<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="texttemplatelist" checkbox="true" actionUrl="${webRoot}/bo/templateMessageController.do?templateGrid" fit="true" fitColumns="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false" ></t:dgCol>
	<t:dgCol title="标题" sortable="true" field="title" query="true"></t:dgCol>
	<t:dgCol title="微信模板ID" sortable="false" field="weixinTemplateId" query="true"></t:dgCol>
	<t:dgCol title="业务类型" sortable="false" field="bussinessType" query="true" replace="投保_100,核保_200,承保_300,理赔_400,批改_500,费用_600"></t:dgCol>
	<t:dgCol title="模板内容" sortable="false"  field="content" ></t:dgCol>
	<t:dgCol title="内容示例" sortable="false" field="contentDemo" ></t:dgCol>
	<t:dgCol title="微信公众号" sortable="false"  field="account.accountname" ></t:dgCol>
	<t:dgCol title="状态" sortable="false"  field="status" replace="有效_1,无效_0,取消_2"></t:dgCol>
	<t:dgCol title="操作" sortable="false"  field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="${webRoot}/bo/templateMessageController.do?delTemplate&id={id}" />
	<t:dgToolBar title="模板录入" icon="icon-add" url="${webRoot}/bo/templateMessageController.do?addorUpdateTemplate" funname="add"></t:dgToolBar>
 	<t:dgToolBar title="模板编辑" icon="icon-edit" url="${webRoot}/bo/templateMessageController.do?addorUpdateTemplate" funname="update"></t:dgToolBar>
 	<t:dgToolBar title="批量删除"  icon="icon-remove" url="${webRoot}/bo/templateMessageController.do?doBatchDelTempalte" funname="deleteALLSelect" ></t:dgToolBar>
</t:datagrid>