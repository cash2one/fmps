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
  <%@ include file="/webpage/fo/common/new-fotags.jsp"%>   
  <link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/double_index.css" />    
  <script type="text/javascript" charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=heF6GLGBNGL8E1rA7749Gakp"></script>
  <link href="${webRoot}/plug-in/carHome/css/dropdown.min.css"	rel="stylesheet" />

 <style>
 .am-header-default {
  height:45px; background:#4fc6ee; color:#fff;
}
	 .grid {
  position: absolute; top:40%; left:34%;
  }
  @media (min-width: 375px){ .grid{left:35%;} }
  @media (min-width: 414px){ .grid{left:37%; top:42%;} }
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
  .item {
  background: #fff;
  text-align: center;
  vertical-align: middle;
  box-sizing: border-box;
}

.float {
  width: 100%;
  overflow: hidden;
}
.item {
  float: left;
  width: 33.3%;
  border-top: 1px solid #fff;
  border-right: 1px solid #e8e8e8;
  font-size: 0;
  margin-top: 10px; margin-bottom: 10px;
}
 .item:nth-child(1){
  border-right: 1px solid #e8e8e8;
}
 .item:nth-child(3) {
  border-right: 0px none;
}
 </style>

</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default"
		data-am-sticky>
		<div class="am-header-left am-header-nav fb-singleDropdown" > 
	        <a href="javascript:" > 
	          <span class="am-header-nav-title" id="currentCity">
					请选择
			  </span>
	        </a>
      	</div>
      	<div class="citySlide margin-header">  
          <ul class="">
          	<div style="width:95%;margin:auto;">
	             <li class="">
	               <a href="javascript:;" class="" code="350200">厦门</a>
	             </li>
	             <li class="">
	               <a href="javascript:;" class="" code="350100">福州</a>
	             </li>
	             <li class="">
	               <a href="javascript:;" class="" code="350600">漳州</a>
	             </li>
	             <li class="">
	               <a href="javascript:;" class="" code="350500">泉州</a>
	             </li>
	             <li class="">
	               <a href="javascript:;" class="" code="510100">成都</a>
	             </li>            
	             <li class="">
	               <a href="javascript:;" class="" code="500000">重庆</a>
	             </li>
	          </div>            
           </ul>
        </div>

		<div class="am-header-title ">
		<a href="#" onclick="goSearchPage()">
		   <div class="search">
             <div class="search_img"><img src="${webRoot}/plug-in/carHome/images/search_icon_2.jpg" /></div>
             <div class="search_input"><input name="" type="text" placeholder="请输入券、商家信息"/></div>
           </div>
        </a> 
		</div>
		<div class="am-header-right am-header-nav">
			<a
				href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=giftList&openid=${openid}"
				class=""> <span class="am-header-nav-title"> 礼包</span></a>
		</div>
	</header>	
	 
  
  <div class="Double_activity" id="serviceItem" >
   <div class="Double_activity_list_1">
     <a href="#" onclick="goCarWashPage()"><div class="li_1"><img src="${webRoot}/plug-in/carHome/images/icon_1.png" /><br /><span class="text">洗车专区</span></div></a>
     <a href="#" onclick="goMaintenancePage()"><div class="li_1"><img src="${webRoot}/plug-in/carHome/images/icon_2.png" /><br /><span class="text">维修保养</span></div></a>
     <a href="#" onclick="go4SPage()"><div class="li_1"><img src="${webRoot}/plug-in/carHome/images/icon_3.png" /><br /><span class="text">4S店</span></div></a>
     <a href="#" onclick="goRoadRescuePage()"><div class="li_1"><img src="${webRoot}/plug-in/carHome/images/icon_4.png" /><br /><span class="text">道路救援</span></div></a>
   </div>
      
   <div class="Double_activity_list_2">
     <a href="#" onclick="goGasolineGiftPage()" ><div class="li_2"><img src="${webRoot}/plug-in/carHome/images/icon_5.png" /><br /><span class="text">加油95折</span></div></a>
     <a href="#" onclick="goDrivePage()"><div class="li_2"><img src="${webRoot}/plug-in/carHome/images/icon_6.png" /><br /><span class="text">代驾</span></div></a>
     <a href="#" onclick="goIllegalDisposalPage()"><div class="li_2"><img src="${webRoot}/plug-in/carHome/images/icon_7.png" /><br /><span class="text">违章处理</span></div></a>
     <a href="#" onclick="goOtherServicesPage()"><div class="li_2"><img src="${webRoot}/plug-in/carHome/images/icon_8.png" /><br /><span class="text">其他服务</span></div></a>
   </div>
  </div>  
  <div class="Double_activity_xian">&nbsp;</div>  
  
  <div id="advertisement" class=" float"  style="display:none"   >
   <div class="item"><a href="#"><img src=" "  /></a></div>
   <div class="item"><a href="#"><img src=" "  /></a></div>
   <div class="item"><a href="#"><img src=" "  /></a></div>
  </div>   

  <div class="Double_activity_xian">&nbsp;</div> 
  
  <div id="recommendList"  style="display:none"   >
  <div class="Double_activity_ad">
      <a href="#"> <div class="ad_1"><img src="${webRoot}/plug-in/carHome/images/AD_2.jpg" /></div></a>
      <a href="#"> <div class="ad_2"><img src="${webRoot}/plug-in/carHome/images/AD_1.jpg" /></div></a>
  </div>
  <div class="Double_activity_ad_1">
      <a href="#"><div class="ad_1"><img src="${webRoot}/plug-in/carHome/images/AD_2.jpg" /></div></a>
      <a href="#"><div class="ad_2"><img src="${webRoot}/plug-in/carHome/images/AD_1.jpg" /></div></a>
  </div>
  </div>
  
  <div class="Double_activity_xian"  style="display:none" >&nbsp;</div>  
  <div class="Double_activity_recommend"   id="merchantList" style="display:none" >
   <div class="recommend_text">★推荐商户</div>
       <%@ include file="merchant.jsp"  %>
  </div>
    <div style="width:603px;height:300px display:none  " id="container"  ></div>
    <input type="hidden" id="address" name="address" value=""> 
    <input type="hidden" id="cityCode" name="cityCode" value=""> 
</body>

<script type="text/javascript"	src="${webRoot}/plug-in/carHome/js/dropdown.js"></script>  

<script  type="text/javascript"  >

  var address="厦门市湖里区东港北路";//用户当前地址 
  var cityCode="350200";  //用户当前城市代码 
  var cityName="厦门市";
  var latitude=24.482166;   //用户当前经度
  var longitude=118.099313;  //用户当前纬度  
  var citylocation,map,marker = null; //腾讯地图js
  
  
   $(function(){ 	   
	   init(); 	   
	   $('.fb-singleDropdown').dropdown('selectedCity');
	   setTimeout("closemodel()",15000);
	});
  
   function init(){	
	   // openmodel();
	   //showdiv();
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
				  initLocation(); 
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
          fail:function (res){
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
	 if(typeof(qq)!="undefined"){
 	 var center = new qq.maps.LatLng(latitude,longitude);
 	    map = new qq.maps.Map(document.getElementById('container'),{
 	        center: center,
 	        zoom: 13
 	    });
 	    var info = new qq.maps.InfoWindow({map: map});
 	    geocoder = new qq.maps.Geocoder({
 	    	 complete : function(result){
 		        	var city=result.detail.addressComponents.city;  		        
 		        	 $(".citySlide a").each(function(){		   
 		    		    cityName=$(this).text()+'市'; 		    		  
 		    		    if(cityName==city){
 		    		    	cityCode = $(this).attr("code");
 		    		    	cityName=$(this).text();
 		    		    	$('#currentCity').text(cityName); //定位到了，修改"请选择"为具体城市名 		    		    	 
 		    		      }
 		    		     });      	 
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
	  } else {		  
		  $('#currentCity').text(cityName);
		  getMerchant(); //异步请求数据    
	  }
	  
	  }
  
 //城市改变了从新设置 address 与 cityCode 
   $(".citySlide a").on("click",function(){	     
	       cityCode = $(this).attr("code");
		   address=$(this).text()+'市'; //		 
	       $('#address').val(address); 		        	
	       $('#cityCode').val(cityCode);	  
	       getMerchant();//城市切换 从新请求数据 
	});
 
  //根据 地址 城市 获取首页信息 
 function getMerchant(){
	// showdiv();
	 chonqing(cityCode); //根据成功显示 服务项目  
	 $('#advertisement').hide(); //广告区 隐藏 
     $('#recommendList').hide(); //精品券区隐藏
     $("#repairList").empty(); //清空列表
	 getadvertisementList(); //获取广告 
	 getrecommendList() ;   //获取精品 
	 getrecommendRepairList();//获取精品商家 
	 showPage();
	// hidediv();
	 }
  
  
    //获取 广告信息  
  function getadvertisementList(){	 
	  var url="${webRoot}/fo/carHomeController.do?getadvertisementList&openid=${openid}&cityCode="+cityCode+"&latitude="+latitude+"&longitude="+longitude; 	
	  $.ajax({
		  type : 'GET',
		  url : url,
		  timeout : 10000, //超时时间设置，单位毫秒
		  dataType : "json",
	      success: function (json) {
	      var json = eval('('+json+')');  
	      var isnull = (0==json.advertisementList.length);
	      if(!isnull){
	    	var advertisementList=json.advertisementList;
	    	if(advertisementList.length!=0){
	    	 getAdvertisement(advertisementList);
	    	 $('#advertisement').show(); //广告区 
	    	 }
	         }else{
	    		alert("获取数据为空 " +json.msg);	    		
	    	  }
	     // closemodel();
	     //hidediv();
	       },
	      error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
	    	 // alert("获取数据失败a"+errorThrown);	    	
	       }
	     }); 
    }
  
    //获取精品信息  
  function getrecommendList(){	
	  var url="${webRoot}/fo/carHomeController.do?getrecommendList&openid=${openid}&cityCode="+cityCode+"&latitude="+latitude+"&longitude="+longitude; 	
	  $.ajax({
		  type : 'GET',
		  timeout : 10000, //超时时间设置，单位毫秒
		  url : url,
		  dataType : "json",
	      success: function (json) {
	      var json = eval('('+json+')');  
		  var isnull = (0==json.recommendList.length);		  
	      if(!isnull){	    		     
	        var recommendList=json.recommendList;
	        if(recommendList.length!=0 ){
	        replaceRecommendUrl(recommendList );
	        $('#recommendList').show(); //精品券区
	         }
	       }else{
	    		alert("获取数据为空" +json.msg);	    	
	    	  }
	     // closemodel();
	     //hidediv();
	       },
	      error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
	    	// alert("获取数据失败b"+errorThrown);	    	
	       }
	     }); 
	 
    }
  
  //获取商家信息  
 function getrecommendRepairList(){	
	var encodeaddress=escape(encodeURIComponent(address)); //转码
	  var url="${webRoot}/fo/carHomeController.do?getrecommendRepairList&openid=${openid}&cityCode="+cityCode+"&address="+encodeaddress+"&latitude="+latitude+"&longitude="+longitude; 	
	  $.ajax({
		  type : 'GET',
		  timeout : 13000, //超时时间设置，单位毫秒
		  url : url,
		  dataType : "json",
	      success: function (json) {
	    	  var json = eval('('+json+')');  
			  var isnull = (0==json.repairList.length);
	      if(!isnull){
	    	var repairList=json.repairList;	 
	    	if(repairList.length!=0){
	    	getRepairList (repairList);
	    	 $('#merchantList').show(); //精品商家 区 
	    	}
	    	 //hidediv();  //关闭加载状态 
	        }else{
	    		alert("获取数据为空" +json.msg);	    		
	    	  }
	     // closemodel();
	     //hidediv();
	       },
	      error: function (XMLHttpRequest, textStatus, errorThrown) {     	   
	    	// alert("获取数据失败c"+errorThrown); 	    	 
	       }
	     }); 
    }
  
   function  testalert(){
	   cityCode=document.getElementById("select_area").value; 
	   address=document.getElementById("address").value; 
	   alert(cityCode);
	   alert(address);
    }
   
   
   
    //替换精品图片及连接 
   function replaceRecommendUrl( recommendList  ){     	
      var imgList=	$('#recommendList').find('img'); 
      var aList=	$('#recommendList').find('a');
      var recommendUrl="${webRoot}/fo/carHomeController.do?method=getMerchandiseRecommend";
     $.each(recommendList, function (i, n) {
    	 imgList[i].src=n.imgPath;    	 
    	 aList[i].href=recommendUrl+"&openid=${openid}&type="+n.type+"&merchandiseId="+n.merchandiseId;
  	   });
    }
  
  //活动滚动图片修改     
   //活动滚动图片修改     
 //var $slider = $('#advertisement');
 var counter = 0;  
 function getAdvertisement(advertisementList){
	 var imgList=	$('#advertisement').find('img'); 
     var aList=	$('#advertisement').find('a');    
    $.each(advertisementList, function (i, n) {
   	 imgList[i].src=n.imgPath;    	 
   	 aList[i].href=n.activityUrl;
 	   }); 
 }
  
  function  getSlide(advertisement)   {
     return "<li><a href=\""+advertisement.activityUrl +"\" class=\"#\"><img src=\""+advertisement.imgPath+"\"/></a></li>" ;
    }
  
  function showPage(){	 
	  $('.Double_activity_xian').show(); // 分隔符 
	  $('.Double_activity_xian_bottom').show(); // 分隔符 
    }
  
/*   function showdiv() { 
	     document.getElementById("load").style.display ="block";
	     $('#load').show();  //开启 加载框 
	  }
  function hidediv() {
	    document.getElementById("load").style.display ='none';
	    $('#load').hide();  //隐藏 加载框 
	 } */
  //跳转到维修厂主页
  function  goRepairMain(repairId){
	   location.href="${webRoot}/fo/carHomeController.do?method=MerchantMain&openid=${openid}&repairId="+repairId; 
   } 
    //跳转到搜索页 
 function  goSearchPage( ){
	   location.href="${webRoot}/fo/carHomeController.do?method=carHomeSearch&openid=${openid}&citycode="+cityCode+"&address="+escape(encodeURIComponent(address)); 
    }  
  //跳转到洗车页 
 function  goCarWashPage( ){
	   location.href="${webRoot}/fo/carWashController.do?carWashIndex&openid=${openid}&citycode="+cityCode+"&address="+escape(encodeURIComponent(address)); 
 }
 //跳转到维修保养页 
 function  goMaintenancePage( ){
	   location.href="${webRoot}/fo/carHomeController.do?method=toCarHomeRepairFactory&openid=${openid}&citycode="+cityCode+"&address="+escape(encodeURIComponent(address)); 
 }
 //跳转到4s页 
 function  go4SPage( ){
	   location.href="${webRoot}/fo/carHomeController.do?method=toCarHome4sFactory&openid=${openid}&citycode="+cityCode+"&address="+escape(encodeURIComponent(address)); 
 }
 //跳转到道路救援 页 
 function  goRoadRescuePage( ){
	   location.href="${webRoot}/plug-in/carHome/rescue.html"; 
 }
   //跳转到加油宝 页 
 function  goGasolineGiftPage( ){
	   location.href="${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?getTheHomePage&openid=${openid}&cityCode="+cityCode; 
 }
 //跳转到代驾 页 
 function  goDrivePage( ){
	   location.href="${webRoot}/fo/drivingGifeController.do?initDrivingGift&openid=${openid}&huodongid=8a828ed551604e390151605400f30001";
	   }
 //跳转到违章处理  页 
 function  goIllegalDisposalPage( ){
	 //user_id用weixin_gzuserinfo.id 32位以内的唯一值
	   location.href="http://wap.cx580.com/illegal?user_id=${weixin_gzuserinfo_id}&user_from=${user_from}&token=${token}"; 
 }
 //跳转到其他服务  页 
 function  goOtherServicesPage( ){
	//   location.href="${webRoot}/plug-in/carHome/other.html"; 
	 location.href="${webRoot}/fo/carHomeController.do?method=toCarHomeOtherServices&openid=${openid}&citycode="+cityCode+"&address="+escape(encodeURIComponent(address)); 
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
  
  

 
 function loadmerchantList(){   }
	  
  
 function chonqing(cityCode){
	 $("#serviceItem").empty(); //清空服务列表 
	 var serviceHtml="" ;
	 if(cityCode=='500000'){
  serviceHtml="   "
	       +"   <div class=\"Double_activity_list_1\"> "
	       +"     <a href=\"#\" onclick=\"goCarWashPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_1.png\" /><span class=\"sup\">HOT</span><br /><span class=\"text\">洗车专区</span></div></a> "
	       +"     <a href=\"#\" onclick=\"goMaintenancePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_2.png\" /><br /><span class=\"text\">维修保养</span></div></a> "
	       +"     <a href=\"#\" onclick=\"go4SPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_3.png\" /><br /><span class=\"text\">4S店</span></div></a> "
	       +"     <a href=\"#\" onclick=\"goDrivePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_6.png\" /><br /><span class=\"text\">代驾</span></div></a> "
	       +"   </div> "	      
	       +"   <div class=\"Double_activity_list_2\"> "	       
           +"     <a href=\"#\" onclick=\"goIllegalDisposalPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_7.png\" /><br /><span class=\"text\">违章处理</span></div></a> "
           +"     <a href=\"#\" onclick=\"goOtherServicesPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_8.png\" /><br /><span class=\"text\">其他服务</span></div></a> "
	       +"   </div> "
	       +"   ";
	  }else if(cityCode=='510100'){
   serviceHtml=" "
             +" <div class=\"Double_activity_list_1\"> "
             +"<a href=\"#\" onclick=\"goCarWashPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_1.png\" /><span class=\"sup\">HOT</span><br /><span class=\"text\">洗车专区</span></div></a>"
             +"<a href=\"#\" onclick=\"goMaintenancePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_2.png\" /><br /><span class=\"text\">维修保养</span></div></a>"
             +"<a href=\"#\" onclick=\"go4SPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_3.png\" /><br /><span class=\"text\">4S店</span></div></a>"
             +"<a href=\"#\" onclick=\"goRoadRescuePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_4.png\" /><br /><span class=\"text\">道路救援</span></div></a>"
             +" </div>"	      
             +"<div class=\"Double_activity_list_2\">"  
             +" <a href=\"#\" onclick=\"goGasolineGiftPage()\" ><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_5.png\" /><span class=\"sup\">NEW</span><br /><span class=\"text\">加油98折</span></div></a>"
             +" <a href=\"#\" onclick=\"goDrivePage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_6.png\" /><br /><span class=\"text\">代驾</span></div></a>"
             +"<a href=\"#\" onclick=\"goIllegalDisposalPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_7.png\" /><br /><span class=\"text\">违章处理</span></div></a>"
             +" <a href=\"#\" onclick=\"goOtherServicesPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_8.png\" /><br /><span class=\"text\">其他服务</span></div></a>"
             +" </div>"
             +"  "; 
	   }else {		 
   serviceHtml=" "
             +" <div class=\"Double_activity_list_1\"> "
             +"<a href=\"#\" onclick=\"goCarWashPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_1.png\" /><span class=\"sup\">HOT</span><br /><span class=\"text\">洗车专区</span></div></a>"
             +"<a href=\"#\" onclick=\"goMaintenancePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_2.png\" /><br /><span class=\"text\">维修保养</span></div></a>"
             +"<a href=\"#\" onclick=\"go4SPage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_3.png\" /><br /><span class=\"text\">4S店</span></div></a>"
             +"<a href=\"#\" onclick=\"goRoadRescuePage()\"><div class=\"li_1\"><img src=\"${webRoot}/plug-in/carHome/images/icon_4.png\" /><br /><span class=\"text\">道路救援</span></div></a>"
             +" </div>"	      
             +"<div class=\"Double_activity_list_2\">"
             +" <a href=\"#\" onclick=\"goGasolineGiftPage()\" ><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_5.png\" /><span class=\"sup\">NEW</span><br /><span class=\"text\">加油95折</span></div></a>"
             +" <a href=\"#\" onclick=\"goDrivePage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_6.png\" /><br /><span class=\"text\">代驾</span></div></a>"
             +"<a href=\"#\" onclick=\"goIllegalDisposalPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_7.png\" /><br /><span class=\"text\">违章处理</span></div></a>"
             +" <a href=\"#\" onclick=\"goOtherServicesPage()\"><div class=\"li_2\"><img src=\"${webRoot}/plug-in/carHome/images/icon_8.png\" /><br /><span class=\"text\">其他服务</span></div></a>"
             +" </div>"
             +"  ";
	     }
	  $("#serviceItem").append(serviceHtml); 	 
 }
 
 function openmodel(){
		var $modal = $('#my-modal-loading');
		$modal.modal('open');
	}
	function closemodel(){
		var $modal = $('#my-modal-loading');
		$modal.modal('close');
	}
 
 
 
</script>
</html>