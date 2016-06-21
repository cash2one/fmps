<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>memcached查询</title>
<t:base type="jquery,easyui,tools"></t:base>
<div class="easyui-layout" fit="true">

	<div region="center" style="padding: 15px;">
		<div style=" margin:15px;float:left;width:25%;">
			<!-- <input id="memcachedkey" class="easyui-textbox" 
				style="height: 20px; width: 180px;" placeholder="请输入memcachedkey"><br> -->
			<input type="text" id="openidkey" class="easyui-textbox" 
					style="height: 20px; width: 180px;" placeholder="请输入openid查闪赔"><br>
			<input type="text" id="registNokey" class="easyui-textbox" 
					style="height: 20px; width: 180px;" placeholder="请输入报案号查闪赔"><br>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">查询</a> <br>
				  <c:choose>
					   <c:when test="${memcachedvalue.isEmpty() || memcachedvalue eq 'null' }"> 
					   		<span style="color:red">没有查询到相关的值！</span>
					   </c:when>
					   <c:otherwise> 
					   		memcached值为：${memcachedvalue}
					   </c:otherwise>
				  </c:choose>
		 </div>	  
		 
	    <t:formvalid formid="memcachedobj" layout="div" dialog="true">
		    <fieldset class="step">
				<div class="form">
					<label class="Validform_label"> 操作类型: </label>
					<select name="modifyType" id="modifyType" onchange="changeModifyType();">
			            <option value="0">选择操作类型</option>
			            <option value="5">get</option>
			            <option value="1">set</option>
			            <option value="2">delete</option>
			            <option value="3">desc</option>
			            <option value="4">incr查询</option>
			        </select> 
			        <span class="Validform_checktip">选择操作类型</span>
				</div>
				<div class="form">
					<label class="Validform_label"> 缓存key: </label>
					<input  name="memcachedKey" id ="memcachedKey"  class="inputxt">
					<span class="Validform_checktip">memcachedKey</span>
			    </div>
				<div class="form" id='value'>
					<label class="Validform_label"> 缓存值: </label> 
					<input  name="cachedValue" id ="cachedValue" class="inputxt">
					<span class="Validform_checktip">memcachedValue</span>
			    </div>
				<div class="form"><label class="Validform_label"> 操作结果: </label> 
					 <span class="Validform_checktip" id ="actionResult"></span>
			    </div>
			    <a href="#" class="easyui-linkbutton" style="margin-left:130px;margin-top:10px;" onclick="modifyCached();">确定</a>
			</fieldset>
		</t:formvalid>
	    
	    
	</div>
	
</div>
<script type="text/javascript">
	function submitForm() {
		var memcachedkey = $("#memcachedkey").val();
		var openidkey = $("#openidkey").val();
		var registNokey = $("#registNokey").val();
		if (memcachedkey == ""&& openidkey==""&& registNokey=="") {
			$.messager.alert('温馨提示', '请输入key值！');
			return;
		}
		var url = "${webRoot}/userController.do?getMemcachedValue&memcachedkey="+memcachedkey+"&openidkey="+openidkey+"&registNokey="+registNokey;
		location.href=url;
	}
	
	 /* 修改操作类型 */
	function changeModifyType(){
		var modifyType = $('#modifyType').val();
		console.log(modifyType);
		if(modifyType==2 || modifyType==4 || modifyType==5){
			$('#value').hide();
		}else{
			$('#value').show();
		}
	}
	function modifyCached(){
		var modifyType = $('#modifyType').val();
		var memcachedKey = $('#memcachedKey').val();
		var cachedValue = $('#cachedValue').val();
		console.log(modifyType);
		console.log(cachedValue);
		if(modifyType == 0){
			$.messager.alert('温馨提示','请选择操作类型');
			$('#modifyType').focus();
			return false;
		}
		if(!memcachedKey){
			$.messager.alert('温馨提示','请填写key值');
			$('#memcachedKey').focus();
			return false;
		}
		if(modifyType != 2 && modifyType != 4 && modifyType != 5){
			if(!cachedValue){
				$.messager.alert('温馨提示','请填写值');
				$('#cachedValue').focus();
				return false;
			}
		}
		$.dialog.confirm("确认执行操作？", function(){
			
			$.ajax({
				url:"userController.do?modifyMemcached",
				dataType:"json",
				data:{"memcachedKey":memcachedKey,"cachedValue":cachedValue,"modifyType":modifyType},
				success:function(data){
					if(data.success){
						var resultText = data.attributes.resultValue;;
						$('#actionResult').text(resultText);
					}
				},
				error:function(){
					alert("出错了，请重新抽奖");
				},
				timeout:40000
			}) 
		}, function(){
		});
		
	} 
</script>
</body>
</html>