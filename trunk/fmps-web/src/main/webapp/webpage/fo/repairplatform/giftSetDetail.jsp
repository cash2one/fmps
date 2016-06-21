<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta name="description" content="这是一个 user 页面">
			<meta name="keywords" content="user">
				<meta name="viewport"
					content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
					<meta name="renderer" content="webkit">
						<meta http-equiv="Cache-Control" content="no-siteapp" />
						<%@ include file="/webpage/fo/common/fotags.jsp"%>
						<link rel="icon" type="image/png" href="assets/i/favicon.png">
							<link rel="apple-touch-icon-precomposed"
								href="assets/i/app-icon72x72@2x.png">
								<meta name="apple-mobile-web-app-title" content="Amaze UI" />
</head>
<style type="text/css">
.am-header-default {
	background-color: #fff;
}

.am-header {
	position: relative;
	width: 100%;
	height: 49px;
	line-height: 49px;
	padding: 0 10px;
	border-bottom: 2px solid #0e90d2;
}

.am-checkbox {
	margin-top: 0px;
}

.am-header .am-header-nav img {
	height: 20px;
}

.am-header .am-header-title {
	margin: 0 1%;
}

.am-btn-primary {
	width: 100%;
}

.am-modal-no-btn .am-modal-dialog {
	border-radius: 5px;
	background: url(${webRoot}/plug-in/repair/campaign_bomb_bg.jpg) #fff
		no-repeat bottom right;
	height: 210px;
}

body {
	background-color: #fff;
}

.campaign_money {
	height: 150px;
	background: #32b5f8;
}

.campaign_money_img {
	padding: 18px 0px 0px 15px;
	font-size: 13px;
	color: #fff;
}

.campaign_money_text {
	font-size: 28px;
	color: #fff;
	text-align: center;
	padding: 9px 0px;
}

.campaign_money_date {
	font-size: 11px;
	color: #e8e8e8;
	text-align: center;
}

.campaign_center {
	padding: 0 15px;
	text-align: left;
}

.campaign_center_service {
	font-size: 16px;
	color: #292929;
	padding: 15px 0px 15px 0px;
}

.campaign_center .service_text {
	font-size: 14px;
	border-bottom: 1px solid #e8e8e8;
	padding-bottom: 10px;
}

.campaign_center .service_text_1 {
	font-size: 14px;
	padding-bottom: 10px;
}

.campaign_button {
	background-color: #0e90d2;
	height: 45px;
	color: #fff;
	text-align: center;
	font-size: 18px;
	border-radius: 3px;
	margin-top: 20px;
}

.am-modal-bd {
	text-align: center;
	font-size: 12px;
	line-height: 25px;
	color: #292929;
}

input {
	height: 35px;
	border: 1px solid #e8e8e8;
	width: 80%;
	font-size: 12px;
	text-align: center;
}

.am-modal-bd_1 {
	margin-bottom: 25px;
}

.am-modal-bd_2 {
	background-color: #32b5f8;
	color: #fff;
	text-align: center;
	border-radius: 20px;
	width: 40%;
	margin: 0 auto;
}

.am-modal-bd_3 {
	text-align: center;
	font-size: 12px;
	padding-top: 5px;
	color: #FF0000;
}

.hasReceived {
	background-color: #f8314e;
	border-color: #f8314e
}

.hasEmpty {
	background-color: #232323;
	border-color: #232323
}

.myGiftBag {
	font-size: 12px;
	color: #292929;
	padding: 10px 0px 10px 0px;
}
</style>
<body>
	<div class="campaign_money">
		<div class="campaign_money_img">
			<img src="${webRoot}/plug-in/repair/peck_head.png"
				style="width: 40px; height: 40px; border-radius: 20px;" />
			富邦微信平台通用券
		</div>
		<div class="campaign_money_text">${giftSet.name}</div>
		<div class="campaign_money_date">
			有效期：${giftSet.starttime}--${giftSet.endtime}			
		</div>
	</div>
	<div
		style="background:url(${webRoot}/plug-in/repair/peck_circle.png) scroll repeat-x top left; height:5px; width:100%; margin-top:-4px;">&nbsp;</div>
	<div class="campaign_center">
		<input type="hidden" id="huodongid" name="huodongid"
			value="${huodongid }" />
		<div class="campaign_center_service">服务内容</div>
		<input type="hidden" id="giftSetId" value=${giftSet.id } />
		<div class="service_text">${giftSet.serviceContent}</div>
		<div class="campaign_center_service">使用须知</div>
		<div class="service_text">${giftSet.useContent}</div>
		<div class="campaign_center_service">使用门店</div>
		<div class="service_text_1" onclick="toRepairMain(${merchant.id})"
			style="color: #0e90d2">${merchant.name}</div>
		<div class="service_text_1">
			<span class="am-icon-map-marker"></span> &nbsp;地址：${merchant.address}
		</div>
		<div class="service_text_1">
			<span class="am-icon-phone"></span> &nbsp;电话：${merchant.telephone}
		</div>
		<c:choose>
			<c:when test="${status==0}">
				<div class="campaign_button am-btn am-btn-primary js-modal-open"
					id="receiveGiftSet"> <c:if test="${giftSet.type=='5'}">抢</c:if> <c:if test="${giftSet.type!='5'}">领 取</c:if> </div>
				<div style="height: 25px;">&nbsp;</div>
			</c:when>
			<c:when test="${status==1}">
				<div
					class="campaign_button am-btn am-btn-primary js-modal-open am-disabled hasReceived">已
					领 取</div>
				<div class="myGiftBag" style="text-align: center;">
					已存入 "<span style="color: #0e90d2" onclick="toGiftList()">我的礼包</span> "
					<br></br>					
				</div>
			</c:when>
			<c:when test="${status==3}">
				<div
					class="campaign_button am-btn am-btn-primary js-modal-open am-disabled hasEmpty">本年度已领满200张券</div>
				<div style="height: 25px;">&nbsp;</div>
			</c:when>
			<c:when test="${status==4}">
				<div
					class="campaign_button am-btn am-btn-primary js-modal-open am-disabled hasEmpty">抢</div>
				<div style="height: 25px;">&nbsp;</div>
			</c:when>
			<c:otherwise>
				<div
					class="campaign_button am-btn am-btn-primary js-modal-open am-disabled hasEmpty">已
					抢 光</div>
			</c:otherwise>
		</c:choose>

		<!-- <div class="am-modal am-modal-no-btn" tabindex="-1" id="your-modal">
			<div class="am-modal-dialog">
				<div class="am-modal-hd">
					<a href="javascript: void(0)" class="am-close am-close-spin"
						data-am-modal-close>&times;</a>
				</div>
				<div class="am-modal-bd">
					本次活动您一共只可领取5张券<br />您可在“我”-个人信息-礼包处查询
				</div>
				<div class="am-modal-bd_1">
					<input name="" type="text" placeholder="请输入您的车牌号" />
				</div>
				<div class="am-modal-bd_2">确认领取</div>
				<div class="am-modal-bd_3" style="display: none">您好，礼包已抢光</div>
			</div>
		</div> -->
	</div>


	</div>


	<div class="am-dimmer am-active" data-am-dimmer=""
		style="display: none;" id="fbshade"></div>
	<div class="am-modal am-modal-alert am-modal-active" tabindex="-1"
		id="my-alert" style="display: none; margin-top: -119px;">
		<div class="am-modal-dialog" style="border-radius: 10px;">
			<div class="am-modal-hd"
				style="font-family: '微软雅黑' 'Helvetica Neue', Helvetica, STHeiTi, sans-serif;">请先长按二维码关注微信号</div>
			<div class="am-modal-bd">
				<div class="erweima">
					<img id="QRcode" src="${webRoot}/plug-in/fo/images/weixinQ.png"
						width="130" height="130" />
				</div>
				<div class="am-modal-hd" style="font-size: 11px;">如果长按二维码不能识别，可以搜索富邦财险进行关注</div>

			</div>
			<div class="am-modal-footer">
				<!--  <span class="am-modal-btn" onclick="reload();">关 闭</span>  -->
			</div>
		</div>
	</div>
	<div class="am-modal am-modal-alert" tabindex="-1" id="showcashcoupon">
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd">
      	恭喜您，领券成功。同时你获得了富邦赠送的红包，稍后会在富邦公众号中发放，请注意查收
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>
	<script>
  $(function() {
//     var $modal = $('#your-modal');

//     $modal.siblings('.am-btn').on('click', function(e) {
//       var $target = $(e.target);
//       if (($target).hasClass('js-modal-open')) {
//         $modal.modal();
//       } else if (($target).hasClass('js-modal-close')) {
//         $modal.modal('close');
//       } else {
//         $modal.modal('toggle');
//       }
//     });

	 $("#receiveGiftSet").click(function(){
   		var giftSetId = $("#giftSetId").val();
       	var huodongid = $("#huodongid").val();
   		$.ajax({
   			url : "${webRoot}/fo/carHomeController.do",
   			data : "method=receiveGiftSet&openid=${openid}&giftSetId="+giftSetId+"&huodongid="+huodongid,
   			type : "POST",
   			dataType: "json",
   			success : function(data) {
   				if("0"==data.obj.errcode){
   					$("#fbshade").show();
   					$("#my-alert").show();
   					return;
   				}
   				if("00000"==data.obj.errcode){
   					$("#receiveGiftSet").text("已 领 取").removeClass("hasReceived").addClass("hasEmpty am-disabled");
   					$("#receiveGiftSet").after("<div class=\"myGiftBag\" style=\"text-align:center;\" onclick=\"toGiftList()\">已存入 \"<span style=\"color:#0e90d2\">我的礼包</span>\"</div>");
   					//$("#receiveGiftSet").after("<div class=\"myGiftBag\" style=\"text-align:center;\" onclick=\"toGiftList()\">\"<span style=\"color:#0e90d2\">已领到的红包</span>\"</div>");
   					if(data.attributes.amount!="0"){
   	   					var $modal = $('#showcashcoupon');
   	   					$modal.modal({
   	   						closeViaDimmer : 0,
   	   						width : 260,
   	   						height : 150
   	   					});
   	   					$modal.modal('open');
   	   				}
   				}else{
   					alert(data.obj.errmsg);
   				}
   				
   			},
   			error : function(e) {
   				alert("网络有问题，请稍后再试");
   			}
   		});
    });
  });
  function toRepairMain(id){
  	var url = "${webRoot}/fo/repairFactoryController.do?method=repairMain&openid=${openid}&repairId="+id;
  	location.href = url;
  }
  
  function toGiftList(){
  	var url = "${webRoot}/fo/binded/repairFactoryGiftController.do?method=giftList&openid=${openid}";
  	location.href = url;
  }
  var sharetitle="";
  $(document).ready(function() {
	 
  });
  var json = ${jsonString};
  wx.config(json);

  wx.ready(function(){
	//wx.hideOptionMenu();
	  var type=${giftSet.type};
		 if(type=="4"){
			 sharetitle="我在富邦抢到了${giftSet.name}，还有不定时超值低价洗车等你来抢！";
		 }else 
		 if(type=="5"){
			 sharetitle="我在富邦抢到了${giftSet.name}，还有全城会员价洗车券可领，快来看看吧";
		 }else{
			 sharetitle="我在富邦爱车之家平台领取了免费美容维修抵用券，你想要的券都在这儿，一起来吧！";
		 }
		 shareinit();
  });
  wx.error(function(res){
	//信息验证失败
  });
  
  $('#showcashcoupon').on('close.modal.amui', function(){
	  var huodongid = $("#huodongid").val();
	  location.href="${webRoot}/fo/cashCouponController.do?showCouponResult&openid=${openid}&huodongid="+huodongid;
	});
  
  function shareinit() {
		//2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
		wx.onMenuShareAppMessage({
			title : '富邦财险',
			desc : sharetitle,
			link : 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}/fo/carHomeController.do?method=carHomeIndex&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
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
			title : sharetitle,
			link : 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}/fo/carHomeController.do?method=carHomeIndex&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
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
 
  function toCashcoupon(){
	  location.href="${webRoot}/fo/cashCouponController.do?showCouponResult&openid=${openid}&huodongid=${huodongid}";
  }
</script>
</body>
</html>