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
.shop_text{ font-size:15px; font-family:"微软雅黑"; color:#818181; padding:0 15px;}
.shop_button{ height:45px; background-color:#0e90d2; color:#fff; font-family:"微软雅黑"; font-size:20px; text-align:center; width:90%; margin:0 auto; border-radius:3px; padding-top:5px;}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; font-size:16px;">
    使用门店
  </h1>
</header>
<div style="height:40px;">&nbsp;</div>
<div class="shop_text">你的券可在爱车之家${weixinGiftsetDetail.areaName}地区商户通用，请直接至爱车之家挑选商户</div>
<div style="height:45px;">&nbsp;</div>
<a href="${webRoot}/fo/carHomeController.do?method=merchantList&id=${id}&openid=${openid}&citygift=${weixinGiftsetDetail.areaName}&cardtype=${weixinGiftsetDetail.cardtype}"><div class="shop_button">爱车之家</div></a>
</body>
</html>
