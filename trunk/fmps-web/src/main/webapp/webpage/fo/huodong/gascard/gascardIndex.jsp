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
	margin-top: 20px;
}

.eleven_illustrate_1 {
	font-size: 11px;
	text-align: left;
	color: #cf0004;
	float: left;
	width: 100%;
	padding-top: 25px;
	padding-bottom: 20px;
}

.eleven_illustrate_1 .text_1 {
	float: left;
	width: 3%;
}

.eleven_illustrate_1 .text_2 {
	float: left;
	width: 97%;
}

.eleven_illustrate_3 {
	font-size: 12px;
	text-align: left;
	color: #222;
	float: left;
	width: 97%;
	padding-top: 8px;
	padding-bottom: 8px;
	border-bottom: 1px solid #e8e8e8;
	border-top: 1px solid #e8e8e8;
}

.eleven_illustrate_3 .text_1 {
	float: left;
	width: 100%;
}

.eleven_illustrate_4 {
	font-size: 12px;
	text-align: left;
	color: #222;
	float: left;
	width: 97%;
	padding-top: 8px;
	padding-bottom: 8px;
	border-bottom: 1px solid #e8e8e8;
}

.eleven_illustrate_4 .text_1 {
	width: 80%;
	float: left;
}

.eleven_illustrate_4 .text_2 {
	width: 17%;
	float: left;
	text-align: right;
	padding-top: 2px;
}

.eleven_img {
	padding: 10px 0px 10px 0px;
	width: 42%;
	clear: both;
}

.eleven_img_text {
	background: #fcfbfb;
	border: 1px solid #ffc000;
	border-radius: 10px;
	font-size: 11px;
	text-align: left;
	padding: 10px 10px;
	line-height: 25px;
}

.pop_text_date {
	text-align: center;
	color: #ff2711;
	font-size: 12px;
}

.pop_table {
	text-align: center;
	font-size: 12px;
	color: #37312e;
	border: 0px solid #f2eeec;
	line-height: 29px;
}

.pop_bottom_bg {
	background-color: #f2eeec;
	border-radius: 10px 10px 10px 10px;
	height: 100px;
}

.pop_title_1 {
	font-size: 15px;
	color: #37312e;
	text-align: left;
	padding-top: 15px;
}

.pop_title_text_1 {
	font-size: 13px;
	color: #27213e;
	text-align: left;
	line-height: 26px;
}

#mcover {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.8);
	display: none;
	z-index: 20000;
}
</style>
<script type="text/javascript">
	function hasPhonenum() {
		var phonenum = $("#phonenum").val();
		if (phonenum == '') {
			alert('您未输入手机号码，您的朋友将无法帮你抢油卡');
		}
	}

	function weChat() {
		$("#mcover").css("display", "none"); // 点击弹出层，弹出层消失
	}
	function block() {
		$("#mcover").css("display", "block"); // 分享给好友圈按钮触动函数
	}
	function savephonenum() {
		var re = /^1[0-9]{10}$/;
		var phonenum = $("#phonenum").val();
		var huodongid = $("#huodongid").val();
		var openid = $("#openid").val();
		if (phonenum == "" || phonenum == null) {
			alert('手机号码不能为空');
			return;
		}
		if (!re.test(phonenum)) {
			alert('手机号码格式不对');
			return;
		}
		$
				.ajax({
					type : 'POST',
					url : "${webRoot}/fo/gasCardController.do?savephonenum",
					data : {
						openid : openid,
						phonenum : phonenum
					},
					dataType : "json",
					error : function() {// 请求失败处理函数
						alert('请求失败！');
					},
					success : function(json) {
						if (json == "0") {
							$("#inputphonenum").css("display", "none");
							$("#takehelp").css("display", "block");
							$("#mcover").css("display", "block");
							shareurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FgasCardController.do%3FhelpIndex%26huodongid%3D8a828ebb49166847014916deca570006%26sponsor%3D${openid}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
							shareinit();
						} else if (json == "1") {
							alert("您输入的手机号已绑定其他微信号");
						}
					}
				});

	}
	var shareurl = '';
	var code='<%=request.getParameter("code")%>';
	$(document).ready(function() {		
		var endtime='2016-11-14 00:00:00';
		var time_now = new Date().getTime(); //设定当前时间
		var time_end =  new Date(endtime.replace(/-/g, "/")).getTime(); //设定目标时间		
		if(time_now>time_end){
			$("#gameover").css("display", "block");
		}else{
			var $modal = $('#my-modal-loading');
			$modal.modal('open');
			var phonenum = '${phonenum}';
			if (phonenum != '') {
				$("#takehelp").css("display", "block");
				shareurl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FgasCardController.do%3FhelpIndex%26huodongid%3D8a828ebb49166847014916deca570006%26sponsor%3D${openid}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
			} else {
				$("#inputphonenum").css("display", "block");
				shareurl = "";
			}
			$.ajax({
				type : 'POST',
				url : "${webRoot}/fo/dobule11Controller.do?JsdkString",
				data : "&attachurl=%2Ffo%2FgasCardController.do%3FgasCardIndex%26id%3D8a828ebb49166847014916deca570006%26code="+code+"%26state=STATE",
				dataType : "json",
	        	error : function() {// 请求失败处理函数
	        		$modal.modal('close');
					alert('获取初始化信息失败，请稍候重试.');
				},
				success : function(json) {
					var result = "fail";
					if (json.success&&json.obj.length>5) {						
						var jssdk = eval('(' + json.obj + ')');
						wx.config(jssdk);					
				 		wx.ready(function () { 
							shareinit();
							setTimeout('closemodel()',500);	
						});  
						wx.error(function (res) {
							$modal.modal('close');
							alert('页面加载异常，请稍后重试.');	
						});
										
					} else {
						alert('页面加载异常，请稍后重试.');						 				
					}
				}
			});
		}
	});
	
	function closemodel(){
		var $modal = $('#my-modal-loading');
		$modal.modal('close');
	}
	
	function gotoRankList() {
		location.href = "${webRoot}/fo/gasCardController.do?showRankList&huodongid=${huodongid}&openid=${openid}";
	}
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
	<input type="hidden" id="shareurl" name="shareurl" value="">
	<input type="hidden" id="huodongid" name="huodongid"
		value="${huodongid}">
	<input type="hidden" id="openid" name="openid" value="${openid}">
	<div id="mcover" onclick="weChat()" style="display: none;">
		<img style="" src="${webRoot}/plug-in/fo/images/guide.png" />
	</div>
	<div class="eleven_card">
		<div class="eleven_top">
			<img src="${webRoot}/plug-in/fo/images/oil_top.png" />
		</div>
		<div id="inputphonenum" style="display: none;">
			<div class="eleven_input">
				<input id="phonenum" name="phonenum" type="text"
					placeholder="请输入正确的手机号码" style="border: dashed #cf0004 1px;"
					value="${phonenum }" />
			</div>
			<div class="eleven_button_1" onclick="savephonenum()">
				<img src="${webRoot}/plug-in/fo/images/oil_button.png" />
			</div>
			<div class="eleven_illustrate_1">
				<div class="text_1">*</div>
				<div class="text_2">请您务必输入准确的手机号码，便于工作人员联系奖品上门领取事宜。</div>

			</div>
		</div>
		<div id="takehelp" style="display: none;">
			<div class="eleven_button_1" onclick="block()">
				<img src="${webRoot}/plug-in/fo/images/oil_button.png" />
			</div>
			<div class="eleven_illustrate_1">
				<div class="text_1">*</div>
				<div class="text_2">
					11.11-11.13 期间召集好友帮忙，抢油卡现金券<br />
				</div>
			</div>
		</div>
		<div id="gameover" style="display: none;">
			<div class="eleven_button_1" >
				<img src="${webRoot}/plug-in/fo/images/oil_over_button.png" />
			</div>
			<div class="eleven_illustrate_1">
				<div class="text_1">*</div>
				<div class="text_2">
					11.11-11.13 期间召集好友帮忙，抢油卡现金券<br />
				</div>
			</div>
		</div>
		<div class="eleven_illustrate_3">
			<div class="text_1">好友助力：${cnt}</div>
		</div>
		<div class="eleven_illustrate_4" onclick="gotoRankList();">
			<div class="text_1">助力排行榜</div>
			<div class="text_2">
				<img src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="13" />
			</div>
		</div>
		<div class="eleven_illustrate_5">
			<div class="eleven_img">
				<img src="${webRoot}/plug-in/fo/images/pop_top_1.png" />
			</div>
		</div>
		<div class="eleven_illustrate_6">
			<div class="eleven_img_text">
				<span style="font-size: 14px; font-weight: 700;">活动时间：</span><br />
				11月11日9时-11月13日24时<br /> <span
					style="font-size: 14px; font-weight: 700; margin-top: 5px;">参与方式：</span><br />
				客户通过点“我要抢油卡”转发朋友助力抢油卡，助力 好友数前100名可获得加油卡，第101-400可获得100
				元现金抵用券，助力排名以最终公布结果为准。<br /> <span
					style="font-size: 14px; font-weight: 700;">活动限制：</span><br />
				每个手机号、微信号仅限有效参与活动一次，如有作弊 ，将取消参与活动资格。<br /> <span
					style="font-size: 14px; font-weight: 700">奖品说明：</span><br />
				油卡须上门领取，仅限厦门、泉州、漳州、福州、成都 五个城市。<br /> <span
					style="font-size: 14px; font-weight: 700">具体上门位置请点击：<a
					href="${webRoot}/fo/serviceBranch.do?list&openid=${openid}">服务网点</a></span><br />
				现金券可在线下抵用合作商家所有服务费 (合作商家为 富邦维修商城里所有维修商家）
			</div>
		</div>


	</div>
	<div style="text-align: center;">
		<img src="${webRoot}/plug-in/fo/images/oil_bg.png" />
	</div>
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">加载中，请稍候...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>
</body>
</html>