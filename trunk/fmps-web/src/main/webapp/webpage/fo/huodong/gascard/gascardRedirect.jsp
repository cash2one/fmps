<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ include file="/webpage/fo/common/fotags.jsp"%> 
<!doctype html>
<head>
<title></title>
   <!-- <meta http-equiv="refresh" content="0;url="http://www.baidu.com">  -->
</head>
<body>
<script type="text/javascript">
    	$(document).ready(function () {
    		location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FgasCardController.do%3FgasCardIndex%26id%3D8a828ebb49166847014916deca570006&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";	    
      }); 
</script> 
</body>
</html>