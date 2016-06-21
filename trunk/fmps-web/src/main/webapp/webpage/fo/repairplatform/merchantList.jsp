<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>爱车之家</title>
  <meta name="description" content="富邦财险">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <%@ include file="/webpage/fo/common/fotags.jsp"%>
  <link href="http://cdn.amazeui.org/amazeui/2.5.0/css/amazeui.min.css" />
  <script src="http://cdn.amazeui.org/amazeui/2.5.0/js/amazeui.min.js"></script>
  <link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css"  >
  <link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/double_index.css" />
  <script charset="utf-8"
	src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>
	<style>
	 .grid {
    overflow: hidden;
  }
  .cell {
    float: left;
    width: 100%;
    box-sizing: border-box;
    padding: 20px;
    display: table;
  }
  .card {
    border-radius: 15px;
    display: table-cell;
    text-align: center;
    vertical-align: middle;
    height: 380px;
  } 
	</style>
</head>
<body>
<!-- 
 <div>   <img class="img_top" src="${webRoot}/plug-in/repair/eleven_index_img.jpg">   </div> 
  -->
  <div style="height: 20px;">&nbsp;</div>
   <div class="grid" ID="load"  >
         <div class="cell">
            <div class="card"> <span class="spinner-loader">Loading&#8230;</span> 
              <div style="clear:both;">正在加载</div>
           </div>                  
         </div>
   </div>  
  <div class="Double_activity_recommend"   id="merchantList" style="display:none" >   
           <%@ include file="merchant.jsp"  %>
  </div> 
  
    <div class="Double_activity_xian_bottom" style="display:none">&nbsp;</div>
   <!-- 
    <button type="button" onclick="initLocation()"    >测试按钮</button>
    -->
    <div style="width:603px;height:300px display:none  " id="container"   ></div>
    <input type="hidden" id="address" name="address" value=""> 
    <input type="hidden" id="cityCode" name="cityCode" value=""> 
</body>

<script>

  var address="厦门市湖里区东港北路";//用户当前地址 
  var city="厦门市";  //用户当前城市代码 
  var latitude=24.482166;   //用户当前经度
  var longitude=118.099313;  //用户当前纬度  
  var citylocation,map,marker = null; //腾讯地图js
  var repairListHtml=""; //动态厂商列表 
  var paging=1 ;//初始分页 
  var isendpage=false ; //是否到达最后一页 
  var controlFlag=true; 
  
  
   $(function(){ 
	   $("#repairList").empty(); //清空列表
	   init();	   
	   $(window).scroll(function () {
	        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
	        //$(window).height()获取当前窗体的高度
	        //$(document).height()获取当前文档的高度	        
	       //var city=document.getElementById("select_area").value;	 
	       //var order=document.getElementById("orderby").value;
	       //var address=document.getElementById("address").value;	 	        
	      var bot = 20; //bot是底部距离的高度
	     // alert("ya");
	        if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {	 
	        	//alert("kao");
     	      if(!isendpage&&controlFlag){     	    	
     	    	controlFlag=false;  
	        	paging=paging+1;	        	 
	        	getMerchant();
	        	
	        	}
	        }
	    });
	   	   
	});
 
   function init(){	   
	   if("YES"=="${hasLbs}"){	 //如果后台有缓存 地理位置 就用 后台的 地理位置 	
			longitude= ${longitude} ;
	  	    latitude= ${latitude};
	  	    initLocation();
		 }else{			 
		      //微信地图 js 
		    wx.config(${JSONString});
		      //1.判断当前版本是否支持指定 JS 接口，支持批量判断
		    wx.ready(function () {	  
			 getLocation();  //使用 微信 获取地理位置 
			     });			   
		    wx.error(function (res) {	
				  alert(res.errMsg);	
				  });			
		     }	     		 		
	  }
  

   // 7.2 获取当前地理位置
   function getLocation(){	
       wx.getLocation({
         success: function (res) {    	 
            longitude=res.longitude;
      	    latitude=res.latitude; 
      	    initLocation();
          },
         cancel: function (res) {
           alert('用户拒绝授权获取地理位置');
           initLocation();
         }
       });   
     }
  
  //根据 用户实际位置定位 	 
  function initLocation(){	 
 	 var center = new qq.maps.LatLng(latitude,longitude);
 	    map = new qq.maps.Map(document.getElementById('container'),{
 	        center: center,
 	        zoom: 13
 	    });
 	    var info = new qq.maps.InfoWindow({map: map});
 	    geocoder = new qq.maps.Geocoder({
 	    	 complete : function(result){
 		        	city=result.detail.addressComponents.city; 		        	 		        	 
 		        	address=result.detail.address; 		           		        	 
 		        	$('#address').val(address); 		        	 
 		        	getMerchant(); //异步请求数据 
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
  
  
  //根据 地址 城市 获取首页信息 
 function getMerchant(){
	 var encodeCity=escape(encodeURIComponent(city)); //转码	  
	 var encodeaddress=escape(encodeURIComponent(address)); //转码
	  var url="${webRoot}/fo/carHomeController.do?getmerchantListByGiftSetId&giftsetDetailId=${giftsetDetailId}&openid=${openid}&city="+encodeCity+"&address="+encodeaddress+"&latitude="+latitude+"&longitude="+longitude+"&paging="+paging; 	
	  $.ajax({
		  type : 'GET',
		  url : url,
		  dataType : "json",
	      success: function (json) {	    	  
	      if(json.success){
	    	controlFlag=true;
	    	var repairList=eval('(' +json.obj+ ')'); 	    	
	    	 if(repairList.length!=0){ 	    	
	    		getRepairList (repairList); 
	    	 }else{		
	    		 repairListHtml+="<li style='text-align:center;' >已经到达尾页了</li>" ;
	    		 repairListHtml +="<div style=\"height:50px;clear: both;\">&nbsp;</div>";
			 isendpage=true;
				 }
	    	  $("#repairList").append(repairListHtml); 
	    	 hidediv();  //关闭加载状态 
	    	 showPage(); //显示页面 	  
	      }else{
	    		alert("异步获取商户失败" +json.msg); 
	    		hidediv();  //关闭加载状态 
	    	  }
	       },
	      error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
	    	  alert("ajax获取失败"); 
	    	  hidediv();  //关闭加载状态 
	       }
	     }); 
    }
  
 function  testalert(){
	  cityCode=document.getElementById("select_area").value; 
	  address=document.getElementById("address").value; 
	alert(cityCode);
	alert(address);
	  
  }
 
  function showPage(){	 
	
	  $('#merchantList').show(); //精品商家 区 
	  $('.Double_activity_xian').show(); // 分隔符 
	  $('.Double_activity_xian_bottom').show(); // 分隔符 
    }
  
  function showdiv() { 
	     document.getElementById("load").style.display ="block";   
	  }
  function hidediv() {
	    document.getElementById("load").style.display ='none';   
	 }
  //跳转到维修厂主页
  function  goRepairMain(repairId){
	   location.href="${webRoot}/fo/carHomeController.do?method=MerchantMain&openid=${openid}&repairId="+repairId; 
   } 
  
//7.1 查看地理位置
  function openLocation(){
   wx.openLocation({
     latitude: latitude,
     longitude: longitude,
     name: 'fubon',
     address:'' ,
     scale: 14,
     infoUrl: 'http://weixin.qq.com'
     });
   }
  
</script>
</html>