	var COUNT_DOWN_SEC = 60;			// 倒计时60秒
    var countdownSec = COUNT_DOWN_SEC;	
	//保存
	function saveData(){
		showError('');
		if(checkVal() ){
			//$('#userForm').submit();//提交路径
			checkIdNumber();
		 }
	}
	
	//验证数据
	function checkVal(){
		var username = $('#customercname').val();
		if(username==null || username ==''){
			$("#customercname").focus();
			showError('**姓名不为空！');
			return false;
		}
		var identifynumber = $('#identifynumber').val();
		if(identifynumber==null || identifynumber ==''){
			$("#identifynumber").focus();
			showError('**身份证号不为空！');
			return false;
		}
		if(!isCardID(identifynumber))  {  
			$("#identifynumber").focus();
			showError('**身份证号格式不对 ！    ');
			return false;  
		}
		var mobile = $('#mobile').val();
		var re=/^1[0-9]{10}$/; 
		if(!re.test(mobile)){
		 $("#mobile").focus();
		 	showError('**手机号格式不对！');
		 	return false;
		}
		var dynamicpasswordother = $('#dynamicpassword').val();
		if(dynamicpasswordother==null || dynamicpasswordother ==''){
			$("#dynamicpassword").focus();
			showError('**验证码不为空！');
			return false;
		}
		if(!$("#readed").is(':checked')){
			showError('**请先勾选我已阅读');
			 return false;	 
		 }
		
		return true;
	}
	
	//显示错误提示
	function showError(str) {
		$('#alertMessage').text(str);
	}
	
	function checkCode(){
		var dynamicpassword= $('#dynamicpassword').val();
		var mobile = $('#mobile').val();
		$.ajax({
			type : "POST",
			url : $("#webRoot").val()+"/fo/lunarNewYearController.do?checkUserPhone",
			data : "&dynamicpassword="+dynamicpassword +"&mobile="+mobile,
			async: false,
			dataType : "json",
			success : function(data) {
				console.log(data);
				if (data == "0") {
					$('#userForm').submit();//提交路径
				}else{
					showError('**验证码有误！');
					return false;
				}
			}
		});
	}
	
	function checkIdNumber(){
		var identifynumber= $('#identifynumber').val();
		var customercname= $('#customercname').val();
		console.log(identifynumber);
		console.log(customercname);
		$.ajax({
			type : "POST",
			url : $("#webRoot").val()+"/fo/lunarNewYearController.do?checkIdNumber",
			data : "&identifynumber="+identifynumber +"&customercname="+customercname,
			async: false,
			dataType : "json",
			success : function(data) {
				console.log(data);
				if (data == "0") {
					checkCode();
				}else{
					showError('该身份已绑定微信号，请勿重复绑定');
					return false;
				}
			}
		});
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
		
		jqBtnObj.text(text + "("+ (countdownSec--)+")");	//设置按钮显示的名称
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
	
	var url = $("#webRoot").val() + "/fo/dynamicPasswordController.do?sendgasolineGiftDynamicPassword&version="+new Date();
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

//外来js(身份证号码检查 )


var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",  
34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",  
43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川"  
,52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",  
64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}   


function isCardID(sId){ 

 var resulta=true;

  var iSum=0 ;  
  var info="" ;  
  if(!/^\d{17}(\d|x|X)$/i.test(sId)){	  
      return false;  
  }
  var ss;
  sId=sId.replace(/x$/i,"a"); 
  ss=sId;
  if(aCity[parseInt(sId.substr(0,2))]==null){				  
      return false;  
  }
  sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));  
  var d=new Date(sBirthday.replace(/-/g,"/")) ;  
  if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())){
      return false;
  }
  for(var i = 17;i>=0;i --){
	  iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
  }
  if(iSum%11!=1){ 
      return false;
  }   
   return resulta;   
}  

