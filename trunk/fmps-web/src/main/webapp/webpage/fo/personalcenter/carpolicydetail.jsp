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
	.am-header {
    position: relative;
    width: 100%;
    height: 49px;
    line-height: 49px;
    padding: 0 10px;
    border-bottom: 2px solid #0e90d2;
    background: #fff;
	}
</style>
</head>
<body>

	<header data-am-widget="header" class="am-header am-header-default" >
	  <h1 class="am-header-title" style=" color:#171717; ">
	    ${policyHead.riskshortname}
	  </h1>
	</header>
	<div class="am-cf admin-main">
	  <div class="admin-content">
			 <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
 				<h2 class="am-titlebar-title">用户信息</h2>
			 </div>
			 <div style="width:94%; margin:0 auto; border-bottom:1px 0 0 0 solid #ddd; height:auto; margin-bottom:10px; font-size:1em; padding:5px 0px 5px 5px;">       
				保单号：${policyHead.policyno}
		        <br/>被保险人：${policyHead.insuredname}
		        <br/>车牌号：${policyHead.licenseno}
	        	<c:if test="${policyHead.licensed == 0  }">
						<span style="float: center; font-size: 1em; font-weight: normal;">
							<a href="${webRoot}/fo/binded/customerNewCarLicenceController.do?method=getCustomerNewCarLicence&openid=${openid}"
							style="text-decoration: none; float: right; padding-right: 10px;">新车上牌</a>
						</span>
				</c:if>
		        <br/>保险起始日期：${policyHead.startdate}
		        <br/>保险终止日期：${policyHead.enddate}
		        <c:if test="${policyHead.endhour != null && policyHead.endhour ne '00' && policyHead.endhour ne '24' }">${policyHead.endhour }时</c:if>
		        <c:if test="${policyHead.status != null }">
					<span style="color: red;font-size: 12px;"> 已失效</span>
				</c:if>
				<div style="position: absolute; top: 140px; left: 70%;"><img src="${webRoot}/plug-in/fo/images/certificate.png" width="70" height="68" /></div>
			
			 </div>
	    
		    <div class="am-g">
		      <div class="am-u-sm-12">
		        <form class="am-form">
		          <table class="am-table  am-table-hover table-main">
		            <thead>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">险种名称</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">不计免赔</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">保额</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">费用</div>
		          </thead>
		          <tbody>
		          	<c:forEach items="${policyBodys}" var="policyBody">
			            <tr>
			              <td style="width:25%;  text-align:center; font-size:14px;">${policyBody.kindname }</td>
			              <td style="width:25%;  text-align:center;">${policyBody.isdeductible }</td>
			              <td style="width:25%;  text-align:right;">
							<c:if test="${policyBody.amount ne 0}">
								<fmt:formatNumber value="${policyBody.amount}" pattern="#,##0.00#" />
							</c:if>				
						  </td>
			              <td style="width:25%;  text-align:right;">
						  	<fmt:formatNumber value="${policyBody.premium}" pattern="#,##0.00#" />
						  </td>
			            </tr>
			         </c:forEach>
			         <tr>
						<td style="text-align:center; color:#FF6600;">合计</td>
						<td colspan="2"></td>
						<td style="text-align:right; color:#FF6600;">
							<fmt:formatNumber value="${policyHead.sumpremium}" pattern="#,##0.00#" />
						</td>
					</tr>
		          </tbody>
		        </table>
				  
		        </form>
		      </div>
		
		    </div>  <!--  /am-g -->
	        
	</div>	<!-- /admin-content -->
</div>
		
		

</body>
</html>