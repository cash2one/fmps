<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
 <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
	.am-btn-primary{ width:100%; margin-bottom:20px;}
	.am-titlebar {
	  margin-top: 0px;
	  height: 45px;
	  font-size: 100%;
	}
	.am-titlebar-default .am-titlebar-title:before {
	
	}
	.fb_che{ width: 100%; height: 35px; border: 1px #dedede solid;}
 </style>
<script>
//刷新验证码   dosubmit
function reloadRandCodeImage() {
    var date = new Date();
    var img = document.getElementById("randCodeImage");
    img.src = '${webRoot}/randCode.do?genCode&randCode=${openid}&a=' + date.getTime();
}
$(document).ready(function(){  //页面加载完成需要初始化的 部分 	
	var carTotal= ${fn:length(customerNewCarLicenceList)};
	  if(carTotal<2){	
		var $frameno =$('#frameno-01').attr('value');
		$("#radio-choice-01").attr("style","border:1px solid #0e90d2"); //如果只有 1条 记录 默认 选中 
		$("#hiddenCar").val($frameno);
	  }
}); 


	var frameno;  //选择的上牌车辆 
    var carLicence ;  //新的车牌号 
	var randCode;   //验证码 	

//提交新车上牌
function updateNewCarLicence(){
	$("#promptMessage").text("");
	var $btn = $("#submitbutton");
	$btn.button('loading');
	if(check()){
		newCarLicenseForm.action = "${webRoot}/fo/binded/customerNewCarLicenceController.do?updateNewCarLicence&openid=${openid}&frameno=" + frameno;
		newCarLicenseForm.submit();
	}
}

	//检查页面输入完整性 
function  check() {	
	var result = true;	
	var $btn = $('#submitbutton');
	  frameno=$("#hiddenCar").val();  //选择的上牌车辆 
      carLicence=$("#carLicence").val();  //新的车牌号 
	  randCode=$("#randCode").val();   //验证码 		 
	if(typeof(frameno)=="undefined" || frameno==""){
		frameno="";
		$("#promptMessage").text('**请选择您需要上牌的车辆信息');
		$btn.button('reset');
		result=false ;
	}else if (carLicence==""){
		$("#promptMessage").text('**请输入新的车牌号');
		$btn.button('reset');
		result=false ;		
	}else if (randCode==""){
		$("#promptMessage").text('**请输入验证码');	
		$btn.button('reset');
		result=false ;		
	}
	return result;
}

	//选择上牌车辆
function selectCar(id,value){
	$(".selectCar").attr('style','border-bottom: 1px solid #dbdbdb;');
	document.getElementById(id).style.border="1px solid #0e90d2";
	$("#hiddenCar").val(value);
}
</script>
</head>
<body>

 	<header data-am-widget="header" class="am-header am-header-default">
	    <h1 class="am-header-title">
	    	  新车车牌变更
	    </h1>
	</header>
	<form name="newCarLicenseForm" action="${webRoot}/fo/binded/customerNewCarLicenceController.do?updateNewCarLicence&openid=${openid}" method="post">
	
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
	  <h2 class="am-titlebar-title ">请选择您的车辆</h2>
	</div>
	
	<div class="am-u-sm-6">
		<input type="hidden"  var="selectCar"	value=""  id="hiddenCar"/>
		<c:forEach items="${customerNewCarLicenceList}"	var="customerNewCarLicence" varStatus="status">
			<div class="selectCar" style="border-bottom:1px solid #dbdbdb; padding-bottom:5px;"	id="radio-choice-0${status.index +1}" onclick="selectCar(id,'${customerNewCarLicence.frameno}')" >
				<label class="am-radio am-secondary">
					<input type="hidden"  var="frameno"	value="${customerNewCarLicence.frameno}"  id="frameno-0${status.index +1}"/>
					<label  name="radio-choice-0"    value="${customerNewCarLicence.frameno}"	>
					车型：${customerNewCarLicence.brandname}<br/> 
					车架号：${customerNewCarLicence.frameno}
					</label>
				</label>
			</div>
		</c:forEach>
	</div>
	
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="clear:both;">
	  <h2 class="am-titlebar-title ">请输入您的信息</h2>
	</div>
	
	<div class="am-g"  style="clear:both;">
	  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
	    <form method="post" class="am-form">
	     
	      <div style="margin-top:10px;">车牌号:</div>
	      <input type="text" class="fb_che" name="carLicence" id="carLicence" placeholder="请输入车牌号" data-am-ucheck>				
	      <div style="margin-top:10px;">验证码:</div>
	      <input type="text" class="fb_che" name="randCode" id="randCode" placeholder="请输入验证码"	data-am-ucheck>
	      <br />
	     
	      <div style=" padding-left:65%; margin-top: 5px;">
			<img id="randCodeImage" onclick=reloadRandCodeImage()  src="${webRoot}/randCode.do?genCode&randCode=${openid}" />
		  </div>
		  <div style="float: left;" style="font-size:22px;color:red">
				<span style="font-size: 22px; color: red" id="promptMessage"><span />
		  </div>
	      <br />
	      <div class="am-cf">
	      	<input id="submitbutton" value="提 交" type="button" class="am-btn am-btn-primary am-btn-lg am-btn-block" onclick="updateNewCarLicence();"/>
	      </div>
	    </form>
	  </div>
	</div>
	
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
	  <h2 class="am-titlebar-title">温馨提示</h2>
	</div>
	<div style="width:90%; margin:0 auto;">新车上牌后请及时变更保单车牌信息，这样便于我们提供针对性的服务，不影响您的理赔时效。</div>						
	
	</form>
</body>
</html>
