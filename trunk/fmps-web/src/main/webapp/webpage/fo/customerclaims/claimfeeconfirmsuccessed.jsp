<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
</head>
<body>
  <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title">确认结果</h1>
  </header>
  
	<div style="height: 20px"></div>
	<div style="width: 90%; margin: 0 auto; text-align: center;">
	 <span style="font-size: 1.8rem;">本次事故理赔金额为：</span><br>
	 <span style="font-size: 1.6rem;">人民币 ${claimFee } 元 (大写：${upperClaimFee })</span>
	</div>
	<div style="height: 60px"></div>
	<div align="center" style="font-size: 1.8rem;">确认成功</div>
  
</body>
</html>