<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="kindList" title="${productname }-${planname }-险种维护"
	actionUrl="ProductController.do?kinddatagrid&productid=${productid}&planid=${planid}"
	fit="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="险种代码" field="kindcode"></t:dgCol>
	<t:dgCol title="险种名称" field="kindname"></t:dgCol>
	<t:dgCol title="对应条款" field="affiliatedId"  replace="${affiliatedReplace}"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="ProductController.do?delkind&id={id}" />
	<t:dgFunOpt funname="gores(id)" title="责任维护"></t:dgFunOpt>
	<t:dgToolBar title="增加险种" icon="icon-add"
		url="product/ProductController.do?addkind&productid=${productid}&planid=${planid }" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑险种" icon="icon-edit"
		url="product/ProductController.do?kindupdate" funname="update"></t:dgToolBar>
</t:datagrid>
<script type="text/javascript">
<!--
	function gores(id) {
		addOneTab('责任维护', 'product/ProductController.do?rebList&productid=${productid}&productname=${productname }&planid=${planid}&id=' + id);
	}
//-->
</script>
