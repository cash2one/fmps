<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>富邦保险</title>
<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/coupon.css">
</head>
<body>
	<div>
		<img src="${webRoot}/plug-in/carHome/images/red_bg.jpg" />
	</div>
	<div class="red_money">${amount }</div>
	<div class="red_center">
		<div class="red_title">活动时间</div>
		<div class="red_text">
			<ul>
				<li>2015年12月25日-2016年1月1日期间</li>
			</ul>
		</div>
		<div class="red_title">活动规则</div>
		<div class="red_text">
			<ul>
				<li>只要领券就有机会抽到红包<br/>每天派发一万份，送完即止！
					<br /></li>
				<li>点击右上角 ● ● ● 选择分享给朋友，一起抢券领红包吧！</li>


			</ul>
		</div>
	</div>
	<div class="red_bottom">
		<img src="${webRoot}/plug-in/carHome/images/red_bottom.jpg" />
	</div>
	<script type="text/javascript">
	wx.config(${JSONString});    
    wx.ready(function () {
    	// 2. 分享接口
    	// 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
        wx.onMenuShareAppMessage({
          title: '富邦保险',
          desc: '双旦大狂欢！！每天派发一万份红包！！！送完即止！ ',
          link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}/fo/carHomeController.do?method=carHomeIndex&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
          imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
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
          title: '双旦大狂欢！！每天派发一万份红包！！！送完即止！ ',
          link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}/fo/carHomeController.do?method=carHomeIndex&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
          imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
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
    	
    	$(document).ready(function() {
    	//	$.ajax({
			//	type : 'POST',
		//		url : "${webRoot}/fo/cashCouponController.do?sendCoupon",
		//		data : "&openid=${openid}&huodongid=${huodongid}",
		//		dataType : "json",
	      //  	error : function() {// 请求失败处理函数
		//			alert('获取初始化信息失败，请稍候重试.');
		//		},
			//	success : function(json) {
					
		//		}
		//	});
    	});
	</script>
</body>
</html>