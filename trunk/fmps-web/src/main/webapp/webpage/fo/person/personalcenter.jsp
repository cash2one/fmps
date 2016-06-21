<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
	[data-am-widget='tabs'] {
		margin: 0px 0px -5px 0px;
	}
	.am-navbar{
		height:51px;
	}
	.am-tabs-bd{
		border:0px;
	}
</style>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$(
					'.a_center_che,.a_center_yi,.a_center_jia,.a_center_you,.a_center_jian,.a_center_ze')
					.click(
							function() {
								var classname = $(this).attr('class');
								var inscode = "";
								if (classname == 'a_center_yi') {		//意外险 03
									inscode = "03";
								} else if (classname == 'a_center_jia') {
									inscode = "02";
								} else if (classname == 'a_center_you') {
									inscode = "04";
								} else if (classname == 'a_center_jian') {
									inscode = "05";
								} else if (classname == 'a_center_che') {
									inscode = "01";
								} else if (classname == 'a_center_ze') {
									inscode = "06";
								}
								var url = "${webRoot}/fo/binded/personalCenter/customerPolicy.do?list&openid=${openid}&p2="
										+ inscode;
								changePage(url);
							});
		});

		function changePage(url) {
			location.href = url;
			//$.mobile.changePage(url, { transition: "slide"},true);
		}
	</script>
	<!--  保单     -->
	<header data-am-widget="header" class="am-header am-header-default">
	<h1 class="am-header-title">
		<a href="#title-link" class="">个人信息</a>
	</h1>
	</header>

	<div class="user_bg">
		<div style="height:18px;"></div>
		<div class="user_touxiang">
			<img src="${headimgurl}" width="54" height="54"
				style="-webkit-border-radius: 50px; -moz-border-radius: 50px; -o-border-radius: 50px; border-radius: 50px; ">
		</div>
		<div class="name_text">
			<h2 class="am-header-title">${nickname}</h2>
		</div>
	</div>

	<div data-am-widget="tabs" class="am-tabs am-tabs-default"
		id="doc-my-tabs">
		<div class="am-tabs-bd	">
			<!-- 保单 -->
			<div data-tab-panel-0 class="am-tab-panel am-active">
				<div class="infometion_center">
					<div class="infometion_up">
						<div class="a_center_che">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_1.jpg"
								width="75" height="66" style="padding-top: 16px;" />
							<div style="margin-top:-9px;">车 险</div>
						</div>
						<div class="a_center_yi">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_2.jpg"
								width="65" height="56" style="padding-top: 13px;" />
							<div>意外险</div>
						</div>
						<div class="a_center_jia">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_3.jpg"
								width="65" height="56" style="padding-top: 13px;" />
							<div>家财险</div>
						</div>
					</div>
					<div class="infometion_down">
						<div class="a_center_you">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_4.jpg"
								width="65" height="56" style="padding-top: 13px;" />
							<div>旅游险</div>
						</div>
						<div class="a_center_jian">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_5.jpg"
								width="65" height="56" style="padding-top: 13px;" />
							<div>健康险</div>
						</div>
						<div class="a_center_ze">
							<img src="${webRoot}/plug-in/weixin/image/user_icon_6.jpg"
								width="65" height="56" style="padding-top: 13px;" />
							<div>责任险</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /am-tabs-bd -->

		<ul class="fb-am-tabs-nav am-cf  am-navbar ">
			<li class="am-active"	style="margin-top:3px;"><a
				href="${webRoot}/fo/binded/personalCenter.do?method=personindex&openid=${openid}">
					<span class="am-icon-edit"></span> <span class="am-tabs-label">保单</span>
			</a></li>
			<li class="" style="margin-top:3px;"><a
				href="${webRoot}/fo/binded/personalCenter/service.do?serviceindex&openid=${openid}">
					<span class="am-icon-user"></span> <span class="am-tabs-label">服务</span>
			</a></li>
			<li class="" style="margin-top:3px;"><a
				href="${webRoot}/fo/binded/personalCenter/accomplishment.do?achvindex&openid=${openid}">
					<span class="am-icon-trophy"></span> <span class="am-tabs-label">成就</span>
			</a></li>
		</ul>
	</div>
	<!-- /doc-my-tabs -->

</body>
</html>