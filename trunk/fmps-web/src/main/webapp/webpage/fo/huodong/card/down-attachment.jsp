<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head lang="en">
  	<title></title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<body onload="show_div();">

<script type="text/javascript">
	$("<div id='div_brg_div'><br><a href='#' id='close_div'>&nbsp;&nbsp;&nbsp;&nbsp;关闭</a><br><br>"
	+"<div>&nbsp;&nbsp;&nbsp;&nbsp;<font color='#FFFFFF'>附件下载说明</font></div><br>"
	+"<div>&nbsp;&nbsp;&nbsp;&nbsp;<font color='#FFFFFF'>1、请点击右上角<img src='${webRoot}/plug-in/fo/images/right.png'/></font></div><br>"	
	+"<div>&nbsp;&nbsp;&nbsp;&nbsp;<font color='#FFFFFF'>2、选择“在浏览器中打开”<img src='${webRoot}/plug-in/fo/images/browser.png'/></font></div><br>"
	+"<div>&nbsp;&nbsp;&nbsp;&nbsp;<font color='#FFFFFF'>3、进入浏览器页面下载附件</font></div><br>"	
	+"</div>").css({
	position:'absolute',
	top:0,
	left:0,
	backgroundColor:"#3B3B3B",
	opacity:150,
	zIndex:500
	})
	.height($(document).height()+50)
	.width($(document).width()).hide().appendTo("body")
	//需要遮罩的时候
	function show_div() {
		$("#div_brg_div").show();
	}
	
	$("#close_div").click(function () {
	//取消遮罩的时候
	$("#div_brg_div").hide();
	})
</script>
<% 
if (userAgent.indexOf("MicroMessenger")<=-1) { 
	String url=request.getParameter("fileUrl")!=null ? request.getParameter("fileUrl") : "";
	if(!url.equalsIgnoreCase("")){
		String urlhead=url.substring(0, url.lastIndexOf("/")+1);
		String urltail=url.substring(url.lastIndexOf("/")+1, url.length());
		url = urlhead+URLEncoder.encode(urltail);
	}
%>
<c:redirect url="<%=url%>"></c:redirect>
<%} %>
</body>
</html>