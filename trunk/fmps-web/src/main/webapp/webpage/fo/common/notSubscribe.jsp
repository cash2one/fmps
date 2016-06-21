<%@page import="cn.com.fubon.util.Constants"%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<title>富邦财险</title>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default">
	   <h1 class="am-header-title">
	     信息提示
	   </h1>
	</header>

	<div class="tips_center">
		<div class="bd_Tips_text">${message }</div>
		<c:choose>
		  	<c:when test="${message != null}">
			  <div class="bd_Tips_img" style=" padding-top:30px;"><img src="${webRoot }/plug-in/fo/images/erweima.jpg" height="160" width="160" /></div>
		  	</c:when>
	    </c:choose>
	</div>


</body>
</html>
