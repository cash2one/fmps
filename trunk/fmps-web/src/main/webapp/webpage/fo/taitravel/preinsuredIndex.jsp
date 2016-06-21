<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%> 
<%@ include file="/webpage/fo/common/mobiscroll.jsp"%> 
<!doctype html>
<html class="no-js">
<head>
  <title>富邦财险</title>
  <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script> 
</head>

<style type="text/css">
.am-selected-btn {
text-align: right;
width: 100px;
}


.am-btn-default {
border:0px;
}

.am-btn {
display: inline-block;
margin-bottom: 0;
padding: 0.225em 1em;}

.am-btn-primary{ width:96%;}
img{ 
  max-width: 100%;
  height: auto;
   }
   
header {
  height: 50px;
  line-height: 0px;
  }
  
.am-topbar {
  position: none;
  min-height: 0px;
  margin-bottom: 0rem;
  }
  .am-btn-success {
  color: #fff;
  background-color: #f8a3a8;
  border: 0px;
}
.input::-ms-clear { display: none; }
.input:valid + .clear { display: inline; }
  

.am-header .am-header-title {
  margin: 0 20%;}
.am-form-field {

  padding: 0em;

}
</style>
<body>
<!--[if lte IE 9]>

<![endif]-->
<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title">
      在线预约
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
    <li><img src="${webRoot}/plug-in/fo/images/yuyue.jpg" height="350" width="700" /></li>
  </ul>
</div>

    </div>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
      <form class="am-form am-form-horizontal"  action="${webRoot}/fo/taitravelController.do?savePreinsured" method="post"  id="form1" name="form1">
          <div class="am-form-group">
            <div style="text-align:left; text-indent:5px;">地区:
             <select data-am-selected name="block" id="block">
				  <option value="福建" selected>福建</option>
				  <option value="厦门" >厦门</option>
				  <option value="大连" >大连</option>
				  <option value="重庆" >重庆</option>
				   <option value="辽宁" >辽宁</option>
				    <option value="四川" >四川</option>
			  </select></div>
          
          </div>
           <div>&nbsp;</div>
          
          <div class="am-form-group">
            <div style="text-align:left; text-indent:5px; float:left; width:15%;">姓名:</div>
            <div class="am-u-sm-9" style="text-align:left; width:80%;">
              <input type="text" id="name" name="name" placeholder="请输入您的姓名">
            </div>
             <div id="nametemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
          </div>

  
          
          <div class="am-form-group" style="margin-top:15px;">
            <div style="text-align:left; text-indent:5px; float:left; width:15%;">手机:</div>
            <div class="am-u-sm-9" style="float:left; width:80%;">
              <input type="text"  id="phone" name="phone"  placeholder="请输入您的手机号">
            </div>
            <div id="phonetemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
  
          </div>
          
          
          <div>&nbsp;</div>

       <button type="button" style="height:45px;   width: 100%;" class="am-btn am-btn-primary btn-loading-example" data-am-loading="{spinner: 'circle-o-notch'}" id="submitbutton">确认</button>
       <input type="hidden" id="openid" name="openid" value="${openid}">
        </form> 
      </div>




<script>

//初始化		
	   $(document).ready(function () {
	    /*  提交处理函数    */
		$('#submitbutton').click(function () {
		     var btn = $('#submitbutton');				  
			  if(checkAll()){ 
				  btn.button('loading');
				    setTimeout(function(){
				        btn.button('reset');
				    }, 15000);
				 
				  document.form1.submit(); 
			        
			  }   
		});
	});

//失去焦点检查 
	/*  失去焦点提示信息(姓名) */
/* 	$('#name').blur(function(){
		 var name1=$("#name").val();
		 $("#nametemp").text('');
		 if(name1==""||name1==null){
			$("#nametemp").text('**姓名不能为空！   ');
			 result = false; 
		 }
	});	*/
	
	/*  失去焦点提示信息(手机号码 ) */
	/*
	$('#phone').blur(function(){
		 var phone1=$("#phone").val();
		 $("#phonetemp").text('');
		   var re=/^1[0-9]{10}$/; 
			if(!re.test(phone1)){   
				$("#phonetemp").text('**手机号格式不对！       ');
			 result = false; 
			}
	}); */




//按钮点击检查 

	
		var $btn = $('#submitbutton');
		/*检查页面输入完整性*/ 
		function  checkAll() {	
			var result = true;

			 var insuredName=$("#name").val();
			 var insuredIdentifynumber=$("#insuredIdentifynumber").val();
			 var insuredPhone=$("#phone").val();

			 $("#nametemp").text('');
			 if(insuredName==""||insuredName==null){
				$("#name").focus();
				$("#nametemp").text('**姓名不能为空！   ');
				 result = false; 
			 }			 
			 
			 
			 $("#phonetemp").text('');
			   var re=/^1[0-9]{10}$/; 
				if(!re.test(insuredPhone)){   
				 $("#phone").focus();
					$("#phonetemp").text('**手机号格式不对！       ');
					//$btn.button('reset');
				 result = false; 
				}	

			return result;
		}
	  
	

</script>

<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<script src="${webRoot}/plug-in/amaze-ui/js/app.js"></script>
</body>
</html>
