<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<title>赴台学生信息</title>
		<t:base type="jquery,easyui,tools"></t:base>
	</head>
	<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="${webRoot}/mailsending/toTaiwanMailController.do?saveorupdate">
		<table style="width:100%" cellpadding="0" cellspacing="1" class="formtable">
			<tr style="display:none">
				<td>
					<input type="hidden" id="id" class="inputxt" name="id" value="${id}">
				</td>
			</tr>
			<tr>
				<td align="right" style="width: 65px">
					<label class="Validform_label"> 姓名: </label>
				</td>
				<td colspan="3" class="value">
					<input id="name" class="inputxt" name="name" value="${name}" datatype="*" nullmsg="姓名不能为空！" disabled="disabled">
					<span class="Validform_checktip">请输入 姓名！</span>
				</td>
			</tr>
			
			<tr>
				<td align="right" style="width: 65px">
					<label class="Validform_label"> 身份证号: </label>
				</td>
				<td colspan="3" class="value">
					<input id="identifynumber" class="inputxt" name="identifynumber" value="${identifynumber}" datatype="*" nullmsg="身份证号不能为空！" disabled="disabled">
					<span class="Validform_checktip">请输入 身份证号！</span>
				</td>
			</tr>
			
			<tr>
				<td align="right" style="width: 65px">
					<label class="Validform_label"> 性别: </label>
				</td>
				<td colspan="3" class="value">
					<select name="sex" id="sex" <c:if test="${sendstatus=='1'}">disabled="disabled"</c:if>>
						<option value="1"  <c:if test="${sex=='1'}">selected="selected"</c:if>>男</option>
				      	<option value="2"  <c:if test="${sex=='2'}">selected="selected"</c:if>>女</option>
					</select>
					<span class="Validform_checktip">请选择 性别！</span>
				</td>
			</tr>

			<tr>
				<td align="right" style="width: 65px">
					<label class="Validform_label"> 邮箱: </label>
				</td>
				<td colspan="3" class="value">
					<input id="email" class="inputxt" name="email" value="${email}" datatype="e" errormsg="邮箱非法" nullmsg="邮箱不能为空！" <c:if test="${sendstatus=='1'}">disabled="disabled"</c:if>>
					<span class="Validform_checktip">请输入 邮箱！</span>
				</td>
			</tr>
		</table>
	</t:formvalid>
	</body>
</html>