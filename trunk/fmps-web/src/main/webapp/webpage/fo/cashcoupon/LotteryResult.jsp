<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<head>
<title></title>
<!-- <script charset="utf-8" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script> -->
<!--   <script src="http://demo.open.weixin.qq.com/jssdk/js/demo.js"> </script>  -->
<style type="text/css">
body {
	margin: 0 auto;
	background-color: #feedd5;
}

.red_pay_bg {
	background: url(../plug-in/cashcoupon/images/red_pay.jpg)
		no-repeat scroll center top;
	background-size: contain;
	height: 501px;
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

img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
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


	<div id="mcover" onclick="weChat()" style="display: none;">
		<img style="" src="${webRoot}/plug-in/cashcoupon/images/guide.png" />
	</div>

	<div class="red_pay_bg">


		<div style="height: 110px;">&nbsp;</div>
		<div class="red_Money">${total_amount }元</div>
		<div style="height: 10px;">&nbsp;</div>
		<div
			style="color: #fff; font-size: 15px; margin: 0 auto; width: 70%; font-family: '微软雅黑'; height: 30px; text-align: center;">
			同时还获得一张悠游天下保险卡</br>可在旅游前激活
		</div>
		<!-- <div
			style="color: #fff; font-size: 15px; margin: 0 auto; width: 70%; font-family: '微软雅黑'; height: 30px; text-align: center;">可在旅游前激活</div>
		
		 -->
		<div style="height: 100px;">&nbsp;</div>
		<div
			style="color: #fff; line-height: 35px; font-size: 14px; margin: 0 auto; width: 70%; font-family: '微软雅黑'; height: 30px; text-align: center;"
			onclick="cardlink();">
			请进入：<span style="color: #89fbf4">我-个人中心-保险卡</span> 查看
		</div>
		<div style="height: 30px;">&nbsp;</div>
		<div class="red_Forwarding">

			<!-- <a href="" onclick="clickshareFriend();"> -->
			<div class="red_Forwarding_text_1" id="onMenuShareAppMessage"
				onclick="button1()">&nbsp;</div>
			<!-- </a> -->
			<!-- <a
				href="" onclick="clickshareFriendhome();"> -->
			<div class="red_Forwarding_text_2" id="onMenuShareTimeline"
				onclick="button2()">&nbsp;</div>
			<!-- </a> -->
		</div>

		<!-- <button class="btn btn_primary" id="onMenuShareTimeline">onMenuShareTimeline</button>

      <button class="btn btn_primary" id="onMenuShareAppMessage">onMenuShareAppMessage</button>
	 -->
		<div style="height: 124px;">&nbsp;</div>
		<div class="red_list_bg">
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
	</div>
	<script>

    wx.config(${JSONString});
    
    
    wx.ready(function () {

      /*   wx.checkJsApi({
          jsApiList: [
            'onMenuShareTimeline',
            'onMenuShareAppMessage'
          ],
          success: function (res) {
            alert(JSON.stringify(res));
          }
        }); */


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
  
    
    	var actionurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}/fo/binded/personalCenterController.do?CardIndex"
			+ "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
		
        //跳到保险卡链接 
        function cardlink(){
        	 location.href =actionurl;	 		
        }
    
    
	  
        function button1(){
    	$("#mcover").css("display","block");    // 分享给好友按钮触动函数
    	}
    
    	function button2(){
    	$("#mcover").css("display","block");  // 分享给好友圈按钮触动函数
    	}
    	function weChat(){
    	$("#mcover").css("display","none");  // 点击弹出层，弹出层消失
    	}
    

</script>
</body>

</html>