<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>抢保额</title>
  <meta name="description" content="user data">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" rel="stylesheet" type="text/css">
  <script src="${webRoot}/plug-in/fo/js/lunarNewyear/writeUserData.js"></script>
  <%-- <script src="${webRoot}/plug-in/fo/verificationIdentity.js"></script> --%>
  <style>
  	.user_tips{ width:100%; clear:both; text-align:center; color:#fff; padding-top:15px; font-size:12px;}
  	.info_form_7 {
		clear: both;
		padding-top: 20px;
		font-size: 12px;
		color: #fff;
		text-align: center;
	}
	.info_form_7 a{
		text-decoration: none;
	}
  	.info_button{ padding-top:15px;}
  </style>
</head>
<body style=" background-color:#8c0c0b;">
	<form id="userForm" action="${webRoot}/fo/lunarNewYearController.do?saveUserData" method="post">
		<input type="hidden" id="webRoot" name="webRoot" value="${webRoot}" />
	 	<div><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/spring_info.jpg" /></div>
	 	<div class="info_form_7" style="color: #ff9b19;">*请填写真实信息，便于生效表单以及参与抽奖活动</div>
		<section class="input">
			 <div class="spring_info_1">
			  	<div class="info_left">姓 名:</div>
			  	<div class="info_right"><input name="customercname" id="customercname" type="text" value = "${weiXinGzUserInfo.customercname}"/></div>
			 </div>
		 
			 <div class="spring_info_2">
			 	 <div class="info_left">身份证:</div>
			  	<div class="info_right"><input name="identifynumber" id="identifynumber" type="text" value="${weiXinGzUserInfo.identifynumber}"/></div>
			 </div>
		
			 <div class="spring_info_2">
			 	 <div class="info_left">手机号:</div>
			 	 <div class="info_right"><input name="mobile" id="mobile" type="text" value="${weiXinGzUserInfo.mobile}"/></div>
			 </div>
		 
			  <div class="spring_info_3">
			  	<div class="info_left">验证码:</div>
			  	<div class="info_right"><input name="dynamicpassword" id="dynamicpassword" type="text" /></div>
			  	<div class="info_validate"  onclick="sendDynamicPassword(this, $('#mobile'), $('#alertMessage'),'${openid}');">获取验证码</div>
			 </div>
			 <div class="info_form_7" >
				<label class="am-checkbox">
					 <input id="readed" style="width:auto;" type="checkbox" class="option-input checkbox"  /> 
					 	我已阅读并同意《
						<a href="${webRoot}/fo/taiwanController.do?showNotice&openid=${openid}&productid=${productId}">
							<span style="color: #ff9b19;">投保须知</span>
						</a>》、《
						<a href="${webRoot}/fo/taiwanController.do?showArticle&openid=${openid}&productid=${productId}">
							<span style="color: #ff9b19;">保险条款</span>
						</a>》
				</label>
			</div>
			 <div class="user_tips" id="alertMessage">${message}</div>
		 </section>
	 	 <div class="info_button" ><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/info_button.jpg"  onclick="saveData()"/></div>
	 </form>
	 
</body>
</html>

