<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>富邦财险</title>
	<meta name="keywords" content="user" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="renderer" content="webkit" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" />
	<script type="text/javascript">
	var shareurl = '';
	var code='<%=request.getParameter("code")%>';
	
	$(function(){
  		var hisamount = '${hisamount}';
  		if(${helpHimFlag}){
		  	$("#message").text("你已经帮我抢过保额啦。一个人只有一次帮抢机会哦。");
  		}else{
  			if(hisamount==0){
	  			$("#message").text("我的保额已经达到10万了，还是感谢您的鼎力相助，你继续加油哦。 ");
	  			$("#helpDiv").hide();
	  		}
  		}
		
		shareUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FlunarNewYearController.do%3FsharePage%26huodongid%3D8a828edfedfre68475034fd3dca5799634%26sponsor%3D${openid}&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		$.ajax({
			type : 'POST',
			url : "${webRoot}/fo/dobule11Controller.do?JsdkString",
			data : "&attachurl=%2Ffo%2FlunarNewYearController.do%3FsharePage%26huodongid%3D8a828edfedfre68475034fd3dca5799634%26sponsor%3D${sponsor}%26code="+code+"%26state=STATE",
			dataType : "json",
	    	error : function() {// 请求失败处理函数
				alert('获取初始化信息失败，请稍候重试.');
			},
			success : function(json) {
// 				console.info(json);
				var result = "fail";
				if (json.success&&json.obj.length>5) {						
					var jssdk = eval('(' + json.obj + ')');
// 					console.info(jssdk);
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
		wx.onMenuShareTimeline({
			title: '我抢到了${myamount}元的意外保障，还能抽最高1000元回家路费，一起来吧！',
			link: shareUrl,
			imgUrl: '${webRoot}/plug-in/huodong/lunarnewyear/images/shareLogo.jpg',
			trigger: function (res) {
			},
			success: function (res) {
			},
			cancel: function (res) {
			},
			fail: function (res) {
				alert(JSON.stringify(res));
			}
		});
		
		wx.onMenuShareAppMessage({
			title: '抢保额活动',
			desc: '我抢到了${myamount}元的意外保障，还能抽最高1000元回家路费，一起来吧！',
			link: shareUrl,
			imgUrl: '${webRoot}/plug-in/huodong/lunarnewyear/images/shareLogo.jpg',
			trigger: function (res) {
			},
			success: function (res) {
			},
			cancel: function (res) {
			},
			fail: function (res) {
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
	function goZPPage(){
		location.href="${webRoot}/fo/lunarNewYearController.do?turnplatePage&productId=8a8195b3523334d4015233534e370018"+"&version="+Math.random();
	}
	//跳转意外险购买页
	function goYWXPage(){
		location.href="${webRoot}/fo/taiwanController.do?showProduct&productid=8a8195b351f192df0151f62dae090007&huodongid=8a828edfedfre68475034fd3dca5799634";
	}
	//跳转 老年骨折险购买页
	function goGZXPage(){
		location.href="${webRoot}/fo/taiwanController.do?showProduct&productid=8a8195b351f6b7910151f74dc163003a&huodongid=8a828edfedfre68475034fd3dca5799634";  
	}
	//查看我的详情
	function toMyDetail(){
		location.href="${webRoot}/fo/lunarNewYearController.do?huodongIndex";
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
	<div class="spring_top_bg">
		<div class="img">
			<img src="${headimgurl }" width="150" height="150" style="border-radius: 50px;">
		</div>
		<div class="text" id="message"  >
			富邦豪送亿元保额，春节出行有保障！我已经抢到了，快看看你抢到了多少！</div>
	</div>
	<div class="spring_number_three" id="helpDiv">
		<div class="spring_number_limit_1">${hisamount }元</div>
		<div class="spring_number_text_1" onclick="goGuarantee()">查看保障说明</div>
		<!--<div class="spring_share">点击右上角分抢保额</div>-->
	</div>
	<div class="spring_number_progress">
		<div class="spring_number_progress_nbsp">&nbsp;</div>
		<div class="spring_guarantee_index">
			<div class="left">
				<div class="progress_bar_1">
					<c:choose>
						<c:when test="${myProgress>=40}"><div class="progress"><span class="red" style="width: ${myProgress}%;"><span>${myamountWan}万/10万</span></span></div></c:when>
						<c:otherwise><div class="progress">${myamountWan}万/10万<span class="red" style="width: ${myProgress}%;"><span></span></span></div></c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="right" onclick="toMyDetail()">详情</div>
			<div class="progress_text">
				每增加1万保额多1次抽奖机会，您有<span>${remainTimes}</span>次机会！
			</div>
		</div>
		<div class="spring_nbsp_button_1" onclick="block()">&nbsp;</div>
		<div class="spring_nbsp_button_2" onclick="goZPPage()">&nbsp;</div>
	</div>
	<%@ include file="/webpage/fo/huodong/lunarnewyear/commonPage.jsp"%>
</body>
</html>
