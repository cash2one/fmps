<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>抢保额</title>
  <meta name="description" content="抢保额主页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" />  

<script type="text/javascript">
//分享链接 
var  shareurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FlunarNewYearController.do%3FsharePage%26huodongid%3D8a828edfedfre68475034fd3dca5799634%26sponsor%3D${openid}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

$(function(){
	   init();
	});

function init(){	
	var jsdkurl=window.location.href;
	//alert(jsdkurl);
	$.ajax({
		type : 'POST',
		url : "${webRoot}/fo/lunarNewYearController.do?JsdkString",
		data : "&jsdkurl="+jsdkurl,
		dataType : "json",
    	error : function() {// 请求失败处理函数    	
			alert('获取初始化信息失败，请稍候重试.');
		},
		success : function(json) {			
			if (json.success&&json.obj.length>5) {
				var jssdk = eval('(' + json.obj + ')');				 
				wx.config(jssdk);					
		 		wx.ready(function () { 
					shareinit();					
				});  
				wx.error(function (res) {
					//alert(res.errMsg);
					alert('页面加载异常，请稍后重试.wx');	
				});
								
			} else {
				alert('页面加载异常，请稍后重试');						 				
			}
		 }
	   });
	 }

//分享给朋友
 function shareinit() {
	//2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
	wx.onMenuShareAppMessage({
		title : '抢保额活动',
		desc : '我抢到了${amount}元的意外保障，还能抽最高1000元回家路费，一起来吧！',
		link : shareurl,
		imgUrl : '${webRoot}/plug-in/huodong/lunarnewyear/images/shareLogo.jpg',
		trigger : function(res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击发送给朋友');
		},
		success : function(res) {			
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
		title : '我抢到了${amount}元的意外保障，还能抽最高1000元回家路费，一起来吧！',
		link : shareurl,
		imgUrl : '${webRoot}/plug-in/huodong/lunarnewyear/images/shareLogo.jpg',
		trigger : function(res) {
			// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			//alert('用户点击分享到朋友圈');
		},
		success : function(res) {		
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

 //跳转保障页面  
 function  goGuarantee(){	   
	   location.href="${webRoot}/plug-in/huodong/lunarnewyear/guarantee.html";
    }

   //跳转全国保额查看页面  
 function  goMapPage(){	   
	   location.href="${webRoot}/fo/lunarNewYearController.do?premiumMapPage";
    }
     //跳转过大年，抽年货 
  function  goZPPage(){
	   location.href="${webRoot}/fo/lunarNewYearController.do?turnplatePage&productId=8a8195b3523334d4015233534e370018"+"&version="+Math.random();
     }
  //跳转意外险购买页
  function  goYWXPage(){
	  location.href="${webRoot}/fo/taiwanController.do?showProduct&productid=8a8195b351f192df0151f62dae090007&huodongid=8a828edfedfre68475034fd3dca5799634";
     }
  //跳转 老年骨折险购买页 
  function  goGZXPage(){
	  location.href="${webRoot}/fo/taiwanController.do?showProduct&productid=8a8195b351f6b7910151f74dc163003a&huodongid=8a828edfedfre68475034fd3dca5799634";  
     }    
  //跳转 活动规则，奖品说明页面 
  function  goActivityInfo(){
	  location.href="${webRoot}/plug-in/huodong/lunarnewyear/spring_prize.html";  
     }    
	//点击弹出层，弹出层消失
  	function weChat() {
		$("#mcover").css("display", "none");
	}
  	//分享给好友圈按钮触动函数
	function block() {
		$("#mcover").css("display", "block");
	}
</script>
</head>
<body>
<div id="mcover" onclick="weChat()" style="display: none;">
		<img style="" src="${webRoot}/plug-in/fo/images/guide.png" />
	</div>
 <div><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/spring_01.jpg" /></div>
 <div class="spring_number">
  <div class="spring_number_limit">${amount}元</div>
  <div class="spring_number_text"  onclick="goGuarantee()">查看保障说明</div>
  <div style="height:17px; border-bottom:1px #8c0c0b dotted;">&nbsp;</div>
  <div class="progress_bar">
   <c:choose>
		<c:when test="${myProgress>=40}"><div class="progress"><span class="red" style="width: ${myProgress}%;"><span>${myamountWan}万/10万</span></span></div></c:when>
		<c:otherwise><div class="progress">${myamountWan}万/10万<span class="red" style="width: ${myProgress}%;"><span></span></span></div></c:otherwise>
	</c:choose>
   </div>
   <div class="progress_text_1">每增加1万保额多1次抽奖机会，您有<span>${remainTimes}</span>次机会！</div>
   <div class="spring_nbsp_button_3" onclick="block()">&nbsp;</div>
   <div class="spring_nbsp_button" onclick="goZPPage()">&nbsp;</div>
 </div>



 
 <%@ include file="/webpage/fo/huodong/lunarnewyear/commonPage.jsp"%>
 </body>
</html>
