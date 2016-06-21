<%@page import="cn.com.fubon.util.Constants"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
body {
	background-color: #f5f5f5;
}
</style>

<%
	String messageType = (String) request
			.getAttribute(Constants.MESSAGE_TYPE);
	String messageTypeInfo = Constants.MESSAGE_TYPE_INFO;
	String messageTypeWarn = Constants.MESSAGE_TYPE_WARN;
	String messageTypeError = Constants.MESSAGE_TYPE_ERROR;
%>
</head>

<body>
	<c:set var="messageType" value="<%=messageType%>" />
	<c:set var="messageTypeInfo" value="<%=messageTypeInfo%>" />
	<c:set var="messageTypeWarn" value="<%=messageTypeWarn%>" />
	<c:set var="messageTypeError" value="<%=messageTypeError%>" />
	<header data-am-widget="header" class="am-header am-header-default">
	<h1 class="am-header-title">信息提示</h1>
	</header>

	<div class="tips_center">
		<br /> <br /> <br />
		<c:choose>
			<c:when
				test="${messageType == messageTypeInfo || messageType == null}">
				<div class="tips_center_img">
					<img src="${webRoot }/plug-in/weixin/image/info.jpg" width="140"
						height="140" />
				</div>
			</c:when>
			<c:when test="${messageType == messageTypeWarn}">
				<div class="tips_center_img">
					<img src="${webRoot }/plug-in/weixin/image/tips.jpg" width="140"
						height="140" />
				</div>
			</c:when>
			<c:when test="${messageType == messageTypeError}">
				<div class="tips_center_img">
					<img src="${webRoot }/plug-in/weixin/image/error.jpg" width="140"
						height="140" />
				</div>
			</c:when>
		</c:choose>
		<br />
		<div class="tips_center_text">${message }</div>
	</div>

</body>
</html>
