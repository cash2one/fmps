<!DOCTYPE html>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body, button, input, select, textarea {
	font: 12px/16px Verdana, Helvetica, Arial, sans-serif;
}

p {
	width: 603px;
	padding-top: 3px;
	overflow: hidden;
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
.am-header .am-header-title{
	margin: 0 10%;
}
</style>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>

</head>
<body onload="init()">
	<header data-am-widget="header" class="am-header am-header-default">
		<h1 class="am-header-title" style="color: #171717;">${repairname}服务网点</h1>
	</header>
	<div>
		<span style="height: 30px; display: none" id="city"></span>
	</div>
	<div style="width: 603px; height: 300px" id="container"></div>
	<p></p>
</body>
<script>
var geocoder,map, marker = null;
var init = function() {
    var center = new qq.maps.LatLng(24.490474,118.11022);
    map = new qq.maps.Map(document.getElementById('container'),{
        center: center,
        zoom: 13
    });
    var info = new qq.maps.InfoWindow({map: map});
    geocoder = new qq.maps.Geocoder({
        complete : function(result){
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
	var latLng = new qq.maps.LatLng(${latitude},${longitude});
    var info = new qq.maps.InfoWindow({map: map});
    geocoder.getAddress(latLng);
}

function CloseWebPage(){
	 if (navigator.userAgent.indexOf("MSIE") > 0) {
	  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
	   window.opener = null;
	   window.close();
	  } else {
	   window.open('', '_top');
	   window.top.close();
	  }
	 }
	 else if (navigator.userAgent.indexOf("Firefox") > 0) {
	  window.location.href = 'about:blank ';
	 } else {
	  window.opener = null;
	  window.open('', '_self', '');
	  window.close();
	 }
	 WeixinJSBridge.call('closeWindow'); 
	}
	
function goBack(){
	alert("history.back()");
	history.back();
	}
</script>
</html>
