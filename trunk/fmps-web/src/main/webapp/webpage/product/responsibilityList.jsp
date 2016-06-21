<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="resList" title="${productname }-${planname }-${kindname }-责任维护"
	actionUrl="ProductController.do?rebdatagrid&productid=${productid}&planid=${planid}&kindid=${kindid }" fit="true"
	idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="责任代码" sortable="false" field="liabilitycode"></t:dgCol>
	<t:dgCol title="保险责任" field="liability"></t:dgCol>
	<t:dgCol title="保额" sortable="true" field="amount"></t:dgCol>
	<t:dgCol title="单位" sortable="true" field="unit"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="ProductController.do?delreb&id={id}" />
	<t:dgToolBar title="增加保险责任" icon="icon-add"
		url="product/ProductController.do?reb&productid=${productid}&planid=${planid }&kindid=${kindid }" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑保险责任" icon="icon-edit"
		url="product/ProductController.do?rebupdate" funname="update"></t:dgToolBar>
</t:datagrid>

