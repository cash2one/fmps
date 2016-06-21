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
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="messagefrom" dialog="true" layout="table"
		beforeSubmit="setDoc();" action="ProductController.do?aopnt">
		<input id="id" name="id" type="hidden" value="${id}">
		<input id="productid" name="productid" type="hidden"
			value="${productid}">
		<button name="button" onclick="view()" type="button">预览</button>
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right" style="width: 65px"><label
					class="Validform_label"> 类型: </label></td>
				<td colspan="3" class="value"><select id="type" name="type"
					onchange="refreshDoc()">
						<option value="2" <c:if test="${type=='2'}">selected</c:if>>投保须知</option>
						<option value="3" <c:if test="${type=='3'}">selected</c:if>>商品介绍</option>
						<option value="4" <c:if test="${type=='4'}">selected</c:if>>商品详情</option>
						<option value="5" <c:if test="${type=='5'}">selected</c:if>>常见问题</option>
				</select> <span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 内容: </label></td>
				<td class="value"><script id="editor" type="text/plain"
						style="width: 100%; height: 500px;">${document}</script></td>
			</tr>
		</table>
		<input name="document" id="document" type="hidden"
			value="">
	</t:formvalid>
	<script type="text/javascript">
		var ue = UE.getEditor('editor', {
			autoHeightEnabled : false
		});
		function setDoc() {
			$("#document").val(UE.getEditor('editor').getContent());
		}
		function view() {
			$("#document").val(UE.getEditor('editor').getContent());
			window.open('${Domain}/webpage/product/viewdetail.jsp');
		}
		function refreshDoc() {
			var type = document.getElementById("type").value;
			var productid = document.getElementById("productid").value;
			$.ajax({
				type : "POST",
				url : "${webRoot}/product/ProductController.do?refreshDoc",
				data : {
					type : type,
					productid : productid
				},
				dataType : "json",
				success : function(data) {
					var objtmp = eval(data);
					if (objtmp.msg != "操作成功") {
						UE.getEditor('editor').setContent(objtmp.obj.document);
						$("#document").val(objtmp.obj.document);
						$("#id").val(objtmp.obj.id);
					} else {
						UE.getEditor('editor').setContent('');
						$("#id").val('');
					}
				}
			});
		}
	</script>
	<script type="text/javascript">
		window.UEDITOR_HOME_URL = '${Domain}/plug-in/ueditor/'; //设置ueditor路径
	</script>
</body>