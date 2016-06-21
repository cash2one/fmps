<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<head>
<title></title>
<style type="text/css">
body {
	background: #f0efdd;
}

input {
	border: 0px;
	color: #fff;
}

.red_Contact_bg {
	background: url(../plug-in/cashcoupon/images/red_Contact_bg.jpg)
		no-repeat scroll left top;
	background-size: contain;
	height: 525px;
	width: 320px;
	margin: 0 auto;
}

.red_Contact {
	width: 75%;
	margin: 0 auto;
}

.red_Contact_input {
	font-size: 12px;
	color: #fff;
	float: left;
	width: 75%;
}

.red_Contact_Verification {
	float: left;
	width: 25%;
	background-color: #fde662;
	color: #740101;
	font-size: 12px;
	height: 20px;
	text-align: center;
	font-weight: 700;
	line-height: 20px;
}

.red_Contact_Verification_2 {
	clear: both;
	color: #FFFFFF;
	font-size: 12px;
	width: 75%;
	margin: 0 auto;
	padding-top: 20px;
}

img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

header {
	height: 45px;
	line-height: 45px;
	text-align: center;
	background: #303e49;
}

.am-topbar {
min-height: 0px;
background: #f0efdd;
border-width: 0 0 1px;
border-style: solid;
border-color: #f0efdd;
margin-bottom: 0rem;
}
</style>
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid}" />
	<input type="hidden" id="huodongid" name="huodongid"
		value="${huodongid}" />
	<input type="hidden" id="webRoot" name="webRoot" value="${webRoot}" />
	<input type="hidden" id="fromtag" name="fromtag" value="${fromtag}" />
	<div class="red_Contact_bg">
		<div style="height: 180px;">&nbsp;</div>
		<div class="red_Contact">
			<div class="red_Contact_input">
				联系方式：<input name="phonenum" id="phonenum" type="text" size="15"
					style="background-color: transparent; border-bottom: 1px solid #fff; height: 25px;" />
			</div>
			<div class="red_Contact_Verification"
				onclick="sendDynamicPassword(this, $('#phonenum'), $('#dynamicpasswordothertemp'));">验证码</div>
		</div>
		<div class="red_Contact_Verification_2">
			验证码：<input name="verifcode" id="verifcode" type="text" size="24"
				style="background-color: transparent; border-bottom: 1px solid #fff; height: 25px;" />
		</div>
		<div style="height: 60px;">
			&nbsp;
			<div id="dynamicpasswordothertemp"
				style="color: white; text-align: center; width: 75%; margin: 0 auto; font-size: 10px;">${messageother }</div>
		</div>
		<a href="#" onclick="submitOrder()"><div
				style="width: 60%; margin: 0 auto; height: 50px;"></div></a>
	</div>
	<header class="am-topbar am-topbar-inverse">
		<div>
			<img src="../plug-in/cashcoupon/images/red_Contact_bg2.jpg">
		</div>
	</header>
	<script type="text/javascript">
		function submitOrder() {
			var verifcode = $("#verifcode").val();
			var phonenum = $("#phonenum").val();
			var openid = $("#openid").val();
			var huodongid = $("#huodongid").val();
			var fromtag = $("#fromtag").val();
			$
					.ajax({
						type : "POST",
						url : "${webRoot}/fo/cashCouponController.do?checkPhone",
						data : {
							verifcode : verifcode,
							phonenum : phonenum,
							openid:openid
						},
						dataType : "json",
						success : function(data) {
							if (data == "0") {
								location.href = "${webRoot}/fo/cashCouponController.do?receiveCard"
										+ "&openid="
										+ openid
										+ "&huodongid="
										+ huodongid
										+ "&verifcode="
										+ verifcode
										+ "&phonenum="
										+ phonenum
										+ "&fromtag="
										+ fromtag;
							} else if (data == "1") {
								$("#dynamicpasswordothertemp").text(
										'**验证码有误！  ');
							} else if (data == "2") {
								$("#dynamicpasswordothertemp").text(
										'**手机号有误！  ');
							}
						}
					});
		}
		
		wx.config(${JSONString});
		wx.ready(function () {
		    // 2. 分享接口
		    // 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
		    wx.onMenuShareAppMessage({
		       title: '${title}',
		       desc: '${desc}',
		       link: '${flink}',
		       imgUrl: '${imgurl}',
		       trigger: function (res) {
		          // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
		          //alert('用户点击发送给朋友');
		       },
		       success: function (res) {
		          //alert('已发送给朋友');
		       },
		       cancel: function (res) {
		         //alert('已取消发送给朋友');
		       },
		       fail: function (res) {
		          alert(JSON.stringify(res));
		       }
		    });
		    // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
		    wx.onMenuShareTimeline({
		       title: '${desc}',
		       link: '${zonelink}',
		       imgUrl: '${imgurl}',
		       trigger: function (res) {
		          // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
		          //alert('用户点击分享到朋友圈');
		       },
		       success: function (res) {
		          //alert('已分享朋友圈');
		       },
		       cancel: function (res) {
		          //alert('已取消分享朋友圈');
		       },
		       fail: function (res) {
		          alert(JSON.stringify(res));
		       }
		     });
		});
		wx.error(function (res) {
		  alert(res.errMsg);
		});
	</script>
	<script
		src="${webRoot}/plug-in/fo/js/customerbind/customerBind.js?vesion=2"></script>
</body>
</html>