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
.pay_message {
	width: 75%;
	margin: 0 auto;
	color: #919090;
	font-size: 12px;
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

.option-input {
	-webkit-appearance: none;
	-moz-appearance: none;
	-ms-appearance: none;
	-o-appearance: none;
	appearance: none;
	position: relative;
	width: 20px;
	height: 20px;
	background: #fff;
	color: #fff;
	cursor: pointer;
	vertical-align: bottom;
}

.option-input:checked::before {
	width: 20px;
	height: 20px;
	position: absolute;
	content: '\2713';
	display: inline-block;
	font-size: 18px;
	text-align: center;
	line-height: 20px;
	background-color: #fff;
	color: #0e90d2;
	border: 1px solid #0e90d2;
	margin-left: -1px;
	margin-top: -1px;
	outline: none;
	position: relative;
	margin-right: 0.5rem;
	z-index: 1000;
}

.option-input:checked::after {
	background: #fff;
	content: '';
	display: block;
	position: relative;
	z-index: 100;
}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		if('${isbinded}'=="YES"){
			$("#bind").css("display", "none");
		}
	});
	function personcenter() {
		var customerbind = $("#customerbind").val();
		if (customerbind == "autobind") {
			$.ajax({
				async: false,
				type : 'POST',
				url : "${webRoot}/fo/taiwanController.do?customerbind",
				data : $('#resultform').serialize(),
				dataType : "json",
				error : function() {// 请求失败处理函数
					alert('自动认证失败！');
				},
				success : function(json) {
					if(json.success){
					}
				}
			});
		}
		location.href = "${webRoot}/fo/binded/personalCenterController.do?method=Index&openid=${openid}";
	}
	function check(obj) {
		if (obj.checked == true) {
			$("#customerbind").val("autobind");
		} else {
			$("#customerbind").val("");
		}
	}
</script>
</head>
<body>
	<form id="resultform">
		<input type="hidden" id="customerbind" name="customerbind"
			value="autobind" /> <input type="hidden" id="openid" name="openid"
			value="${openid }" /> <input type="hidden" id="appliName"
			name="appliName" value="${appliName }" /> <input type="hidden"
			id="appliIdentifyType" name="appliIdentifyType"
			value="${appliIdentifyType }" /> <input type="hidden"
			id="appliIdentifyNumber" name="appliIdentifyNumber"
			value="${appliIdentifyNumber }" />
		<div style="height: 41px;">&nbsp;</div>
		<div class="pay_menoy">
			<img src="${webRoot }/plug-in/fo/images/dui_icon.jpg" width="116"
				height="116" />
		</div>
		<div style="height: 20px;">&nbsp;</div>
		<div class="pay_menoy_tel">
		   <c:if test="${underwriting =='online'}">
			<div class="pay_text">保单已购买成功</div>	 
           </c:if>
		   <c:if test="${underwriting =='offline'}">
			<div class="pay_text">保费预支付成功</div>	 
           </c:if>			 
		</div>
		<div class="pay_message">
		    <c:if test="${underwriting =='online'}">
			<div class="pay_text">系统将在24小时内完成承保，请留意富邦微信号的承保通知</div>	 
           </c:if>
		   <c:if test="${underwriting =='offline'}">
			<div class="pay_text">因系统更新中，此功能目前仅提供保费支付，我们将有服务人员与您联系，进行投保资料确认，谢谢！</div>	 
           </c:if>
		</div>
		<div style="height: 12px;">&nbsp;</div>
		<div id="bind" class="pay_menoy_text_2">
			<input type="checkbox" onchange="check(this)"
				class="option-input checkbox" style="border: 1px solid #0e90d2;"
				checked="checked" /> 我是本人，自动认证富邦微信身份
		</div>
		<div style="height: 20px;">&nbsp;</div>
		<div class="pay_button_1" onclick="personcenter();">进入个人中心</div>
		<div style="height: 5px;">&nbsp;</div>
		<div class="pay_service_text">微信认证后，您可以体验以下服务：</div>
		<div class="pay_service">
			<img src="${webRoot }/plug-in/fo/images/pay_service.jpg" />
		</div>
	</form>
</body>
</html>