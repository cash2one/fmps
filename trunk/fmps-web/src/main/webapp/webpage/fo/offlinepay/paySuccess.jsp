<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotagsforbrowser.jsp"%>
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
	border-bottom: 2px solid #0e90d2;
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

.pay_menoy {
	text-align: center;
}

.pay_menoy_tel {
	width: 80%;
	margin: 0 auto;
	color: #222;
	font-size: 16px;
}

.pay_text {
	width: 100%;
	text-align: center;
	padding-top: 2px;
}

.pay_service {
	text-align: center;
}

.pay_service_text {
	text-align: center;
	font-size: 11px;
	color: #999;
	width: 100%;
	padding-top: 26px;
	padding-bottom: 25px;
}

img {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0 /* 4 */;
}
</style>
</head>

<body>
	<div style="height: 41px;">&nbsp;</div>
	<div class="pay_menoy">
		<img src="${webRoot }/plug-in/fo/images/dui_icon.jpg" width="116"
			height="116" />
	</div>
	<div style="height: 18px;">&nbsp;</div>
	<div class="pay_menoy_tel">
		<div class="pay_text">保费已缴纳成功</div>
		<div style="height: 23px; border-bottom: 1px solid #e8e8e8;">&nbsp;</div>
		<div class="pay_service_text">关注“富邦财险”官方微信公众号进行保单查看</div>
		<div class="pay_service">
			<img src="${webRoot }/plug-in/fo/images/pay_service.jpg" />
		</div>
	</div>
</body>
</html>