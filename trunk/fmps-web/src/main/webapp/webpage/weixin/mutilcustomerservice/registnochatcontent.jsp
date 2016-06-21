<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
  <!--设置为ifram调用方式时，需要加载这个js，如果是href方式就注释掉下面-->
  <t:base type="jquery,easyui,tools"></t:base> 
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <link href="${webRoot}/plug-in/fo/css/wechatclaims.css" rel="stylesheet" type="text/css" />
  <link href="${webRoot}/plug-in/picbox/css/picbox.css" rel="stylesheet"
	type="text/css" />
  <script src="${webRoot}/plug-in/picbox/js/picbox.js" id="picboxId"></script>   
  <script src="${webRoot}/plug-in/common/js/common.js"></script>
  <!-- webRoot 是提供给common.js用的 -->
  <input type="hidden" name="webRoot" id="webRoot" value="${webRoot}" />
   
	  <!-- 缩放比例：长方形132*250 正方形132*80 接近值：132*150-->
		<script type="text/javascript">
		/**
		 * 1）扩展jquery easyui tree的节点检索方法。使用方法如下：
		 * $("#treeId").tree("search", searchText);	 
		 * 其中，treeId为easyui tree的根UL元素的ID，searchText为检索的文本。
		 * 如果searchText为空或""，将恢复展示所有节点为正常状态
		 */
		(function($) {	
			
			$.extend($.fn.tree.methods, {
				/**
				 * 扩展easyui tree的搜索方法
				 * @param tree easyui tree的根DOM节点(UL节点)的jQuery对象
				 * @param searchText 检索的文本
				 * @param this-context easyui tree的tree对象
				 */
				search: function(jqTree, searchText) {
					//easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
					var tree = this;
					
					//获取所有的树节点
					var nodeList = getAllNodes(jqTree, tree);
					
			  		//如果没有搜索条件，则展示所有树节点
					searchText = $.trim(searchText);
			  		if (searchText == "") {
			  			/* for (var i=0; i<nodeList.length; i++) {
			  				$(".tree-node-targeted", nodeList[i].target).removeClass("tree-node-targeted");
			  	  			$(nodeList[i].target).show();
			  	  		}
			  			//展开已选择的节点（如果之前选择了）
			  			var selectedNode = tree.getSelected(jqTree);
			  			if (selectedNode) {
			  				tree.expandTo(jqTree, selectedNode.target);
			  			}
			  			return; */
			  		}
			  		
			  		//搜索匹配的节点并高亮显示
			  		var matchedNodeList = [];
			  		if (nodeList && nodeList.length>0) {
			  			var node = null;
			  			for (var i=0; i<nodeList.length; i++) {
			  				node = nodeList[i];
			  				if (isMatch(searchText, node.text)) {
			  					matchedNodeList.push(node);
			  				}
			  			}
			  			
			  			//隐藏所有节点
			  	  		for (var i=0; i<nodeList.length; i++) {
			  	  			$(".tree-node-targeted", nodeList[i].target).removeClass("tree-node-targeted");
			  	  			$(nodeList[i].target).hide();
			  	  		}  			
			  			
			  			//折叠所有节点
			  	  		tree.collapseAll(jqTree);
			  			
			  			//展示所有匹配的节点以及父节点  			
			  			for (var i=0; i<matchedNodeList.length; i++) {
			  				showMatchedNode(jqTree, tree, matchedNodeList[i]);
			  			}
			  		} 	 
				},
				
				/**
				 * 展示节点的子节点（子节点有可能在搜索的过程中被隐藏了）
				 * @param node easyui tree节点
				 */
				showChildren: function(jqTree, node) {
					//easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
					var tree = this;
					
					//展示子节点
					if (!tree.isLeaf(jqTree, node.target)) {
						var children = tree.getChildren(jqTree, node.target);
						if (children && children.length>0) {
							for (var i=0; i<children.length; i++) {
								if ($(children[i].target).is(":hidden")) {
									$(children[i].target).show();
								}
							}
						}
					}  	
				},
				
				/**
				 * 将滚动条滚动到指定的节点位置，使该节点可见（如果有滚动条才滚动，没有滚动条就不滚动）
				 * @param param {
				 * 	  treeContainer: easyui tree的容器（即存在滚动条的树容器）。如果为null，则取easyui tree的根UL节点的父节点。
				 *    targetNode:  将要滚动到的easyui tree节点。如果targetNode为空，则默认滚动到当前已选中的节点，如果没有选中的节点，则不滚动
				 * } 
				 */
				scrollTo: function(jqTree, param) {
					//easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
					var tree = this;
					
					//如果node为空，则获取当前选中的node
					var targetNode = param && param.targetNode ? param.targetNode : tree.getSelected(jqTree);
					
					if (targetNode != null) {
						//判断节点是否在可视区域				
						var root = tree.getRoot(jqTree);
						var $targetNode = $(targetNode.target);
						var container = param && param.treeContainer ? param.treeContainer : jqTree.parent();
						var containerH = container.height();
						var nodeOffsetHeight = $targetNode.offset().top - container.offset().top;
						if (nodeOffsetHeight > (containerH - 30)) {
							var scrollHeight = container.scrollTop() + nodeOffsetHeight - containerH + 30;
							container.scrollTop(scrollHeight);
						}							
					}
				}
			});
			
			/**
			 * 展示搜索匹配的节点
			 */
			function showMatchedNode(jqTree, tree, node) {
		  		//展示所有父节点
		  		$(node.target).show();
		  		$(".tree-title", node.target).addClass("tree-node-targeted");
		  		var pNode = node;
		  		while ((pNode = tree.getParent(jqTree, pNode.target))) {
		  			$(pNode.target).show();  			
		  		}
		  		//展开到该节点
		  		tree.expandTo(jqTree, node.target);
		  		//如果是非叶子节点，需折叠该节点的所有子节点
		  		if (!tree.isLeaf(jqTree, node.target)) {
		  			tree.collapse(jqTree, node.target);
		  		}
		  	}  	 
			
			/**
			 * 判断searchText是否与targetText匹配
			 * @param searchText 检索的文本
			 * @param targetText 目标文本
			 * @return true-检索的文本与目标文本匹配；否则为false.
			 */
			function isMatch(searchText, targetText) {
		  		return $.trim(targetText)!="" && targetText.indexOf(searchText)!=-1;
		  	}
			
			/**
			 * 获取easyui tree的所有node节点
			 */
			function getAllNodes(jqTree, tree) {
				var allNodeList = jqTree.data("allNodeList");
				if (!allNodeList) {
					var roots = tree.getRoots(jqTree);
		  			allNodeList = getChildNodeList(jqTree, tree, roots);
		  			jqTree.data("allNodeList", allNodeList);
				}
		  		return allNodeList;
		  	}
		  	
			/**
			 * 定义获取easyui tree的子节点的递归算法
			 */
		  	function getChildNodeList(jqTree, tree, nodes) {
		  		var childNodeList = [];
		  		if (nodes && nodes.length>0) {  			
		  			var node = null;
		  			for (var i=0; i<nodes.length; i++) {
		  				node = nodes[i];
		  				childNodeList.push(node);
		  				if (!tree.isLeaf(jqTree, node.target)) {
		  					var children = tree.getChildren(jqTree, node.target);
		  					childNodeList = childNodeList.concat(getChildNodeList(jqTree, tree, children));
		  				}
		  			}
		  		}
		  		return childNodeList;
		  	}
		})(jQuery);

	    //搜索查询话术
	   function searchChange(){
		   var searchName=$("#textName").val();
		   $("#ccc").tree("search", searchName); 
	    	
	    }
	
	    //树形展示   		
		$(function() {
			$('#ccc').tree({
				checkbox : false,
				url : '${webRoot}/wechatClaims/CustomerChat.do?wordTree&registno=${registno}&currOperatorName=${currOperatorName}&currOperatorCode=${currOperatorCode}',
				onLoadSuccess : function(node) {
					
					//默认展示子节点 
						if (node) {
							$('#ccc').tree('expandAll', node.target);
						} else {
							$('#ccc').tree('expandAll');
						}		
					//为每个节点增加desc描述
				$(".tree-node").each(function(i) {
					//这里的this是dom对象,$(this)为jquery对象
					var tn = $('#ccc').tree('getNode', this);
					$(this).attr("title", tn.text);
				});			
				},
				onClick: function(node){
					var nodeT=node.id;
					  $.ajax({
							type: "POST",
							url : "${webRoot}/wechatClaims/CustomerChat.do?serchRoot",
							data:{},
							dataType: "json",
							success: function(data){
								var  idString=data;
								var  str=idString.split(";");
								if(str.indexOf(nodeT)==-1){
									$("#f_sendcontent${registno}").val(node.text);
									
								}
		
							}
					});
				},
				onExpand:function(node){
		
				}
			});	
		});


		//ifram方式调用
		var mainTabs=parent.$('#maintabs');
		var customerServiceImageurl=parent.$("#customerServiceImageUrl").val();

		//href方式调用
		//var mainTabs= $('#maintabs');
		//var customerServiceImageurl=$("#customerServiceImageUrl").val();

		//获取当前tab的标题
		//var currTab = mainTabs.tabs('getSelected'); 
		//var currTabTitle=currTab.panel('options').title;
		
		//页面加载  
		$(function() {  
			setCustomerServiceHeadImage();
			//setChatImage();
			//setQuikeRecive();
			setIntervalStart();
		    goToBottom();
			//发送消息
			$('#sendChat${registno}').click(function () {
            	var chkRes = checkContent();
            	if(chkRes){
	            	sendMsg(); 
            	}
			});
			
		  window.onfocus = function(){
			  parent.is_Blur = false;
				 //alert('wsq onfocus event:'+parent.is_Blur);
				//console.log('fired window blur event');
				// parent.isOnBlur();
			} 
			//关闭会话
			$('#closeChat${registno}').click(function () {
				closeChat();
			});
			
			//消息记录
			$('#historyChat${registno}').click(function () {
				//判断session是否超时或注销 added by guofangfang 20150716
				$.ajax({
					  async: false,	//用同步方式
					  type: 'POST',
					  url: "${webRoot}/loginController.do?checkSession",
					  dataType: "json",
					  success: function(json){
						    if(!json.success){
						    	if(window.parent){
						    		window.parent.close();
						    	}
								toLoginPage();
								return;
							}
						    
						  },
					  error:function (XMLHttpRequest, textStatus, errorThrown) {
						  if(window.parent){
					    		window.parent.close();
					      }
						  toLoginPage();
						  return;
						}
					});
				
				goToHistoryChat();
			});

		}); 
		
		//5秒刷新一次聊天记录 
		function setIntervalStart(){
			setInterval(function() {
				var activedRegistNo=parent.$("#activedRegistNo").val();
				var currentRegistNo  = "${reportInfoMap.registNo}";
				if(activedRegistNo != currentRegistNo ){//激活tab的才自动 刷新新内容
					return;
				}
				getCustomerMsg();
			}, 8000);
		}
		
		//进入网页底部
        function goToBottom(){  
            div=document.getElementById("chatContent${registno}");  
			div.scrollTop = div.scrollHeight;  
        }

		//设置客服头像
		function setCustomerServiceHeadImage(){
			var custSerHeadImage = $("[id=img${registno}]");
			if(customerServiceImageurl==""){
				customerServiceImageurl ="${webRoot}/plug-in/fo/images/customerwechat/kefu.jpg";
			}
			custSerHeadImage.attr("src",customerServiceImageurl);    
		}
		//设置图片缩略
		function setChatImage(){
			$(".p_left_chat_user_background_content_style").autoIMG();
			//$(".p_left_chat_customerservice_background_content_style").autoIMG();
		}
		//快捷回复
		function setQuikeRecive(){
			$('#cc').combo({
				//required:true,
				editable:false
			});
			$('#sp').appendTo($('#cc').combo('panel'));
			$('#sp input').click(function(){
				$('#f_sendcontent${registno}').empty();
				var v = $(this).val();
				var s = $(this).next('span').text();
				$('#cc').combo('setValue', v).combo('setText', s).combo('hidePanel');
				var content = $(this).next('span').attr("title");
				$('#f_sendcontent${registno}').append(content);
			});
		}
		//快捷发送
		function keySend(event) { 
			if (event.ctrlKey && event.keyCode == 13) 
			{ 
            	var chkRes = checkContent();
            	if(chkRes){
	            	sendMsg(); 
            	}
			} 
		}
		//关闭当前激活tab
		function closeCurrentTab(){
			//移除对应案件信息的div
			var registNoDiv = parent.$("#menu_head${registno}");
			registNoDiv.remove();
			
			var tab = mainTabs.tabs('getSelected');
			if (tab){
				var index = mainTabs.tabs('getTabIndex', tab);
				mainTabs.tabs('close', index);
			}
		}
		
		//进入聊天历史记录
		function goToHistoryChat(){
			window.open('${webRoot}/wechatClaims/CustomerChat.do?historyChatIndex&registno=${registno}&openid=${openid}&operatorcode=${operatorCode}&rolecode=${roleCode}');
		}
		//发送验证内容
		function checkContent(){
			 var content=$("#f_sendcontent${registno}").val();  
			 var returnRes = true;
	         if(content=="" || content.length==0 || content ==null){  
	        	$.messager.alert('温馨提示','发送内容不能为空！');
	        	returnRes = false;  
	         } 
	         if(content.length>999){
	        	 $.messager.alert('温馨提示','发送内容长度不能超过1000个字符！');
	        	 returnRes = false;  
	         }
	         return returnRes;
		}
		//提示用户已经关闭
		function getCloseMsg(){
       	 	$.messager.alert('温馨提示','会话已经关闭！');
		}
		
		//用户气泡聊天样式
		function appendLeftContent(content,headimageurl,msgtype,picurl,StreamUrl,createtime,locationx,locationy,imagesNum){
			var contentStyle = "";
			contentStyle = "<div class=\"p_left_chat_user\">"
			+"<div class=\"p_left_chat_user_head\">"
			+"<img src=\""+headimageurl+"\" width=\"40px\" height=\"40px\" class=\"p_left_chat_user_head_img\" >"
			+"</div>"
			
			+"<div class=\"p_left_chat_user_createtime\">"+createtime
			+"</div>"
			
			+"<div class=\"p_left_chat_user_background_triangle\">&nbsp;"
			+"</div>"
			+"<div class=\"p_left_chat_user_background_content\">"
			+"<div class=\"p_left_chat_user_background_content_style\">";
			if(msgtype == "text"){
				contentStyle += content;
			}
			if(msgtype == "image"){
				var num = parseInt(imagesNum);
				if(num>=30){
					contentStyle += "<div  class=\"photos_new\"><a href=\""+StreamUrl+"\" rel=\"lightbox-group\" >"
					+"<img  src=\""+StreamUrl+"\" />"
					+"</a><span style=\"font-weight:bold;color:red\">（提示：当前照片已经超过30张，无法传入b2b系统。）</span></div>";
				}else if(num>=25){
					contentStyle += "<div  class=\"photos_new\"><a href=\""+StreamUrl+"\" rel=\"lightbox-group\" >"
					+"<img  src=\""+StreamUrl+"\" />"
					+"</a><span style=\"font-weight:bold;color:red\">（提示：该用户还能上传"+(30-parseInt(imagesNum))+"张照片）</span></div>";
				}else{
					contentStyle += "<div  class=\"photos_new\"><a href=\""+StreamUrl+"\" rel=\"lightbox-group\" >"
					+"<img  src=\""+StreamUrl+"\" />"
					+"</a></div>";
				}
			}
			if(msgtype == "voice"){
					contentStyle += "<embed src='" + StreamUrl + "' width='200' height='18' autoplay='false' controller='true' type='video/quicktime'></embed>";				
					if(content!=null&&content!=""){
						contentStyle += "<span>('"+content+"')</span>";
					}
			}
			 if(msgtype == "location"){
				 alert();
					var center="center="+locationy+","+locationx+"";
					//childdiv1 +="<a href='http://api.map.baidu.com/staticimage?"+center+"&width=800&height=620&zoom=15&scale=2&markers="+locationy+","+locationx+"&markerStyles=l,A,0xff0000'><img style='margin:20px' width='240' height='100' src='http://api.map.baidu.com/staticimage?"+center+"&width=280&height=140&zoom=15&scale=2&markers="+locationy+","+locationx+"&markerStyles=l,A,0xff0000' /></a> ";
					contentStyle +="<div  class=\"photos_new\"><a rel=\"lightbox-group\" href='http://st.map.qq.com/api?size=1004*800&"+center+"&zoom=15&markers="+locationy+","+locationx+"'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&"+center+"&markers="+locationy+","+locationx+"&zoom=15' /></a></div> ";
		
			
		    } 
			contentStyle +="</div>"
			+"</div>"
			+"</div>"
			+"<div class=\"p_clear_both\">&nbsp;</div>";
	        return contentStyle;
		}
		
		//客服气泡聊天样式
		function appendRightContent(content,msgtype,filepath,createtime){
			var contentStyle = "";
			contentStyle="<div class=\"p_left_chat_customerservice\">"
				+"<div class=\"p_left_chat_customerservice_head\">"
				+"<img id=\"img${registno}\" src=\""+customerServiceImageurl+"\" width=\"40px\" height=\"40px\" class=\"p_left_chat_customerservice_head_img\">"
				+"</div>"
				
				+"<div class=\"p_left_chat_customerservice_createtime\">"+createtime
				+"</div>"
				
				+"<div class=\"p_left_chat_customerservice_background_triangle\">&nbsp;"
				+"</div>"
				+"<div class=\"p_left_chat_customerservice_background_content\">"
				+"<div class=\"p_left_chat_customerservice_background_content_style\">";
				if(msgtype == "001"){
					contentStyle += content;
				}
				if(msgtype == "002"){
					contentStyle += "<a href=\""+filepath+"\" target=\"_blank\">"
					+"<img  src=\""+filepath+"\" alt=\"\"/>"
					+"</a>";
				}
				contentStyle +="</div>"
				+"</div>"
				+"</div>"
				+"<div class=\"p_clear_both\">&nbsp;</div>";
	        return contentStyle;
		}
		
		/**********************后台交互***********************/
		//读取客户聊天记录ajax
		function getCustomerMsg(){
		  var tcontent="";
		  var url="${webRoot}/wechatClaims/CustomerChat.do?getCustomerMessage"
	    		  +"&registno=${registno}";	  
	      $.ajax({
			  type : 'POST',
			  url : url,
			  dataType : "json",
	          success: function (json) {
	        		if (json.success) { 
						var jsonnotreadedlist =json.attributes.customerChatNotReadedList;
						$.each(jsonnotreadedlist, function (i, n) { // i表示索引值；n表示一条记录对象
								var content = n.content;
								var headimgurl = "${reportInfoMap.headimgurl}";
								var msgtype = n.msgtype;
								var picurl  = n.picurl;
								var location_x  = n.location_x;
								var location_y  = n.location_y;
							
								var createtime = new Date(n.createtime);
								createtime = (createtime.getHours()<10 ? "0"+createtime.getHours() : createtime.getHours())+":"
								+(createtime.getMinutes()<10 ? "0"+createtime.getMinutes() : createtime.getMinutes())+":"
								+(createtime.getSeconds()<10 ? "0"+createtime.getSeconds() : createtime.getSeconds());
								
								var StreamUrl = "${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=" + n.mediaid;
								tcontent += appendLeftContent(content,headimgurl,msgtype,picurl,StreamUrl,createtime,location_x,location_y,n.imagesNum);
								//最小化时有新信息弹出提示
								//parent.intervalMinStatusClick("有最新消息！请及时处理！");
								//转移焦点时有新信息弹出提示
								//parent.intervalOnblur("有最新信息！请及时处理！");
						});
						$("#chatContent${registno}").append(tcontent);
						
						//setChatImage();
						goToBottom();
						
						//重新加载 picbox.js   初始化图片
						$("#picboxId").remove();
						var picboxjs ="<script id=\"picboxId\" src='${webRoot}/plug-in/picbox/js/picbox.js'></sc"+"ript>";
						$("head").append(picboxjs);
	        		}
	          },
	          error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	  //避免在右边窗口打开登录页,需要关闭父窗口 added by guo 20150716
	        	  if(window.parent){
			      		window.parent.close();
			      }
	        	  toLoginPage();
	          }
	      });
		}
		
		//发送消息ajax
		function sendMsg(){
			  var sendContent=$("#f_sendcontent${registno}").val();
			  var encodeSendContent=escape(encodeURIComponent(sendContent)); //转码
		      var url="${webRoot}/wechatClaims/CustomerChat.do?sendMessage"
		    		  +"&operatorcode=${operatorCode}&openid=${openid}&registno=${registno}"
		    		  +"&msgtype=001&content="+encodeSendContent;
		      //var chatContent = $("#chatContent${registno}").html();//获取div内容	
		      $.ajax({
				  type : 'POST',
				  url : url,
				  dataType : "json",
		          success: function (json) {
					if (json.success) { 
						var msgtype = "001";//001 文本 002 图像
						var filepath = "";//本地图像
						
						var createtime = new Date();
						createtime = (createtime.getHours()<10 ? "0"+createtime.getHours() : createtime.getHours())+":"
						+(createtime.getMinutes()<10 ? "0"+createtime.getMinutes() : createtime.getMinutes())+":"
						+(createtime.getSeconds()<10 ? "0"+createtime.getSeconds() : createtime.getSeconds());
						
						var tcontent = appendRightContent(sendContent,msgtype,filepath,createtime);
						$("#chatContent${registno}").append(tcontent);
						$("#f_sendcontent${registno}").val("");  
						
						//setChatImage();
						goToBottom();
					}else {
						$.messager.alert('温馨提示',json.msg);
					}
		          },
		          error: function () {
		        	  //$.messager.alert('温馨提示','请求失败！');
		        	  //避免在session失效时右边窗口打开登录页 added by guo 20150716
		        	  if(window.parent){
		        		  window.parent.close();
		        	  }
		        	  toLoginPage();
		          }
		      });
		}
		
		//关闭会话ajax
		function closeChat(){
			$.messager.confirm('温馨提示', '确定要关闭此次会话?<br/><font color=\"red\">注意，此动作将关闭和微信端用户的对话</font>', function(res){
				if (res){
					//后台操作
					var url="${webRoot}/wechatClaims/CustomerChat.do?closeCustomerChat&openid=${openid}&registno=${registno}";
				      $.ajax({
						  type : 'POST',
						  url : url,
						  dataType : "json",
				          success: function (json) {
							if (json.success) { 
								closeCurrentTab();
							}else {
								$.messager.alert('温馨提示',json.msg);
							}
				          },
				          error: function () {
				        	  //$.messager.alert('温馨提示','请求失败！');
				        	  if(window.parent){
				        		  window.parent.close();
				        	  }
				        	  toLoginPage();
				          }
				      });
					

				}
			});
		}
		
	</script>
    	<%--即时窗口 --%>
		<div class="easyui-panel" title="聊天窗口" fit="true" class="p_panel">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" >
					<div class="easyui-layout" fit="true">
						<!-- 右侧信息 -->
						<div   region="east" class="p_right"  split="true" border="false" style="width:300px;">
						<!-- <div id="tt" class="easyui-tabs" style="width:250px;height:850px;"> -->
						<div id="tt" class="easyui-tabs" style="width:850px;height:1050px;">
						    <div title="保单信息" style="padding:20px;">
						        <div class="p_right_registno"> 
									<span class="p_right_registno_content">报案人：</span><br/>
									${reportInfoMap.reportorName}<br/>
							     	<span class="p_right_registno_content">报案时间：</span><br/>
							     	${reportInfoMap.reportDate} ${reportInfoMap.reportTime}<br/>
							     	<span class="p_right_registno_content">报案电话：</span><br/>
							     	${reportInfoMap.phoneNumber}<br/>
							     	<span class="p_right_registno_content">报案号：</span><br/>
							     	${reportInfoMap.registNo}<br/>
							     	<span class="p_right_registno_content">事故经过：</span><br/>
							     	${reportInfoMap.remark}<br/>
							     	<span class="p_right_registno_content">险别信息：</span><br/>
							     	${reportInfoMap.kindName}<br/>
							     	<span class="p_right_registno_content">车辆信息：</span><br/>
							     	${reportInfoMap.carModel}<br/>
							        <span class="p_right_registno_content" >案件处理人：</span><br/>
										${reportInfoMap.currOperatorCode}(${reportInfoMap.currOperatorName})
									<br/>
									<span style="color: red">*注意：案件超过30分钟未进行任何操作，将自动关闭对话。</span>
						        </div> 
						    </div>
						   <!--  <div title="常用话术" style="padding:5px; width: 148px; height: 710px;">	 -->
						     <div title="常用话术" style="">		    
						       <span> 关键字：<input type="text" id="textName" style="width: 150px;"/> <button onclick="searchChange();">查询</button></span>
						        <div>&nbsp;</div>
						        <ul id="ccc" hint></ul>
						    </div>
					    </div>				    
						</div>
						<!-- 左侧信息 -->
						<div region="center" border="false" class="p_left">
							<div class="easyui-layout" fit="true">
								<!-- 发送窗口 -->
								<div region="south" split="true" border="false" class="p_left_send">
									<!-- 上传按钮
									<div class="p_left_send_upload">
									 	<a href="#" class="p_left_send_upload_a">
									 	<img alt="" src="${webRoot}/plug-in/fo/images/customerwechat/shangchuang_icon.jpg" class="p_left_send_upload_img">
									 	</a>
									</div>-->

									
									<textarea id="f_sendcontent${registno}" class="p_left_send_textarea" onkeydown="keySend(event);" ></textarea>
							
									<div class="p_left_send_button">
									<%-- 快捷回复 
										<select id="cc" style="width:70px"></select>
										<div id="sp">
										
												<div style="color:#99BBE8;background:#fafafa;padding:5px;">快捷回复</div>
												<div style="padding:5px">
													<input type="radio" name="lang" value="01"><span title="你好，我是理赔客服，请问有什么可以帮助你?">问候</span>
													<br/>
													<input type="radio" name="lang" value="02"><span title="你好，理赔已经处理完毕，请等候电话通知!">再见</span>
													<br/>
													<input type="radio" name="lang" value="03"><span title="你好，客服现在正忙，请留言!">忙碌</span>
												</div>
										</div>--%>
										按CTRL+回车，直接发送
										<a href="javascript:void(0)" class="easyui-linkbutton" id="historyChat${registno}">消息记录</a>
										<c:if test="${reportInfoMap.sessionState == 0  }"><!-- 会话关闭 -->
											<a href="javascript:void(0)" data-options="disabled:false" onclick="getCloseMsg()" class="easyui-linkbutton" >结束会话</a>
											<a href="javascript:void(0)" data-options="disabled:false" onclick="getCloseMsg()" class="easyui-linkbutton" >发送</a>
										</c:if>
										<c:if test="${reportInfoMap.sessionState == 1  }">
											<a href="javascript:void(0)" class="easyui-linkbutton" id="closeChat${registno}">结束会话</a>
											<a href="javascript:void(0)" class="easyui-linkbutton" id="sendChat${registno}">发送</a>											
										</c:if>
									</div>
									
								</div>
								
								
								<!-- 对话窗口 -->
								<div region="center" border="false" id="chatContent${registno}" >
									<div class="p_clear_both_top">&nbsp;</div>
									<c:forEach items="${customerChatReadedList}" var="customerChatReaded" varStatus="status">
									<!-- 客户 -->
									<c:if test="${customerChatReaded.message_source == 1  }">
										<div class="p_left_chat_user">
											<div class="p_left_chat_user_head">
												<img src="${reportInfoMap.headimgurl}" width="40px" height="40px" class="p_left_chat_user_head_img" >
											</div>
											<div class="p_left_chat_user_createtime">
												<fmt:formatDate value="${customerChatReaded.createtime}" pattern="HH:mm:ss"/>
											</div>
											
	                                        <div class="p_left_chat_user_background_triangle" >&nbsp;
											</div>
	                                       <div class="p_left_chat_user_background_content">
	                                        <div class="p_left_chat_user_background_content_style" >
	                                        	<c:if test="${customerChatReaded.receiveMessage.msgType == 'text'  }">
	                                        		${customerChatReaded.receiveMessage.content}
	                                        	</c:if>
											 	
											 	<c:if test="${customerChatReaded.receiveMessage.msgType == 'image'  }">
											 		 <div  class="photos_record">
											 		 	<a href="${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=${customerChatReaded.receiveMessage.mediaId }" rel="lightbox-group" >
												        	<img   src="${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=${customerChatReaded.receiveMessage.mediaId }" alt="" >
												        </a>
												     </div>
												</c:if>
												
											 	<c:if test="${customerChatReaded.receiveMessage.msgType == 'voice'  }">
											 		<embed src='${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=${customerChatReaded.receiveMessage.mediaId }' width='200' height='18' autoplay='false' controller="true" type="video/quicktime" ></embed>
											 		<c:if test="${(customerChatReaded.receiveMessage.content != null)&&(customerChatReaded.receiveMessage.content!='') }">
											 	       <span>(${customerChatReaded.receiveMessage.content })</span>
											 	    </c:if>

												</c:if>
												<c:if test="${customerChatReaded.receiveMessage.msgType == 'location'  }">			                      
											   <div  class="photos_record">
									            <a  rel="lightbox-group" href='http://st.map.qq.com/api?size=1004*800&${customerChatReaded.receiveMessage.location_Y},${customerChatReaded.receiveMessage.location_X}&zoom=15&markers=${customerChatReaded.receiveMessage.location_Y},${customerChatReaded.receiveMessage.location_X}'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&${customerChatReaded.receiveMessage.location_Y},${customerChatReaded.receiveMessage.location_X}&markers=${customerChatReaded.receiveMessage.location_Y},${customerChatReaded.receiveMessage.location_X}&zoom=15' /></a>  
												</div>
                                                    
												</c:if> 
												
												
												
												
											</div>
	                                       </div>
	                                    </div>
	                                    <div class="p_clear_both">&nbsp;</div>
									</c:if>
									<!-- 客服 -->
									<c:if test="${customerChatReaded.message_source == 0  }">
										<div class="p_left_chat_customerservice">
                                        	<div class="p_left_chat_customerservice_head">
                                        		<img id="img${registno}" src="${webRoot}/plug-in/fo/images/customerwechat/kefu.jpg" width="40px" height="40px" class="p_left_chat_customerservice_head_img">
	                                        </div>
											<div class="p_left_chat_customerservice_createtime">
												<fmt:formatDate value="${customerChatReaded.createtime}" pattern="HH:mm:ss"/>
											</div>
	                                        
	                                        <div class="p_left_chat_customerservice_background_triangle">&nbsp;
											</div>                                        
											<div class="p_left_chat_customerservice_background_content">
	                                            <div class="p_left_chat_customerservice_background_content_style">
													<c:if test="${customerChatReaded.customerServiceChatInfo.msgtype == '001'  }">
		                                        		${customerChatReaded.customerServiceChatInfo.content}
		                                        	</c:if>
												 	
												 	<c:if test="${customerChatReaded.customerServiceChatInfo.msgtype == '002'  }">
													 	<a href="${customerChatReaded.customerServiceChatInfo.filepath}" target="_blank">
													 		<img  src="${customerChatReaded.customerServiceChatInfo.filepath}" alt=""/>
													 	</a>
													</c:if>
												</div>
                                        	</div>
                                        </div>
                                        <div class="p_clear_both">&nbsp;</div>
									</c:if>
									
									</c:forEach>

									<div style="text-align: center">
										<c:if test="${not empty userlasttime}">
										---------------------------${userlasttime}---------------------------
										</c:if>
									</div>
									<%-- 
									<c:forEach items="${customerChatNotReadedList}" var="customerChatNotReaded" varStatus="status">
									<!-- 客户 -->
									<c:if test="${customerChatNotReaded.message_source == 1  }">
										<div class="p_left_chat_user">
											<div class="p_left_chat_user_head">
												<img src="${reportInfoMap.headimgurl}" width="40px" height="40px" class="p_left_chat_user_head_img" >
											</div>
	                                        <div class="p_left_chat_user_background_triangle">&nbsp;
											</div>
	                                       <div class="p_left_chat_user_background_content">
	                                        <div class="p_left_chat_user_background_content_style">
											 	<c:if test="${customerChatNotReaded.receiveMessage.msgType == 'text'  }">
	                                        		${customerChatNotReaded.receiveMessage.content}
	                                        	</c:if>
											 	<c:if test="${customerChatNotReaded.receiveMessage.msgType == 'image'  }">			 	
											 		<a href="#" onclick="$('#w').window('open');$('#img').attr('src','${customerChatNotReaded.receiveMessage.picUrl}')">
											 			<img  src="${customerChatNotReaded.receiveMessage.picUrl}" alt=""/>
											 		</a>
												</c:if>
											</div>
	                                       </div>
	                                    </div>
	                                    <div class="p_clear_both">&nbsp;</div>
	                                 </c:if>
	                                </c:forEach>
	                                --%>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>  
