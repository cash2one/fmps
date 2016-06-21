<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<head>
<meta charset="UTF-8">
<title>历史图片</title>
 
<style type="text/css">
.am-header-default {
  background-color: #fff;
}
.am-header {
  position: relative;
  width: 100%;
  height: 49px;
  line-height: 49px;
  padding: 0 10px;
  border-bottom:2px solid #0e90d2;
}
.am-checkbox {
  margin-top: 0px;
  }
  .am-header .am-header-nav img {
  height: 20px;
}
.am-header .am-header-title {
  margin: 0 1%;
}
.pic_text{ color:#171717; font-family:"微软雅黑"; font-size:12px; margin:0 auto; width:90%; border-bottom: 1px solid #e8e8e8; height:25px;}
.lipei_picture{ width:90%; margin:0 auto;}
.lipei_picture_1{ float:left; width:25%; padding-left:5px;}


#mcover {
	position:absolute; 
	top:5%; 
	left: 10%; 
/* 	 background: rgba(0, 0, 0, 0.8); */
	 display: none;
	 z-index: 20000; 
}
</style>

<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <div class=" am-header-nav" style="padding-top:15px;">
    <a href="#left-link" >
      <img src="${webRoot}/plug-in/totaiwan/img/pic_icon.jpg" width="20" height="22" alt="#"/>
    </a>
  </div>
  <h1 class="am-header-title" style=" color:#171717; ">
    历史图片
  </h1>
</header>
 
 <c:forEach items="${list}"	var="list"  varStatus="statuss">

  <c:if test="${statuss.index==0 }">
 <div style="height:20px;">&nbsp;</div>
  </c:if> 
 <div class="pic_text">于<fmt:formatDate value="${list.uploadtime}" type="both"/>上传${list.count}张图片</div> 


<div style="height:20px;">&nbsp;</div>

<div class="lipei_picture" >
<c:forEach items="${totaiwanClaimImageList}"	var="totaiwanClaimImage" varStatus="status" >
 
<%--  ${list.uploadtime==totaiwanClaimImage.uploadtime}  --%>
 <c:if test="${totaiwanClaimImage.uploadtime==list.uploadtime}"> 
	 <div class="lipei_picture_1" ><img onclick="button1(this)"  src="${webRoot}/fo/TotaiwanController.do?getStream&id=${totaiwanClaimImage.id}" width="63" height="63" />&nbsp;&nbsp;&nbsp;&nbsp;</div>
 </c:if> 
</c:forEach>
</div>
<div style="height:8px; clear:both;">&nbsp;</div>

</c:forEach>
<!-- <div id="mcover" onclick="weChat()" style="display: none;">
		<img style="" id="mcoverimg" src="" width="63" height="63" />
	</div> -->


<!-- <img class="imgAttr" id="imgShow" src="" alt=""/>  -->
<!-- <img class="clsImg" src="img1.jpg" alt=""/> 
<img class="clsImg" src="img2.jpg" alt=""/> 
<img class="clsImg" src="img3.jpg" alt=""/> 
<img class="clsImg" src="img4.jpg" alt=""/>  -->



<script type="text/javascript"> 

wx.config(${JSONString});
/* wx.ready(function () { */
//5.2 图片预览

 function button1(imgobj){
	// alert($(imgobj).attr("src"));
	 wx.previewImage({	   
		 current: $(imgobj).attr("src"),
		 urls: [
               $(imgobj).attr("src")
		    ]
		 }); 
 }

/* }); */


</script> 
</body>
</html>