<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title></title>
<style type="text/css">
.am-with-topbar-fixed-bottom {
	padding-bottom: 0px;
}

.am-popup-inner {
	padding-top: 0px;
	margin-top: 50px;
}

.am-topbar-inverse {
	background-color: #fff;
	border-color: #fff;
	color: #eeeeee;
}

.am-topbar {
	min-height: 50px;
	background: #fff;
	border-width: 0 0 0px;
	border-style: solid;
	border-color: #fff;
	color: #ffffff;
}

.am-popup {
	position: fixed;
	left: 5%;
	top: 5%;
	width: 90%;
	height: 80%;
	z-index: 1110;
	display: none;
	overflow: hidden;
	-webkit-transition-property: -webkit-transform;
	transition-property: transform;
	-webkit-transform: translateY(100%);
	-ms-transform: translateY(100%);
	transform: translateY(100%);
	margin: 0 auto;
}

.am-popup-hd {
	position: fixed;
	top: 0px;
	width: 100%;
	height: 43px;
	border-bottom: 0px solid #dedede;
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0 !important;
}

.am-popup-bd {
	padding: 10px;
	background: #f2eeec;
	color: #555555;
	border-radius: 10px 10px 0px 0px;
	min-height: 360px;
}

.am-popup-bd_2 {
	padding: 20px;
	background: #f2eeec;
	color: #555555;
	border-radius: 10px 10px 0px 0px;
	min-height: 360px;
}

body {
	background-color: #f4f1f0;
}

img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

input {
	text-align: center;
	height: 35px;
	width: 70%;
	background-color: #f4f1f0;
}

.eleven_card {
	padding: 0 20px;
}

.eleven_top {
	text-align: center;
	margin-top: 24px;
}

.eleven_input {
	text-align: center;
	font-size: 12px;
	margin-top: 25px;
}

.eleven_button_1 {
	text-align: center;
	width: 70%;
	margin: 0 auto;
	margin-top: 25px;
}

.eleven_button_2 {
	text-align: center;
	width: 100%;
	margin: 0 auto;
	margin-top: 25px;
	padding-bottom: 25px;
}

.button_nbsp {
	float: left;
	width: 7%
}

.button_img {
	float: left;
	width: 15%;
	text-align: center;
}

.button_text {
	float: left;
	width: 73%;
	text-align: center;
}

.eleven_illustrate_1 {
	font-size: 11px;
	text-align: center;
	color: #cf0004;
	float: left;
	width: 100%;
	padding-top: 25px;
}

.eleven_illustrate_2 {
	font-size: 11px;
	text-align: center;
	color: #222;
	float: left;
	width: 100%;
	padding-top: 8px;
	padding-bottom: 20px;
}

.eleven_erweima {
	text-align: center;
	width: 60%;
	margin: 0 auto;
}

.oil_bg {
	background: url(${webRoot}/plug-in/fo/images/oil_bg.png) bottom right
		no-repeat;
	background-size: 100% 100%;
	min-height: 200px;
}
</style>
<script type="text/javascript">
function take(){
	var openid=$("#openid").val();
	var sponsor=$("#sponsor").val();
	if(openid==sponsor){
		alert('自己不能帮自己抢!');		
		return;
	}
	var huodongid=$("#huodongid").val();
	$.ajax({
		type : "POST",
		url : "${webRoot}/fo/gasCardController.do?help",
		data : {
			openid : openid,
			huodongid : huodongid,
			sponsor:sponsor
		},
		dataType : "json",
		success : function(data) {
			if (data == "0") {				
				setTimeout('closemodel()',500);				
			} else if (data == "1") {
				alert('自己不能帮自己抢!');
				closemodel();
			} else if (data == "2") {
				$("#help").css("display","none");
				$("#helped").css("display","block");
			}
		}
	});
}

function closemodel(){
	var $modal = $('#my-modal-loading');
	$modal.modal('close');
	//alert('帮抢成功!');
	$("#help").css("display","none");
	$("#helped").css("display","block");
}
var shareurl = '';
var code='<%=request.getParameter("code")%>';
$(document).ready(function(){ 
	var helpflag=$("#helpflag").val();
	if(helpflag=="1"){
		location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FgasCardController.do%3FgasCardIndex%26id%3D8a828ebb49166847014916deca570006&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	}else if(helpflag=="2"){
		$("#help").css("display","none");
		$("#helped").css("display","block");
	}
	shareurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FgasCardController.do%3FhelpIndex%26huodongid%3D${huodongid}%26sponsor%3D${sponsor}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	$.ajax({
		type : 'POST',
		url : "${webRoot}/fo/dobule11Controller.do?JsdkString",
		data : "&attachurl=%2Ffo%2FgasCardController.do%3FhelpIndex%26huodongid%3D8a828ebb49166847014916deca570006%26sponsor%3D${sponsor}%26code="+code+"%26state=STATE",
		dataType : "json",
    	error : function() {// 请求失败处理函数
			alert('获取初始化信息失败，请稍候重试.');
		},
		success : function(json) {
			var result = "fail";
			if (json.success&&json.obj.length>5) {						
				var jssdk = eval('(' + json.obj + ')');
				wx.config(jssdk);					
		 		wx.ready(function () { 
					shareinit();
				});  
				wx.error(function (res) {	
					alert('页面加载异常，请稍后重试.');	
				});
								
			} else {
				alert('页面加载异常，请稍后重试.');						 				
			}
		}
	});
});
function shareinit() {
	//2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
	wx.onMenuShareAppMessage({
		title : '富邦财险双11五城百店同庆',
		desc : '油卡送不停，手快有手慢无',
		link : shareurl,
		imgUrl : '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
		trigger : function(res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击发送给朋友');
		},
		success : function(res) {
			hasPhonenum()
			//alert('已发送给朋友');
		},
		cancel : function(res) {
			//alert('已取消发送给朋友');
		},
		fail : function(res) {
			alert(JSON.stringify(res));
		}
	});

	// 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
	wx.onMenuShareTimeline({
		title : '富邦财险双11五城百店同庆，油卡送不停，手快有手慢无',
		link : shareurl,
		imgUrl : '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
		trigger : function(res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击分享到朋友圈');
		},
		success : function(res) {
			hasPhonenum()
			//alert('已分享朋友圈');
		},
		cancel : function(res) {
			//alert('已取消分享朋友圈');
		},
		fail : function(res) {
			alert(JSON.stringify(res));
		}
	});
}
</script>
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid}">
	<input type="hidden" id="sponsor" name="sponsor" value="${sponsor}">
	<input type="hidden" id="huodongid" name="huodongid"
		value="${huodongid}">
	<input type="hidden" id="helpflag" name="helpflag" value="${helpflag}">
	<div class="eleven_card">
		<div class="eleven_top">
			<img src="${webRoot}/plug-in/fo/images/oil_top.png" />
		</div>
		<div class="eleven_button_2">
			<div class="button_nbsp">&nbsp;</div>
			<div class="button_img">
				<img src="${userinfo.headimgurl }" style="border-radius: 5px;" />
			</div>
			<div class="button_text">
				<img src="${webRoot}/plug-in/fo/images/eleven_tips.png" />
			</div>
		</div>
		<div style="height: 15px;">&nbsp;</div>
		<div id="help" class="eleven_button_1" onclick="take();"
			data-am-modal="{target: '#my-modal-loading'}">
			<img src="${webRoot}/plug-in/fo/images/oil_button_3.png" />
		</div>
		<div id="helped" class="eleven_button_1" style="display: none;">
			<img src="${webRoot}/plug-in/fo/images/oil_button_4.png" />
		</div>
		<div class="eleven_illustrate_1">* 11.11-11.13 期间召集好友帮忙，抢油卡现金券</div>
		<div style="height: 30px; clear: both;">&nbsp;</div>
		<div class="eleven_erweima">
			<img src="${webRoot}/plug-in/fo/images/eleven_erweima.png" />
		</div>
		<div class="eleven_illustrate_2">活动公众号：富邦财险</div>
	</div>

	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">帮抢中...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>
</body>
</html>