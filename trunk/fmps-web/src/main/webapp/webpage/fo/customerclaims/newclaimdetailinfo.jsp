<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>富邦财险</title>
<link href="${webRoot}/plug-in/customerclaim/css/timeline.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${webRoot}/plug-in/customerclaim/css/claims_record.css" type="text/css">

</head>
<style>
#cd-timeline {
	position: relative;
	padding: 0em 0.6em;
	margin-top: 2em;
	margin-bottom: 2em;
}
.am-header-default {
	background-color: #fff;
}
.am-header {
	position: relative;
	width: 100%;
	height: 49px;
	line-height: 49px;
	padding: 0 10px;
	border-bottom: 2px solid #0e90d2;
}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#132a39; font-size:18px;">理赔进度 </h1>
</header>
<div class="claims_record_1_style">
 <div class="claims_record_1_insurance">
   <div class="claims_record_1_insurance_anniu">
    <div class="text"><span style="color:#4dc6f2">${claimRecord.title }</span><br/></div>
   </div>
 </div>
</div>
<div class="insurance_xian">&nbsp;</div>
<div class="claims_record_1_style">
 <div class="claims_record_1_insurance">
  <div class="claims_record_1_insurance_text">案件经过：</div>
   <div class="claims_record_1_insurance_anniu_1"> 
   		 ${claimRecord.remark }
   </div>
 </div>
</div>
<div class="insurance_xian">&nbsp;</div>
	<section id="cd-timeline" class="cd-container" >
		<c:forEach items="${detailList}" var="detailData">
			<div class="cd-timeline-block">
				<div class="cd-timeline-img cd-location" >
				</div>
				<div class="cd-timeline-content">
					<c:choose>
						<c:when test="${detailData.nodename eq claimRecord.nodename}">
							<h5 style="color:#25ae5f; font-size: 14px;">${detailData.nodename }</h5>
						</c:when>
						<c:otherwise>
							<h5 style="font-size: 14px;">${detailData.nodename }</h5>
						</c:otherwise>
					</c:choose>
					<p style="font-size: 13px;">${detailData.nodedesc }<br />${detailData.flowintime }</p>
				</div> 
			</div> 
       </c:forEach>
	</section>
	
</body>
</html>