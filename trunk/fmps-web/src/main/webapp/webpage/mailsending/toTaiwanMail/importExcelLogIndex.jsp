<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="logList" title="查看导入日志" actionUrl="toTaiwanMailController.do?importExcelLogDatagrid" idField="id" fit="true" fitColumns="false" queryMode="group" pageSize="20">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="姓名" field="name" width="80" query="true"></t:dgCol>
	<t:dgCol title="身份证号" field="identifynumber" width="160" query="true"></t:dgCol>
	<t:dgCol title="性别" field="sex" replace="男_1,女_2, _0"></t:dgCol>
	<t:dgCol title="邮箱" field="email"></t:dgCol>
	<t:dgCol title="导入批次号" field="importBatchId" width="130" query="true"></t:dgCol>
	<t:dgCol title="导入时间" field="importTime" width="150" formatter="yyyy-MM-dd hh:mm:ss" queryMode="group" query="true"></t:dgCol>
	<t:dgCol title="操作人" field="importOperator" query="true"></t:dgCol>
	<t:dgCol title="导入结果" field="importResult" query="true"></t:dgCol>
	<t:dgCol title="活动id" field="huodongid" query="true"></t:dgCol>
</t:datagrid></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='importTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='importTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});
</script>