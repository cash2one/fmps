<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>保险条款</title>
<meta name="description" content="这是一个 user 页面">
<meta name="keywords" content="user">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<%--   <link href="${webRoot}/plug-in/amaze-ui/css/amazeui.css" rel="stylesheet" type="text/css" />
  <link href="${webRoot}/plug-in/assets/css/admin.css" rel="stylesheet" type="text/css" /> --%>
<link href="${webRoot}/plug-in/fo/css/new.css" rel="stylesheet"
	type="text/css" />
</head>

<style type="text/css">
.am-selected-btn {
	text-align: right;
	width: 100px;
}

.am-btn-default {
	border: 0px;
}

.am-btn {
	display: inline-block;
	margin-bottom: 0;
	padding: 0.225em 1em;
}

.am-btn-primary {
	width: 96%;
}

img {
	max-width: 100%;
	height: auto;
}

header {
	height: 50px;
	line-height: 0px;
}

.am-topbar {
	position: none;
	min-height: 0px;
	margin-bottom: 0rem;
}

.am-btn-success {
	color: #fff;
	background-color: #f8a3a8;
	border: 0px;
}
</style>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<header class="am-topbar admin-header">
		<header data-am-widget="header" class="am-header am-header-default">
			<h1 class="am-header-title">保险条款</h1>
		</header>
	</header>
	<section data-am-widget="accordion"
		class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
		<dl class="am-accordion-item" style="clear: both;">
			<dt class="am-accordion-title" style="background-color: #f5f5f5;">
				<div id="desc"></div>
			</dt>
			<dd class="am-accordion-bd am-collapse am-in"  style="height: 0px;">
				<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
				<div class="am-accordion-content" style="font-size: 0.625em;">
					<div id="doc"></div></div>
			</dd>
		</dl>
	</section>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#desc").html(window.opener.document.getElementById("description").value);
					$("#doc").html(window.opener.document.getElementById("document").value);
				});
	</script>
</body>
</html>