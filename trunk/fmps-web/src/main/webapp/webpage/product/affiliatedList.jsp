<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="affiliatedList" title="${productname }-条款管理"
	actionUrl="ProductController.do?affidatagrid&type=${type}&prodid=${prodid}" fit="true"
	idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="排序" field="sorting"></t:dgCol>
	<t:dgCol title="标题" field="description"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="ProductController.do?delaff&id={id}" />
	<t:dgToolBar title="增加条款" icon="icon-add"
		url="product/ProductController.do?aff&prodid=${prodid }" funname="add" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑条款" icon="icon-edit"
		url="product/ProductController.do?affupdate" funname="update" height="100%"></t:dgToolBar>
</t:datagrid>

