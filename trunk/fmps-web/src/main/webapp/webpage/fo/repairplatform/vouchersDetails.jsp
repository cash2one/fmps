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
.peck_instruction_left{ width:5%; float:left;}
.peck_instruction_right{ width:95%; float:left; border-bottom: 1px solid #e8e8e8; font-size:14px; color:#292929; font-family:"微软雅黑";}
.peck_instruction_text_1{ font-size:13px; font-family:"微软雅黑"; color:#292929; border-bottom:1px solid #e8e8e8; height:30px; clear:both; text-align:center;}
.peck_instruction_text_2{ font-size:13px; font-family:"微软雅黑"; color:#292929; border-bottom:1px solid #e8e8e8; height:70px; clear:both; text-align:left; padding-top:15px; padding-left:17px; }
.peck_instruction_text_3{ font-size:13px; font-family:"微软雅黑"; color:#292929; border-bottom:1px solid #e8e8e8; border-top:1px solid #e8e8e8; height:43px; line-height:40px; padding-left:17px;}
</style>
<body style="background:#f9f9f9;">
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; font-size:16px;">
    详情
  </h1>
</header>
<div style="background:#fff;">
<div style="height:13px; ">&nbsp;</div>
<c:if test="${content==null||content==''}">
<div style=" text-align:center; margin-left:auto; margin-right:auto; ">${message}</div>
</c:if>
<div class="peck_instruction">
 ${content }
</div>
<!-- <div style="height:20px; background:#f9f9f9;">&nbsp;</div>
<div class="peck_instruction_text_3">客服服务  <span style="float:right; padding-right:15px; color:#576b95;">4008-817-518</span></div>
 -->
</div>
</body>
</html>
