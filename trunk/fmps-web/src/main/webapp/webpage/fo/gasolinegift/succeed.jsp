<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加油宝活动</title>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="description" content="加油宝活动" />
  <meta name="keywords" content="user" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
  <meta name="renderer" content="webkit" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <%@ include file="/webpage/fo/common/fotags.jsp"%>
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
<style type="text/css">
body{ margin:0 auto; background-color:#2d3455; width:100%;   line-height: 1.4;}
.succeed_all{ margin:0 auto; background-color:#2d3455; width:100%;}
img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
}
.succeed_bg_3{ height:90px; font-family:"微软雅黑"; font-size:48px; text-align:center; color:#fff; max-width:640px;}
.succeed_bg_3_1{ width:276px;  border:1px dashed #ffff00; height:70px; margin:0 auto;}
.succeed_bg_4{ font-family:"微软雅黑"; font-size:14px; color:#FFFFFF; text-align:left; max-width:640px; padding:0 20px; line-height: 26px; font-weight:700;}
.succeed_bg_5{ font-family:"微软雅黑"; font-size:16px; color:#FFFFFF; text-align:left; max-width:640px; padding:0 20px; line-height: 26px; font-weight:700; margin-top:10px;}
.index_bg_4{ font-family:"微软雅黑"; font-size:14px; color:#FFFFFF; text-align:left; max-width:640px; padding:0 20px; line-height: 26px; padding-bottom:20px; padding-top:10px;}
.am-modal-bd {
  padding: 0px 0px;}
.am-close {
  opacity: .9;}
ol li{list-style:decimal;}
</style>
<script type="text/javascript">
  	var json = ${jsonString};
	wx.config(json);
	
	wx.ready(function(){
		wx.onMenuShareTimeline({
			title: '这就是你要的加油神器，全国中石化95折！没有上限！加多少都95折！',
			link: '${link}',
			imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
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
			title: '给你推荐一款95折无上限加油神器。',
			desc: '这就是你要的加油神器，全国中石化95折！没有上限！加多少都95折！',
			link: '${link}',
			imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
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
	});

	wx.error(function(res){
		//信息验证失败
	});
  </script>
</head>

<body>
 <div class="succeed_all">
  <div class="succeed_bg_1"><img src="${webRoot}/plug-in/gasolinegift/succeed_1.jpg" /></div>
  <div class="succeed_bg_2"><img src="${webRoot}/plug-in/gasolinegift/succeed_2.jpg" /></div>
  <div class="succeed_bg_3">
    <div class="succeed_bg_3_1">${giftid}</div>
  </div>
  <div class="succeed_bg_4">
请您持本人身份证、行驶证、办理邀请码至以下地点办理加油宝。
  </div>
  <div class="succeed_bg_7"><img src="${webRoot}/plug-in/gasolinegift/succeed_7.jpg" /></div>
   <div class="succeed_bg_5">
富邦专属合作银行—厦门银行
  </div>
  <div class="succeed_bg_4">（厦门地区所有厦门银行网点均可办理）</div>
  <div class="index_bg_4">
   
  </div>
  <div class="succeed_bg_8"><a href="http://s.p.qq.com/pub/jump?d=AAARyMzz"><img src="${webRoot}/plug-in/gasolinegift/succeed_8.jpg" /></a></div>
  <div class="succeed_bg_9"><a href="${returnLink}"><img src="${webRoot}/plug-in/gasolinegift/succeed_9.jpg" /></a></div>
  <div class="succeed_bg_10"><img src="${webRoot}/plug-in/gasolinegift/succeed_10.jpg" /></div>
 </div>

<script>
$('.btn-loading-example').click(function () {
  var $btn = $(this)
  $btn.button('loading');
    setTimeout(function(){
      $btn.button('reset');
  }, 5000);
});
$('#doc-modal-1').on('open.modal.amui', function(){
//   console.log('第一个演示弹窗打开了');
});
</script>
</body>
</html>
