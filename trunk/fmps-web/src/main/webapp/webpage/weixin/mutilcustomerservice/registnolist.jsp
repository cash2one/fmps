<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<link href="${webRoot}/plug-in/fo/css/wechatclaims.css" rel="stylesheet" type="text/css" />
<script src="${webRoot}/plug-in/common/js/common.js"></script>
<!-- webRoot 是提供给common.js用的 -->
<input type="hidden" name="webRoot" id="webRoot" value="${webRoot}" />

<script type="text/javascript">
  var  localRegistArr = new Array();//本地案件信息
  var  localRegistArrTemp = new Array();//临时变量
  var  localNotReadCount =	parseInt("${notReadCount}");//未读消息总数
  //页面加载完毕事件
  $(function () {
	  InitRegistList();
	  setIntervalStart();
	  //绑定菜单点击事件
	  $("#firstpane div.menu_head").live("click",function(){
		$(this).addClass("current");
		$(this).siblings().removeClass("current");
	  });
  });
  
  //8秒刷新一次 
  function setIntervalStart(){
	 setInterval(function() {
		 IntervalRegistList(); 
	 }, 60000);//60000
  }
  //使用ifram方式加载
  function createFrame(url){
  	var ieiframe = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:99.8%;height:99.8%;"></iframe>';
  	return ieiframe;
  }
  //设置首页未读消息和待处理案件数
  function setRegistNoCountAndNotReadCount(){
	  var registNoCount = localRegistArr.length;
	  var notReadMsgCount = localNotReadCount;
	  $("#main_right_registnocount_content").text("当前未处理的案件数量为"+registNoCount+"个");
	  $("#main_right_totalNotReadedMessageCount_content").text("当前未读信息数量为"+notReadMsgCount+"条");
  }
  //打开案件聊天窗口
  function openTab(s_title,registno,openid,operatorcode,rolecode){
	  	//判断session是否超时或注销 added by guofangfang 20150715
		$.ajax({
			  async: false,	//用同步方式
			  type: 'POST',
			  url: "${webRoot}/loginController.do?checkSession",
			  dataType: "json",
			  success: function(json){
				    if(!json.success){
				    	toLoginPage();
						return;
				    }
				  },
			  error:function (XMLHttpRequest, textStatus, errorThrown) {
				    toLoginPage();
					return;
				}
			});
	  
	  
	  
	    //设置未读信息0
	    $("#menu_head_count_msg"+registno).html(" <div class=\"menu_head_content_msg_count2\">0</div>");
		var progress = $("div.messager-progress");
		if(progress.length){return;}
		$.messager.progress({
			text : '页面加载中....',
			interval : 200
		});
		if (!$('#maintabs').tabs('exists', s_title)) {
			var s_url = "${webRoot}/wechatClaims/CustomerChat.do?instantChatIndex&registno="+registno+"&openid="+openid+"&operatorCode="+operatorcode+"&roleCode="+rolecode;
			var s_icon = "icon-tip";
			
			$('#maintabs').tabs('add', {
				title : s_title,
				//href : s_url,//href方式添加tab
				content:createFrame(s_url),//ifram方式添加tab
				closable : true,
				icon : s_icon,
				selected: true
			});
			$("#activedRegistNo").val(s_title);//设置主页的隐藏域当前激活的案件
		}else {
			$('#maintabs').tabs('select', s_title);
			$.messager.progress('close');
		}
  }
  //添加单个案件
  function addRegistNo(obj,flag){
	  var licenseTotal = obj.licenseTotal;
	  var messageTotal = obj.messageTotal;
	  var openidTotal = obj.openidTotal;
	  var reportorName = obj.reportorName;
	  if(reportorName.length >7){
		  reportorName=reportorName.substring(0,6)+"...";
	  }
 	 var childdiv = "";
 		childdiv += "<input type=\"hidden\" id=\"openid"+obj.registNo+"\" value=\""+obj.openid+"\">"
 			+"<input type=\"hidden\" id=\"title"+obj.registNo+"\" value=\""+obj.licenseNo+"\">"
 			+"<input type=\"hidden\" id=\"registno"+obj.registNo+"\" value=\""+obj.registNo+"\">"
 			+"<input type=\"hidden\" id=\"operatorcode"+obj.registNo+"\" value=\""+obj.operatorCode+"\">"
 			+"<input type=\"hidden\" id=\"rolecode"+obj.registNo+"\" value=\"${roleCode}\">"
 			+"<div class=\"menu_head\" name=\""+obj.registNo+"\" id=\"menu_head"+obj.registNo+"\">"
 			+"<div class=\"menu_head_onclick\" id=\""+obj.registNo+"\" onclick=\"openTab(\'"+obj.registNo+"\',\'"+obj.registNo
 				+"\',\'"+ obj.openid +"\',\'${operatorCode}\',\'${roleCode}\');\">"
 			+"<div class='menu_head_content'>"
 			+"<div class='menu_head_content_img'>"
 			+"<img src=\""+obj.headimgurl+"\" width='50px' height='50px' style=\"padding-top:10px;\"/>"
 			+"</div>"
 			+"<div class='menu_head_content_name'>"
 			+ reportorName;
 			if(licenseTotal >= 3){
 				childdiv += "<div style=\"color:red\">";
 			}else{
 				childdiv += "<div>";
 			}
 			childdiv += "(车牌号数量："+licenseTotal+")"
 			+"</div>";
 			if(openidTotal >= 2){
 				childdiv += "<div style=\"color:red\">";
 			}else{
 				childdiv += "<div>";
 			}
 			childdiv += "(微信号数量："+openidTotal+")"
 		    +"</div>"
 		   +"</div>"
 		    +"<div class=\"menu_head_content_msg\" id=\"menu_head_count_msg"+obj.registNo+"\">";
 		   if(flag=='Y'){
 			  childdiv += "<div > <img src=\"${webRoot}/plug-in/weixin/image/new.gif\"  alt=\"新\" /> </div>"; 			   
 		   }else{
 		    if(messageTotal>0){
 		    	childdiv += "<div class=\"menu_head_content_msg_count1\">"
		 		   	    +messageTotal
		 	 		    +"</div>";
 		    }else{
 		    	childdiv += "<div class=\"menu_head_content_msg_count2\">"
	 		   	    +messageTotal
	 	 		    +"</div>";
 		    }
 		   }
 		   childdiv +="</div>"
 			+"</div>"
 			+"<div class='menu_head_content'>"
 			+"<div class='menu_head_content_lisens'>"
 			+ obj.licenseNo
 			+"</div>"
 			+"<div class=\"menu_head_content_registno\">"
 			+"<input type=\"text\" id=\"focus"+obj.registNo+"\" name=\"menu_head_input\" value=\""+obj.registNo+"\" >"
 			+"</div>"
 			+"</div>"
 			+"</div>"
 			+"</div>";
 	return childdiv;
  }
  //清空案件列表
  function clearRegistList(msg){
		//清空本地案件变量
		localRegistArr = new Array();
		localRegistArrTemp = new Array();
		$("#firstpane").empty();
		$("#firstpane").append(msg);
		//按钮供客服刷新理赔案件列表
		var btn = "<div><input type='button' value='刷新理赔案件' onclick='IntervalRegistList();' /></div>";
		$("#firstpane").append(btn);
  }
  
  //加载案件列表
  function InitRegistList(){
      var tbody = "";
      var url="${webRoot}/wechatClaims/CustomerChat.do?registNoList&operatorCode=${operatorCode}&roleCode=${roleCode}";
      $.ajax({
		  type : 'POST',
		  url : url,
		  dataType : "json",
          success: function (json) {
			if (json.success) { 
				$("#firstpane").empty();
				var jsonregistnolist =json.attributes.registNoList;
				$.each(jsonregistnolist, function (i, n) {
						var obj = n;
						addRegistNo(obj,'N');
						var childdiv = addRegistNo(obj,'N');
						tbody += childdiv;
						//首次加载案件信息存入本地数组
						var localRegistNoObj = new Object();
						localRegistNoObj.registNo = obj.registNo;
						localRegistArr.push(localRegistNoObj);
						localRegistArrTemp.push(localRegistNoObj);
				});
				$("#firstpane").append(tbody);
			} else {
				clearRegistList(json.msg);
			}
          },
          error: function (XMLHttpRequest, textStatus, errorThrown) {
        	  toLoginPage();
        	  //clearRegistList('获取案件列表失败，服务器访问异常。');
          }
      });
   }
  
//定时刷新案件列表
  function IntervalRegistList(){
      var url="${webRoot}/wechatClaims/CustomerChat.do?registNoList&operatorCode=${operatorCode}&roleCode=${roleCode}";
      $.ajax({
		  type : 'POST',
		  url : url,
		  dataType : "json",
          success: function (json) {
			if (json.success) { 
				var jsonregistnolist =json.attributes.registNoList;
				localNotReadCount = json.attributes.totalNotReadedMessageCount;
				//1.更新案件未读消息,添加新案件
				$.each(jsonregistnolist, function (i, n) {
						var obj = n;
						var jsonregistno1 = obj.registNo;
						if(typeof(jsonregistno1) == "undefined"){
							return true;//类似continue
						}
						var localRegistObjTemp1;
						var chkAdd=false;
						for (localRegistObjTemp1 in localRegistArrTemp)
						{
							var localRegistNo1 = localRegistArrTemp[localRegistObjTemp1].registNo;
							//服务端案件比对本地案件，本地没有的为新增案件
							if(jsonregistno1 == localRegistNo1){
								var currMessageTotal = $("#menu_head_count_msg"+localRegistNo1).text();	
								currMessageTotal = currMessageTotal.replace(/[ ]/g,"") ; //如果是新案件 替换后 就 未 "" 字符串 
								var mesageTotal = obj.messageTotal;
								//当未读消息不一致，更新对应案件的未读信息
								if(currMessageTotal != mesageTotal&&currMessageTotal!=""){									
									var noRededMsgCountDiv = $("#menu_head_count_msg"+localRegistNo1);
									noRededMsgCountDiv.empty();
									
									//当前激活不更新消息状态
									var activedRegistNo=parent.$("#activedRegistNo").val();
									if(activedRegistNo == localRegistNo1 ){
										mesageTotal=0;
									}
									if(mesageTotal == 0){
									   noRededMsgCountDiv.append("<div class=\"menu_head_content_msg_count2\">"+mesageTotal+"</div>");
									}else{
										noRededMsgCountDiv.append("<div class=\"menu_head_content_msg_count1\">"+mesageTotal+"</div>");
									}
									//最小化时有新信息弹出提示
									//intervalMinStatusClick("有最新消息！请及时处理！");
									//转移焦点时有新信息弹出提示
									//intervalOnblur("有最新消息！请及时处理！");
								}
								chkAdd=true;
							}
						}
						//div添加增加的案件
						if(!chkAdd){
							//本地案件为空，则先清空案件列表内容
							if(localRegistArr=="" || typeof(localRegistArr) == "undefined"){
								$("#firstpane").empty();
							}
							var childdiv = addRegistNo(obj,'Y');							
							$("#firstpane").append(childdiv);
							parent.intervalOnblur('您有新的微信闪赔案件');
							//添加registno到本地array
							var localRegistObjTemp1_1 = new Object();
							localRegistObjTemp1_1.registNo = jsonregistno1;
							localRegistArr.push(localRegistObjTemp1_1);
							//最小化时有新案件弹出提示
							//intervalMinStatusClick("有最新案件！请及时处理！");
							//转移焦点时有新案件弹出提示
							//intervalOnblur("有最新案件！请及时处理！");
						}
						
				});

				//2.删除关闭会话案件
				var localRegistObjTemp2;
				for (localRegistObjTemp2 in localRegistArrTemp)
				{
					var localRegistNo2 = localRegistArrTemp[localRegistObjTemp2].registNo;
					var chkDel=false;
					
					$.each(jsonregistnolist, function (i, n) {
						var obj = n;
						var jsonregistno2 = obj.registNo;
						if(typeof(jsonregistno2) == "undefined"){
							return true;//类似continue
						}
						//本地案件比对服务端案件，服务端没有的为删除案件
						if(jsonregistno2 == localRegistNo2){
							chkDel=true;
						}
						
					});
					if(!chkDel){
						//移除对应案件信息的div
						var registNoDiv = $("#menu_head"+localRegistNo2);
						registNoDiv.remove();
						//关闭对应案件对话窗口
						$("#maintabs").tabs('close',localRegistNo2);
						//获取此元素的下标
						var i=0;
						var j;
						var localRegistObjTemp2_1;
						for (localRegistObjTemp2_1 in localRegistArr)
						{
							var localRegistNo2_1 = localRegistArr[localRegistObjTemp2_1].registNo;
							if(localRegistNo2 == localRegistNo2_1){
								j = i;
							}
							i++;
						}
						if(j != ""){
							localRegistArr.splice(j, 1);;//删除指定下标的元素
						}
					}

				}
				
				//3.更新本地案件信息临时变量
				localRegistArrTemp = new Array();//清掉临时变量数据
				var localRegistObjTemp3;
				for (localRegistObjTemp3 in localRegistArr)
				{
					var localRegistNo3 = localRegistArr[localRegistObjTemp3].registNo;
					var localRegistObjTemp3_1 = new Object();
					localRegistObjTemp3_1.registNo = localRegistNo3;
					localRegistArrTemp.push(localRegistObjTemp3_1);
				}
			} else {
				clearRegistList(json.msg);
			}
			//设置首页未读消息
			setRegistNoCountAndNotReadCount();
          },
          error: function (XMLHttpRequest, textStatus, errorThrown) {
        	  toLoginPage();
        	  //clearRegistList(textStatus);
          }
      });
   }

</script>

<!-- 案件列表 -->
 <div id="firstpane" class="menu_list">
 
 <%--     
 <!-- 主页快捷接入用 -->
 <input type="hidden" id="openid62220202121212" value="xxxxxx"> 
 <input type="hidden" id="title62220202121212" value="xxxx"> 
 <input type="hidden" id="registno62220202121212" value="xxxx"> 
 <input type="hidden" id="operatorcode62220202121212" value="xxx"> 
 <input type="hidden" id="rolecode62220202121212" value="${roleCode}">
 	<!-- 第一个报案人 -->
 	 
 	 <div class="menu_head" name="闽地DD" id="menu_head62220202121212">
 	 	<div class="menu_head_onclick" onclick="openTab('测试客户1');">
			<div class="menu_head_content">
				<div class="menu_head_content_img">
					<img src="${headimgurl}"  width="50px" height="50px" style="padding-top:10px;"/>	
				</div>
				<div class="menu_head_content_name">
					客户客客户客...<br/>
					<div style="color:red">(车牌号数量：30)
					</div>
					<div style="color:red">(微信号数量：30)
					</div>
				</div>
				<div class="menu_head_content_msg" id="menu_head_count_msg62220202121213234324325">
					 <div class="menu_head_content_msg_count1">
					 	11
					 </div>
					 <!-- 
					 <div class="menu_head_content_msg_count2">
					 	11
					 </div>-->
				</div>
			</div>
			<div class="menu_head_content">
				<div class="menu_head_content_lisens">
					闽D31614
				</div>
				<div class="menu_head_content_registno" >
					62220202121213234324325
				</div>
			</div>
		</div>
   </div>

 <input type="hidden" id="openid62220202121213" value="xxxxxx"> 
 <input type="hidden" id="title62220202121213" value="xxxx"> 
 <input type="hidden" id="registno62220202121213" value="xxxx"> 
 <input type="hidden" id="operatorcode62220202121213" value="xxx"> 
  <input type="hidden" id="rolecode62220202121213" value="${roleCode}">
     <!-- 第2个报案人 -->
  	 <div class="menu_head" name="闽地DD2" id="menu_head62220202121213">
  	 	<div onclick="openTab('测试客户2');">
			<div class="menu_head_content">
				<div class="menu_head_content_img">
					<img src="${headimgurl}"  width="50px" height="50px" style="padding-top:10px;"/>	
				</div>
				<div class="menu_head_content_name">
					客户2...
					<div >
					(车牌号数量：2)
					</div>
					<div>(微信号数量：2)</div>
				</div>
				<div class="menu_head_content_msg" id="menu_head_count_msg62220202121213">
					 <div class="menu_head_content_msg_count1">
					 	11
					 </div>
					 <!-- 
					 <div class="menu_head_content_msg_count2" >
					 	11
					 </div>-->
				</div>
			</div>
			
			<div class="menu_head_content">
				<div class="menu_head_content_lisens">
					闽D31615
				</div>
				<div class="menu_head_content_registno" >
					62220202121213234324324
				</div>
			</div>
		</div>
   </div>
 --%>
 </div>
