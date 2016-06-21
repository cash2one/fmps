<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/webpage/fo/common/fotags.jsp"%>  
<!doctype html>
<head>
  <title>富邦财险</title>
  <link href="${webRoot}/plug-in/fo/css/new.css" rel="stylesheet" type="text/css" />
 <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script> 
</head>
<style type="text/css">
html{background:#FFF;} 
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form, 
fieldset,input,textarea,p,blockquote,th,td { 
margin:0; 
padding:0; 
}
body {
	background-color: #fff;
}

.am-header-default {
	background-color: #fff;
}

.am-header {
	position: relative;
	width: 100%;
	height: 49px;
	line-height: 49px;
	padding: 0 10px;
	border-bottom: 2px solid #0e90d2;
}
header {
	height: 50px;
	line-height: 20px;
}
img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

.pay {
	width: 90%;
	margin: 0 auto;
}

.pay_top_text {
	text-align: left;
	font-size: 12px;
	font-family: "微软雅黑";
	width: 90%;
	margin: 0 auto;
	padding-top: 20px;
}

.pay_text {
	width: 20%;
	float: left;
	font-size: 16px;
	text-align: left;
}

.pay_input {
	width: 79%;
	float: left;
}

input {
	border-bottom: 1px solid #dedede;
	border-left: 0px solid #dedede;
	border-right: 0px solid #dedede;
	border-top: 0px solid #dedede;
	height: 21px;
	width: 100%;
	text-align: left;
	background-color: rgb(255, 255, 255); ;
}

.validate {
	width: 90%;
	margin: 0 auto;
}

.validate_text {
	width: 29%;
	float: left;
	font-size: 16px;
}

.validate_input {
	width: 50%;
	float: left;
}

.validate_letter {
	width: 20%;
	float: left;
	font-size: 20px;
	margin-top: 3px;
	text-align: right;
}

.pay_button {
	border-radius: 5px;
	background-color: #0e90d2;
	color: #fff;
	font-size: 18px;
	text-align: center;
	height: 47px;
	width: 90%;
	margin: 0 auto;
	line-height: 43px;
}


.am-topbar-inverse {
	background-color: #fff;
	border-color: #fff;
}
input:-webkit-autofill { 
-webkit-box-shadow: 0 0 0px 1000px #fff inset; 
}
</style>

<body >
<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title" style="color: #171717;">
      保险卡激活
    </h1>
  </header>
</header>
<div class="am-cf admin-main">
  <!-- sidebar start -->


  <!-- content start -->
  <div class="admin-content">
    
    <div>
<div class="am-slider am-slider-default" data-am-flexslider>
  <ul class="am-slides">
    <li></li>
  </ul>
</div>

    </div>

    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class=" am-form-horizontal" action="${webRoot}/fo/cardController.do?cardCommodity" method="post">
          <div class="pay">
			<div class="pay_text">卡 号：</div>
            <div class="pay_input">
              <input type="text" style="font-size: 14px; background-color:#fff" id="cardcount" maxLength="25" placeholder="请输入您的卡号" >
            </div>
          </div>
            <div id="cardcounttemp" style="color: red; text-align: left; text-indent: 5%; clear: both;" ></div>

          <div class="pay" style="margin-top:30px;">
			<div class="pay_text">密 码：</div>
			<div class="pay_input">
              <input type="password" style="font-size: 14px;  background-color:#fff" id="password" placeholder="请输入密码">
            </div>
          </div>
          <div id="passwordtemp" style="color: red; text-align: left; text-indent: 5%; clear: both;" ></div>
          <div class="am-form-group"  style="margin-top:15px;">
           
            <div class="am-u-sm-9" id="codediv" style="display:none;">
             <div >
            <div style="text-align:left;">验证码：</div>
            <div style="float: left; width: 75%;"><input class="randCode am-form-field" name="randCode" type="text" style="width:98%" id="randCode" title="" value="" placeholder="请输入验证码" ></div>
            <div style="float: left; width: 25%;"><img style="height: 45px;" id="randCodeImage2" src="${webRoot}/plug-in/login/images/preloader.gif" /></div> 
            </div>
            </div>
          </div>
          <div id="randCodetemp" style="color: red; text-align: left; text-indent: 10px;" ></div>
          <div>&nbsp;</div>
      <button type="button" style="height:45px; margin-bottom: 20px;" class="am-btn am-btn-primary btn-loading-example" data-am-loading="{spinner: 'circle-o-notch', loadingText: '验证中...' resetText: '下一步'}" id="next">下一步</button>
     <input type="hidden" id="openid" value="${openid}">
        </form> 
        <header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
	<div style="height: 50px;">
		<div><img src="${webRoot }/plug-in/fo/images/logo_bottom.jpg" width="320" height="38" /></div>
		<div style=" text-align: center; font-size: 12px; color: #222; width: 100%;">版权所有：富邦财产保险有限公司</div>
	</div>
	</header>
      </div>
<%
String M="0";
if(request.getSession().getAttribute("count")!=null){
   M=request.getSession().getAttribute("count").toString(); //从session里把a拿出来，并赋值
}
%>


<script>
var count=<%=M%>;
$(document).ready(function () {
	if(count>"2"){
		 $("#codediv").show();	
	}
	reloadRandCodeImageT();
	
	$('#next').click(function () {
		var actionurl = $('form').attr('action');//提交路径
		var checkurl = $('form').attr('check');//验证路径
		var cardcount = $("#cardcount").val();
		var password = $("#password").val();
		var randCode = $("#randCode").val();
		var openid= $("#openid").val();
		var $btn = $(this);	
	    if(checkinput()){ 
	    	if(count>2){
			  $.ajax({
					type: "POST",
					url : "${webRoot}/fo/cardController.do?checkCode",
					data:{randCode:randCode,openid:openid},
					dataType: "json",
					success: function(data){
						if(data == "1"){
								 location.href = actionurl + "&cardcount="+cardcount+"&password="+password+"&openid="+openid;	 
						}else{
							$("#randCode").focus();
							 $("#randCodetemp").text('**验证码有误！  ');
							$btn.button('reset');
						}
					}
			});
			  
	    	}else{
	    		 location.href = actionurl + "&cardcount="+cardcount+"&password="+password+"&openid="+openid;	 	
	    		
	    	} 
			  
	    }

 	});
});
	
//失去焦点 
  
    /*  失去焦点提示信息(卡号   )  */
     $("#cardcounttemp").text('');
	$('#cardcount').blur(function(){
		 var cardcount1=$("#cardcount").val();
		 if(cardcount1==""||cardcount1==null){
			$("#cardcounttemp").text('**卡号不能为空！');
			 result = false; 
		 }else{
			 $("#cardcounttemp").text('');
			 var reg_money =  /^[\d]+$/;
			 var mess = reg_money.test(cardcount1);
				$("#cardcounttemp").text('');
				if(cardcount1.length>25||cardcount1.length<15){
					$("#cardcounttemp").text('**卡号长度不符合要求，请重新输入  ！');		
					 result = false;
				}	
				if(!mess){
					$("#cardcounttemp").text('**卡号只能为数字 ！');	
					 result = false; 
				}
		 }
	}); 
	
	/*  失去焦点提示信息(密码    ) */
    $("#passwordtemp").text('');
	$('#password').blur(function(){
		 var cardcount2=$("#cardcount").val();
		var password1=$("#password").val();
		$("#passwordtemp").text('');
		 if(password1==""||password1==null){
			$("#passwordtemp").text('**密码不能为空！ ');
			 result = false; 
		 }
	}); 
	
	
	/*  失去焦点提示信息(验证码 ) */
   $("#randCodetemp").text('');
	$('#randCode').blur(function(){
		var count3=<%=M%>;
		if(count3>2){
		 var cardcount3=$("#cardcount").val();
		 var password3=$("#password").val();
		 var randCode2=$("#randCode").val();
		 $("#randCodetemp").text('');
		 if(randCode2==""||randCode2==null){
				$("#randCodetemp").text('**验证码不能为空！  ');
				 result = false; 
			 }	
		}
	}); 
	
//检查页面输入完整性 
function  checkinput() {	
	var result = true;	
	var cardcount=$("#cardcount").val();
	var password=$("#password").val();
	var randCode=$("#randCode").val();
	$("#cardcounttemp").text('');
	 if(cardcount==""||cardcount==null){
		$("#cardcount").focus();
		$("#cardcounttemp").text('**卡号不能为空！');
		 result = false; 
	 }else{
		 $("#cardcounttemp").text('');
		 var reg_money =  /^[\d]+$/;
		 var mess = reg_money.test(cardcount);	
			$("#cardcounttemp").text('');
			if(cardcount.length>25||cardcount.length<15){
				$("#cardcount").focus();
				$("#cardcounttemp").text('**卡号长度不符合要求，请重新输入  ！');		
				 result = false;
			}	
			if(!mess){
				$("#cardcount").focus();
				$("#cardcounttemp").text('**卡号只能为数字 ！');	
				 result = false; 
			}
	 }
	 $("#passwordtemp").text('');
	 if(password==""||password==null){
		if(cardcount!=""&&cardcount!=null){
			$("#password").focus();	
		}
		$("#passwordtemp").text('**密码不能为空！ ');
		 result = false; 
	 }
	// $("#randCodetemp").text('');
	 var count2=<%=M%>;
		if(count2>2){
			 if(randCode==""||randCode==null){
					if(cardcount!=""&&cardcount!=null){
					 if(password!=""&&password!=null){
						 $("#randCode").focus();
						}
					}
					$("#randCodetemp").text('**验证码不能为空！  ');
					 result = false; 
				 }
		}
	
	 
	return result;
}

</script>
      
    </div>
  </div>
  <!-- content end -->

</div>
<!--<![endif]-->
<script src="${webRoot}/plug-in/amaze-ui/js/app.js"></script>

<script type="text/javascript">
$('#randCodeImage2').click(function(){
    reloadRandCodeImageT();
    $('#randCode').val('');
});
/**
 * 刷新验证码
 */
function reloadRandCodeImageT() {
    var date = new Date();
    var img = document.getElementById("randCodeImage2");
    img.src=img.src.replace("/fo","");
    img.src='${webRoot}'+'/randCode.do?genCode&randCode=${openid}&a=' + date.getTime();
}
</script>
</body>
</html>
