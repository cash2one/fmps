<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="ruleList" title="${productname }-规则管理"
	actionUrl="ProductController.do?ruledatagrid&prodid=${prodid}"
	fit="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="规则名称" field="rulename"></t:dgCol>
	<t:dgCol title="规则类型" field="ruletype"></t:dgCol>
	<t:dgCol title="分类" field="ruleclass"></t:dgCol>
	<t:dgCol title="最小值" field="minage"></t:dgCol>
	<t:dgCol title="最大值" field="maxage"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="ProductController.do?delrule&id={id}" />
	<t:dgToolBar title="增加规则" icon="icon-add"
		url="product/ProductController.do?rule&prodid=${prodid }"
		funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑规则" icon="icon-edit"
		url="product/ProductController.do?ruleUpdate" funname="update"></t:dgToolBar>
</t:datagrid>

