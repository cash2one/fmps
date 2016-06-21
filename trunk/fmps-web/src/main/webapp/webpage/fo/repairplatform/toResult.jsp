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
 body{ background-color:#f5f5f5;}
 header {
  height: 0px;}
 .am-topbar {
  position: relative;
  min-height: 50px;
  margin-bottom: 0.1rem;}
 .peak_text_1{ font-family:"微软雅黑"; font-size:14px; color:#222222; width:80%; text-align:left; margin:0 auto; padding-top:1px;}
 .peak_text_2{ font-family:"微软雅黑"; font-size:12px; color:#222222; width:80%; text-align:center; margin:0 auto; line-height:40px;}
</style>
<body>

<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title">
      信息提示
    </h1>
  </header>
</header>

<div class="tips_center">
 <br />
 <br />
 <br />
 <div class="tips_center_img"><img src="${webRoot}/plug-in/fo/images/Pay_dui.jpg"  width="140" height="140"/></div>
 <br />
 <div class="tips_center_text">扫码完成</div>
 <br />
 <div style="background:#fff; border-bottom:#dedede 1px solid; border-top:#dedede 1px solid;">
  <div class="peak_text_1" style=" margin-top:5px;">时间： <fmt:formatDate value="${weixinGiftsetDetail.scandate }" pattern="yyyy-MM-dd HH:mm"/> </div>
  <div class="peak_text_1">商户： ${weixinGiftsetDetail.scanrepairname } </div>
  <div class="peak_text_1" style=" margin-bottom:5px;">消费： ${weixinGiftsetDetail.name } </div>
 </div>
 <br />
 <br />
 <div style="width:80%; margin:0 auto; background-color:#0e90d2; color:#FFFFFF; height:30px; line-height:30px; border-radius:5px;" onclick="evaluation();">评 价</div>
 <div style="height: 20px;">&nbsp;</div>
  <div style="display:none" id="evaluationflag" >${evaluationflag}</div>
</div>

<script>
function evaluation(){
	var evaluationflag=$("#evaluationflag").html();
	if(evaluationflag=='1'){
		var WeixinRepairName='${weixinGiftsetDetail.scanrepairname}';
		var WeixinRepairNameZ=escape(encodeURIComponent(WeixinRepairName)); //转码
	//location.href ="${webRoot}/fo/repairFactoryController.do?method=toResult&openid=${openid}&uuid=${uuid}&id=${id}"
		location.href = "${webRoot}/fo/repairFactoryController.do?method=evaluation&openid=${openid}&repairId=${weixinGiftsetDetail.scanrepairid }&repairname="+WeixinRepairNameZ;
	}else{
		alert("您没有在此维修厂修理过或者已经评论过，不能评价。 ");
	}
}


</script>

</html>
