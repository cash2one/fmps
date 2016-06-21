<!doctype html>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="/webpage/fo/common/fotags.jsp"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
  <title>爱车之家</title>

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
.evaluate_all{ padding:0 15px;}
.evaluate_all_title{ color:#e6e6e8; font-size:12px; border-bottom:1px solid #e8e8e8; height:25px; font-family:"微软雅黑"; clear:both;}
.evaluate_all_name{ width:100%; }
.evaluate_all_name_text{ width:80%; float:left; font-family:"微软雅黑"; font-size:14px; color:#292929; line-height:30px; padding-left:6px;}
.evaluate_all_name_button{ width:20%; float:left;}
.describe{ float:left; width:25%; font-size:14px; padding-left:6px;}
.describe_2{ float:left; width:75%; font-size:14px;}
.fb_Comment_text{  width:100%; padding-left:6px; font-size:14px; color:#292929;}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; font-size:16px;">
    我的评价
  </h1>
</header>
 <div style="height:15px;">&nbsp;</div>
 <div class="evaluate_all">
  <div class="evaluate_all_title">待评价</div>
   <div class="evaluate_all_name"> 
   
   
   

    <c:forEach items="${weixinRepairEvaluationnList}"	var="weixinRepairEvaluation" varStatus="status">

   <c:if test="${fn:length(weixinRepairEvaluationnList)!=status.index+1}" >
    <div style=" border-bottom:1px solid #e8e8e8; float:left; width:100%; padding-top:12px; clear:both;">
  </c:if>   
   <c:if test="${fn:length(weixinRepairEvaluationnList)==status.index+1}"  > 
    <div style="float:left; width:100%; padding-top:12px; clear:both;">
  </c:if>  
      <div class="evaluate_all_name_text">${weixinRepairEvaluation.repairname}</div>
      <div class="evaluate_all_name_button">
       <div   onclick="goEvaluationn('${weixinRepairEvaluation.repairid}','${weixinRepairEvaluation.repairname}')" style="background-color:#43abea; width:60px; height:30px; color:#fff; font-size:14px; border-radius:3px; padding:5px 0px 0px 15px;">评 价</div>
      </div>
     <div style=" float:left; width:100%; padding-bottom:20px;">
      <div class="describe">车牌号</div>    
      <div class="describe_2">${weixinRepairEvaluation.reportInfo.licenseNo}</div>
      <div class="describe">服务时间</div>  
      <div class="describe_2">${weixinRepairEvaluation.reportInfo.reportDate}${weixinRepairEvaluation.reportInfo.reportTime}</div>
      <div class="describe">处理事故</div>  
      <div class="describe_2">${weixinRepairEvaluation.reportInfo.remark}</div>
     </div>
    </div>

 </c:forEach>
   
   
   
   
   
   
    <div class="evaluate_all_title">评价记录</div>
    
    
    <c:forEach items="${weixinRepairEvaluationList}"	var="weixinRepairEvaluation" varStatus="status">
      <div class="fb_Comment_text" style=" border-bottom:1px solid #e8e8e8; float:left; width:100%; padding-top:10px; clear:both;">
       <div style=" padding-bottom:5px; padding-top:5px;">${weixinRepairEvaluation.repairname }</div>
       <div style=" padding-bottom:10px;"><img src="../../plug-in/repair/star-${weixinRepairEvaluation.evaluation }.png" width="66" height="12"/><span style="float:right; color:#979797; margin-top:-5px;"><fmt:formatDate value="${weixinRepairEvaluation.scanQrCodeTime }" type="both"/></span></div>
       <div style=" padding-bottom: 5px;">${weixinRepairEvaluation.comment }</div>
      </div>
     
     
    <!--  
     <div class="fb_Comment" style="width: 360px;">
      <div class="fb_Comment_img"></div>
      <div >
       <div style=" padding:3px;"></div>
       <div style=" padding:3px;"><img  width="66" height="12"/><span style="float:right; color:#333;"> </span></div>
       <div ></div>
      </div>
     </div> -->
     </c:forEach>
    
    
    
    
   
    
 
  </div> 
  
 </div>
</body>
<script>

function goEvaluationn(repairId,WeixinRepairName) {
	var WeixinRepairNameZ=escape(encodeURIComponent(WeixinRepairName)); //转码

		location.href = "${webRoot}/fo/repairFactoryController.do?method=evaluation&openid=${openid}&repairId="
			+ repairId + "&repairname="+WeixinRepairNameZ;
	
}

</script>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
