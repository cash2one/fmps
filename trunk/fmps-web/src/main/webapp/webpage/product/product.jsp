<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>商品详情</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<link type="text/css" rel="stylesheet"
	href="${Domain}/plug-in/weixin/css/appmsg_edit.css" />
<link type="${Domain}/text/css" rel="stylesheet"
	href="${Domain}/plug-in/weixin/css/jquery.fileupload.css" />
<link type="text/css" rel="stylesheet"
	href="${Domain}/plug-in/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${Domain}/plug-in/ckfinder/ckfinder.js"></script>

<!--fileupload-->
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/load-image.min.js"></script>
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/jquery.fileupload.js"></script>
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/jquery.fileupload-process.js"></script>
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/jquery.fileupload-image.js"></script>
<script type="text/javascript"
	src="${Domain}/plug-in/weixin/js/jquery.iframe-transport.js"></script>
<!--UEditor-->
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/ueditor.all.min.js"></script>

<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${Domain}/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	//编写自定义JS代码
	/*jslint unparam: true, regexp: true */
	/*global window, $ */
	$(function() {
		'use strict';
		// Change this to the location of your server-side upload handler:
		var url = '../weixinArticleController.do?upload', uploadButton = $(
				'<button/>').addClass('btn btn-primary').prop('disabled', true)
				.text('上传中...').on('click', function() {
					var $this = $(this), data = $this.data();
					$this.off('click').text('正在上传...').on('click', function() {
						$this.remove();
						data.abort();
					});
					data.submit().always(function() {
						$this.remove();
					});
				});
		$('#fileupload')
				.fileupload(
						{
							url : url,
							dataType : 'json',
							autoUpload : false,
							acceptFileTypes : /(\.|\/)(gif|jpe?g|png)$/i,
							maxFileSize : 2000000, // 2 MB
							disableImageResize : /Android(?!.*Chrome)|Opera/
									.test(window.navigator.userAgent),
							previewMaxWidth : 290,
							previewMaxHeight : 160,
							previewCrop : true
						})
				.on(
						'fileuploadadd',
						function(e, data) {
							$("#files").text("");
							data.context = $('<div/>').appendTo('#files');
							$.each(data.files, function(index, file) {
								//var node = $('<p/>').append($('<span/>').text(file.name));
								//fileupload
								var node = $('<p/>');
								if (!index) {
									node.append('<br>')
											.append(
													uploadButton.clone(true)
															.data(data));
								}
								node.appendTo(data.context);
							});
						})
				.on(
						'fileuploadprocessalways',
						function(e, data) {
							var index = data.index, file = data.files[index], node = $(data.context
									.children()[index]);
							if (file.preview) {
								node.prepend('<br>').prepend(file.preview);
							}
							if (file.error) {
								node.append('<br>').append(
										$('<span class="text-danger"/>').text(
												file.error));
							}
							if (index + 1 === data.files.length) {
								data.context.find('button').text('上传').prop(
										'disabled', !!data.files.error);
							}
						}).on(
						'fileuploadprogressall',
						function(e, data) {
							var progress = parseInt(data.loaded / data.total
									* 100, 10);
							$('#progress .progress-bar').css('width',
									progress + '%');
						}).on(
						'fileuploaddone',
						function(e, data) {
							console.info(data);
							var file = data.files[0];
							//var delUrl = "<a class=\"js_removeCover\" onclick=\"return false;\" href=\"javascript:void(0);\">删除</a>";
							$("#imgName").text("").append(file.name);
							$("#imagename").val(file.name);
							$("#progress").hide();
							var d = data.result;
							if (d.success) {
								var link = $('<a>').attr('target', '_blank')
										.prop('href', d.attributes.viewhref);
								$(data.context.children()[0]).wrap(link);
								console.info(d.attributes.viewhref);
								$("#imagehref").val(d.attributes.url);
							} else {
								var error = $('<span class="text-danger"/>')
										.text(d.msg);
								$(data.context.children()[0]).append('<br>')
										.append(error);
							}
						}).on(
						'fileuploadfail',
						function(e, data) {
							$.each(data.files, function(index, file) {
								var error = $('<span class="text-danger"/>')
										.text('File upload failed.');
								$(data.context.children()[index])
										.append('<br>').append(error);
							});
						}).prop('disabled', !$.support.fileInput).parent()
				.addClass($.support.fileInput ? undefined : 'disabled');

		//编辑时初始化图片预览
		var name = "${productname}", imageHref = "${imagehref}";
		if (name != "") {
			$("#imageTitle").html(name);
		}
		if (imageHref != "") {
			var url = "../" + imageHref;
			$("#imageShow").html(
					'<img src="' + url + '" width="100%" height="160" />');
		}
	});
	function setimageTitle(obj) {
		$("#imageTitle").html($(obj).val());
	}
</script>
</head>
<body>
	<div class="main_bd">
		<div class="media_preview_area">
			<div class="appmsg editing">
				<div class="appmsg_content" id="js_appmsg_preview">
					<div class="appmsg_info">
						<em class="appmsg_date"></em>
					</div>
					<div id="files" class="files">
						<i class="appmsg_thumb default" id="imageShow">栏目图片</i>
					</div>
					<div id="progress" class="progress">
						<div class="progress-bar progress-bar-success"></div>
					</div>
					<p class="appmsg_desc"></p>
				</div>
			</div>
		</div>
		<div class="media_edit_area" id="js_appmsg_editor">
			<div class="appmsg_editor" style="margin-top: 0px;">
				<div class="inner">
					<t:formvalid formid="formobj" dialog="true" usePlugin="password"
						layout="table" action="ProductController.do?addorupdate">
						<input id="id" name="id" type="hidden" value="${product.id }">
						<input type="hidden" name="imageName" id="imageName"
							value="${imagename}">
						<table cellpadding="0" cellspacing="1" class="formtable">
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 产品编码: </label></td>
								<td colspan="3" class="value"><input name="internalcode"
									id="internalcode" class="inputxt" value="${internalcode}"
									datatype="s1-20"> <span class="Validform_checktip">产品编码不能为空</span></td>
							</tr>
							<tr>
								<td align="right"><label class="Validform_label">
										产品名称: </label></td>
								<td class="value"><input class="inputxt" id="productname"
									name="productname" style="width: 300px" value="${productname}"
									datatype="s2-30"> <span class="Validform_checktip"></span>
									<label class="Validform_label" style="display: none;">产品名称不能为空</label>
								</td>
							</tr>
							<tr>
								<td align="right"><label class="Validform_label">
										产品简称: </label></td>
								<td class="value"><input class="inputxt" id="riskshortname"
									name="riskshortname" style="width: 300px" value="${riskshortname}"
									datatype="s2-30"> <span class="Validform_checktip"></span>
									<label class="Validform_label" style="display: none;">产品简称不能为空</label>
								</td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 产品特色: </label></td>
								<td colspan="3" class="value"><input name="feature"
									id="feature" class="inputxt"
									value="${feature}" datatype="*1-22"> <span
									class="Validform_checktip">产品特色不能为空</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 销售方式: </label></td>
								<td colspan="3" class="value">
									<select id="salemode" name="salemode">
										<option value=""
											<c:if test="${salemode==''}">selected</c:if>></option>
										<option value="1"
											<c:if test="${salemode=='1'}">selected</c:if>>微店</option>
										<option value="2"
											<c:if test="${salemode=='2'}">selected</c:if>>微信</option>
										<option value="3"
											<c:if test="${salemode=='3'}">selected</c:if>>赠险</option>
										<option value="4"
											<c:if test="${salemode=='4'}">selected</c:if>>手工</option>
									</select> 
									<span class="Validform_checktip">请选择销售方式</span></td>
							</tr>
							
							
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 保单寄送方式: </label></td>
								<td colspan="3" class="value">
									<select id="delivery" name="delivery">
										<option value=""
											<c:if test="${delivery==''}">selected</c:if>></option>
										<option value="1"
											<c:if test="${delivery=='1'}">selected</c:if>>无</option>
										<option value="2"
											<c:if test="${delivery=='2'}">selected</c:if>>仅电子保单</option>
										<option value="3"
											<c:if test="${delivery=='3'}">selected</c:if>>仅纸质保单</option>
										<option value="4"
											<c:if test="${delivery=='4'}">selected</c:if>>电子纸质可选</option>
									</select> 
									<span class="Validform_checktip">请选择寄送方式</span></td>
							</tr>
							
							
							
							
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 类型: </label></td>
								<td colspan="3" class="value"><select id="type" name="type"
									datatype="*"><option value="1"
											<c:if test="${type=='1'}">selected</c:if>>意外</option>
										<option value="2" <c:if test="${type=='2'}">selected</c:if>>家财</option>
										<option value="3" <c:if test="${type=='3'}">selected</c:if>>车险</option></select>
									<span class="Validform_checktip">类型不能为空</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 是否卡单: </label></td>
								<td colspan="3" class="value"><select id="iscard"
									name="iscard" datatype="*"><option value="Y"
											<c:if test="${iscard=='Y'}">selected</c:if>>是</option>
										<option value="N" <c:if test="${iscard=='N'}">selected</c:if>>否</option></select>
									<span class="Validform_checktip">是否卡单不能为空</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 职业范围: </label></td>
								<td colspan="3" class="value"><select id="occupationLevels"
									name="occupationLevels" ><option
											value=""
											<c:if test="${occupationLevels==''}">selected</c:if>></option><option
											value="occupationLevels12"
											<c:if test="${occupationLevels=='occupationLevels12'}">selected</c:if>>1-2</option>
										<option value="occupationLevels34"
											<c:if test="${occupationLevels=='occupationLevels34'}">selected</c:if>>3-4</option>
										<option value="occupationLevels13"
											<c:if test="${occupationLevels=='occupationLevels13'}">selected</c:if>>1-3</option>
										<option value="occupationLevels14"
											<c:if test="${occupationLevels=='occupationLevels14'}">selected</c:if>>1-4</option>
										<option value="occupationLevels16"
											<c:if test="${occupationLevels=='occupationLevels16'}">selected</c:if>>1-6</option></select>

									<span class="Validform_checktip">微店销售商品请选择</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 职业类别: </label></td>
								<td colspan="3" class="value"><input
									name="occupationcategory" id="occupationcategory"
									class="inputxt" value="${occupationcategory}"> <span
									class="Validform_checktip">意外险请填写职业类别</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 职业代码: </label></td>
								<td colspan="3" class="value"><input name="occupationcode"
									id="occupationcode" class="inputxt" value="${occupationcode}">
									<span class="Validform_checktip">意外险请填写职业代码</span></td>
							</tr>
							<tr>
								<td align="right" style="width: 65px"><label
									class="Validform_label"> 状态: </label></td>
								<td colspan="3" class="value"><select id="status"
									name="status" datatype="*"><option value="1"
											<c:if test="${status=='1'}">selected</c:if>>有效</option>
										<option value="2" <c:if test="${status=='2'}">selected</c:if>>无效</option></select><span
									class="Validform_checktip">状态不能为空</span></td>
							</tr>
							<tr>
								<td align="right"><label class="Validform_label">
										上传图片: </label></td>
								<td class="value"><span
									class="btn btn-success fileinput-button"> <i
										class="glyphicon glyphicon-plus"></i> <span>浏览</span> <!-- The file input field used as target for the file upload widget -->
										<input id="fileupload" type="file" name="files[]" multiple>
								</span> <input id="imagehref" name="imagehref" type="hidden"
									datatype="*" nullmsg="请添加图片" value="${imagehref}"> <span
									id="imgName"></span> <span class="Validform_checktip"></span> <label
									class="Validform_label" style="display: none;">图片链接</label> <label
									class="Validform_label">图片尺寸建议1024*550</label></td>
							</tr>
						</table>
					</t:formvalid>
				</div>
				<i class="arrow arrow_out" style="margin-top: 0px;"></i> <i
					class="arrow arrow_in" style="margin-top: 0px;"></i>
			</div>
		</div>
	</div>
</body>