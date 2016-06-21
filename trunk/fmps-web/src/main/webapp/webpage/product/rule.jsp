<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>规则信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" layout="table"
		action="ProductController.do?addorupdaterule">
		<input name="id" type="hidden" value="${id}">
		<input name="productid" type="hidden" value="${productid}">
		<table style="width: 100%" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 规则名称: </label></td>
				<td colspan="3" class="value"><input id="rulename"
					name="rulename" class="inputxt" value="${rulename}"
					datatype="s1-100"> <span class="Validform_checktip">规则名称不为空</span>
				</td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 规则类型: </label></td>
				<td colspan="3" class="value"><select id="ruletype"
					name="ruletype" datatype="*"><option value="投保人"
							<c:if test="${ruletype=='投保人'}">selected</c:if>>投保人</option>
						<option value="被保人"
							<c:if test="${ruletype=='被保人'}">selected</c:if>>被保人</option></select><span
					class="Validform_checktip">规则类型不为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 规则分类: </label></td>
				<td colspan="3" class="value"><select id="ruleclass"
					name="ruleclass" datatype="*"><option value="年龄规则"
							<c:if test="${ruleclass=='年龄规则'}">selected</c:if>>年龄规则</option>
						<option value="份数规则"
							<c:if test="${ruleclass=='份数规则'}">selected</c:if>>份数规则</option></select><span
					class="Validform_checktip">请选择规则分类</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 最小值: </label></td>
				<td colspan="3" class="value"><input id="minage" name="minage"
					class="inputxt" value="${minage}" datatype="n1-3"> <span
					class="Validform_checktip">最小值不为空，1~3位数字</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 最大值: </label></td>
				<td colspan="3" class="value"><input name="maxage" id="maxage"
					class="inputxt" value="${maxage}" datatype="n1-3"> <span
					class="Validform_checktip">最大值不能为空，1~3位数字</span></td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>