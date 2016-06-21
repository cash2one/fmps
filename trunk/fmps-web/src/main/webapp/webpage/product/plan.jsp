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
		action="ProductController.do?addorupdateplan">
		<input name="id" type="hidden" value="${id}">
		<input name="productid" type="hidden" value="${productid}">
		<table style="width: 100%" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 计划编码: </label></td>
				<td colspan="3" class="value"><input name="serialno"
					id="serialno" class="inputxt" value="${serialno}" datatype="n1-6">
					<span class="Validform_checktip">计划编码为1~6位数字，不能为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 计划名称: </label></td>
				<td colspan="3" class="value"><input id="planname"
					name="planname" class="inputxt" value="${planname}"
					datatype="s2-20"> <span class="Validform_checktip">计划名称2~20位字符之间,且不为空</span>
				</td>
			</tr>			
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 核心产品代码: </label></td>
				<td colspan="3" class="value"><input name="coreproductcode"
					id="coreproductcode" class="inputxt" value="${coreproductcode}"
					datatype="s1-20"> <span class="Validform_checktip">核心产品代码不能为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 保险期限: </label></td>
				<td colspan="3" class="value"><input name="period" id="period"
					class="inputxt" value="${period}" datatype="n"> <span
					class="Validform_checktip">保险期限不能为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 期限类型: </label></td>
				<td colspan="3" class="value"><select id="type"
					name="periodtype" datatype="*"><option value="年"
							<c:if test="${periodtype=='年'}">selected</c:if>>年</option>
						<option value="月" <c:if test="${periodtype=='月'}">selected</c:if>>月</option>
						<option value="日" <c:if test="${periodtype=='日'}">selected</c:if>>日</option></select>
					<span class="Validform_checktip">类型不能为空</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 保费: </label></td>
				<td colspan="3" class="value"><input name="premium"
					id="premium" class="inputxt" value="${premium}" datatype="d">
					<span class="Validform_checktip">保费为1~6位数字，单位：元</span></td>
			</tr>
			<tr>
				<td align="right" style="width: 80px"><label
					class="Validform_label"> 状态: </label></td>
				<td colspan="3" class="value"><select id="state" name="status" datatype="*"><option value="有效" <c:if test="${status=='有效'}">selected</c:if>>有效</option>
										<option value="无效" <c:if test="${status=='无效'}">selected</c:if>>无效</option></select><span
					class="Validform_checktip">状态不能为空</span></td>
			</tr>

		</table>
	</t:formvalid>
</body>
</html>