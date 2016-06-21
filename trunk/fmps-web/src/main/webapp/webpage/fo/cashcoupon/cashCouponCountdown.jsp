<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>

<!doctype html>
<head>
  <title>抢红包</title>
  <style type="text/css">
   body{ background:#e7232f;}
   a{ border:0px;}
   img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
       }
   .red_bg{ margin:0 auto;}
   .Countdown_top{ margin:0 auto; text-align:center;}
   .Countdown_time{ color:#fff; text-align:center; margin:0 auto; font-size:35px; width:90%; background:url(${webRoot}/plug-in/cashcoupon/images/Countdown_bg.jpg) no-repeat center; height:52px; background-size:100% 100%;}
    @media screen and (max-width: 374px) { /*当屏幕尺寸小于374px时，应用下面的CSS样式*/
   .Countdown_time {
      background-size:contain;
   }
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
   .Countdown_time .days{ float:left; width:25%; font-family: "微软雅黑" "Helvetica Neue", Helvetica, STHeiTi, sans-serif;}
   .Countdown_time .hros{ float:left; width:25%; font-family: "微软雅黑" "Helvetica Neue", Helvetica, STHeiTi, sans-serif;}
   .Countdown_time .mins{ float:left; width:25%; font-family: "微软雅黑" "Helvetica Neue", Helvetica, STHeiTi, sans-serif;}
   .Countdown_time .secs{ float:left; width:25%; font-family: "微软雅黑" "Helvetica Neue", Helvetica, STHeiTi, sans-serif;}
   .Countdown_text{ color:#fff; text-align:center; margin:0 auto; font-size:14px;  width:90%;}
   .Countdown_text .days{ float:left; width:25%}
   .Countdown_text .hros{ float:left; width:25%}
   .Countdown_text .mins{ float:left; width:25%}
   .Countdown_text .secs{ float:left; width:25%}
   .Countdown_button{ margin:0 auto; text-align:center; padding-top:20px;}
   .Countdown_erweima{margin:0 auto; text-align:center; padding-top:20px;}
  </style>
  
  
</head>

<body>
 <div id="mcover" onclick="weChat()" style="display: none;">
		<img style="" src="${webRoot}/plug-in/cashcoupon/images/guide.png" />
	</div>
 <div class="red_bg">
  <div class="Countdown_top"><img src="${webRoot}/plug-in/cashcoupon/images/Countdown_top2.jpg" /></div>
  <div class="Countdown_time">
   <div id="days" class="days">00</div>
   <div id="hros" class="hros">00</div>
   <div id="mins" class="mins">00</div>
   <div id="secs" class="secs">00</div>
  </div>
  <div class="Countdown_text">
   <div class="days">天</div>
   <div class="hros">时</div>
   <div class="mins">分</div>
   <div class="secs">秒</div>
  </div>
 
  <div class="Countdown_button" id="onMenuShareTimeline"
				onclick="button2()"><img src="${webRoot}/plug-in/cashcoupon/images/Countdown_button.jpg" /></div>
  <div class="Countdown_erweima"><img src="${webRoot}/plug-in/cashcoupon/images/Countdown_erweima.jpg" /></div>
 </div>

</body>

<script type="text/javascript">

function show_time(){ 
	var time_start = new Date().getTime(); //设定当前时间
	//
	var time_end =  new Date('${endtimeStr}').getTime(); //设定目标时间
	
	//var time_end =  new Date("2015/9/18 19:23:00").getTime(); //设定目标时间
	//alert();
	if(time_start<time_end){
	// 计算时间差 
	var time_distance = time_end - time_start; 
 	// 天
	var int_day = Math.floor(time_distance/86400000) 
	time_distance -= int_day * 86400000;  
	// 时
	var int_hour = Math.floor(time_distance/3600000) 
	time_distance -= int_hour * 3600000; 
	// 分
	var int_minute = Math.floor(time_distance/60000) 
	time_distance -= int_minute * 60000; 
	// 秒 
	var int_second = Math.floor(time_distance/1000) 
	// 时分秒为单数时、前面加零 
    if(int_day < 10){ 
		int_day = "0" + int_day; 
	}  
	if(int_hour < 10){ 
		int_hour = "0" + int_hour; 
	} 
	if(int_minute < 10){ 
		int_minute = "0" + int_minute; 
	} 
	if(int_second < 10){
		int_second = "0" + int_second; 
	} 
	// 显示时间 
	/* $("#time_d").val(int_day);  */
	//$("#time").html(int_day+":"+int_hour+":"+int_minute+":"+int_second+""); 
	
	$("#days").html(int_day); 
	$("#hros").html(int_hour); 
	$("#mins").html(int_minute); 
	$("#secs").html(int_second); 
	
	
/* 	$("#time_m").val(); 
	$("#time_s").val();  */
	// 设置定时器
	}else{
		var actionurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${webRoot}%2Ffo%2FcashCouponController.do%3Fcashcoupon%26fromtag%3D2%26huodongid%3D8a828ebb49166847014916deca570004"
			+ "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
			// location.href = "http://guojunjie.pagekite.me:8080/fmps/fo/cashCouponController.do?cashcoupon&openid=oELqIsyh_VguKRN-0MONSbeLz5r0&state=8a828ebb49166847014916deca570004_wew";	 	
			 location.href = actionurl;	
	}
}
//setTimeout("show_time()",1000); 
$(document).ready(function(){  
	 InterValObj = window.setInterval(show_time, 1000); //间隔函数，1秒执行 
	//setTimeout("show_time()",1000);
	// setInterval(show_time(), 1000);  
	}); 
wx.config(${JSONString});
wx.ready(function () {


	// 2. 分享接口
	// 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareAppMessage({
      title: '富邦首期红包大派送，快来抢红包呀！！！',
      desc: '富邦首期红包大派送，快来抢红包呀！！！',
      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${webRoot}%2Ffo%2FcashCouponController.do%3FcashCouponCountdown%26id%3D8a828ebb49166847014916deca570004&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
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
      title: '富邦首期红包大派送，快来抢红包呀！！！',
      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${webRoot}%2Ffo%2FcashCouponController.do%3FcashCouponCountdown%26id%3D8a828ebb49166847014916deca570004&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
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
</html>