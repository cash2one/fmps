<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>94频道</title>
  <meta name="description" content="94频道" />
  <meta name="keywords" content="user" />
  <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width" />
  <meta name="format-detection" content="telephone=no" />
  <meta name="renderer" content="webkit" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <%@ include file="/webpage/fo/common/new-fotags.jsp"%>
  <script src="${webRoot}/plug-in/fo/js/gasolinegift/gasolinegift.js"></script>
 <script type="text/javascript">
  var customerId ;
  function checkCode(){
		var dynamicpassword= $('#dynamicpasswordother').val();
		var mobile = $('#mobile').val();
		$.ajax({
			type : "POST",
			url : "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?checkPhone",
			data : "&dynamicpassword="+dynamicpassword +"&mobile="+mobile,
			dataType : "json",
			success : function(data) {
				if (data == "0") {
				 	return true ;
				}else{
					showError('**验证码有误！');
					return false;
				}
			 }
		 });
	  }
 
   function checkUserMobile(mobile){
	     //异步检查用户手机是否有申请资格
	   $.ajax({
			type : "POST",
			url : "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?checkUserQualification",
			data : "&mobile="+mobile,
			dataType : "json",
			success : function(data) {
				 // 用户有资格就发送验证码
				 if(data.success){
				 sendDynamicPassword($('#VerificationCode'), $('#mobile'), $('#dynamicpasswordothertemp'),'${openid}');
				 var customerId=data.obj;
				 }else{
					showError('**没有查询到您的申请信息'); 
				 }
			   }
		    });
        }
       //提交申请加油宝 
     function submit(){
	    var mobile = $('#mobile').val();
	    var dynamicpasswordother = $('#dynamicpasswordother').val();
	    if(!mobile || mobile==null){
	        alert("请输入手机号,获取验证码 ");
	        return ;
         } else if (!dynamicpasswordother || dynamicpasswordother==null){
    	     alert("请输入验证码");
   	        return ;
         }
	    if(checkCode()){  //验证码通过 
			location.href = "${webRoot }/fo/binded/gasolinegift/gasolinegiftController.do?getGasolinegiftInfo&cityCode=350200&channel=1&customerId="+customerId+"&version="+Math.random();	
	    }
    }
   
   //显示错误提示
	function showError(str) {
		$('#alertMessage').text(str);
	}

 </script>

</head>
<body>

   <input type="hidden" id="webRoot" name="webRoot" value="${webRoot}" />
   <div class="tel">
    <div class="tel_text">手机号：</div>
    <div class="tel_input"><input id="mobile" name="mobile" value="${mobile }" type="text" size="19" /></div>
   </div>
   <div class="code">
   <div class="code_text">验证码：</div>
   <div class="code_input">
    	<input type="text" style="height:25px;  width: 100%;" size="8" name="dynamicpasswordother" id="dynamicpasswordother" placeholder="请输入">
    </div>
    <div class="code_button">
    	<div  id="VerificationCode" onclick="checkUserMobile($('#mobile').val())">获取验证码</div>
    </div>
   </div>
   <div style="clear: both;"></div>
   <div id="dynamicpasswordothertemp" style="color:red;font-size: 12px;">${messageother }</div>
   	<div class="oil_tips" id="alertMessage">${message}</div>


    <div class="code_button">
    	<div  id="submit" onclick="submit()">确认申请</div>
    </div>

</body>
</html>