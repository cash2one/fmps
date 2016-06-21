<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<meta name="format-detection" content="telephone=no">
  <style>
    html,
    body,
    .page {
      height: 100%;
    }

    #wrapper {
      position: absolute;
      top: 49px;
      bottom: 0;
      overflow: hidden;
      margin: 0;
      width: 100%;
      padding: 0 8px;
      background-color: #f8f8f8;
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
  </style>
</head>

<body>
  <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title" style="color: #171717;">
     	 服务网点
    </h1>
  </header>
  <div class="fb_fuwu" style="font-size: 1.125Em;">
     
   	<c:forEach items="${serviceNetWorksMap}" var="serviceNetWorkArea">
	    <div class="fb_city"><a href="#" style="color:#000000;" onclick="showDiv(${serviceNetWorkArea.key},this.id);" id="${serviceNetWorkArea.key}_id">${serviceNetWorkArea.key}</a></div>
    </c:forEach>
    
  </div>
  
  <c:forEach items="${serviceNetWorksMap}" var="serviceNetWorkArea">
	  <div class="fb_add" id="${serviceNetWorkArea.key}" style="display: none;">
		
		<c:forEach items="${serviceNetWorkArea.value}" var="serviceNetWork">
	
	      <div class="am-accordion-content" style="font-size: 1.125Em;">
	       <div>${serviceNetWork.networkname }</div> 
	       <div>电话：${serviceNetWork.phonenumber }</div>
	       <div>地址：${serviceNetWork.address }</div>
	      </div>
	          
		</c:forEach>
		
	  </div> <!-- fb_add -->
  </c:forEach>
</body>
<script>
$(document).ready(function(){
	initShow();
});

function initShow(){
	$(".fb_add").first().attr('style','display:;');
	$(".fb_city a").first().attr('style','color:#0e90d2;');
}
function showDiv(area,id){
	$(".fb_add").attr('style','display:none;');
	$(area).attr('style','display:;');
	$(".fb_city a").attr('style','color:#000000;');
	document.getElementById(id).style.color="#0e90d2";
}
</script>
</html>
