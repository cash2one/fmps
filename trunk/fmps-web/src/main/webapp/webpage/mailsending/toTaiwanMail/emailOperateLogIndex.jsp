<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="logList" title="操作日志" actionUrl="toTaiwanMailController.do?emailOperateLogDatagrid" idField="id" fit="true" fitColumns="false" queryMode="group" pageSize="20">
	<t:dgCol title="操作日志id" field="operatelogId" query="true"  extend="{style:{width:300px}}"></t:dgCol>
	<t:dgCol title="浏览器" field="broswer" width="80"></t:dgCol>
	<t:dgCol title="操作动作" field="operateType"></t:dgCol>
	<t:dgCol title="日志内容" field="logContent"></t:dgCol>
	<t:dgCol title="批次号" field="importBatchId" width="130"></t:dgCol>
	<t:dgCol title="活动id" field="huodongid"></t:dgCol>
	<t:dgCol title="操作人" field="operater" query="true"></t:dgCol>
	<t:dgCol title="ip地址" field="ipAddr"></t:dgCol>
	<t:dgCol title="操作时间" field="operateTime" width="150" formatter="yyyy-MM-dd hh:mm:ss" queryMode="group" query="true"></t:dgCol>
</t:datagrid></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='operateTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='operateTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});
</script>