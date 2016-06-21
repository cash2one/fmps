<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
.am-header-default {
  background-color: #fff;
}
.am-header {
  position: relative;
  width: 100%;
  height: 49px;
  line-height: 49px;
  padding: 0 10px;
  margin-bottom: 20px;
  border-bottom:2px solid #0e90d2;
}
.am-checkbox {
  margin-top: 0px;
  }
  .am-header .am-header-nav img {
  height: 20px;
}
.insurance_card{ padding:0px 15px 15px 15px; width:100%;}
.insurance_card_product{
    -moz-border-radius: 10px;   
    -webkit-border-radius: 10px;       
	border-radius:10px; 
	border:1px solid #e8e8e8;
	width:100%;
	height:86px;
	padding:15px;
	background:url(${webRoot}/plug-in/fo/images/activation1.png)  no-repeat right top ;
	background-size:40px 40px;
	}
	.insurance_card_product2{
    -moz-border-radius: 10px;   
    -webkit-border-radius: 10px;       
	border-radius:10px; 
	border:1px solid #e8e8e8;
	width:100%;
	height:86px;
	padding:15px;
	}
.insurance_card_product2 .product_img{ width:20%; float:left;}
.insurance_card_product2 .product_text{ width:70%; float:left; font-size:0.625em; text-align:left; color:#06b105; padding-left:21px; padding-top: 5px;}
.insurance_card_product2 .product_right_icon{ width:10%; float:left; padding-top:17px;}

.insurance_card_product .product_img{ width:20%; float:left;}
.insurance_card_product .product_text{ width:70%; float:left; font-size:0.625em; text-align:left; color:#06b105; padding-left:21px; padding-top: 5px;}
.insurance_card_product .product_right_icon{ width:10%; float:left; padding-top:17px;}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; ">
    保险卡
  </h1>
</header>

<c:forEach items="${weixinHuodongCardList}"	var="weixinHuodongCard" varStatus="status">

 <c:if test="${weixinHuodongCard.status=='-2' }"> 
<div class="insurance_card">
<a href="${webRoot}/fo/cardController.do?cardCommodity&cardcount=${weixinHuodongCard.cardno}&password=${weixinHuodongCard.password}&openid=${weixinHuodongCard.openid}" >
 <div class="insurance_card_product2">
  <div class="product_img"><img src="${webRoot}/${weixinHuodongCard.producticon}" width="55" height="55" /></div>
  <div class="product_text" style="font-size:18px;color:#333333; line-height: 25px;">${weixinHuodongCard.productname}<br /><span style="color:#333; font-size:0.725em;">有效期至 <fmt:formatDate value="${weixinHuodongCard.validtime}" type="date" dateStyle="default"/>  <%-- </br> 已于<fmt:formatDate value="${weixinHuodongCard.cardinfoid.startdate}" type="date" dateStyle="long"/>激活成功 --%>   </span></div>
  <div class="product_right_icon"><span style="font-size:24px; color:#E0E0E0; text-align:right;"> <img src="${webRoot}/plug-in/fo/images/right2.png" width="8" height="15"/></span></div>
 </div>
 </a>

</div>
</c:if> 

<c:if test="${(weixinHuodongCard.status=='-1')||(weixinHuodongCard.status==null)||(weixinHuodongCard.status=='')  }"> 
<div class="insurance_card">
<a href="${webRoot}/fo/cardController.do?cardCommodity&cardcount=${weixinHuodongCard.cardno}&password=${weixinHuodongCard.password}&openid=${weixinHuodongCard.openid}" >
 <div class="insurance_card_product">
  <div class="product_img"><img src="${webRoot}/${weixinHuodongCard.producticon}" width="55" height="55" /></div>
  <div class="product_text" style="font-size:18px;color:#333333;line-height: 25px;">${weixinHuodongCard.productname}<br /><span style="color:#333; font-size:0.725em;">有效期至 <fmt:formatDate value="${weixinHuodongCard.validtime}" type="date" dateStyle="default"/></span></div>
  <div class="product_right_icon"><span style="font-size:24px; color:#E0E0E0; text-align:right;"> <img src="${webRoot}/plug-in/fo/images/right2.png" width="8" height="15"/></span></div>
 </div>
 </a>

</div>
</c:if>


</c:forEach>

</body>
</html>