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
body{ background-color:#f5f5f5;}
.peak_money{ height:111px; background:#32b5f8;}
.peak_money2{ height:111px; background:url(${webRoot}/plug-in/repair/overdue.png) right top scroll no-repeat #32b5f8;}
.peak_money3{ height:111px; background:url(${webRoot}/plug-in/repair/use.png) right top scroll no-repeat #32b5f8;}

.peak_money_left{ float:left; width:22%; padding:26px 0px 0px 10px;}
.peak_money_right{ float:left; width:78%; text-align:left; color:#FFFFFF; padding-left:20px; padding-top:32px; font-family:"微软雅黑"; font-size:18px;}
.peak_money_erweima{ text-align:center; padding-top:25px;}
.peak_money_erweima_text{ text-align:center; font-family:"微软雅黑"; font-size:15px; color:#292929; padding-top:15px; border-bottom:1px solid #e8e8e8; padding-bottom:10px;}
.peak_money_button{ height:90px; border-bottom:1px solid #e8e8e8; border-top:1px solid #e8e8e8; font-family:"微软雅黑"; font-size:15px; color:#292929;}
.peak_money_button_text{ width:95%; border-bottom:1px solid #e8e8e8; margin-left:5%; padding-top:10px; padding-bottom:10px;}
.peak_money_button_text_1{  margin-left:5%; padding-top:10px; width:95%;}
</style>
<body>

<c:if test="${statusflag==1 }">
<div class="peak_money">
</c:if>
 <c:if test="${statusflag==2 }">
<div class="peak_money3">
</c:if>
 <c:if test="${statusflag==3 }">
<div class="peak_money2">
</c:if>
  <div class="peak_money_left">
  <c:choose>
  	<c:when test="${weixinGiftsetDetail.cardtype==1}">
 		<img src="${webRoot}/plug-in/repair/peck_head.png"  style="width:62px; height:62px; border-radius:31px;"/>
 	</c:when>
 	<c:when test="${weixinGiftsetDetail.cardtype==2}">
 		<c:if test="${weixinGiftsetDetail.repairlogo!=null&&weixinGiftsetDetail.repairlogo!=''}">
 			<img src="${weixinGiftsetDetail.repairlogo}"  style="width:60px; height:60px; border-radius:30px;"/>
 		</c:if> 
 	</c:when>
  </c:choose>
  
  </div>
  <c:if test="${weixinGiftsetDetail.cardtype==5 }">
  <div class="peak_money_right">${weixinGiftsetDetail.name}<div style=" text-align:left; font-size:11px; padding-top:5px;">有效期至:<fmt:formatDate value="${weixinGiftsetDetail.startdate}" type="date" pattern="yyyy-MM-dd hh:mm" dateStyle="medium"/>--<fmt:formatDate value="${weixinGiftsetDetail.enddate}" type="date" pattern="hh:mm" dateStyle="medium"/></div></div>
  </c:if>
  <c:if test="${weixinGiftsetDetail.cardtype!=5 }">
  <div class="peak_money_right">${weixinGiftsetDetail.name}<div style=" text-align:left; font-size:11px; padding-top:5px;">有效期至:<fmt:formatDate value="${weixinGiftsetDetail.enddate}" type="date" pattern="yyyy-MM-dd" dateStyle="medium"/></div></div>
  </c:if>
 </div>
 <div style="background:url(${webRoot}/plug-in/repair/peck_circle.png) scroll repeat-x top left; height:5px; width:100%; margin-top:-4px;">&nbsp;</div>
 <div style="background-color:#FFFFFF;">
 <c:if test="${statusflag==1 }">
   <div class="peak_money_erweima">
   <c:if test="${newCarFlag!=1}"> 
     <img id="QRcode" src="${webRoot}/fo/binded/repairFactoryGiftController.do?getGitQRcode&openid=${openid}&uuid=${uuid}&id=${weixinGiftsetDetail.id}" width="170" height="170" />
   </c:if> 
   <c:if test="${newCarFlag==1}">
    <img id="QRcode" src="${webRoot}/plug-in/cashcoupon/images/weixincar.jpg" width="" height="" />
   </c:if> 
   </div>
 
  <div class="peak_money_erweima_text">
  <c:if test="${newCarFlag!=1}">
         使用时请直接出示给工作人员
    <br />
    </c:if>
 
     <c:if test="${newCarFlag==1}">
     <div style="text-align: center; font-size: 14px;">您是新车，请先点击<a href="${webRoot}/fo/binded/customerNewCarLicenceController.do?method=getCustomerNewCarLicence&openid=${openid}"><span style="color:#32b5f8;">新车上牌</span></a>才能使用此券</div>
     </c:if> 
  </div>
  </c:if>  
 <div style="height:14px; background-color:#f5f5f5;">&nbsp;</div>
 <div class="peak_money_button">
  <a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=vouchersDetails&id=${weixinGiftsetDetail.id}&openid=${openid}"><div class="peak_money_button_text">详情 <span style="float:right; padding:5px 10px 0px 0px;"><img src="${webRoot}/plug-in/repair/right.png" width="8" height="15" /></span></div></a>
  
  <c:if test="${weixinGiftsetDetail.cardtype==1}">
  <a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=useStore&id=${weixinGiftsetDetail.id}&openid=${openid}"><div class="peak_money_button_text_1">使用门店 <span style="float:right; padding:5px 10px 0px 0px;"><img src="${webRoot}/plug-in/repair/right.png" width="8" height="15" /></span></div></a>
  </c:if>
  
  <c:if test="${weixinGiftsetDetail.cardtype!=1}">
  <a href="${webRoot}/fo/carHomeController.do?method=merchantList&id=${weixinGiftsetDetail.id}&openid=${openid}&cardtype=${weixinGiftsetDetail.cardtype}"><div class="peak_money_button_text_1">使用门店 <span style="float:right; padding:5px 10px 0px 0px;"><img src="${webRoot}/plug-in/repair/right.png" width="8" height="15" /></span></div></a>
  </c:if>
  
 </div>
 </div>
</body>
<script>
//每5秒ajax 检查memcache key=uuid , value=2(已扫码)
setInterval("checkMemcache()", 5000); //5秒执行一次checkMemcache函数。
function checkMemcache()
{
	//var uuid = document.getElementById("uuid").value;
	//alert("uuid "+uuid);
	var uuid='${uuid}';
	 $.ajax({
			type: "POST",
			url : "${webRoot}/fo/binded/repairFactoryGiftController.do?method=qRcodeajax&id=${weixinGiftsetDetail.id}&openid=${openid}",
			data:{uuid:uuid},
			dataType: "json",
			success: function(data){
				if(data=="1"){
					location.href ="${webRoot}/fo/binded/repairFactoryGiftController.do?method=toResult&openid=${openid}&uuid=${uuid}&id=${weixinGiftsetDetail.id}&uuid=${uuid}" 
				}
				if(data=="2"){
					location.href ="${webRoot}/fo/binded/repairFactoryGiftController.do?method=qRcodeFailcommon&id=${weixinGiftsetDetail.id}&openid=${openid}" 
				}
				
			}
	});

}


/*  wx.config(${JSONString});
//1.判断当前版本是否支持指定 JS 接口，支持批量判断
 wx.ready(function () {
	 wx.getLocation({
		    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
		    success: function (res) {
		        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
		        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
		        var speed = res.speed; // 速度，以米/每秒计
		        var accuracy = res.accuracy; // 位置精度
		    }
		});
  });  */




</script>
</html>
