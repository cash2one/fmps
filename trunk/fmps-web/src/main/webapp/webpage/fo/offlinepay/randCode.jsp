<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotagsforbrowser.jsp"%>
<style type="text/css">
body {
	background-color: #fff;
}

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

img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

.pay {
	width: 90%;
	margin: 0 auto;
}

.pay_top_text {
	text-align: left;
	font-size: 12px;
	font-family: "微软雅黑";
	width: 90%;
	margin: 0 auto;
	padding-top: 22px;
}

.pay_text {
	width: 29%;
	float: left;
	font-size: 16px;
}

.pay_input {
	width: 70%;
	float: left;
}

input {
	border-bottom: 1px solid #dedede;
	border-left: 0px solid #dedede;
	border-right: 0px solid #dedede;
	border-top: 0px solid #dedede;
	height: 21px;
	width: 100%;
	text-align: left;
}

.validate {
	width: 90%;
	margin: 0 auto;
}

.validate_text {
	width: 29%;
	float: left;
	font-size: 16px;
}

.validate_input {
	width: 50%;
	float: left;
}

.validate_letter {
	width: 20%;
	float: left;
	font-size: 20px;
	margin-top: 3px;
	text-align: right;
}

.pay_button {
	border-radius: 5px;
	background-color: #0e90d2;
	color: #fff;
	font-size: 18px;
	text-align: center;
	height: 47px;
	width: 90%;
	margin: 0 auto;
	line-height: 43px;
}

.am-topbar-inverse {
	background-color: #fff;
	border-color: #fff;
}

header {
	height: 50px;
	line-height: 20px;
}
</style>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default">
	<h1 class="am-header-title" style="color: #171717;">保费支付</h1>
	</header>

	<form class=" am-form-horizontal" name="payForm" id="payForm"
		action="${webRoot}/pay/payController.do?showPolicy&payCode=${payCode }&paytype=${paytype }"
		check="${webRoot}/pay/payController.do?checkRandCode" method="post">
		<input type="hidden" id="paytype" name="paytype" value="${paytype }" />
		<div class="pay_top_text">您好！感谢选择富邦财险，输入以下信息进入支付页面</div>
		<div style="height: 58px; clear: both;">&nbsp;</div>
		<div class="validate">
			<div class="validate_text">验 证 码</div>
			<div class="validate_input">
				<input class="randCode" style="font-size: 14px;" name="randCode"
					type="text" maxlength="4" id="randCode" title=""
					placeholder="请输入验证码" />
			</div>
			<div class="validate_letter">
				<img id="randCodeImage"
					src="${webRoot}/plug-in/login/images/preloader.gif" alt="验证码" />
			</div>
		</div>
		<div class="pay_page_tips" id="alertMessage"
			style="color: red; clear: both; text-align: center;"></div>
		<div style="height: 50px; clear: both;">&nbsp;</div>
		<div class="pay_button" id="paySub">确 &nbsp;&nbsp;&nbsp;认</div>
		<div style="height: 190px;">&nbsp;</div>
	</form>
	<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
	<div style="height: 50px;">
		<div><img src="${webRoot }/plug-in/fo/images/logo_bottom.jpg" width="320" height="38" /></div>
		<div style=" text-align: center; font-size: 12px; color: #222; width: 100%;">版权所有：富邦财产保险有限公司</div>
	</div>
	</header>
	<script type="text/javascript">
		$().ready(function() {
			reloadRandCodeImage();
			$('#paySub').click(function() {
				var actionurl = $('form').attr('action');//提交路径
				var checkurl = $('form').attr('check');//验证路径
				var randCode = $("#randCode").val();
				$.ajax({
					type : 'POST',
					url : checkurl,// 请求的action路径
					data : {
						randCode : randCode
					},
					dataType : "json",
					error : function() {// 请求失败处理函数
						showError('请求失败！');

					},
					success : function(json) {
						if (json.success) {
							location.href = actionurl;
						} else {
							showError(json.msg);
						}
					}
				});
			});

			$('#randCodeImage').click(function() {
				reloadRandCodeImage();
				$('#alertMessage').html('');
				$('#randCode').val('');
			});

		});
		//刷新验证码
		function reloadRandCodeImage() {
			var date = new Date();
			var img = document.getElementById("randCodeImage");
			img.src = '${webRoot}/randCode.do?genCode&randCode=${openid}&a='
					+ date.getTime();
		}
		//显示错误提示
		function showError(str) {
			$('#alertMessage').addClass('error').html(str);
		}
	</script>
</body>
</html>
