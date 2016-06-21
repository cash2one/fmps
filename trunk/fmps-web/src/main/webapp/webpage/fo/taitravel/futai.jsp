<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/webpage/fo/common/fotags.jsp"%>  
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>富邦财险</title>
</head>

<style type="text/css">
 .futai_index{ width:100%; float:left;}
 .futai_index_left{ width:25%; float:left;}
 .futai_index_img{ width:80px; height:80px; margin-left:10px;}
 .futai_index_right{ width:70%; float:left; font-size:1em; margin-left:15px;}
 .futai_index_title{ color:#222222; font-weight:700;}
 .futai_index_text{ color:#898888; font-size:14px;}
 .am-slider-default {
  margin: 0 0 10px;
}
.am-topbar {
  min-height: 30px;
  border-width: 0 0 0px;
  border-style:none;
}

img{   max-width: 100%;
  height: auto;}
  
header {
  height: 0px;}

</style>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title">
      赴台专区
    </h1>
  </header>


  
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->


  <!-- content start -->
  <div class="admin-content">
    
    <div class="am-slider am-slider-default">
 <img src="../plug-in/totaiwan/img/futai_tu_1.jpg" width="1024" height="456" alt="#" />
</div>
   <div class="futai_index">
    <div class="futai_index_left">
     <div class="futai_index_img"><img src="../plug-in/totaiwan/img/futai_index_pro.jpg" style="border-radius:5px 5px 5px 5px; border:#ebeaea solid 1px;" width="100" height="100"></div>
    </div>
    <div class="futai_index_right">
     <div class="futai_index_title">富邦Fun心游境外游保险</div>
     <div class="futai_index_text">提供24小时台湾旅行全天候综合性的紧急救援服务.</div>
    </div>
    <div style="clear:both; height:10px;">&nbsp;</div>
    <div class="futai_index_biao">
    <a href="${webRoot}/fo/TotaiwanController.do?baoan&openid=${openid}"> <div style="background-color:#5299cc; float:left; width:49.5%; height:110px; color:#ffffff; text-align:center; padding-top:30px; font-size:1.125em;">
     <div>报案流程及电话</div>
     <div style=" background:url(../plug-in/totaiwan/img/futai_index_bg_1_1.jpg) bottom right no-repeat; height:60px;">&nbsp;</div>
     </div>
     </a>
     <a href="../plug-in/totaiwan/futaishanjia.html"> <div style="background-color:#24b394; float:right; width:49.5%; height:110px; color:#ffffff; text-align:center; padding-top:30px; font-size:1.125em;">
     <div>在台生活福利区</div>
     <div style=" background:url(../plug-in/totaiwan/img/futai_index_bg_2_2.jpg) bottom right no-repeat; height:60px;">&nbsp;</div>
     </div>
     </a>
     <a href="../plug-in/totaiwan/futaiSOS.html"> <div style="background-color:#fbc354; float:left; width:49.5%; height:110px; margin-top:11px; color:#ffffff; text-align:center; padding-top:30px; font-size:1.125em;">
     <div>海外紧急救援专线</div>
     <div style=" background:url(../plug-in/totaiwan/img/futai_index_bg_3_3.jpg) bottom right no-repeat; height:60px;">&nbsp;</div>
     </div>
     </a>
     <a href="#" onclick="cs();"> <div style="background-color:#db585e; float:right; width:49.5%; height:110px; margin-top:11px; color:#ffffff; text-align:center; padding-top:30px; font-size:1.125em;">
     <div>在线投保</div>
     <div style=" background:url(../plug-in/totaiwan/img/futai_index_bg_4_4.jpg) bottom right no-repeat; height:60px;">&nbsp;</div>
     </div>
     </a>
    </div>
    <div style="clear:both; height:10px;">&nbsp;</div>
   </div>


</div>
  <!-- content end -->

</div>

<script>
$('.btn-loading-example').click(function () {
  var $btn = $(this)
  $btn.button('loading');
    setTimeout(function(){
      $btn.button('reset');
  }, 5000);
});

function cs(){	
	var openid='${openid}';
	var actionurl="${webRoot}/fo/taitravelController.do?indexTaitravel";
	var dat="&openid="+openid;
	  location.href=actionurl+dat;	
}
</script>

</body>
</html>
