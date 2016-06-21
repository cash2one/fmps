<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<style type="text/css">
  *{
    margin:0px;
    padding:0px;
   }
   body, button, input, select, textarea {
    font: 14px/16px Verdana, Helvetica, Arial, sans-serif;
   }
   p{
    width:603px;
    padding-top:3px;
    overflow:hidden;
    }
    html,
    body,
    .page {
      height: 100%;
    }
    #wrapper {
      position: absolute;
      top: 49px;
      bottom: 0;
      margin: 0;
      width: 100%;
      padding: 0 8px;
      background-color: #f8f8f8;
    }
    .am-list {
      margin: 0;
    }
    .am-list > li {
      background: none;
      box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8); padding:10px 0px 10px 0px;
    }
    .pull-action {
      text-align: center;
      height: 45px;
      line-height: 45px;
      color: #999;
     }
    .pull-action .am-icon-spin {
      display: none;
     }
    .pull-action.loading .am-icon-spin {
      display: block;
     }
    .pull-action.loading .pull-label {
      display: none;
     }
</style>
</head>
<body  >
<div class="page">
    <header data-am-widget="header" class="am-header am-header-default">
        <h1 class="am-header-title"> 维修平台   </h1>
     </header>
  <div id="wrapper" data-am-widget="list_news"  > 
 <div style=" width: 25%; float: left; padding-top: 18px;">当前地区：</div> 
 <div style=" width: 75%; float: left;"><select id="select_area"  onchange=RefreshList(this.value)  style=" width: 50%; text-align:left; height: 30px; margin-top: 10px; ">  
   <option value="请选择">请选择</option>
  <c:forEach items="${cityList}" var="city" varStatus="status">
   <option value="${city.city}">${city.city}</option> 
 </c:forEach>       
  </select></div>
  
<div style="width:100%; clear:both; height:auto; margin:0 auto; padding-bottom:15px; padding-top: 15px;">
      <div  id="Present_address" style="width:95%; float:left; padding-bottom:10px;">所在位置： </div>
      <div style="width:5%; float:left;"></div>
<div>
</div>
</div>       
    <div class="am-list-news-bd"  id="repairPlatformList"  >  </div>
  </div>
</div>

<div style="display: none;">
      <p>############&&&&######****#################</p>
      <p>********* **********</p>
      <h3 id="menu-location">地理位置接口</h3>
      <span class="desc">使用微信内置地图查看位置接口</span>
      <button onclick='openLocation()' >openLocation</button>
      <span class="desc">获取地理位置接口</span>
      <button   onclick='getLocation()' >getLocation</button>
      <p>********* **********</p>
       <button onclick='alertlocation()'>alert location</button>
      <p>********* *********</p>  
      <p>********* *********</p>
      <button onclick='codeLatLng()'>alert codeLatLng</button>
      
      
  <div>
    <input id="latLng" type="textbox" value="39.89477,116.35432">
    <input type="button" value="search" onclick="geolocation_latlng()">
    <span style="height:30px;display:none" id="city"></span>
</div>
 <div style="width:603px;height:300px" id="container"></div>
 <p>根据地理坐标确定地图中心位置。</p> 
 
   
 </div>
</body>
<script> 
 //全局变量 
   var latitude=24.482166;   //用户当前经度
   var longitude=118.099313;  //用户当前纬度  
  // var ManufacturersList=''; //动态厂商列表   
   //var divArray=new Array(); //动态DIV 列表 提供排序 
   var quantum=1;   //厂商数量 
  
 //微信地图 js 
   wx.config(${JSONString});
  //1.判断当前版本是否支持指定 JS 接口，支持批量判断
    wx.ready(function () { 
	  init();
     });  
   wx.error(function (res) {	
	  alert(res.errMsg);	
	  });
 // 7.1 查看地理位置
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
 
 // 7.2 获取当前地理位置
 function getLocation(){	
     wx.getLocation({
       success: function (res) {    	 
          longitude=res.longitude;
    	  latitude=res.latitude; 
    	  initLocation ();
        },
       cancel: function (res) {
         alert('用户拒绝授权获取地理位置');
       }
     });
   }
 
  //腾讯地图js
 var citylocation,map,marker = null; 
  //页面初始化 
 function init(){  	 
	 if('${hasLocation}'=='YES'){  //用户有上传地址，先采用后台地址		
		   latitude=${latitude};  
		   longitude=${longitude};		
		   initLocation ();
	   }else{ //用户无上传地址 ，使用 js sdk 获取 地址 		   
		   getLocation();  
	   }	
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
	        	$("#Present_address").empty(); //用户当前地址 	
	         	$("#Present_address").append("所在位置:"+result.detail.address);	        	
	        	 $('#select_area').val(result.detail.addressComponents.city);	        	
	        	 RefreshList(result.detail.addressComponents.city); 	        	
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
 //本页面js 
 //地区变化 需要从新加载 维修厂列表    
  function RefreshList(city){	
	  $("#repairPlatformList").empty(); //清空列表 	  
	  //divArray=new Array();
	  // 动态产生维修厂列表 ，并 加入 DIV 显示 
	  getRepairPlatformByArea(city);	
	} 
  //根据 地区 读取 维修厂商 列表 
 function getRepairPlatformByArea( city ){
	 var ManufacturersList=''; //动态厂商列表 
	 var divArray = new Array();
	 var encodecity=escape(encodeURIComponent(city)); //转码
	  var url="${webRoot}/fo/repairPlatformController.do?getRepairPlatformByArea&city="+encodecity; 	
     $.ajax({
		  type : 'GET',
		  url : url,
		  dataType : "json",
       success: function (json) {
     		if (json.success) { 
				var jsonnotreadedlist =json.attributes.weixinRepairPlatformList;
			    	quantum=jsonnotreadedlist.length;//本次共查询多少厂商 数量 
			    	 var start = new qq.maps.LatLng(latitude, longitude);			   	 			    	
					 $.each(jsonnotreadedlist, function (i, n) {
						 var end = new qq.maps.LatLng(n.latitude,n.longitude); 						 
						var dist_s_e= qq.maps.geometry.spherical.computeDistanceBetween(start,end); //两点之间的距离 
						   tempArray=new Array();
						   tempArray[0]=dist_s_e;
						   tempArray[1]=n;
						   divArray[i] =tempArray;
					  });
					 divArray.sort(function(x,y){return x[0]-y[0]});					
					 if(divArray.length!=0){
					 for (var i=0;i<divArray.length;i++)
					 {
						if(typeof(divArray[i][1])!='undefined'){
							ManufacturersList += getSingletonRepairPlatform(divArray[i][1].name,divArray[i][1].address,divArray[i][1].telephone,divArray[i][1].latitude,divArray[i][1].longitude,(divArray[i][0]/1000).toFixed(2));			    	
					    }
					 }
					 }else{
						 ManufacturersList="<li style='text-align:center;' >该区域暂时无维修平台数据</li>" 
					 }
					 $("#repairPlatformList").append("<ul class=\"am-list\" style=\"clear:both;\">"+ManufacturersList+" </ul>");
				}
       },
       error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
    	   $("#repairPlatformList").append("数据读取错误");     	   
       }
     });    
	}
   //进入地图页面
	function goToMapPage(latitude,longitude){	  
		window.open('${webRoot}/fo/repairPlatformController.do?method=goToMapPage&latitude='+latitude+'&longitude='+longitude);
	}
  // 组装 维修厂 html  
   function getSingletonRepairPlatform(name,address,telephone,latitude,longitude,Distance ){	 
	   var ManufacturersOne =
	  	    "<li>"
	  	      +"<table width=\"100%\" border=\"0\" style='line-height: 20px;'>"  
	  	      +" <tr>"
	  	         +"<td width=\"20%\">名称：</td>"  
	  	         +"<td width=\"50%\">"+name+"</td>" 
	  	         +"<td width=\"7%\" onclick='goToMapPage("+latitude+","+longitude+")' style='text-align: center;'><i class=\"am-icon-map-marker\"></i></td>"
	  	         +"<td width=\"23%\"> <span class=\"am-badge am-badge-success\">约"+Distance+"公里</span></td>" 
	  	         +"</tr>"
	  	         +"<tr>"
	  	         +"<td width=\"20%\">地址：</td>" 
	  	         +"<td width=\"50%\">"+address+"</td>" 
	  	         +"<td width=\"7%\"> </td>" 
	  	         +"<td width=\"23%\"> </td>" 
	  	         +"</tr>" 
	  	         +"<tr>"  
	  	         +"<td width=\"20%\">电话：</td>"
	  	          +"<td width=\"50%\">"+telephone+"</td>"
	  	        +"<td width=\"7%\"> </td>" 
	  	        +"<td width=\"23%\"> </td>" 
	  	        +" </tr>"
	  	      +"</table>"
	  	      +" </li>";
     return ManufacturersOne;     
   }
     
  //***************调试使用 ***********
     
   function codeLatLng() { 
	  //  var latLng = new qq.maps.LatLng(latitude, longitude);
	  var latLng = new qq.maps.LatLng(24.486968, 118.084002);	    
	    geocoder.getAddress(latLng);
	}
  
   function geolocation_latlng() {	 
	 var latLng = new qq.maps.LatLng(latitude, longitude);
	 var info = new qq.maps.InfoWindow({map: map});
	    geocoder.getAddress(latLng);
   }
     
   function alertlocation(){ 	
		  alert(latitude);	
		  alert(longitude);	
		    }
   
  //*************************

 
  
  
  
</script>

</html>
