<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ResourceBundle"%>
<% 
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
ResourceBundle bundler = ResourceBundle.getBundle(configFileName);
String basePath = bundler.getString("domain");
String currentEnv = bundler.getString("currentEnv");
String userAgent = request.getHeader("user-agent");

System.out.println("userAgent==>" + userAgent);
%>
<c:set var="webRoot" value="<%=basePath%>" />
<!doctype html> 
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>富邦双11约惠五城百店</title>
<script> 
//全局变量 
var domain="http://mp.fubon.com.cn"; 
var APPID="wxeee8b84bc1946b90";
</script>
<link href="http://cdn.amazeui.org/amazeui/2.2.1/css/amazeui.min.css" rel="stylesheet" type="text/css" />
<link href="${webRoot}/plug-in/huodong/dobule11/css/eleven_index.css" rel="stylesheet" type="text/css" />
<style type="text/css">
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
<body style="background:#fd2752">
 <div class=" eleven_index_urban">
	<div class="am-dropdown areaDropdown" >
		      <button class="am-btn am-btn-default am-dropdown-toggle" data-am-dropdown-toggle ><span id="currentAreaName">请选择</span><span class="am-icon-caret-down"></span></button>
			  <ul class="am-dropdown-content" id="areaid">
<!-- 				<li><a href="javascript:void(0)" onClick="RefreshCoupon('siming','思明区');">思明区</a></li> -->
			  </ul>
	 </div>
 </div>
 <div class="eleven_coupon_center" id="main">
 	<c:forEach items="${moreGiftSet}" var="gift" varStatus="status">
 		<div class="eleven_coupon">
	      <div style="height:10px;" class="bodyWidth">&nbsp;</div>
	      <a href="#" class="giftset_class" giftset_id="${gift.giftSetId}">
	      	<div class="eleven_coupon_1 ">
			   <div class="eleven_coupon_left">${gift.giftSetName}</div>
			   <div class="eleven_coupon_right"><span class="viewCoupon">查 看</span></div>
			   <div class="eleven_coupon_bottom">${gift.repairName}</div>
		  	</div>
	      </a>
	   </div>
   	</c:forEach>
 </div>
 
 <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
	<div class="am-modal-dialog" style="border-top:5px solid #fff;background:#fff">
		<div class="am-modal-hd" style="color:#000">正在加载...</div>
		<div class="am-modal-bd">
			<span class="am-icon-spinner am-icon-spin"></span>
		</div>
	</div>
</div>
 <input type="hidden" id="countyCode_id" value="${countyCode}"/>
</body>

<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?3b62d4c2f2d2718cfcdca0a716aed32e";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script charset="utf-8"	src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script> 
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.amazeui.org/amazeui/2.4.2/js/amazeui.min.js"></script>
<script src="${webRoot}/plug-in/huodong/dobule11/js/echo.min.js"></script>
<link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css">
<script>
//区变化     
var bodyWidth =document.body.clientWidth-30;
$(".eleven_index_urban").css("width","100%");
$(".bodyWidth").css("width",bodyWidth);
$('.am-dropdown').dropdown({justify: '.bodyWidth'});

var currentAreaCode = "";
var currentAreaName = "";
var paging = 1;
var isendpage = false;
var controlFlag=true;
function RefreshCoupon(area,areaName){
	$(".eleven_coupon").hide();
	$("."+area).show();
	$(".areaDropdown").dropdown('toggle');
	$(".areaDropdown").find("button").html(areaName+'<span class="am-icon-caret-down"></span>');

	$("#main").empty();
	isendpage = false;
	loadAreaGift(area,"1");
}

function loadAreaGift(area,paging){
	$.ajax({
		url : "${webRoot}/fo/binded/repairFactoryGiftController.do?getmoreGiftSetByArea",
		data : {
			"countycode":area,
			"paging":paging
		},
		type : "POST",
		dataType: "json",
		beforeSend : function(){
			openmodel();
		},
		success : function(data) {
			var isnull = (null==data.obj.giftSetMoreList);
			controlFlag=true;
			if(!isnull){
				$.each(data.obj.giftSetMoreList,function(id,gift){
					$("#main").append('<div class="eleven_coupon">'
						 +'     <div style="height:10px;">&nbsp;</div>'
						 +'	  <div class="eleven_coupon_1 ">'
						 +'		<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid='+APPID+'&redirect_uri='+domain+'/fo/repairFactoryController.do?method=goToGiftSetDetail&response_type=code&scope=snsapi_base&state='+gift.giftSetId+'#wechat_redirect" class="gifts">'
						 +'		   <div class="eleven_coupon_left">'+gift.giftSetName+'</div>'
						 +'		   <div class="eleven_coupon_right"><span class="viewCoupon">查 看</span></div>'
						 +'	   	   <div class="eleven_coupon_bottom">'+gift.repairName+'</div>'
						 +'     </a>'
						 +'	  </div>'
						 +' </div>');
				});
			}else{
				isendpage = true;
				$("#main").append('<div style="text-align:center;color:#fff">已经到达尾页了</div>');
			}
			
			closemodel();
		},
		error : function(e) {
			closemodel();
			alert("网络有问题，请稍后再试");
		}
	});
}

function openmodel(){
	var $modal = $('#my-modal-loading');
	$modal.modal('open');
}
function closemodel(){
	var $modal = $('#my-modal-loading');
	$modal.modal('close');
}

$(function() {
	$(window).scroll(function () {
		if ($(window).scrollTop() >= ($(document).height() - $(window).height())) {
			if(!isendpage&&controlFlag){
      	    	controlFlag=false;  
				paging = paging + 1;
				loadAreaGift(currentAreaCode, paging);
			}
		}
	});
	
	currentAreaCode = $("#countyCode_id").val();
	var str = '${countyJson}';
	var json = eval('(' + str + ')');
 	currentAreaName = json[$("#countyCode_id").val()];
	$("#currentAreaName").text(currentAreaName);
 	
	$.each(json,function(id,area){
// 		console.info(id+"--"+area);
		$("#areaid").append('<li><a href="javascript:void(0)" onClick="RefreshCoupon(\''+id+'\',\''+area+'\');">'+area+'</a></li>');
	});
	$('.giftset_class').on("click",function(){
		var id = $(this).attr("giftset_id")
		var url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APPID+"&redirect_uri="+domain+"/fo/repairFactoryController.do?method=goToGiftSetDetail&response_type=code&scope=snsapi_base&state="+id+"#wechat_redirect";	 	
		
		location.href = url;
	});
	
	loadAreaGift(currentAreaCode, "1");
});

</script>
</html>
