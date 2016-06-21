<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦封神榜: 我乃${honor_name }！邀众神归队，抢夺神位！</title>
<%@ include file="/webpage/fo/common/fotags.jsp" %>

<style type="text/css">
body {
	background: url(${webRoot }/plug-in/fo/images/feng_1.jpg) scroll center no-repeat;
	margin: 0 auto;
	height: 766px;
	width: 100%;
}

.feng_text_1 {
	font-size: 0.75em;
	color: #ffffff;
	text-align: center;
	font-family: "微软雅黑";
}

.feng_text_2 {
	font-size: 2.5em;
	color: #3b302b;
	text-align: center;
	font-family: "微软雅黑";
}

.feng_text_3 {
	font-size: 0.825em;
	color: #3b302b;
	text-align: center;
	font-family: "微软雅黑"; width: 75%; margin: 0 auto;
}

.feng_text_4 {
	font-size: 1em;
	color: #3b302b;
	text-align: center;
	font-family: "微软雅黑";
	width: 100%;
}

.feng_anniu_1 {
	float: left;
	width: 50%;
}

.feng_anniu_2 {
	float: left;
	width: 50%;
}

.anniu_1 {
	width: 100px;
	text-align: center;
	background-color: #6f5d47;
	margin: 0 auto;
	color: #FFFFFF;
	font-size: 0.75em;
	padding: 5px;
	border-radius: 3px;
	margin-right: 10px;
}

.anniu_2 {
	width: 100px;
	text-align: center;
	background-color: #6f5d47;
	margin: 0 auto;
	color: #FFFFFF;
	font-size: 0.75em;
	padding: 5px;
	border-radius: 3px;
	margin-left: 10px;
}

.feng_text_5 {
	font-size: 0.75em;
	color: #010101;
	text-align: center;
	font-family: "微软雅黑";
}
header {
  height: 35px;
  line-height: 18px;
}
.am-topbar-inverse {
opacity:0.80;
}
.fee_anniu_1 {
  margin-top: 0px;
}
</style>
</head>
<body>
 <div style="height:15px;">&nbsp;</div>
 <div class="feng_text_1"></div>
 
 <!-- 是否有排名信息,rank==null则没有排名信息 -->
 <c:choose>
 	<c:when test="${rank == null }">
 		<div style="height:150px;">&nbsp;</div>
 		<div style="height:20px;">&nbsp;</div>
 		<div class="feng_text_3">很抱歉，您目前没有有效保单，无法获得神位。</div>
 	</c:when>
 	<c:otherwise>
 	
 		<div style="height:150px;">&nbsp;</div>
		<div class="feng_text_2">${honor_name }</div>
		<div style="height:20px;">&nbsp;</div>
		<div class="feng_text_3">${honor_desc }</div> 
		<div style="height:120px;">&nbsp;</div>
		 
 		<!-- 是否本人,nickname==null则是本人-->
 		<c:choose>
			<c:when test="${nickname == null }">
				 <div class="feng_text_4">
				  <div class="feng_anniu_1">
				   <div class="anniu_1" onclick="toPersonalCenter();">进入个人中心</div>
				  </div>
				  <div class="feng_anniu_2">
				   <div class="anniu_2" onclick="toCustomerPremRanking();">查看全国排名</div>
				  </div>
				 </div>
			</c:when>
			<c:otherwise>
			
			<c:if test="${subscribed == null }">
		 		<div class="fee_anniu_1">
					<div style=" font-size:14px; width:120px; margin:0 auto;  text-align:center; background:#6f5d47; color:#FFFFFF;-moz-border-radius: 5px; -webkit-border-radius: 5px; height: 25px;" onclick="toCustomerHonorTitle(); ">查看我的称号</div>
				</div>
			
		 	</c:if>
				
			</c:otherwise>
 		</c:choose>
 		
 		<c:choose>
			<c:when test="${subscribed == null }">
				 <div style="height:60px; clear: both;">&nbsp;</div>
			</c:when>
			<c:otherwise>
				 <div style="height:89px; clear: both;">&nbsp;</div>
			</c:otherwise>
		</c:choose>
		
		<div class="feng_text_5">当前个人保费全国排名 ${rank } 名</div>
		 
		 <c:if test="${subscribed != null }">
		    <header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
              <div style="  font-size: 0.825em; color: #fff; word-break:break-all; width:100%; overflow:auto; padding-top: 6px; text-align: left; padding-left: 6px; opacity:0.99;">${subscribed}</div>
            </header>
		 
		 </c:if>
  	</c:otherwise>
 </c:choose>
</body>

<script>
function toPersonalCenter(){
	location.href="${webRoot}/fo/binded/personalCenterController.do?method=Index&openid=${openid}";
}
function toCustomerPremRanking(){
	location.href="${webRoot}/fo/binded/customerPremRankingController.do?method=customerPremRanking&openid=${openid}";
}
function toCustomerHonorTitle(){
	location.href="${webRoot}/fo/binded/customerHonorTitleController.do?method=customerHonorTitle&openid=${openid}";
}
</script>
</html>