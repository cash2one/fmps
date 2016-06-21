<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>聊天历史记录窗口</title>
<t:base type="jquery,easyui,tools"></t:base>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link href="${webRoot}/plug-in/fo/css/wechatclaims.css" rel="stylesheet"
	type="text/css" />
<link href="${webRoot}/plug-in/picbox/css/picbox.css" rel="stylesheet"
	type="text/css" />
<script src="${webRoot}/plug-in/picbox/js/picbox.js" id="picboxId"></script>
<script src="${webRoot}/plug-in/common/js/common.js"></script>  
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
<!-- webRoot 是提供给common.js用的 -->
<input type="hidden" name="webRoot" id="webRoot" value="${webRoot}" />

<script type="text/javascript">
	//加载事件
	$(function () {
		  setCustomerServiceHeadImage();
		 ///setChatImage();
		  goToBottom();
		  PageInit(0);
		  $("#firstpane div.menu_head").live("click",function(){//绑定菜单点击事件（动态加载）
			$(this).addClass("current");
			$(this).siblings().removeClass("current");
		  });
		  //查询条件
		  $('#h_search').click(function () {
			  PageInit(1);
	      });
	});
	//设置客服头像
	function setCustomerServiceHeadImage(){
		var custSerHeadImage = $("[id=img${registno}]");
		var custSerImageUrl = "${userImageUrl}";
		if(custSerImageUrl==""){
			custSerImageUrl ="${webRoot}/plug-in/fo/images/customerwechat/kefu.jpg";
		}
		custSerHeadImage.attr("src",custSerImageUrl);    
	}
	//设置图片缩略
	function setChatImage(){
		$(".p_left_chat_user_background_content_style").autoIMG();
	}
	
	//进入网页底部
    function goToBottom(){  
        div=document.getElementById("chatContent");  
		div.scrollTop = div.scrollHeight;  
    }
	
	//分页页面
	function PageInit(currentNumber){
		showRegistNoList(currentNumber);
	}
	
	//显示聊天内容和案件信息
    function showChat(registno){
    	//getMap("","");
    	  var strString=""; 
		  var contentTbody = "";
		  var registTbody = "";
	      var url="${webRoot}/wechatClaims/CustomerChat.do?historyChatInfoList&registno="+registno;
		  $("#chatContent").empty();
		  $("#right_registno").empty(); 
	      $.ajax({
			  type : 'POST',
			  url : url,
			  dataType : "json",
	          success: function (jsonString) {	        	
	        	var json= eval('(' + jsonString + ')');  
				if (json.success) { 
					//聊天内容
					var jsonchatlist =json.attributes.customerChatList;
					var jsonuserlasttime = json.attributes.userlasttime;
					var jsonimgurl = json.attributes.headimgurl;
					contentTbody += "<div class=\"p_clear_both_top\">&nbsp;</div>";
					$.each(jsonchatlist, function (i, n) {
							var childdiv1 = "";
							var messagesource = n.message_source;

							//用户聊天信息对象
							var msgtype = "";
							var mediaId = "";
							var locationx  ="";
							var locationy  ="";
							var id  ="";
							var receiveMsgObj = n.receiveMessage;
							
							
							
							
							if(receiveMsgObj !=null){//用户聊天为空处理
								msgtype = receiveMsgObj.msgType;
							    mediaId = receiveMsgObj.mediaId;
							    content= receiveMsgObj.content;
							    locationx = receiveMsgObj.location_X;
							    locationy = receiveMsgObj.location_Y;
							}
						
							
							var StreamUrl = "${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=" + mediaId;
							
							//客服聊天信息对象
							var cmsgtype ="";
							var customerSerObj = n.customerServiceChatInfo;
							if(customerSerObj !=null){//客服聊天为空处理
								cmsgtype = customerSerObj.msgtype;
							}
							
							var createtime = new Date(n.createtime);
							createtime = (createtime.getHours()<10 ? "0"+createtime.getHours() : createtime.getHours())+":"
							+(createtime.getMinutes()<10 ? "0"+createtime.getMinutes() : createtime.getMinutes())+":"
							+(createtime.getSeconds()<10 ? "0"+createtime.getSeconds() : createtime.getSeconds());
							
							//聊天历史记录按日期分段
							var tempDate = n.tempDate;
							if(tempDate){
								childdiv1 +="<div style=\"text-align: center\">"+tempDate+"</div>";
							}
							
							//用户
							if(messagesource == "1"){
								childdiv1 +="<div class=\"p_left_chat_user\">"
								+"<div class=\"p_left_chat_user_head\">"
								+"<img src=\""+jsonimgurl+"\" width=\"40px\" height=\"40px\" class=\"p_left_chat_user_head_img\" >"
								+"</div>"
								
								+"<div class=\"p_left_chat_user_createtime\">"+createtime
								+"</div>"
								
								+"<div class=\"p_left_chat_user_background_triangle\">&nbsp;"
								+"</div>"
								+"<div class=\"p_left_chat_user_background_content\">"
								+"<div class=\"p_left_chat_user_background_content_style\">";
								if(msgtype == "text"){
									childdiv1 += receiveMsgObj.content;
								}
								if(msgtype == "image"){
									  childdiv1 += "<div  class='photos_record'><a href=\""+StreamUrl+"\" rel=\"lightbox-group\" >"
										+"<img  src=\""+StreamUrl+"\" />"	  
										+"</a></div>";
								}
								if(msgtype == "voice"){
										childdiv1 += "<embed src='" + StreamUrl + "' width='200' height='18' autoplay='false' controller='true' type='video/quicktime'></embed>";			
									if(content!=null&&content!=""){
										childdiv1 += "<span>('"+content+"')</span>";
									}
								}
								if(msgtype == "location"){
									var center="center="+locationy+","+locationx+"";
									//childdiv1 +="<a href='http://api.map.baidu.com/staticimage?"+center+"&width=800&height=620&zoom=15&scale=2&markers="+locationy+","+locationx+"&markerStyles=l,A,0xff0000'><img style='margin:20px' width='240' height='100' src='http://api.map.baidu.com/staticimage?"+center+"&width=280&height=140&zoom=15&scale=2&markers="+locationy+","+locationx+"&markerStyles=l,A,0xff0000' /></a> ";
									//childdiv1 +="<div  class='photos_record'><a href='http://st.map.qq.com/api?size=1004*800&"+center+"&zoom=15&markers="+locationy+","+locationx+"'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&"+center+"&markers="+locationy+","+locationx+"&zoom=15' /></a></div> ";
									
									
									childdiv1 +="<div  class='photos_record'><a rel=\"lightbox-group\" href='http://st.map.qq.com/api?size=1004*800&"+center+"&zoom=15&markers="+locationy+","+locationx+"'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&"+center+"&markers="+locationy+","+locationx+"&zoom=15' /></a></div> ";
									//childdiv1 +="<div  class='photos_record'><a  href='${webRoot}/wechatClaims/CustomerChat.do?method=goToMapPage&latitude="+locationy+"&longitude="+locationx+"'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&"+center+"&markers="+locationy+","+locationx+"&zoom=15' /></a></div> ";
							    }
								childdiv1 +="</div>"
								+"</div>"
								+"</div>"
								+"<div class=\"p_clear_both\">&nbsp;</div>";
								
							}
							/* if(messagesource == "1"){
                            if(msgtype == "location"){
                            	init();
								
							}
							} */
							
							
							
							//客服
							if(messagesource == "0"){
								childdiv1 +="<div class=\"p_left_chat_customerservice\">"
									+"<div class=\"p_left_chat_customerservice_head\">"
									+"<img id=\"img${registno}\" src=\"${webRoot}/plug-in/fo/images/customerwechat/kefu.jpg\" width=\"40px\" height=\"40px\" class=\"p_left_chat_customerservice_head_img\" >"
									+"</div>"
									+"<div class=\"p_left_chat_customerservice_createtime\">"+createtime
									+"</div>"
									+"<div class=\"p_left_chat_customerservice_background_triangle\">&nbsp;"
									+"</div>"
									+"<div class=\"p_left_chat_customerservice_background_content\">"
									+"<div class=\"p_left_chat_customerservice_background_content_style\">";
									if(cmsgtype == "001"){
										childdiv1 += customerSerObj.content;
									}
									if(cmsgtype == "002"){
										childdiv1 +="<a href=\""+customerSerObj.filepath+"\" target=\"_blank\">"
										 +"<img  src=\""+customerSerObj.filepath+"\" alt=\"\"/>"
										 +"</a>";
									}
									childdiv1 +="</div>"
									+"</div>"
									+"</div>"
									+"<div class=\"p_clear_both\">&nbsp;</div>";
							}
							contentTbody += childdiv1;
					});
					//最后聊天时间
					contentTbody +="<div style=\"text-align: center\">";
					if(jsonuserlasttime != ""){
						contentTbody +="---------------------------"+jsonuserlasttime+"---------------------------";
					}
					contentTbody +="</div>";
					
					//案件信息
					var childdiv2 = "";
					var jsonreportorname = json.attributes.reportorName;
					var jsonreportdate = json.attributes.reportDate;
					var jsonreporttime = json.attributes.reportTime;
					var jsonphonenumber = "";
					if(json.attributes.phoneNumber != null){
						jsonphonenumber=json.attributes.phoneNumber;
					}
					var jsonregistno = json.attributes.registNo;
					var jsonremark = json.attributes.remark;
					var jsonkindName = json.attributes.kindName;
					var jsoncarModel = json.attributes.carModel;
					var jsoncurroperator = json.attributes.currOperatorCode;
					var jsoncurrName = json.attributes.currOperatorName;
					childdiv2 +="<span class=\"p_right_registno_content\">报案人：</span><br/>"
						+jsonreportorname+"<br/>"
						+"<span class=\"p_right_registno_content\">报案时间：</span><br/>"
						+jsonreportdate+" "+jsonreporttime+"<br/>"
						+"<span class=\"p_right_registno_content\">报案电话：</span><br/>"
						+jsonphonenumber+"<br/>"
						+"<span class=\"p_right_registno_content\">报案号：</span><br/>"
						+jsonregistno+"<br/>"
						+"<span class=\"p_right_registno_content\">事故经过：</span><br/>"
						+jsonremark+"<br/>"
						+"<span class=\"p_right_registno_content\">险别信息：</span><br/>"
						+jsonkindName+"<br/>"
						+"<span class=\"p_right_registno_content\">车辆信息：</span><br/>"
						+jsoncarModel+"<br/>"
				     	+"<span class=\"p_right_registno_content\" >案件处理人：</span><br/>"
						+jsoncurroperator+"("+jsoncurrName+")"
						+"<br/>";
						
					registTbody += childdiv2;
					$("#chatContent").append(contentTbody);
					
					 
		  			$("#right_registno").append(registTbody);
		  			setCustomerServiceHeadImage();//设置客服头像和自动跳到div末尾
		  			//setChatImage();
		  			goToBottom();
		  			
					//重新加载 picbox.js   初始化图片
					$("#picboxId").remove();
					var picboxjs ="<script id=\"picboxId\" src='${webRoot}/plug-in/picbox/js/picbox.js'></sc"+"ript>";
					$("head").append(picboxjs);
				} else {
					
				}
	          },
	          error: function () {
	            toLoginPage();
	          }
	      });
    }
	
	//搜索显示案件列表
	function showRegistNoList(currentNumber){
		  var tbody = "";
		  var total=0;
		  var registnofrom="";
		  if(currentNumber==0){
				currentNumber=1;//即时聊天窗口传递过来的案件号（第一次才激活样式）
				registnofrom="${registno}";
		  }
		  var licenseno =$("#h_licenseno").val();
		  var registno =$("#h_registno").val();
		  var encodeLicenseno=escape(encodeURIComponent(licenseno)); //转码
		  var startTime =$("#h_startdate").datetimebox("getValue");
		  var endTime =$("#h_enddate").datetimebox("getValue");
	      var url="${webRoot}/wechatClaims/CustomerChat.do?historyRegistNoList&operatorcode=${operatorCode}&rolecode=${roleCode}"
	    		  +"&licenseno="+encodeLicenseno
	    		  +"&registno="+registno
	    		  +"&startTime="+startTime
	    		  +"&endTime="+endTime
	    		  +"&currpageno="+currentNumber;
		  $("#firstpane").empty();
	      $.ajax({
			  type : 'POST',
			  url : url,
			  dataType : "json",
	          success: function (json) {
				if (json.success) { 
					var jsonregistnolist =json.attributes.registNoList;
					var jsontotal = json.attributes.total;
					total=jsontotal;
					$.each(jsonregistnolist, function (i, n) {
							var childdiv = "";
							var registno = n.registNo;
							if(registno == registnofrom ){
								childdiv +="<div class=\"menu_head current\">";
							}else{
								childdiv +="<div class=\"menu_head\">";
							}
							childdiv +="<div id=\""+n.registNo+"\" onclick=\"showChat(\'"+n.registNo+"\');\">"
								+"<div class='menu_head_content'>"
								+"<div class='menu_head_content_img'>"
								+"<img src=\""+n.headimgurl+"\" width='50px' height='50px' style=\"padding-top:10px;\"/>"
								+"</div>"
								+"<div class='menu_head_content_name'>"
								+ n.reportorName
								+"</div>"
								+"</div>"
								+"<div class='menu_head_content'>"
								+"<div class='menu_head_content_lisens'>"
								+ n.licenseNo
								+"</div>"
								+"<div class=\"menu_head_content_registno\">"
					 			+ n.registNo
					 			+"</div>"
								+"</div>"
								+"</div>"
								+"</div>";
							tbody += childdiv;
					});
					$("#firstpane").append(tbody);
				} else {
					$("#firstpane").append(json.msg);
				}
				
			    //分页
				$('#pp').pagination({   
						total:total,   
						pageSize:<%=cn.com.fubon.util.Constants.WECHATCLAIMS_REGISTNO_PAGESIZE %>, 
						pageNumber:currentNumber,
						showPageList:false,
						showRefresh:false,
						onSelectPage: function(pageNumber, pageSize){   
							showRegistNoList(pageNumber);
			           }
				 });
	          },
	          error: function () {
	        	  toLoginPage();
	          }
	      });
	}

</script>
</head>
<body>
<body class="easyui-layout">
	
	<div region="west" split="true" title="案件列表" class="main_left" id="main_left">
		<!-- 左侧历史案件列表 start-->
		 <div id="firstpane" class="menu_list">
		 <%-- 	 		 
		 		<c:if test="${regists.registNo eq registno}">
-					<div class="menu_head current">
-				 </c:if>
-				 <c:if test="${regists.registNo ne registno}">
-					<div class="menu_head">
-				 </c:if> 
		--%>
   		</div>
   		<!-- 左侧历史案件列表 end-->
   		<div id="pp" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;">
		</div>
	</div>

	<!-- main条件查询和历史聊天内容记录 start-->
	<div id="mainPanle" region="center" style="padding: 2px;">
		<!-- panel start -->
		<div class="easyui-panel" title="条件查询" fit="true" class="p_panel">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false">
					<div class="easyui-layout" fit="true">
						<!-- 右侧案件信息 -->
						<div region="east" border="false" class="p_right">
							<div class="p_right_registno" id="right_registno">
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
						     		<c:if test="${reportInfoMap.currOperatorCode != 'null'  }">
										${reportInfoMap.currOperatorCode}(${reportInfoMap.currOperatorName})
									</c:if>
								<br/>
						    </div>	
						</div>
						<!-- 左侧聊天内容信息  start-->
						<div region="center" border="false" class="p_left">
							<div class="easyui-layout" fit="true">
								<!-- 条件查询-->
								<div region="center" border="false">
									<div class="p_right_registno">
										 <span class="p_right_registno_content">
										 	开始时间：<input class="easyui-datetimebox" id="h_startdate" style="width:150px;">
										 </span>
										 <span class="p_right_registno_content">
											结束时间：<input class="easyui-datetimebox" id="h_enddate" width="150px" style="width:150px;">
										 </span>
										  <span class="p_right_registno_content">
										 	车牌号：<input id="h_licenseno" class="easyui-textbox" style="height: 15px;width: 150px;" placeholder="请输入车牌号">
						                </span>
						                <span class="p_right_registno_content">                                
						                                                            报案号：<input id="h_registno" class="easyui-textbox" style="height: 15px;width: 150px;" placeholder="请输入报案号">
										</span>
										<!--  
										<span class="p_right_registno_content">  
										              关键字：<input id="h_key" class="easyui-textbox" style="height: 15px;width: 150px;" placeholder="请输入内容关键字">
										 </span>-->
						 				<a href="#" id="h_search" class="easyui-linkbutton">查询</a>			
									</div>
								</div>
							
								<!-- 聊天内容窗口 start-->
								<div region="south" split="true" border="false" class="h_left_historychatcontent" id="chatContent" >
									<div class="p_clear_both_top">&nbsp;</div>
									<c:forEach items="${customerChatList}" var="customerChats" varStatus="status">
									<c:if test="${not empty customerChats.tempDate}">
										<div style="text-align: center">
										${customerChats.tempDate}
										</div>
									</c:if>
									
									<!-- 客户  start-->
									<c:if test="${customerChats.message_source == 1  }">
										<div class="p_left_chat_user">
											<div class="p_left_chat_user_head">
												<img src="${reportInfoMap.headimgurl}" width="40px" height="40px" class="p_left_chat_user_head_img" >
											</div>
											<div class="p_left_chat_user_createtime">
												<fmt:formatDate value="${customerChats.createtime}" pattern="HH:mm:ss"/>
											</div>
											 
	                                        <div class="p_left_chat_user_background_triangle">&nbsp;
											</div>
	                                       <div class="p_left_chat_user_background_content">
	                                        <div class="p_left_chat_user_background_content_style">
	                                        	<c:if test="${customerChats.receiveMessage.msgType == 'text'  }">
	                                        		${customerChats.receiveMessage.content}
	                                        	</c:if>
											 	
											 	<c:if test="${customerChats.receiveMessage.msgType == 'image'  }">
											 		  <div  class="photos_record">
												        <a href="${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=${customerChats.receiveMessage.mediaId }" rel="lightbox-group" >
												       	  <img   src="${webRoot}/wechatClaims/CustomerChat.do?getMediaidStream&mediaid=${customerChats.receiveMessage.mediaId }" alt="" >
												        </a>
												     </div>
												</c:if>
												
											 	<c:if test="${customerChats.receiveMessage.msgType == 'voice'  }">	
													<div><span style='height: 30px; display: none' id='city'></span></div><div style='width: 603px; height: 300px' id='container'></div><p></p>
									
												</c:if>
												<c:if test="${customerChats.receiveMessage.msgType == 'location'  }">
												<div  class="photos_record">
									            <a  rel="lightbox-group" href='http://st.map.qq.com/api?size=1004*800&${customerChats.receiveMessage.location_Y},${customerChats.receiveMessage.location_X}&zoom=15&markers=${customerChats.receiveMessage.location_Y},${customerChats.receiveMessage.location_X}'><img style='margin:20px' width='240' height='100' src='http://st.map.qq.com/api?size=304*200&${customerChats.receiveMessage.location_Y},${customerChats.receiveMessage.location_X}&markers=${customerChats.receiveMessage.location_Y},${customerChats.receiveMessage.location_X}&zoom=15' /></a>  
												</div>
												</c:if>
											</div>
	                                       </div>
	                                    </div>
	                                    <div class="p_clear_both">&nbsp;</div>
									</c:if>
									<!-- 客户  end-->
									<!-- 客服  start-->
									<c:if test="${customerChats.message_source == 0  }">
										<div class="p_left_chat_customerservice">
                                        	<div class="p_left_chat_customerservice_head">
                                        		<img id="img${registno}" src="${webRoot}/plug-in/fo/images/customerwechat/kefu.jpg" width="40px" height="40px" class="p_left_chat_customerservice_head_img">
	                                        </div>
	                                         <div class="p_left_chat_customerservice_createtime">
												<fmt:formatDate value="${customerChats.createtime}" pattern="HH:mm:ss"/>
											</div>
	                                        <div class="p_left_chat_customerservice_background_triangle">&nbsp;
											</div>                                        
											<div class="p_left_chat_customerservice_background_content">
	                                            <div class="p_left_chat_customerservice_background_content_style">
													<c:if test="${customerChats.customerServiceChatInfo.msgtype == '001'  }">
		                                        		${customerChats.customerServiceChatInfo.content}
		                                        	</c:if>
												 	
												 	<c:if test="${customerChats.customerServiceChatInfo.msgtype == '002'  }">
												 		<a href="${customerChats.customerServiceChatInfo.filepath}" target="_blank">
												 			<img  src="${customerChats.customerServiceChatInfo.filepath}" alt=""/>
												 		</a>
													</c:if>
												</div>
                                        	</div>
                                        </div>
                                        <div class="p_clear_both">&nbsp;</div>
									</c:if>
									<!-- 客服  end-->
									</c:forEach>

									<div style="text-align: center">
										<c:if test="${not empty userlasttime}">
										---------------------------${userlasttime}---------------------------
										</c:if>
									</div>
								</div>
							<!-- 聊天内容窗口 end-->
							</div>
						</div>
					  <!-- 左侧信息  end-->
					</div>
				</div>
			</div>
		</div>
		<!-- panel end -->
	</div>
<!-- main条件查询和历史聊天内容记录 end-->
</body>



</html>
