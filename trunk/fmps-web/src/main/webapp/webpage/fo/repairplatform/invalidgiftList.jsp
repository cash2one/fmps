<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>礼包</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
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
  border-bottom:2px solid #0e90d2;
}
.am-checkbox {
  margin-top: 0px;
  }
  .am-header .am-header-nav img {
  height: 20px;
}
.am-header .am-header-title {
  margin: 0 1%;
}
.am-header-default .am-header-nav > a{ color:#222222;}
.ticket_bg{ border-bottom:1px solid #e8e8e8; border-top:1px solid #e8e8e8; height:80px; background:url(${webRoot}/plug-in/repair/make.jpg) scroll no-repeat right bottom; width:100%;}
.ticket_bg_2{ border-bottom:1px solid #e8e8e8; border-top:1px solid #e8e8e8; height:80px; background:url(${webRoot}/plug-in/repair/make_2.jpg) scroll no-repeat right bottom; width:100%;}
.ticket_left{ width:20%; float:left; padding:15px 0px 0px 10px;}
.ticket_right{ width:65%; float:left; color:#292929; font-size:18px; line-height:70px; font-family:"微软雅黑";}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; font-size:16px;">
    无效礼包
  </h1>
</header>
<%-- <c:if test="${invalidWeixinGiftsetDetailList==null||invalidWeixinGiftsetDetailList==''}">
<div style=" text-align:center; margin-left:auto; margin-right:auto; ">${message}</div>

</c:if> --%>
<c:forEach items="${invalidWeixinGiftsetDetailList}"	var="invalidWeixinGiftsetDetail" varStatus="status">
 <c:if test="${status.index==0}">
<div style="height:15px;">&nbsp;</div>
</c:if> 
 <c:if test="${status.index!=0}">
<div style="height:10px;">&nbsp;</div>
</c:if>


 <c:if test="${invalidWeixinGiftsetDetail.scanrepairid!=null}">
 <a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=vouchersMain&id=${invalidWeixinGiftsetDetail.id}&openid=${openid}&statusflag=2"> 
<div class="ticket_bg">
 <div class="ticket_left">
 
 <img src="${invalidWeixinGiftsetDetail.repairlogo }"  style="width:40px; height:40px; border-radius:20px; border:1px solid #e8e8e8;"/>
 
 
 
 </div>
 <div class="ticket_right">${invalidWeixinGiftsetDetail.name }  <span style="color:#818181; font-size:12px; float:right; line-height:75px;"><fmt:formatDate value="${invalidWeixinGiftsetDetail.enddate }" pattern="MM月dd日"/></span></div>
</div>
</a>
</c:if>


 <c:if test="${invalidWeixinGiftsetDetail.scanrepairid==null}">
<a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=vouchersMain&id=${invalidWeixinGiftsetDetail.id}&openid=${openid}&statusflag=3"> 
<div class="ticket_bg_2">
 <div class="ticket_left">
  
 <img src="${invalidWeixinGiftsetDetail.repairlogo }"  style="width:40px; height:40px; border-radius:20px; border:1px solid #e8e8e8;"/>
 
 
 </div>
 <div class="ticket_right">${invalidWeixinGiftsetDetail.name }  <span style="color:#818181; font-size:12px; float:right; line-height:75px;"><fmt:formatDate value="${invalidWeixinGiftsetDetail.enddate }" pattern="MM月dd日"/></span></div>
</div>
</a>
</c:if>

</c:forEach>

<!-- <div style="height:10px;">&nbsp;</div>
<div class="ticket_bg_2">
 <div class="ticket_left"><img src="images/peck_head.png"  style="width:40px; height:40px; border-radius:20px; border:1px solid #e8e8e8;"/></div>
 <div class="ticket_right">29元代驾券 <span style="color:#818181; font-size:12px; float:right; line-height:75px;">7月05日</span></div>
</div> -->
</body>
</html>
