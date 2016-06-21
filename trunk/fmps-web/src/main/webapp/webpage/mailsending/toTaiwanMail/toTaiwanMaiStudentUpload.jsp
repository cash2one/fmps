<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Excel导入</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" beforeSubmit="upload">
	<fieldset class="step">
	<div class="form">
		<table style="width:100%" cellpadding="0" cellspacing="1">
			<tr>
				<td align="right" style="width: 65px">
					<label>活动：</label>
				</td>
				<td colspan="3">
					<select name="huodongid" id="huodongid">
						<c:forEach items="${huodongList}"	var="huodongid">
							<option value="${huodongid.id}">${huodongid.title}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
	<div class="form">
		<t:upload name="fiels" buttonText="选择要导入的文件" uploader="${webRoot}/mailsending/toTaiwanMailController.do?importExcel" extend="*.xls;*.xlsx" id="file_upload" formData="huodongid"></t:upload>
	</div>
	<div class="form" id="filediv" style="height: 50px"></div>
	</fieldset>
</t:formvalid>
</body>
</html>
