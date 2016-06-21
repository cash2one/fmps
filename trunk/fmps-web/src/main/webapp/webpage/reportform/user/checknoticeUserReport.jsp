<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <link rel="stylesheet" type="text/css" href="plug-in/lhgDialog/skins/default2.css">
 
<%@include file="/context/mytags.jsp"%> 
<!DOCTYPE html>
<html>
 <head>
  <title></title>
   <!--  <t:base type="jquery,easyui,tools"></t:base> -->
  <style type="text/css">
  
    * {
  font-size: 18px;
  font-family: Tahoma,Verdana,微软雅黑,新宋体;
      }
  .checkbox{
width:18px;

height:18px;

}
.ui_state_highlight{
 display: none;
}
.ui_buttons input {

  display: none;
}
.ui_dialog .ui_buttons {

  
  white-space: nowrap;
  padding: 4px 8px;
  text-align: right;
  background-color: #FFF;
  display: none;

}
.ui_buttons {
  white-space: nowrap;
  padding: 4px 8px;
  text-align: right;
  background-color: #FFF;
  display: none;
}

  </style>

  <script type="text/javascript">
 
  </script>
 </head>
 <body style="overflow-y: hidden;" scroll="no">
 <%--  <t:formvalid formid="gzfrom" dialog="true" usePlugin="password" layout="table" action="NoticeUserReportController.do?exportXlscheck">
   <input id="id" name="id" type="hidden" value="${id}">
   --%>
  <form name="form1" action="NoticeUserReportController.do?exportXlscheck" method="post">
  请选择要导出的字段？<br /><br /> 
 &nbsp; &nbsp;
<label><input name="openid" type="checkbox" class="checkbox" value="微信号" />微信号 </label> 
&nbsp;&nbsp;
<label><input name="nickname" type="checkbox" class="checkbox"  value="昵称" />昵称 </label> 
<label><input name="account_id" type="checkbox" class="checkbox"  value="微信账号" />微信账号 </label> 
<label><input name="sex" type="checkbox" class="checkbox" value="性别" />性别 </label>
<label><input name="subscribeTime" type="checkbox" class="checkbox"  value="关注时间" />关注时间 </label>
 <label><input name="headimgurl" type="checkbox" class="checkbox"  value="用户头像" />用户头像 </label>
   <br /> 
  <br />  
  &nbsp; &nbsp;
 <label><input name="bzName" type="checkbox" class="checkbox"  value="备注名称" />备注名称</label>
 <label><input name="addtime" type="checkbox" class="checkbox"  value="添加时间" />添加时间 </label> 
 
 <label><input name="bindType" type="checkbox" class="checkbox"  value="认证类型" />认证类型 </label> 
  <label><input  name="bindTime" type="checkbox" class="checkbox"  value="认证时间" />认证时间</label> 
  <label><input name="country" type="checkbox" class="checkbox" value="国家 " />国家 </label>
 <label><input name="province" type="checkbox" class="checkbox" value="省份" />省份 </label>
 

  
  <br /> 
  <br /> 
  &nbsp; &nbsp;
<label><input name="city" type="checkbox" class="checkbox"  value="城市 " />城市 </label>
   

  <label><input name="customercode" type="checkbox" class="checkbox"  value="客户代码" />客户代码</label> 
  <label><input name="customercname" type="checkbox" class="checkbox"  value="客户名称" />客户名称</label> 
  <label><input name="identifynumber" type="checkbox" class="checkbox"  value="证件号码" />证件号码</label> 
  <label><input name="mobile" type="checkbox" class="checkbox"  value="手机号" />手机号</label>
 <label><input  name="licenseno" type="checkbox" class="checkbox"  value="车牌号" />车牌号</label>
   <br /> 
  <br /> 
  &nbsp; &nbsp; 
   
   <label><input name="groupId" type="checkbox" class="checkbox"  value="组ID" />组ID </label>
    <label><input name="subscribe" type="checkbox" class="checkbox"  value="是否关注" />是否关注 </label> 
  <label><input name="customerSex" type="checkbox" class="checkbox"  value="认证客户的性别" />认证客户的性别</label> 
  <label><input name="customerBirthday" type="checkbox" class="checkbox"  value="认证客户的生日" />认证客户的生日</label>
    <br /> 
  <br />  
  &nbsp; &nbsp; 
  <label><input name="identifyType" type="checkbox" class="checkbox"  value="认证客户的证件类型" />认证客户的证件类型</label> 
  <label><input name="EventKey" type="checkbox" class="checkbox"  value="扫码关注预设值" />扫码关注预设值</label> 

<br /> 
  <br />  
   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<input type="submit" name="submit"  value="确认" onclick="courseListExportXlscheck();" />
 </form>

 <%--  </t:formvalid> --%>
 <script type="text/javascript">
 function courseListExportXlscheck() {
	 document.form1.submit();
	 //location.href="NoticeUserReportController.do?exportXlscheck";
		//JeecgExcelExport("NoticeUserReportController.do?exportXlscheck","noticeUserReportList");
	}

 </script>
 </body>