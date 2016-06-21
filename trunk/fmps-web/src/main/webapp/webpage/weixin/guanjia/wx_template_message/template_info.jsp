<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title></title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <t:base type="jquery,easyui,tools"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="templateform" dialog="true" layout="table" action="${webRoot}/bo/templateMessageController.do?doSaveTemplate">
   <input id="id" name="id" type="hidden" value="${weiXinTemplate.id}">   
   <table style="width:650px;height: 700px" cellpadding="0" cellspacing="1" class="formtable">
    <tr>
     <td align="right">
      <label class="Validform_label">
     	模板标题:
      </label>
     </td>
     <td class="value">
       <input id="title" class="inputxt" name="title"  value="${weiXinTemplate.title}" datatype="*" nullmsg="模板标题不能为空！" style="width:220px">
      <span class="Validform_checktip">请输入模板标题！</span>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
     	微信模板ID:
      </label>
     </td>
     <td class="value">
       <input id="title" class="inputxt" name="weixinTemplateId"  value="${weiXinTemplate.weixinTemplateId}" datatype="*" nullmsg="微信模板ID不能为空！" style="width:220px">
      <span class="Validform_checktip">请输入微信模板ID！</span>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
     	业务类型:
      </label>
     </td>
     <td class="value">
	     	<t:dictSelect field="bussinessType" typeGroupCode="templtype" hasLabel="false" defaultVal="${weiXinTemplate.bussinessType}" extendJson="{style:'width:220px'}"></t:dictSelect>
			<span class="Validform_checktip"></span>
			<label class="Validform_label" style="display: none;">业务类型</label>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
    	 模板内容:
      </label>
     </td>
     <td class="value">
          <textarea  rows="6" cols="80" name="content" id="content">${weiXinTemplate.content}</textarea>
          <br>
      	  <span class="Validform_checktip">请输入模板内容！</span>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
    	 内容示例:
      </label>
     </td>
     <td class="value">
          <textarea  rows="6" cols="80" name="contentDemo" id="contentDemo">${weiXinTemplate.contentDemo}</textarea>
          <br>
      	  <span class="Validform_checktip">请输入内容示例！</span>
     </td>
    </tr>
    <tr>
     <td align="right">
      <label class="Validform_label">
     	微信公众号:
      </label>
     </td>
     <td class="value">
     	<select id="accountId" name="account.id">
     			<option value="-1" name="account">请选择...</option>
     		<c:forEach items="${accountList}" var="theAccount">
     			<option value="${theAccount.id}" name="account" <c:if test="${weiXinTemplate.account.id==theAccount.id}">selected="selected"</c:if>>${theAccount.accountname}</option>
     		</c:forEach>
     	</select>
     </td>
    </tr>    
   </table>
  </t:formvalid>
 </body>