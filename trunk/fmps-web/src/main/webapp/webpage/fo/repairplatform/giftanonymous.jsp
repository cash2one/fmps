<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>礼包</title>
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
 img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
}
.am-header-default .am-header-nav > a{ color:#222222;}
.peak_no{ text-align:center;}
.peak_no_text{ font-family:"微软雅黑"; font-size:18px; text-align:center; color:#818181; padding-top:30px;}
.peak_no_text_1{font-family:"微软雅黑"; font-size:15px; text-align:center; color:#818181; padding-top:13px;}
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
 <div id="gifts"  style="display:none; position: absolute; float: right; width: 100%;"><a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=InvalidgiftList&openid=${openid}" class="" >
<span class="am-btn am-btn-primary btn-loading-example" style="float: right;" >无效礼包</span></a></div>
  
<div style="height:20px;">&nbsp;</div>
<div class="peak_no" ><img   src="${webRoot}/plug-in/repair/peak_no.jpg" /></div>
<div class="peak_no_text">当前暂无礼包</div>
<div class="peak_no_text_1">关注服务号活动，福利享不停！</div>
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




