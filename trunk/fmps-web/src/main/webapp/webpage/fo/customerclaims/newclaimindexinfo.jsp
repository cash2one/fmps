<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>富邦财险</title>
  <link rel="stylesheet" href="${webRoot}/plug-in/customerclaim/css/claims_record.css">
</head>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#132a39; font-size:18px;">
    理赔记录
  </h1>
</header>
<div class="claims_record_style">
 <div class="claims_record_insurance">

 <c:forEach items="${indexList}" var="indexData">
 	 <c:if test="${indexData.tempReportYear != null}">
	 	<div class="claims_record_insurance_text">${indexData.tempReportYear }</div>
	 </c:if>
 	<a href="${webRoot}/fo/binded/customerClaims/newCustomerClaimsController.do?getClaimDetailInfo&registno=${indexData.registno }&id=${indexData.ID}">
	   <div class="claims_record_insurance_anniu">
	    <div class="text"><span class="text_2">${indexData.title }</span><br/>${indexData.nodename }<br/><span class="text_1">${indexData.current_desc }</span></div>
	    <div class="time">${indexData.flowintime}</div>
	    <div class="tu"><img src="${webRoot}/plug-in/customerclaim/images/right.png" width="8" height="15"/></div>
	   </div>
   </a>
   </c:forEach>

 </div>
</div>
</body>
</html>