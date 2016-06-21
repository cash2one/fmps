<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="planList" title="${productname }-计划管理"
	actionUrl="ProductController.do?plandatagrid&prodid=${prodid}"
	fit="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="计划编号" sortable="false" field="serialno"></t:dgCol>
	<t:dgCol title="计划名称" field="planname" query="true"></t:dgCol>
	<t:dgCol title="核心产品代码" field="coreproductcode"></t:dgCol>
	<t:dgCol title="保费(元)" sortable="true" field="premium"></t:dgCol>
	<t:dgCol title="期限" sortable="true" field="period"></t:dgCol>
	<t:dgCol title="期限类型" sortable="true" field="periodtype"></t:dgCol>
	<t:dgCol title="状态" sortable="true" field="status"></t:dgCol>
	<t:dgCol title="创建时间" sortable="true" field="createtime"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="ProductController.do?delplan&id={id}" />
	<t:dgFunOpt funname="gores(id)" title="险种维护"></t:dgFunOpt>
	<t:dgToolBar title="增加计划" icon="icon-add"
		url="product/ProductController.do?plan&prodid=${prodid}" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑计划" icon="icon-edit"
		url="product/ProductController.do?planUpdate" funname="update"></t:dgToolBar>
</t:datagrid>
<script type="text/javascript">
<!--
	function gores(id) {
		addOneTab('险种维护', 'product/ProductController.do?kindList&productid=${prodid}&productname=${productname }&id=' + id);
	}
//-->
</script>

