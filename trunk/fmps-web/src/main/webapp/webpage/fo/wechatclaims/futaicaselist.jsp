<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="format-detection" content="telephone=no"/>
	<title>理赔案件列表</title>
	<script charset="utf-8" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<style type="text/css">
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
	
	.am-checkbox {
		margin-top: 0px;
	}
	
	.am-header .am-header-nav img {
		height: 20px;
	}
	
	.am-header .am-header-title {
		margin: 0 1%;
	}
	
	.evaluate_all{ padding:0 15px;}
	.evaluate_all_title{ color:#919090; font-size:12px; border-bottom:1px solid #e8e8e8; height:25px; font-family:"微软雅黑"; clear:both;}
	.evaluate_all_name{ width:100%;}
	.evaluate_all_name_text{ width:80%; float:left; font-family:"微软雅黑"; font-size:14px; color:#0f90d2; line-height:30px;}
	.evaluate_all_name_button{ width:20%; float:left;}
	.describe{ float:left; width:25%; font-size:14px;}
	.describe_2{ float:left; width:75%; font-size:14px;}
	.fb_Comment_text{  width:100%; padding-left:6px; font-size:14px; color:#292929;}
	.evaluate_button{ width:100%; background-color:#43abea; color:#fff; text-align:center; height:30px;  border-radius:3px; font-size:16px;}
	.pay_menoy_text{ font-size:10px; color:#919090; margin:0 auto; padding-bottom: 10px;}
	</style>
  </head>
  
  <body>
  	<input type="hidden" id="openid" name="openid" value="${openid}" />
  	<input type="hidden" id="phonenum" name="phonenum" value="${phonenum}" />
	
	<header data-am-widget="header" class="am-header am-header-default">
		<h1 class="am-header-title" style="color: #171717;">案件列表</h1>
	</header>
	<div style="height: 15px;">&nbsp;</div>
	<div class="evaluate_all">
		<div class="evaluate_all_title">选择案件</div>
		<div class="evaluate_all_name">
			<c:forEach items="${caselist}" var="reportinfo">
			<div style="border-bottom: 1px solid #e8e8e8; float: left; width: 100%; padding-top: 12px; clear: both;">
				<div class="evaluate_all_name_text">报案号：${reportinfo.registNo}</div>
				<div class="evaluate_all_name_button">
					<div style="background-color: #43abea; width: 60px; height: 30px; color: #fff; font-size: 14px; border-radius: 3px; padding: 3px 0px 0px 13px;" class="casediv" registNo="${reportinfo.registNo}" reportDate="${reportinfo.reportDate}" reportTime="${reportinfo.reportTime}" policyNo="${reportinfo.policyNo}" startDate="${reportinfo.startDate}" endDate="${reportinfo.endDate}" remark="${reportinfo.remark}" caseStatus="${reportinfo.caseStatus}" insuredName="${reportinfo.insuredName}" reportorName="${reportinfo.reportorName}">选
						择</div>
				</div>
				<div
					style="float: left; width: 100%; padding-bottom: 20px; padding-top: 10px;">
					<div class="describe">报案时间</div>
					<div class="describe_2">${reportinfo.reportDate} ${reportinfo.reportTime}</div>
					<div class="describe">保单号</div>
					<div class="describe_2">${reportinfo.policyNo}</div>
					<div class="describe">保险期间</div>
					<div class="describe_2"><fmt:parseDate value="${reportinfo.startDate}" var="start_date" pattern="yyyy-MM-dd"/><fmt:formatDate value="${start_date}" pattern="yyyy-MM-dd" /> 至 <fmt:parseDate value="${reportinfo.endDate}" var="end_date" pattern="yyyy-MM-dd"/><fmt:formatDate value="${end_date}" pattern="yyyy-MM-dd" /></div>
					<div class="describe">被保险人</div>
					<div class="describe_2">${reportinfo.insuredName}</div>
					<div class="describe">案件信息</div>
					<div class="describe_2">${reportinfo.remark}</div>
				</div>
			</div>
			</c:forEach>
			<div style="height: 10px; clear: both;">&nbsp;</div>
			<div class="pay_menoy_text">选择案件信息，直接点击进入</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$(function(){
		$(".casediv").on("click",function(){
			var openid=$("#openid").val();
			var phonenum=$("#phonenum").val();
			var registNo = $(this).attr("registNo");
			var reportDate = $(this).attr("reportDate");
			var reportTime = $(this).attr("reportTime");
			var policyNo = $(this).attr("policyNo");
			var startDate = $(this).attr("startDate");
			var endDate = $(this).attr("endDate");
			var remark = $(this).attr("remark");
			var encoderemark = escape(encodeURIComponent(remark));
			var caseStatus = $(this).attr("caseStatus");
			var insuredName = $(this).attr("insuredName");
			var encodeinsuredName = escape(encodeURIComponent(insuredName));
			var reportorName = $(this).attr("reportorName");
			var encodereportorName = escape(encodeURIComponent(reportorName));
			
	 		location.href="${webRoot}/fo/notCarClaimController.do?toUploadimg&openid="+openid+"&phonenum="+phonenum+"&registNo="+registNo+"&reportDate="+reportDate+"&reportTime="+reportTime+"&policyNo="+policyNo+"&startDate="+startDate+"&endDate="+endDate+"&remark="+encoderemark+"&caseStatus="+caseStatus+"&insuredName="+encodeinsuredName+"&reportorName="+encodereportorName;
		});
	});
	</script>
  </body>
</html>