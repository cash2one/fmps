<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
.am-btn {
display: inline-block;
margin-bottom: 0;
padding: 5px 5px 5px 5px;}
</style>
</head>
<body>
  <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title"> 理赔金额确认</h1>
  </header>
	<form name="fm" action="${webRoot}/fo/binded/customerClaims/customerClaimsController.do?method=confirmClaimFee&openid=${openid }&registNo=${registNo }" method="post">
		<div style="height: 20px"></div>
		<div style="width: 90%; margin: 0 auto; text-align: center;">
		 <span style="font-size: 1.8rem;">本次事故理赔金额为：</span><br>
		 <span style="font-size: 1.6rem;">人民币 ${claimFee } 元 (大写：${upperClaimFee })</span>
		</div>
		<div style="height: 60px"></div>
		<div align="center">
			<input type="submit" value="确 认" class="am-btn am-btn-primary am-btn-lg" style="width: 80%; border-radius:5px;" />
			<div style="padding-top: 10px;font-size: 1.6rem;">(如无操作系统将在5分钟后自动确认)</div>
		</div>
	</form>
</body>
</html>