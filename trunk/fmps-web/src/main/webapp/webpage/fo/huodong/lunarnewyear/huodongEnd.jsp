<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>抢保额</title>
  <meta name="description" content="结束活动页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" />  
</head>
<script type="text/javascript">
//跳转 老年骨折险购买页 
function  goPolicyList(){
	  location.href="${webRoot}/fo/binded/personalCenter/policyController.do?method=Index";  
   }

</script>
<body style=" background:url(${webRoot}/plug-in/huodong/lunarnewyear/images/spring_end.jpg) scroll top center repeat;  background-size:contain; height:100%;">
 <div class="end_img"><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/end_mammon.png" style="width:52%;" /></div>
 <c:if test="${hasPolicy=='YES'}">
   <div class="end_img_2"  onclick="goPolicyList()" ><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/end_button.jpg"  style="width:80%;"/></div>
 </c:if>
</body>
</html>
