var COUNT_DOWN_SEC = 60;			// 倒计时180秒
var countdownSec = COUNT_DOWN_SEC;	

/**
 * 非车绑定登录
 */
function submitOther(){
	$("#dynamicpasswordothertemp").text("");
	if($("#customercname").val() == ""){
		$("#customercnametemp").text("**姓名不能为空！");
		return false;
	}
	$("#customercnametemp").text("");
	
	if($("#identifynumberother").val() == ""){
		$("#identifynumberothertemp").text("**证件号不能为空！");
		return false;
	}
	$("#identifynumberothertemp").text("");

	var mobile = $("#mobileother").val();
	var dynamicpassword = $("#dynamicpasswordother").val();
	
	if(!checkMobile(mobile,$("#mobileothertemp"))){
		return false;
	}
	
	if(dynamicpassword == ""){
		$("#dynamicpasswordothertemp").text("**验证码不能为空！");
		return false;
	}
	$("#dynamicpasswordothertemp").text("");
	//var $btn = $(bindother);
	//$btn.button('loading');	//变化按钮状态
	bindForm.action = bindForm.action;
	bindForm.submit();

}

/**
 * 发送手机验证码
 */
function sendDynamicPassword(btnSendPwd, mobileElement, msgElement,openid){
	//1.生成验证码 2.写表 3.发送到手机 	
	var mobile = mobileElement.val();
	if(!checkMobile(mobile,msgElement)){
		return false;
	}
	
	sendPwd($(btnSendPwd),mobile,msgElement,openid);
}

/**
 * 校验合法手机号
 */
function checkMobile(mobile,msgObj){
	var reg=/^1[0-9]{10}$/;	//1开头的11位数字
	if(!mobile || mobile==null){
		msgObj.text("**手机号不能为空！");
		return false;
	}else if(!reg.test(mobile)){
		msgObj.text("**手机号格式不对！");
		return false;
	}
	msgObj.text("");
	return true;
}

/**
* 校验合法身份证号
*/
function checkIdentifyNumber(identifyNumber){
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	if(reg.test(identifyNumber) == false)  
	{  
		//$(".temp").text("**身份证号不合法！");
		return false;  
	}
	
	return true;
}


/**
 *  动态码发送
 *  
 * @param jqBtnObj 获取动态码按钮jquery对象
 * @param mobile 手机号
 * @param msgObj 放提示信息的对象
 * @return
 */
function sendPwd(jqBtnObj,mobile,msgObj,openid){
	
	//倒计时begin
	jqBtnObj.attr('disabled','disabled');
	countdownSec = COUNT_DOWN_SEC;	
	text ="获取验证码"; 	//按钮原来的名称	
	interval =  setInterval('countdownFun()',1000);
	countdownFun = function(){		
		jqBtnObj.html(text + "("+ (countdownSec--)+")");	//设置按钮显示的名称
		//倒计时为0时，停止倒计时，
		if(countdownSec <= 0){	
			clearInterval(interval);
			 jqBtnObj.attr('disabled',false);
			 jqBtnObj.text(text);
		}
		
	};
	countdownFun();
	//倒计时end
	
	msgObj.text("");
	
	var url = $("#webRoot").val() + "/fo/dynamicPasswordController.do?sendDynamicPassword&version="+new Date();
	
	$.ajax({
		 type: "GET",
		 url: url,
		 data: "mobile="+mobile+"&openid="+openid,
		 async: false,
		 error : function(data) {
			 // 请求失败处理函数
		 },
		 success: function(result){
			 var data = $.parseJSON(result);
			 if(data.success) {
				 msgObj.text(data.msg);
			 } else {
				 msgObj.text(data.msg);
				 clearInterval(interval);
				 jqBtnObj.attr('disabled',false);
				 jqBtnObj.val(text);
			 }
			 
		 } 
		});
}
