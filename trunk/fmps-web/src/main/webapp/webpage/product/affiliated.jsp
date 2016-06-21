<%@ page language="java" import="java.util.*"
	contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="messagefrom" dialog="true" layout="table"
		beforeSubmit="setDoc();" action="ProductController.do?aopaff">
		<input id="id" name="id" type="hidden" value="${id}">
		<input name="productid" type="hidden" value="${productid}">
		<input name="type" type="hidden" value="${type}">
	<%-- 	<input name="document" id="document" type="hidden" value="${document }"> --%>
		<button name="button" onclick="view()" type="button">预览</button>
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 标题: </label></td>
				<td colspan="3" class="value"><input id="description"
					name="description" class="inputxt" value="${description}"
					datatype="s1-200" style="width:495px"> <span class="Validform_checktip">标题不为空</span>
				</td>
			</tr>
						
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 排序: </label></td>
				<td colspan="3" class="value"><input id="sorting"
					name="sorting" class="inputxt" value="${sorting}"
					datatype="n" style="width:495px"> <span class="Validform_checktip">条款排序值不为空</span>
				</td>
			</tr>			

			<tr>
				<td align="right"><label class="Validform_label"> 条款内容:
				</label></td>
				<td class="value">
					<!-- <textarea rows="15" cols="80" name="document"
						id="document">${document}</textarea> <br> <span
					class="Validform_checktip">请输入条款内容！</span> --> 				
					<script id="editor" type="text/plain" style="width: 500px; height: 500px;">${document}</script>
				</td>
			</tr>
		</table>
		<input name="document" id="document" type="hidden"	value="">
	</t:formvalid>
	<script type="text/javascript">
		var ue = UE.getEditor('editor',{autoHeightEnabled: false});
	//	$(document).ready(function(){
		//	var doc=document.getElementById("document").value;
		//	if(doc!=null){
		//		document.getElementById("editor").value=doc;  
		//	}else{
		//		document.getElementById("editor").value='';
		//	}
	     //	});
		function setDoc() {
			$("#document").val(UE.getEditor('editor').getContent());
		}
		function view(){
			$("#document").val(UE.getEditor('editor').getContent());
			window.open('${Domain}/webpage/product/viewAff.jsp');
		}
	</script>
	<script type="text/javascript">
		window.UEDITOR_HOME_URL = '${Domain}/plug-in/ueditor/'; //设置ueditor路径
	</script>
</body>