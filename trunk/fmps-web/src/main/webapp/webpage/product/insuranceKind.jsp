<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>商品信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" layout="table"
		action="ProductController.do?aopkind">
		<input name="id" type="hidden" value="${id}">
		<input name="productid" type="hidden" value="${productid}">
		<input name="planid" type="hidden" value="${planid}">
		<table style="width: 100%" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 险种代码: </label></td>
				<td colspan="3" class="value"><input name="kindcode"
					id="kindcode" class="inputxt" value="${kindcode}" datatype="s1-10">
					<span class="Validform_checktip">险种代码为1-10位字符，不能为空</span></td>
			</tr>	
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 险种名称: </label></td>
				<td colspan="3" class="value"><input name="kindname"
					id="kindname" class="inputxt" value="${kindname}" datatype="*">
					<span class="Validform_checktip">险种名称不能为空</span></td>
			</tr>						
			<tr>
			<td align="right"><label class="Validform_label"> 条款: </label></td>
			<td class="value"><select id="affiliatedId" name="affiliatedId" datatype="*">
				<c:forEach items="${affList}" var="affiliated">
					<option value="${affiliated.id }" <c:if test="${affiliated.id==affiliatedId}">selected="selected"</c:if>>${affiliated.description}</option>
				</c:forEach>
			</select> <span class="Validform_checktip">请选择险种对应条款</span></td>
		    </tr>
		</table>
	</t:formvalid>
</body>
</html>