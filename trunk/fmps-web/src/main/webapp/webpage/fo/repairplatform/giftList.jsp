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
.peck_up{
       width:95%; 
	   height:90px;
       background:#32b5f9; 
	   margin:0 auto;
	   border-radius: 5px 5px 0px 0px; }
.peck_down{
       width:95%; 
	   height:28px;
       background:#2b9fda; 
	   margin:0 auto;
	   border-radius: 0px 0px 5px 5px;}
.peak_left{ float:left; width:30%; padding:22px 0px 0px 15px;}
.peak_right{ float:left; width:70%; text-align:left; font-family:"微软雅黑"; font-size:17px; color:#fff; padding-top:35px; padding-left:5px;}
.peck_down_left{ float:left; width:50%; color:#fff; font-size:11px; text-align:left; line-height:27px; text-indent:14px;}
.peck_down_right{ float:left; width:46%; color:#fff; font-size:11px; text-align:right; line-height:27px;}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >

  <h1 class="am-header-title" style=" color:#171717; font-size:16px;">
    礼包
  </h1>
  <div  class="am-header-right am-header-nav" style="padding-top:15px;">
         
       <a id="aa" >  <i class="am-header-icon am-icon-bars" > </i> </a>
          
      </div>
</header>
 
   <div id="gifts"  style="display:none; position: absolute; float: right; width: 100%;"><a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=InvalidgiftList&openid=${openid}" class="" ><span class="am-btn am-btn-primary btn-loading-example" style="float: right;" >无效礼包</span></a></div>
  
<%-- <c:if test="${weixinGiftsetDetailList==null||weixinGiftsetDetailList==''}">
<div style=" text-align:center; margin-left:auto; margin-right:auto; ">${message}</div>

</c:if> --%>
<c:forEach items="${weixinGiftsetDetailList}"	var="weixinGiftsetDetail" varStatus="status">
     

<a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=vouchersMain&id=${weixinGiftsetDetail.id}&openid=${openid}&statusflag=1">         


<div style="height:10px;">&nbsp;</div>
<div class="peck_up" style="background:${weixinGiftsetDetail.lightcolor};">
 <div class="peak_left">
 <c:choose>
 	 <c:when test="${weixinGiftsetDetail.cardtype==1}">
 		<img src="${webRoot}/plug-in/repair/peck_head.png"  style="width:62px; height:62px; border-radius:31px;"/>
 	 </c:when>
 	 <c:otherwise>  
 		<img src="${weixinGiftsetDetail.repairlogo}"  style="width:62px; height:62px; border-radius:31px;"/>
 	 </c:otherwise>  
 </c:choose>
 </div>
 <div class="peak_right">${weixinGiftsetDetail.name}</div>
</div>
<div class="peck_down" style="background:${weixinGiftsetDetail.deepcolor};">
<c:if test="${weixinGiftsetDetail.cardtype!=1}">
 <div class="peck_down_left">
 
   <c:if test="${fn:length(weixinGiftsetDetail.providerepairname)>'9'}">  
                    ${fn:substring(weixinGiftsetDetail.providerepairname,0,9)}...  
            </c:if>  
            <c:if test="${fn:length(weixinGiftsetDetail.providerepairname)<='9'}">  
                ${weixinGiftsetDetail.providerepairname}  
            </c:if>  
 </div>
</c:if> 
<c:if test="${weixinGiftsetDetail.cardtype==1}">
 <div class="peck_down_left">&nbsp;&nbsp;</div>
</c:if> 
 <div class="peck_down_right">有效期至<fmt:formatDate value="${weixinGiftsetDetail.enddate}" type="date" dateStyle="medium"/></div>
</div>
</a>
</c:forEach>
<div style="height:20px;">&nbsp;</div>
<!-- 
<div style="height:10px;">&nbsp;</div>
<div class="peck_up">
 <div class="peak_left"><img src="images/peck_head.png"  style="width:62px; height:62px; border-radius:31px;"/></div>
 <div class="peak_right">29元代驾券</div>
</div>
<div class="peck_down">
 <div class="peck_down_left">建发车行</div>
 <div class="peck_down_right">有效期至2015-9-30</div>
</div> -->
</body>
<script >
$(document).ready(function(){
	  $("#aa").click(function(){
		  $("#gifts").toggle(1);
		  }); 
		  
	 //$("#gifts").toggle(1);	  
	
});
 
</script>

</html>
