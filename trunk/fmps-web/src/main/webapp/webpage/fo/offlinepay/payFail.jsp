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
	width: 85%;
	margin: 0 auto;
	color: #222;
	font-size: 16px;
}

.pay_text {
	width: 100%;
	text-align: center;
}

.pay_service {
	text-align: center;
}
</style>
</head>

<body>
	<div style="height: 41px;">&nbsp;</div>
	<div class="pay_menoy">
		<img src="${webRoot }/plug-in/fo/images/cuo_icon.jpg" width="116"
			height="116" />
	</div>
	<div style="height: 33px;">&nbsp;</div>
	<div class="pay_menoy_tel">
		<div class="pay_text">${message }</div>
	</div>
</body>
</html>