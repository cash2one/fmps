<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>  
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="format-detection" content="telephone=no"/>
	<title>理赔专区</title>
	<script type="text/javascript" src="${webRoot}/plug-in/claims/js/modernizr.js"></script>
	<link rel="stylesheet" href="${webRoot}/plug-in/claims/css/timeline.css" />
	<style type="text/css">
	body {
		max-width: 640px;
	}
	
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
	
	#cd-timeline {
		position: relative;
		padding: 0em 0.5em;
		margin-top: 1em;
		margin-bottom: 1em;
	}
	
	.cd-timeline-content {
		margin-left: 30px;
		border-bottom: 1px solid #e8e8e8;
	}
	
	.cd-timeline-img {
		position: absolute;
		top: 3px;
	}
	
	#cd-timeline::before {
		top: 3px;
	}
	
	h1, h2, h3, h4, h5, h6 {
		margin: 0 0 1.2rem 0;
		font-weight: 600;
		font-size:14px;
	}
	.cd-timeline-content p, .cd-timeline-content .cd-read-more, .cd-timeline-content .cd-date {
		font-size: 12px;
	}
	
	.tel_bg {
		background: #1490d7;
	}
	
	.tel_input {
		width: 70%;
		margin: 0 auto;
		padding-top: 25px;
		font-size: 12px;
	}
	
	.tel_button {
		background-color: #feb402;
		width: 70%;
		margin: 0 auto;
		font-size: 12px;
		text-align: center;
		color: #fff;
		height: 30px;
		margin-top: 25px;
		border-radius: 5px;
		line-height: 30px;
	}
	
	.title_img {
		margin: 0 auto;
		width: 90%;
		padding-top: 30px;
		border-bottom: 1px solid #e8e8e8;
		padding-bottom: 10px;
	}
	</style>
</head>

<body>
<input type="hidden" id="openid" name="openid" value="${openid}" />

<header data-am-widget="header" class="am-header am-header-default">
	<h1 class="am-header-title" style="color: #171717;">理赔资料收集</h1>
</header>

<div class="tel_bg">
	<div class="tel_input">
		<input id="phonenum" name="phonenum" type="text" style="height: 30px; border: 0px solid; width: 100%; border-radius: 5px; text-indent: 5px;" maxlength="30" placeholder="请输入您的报案电话" />
	</div>
	<div class="tel_button" onclick="searchCaseList()">下一步</div>
	<div id="msgtemp" style="padding:10px 10px; text-align:center; border:none; color:red; display:none"></div>
	<div>
		<img src="${webRoot}/plug-in/claims/images/tel_bg.jpg" />
	</div>
</div>

<div class="title_img">
	<img src="${webRoot}/plug-in/claims/images/tel_title.jpg" width="92" height="18" />
</div>
<section id="cd-timeline" class="cd-container">
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location"></div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5>1.发生保险事故</h5>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location"></div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5>2.拨打报案专线</h5>
			<p>当您在大陆地区请拨打:<a href="tel:4008-817-518"> 4008-817-518</a><br />当您在台湾地区请拨打:<a href="tel:02-6603-1581">（02）6603-1581</a></p>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location">
			<!--<img src="images/cd-icon-location.svg" alt="Location">-->
		</div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5>3.理赔受理</h5>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location"
			style="background-color: #1490d7; font-weight: 500px;">
			<!--<img src="images/cd-icon-location.svg" alt="Location">-->
		</div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5 style="color: #1490d7;">4.理赔资料收集</h5>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location">
			<!--<img src="images/cd-icon-location.svg" alt="Location">-->
		</div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5>5.理赔金额确认</h5>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->

	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-location">
			<!--<img src="images/cd-icon-location.svg" alt="Location">-->
		</div>
		<!-- cd-timeline-img -->

		<div class="cd-timeline-content">
			<h5>6.赔付金给付结案</h5>
		</div>
		<!-- cd-timeline-content -->
	</div>
	<!-- cd-timeline-block -->
</section>

<script type="text/javascript">
$(function(){
	$("link[href*='fb-main.css']").remove();
});

function searchCaseList(){
	var openid=$("#openid").val();
	var phonenum = $("#phonenum").val();
	var re=/^[0-9]*$/;
	if(phonenum==""||phonenum==null){
    	$("#msgtemp").text('**报案电话不能为空').css("display","block");
        return;
    }
    if(phonenum.length<5){
    	$("#msgtemp").text('**报案电话要大于5位').css("display","block");
        return;
    }
	if(!re.test(phonenum)){
		$("#msgtemp").text('**报案电话只能是数字').css("display","block");
        return;
    }
	$("#msgtemp").text("").css("display","none");
	
	location.href="${webRoot}/fo/notCarClaimController.do?caselist&openid="+openid+"&phonenum="+phonenum;
}
</script>
</body>
</html>