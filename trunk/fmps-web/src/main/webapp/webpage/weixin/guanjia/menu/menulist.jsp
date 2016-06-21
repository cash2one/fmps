<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="system_function_functionList" class="easyui-layout" fit="true">
<div region="center" style="padding:1px;">
<t:datagrid actionUrl="menuManagerController.do?datagrid"  name="menuList" queryMode="group" treegrid="true" fitColumns="true" idField="id">
<t:dgCol field="id" treefield="id" title="主键" hidden="false"></t:dgCol>
<t:dgCol field="name" treefield="text" title="菜单名称" query="true" width="100"></t:dgCol> 
<t:dgCol field="type" treefield="src" title="菜单类型" replace="消息触发类_click,网页链接类_view" width="100" ></t:dgCol>
<t:dgCol field="status" treefield="status" title="状态" style="color:red;_2"  replace="暂停_2,有效_1"    width="100" ></t:dgCol>
<t:dgCol field="orders" treefield="order" title="顺序" width="100"></t:dgCol>
 
<t:dgCol title="操作" field="opt"></t:dgCol>
<t:dgFunOpt exp="status#eq#1" funname="closeItem(id)" title="停用"></t:dgFunOpt>
<t:dgFunOpt exp="status#eq#2" funname="openItem(id)" title="启用"></t:dgFunOpt>
<t:dgDelOpt title="删除" url="menuManagerController.do?del&id={id}" />
<t:dgToolBar title="录入菜单" icon="icon-add" url="menuManagerController.do?jumpSuView" funname="addFun()"></t:dgToolBar>
<t:dgToolBar title="菜单编辑" icon="icon-edit" url="menuManagerController.do?jumpSuView" funname="update"></t:dgToolBar>
<t:dgToolBar title="菜单同步到微信" icon="icon-edit" url="menuManagerController.do?sameMenu" funname="sameMenu()"></t:dgToolBar>
</t:datagrid>
</div></div>

<script type="text/javascript">
function addFun() {

    var row = $('#menuList').datagrid('getSelected');
    var url = "menuManagerController.do?jumpSuView";
    if(row){
    	url += "&fatherId="+row.id;
    }
	add("编辑信息",url,"menuList","","");
}

function edite(id) {
    var url = "menuManagerController.do?jumpSuView&id="+id;
	add("编辑信息",url,"menuList","","");
}


function sameMenu(){
	$.ajax({
		url:"menuManagerController.do?sameMenu",
		type:"GET",
		dataType:"JSON",
		success:function(data){
			if(data.success){
				tip(data.msg);
			}
		}
	});
}

function openItem(id){
	var tabName= 'menuList';
	var url= 'menuManagerController.do?changeStatus&id='+id;
	$.dialog.confirm('确定状态要启用吗', function(){
		doSubmit(url,tabName);
		
	}, function(){
	});
	
	
}

function closeItem(id){
	var tabName= 'menuList';
	var url= 'menuManagerController.do?changeStatus&id='+id;
	$.dialog.confirm('确定状态要停用吗', function(){
		doSubmit(url,tabName);
		
	}, function(){
	});
	
}

</script>
