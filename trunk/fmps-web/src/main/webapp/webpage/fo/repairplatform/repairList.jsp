<!doctype html>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>爱车之家</title>
<script charset="utf-8"
	src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style>
html, body, .page {
	height: 100%;
}

#wrapper {
	
	top: 25px;
	bottom: 0;
	margin: 0;
	width: 100%;
	background-color: #fff;
}

.am-list {
	margin: 0;
}

.am-list>li {
	background: none;
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8);
	padding: 10px 0px 10px 0px;
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

.am-btn-primary {
	color: #222;
	background-color: #fff;
	border-color: #fff;
}

.am-btn {
	font-size: 1.4rem;
	padding: 0.1em 0.1em;
}

.am-topbar {
	min-height: 50px;
}

header {
	height: 50px;
}

/* .fb_new_header {
	background: url(../plug-in/repair/head_bg.jpg) repeat-x scroll center;
	width: 100%;
	height: 25px;
	font-size: 13px;
	color: #FFFFFF;
	padding-left: 5px;
	line-height: 22px;
} */

.fb_dropbutton {
	width: 100%;
	height: 35px;
	margin-top: 5px;
	border-bottom: 1px solid #dedede;
}

.fb_dropbutton_left {
	width: 50%;
	height: 30px;
	float: left;
	border-right: 1px solid #dedede;
	font-size: 0.825em;
}

.fb_dropbutton_right {
	width: 50%;
	height: 30px;
	float: left;
	font-size: 0.825em;
}

.fb_Repair {
	padding: 0 15px;
	clear: both;
	height: auto;
	width: 100%;
}

.fb_Repair_table {
	width: 100%;
	border-bottom: 1px solid #dedede;
	height: 102px;
	float: left;
	padding-top: 18px;
	padding-bottom: 15px;
}

.fb_Repair_table_left {
	float: left;
	width: 35%;
}

.fb_Repair_table_right {
	float: left;
	width: 65%;
	margin-top: -5px;
}

.fb_Repair_table_right_text {
	font-size: 15px;
	font-family: "微软雅黑";
	color: #222222;
}

.fb_Repair_table_right_text_2 {
	font-size: 0.825em;
	font-family: "微软雅黑";
	color: #888; padding-bottom: 5px; padding-top: 5px; vertical-align:bottom;
}

.fb_Repair_table_right_text_3 {
	font-size: 0.825em;
	font-family: "微软雅黑";
	color: #888;
}

.am-topbar-fixed-bottom {
	border-width: 0px 0 0;
}
.img_top {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
}
.fb-dropbutton-select select {
   background: url(../plug-in/fo/images/downward.png) no-repeat 75% center;
   width: 100%;
   padding-left: 30%;
   height: 30px;
   -webkit-appearance: none; /*for chrome*/
  }
  
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
 <link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css"  >
</head>
<body  >
	<div class="page">		
	  <div> <a href="${webRoot}/plug-in/huodong/dobule11/index.html"> <img class="img_top" src="${webRoot}/plug-in/repair/eleven_index_img.jpg"> </a> </div>		
		<div id="wrapper" data-am-widget="list_news"
			class="am-list-news am-list-news-default">
			<!--flag==2表示为礼包的使用门店  -->
			<div class="fb_dropbutton"     <c:if test="${flag==2 }"> style="display:none;" </c:if>>
			
			<%-- <c:if test="${flag!=2 }">
			<div class="fb_dropbutton" >
			</c:if> --%>
				<div class="fb_dropbutton_left fb-dropbutton-select">
					<select  id="select_area" 
						onchange='RefreshList(this.value)'>
						<option value="请选择">所有地区</option>
						<c:forEach items="${cityList}" var="TSType" varStatus="status">
							<option value="${TSType.typecode}">${TSType.typename}</option>
						</c:forEach>
					</select>
				</div>
				<div class="fb_dropbutton_right fb-dropbutton-select">
					<select  id="orderby" 
						onchange='sort(this.value)'>
						
						<option value="distance">离我最近</option>						
						<option value="evaluation">好评优先</option>						
					</select>
				</div>

			</div>			
			
			 <div class="grid" ID="load"  >
               <div class="cell">
                  <div class="card"> <span class="spinner-loader">Loading&#8230;</span> 
                   <div style="clear:both;">正在加载</div>
                  </div>                  
               </div>
             </div>
			
			<div class="am-list-news-bd" id="repairPlatformList"></div>	
			<c:if test="${flag!=2 }">	
			<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
				<a onclick="goQRcodePage()">
					<div style="line-height: 50px;">获取保修二维码</div>
				</a>
			</header>
            </c:if>
		</div>
	</div>
	<div  style="display: none;"  >
  <input type="hidden" id="address" name="address" value="">  
  <div style="width:603px;height:300px" id="container"></div>
  </div>
</body>
<script> 
   //全局变量 
   var latitude=24.482166;   //用户当前经度
   var longitude=118.099313;  //用户当前纬度  
   var quantum=1;   //厂商数量   
   var paging=1 ;//初始分页 
   var isendpage=false ; //是否到达最后一页 
   var controlFlag=true; 
   //var progress = $.AMUI.progress;

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
	if("YES"=="${hasLbs}"){	 //如果后台有缓存 地理位置 就用 后台的 地理位置 	
		longitude= ${longitude} ;
  	    latitude= ${latitude}; 
	 }else{
		getLocation();  //使用 微信 获取地理位置 
	 }	
    initLocation(); //根据地理位置获取维修厂列表 	
	$(window).scroll(function () {
	        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
	        //$(window).height()获取当前窗体的高度
	        //$(document).height()获取当前文档的高度	        
	      var city=document.getElementById("select_area").value;	 
	      var order=document.getElementById("orderby").value;
	      var address=document.getElementById("address").value;	 	        
	      var bot = 20; //bot是底部距离的高度
	     // alert("ya");
	        if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {	 
	        	//alert("kao");
      	      if(!isendpage&&controlFlag){
      	    	controlFlag=false;  
	        	paging=paging+1;
	        	//alert("页"+paging);
	        	 getRepairPlatformByArea(city,order,address,paging);
	        	
	        	}
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
		        	$('#select_area').val(result.detail.addressComponents.city);
		        	/* //解决手机上看页面时会出现多选的bug
		        	$('#select_area').find('option[value="请选择"]').attr('selected', true);
		        	$('#select_area').find('option[value="请选择"]').attr('selected', false);
		        	$('#select_area').find('option[value="'+result.detail.addressComponents.city+'"]').attr('selected', true); */
		        	$('#address').val(result.detail.address);
		        	getRepairPlatformByArea(result.detail.addressComponents.city,"distance",result.detail.address,paging); 	  	        	
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
	   isendpage=false ;
	   paging=1;
	  $("#repairPlatformList").empty(); //清空列表 
	  var city=document.getElementById("select_area").value;
	  $('#address').val(city);
	  var order=document.getElementById("orderby").value;	
	  getRepairPlatformByArea(city,order,city,paging);	
	} 
 //排序变化从新加载列表
  function sort(by){
	   isendpage=false ;
	   paging=1;
		// alert("排序关键字："+by)
		 $("#repairPlatformList").empty(); //清空列表 
		 var city=document.getElementById("select_area").value;
		 var address=document.getElementById("address").value;
		 getRepairPlatformByArea(city,by,address,paging);	
	   }
 
  //根据 地区 读取 维修厂商 列表 
 function getRepairPlatformByArea( city,order,address,paging ){	
	  showdiv();
	 var citygift='${citygift}';
	 var ManufacturersList=''; //动态厂商列表 
	 var divArray = new Array();
	 var encodecity=escape(encodeURIComponent(city)); //转码
	 var encodeaddress=escape(encodeURIComponent(address)); //转码
	 var ecitygift=escape(encodeURIComponent(citygift)); //转码	 
	  var url="${webRoot}/fo/repairFactoryController.do?getRepairPlatformByArea&openid=${openid}&city="+encodecity+"&pageNo="+paging+"&order="+order+"&address="+encodeaddress+"&id=${giftset_detail_id}&citygift="+ecitygift+"&cardtype=${cardtype}"+"&latitude="+latitude+"&longitude="+longitude ; 	
     $.ajax({
		  type : 'GET',
		  url : url,
		  dataType : "json",
       success: function (json) {
     		if (json.success) {
     			// alert("12--");
     			 controlFlag=true;
				var jsonnotreadedlist =json.attributes.weixinRepairPlatformList;
			    	quantum=jsonnotreadedlist.length;//本次共查询多少厂商 数量 
			    	 var start = new qq.maps.LatLng(latitude, longitude);
			    	 var jsonRepairList = eval('(' + jsonnotreadedlist + ')'); 
					 $.each(jsonRepairList, function (i, n) {
						 //var end = new qq.maps.LatLng(n.latitude,n.longitude); 						 
						 //var dist_s_e= qq.maps.geometry.spherical.computeDistanceBetween(start,end); //两点之间的距离 
						   tempArray=new Array();
						  // tempArray[0]=dist_s_e;  距离改由企业号 提供 。 
						   tempArray[0]=0;
						   tempArray[1]=n;
						   divArray[i] =tempArray;
					  });
					 $("#rpArray").val(divArray);
					 //divArray.sort(function(x,y){return x[0]-y[0]});					
					 if(divArray.length!=0){
						 //alert("1--");
					 for (var i=0;i<divArray.length;i++)
					 {
						if(typeof(divArray[i][1])!='undefined'){
							//ManufacturersList += getSingletonRepairPlatform(divArray[i][1].name,divArray[i][1].address,divArray[i][1].telephone,divArray[i][1].latitude,divArray[i][1].longitude,(divArray[i][0]/1000).toFixed(2));
							ManufacturersList += getRepairPlatform(divArray[i][1].id,divArray[i][1].imgUrl,divArray[i][1].name,divArray[i][1].shortAddr,divArray[i][1].evaluation,divArray[i][1].evaluationTotal,divArray[i][1].distance,divArray[i][1].toBeEvaluated);
							
					    }
					 }
					 }else{
						// alert("2--"); 
						 ManufacturersList+="<li style='text-align:center;' >已经到达尾页了</li>" ;
						 ManufacturersList +="<div style=\"height:50px;clear: both;\">&nbsp;</div>";
						 isendpage=true;
					 }
					//ManufacturersList +="<div style=\"height:50px;clear: both;\">&nbsp;</div>";
					 $("#repairPlatformList").append(ManufacturersList);
					 hidediv();
				}
       },
       error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
    	   $("#repairPlatformList").append("数据读取错误");     	   
       }
     });    
	}
   //进入地图页面
	function goToMapPage(latitude,longitude){	  
		window.open('${webRoot}/fo/repairPlatformController.do?method=goToMapPage&openid=${openid}&latitude='+latitude+'&longitude='+longitude);
	}
  
	// 组装 维修厂 html  
   function getRepairPlatform(repairid,imageurl,name,address,eva,evanum,Distance,toBeEvaluated ){
		var tbe="";
		if(toBeEvaluated!=0){tbe="("+toBeEvaluated+")"}
		var nametbe=name+tbe;
		if(tbe==""){
			if(name.length>11){
				nametbe=name.substr(0,11)+"...";
			}else{
				nametbe=name;
			}
			
			
		}else{
			if(nametbe.length>11){
				nametbe=nametbe.substr(0,11)+"...";
			}else{
				nametbe=nametbe;
			}
		
		}
		
	   var ManufacturersOne =
	  	    "<div class=\"fb_Repair\" onclick=\"goRepairMain("+repairid+")\">"
	  	      +"<div class=\"fb_Repair_table\">"  
	  	      +"<div class=\"fb_Repair_table_left\"><img src=\""+imageurl+"\" width=\"90\" height=\"65\" style=\"border-radius:5px;\"/></div>"
	  	         +" <div class=\"fb_Repair_table_right\">"  
	  	         +"<div class=\"fb_Repair_table_right_text\">"+
	  	         
	  	         
	  	       nametbe+
	  	     
	  	         
	  	         
	  	         
	  	         "</div>" 
	  	         +"<div class=\"fb_Repair_table_right_text_2\"><img src=\"../plug-in/repair/star-"+eva+".png\" width=\"66\" height=\"12\"/> "+evanum+"条</div>"
	  	         +"<div class=\"fb_Repair_table_right_text_3\"><span style=\"text-align:left;\">"+address+"</span><span style=\"text-align:right; float:right;\"> <"+Distance+"km </span> </div>" 
	  	         +"</div>"
	  	         +"</div>"
	  	         +"</div>";
     return ManufacturersOne;     
   }
     
   function  goRepairMain(repairId){
	   location.href="${webRoot}/fo/repairFactoryController.do?method=repairMain&openid=${openid}&repairId="+repairId; 
   }
   
   function goQRcodePage(){	
		 var url = "${webRoot}/fo/repairFactoryController.do?method=QRcodePage&openid=${openid}";			
		location.href = url;	 
	   }
   
   function showdiv() { 
	     document.getElementById("load").style.display ="block";   
	  }
   function hidediv() {
	    document.getElementById("load").style.display ='none';   
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
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
