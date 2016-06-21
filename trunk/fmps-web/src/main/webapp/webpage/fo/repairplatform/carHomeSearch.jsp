<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>富邦财险</title>
	<meta name="keywords" content="user">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="renderer" content="webkit" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<%@ include file="/webpage/fo/common/fotags.jsp"%>
  	<link href="http://cdn.amazeui.org/amazeui/2.5.0/css/amazeui.min.css" />
  	<link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/search.css" />
</head>

<body>
	<div class="top_search">
		<div class="top_search_left">
			<div class="top_search_left_img">
				<img src="${webRoot}/plug-in/carHome/images/search_icon_2.jpg" width="22" height="22" />
			</div>
			<div class="top_search_left_input">
				<input id="searchnameId" type="text" size="30" value="${searchname }" placeholder="请搜索" />
			</div>
		</div>
		<div class="top_search_right" onClick="javascript:history.go(-1);">取消</div>
	</div>
	<div class="center_search">
		<div class="certer_search_title">热门搜索</div>
		<div class="certer_search_name">
			<div class="center_search_text">
				<div class="text_1">洗车</div>
				<div class="text_1">四轮定位工时券</div>
				<div class="text_1">三清工时券</div>
			</div>
			<div class="center_search_text">
				<div class="text_1">喷漆</div>
				<div class="text_1">打蜡券</div>
				<div class="text_1">机油保养</div>
			</div>
			<div class="center_search_text">
				<div class="text_1">维修代步</div>
				<div class="text_1">检测评估</div>
				<div class="text_1">空调清洗</div>
			</div>
			<div class="center_search_text_1">
				<div class="text_1">烤漆</div>
				<div class="text_1">消毒</div>
				<div class="text_1">钣金抵用券</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var citycode = '${citycode}';
	var address = escape(encodeURIComponent('${address}'));
	var order = '${order}';
	var paging = '${paging}';
// 	console.info(citycode);
// 	console.info(address);
// 	console.info(order);
// 	console.info(paging);
	
	$(function(){
		document.onkeydown = keyDown;
		
		function keyDown(e) {
			var keycode = e.which;
			var realkey = String.fromCharCode(e.which);
// 			console.info("字符："+realkey);
		   	if(keycode==13){//回车
		   		gotoSearch();
		   	}
		}
		
		$("div.text_1,div.text_2").on("click",function(){
			var hotword = $(this).text();
			$("#searchnameId").val(hotword);
			gotoSearch();
		});
		
		function gotoSearch(){
			var searchname = $("#searchnameId").val();
			var encodesearchname = escape(encodeURIComponent(searchname));

	   		var url = "${webRoot}/fo/carHomeController.do?method=toCarHomeSearchResultPage"+
	   				"&openid=${openid}"+
	   				"&citycode="+citycode+
	   				"&address="+address+
	   				"&order="+order+
	   				"&paging="+paging+
	   				"&searchname="+encodesearchname;
// 			console.info(url);
			location.href = url;
		}
	});
	</script>
</body>
</html>
