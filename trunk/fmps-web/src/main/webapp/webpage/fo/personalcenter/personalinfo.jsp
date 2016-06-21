<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html class="no-js">
<head>
  <title>个人信息</title>
  <link rel="icon" type="image/png" href="${webRoot}/plug-in/amaze-ui/i/favicon.png">
 <%@ include file="/webpage/fo/common/fotags.jsp"%>
  <style type="text/css">
.geren_center_bg {
	background: url(${webRoot}/plug-in/fo/images/geren_center_bg.jpg) no-repeat scroll left top / 100% auto;
	height: 150px;
	width: auto;
}

.geren_center_img {
	border: 3px solid #c5b39d;
	width: 80px;
	height: 80px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	-o-border-radius: 50px;
	border-radius: 50px;
	margin-left: 20px;
	margin: 0 auto;
}

.geren_center_name {
	color: #FFFFFF;
	font-size: 0.825em;
	text-align: center;
	margin: 0 auto;
	padding-top: 5px;
}

.geren_center_all {
	padding: 15px;
}

.geren_center_all_icon {
	font-size: 0.825em;
	color: #b1b1b1;
	border-bottom: #e8e8e8 solid 1px;
	height: 30px;
}

.geren_Information {
	font-size: 0.825em;
	color: #292929;
	line-height: 32px;
	padding: 5px;
}

.notfilled {
	color: #a2a2a1;
}

</style>
</head>

<body>
<div class="geren_center_bg">
 <div style="height:20px;">&nbsp;</div>
 
  <div style="width:100%;">
   <div class="geren_center_img">
   <img src="${headimgurl}"  width="75" height="74" style="-webkit-border-radius:50px; -moz-border-radius:50px; -o-border-radius:50px; border-radius:50px;">
   </div>
   <div class="geren_center_name">${nickname}</div>
  </div>
</div>

<div class="geren_center_all">
 <div class="geren_center_all_icon"><img src="${webRoot}/plug-in/fo/images/geren_nei_icon_1.jpg" width="15" height="15"/> 个人</div>
 <div class="geren_Information">
  <div class="text_1">姓 名：
	  <c:if test="${customercname == null}"><span class="notfilled"><未填写></span></c:if>
	  <c:if test="${customercname != null}"><span>${customercname}</span></c:if>
  </div>
  <div class="text_2">性 别：
  	  <c:if test="${customerSex == null}"><span class="notfilled"><未填写></span></c:if>
	  <c:if test="${customerSex != null}"><span>${customerSex}</span></c:if>
  </div>
  <div class="text_3">证件号：
  	  <c:if test="${identifynumber == null}"><span class="notfilled"><未填写></span></c:if>
	  <c:if test="${identifynumber != null}"><span>${identifynumber}</span></c:if>
  </div>
 </div>
 
 
 <div class="geren_center_all_icon"><img src="${webRoot}/plug-in/fo/images/geren_nei_icon_3.jpg" width="15" height="15"/> 车辆</div>
 <c:if test="${fn:length(cars)==0}"><div class="geren_Information">您名下没有车辆信息。</div></c:if>
 <c:forEach items="${cars}" var="car">
  <div class="geren_Information" style="border-bottom:1px solid #e8e8e8;">
	  <div class="text_1">车牌号：<span>${car.licenseno }</span></div>
	  <div class="text_2">品牌型号：<span>${car.brandname }</span></div>
  </div>
 </c:forEach>

 
</div>

</body>
</html>