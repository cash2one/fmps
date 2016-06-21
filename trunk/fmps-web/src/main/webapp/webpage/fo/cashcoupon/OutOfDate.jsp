<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<head>
<title></title>
<style type="text/css">
body {
	margin: 0 auto;
	background-color: #feedd5;
}

.red_pay_bg {
	background:
		url(${webRoot}/plug-in/cashcoupon/images/red_pay_invilid.jpg)
		no-repeat scroll center top;
	background-size: contain;
	height: 446px;
	width: 100%;
	margin: 0 auto;
}

.red_Money {
	color: #fff;
	font-size: 40px;
	margin: 0 auto;
	width: 50%;
	font-family: "微软雅黑";
	text-align: center;
}

.red_Forwarding {
	width: 100%;
	float: left;
	height: 30px;
}

.red_Forwarding_text_1 {
	width: 50%;
	float: left;
	height: 35px;
}

.red_Forwarding_text_2 {
	width: 50%;
	float: left;
	height: 35px;
}

.red_list_bg {
	width: 320px;
	background-color: #a42303;
	height: auto;
	margin: 0 auto;
	clear: both;
	padding-bottom: 20px;
}

.red_list {
	background: #fff;
	width: 280px;
	margin: 0 auto;
	height: auto;
	border-bottom: 1px solid #dedede;
	height: 60px;
}

.red_list .red_list_img {
	padding: 5px;
	float: left;
	width: 20%;
}

.red_list .red_list_text {
	float: left;
	width: 50%;
	font-size: 14px;
	font-family: "微软雅黑";
	padding-top: 15px;
	color: #0a0a0a;
}

.red_list .red_list_pay {
	float: left;
	width: 20%;
	font-size: 14px;
	font-family: "微软雅黑";
	padding-top: 15px;
	text-align: right;
	color: #0a0a0a;
	font-weight: 700;
}
</style>
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid}" />
	<input type="hidden" id="huodongid" name="huodongid"
		value="${huodongid}" />
	<div class="red_pay_bg">
		<div style="height: 260px;">&nbsp;</div>
		<div
			style="color: #fff; font-size: 10px; margin: 0 auto; width: 60%; font-family: '微软雅黑'; height: 30px; text-align: center;">${message}</div>
	</div>

	<div class="red_list_bg" style="clear: both;">
		<div style="height: 20px;">&nbsp;</div>
		<c:forEach items="${cashHistoryList}" var="cashHistory"
			varStatus="status">
			<div class="red_list">
				<div class="red_list_img">
					<img src="${cashHistory.headimgurl}"
						style="-webkit-border-radius: 50px; border-radius: 50px; height: 50px; width: 50px;" />
				</div>
				<div class="red_list_text">
					<span style="font-weight: 700;">${cashHistory.nickname}</span><br />
					<span style="color: #a3a1a1; font-size: 10px;"><fmt:formatDate
							value='${cashHistory.rltime}' pattern="MM-dd HH:mm" /></span>
				</div>
				<div class="red_list_pay">${cashHistory.total_amount}元</div>
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript">
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
</body>

</html>