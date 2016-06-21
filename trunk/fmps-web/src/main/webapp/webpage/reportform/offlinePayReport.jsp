<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="offlinePayList" title="保费支付报表"
	actionUrl="offlinePayReportController.do?datagrid"
	fit="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="支付码" field="payCode" query="true"></t:dgCol>
	<t:dgCol title="MD5支付码" field="paycodemd5" query="true"></t:dgCol>
	<t:dgCol title="订单状态" field="PayStatus" replace="未支付_0,支付成功_1,支付失败_2"></t:dgCol>
	<t:dgCol title="订单类别" field="ClassCode" replace="车险_CX,非车_FC"></t:dgCol>
	<t:dgCol title="被保险人" field="InsuredName" query="true"></t:dgCol>
	<t:dgCol title="总保费" field="SumPremium"></t:dgCol>
	<t:dgCol title="起保日期" field="PolicyStartDate" formatter="yyyy-MM-dd"></t:dgCol>
	<t:dgCol title="车牌号" field="LicenseNo" query="true"></t:dgCol>
	<t:dgCol title="身份证号" field="IdentifyNumber" query="true"></t:dgCol>
	<t:dgCol title="创建日期" field="CreateTime" queryMode="group" query="true" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>	
</t:datagrid>
<script type="text/javascript">
$("input[name='CreateTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
$("input[name='CreateTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
</script>