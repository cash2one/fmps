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
	width: 75%;
	margin: 0 auto;
	color: #222;
	font-size: 16px;
}

.pay_text {
	width: 100%;
	text-align: center;
}

.pay_button_1 {
	border-radius: 3px;
	border: 1px solid #0f90d2;
	width: 180px;
	margin: 0 auto;
	text-align: center;
	font-size: 14px;
	color: #0f90d2;
	padding-top: 6px;
	padding-bottom: 6px;
}

.pay_menoy_text {
	font-size: 12px;
	color: #919090;
	margin: 0 auto;
	width: 75%;
	text-align: center;
}

.pay_menoy_text_2 {
	width: 75%;
	margin: 0 auto;
	color: #919090;
	font-size: 12px;
	text-align: center;
}

.pay_service {
	text-align: center;
	width: 80%;
	margin: 0 auto;
}

.pay_service_text {
	text-align: left;
	font-size: 11px;
	color: #999;
	width: 80%;
	padding-top: 26px;
	padding-bottom: 22px;
	margin: 0 auto;
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
<script type="text/javascript">
	function personcenter() {
		location.href="${webRoot}/fo/binded/personalCenterController.do?method=Index&openid=${openid}";
	}
</script>
</head>
<body>

	<div style="height: 41px;">&nbsp;</div>
	<div class="pay_menoy">
		<img src="${webRoot }/plug-in/fo/images/dui_icon.jpg" width="116"
			height="116" />
	</div>
	<div style="height: 20px;">&nbsp;</div>
	<div class="pay_menoy_tel">
		<div class="pay_text">保单已缴纳成功</div>
	</div>
	<div style="height: 12px;">&nbsp;</div>
	<div style="height: 20px;">&nbsp;</div>
	<div class="pay_button_1" onclick="personcenter();">进入个人中心</div>
	<div style="height: 5px;">&nbsp;</div>
	<div class="pay_service_text">微信认证后，您可以体验以下服务：</div>
	<div class="pay_service">
		<img src="${webRoot }/plug-in/fo/images/pay_service.jpg" />
	</div>
</body>
</html>