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

a {
	border: 0px;
}

.red_bg {
	background: url(${webRoot}/plug-in/cashcoupon/images/red_pay_4.jpg) no-repeat scroll center top;
	background-size: contain;
	height: 570px;
	width: 320px;
	margin: 0 auto;
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
	<div class="red_bg">
		<div style="height: 300px;">&nbsp;</div>
		<div
			style="width: 50%; margin: 0 auto; height: 90px; color: #fff; font-family: '微软雅黑'; text-align: center;">${message }</div>
	</div>
	<header class="am-topbar am-topbar-inverse ">
		<div>
			<img src="../plug-in/cashcoupon/images/red_Contact_bg2.jpg">
		</div>
	</header>
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