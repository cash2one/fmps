<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="productList" title="商品维护"
	actionUrl="ProductController.do?datagrid" fit="true" idField="id"
	queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="产品代码" field="internalcode"></t:dgCol>
	<t:dgCol title="产品名称" sortable="false" field="productname" query="true"></t:dgCol>	
	<t:dgCol title="产品简称" field="riskshortname"></t:dgCol>	
	<t:dgCol title="产品特色" field="feature"></t:dgCol>
	<t:dgCol title="适用职业范围" field="occupationLevels" replace="1-2_occupationLevels12,3-4_occupationLevels34,1-3_occupationLevels13,1-4_occupationLevels14,1-6_occupationLevels16"></t:dgCol>
	<t:dgCol title="销售方式" field="salemode" replace="微店_1,微信_2,赠险_3,手工_4"></t:dgCol>
	<t:dgCol title="寄送方式" field="delivery" replace="无_1,仅电子保单_2,仅纸质保单_3,电子纸质可选_4"></t:dgCol>
	<t:dgCol title="类型" field="type" replace="意外_1,家财_2,车险_3"></t:dgCol>
	<t:dgCol title="是否卡单" field="iscard" replace="是_Y,否_N"></t:dgCol>
	<t:dgCol title="职业类别" field="occupationcategory"></t:dgCol>
	<t:dgCol title="职业代码" field="occupationcode"></t:dgCol>
	<t:dgCol title="状态" sortable="true" field="status" replace="有效_1,无效_2"></t:dgCol>
	<t:dgCol title="创建时间" sortable="true" field="createtime"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgFunOpt funname="goplan(id)" title="计划维护"></t:dgFunOpt>
	<t:dgFunOpt funname="gorule(id)" title="投保规则"></t:dgFunOpt>
	<t:dgFunOpt funname="gonotice(id)" title="附加信息维护"></t:dgFunOpt>
	<t:dgFunOpt funname="goarticle(id)" title="条款"></t:dgFunOpt>
	<t:dgDelOpt title="删除" url="ProductController.do?del&id={id}" />
	<t:dgToolBar title="增加产品" icon="icon-add"
		url="product/ProductController.do?goprod" funname="add" width="100%"
		height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑产品" icon="icon-edit"
		url="product/ProductController.do?goUpdate" funname="update"
		width="100%" height="100%"></t:dgToolBar>
</t:datagrid>
<script type="text/javascript">
	function gorule(id) {
		addOneTab('投保规则', 'product/ProductController.do?prodrulelist&id=' + id);
	}

	function goplan(id) {
		addOneTab('计划维护', 'product/ProductController.do?prodplanlist&id=' + id);
	}

	function gonotice(id) {
		createwindow('附加信息维护', 'product/ProductController.do?ntupdate&type=2&id='
				+ id, '100%', '100%');
	}
	function goarticle(id) {
		addOneTab('条款', 'product/ProductController.do?noticelist&type=1&id='
				+ id);
	}
</script>
