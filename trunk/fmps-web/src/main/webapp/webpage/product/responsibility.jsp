<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>责任维护</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" layout="table"
		action="ProductController.do?aopreb">
		<input name="id" type="hidden" value="${id}">
		<input name="productid" type="hidden" value="${productid}">
		<input name="planid" type="hidden" value="${planid}">
		<input name="kindid" type="hidden" value="${kindid}">
		<table style="width: 100%" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 责任代码: </label></td>
				<td colspan="3" class="value"><input id="liabilitycode"
					name="liabilitycode" class="inputxt" value="${liabilitycode}"
					datatype="s1-20"> <span class="Validform_checktip">责任代码不为空</span>
				</td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 保险责任: </label></td>
				<td colspan="3" class="value"><input name="liability"
					id="liability" class="inputxt" value="${liability}"
					datatype="*1-100"> <span class="Validform_checktip">保险责任不能为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 保额: </label></td>
				<td colspan="3" class="value"><input name="amount" id="amount"
					class="inputxt" value="${amount}" datatype="n1-10"> <span
					class="Validform_checktip">1~10位数字</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 单位: </label></td>
				<td colspan="3" class="value"><select id="unit"
					name="unit" datatype="*"><option value="万元"
							<c:if test="${unit=='万元'}">selected</c:if>>万元</option>
						<option value="元/天" <c:if test="${unit=='元/天'}">selected</c:if>>元/天</option>
						<option value="元" <c:if test="${unit=='元'}">selected</c:if>>元</option></select>
					<span class="Validform_checktip">请选择单位</span></td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>