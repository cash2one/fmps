<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
	function studentListExportXls() {
		var url = "${webRoot}/export/emailTemplate/blankTemplate.xls";
		location.href = url;
	}
	function studentListImportXls() {
		openuploadwin('Excel导入', '${webRoot}/mailsending/toTaiwanMailController.do?upload', "studentList");
	}
	function sendSingeleEmail() {
		var row = $('#studentList').datagrid('getSelections');
		if(row.length > 1){
			$.messager.alert('提示','"重新发送"只能发送一条邮件，请重新选择','warning');
			return;
		} else if (row.length == 0){
			$.messager.alert('提示','请选择一条记录再发送','warning');
			return;
		}

		$.ajax({
			url : "${webRoot}/mailsending/toTaiwanMailController.do?sendSingeleEmail",
			data : {
				"selectArray":JSON.stringify(row)
			},
			type : "POST",
			dataType: "json",
			beforeSend : function(){
				ajaxLoading();
			},
			success : function(data) {
				ajaxLoadEnd();
				if(data.success){
					$.messager.alert('提示', data.msg);
				}else{
					$.messager.alert('提示', data.msg);
				}
			},
			error : function(e) {
				ajaxLoadEnd();
				alert("发送邮件失败");
			}
		});
	}
	
	function sendBatchEmail() {
		var row = $('#studentList').datagrid('getSelections');
		if (row.length == 0){
			$.messager.alert('提示','请选择一条或多条记录再发送','warning');
			return;
		}
		
		$.ajax({
			url : "${webRoot}/mailsending/toTaiwanMailController.do?sendBatchEmail",
			data : {
				"selectArray":JSON.stringify(row)
			},
			type : "POST",
			dataType: "json",
			beforeSend : function(){
				ajaxLoading();
			},
			success : function(data) {
				ajaxLoadEnd();
				if(data.success){
					$.messager.alert('提示', data.msg);
				}else{
					$.messager.alert('提示', data.msg);
				}
			},
			error : function(e) {
				ajaxLoadEnd();
				alert("批量发送邮件失败");
			}
		});
	}
	
	function ajaxLoading() {
		$("<div class=\"datagrid-mask\"></div>").css({
			display : "block",
			width : "100%",
			height : $(window).height()
		}).appendTo("body");
		$("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。")
				.appendTo("body").css({
					display : "block",
					left : ($(document.body).outerWidth(true) - 190) / 2,
					top : ($(window).height() - 45) / 2
				});
	}
	function ajaxLoadEnd() {
		$(".datagrid-mask").remove();
		$(".datagrid-mask-msg").remove();
	}
</script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="studentList" title="赴台学生信息" actionUrl="${webRoot}/mailsending/toTaiwanMailController.do?datagrid" idField="id" fit="true" fitColumns="false" queryMode="group" checkbox="true" pageSize="20">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="姓名" field="name" width="80" query="true"></t:dgCol>
	<t:dgCol title="身份证号" field="identifynumber" width="160" query="true"></t:dgCol>
	<t:dgCol title="性别" field="sex" replace="男_1,女_2"></t:dgCol>
	<t:dgCol title="邮箱" field="email"></t:dgCol>
	<t:dgCol title="邮件发送时间" field="sendtime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgCol title="邮件发送状态" field="sendstatus" replace="发送成功_1,发送失败_2, _0"></t:dgCol>
	<t:dgCol title="赠险单号" field="insuranceno" query="true"></t:dgCol>
	<t:dgCol title="操作日志id" field="operatelogId"></t:dgCol>
	<t:dgCol title="导入批次号" field="importBatchId" width="130"></t:dgCol>
	<t:dgCol title="操作时间" field="importTime" width="150" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgCol title="操作人" field="importOperator" query="true"></t:dgCol>
	<t:dgCol title="活动id" field="huodongid"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除" url="${webRoot}/mailsending/toTaiwanMailController.do?del&id={id}" />
	<t:dgToolBar title="编辑" icon="icon-edit" url="${webRoot}/mailsending/toTaiwanMailController.do?jumpView" funname="update"></t:dgToolBar>
	<t:dgToolBar title="导入Excel" icon="icon-put" onclick="studentListImportXls()"></t:dgToolBar>
	<t:dgToolBar title="下载导入模板" icon="icon-putout" onclick="studentListExportXls();"></t:dgToolBar>
	<t:dgToolBar title="批量发送赠险邮件" icon="icon-redo" url="${webRoot}/mailsending/toTaiwanMailController.do?sendBatchEmail" funname="sendBatchEmail()"></t:dgToolBar>
	<t:dgToolBar title="重新发送" icon="icon-redo" url="${webRoot}/mailsending/toTaiwanMailController.do?sendSingeleEmail" funname="sendSingeleEmail()"></t:dgToolBar>
</t:datagrid></div>
</div>