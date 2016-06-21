<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%> 
<%@ include file="/webpage/fo/common/mobiscroll.jsp"%> 

<script src="${webRoot}/plug-in/fo/verificationIdentity.js"></script>
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
    <h1 class="am-header-title" >
    赴台旅游
    </h1>
  </header>

</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->


  <!-- content start -->
  <div class="admin-content">
 

  <form class="am-form-horizontal" action="${webRoot}/fo/taitravelController.do?taitravelInfo" method="post" name="form">   
<div style="margin: .5rem 1rem; border: 1px solid #dedede; height:auto; position:relative;">

 <div class="am-accordion-title" style="background-color:#f5f5f5;  padding: 0.8rem 2rem 0.8rem 1rem; border-bottom:1px solid #dedede;"> <i class=" am-icon-user"></i> 被保险人信息</div>
 <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">姓 名:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left;">
   <input size="13" class="input" id="insuredName" name="insuredName" type="text"  style="font-size:16px; height:30px; text-align:left; width:100%;border:0px; padding-right:10px;" value="${customer.customercname}" placeholder="请输入姓名" required maxlength="120">
  </div>
  <div id="insuredNametemp" style="color: red; text-align: left; text-indent: 10px; clear: both;" ></div>
 </div>
  <input type="hidden" id="cardno" name="cardno" value="${cardno}">
  <input type="hidden" id="type" name="type" value="${product.type}">
 
 <div style=" position:relative; height:49px; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:29%; float:left;">证件类型:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:right;">
  
   <div style="float:left; ">
<select data-am-selected name="insuredIdentifytype" id="ci">
  <option value="01">身份证</option>
  <option value="99">其它</option>
</select>
</div>
  
  </div>
 </div>
 
 
 <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">证件号码:</div>
  <div style="width:60%; float:left; padding-top:10px;  text-align:left;">
   <input id="insuredIdentifynumber" value="${customer.identifynumber}" name="insuredIdentifynumber" type="text"    style="font-size:16px; height:30px; width:100%;text-align:left; border:0px;padding-right:10px; "  placeholder="输入证件号码" >
  </div>
 <div id="insuredIdentifynumbertemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
  
 </div>
 
 
 <%-- 要用打开即可1
 
 <div id="genderf" style="display:none; position:relative; height:auto;border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:29%; float:left;">性 别:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left; text-indent: 13px;">
  <select id="insuredGender" name="insuredGender" style=" width: 50px;">
   <option value="M" <c:if test="${customer.customerSex=='M'  }">selected</c:if>>男</option>
  <option value="F" <c:if test="${customer.customerSex=='F'  }">selected</c:if>>女</option>

  </select>
  </div>
 <div id="insuredGendertemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div> --%>
 

 <%-- 要用打开即可2
 <div id="birthdayf"   style="display:none; position:relative; height:auto; border-bottom:1px solid #dedede;"> 
 
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">出生日期:</div>
  <div style="width:50%; float:left;  text-align:left;" onclick="changecolor();">
   <input class="am-form-field" id="insuredBirthday"  name="insuredBirthday"  readonly="readonly" value="<fmt:formatDate value='${customer.customerBirthday}' type="date" dateStyle="medium"/>" type="text"  style="border:0px; padding-top:15px; width:100%;color:black;background-color: #fff;">
  </div>
 <div id="insuredBirthdaytemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div> --%>
 
 
 
 
 <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">手机:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left;">
   <input id="insuredPhone"    value="${customer.mobile}" name="insuredPhone" type="text"  style="font-size:16px; height:30px; width:100%; text-align:left; border:0px; padding-right:10px;"  placeholder="请输入手机号码" >
  </div>
 <div id="insuredPhonetemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div>
 
 
  <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">常用地址:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left;">
  <div style="float:left; width: 34%; overflow: hidden;">
    <div class="am-form-group">
<select  id="provinceId" name="provinceCode" style="overflow: hidden;">
  <option value="a" style="overflow: hidden; width: 40px;">省</option>

</select>
</div>
</div>
  
  <div style="float:left; width: 33%; overflow: hidden;">
  <div class="am-form-group">
<select  name="cityCode" id="cityId" style="overflow: hidden;">
  <option value="a" style="overflow: hidden; width: 40px;">市</option>
</select>
</div>
</div>

<div style="float:left; width: 33%; overflow: hidden;">
  <div class="am-form-group">
<select  name="areaCode" id="areaId" style="overflow: hidden;"  >
  <option value="a" style="overflow: hidden; width: 40px;">区</option>

</select>
</div>
</div>
  
  </div> 
 <div id="insuredPhonetemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div> 
 
 
 
 <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;"></div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left;">
   <input id="detial"    value="${customer.detial}" name="detial" type="text"  style="font-size:16px; height:30px; width:100%; text-align:left; border:0px; padding-right:10px;"  placeholder="请输入详细地址" >
  </div>
 <div id="detialtemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div>
 
 
 
 
 
 
 
 
 <div style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
  <div id="landschool" style=" padding: 1.2rem 0rem 0.8rem 1rem; width:34%; float:left;">就读学校:</div>
  <div style="width:60%; float:left; padding-top:10px; text-align:left;">
   <input id="insuredSchool"    value="${customer.insuredSchool}" name="insuredSchool" type="text"  style="font-size:16px; height:30px; width:100%; text-align:left; border:0px; padding-right:10px;"  placeholder="请输入您所就读的学校" >
  </div>
 <div id="insuredSchooltemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 </div>


</div>



<input type="hidden" id="openid" name="openid" value="${openid}">
<%-- <input type="hidden" id="schemetype" name="schemetype" value="${schemetype}">
<input type="hidden" id="period" name="period" value="${period}">
<input type="hidden" id="premium" name="premium" value="${premium}"> --%>
 </form>
 

<button type="button" style="height:45px;   width: 100%;" class="am-btn am-btn-primary btn-loading-example" data-am-loading="{spinner: 'circle-o-notch'}" id="submitbutton">下一步</button>

</div>
  <!-- content end -->
<div style="width:603px;height:300px;display:none" id="container"></div>

<input type="hidden" id="json" value="${json}">
</div>


<script>

//自动获得地址 	
	var latitude=24.482166;   //用户当前经度
	var longitude=118.099313;  //用户当前纬度
	var ss='${json}';
	var parsedJson = jQuery.parseJSON(ss); 
  //微信地图 js 
	wx.config(${JSONString});
	//1.判断当前版本是否支持指定 JS 接口，支持批量判断
	 wx.ready(function () {
		 getLocation();
	  });  
	wx.error(function (res) {	
		  alert(res.errMsg);	
		  });
		$('#tr3').find('td').each(function(){
			
			if(value==$(this).html()){
				if($(this).index()!=0){
					if($(this).attr("style").trim()=="border-bottom:1px solid #dedede; width:20%;"){
					$(this).attr("style","border-bottom:1px solid #dedede; width:20%; background-color: #0e90d2; color: #fff;");
					$("#premium").val(value);
				    }else{
				    	$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");				
				    }
				}	
			}
		}); 	   
   //去掉数组中的重复的元素 
	 var    inArray = function(arr, elt) {
       for(var i = 0, len = arr.length; i < len; i++) {
           if(arr[i] === elt) {
               return true;
           }
       }
       return false;
   };
   
   var    unique = function(arr) {
       if(arr.length < 2) return arr;
       var i = 0, len = arr.length; re = [];
       for(; i < len; i++) {
           if(!inArray(re, arr[i])) {
               re.push(arr[i]);
           }
       }
       return re;
   };
	
	// 7.2 获取当前地理位置
	function getLocation(){	
	  wx.getLocation({
	    success: function (res) {    	 
	      longitude=res.longitude;
	 	  latitude=res.latitude;
	 	  initLocation (latitude,longitude);
	     },
	    cancel: function (res) {
	    alert('用户拒绝授权获取地理位置');	 
	  //  sanjiliandong();
	    
	    }
	  });
	}
	
	//腾讯地图js
	var citylocation,map,marker = null;  
	 //根据 用户实际位置定位 	 
	function initLocation(latitude,longitude){
		 var center = new qq.maps.LatLng(latitude,longitude);
		 map = new qq.maps.Map(document.getElementById('container'),{
		        center: center,
		        zoom: 13
		 });
		    var info = new qq.maps.InfoWindow({map: map});
		    geocoder = new qq.maps.Geocoder({
		        complete : function(result){
		        	//该处修改为设置省市下拉框
		        	//alert(result.detail.addressComponents.province+result.detail.addressComponents.city);
		        	var provinceW=result.detail.addressComponents.province;
		        	var cityW=result.detail.addressComponents.city;

					  var tmpprovinceCC = new Array(); 
					  var tmpcityCC = new Array();

			 			$.each(parsedJson,function(key,value){
			 		       if(value.province==provinceW){
			 		    	  tmpprovinceCC.push(value.provinceCode);
			 		        }
			 		       
			 		      if(value.city==cityW){
			 		    	 tmpcityCC.push(value.cityCode);
			 		        }
	 
			 		      });
			 	        
			       		var tmpprovinceCodeC=unique(tmpprovinceCC);
			       		var tmpcityCodeC=unique(tmpcityCC);
			       	    $("#provinceId").html("");
			 		    $("#cityId").html("");
			 		    for(var i in tmpprovinceCodeC){
			               	//该元素在tmp内部不存在才允许追加 
		                   //alert(tmpprovinceCodeC[i]);  
		                  // alert(tmpcityCodeC[i]);  
		                   
				 		   $("#provinceId").append("<option value='"+provinceW +"'>"+provinceW+"</option>");
				 		    $("#cityId").append("<option value='"+cityW+"'>"+cityW+"</option>");
				 		  // $("#provinceId").find("option[value='"+tmpprovinceCodeC[i]+"']").attr("selected",true);  
				 		  // $("#cityId").find("option[value='"+tmpcityCodeC[i]+"']").attr("selected",true);  
				 		 
			 		    }  
			 		    sanjiliandong();
			 		    
						  var tmpcityNA = new Array(); 
						  var tmpcityCA = new Array();

				 			$.each(parsedJson,function(key,value){
				 		       if(value.province==provinceW){
				 		    	  tmpcityNA.push(value.city);
				 		    	  tmpcityCA.push(value.cityCode);
				 		        }
				 		      });

				       		var tmpcityNameA=unique(tmpcityNA);
				       		var tmpcityCodeA=unique(tmpcityCA);
				 		    for(var i in tmpcityNameA){
				               	//该元素在tmp内部不存在才允许追加
			                    $("#cityId").append("<option value='"+tmpcityNameA[i]+"'>"+tmpcityNameA[i]+"</option>");
				               	}   
   
				 		   var tmpcountyNA = new Array(); 
				 			  var tmpcountyCA = new Array();

					 			$.each(parsedJson,function(key,value){
					 		       if(value.city==$("#cityId option:checked").text()){
					 		    	  
					 		    	  tmpcountyNA.push(value.county);
					 		    	  tmpcountyCA.push(value.countyCode);
					 		        }
					 		      });
					
			      
					       		var tmpcountyNameA=unique(tmpcountyNA);
					       		var tmpcountyCodeA=unique(tmpcountyCA);
					 		    for(var i in tmpcountyNameA){
				 	               	//该元素在tmp内部不存在才允许追加
				                      $("#areaId").append("<option value='"+tmpcountyNameA[i]+"'>"+tmpcountyNameA[i]+"</option>");
				 	               	
				 	               	
				 	               	}   
		            map.setCenter(result.detail.location);
		            var marker = new qq.maps.Marker({
		                map:map,
		                position: result.detail.location
		            });
		            qq.maps.event.addListener(marker, 'click', function() {
		                info.open();
		                info.setContent('<div style="width:280px;height:100px;">'+
		                    result.detail.address+'</div>');
		                info.setPosition(result.detail.location);
		            });
		        }
		    });	
		    geocoder.getAddress(center);  //根据 经纬度 定位用户所属市区、地址 
	}

   
	//初始化 
	$(document).ready(function () {
		   sanjiliandong(); 
	});
	//三级联动 
	function sanjiliandong(){
	  	 /*	三级联动   */ 
	 	
		
		  var tmpprovinceN = new Array(); 
		  var tmpprovinceC = new Array();
		  //var parsedJson = jQuery.parseJSON(ss); 
		  
			$.each(parsedJson,function(key,value){
		    	  tmpprovinceN.push(value.province);
		    	  tmpprovinceC.push(value.provinceCode);
		      });

   		var tmpprovinceName=unique(tmpprovinceN);
   		var tmpprovinceCode=unique(tmpprovinceC);
   		
		    for(var i in tmpprovinceName){
           	//该元素在tmp内部不存在才允许追加
     
          $("#provinceId").append("<option value='"+tmpprovinceName[i] +"'>"+tmpprovinceName[i]+"</option>");  

           	}      

	        $("#provinceId").change(function () {  
	       	 var data2="provinceId="+$("#provinceId").val();
	       	 if($("#provinceId").val()!="a"){
	      

			  var tmpcityN = new Array(); 
			  var tmpcityC = new Array();

	 			$.each(parsedJson,function(key,value){
	 		       if(value.province==$("#provinceId option:checked").text()){
	 		    	  tmpcityN.push(value.city);
	 		    	  tmpcityC.push(value.cityCode);
	 		        }
	 		      });
	
	 	        
	       		var tmpcityName=unique(tmpcityN);
	       		var tmpcityCode=unique(tmpcityC);
	       		$("#cityId").html("");
	 		    for(var i in tmpcityName){
	               	//该元素在tmp内部不存在才允许追加
                  $("#cityId").append("<option value='"+tmpcityName[i]+"'>"+tmpcityName[i]+"</option>");
	               	}   
	 		    
	 		    
	 			  var tmpcountyN = new Array(); 
	 			  var tmpcountyC = new Array();

		 			$.each(parsedJson,function(key,value){
		 		       if(value.city==$("#cityId option:checked").text()){
		 		    	  tmpcountyN.push(value.county);
		 		    	  tmpcountyC.push(value.countyCode);
		 		        }
		 		      });
		
    
		       		var tmpcountyName=unique(tmpcountyN);
		       		var tmpcountyCode=unique(tmpcountyC);
		       		$("#areaId").html("");
		 		    for(var i in tmpcountyName){
	 	               	//该元素在tmp内部不存在才允许追加
	                      $("#areaId").append("<option value='"+tmpcountyName[i]+"'>"+tmpcountyName[i]+"</option>");
	 	               	
	 	               	
	 	               	}      	
	 		    
	 		    
	       	 }else{
	       	  $("#cityId").html("");
	       	  $("#cityId").append("<option value='a'>选择市</option>");
	       	$("#areaId").html("");
	        $("#areaId").append("<option value='a'>选择区</option>"); 
	       	 }
	       });
	    $("#cityId").change(function () {
	    	 var data3="cityId="+$("#cityId").val();
	    	 if($("#cityId").val()!="a"){

	 			  var tmpcountyN = new Array(); 
	 			  var tmpcountyC = new Array();

		 			$.each(parsedJson,function(key,value){
		 		       if(value.city==$("#cityId option:checked").text()){
		 		    	  tmpcountyN.push(value.county);
		 		    	  tmpcountyC.push(value.countyCode);
		 		        }
		 		      });
		
    
		       		var tmpcountyName=unique(tmpcountyN);
		       		var tmpcountyCode=unique(tmpcountyC);
		       		$("#areaId").html("");
		 		    for(var i in tmpcountyName){
	 	               	//该元素在tmp内部不存在才允许追加
	                      $("#areaId").append("<option value='"+tmpcountyName[i]+"'>"+tmpcountyName[i]+"</option>");

	 	               	}      	 
	    	 }
	    }); 

	}	 

	/* 要用打开即可3
	//根据身份类型判断 是否将性别，生日日期隐藏 
	$("#ci").change(function () {
      	 var identifytype=$("#ci").val();
      	 if(identifytype=="01"){
    		 $("#birthdayf").hide();
    		 $("#genderf").hide();
    	 }else{
    		 $("#birthdayf").show();
    		 $("#genderf").show();
    		 
    	 }
    });
 */


//初始化		
	   $(document).ready(function () {
		  /*  要用打开即可4
		  
		  $('#insuredBirthday').mobiscroll().date({
               theme: 'android-holo-light',     // Specify theme like: theme: 'ios' or omit setting to use default 
               mode: 'modal',       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
               lang: 'zh',        // Specify language like: lang: 'pl' or omit setting to use default 
               dateFormat: 'yy-mm-dd',
               maxDate: new Date(),
               yearText: "年",

           }); */
		   
	    /*  提交处理函数    */
		$('#submitbutton').click(function () {
		     var btn = $('#submitbutton');				  
			  if(checkAll()){ 
				  btn.button('loading');
				    setTimeout(function(){
				        btn.button('reset');
				    }, 15000);
				 
				  document.form.submit(); 
			        
			  }   
		});
	});
//radio点击切换 
	 function radioShow(){
				   var identity= $('input:radio[name="studenttype"]:checked').val();
				   if(identity=="陆籍生"){
					   $("#landblock").html("大陆所属地区:");
					   $("#landschool").html("大陆就读学校:");
				   }	
				   if(identity=="台籍生"){
					   $("#landblock").html("台湾地区:");
					   $("#landschool").html("台湾就读学校:");		   
				   }
			   }
//失去焦点检查 
	/*  失去焦点提示信息(姓名) */
/* 	$('#insuredName').blur(function(){
		 var name1=$("#insuredName").val();
		 $("#insuredNametemp").text('');
		 if(name1==""||name1==null){
			$("#insuredNametemp").text('**姓名不能为空！   ');
			 result = false; 
		 }
	}); */
	
	/*  失去焦点提示信息(证件号码 ) */
	/* $('#insuredIdentifynumber').blur(function(){
		 var identifynumber1=$("#insuredIdentifynumber").val();
		 $("#insuredIdentifynumbertemp").text('');
		 if(identifynumber1==""||identifynumber1==null){
				$("#insuredIdentifynumbertemp").text('**证件号码不能为空！     ');
			 result = false; 
		 }
	}); */
	
	/*  失去焦点提示信息(证件号码 ) */
	/* $('#insuredIdentifynumber').blur(function(){
		 var identifynumber1=$("#insuredIdentifynumber").val();
		 $("#insuredIdentifynumbertemp").text('');
		 if(identifynumber1==""||identifynumber1==null){
				$("#insuredIdentifynumbertemp").text('**证件号码不能为空！     ');
			 result = false; 
		 }
	}); */
	
	/*  失去焦点提示信息(学校地址 ) */
	/* $('#insuredSchool').blur(function(){
		 var insuredSchool=$("#insuredSchool").val();
		 $("#insuredSchooltemp").text('');
		 if(insuredSchool==""||insuredSchool==null){
				$("#insuredSchooltemp").text('**学校名称不能为空！      ');
			 result = false; 
		 }
	}); */
	
	/*  失去焦点提示信息(详细地址 ) */
	/* $('#insuredSchool').blur(function(){
		var detial=$("#detial").val();
	 $("#detialtemp").text('');
	 if(detial==""||detial==null){
			$("#detialtemp").text('**详细地址不能为空！      ');
		 result = false; 
	 }	 
	}); */
	
	/*  失去焦点提示信息(手机号码 ) */
	/* $('#insuredPhone').blur(function(){
		 var phone1=$("#insuredPhone").val();
		 $("#insuredPhonetemp").text('');
		   var re=/^1[0-9]{10}$/; 
			if(!re.test(phone1)){   
				$("#insuredPhonetemp").text('**手机号格式不对！       ');
			 result = false; 
			}
	});
 */



//按钮点击检查 

	
		var $btn = $('#submitbutton');
		/*检查页面输入完整性*/ 
		function  checkAll() {	
			var result = true;

			 var insuredName=$("#insuredName").val();
			 var insuredIdentifynumber=$("#insuredIdentifynumber").val();
			 var type=$("#type").val();
			 var insuredPhone=$("#insuredPhone").val();
			 var insuredSchool=$("#insuredSchool").val();
			 var detial=$("#detial").val();
			/* 要用打开即可5 
			
			var insuredGender=$("#insuredGender").val();
			 var insuredBirthday=$("#insuredBirthday").val().replace("出生日期：","");
			
 */
			 $("#insuredNametemp").text('');
			 if(insuredName==""||insuredName==null){
				$("#insuredName").focus();
				$("#insuredNametemp").text('**姓名不能为空！   ');
				 result = false; 
			 }
			 
			 $("#insuredIdentifynumbertemp").text('');
			 if(insuredIdentifynumber==""||insuredIdentifynumber==null){
				 $("#insuredIdentifynumber").focus();
					$("#insuredIdentifynumbertemp").text('**证件号码不能为空！     ');
				 result = false; 
			 }

			 $("#insuredSchooltemp").text('');
			 if(insuredSchool==""||insuredSchool==null){
					$("#insuredSchooltemp").text('**学校名称不能为空！      ');
				 result = false; 
			 }
			 
			 $("#detialtemp").text('');
			 if(detial==""||detial==null){
					$("#detialtemp").text('**详细地址不能为空！      ');
				 result = false; 
			 }
			/*  要用打开即可6
			 $("#insuredGendertemp").text('');
			 if(insuredGender==""||insuredGender==null){
				 $("#insuredGender").focus();
					$("#insuredGendertemp").text('**性别不能为空！     ');
				 result = false; 
			 }
		
			 $("#insuredBirthdaytemp").text('');	
			 if(insuredBirthday==""||insuredBirthday==null){
					 $("#insuredBirthday").attr("value","**生日日期不能为空！");
					 $("#insuredBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:red; background-color: #fff;");//单个属性的设置 
					
				 result = false; 
			 } */

			 $("#insuredPhonetemp").text('');
			   var re=/^1[0-9]{10}$/; 
				if(!re.test(insuredPhone)){   
				 $("#insuredPhone").focus();
					$("#insuredPhonetemp").text('**手机号格式不对！       ');
					//$btn.button('reset');
				 result = false; 
				}	
				
				 $("#insuredIdentifynumbertemp").text('');
				 var identifytype = $("#ci").val();
			      if (identifytype == '01') {
			      if(!isCardID(insuredIdentifynumber.trim(), 1)){
			    	  result = false; 
			      }
			      }
				
				

			return result;
		}


/*要用打开即可7 
		  //处理改变生日日期颜色函数 （被保人） 
			function changecolor(){
				 if($("#insuredBirthday").val()=="**生日日期不能为空！"){
					 $("#insuredBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:black; background-color: #fff;");//单个属性的设置 
					 $("#insuredBirthday").attr("value","");
				 }
				 if($("#insuredBirthday").val()!=""&&$("#insuredBirthday").val()!="**生日日期不能为空！"){
					 $('.am-form-field').datepicker('setValue', $("#insuredBirthday").val());
				 }
				 
			} */
	 
	
	/* 要用打开即可8
	
	//响应单击事件
		$(function() {
	  $('#insuredIdentifynumber').blur(function() {
	      var strinput = $("#insuredIdentifynumber").val();
	      var identifytype22 = $("#ci").val()
	      if (identifytype22 == '01') {
	          if (isCardIDD(strinput, 1)) { 
	        	  var setx=(strinput.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
				
	              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
	              if (sBirthdayy!= "undefined" && setx != "undefined"&&sBirthdayy!= "" && setx != "") {
	            	  if(setx=="男"){
	            		  setx="M";
	            	  }
	            	  if(setx=="女"){
	            		  setx="F";
	            	  }
	            	  var iss=sBirthdayy.split("-");
	            	  if(iss[2].length=='1'&&iss[1].length!='1'){
	            		  sBirthdayy=iss[0]+"-"+iss[1]+"-"+"0"+iss[2];
	            	  }
	            	  if(iss[1].length=='1'&&iss[2].length!='1'){
	            		  sBirthdayy=iss[0]+"-0"+iss[1]+"-"+iss[2];
	            	  }
	            	  if(iss[1].length=='1'&&iss[2].length=='1'){
	            		  sBirthdayy=iss[0]+"-0"+iss[1]+"-"+"0"+iss[2];
	            	  }
	            	  $("#insuredGender").val(setx);
	                  $("#insuredBirthday").val(sBirthdayy);
	              }
	          }
	      }
	  });
	}); 
	
	 

	
	
	  //证件类型修改触发(被保人 ) 
	     $("#insuredIdentifynumbertemp").text(''); 
	  $("#ci").change(function(){
		  //code...
		   var strinputt = $("#insuredIdentifynumber").val();
		   var identifytypeci = $("#ci").val();
		   if(strinputt!=""){ 
		   if (identifytypeci == '01') {
			   if (isCardIDD(strinputt, 1)) {
				
				   var sex=(strinputt.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
					
		              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
		              if (sBirthdayy != "undefined" && sex!= "undefined"&&sBirthdayy != "" && sex!= "") {
		            	  if(sex=="男"){
		            		  sex="M";
		            	  }
		            	  if(sex=="女"){
		            		  sex="F";
		            	  }
		            	  var sss=sBirthdayy.split("-");
		            	  if(sss[2].length=='1'&&sss[1].length!='1'){
		            		  sBirthdayy=sss[0]+"-"+sss[1]+"-"+"0"+sss[2];
		            	  }
		            	  if(sss[1].length=='1'&&sss[2].length!='1'){
		            		  sBirthdayy=sss[0]+"-0"+sss[1]+"-"+sss[2];
		            	  }
		            	  if(sss[1].length=='1'&&sss[2].length=='1'){
		            		  sBirthdayy=sss[0]+"-0"+sss[1]+"-"+"0"+sss[2];
		            	  }
		            	  $("#insuredGender").val(sex);
		                  $("#insuredBirthday").val(sBirthdayy);
		              }
		          }
		   }
		   }
	  });  */
	  

	  //验证身份证合法性  
	    var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
	    		21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",  
	    		34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",  
	    		43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川"  
	    		,52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",  
	    		64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}   

	    function isCardIDD(sId,flag){ 
	    	
      	 var resulta=true;
	   		  if (flag == 1) {
	   		      identifynumber3 = "insuredIdentifynumber";
	   		      identifynumbertemp3 = "insuredIdentifynumbertemp";
	   		  } else {
	   		      identifynumber3 = "applicantNumber";
	   		      identifynumbertemp3 = "applicantNumbertemp";
	   		  }          
	
	
			  var iSum=0 ;  
			  var info="" ;  
			  if(!/^\d{17}(\d|x)$/i.test(sId)){	  
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
		          resulta = false;  
			  }
			  var ss;
			  sId=sId.replace(/x$/i,"a"); 
			  ss=sId;
			  if(aCity[parseInt(sId.substr(0,2))]==null){				  
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;  
			  }
			  sBirthdayy=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));  
			  var d=new Date(sBirthdayy.replace(/-/g,"/")) ;  
			  if(sBirthdayy!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())){
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;
			  }
			  for(var i = 17;i>=0;i --){
				  iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
			  }
			  if(iSum%11!=1){ 
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;
			  }   
	           return resulta;   
		}  

</script>

<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->

</body>
</html>
