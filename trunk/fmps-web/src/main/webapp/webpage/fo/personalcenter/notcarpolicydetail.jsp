<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
	.am-table > thead > tr > th,
	.am-table > tbody > tr > th,
	.am-table > tfoot > tr > th,
	.am-table > thead > tr > td,
	.am-table > tbody > tr > td,
	.am-table > tfoot > tr > td {
	  padding: 0.1rem;
	  line-height: 1.6;
	  vertical-align:middle;
	  border-top: 1px solid #dddddd;
	}
	.am-titlebar {
	  margin-top: 5px;
	}
.card_button {
	width:100%;
	margin:0 auto;
	position:fixed;
	left:0;
	bottom:0;
	z-index:999;
	font-size: 16px;
	text-align: center;
	
}
.am-header {
    position: relative;
    width: 100%;
    height: 49px;
    line-height: 49px;
    padding: 0 10px;
    border-bottom: 2px solid #0e90d2;
    background: #fff;
}
.card_left{ width:100%; margin:0 auto; text-align: center; background-color: #09BB07; color:#fff; height: 40px; line-height: 40px; }
.am-g{ padding-bottom: 35px;}
</style>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default" >
	  <h1 class="am-header-title" style=" color:#171717; ">
	    ${policyHead.riskshortname}
	  </h1>
	</header>
	<%-- <header data-am-widget="header" class="am-header am-header-default">
	    <h1 class="am-header-title">
	      	${policyHead.riskshortname}
	    </h1>
	</header> --%>
	<!-- <div  id="gotoClause" 
		style="position: absolute; background: #dff0d8; color: #4f8253; height: 40px; font-family: '黑体'; width: 100%; font-size: 14px; opacity: 0.95; padding: 11px 5px; text-indent: 5px;z-index: 999;">
		<span onclick="goClause()">您有未确认的条款，点击确认后领取红包奖励。</span><span class="am-icon-close"
			style="float: right; padding-top: 3px;" onclick="hidetips()"></span>
	</div> -->	
	<div class="am-cf admin-main">
		<div class="admin-content">
			 <div class="am-titlebar am-titlebar-default">
 				<h2 class="am-titlebar-title">用户信息</h2>
			 </div>
			 <div style="width:94%; margin:0 auto; border-bottom:1px 0 0 0 solid #ddd; height:auto; margin-bottom:10px; font-size:1em; padding:5px 0px 5px 5px;">       
				保单号：${policyHead.policyno}
		        <br/>被保险人：${policyHead.insuredname}
		        <br/>证件号码：${policyHead.identifynumber}
		        <br/>保险起始日期：${policyHead.startdate}
		        <br/>保险终止日期：${policyHead.enddate}
		        <c:if test="${policyHead.endhour != null && policyHead.endhour ne '00' && policyHead.endhour ne '24' }">${policyHead.endhour }时</c:if>
		        <c:if test="${policyHead.status != null }">
					<span style="color: red;font-size: 12px;"> 已失效</span>
				</c:if>
				<br/>保费：<fmt:formatNumber value="${policyHead.sumPremium}" pattern="#,##0.00#" />
				<div style="position: absolute; top: 140px; left: 70%;"><img src="${webRoot}/plug-in/fo/images/certificate.png" width="70" height="68"  /></div>
			</div>
		    
		    <div class="am-g">
		      <div class="am-u-sm-12">
		        <form class="am-form">
		          <table class="am-table am-table-hover table-main">
		            <thead>
		              <div style="width:35%; float:left; text-align:center; color:#0099FF;">险种名称</div>
		              <div style="width:35%; float:left; text-align:center; color:#0099FF;">保障信息</div>
		              <div style="width:30%; float:left; text-align:center; color:#0099FF;">保额</div>
		           </thead>
		          <tbody>
		          	<c:forEach items="${policyBodys}" var="policyBody">
			            <tr>
			              <td colspan="2" style="width:35%;  text-align:center;">${policyBody.kindname }</td>
			              <td style="width:35%;  text-align:center;">${policyBody.itemdetailname }</td>
			              <td style="width:30%;  text-align:right;">
						  	<fmt:formatNumber value="${policyBody.amount}" pattern="#,##0.00#" />
						  </td>
			            </tr>
			         </c:forEach>
		          </tbody>
		        </table>
		        
		        </form>
		      </div>
		
		    </div>  <!--  /am-g -->
		     <c:if test="${greetingCardLink==1}" >
		    <div>
		    <a href="${webRoot}/plug-in/huodong/lunarnewyear/greeting_card.html"  >富邦新春贺卡，点击领取送家人 </a>
		    </div>
		    </c:if>     
		</div>	<!-- /admin-content -->
	</div>
	<div class="card_button">
	<c:if test="${hasUnReadClause=='YES'}">
		<!-- <div class="card_left" onclick="goClause()">查看条款有惊喜</div> -->
		<div class="card_left" onclick="goClause()">查看条款</div>
	</c:if>
	<c:if test="${hasUnReadClause=='NO'}">
		<div class="card_left" onclick="goClause()">查看条款</div>
	</c:if>
    </div>
<script type="text/javascript">
		/* $(document).ready(function() {
			if ('${hasUnReadClause}' == 'YES') {
				$("#gotoClause").css("display", "block");
			}else{
				$("#gotoClause").css("display", "none");
			}
		});
		
		function hidetips(){
			$("#gotoClause").css("display", "none");
		} */
		function goClause() {
			location.href="${webRoot}/fo/binded/personalCenter/policyController.do?method=goClause&openid=${openid}&policyno=${policyHead.policyno}&productcode=${productcode}&hasUnReadClause=${hasUnReadClause}";
		}
</script>
</body>
</html>