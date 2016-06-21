<!doctype html>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>爱车之家</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<script charset="utf-8"
	src="http://map.qq.com/api/js?v=2.exp&libraries=drawing,geometry,autocomplete,convertor"></script>


 <style>
    html,
    body,
    .page {
      height: 100%;
    }
    #wrapper {
      position:relative;

      bottom: 0;
  
      margin: 0;
      width: 100%;
      background-color: #fff;
    }

    .am-list {
      margin: 0;
    }

    .am-list > li {
      background: none;
      box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8); padding:10px 0px 10px 0px;
    }
	header {
		height: 50px;
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
  min-height: 50px;}
.am-header .am-header-title {
  margin:0 15%
  ;}
  .am-slider-default .am-direction-nav a {

  opacity: .0;
  display: none;

}
  .fb_Repair{ padding:0 15px; clear:both; height:auto; width:100%; }
  .fb_Repair_1{  clear:both; height:auto; width:90%; margin: 0 auto; }
  .fb_Repair_table_right_text_2{ font-size:0.825em; font-family:"微软雅黑"; color:#888; border-bottom:1px solid #dedede; height:35px; padding-left:15px; padding-top:5px;}
  .fb_Comment{ padding:15px 15px; clear:both; height:auto; width:100%; border-bottom:1px solid #dedede; float:left;}
  .fb_Comment_img{
-webkit-border-radius:50px;
-moz-border-radius:50px;
-o-border-radius:50px;
border-radius:50px; 
background:url(images/futai_index_pro.jpg) scroll center no-repeat; 
height:50px; 
width:50px;
float:left;
}
.fb_Comment_text{ float:left; width:80%; padding-left:10px; font-size:0.825em; color:#222222;}
.fb_Repair_left{ width: 10%; float: left; padding-top: 10px; padding-bottom: 10px;}
.fb_Repair_middle{ width: 85%; float: left; text-align: left; font-size: 15px; color: #222222; padding-top: 10px; padding-bottom: 10px;}
.fb_Repair_middle_1{ width: 100%; float: left; text-align: left; font-size: 15px; color: #222222; padding-top: 10px; padding-bottom: 10px;}
.fb_Repair_middle_2{ width: 100%; float: left; text-align: left; font-size: 14px; color: #222; padding-top: 8px; padding-bottom: 8px; margin: 0 auto;}
.fb_Repair_right{ width: 5%; float: left; padding-top: 10px; padding-bottom: 10px;}
.fb_text_right{padding-top: 10px; padding-bottom: 10px;}
  </style>

</head>
<body>
	<div class="page">
		<header data-am-widget="header" class="am-header am-header-default">
			<h1 class="am-header-title" style="font-size: 1em;">
				<a href="#title-link" class="">${WeixinRepair.name}</a>
			</h1>
			<div class="am-header-right am-header-nav"></div>
		</header>

		<div data-am-widget="slider" class="am-slider am-slider-default" data-am-slider='{}'>

  
		    <ul class="am-slides" >
						<c:forEach items="${repairImageList}" var="WeixinRepairImageUrl"
							varStatus="status">
							 <li style="height: 200px;"><a href="${WeixinRepairImageUrl.imgUrl }"><img style="height: 200px;" src="${WeixinRepairImageUrl.imgUrl }"></a></li> 
					
				<!-- 	<li style="height: 200px;"><a href="http://guojunjie.pagekite.me:8080/fmps/plug-in/fo/images/tt.jpg"><img style="height: 200px;" src="http://guojunjie.pagekite.me:8080/fmps/plug-in/fo/images/tt.jpg"></a></li>
					 -->
					
					
						</c:forEach>
			</ul>
  
       </div>
		
		
		
		
		
		
		
		
		
		    <div id="wrapper" data-am-widget="list_news" class="am-list-news am-list-news-default">
     <div class="fb_Repair_table_right_text_2"><img src="../plug-in/repair/star-${WeixinRepair.evaluation}.png" width="66" height="12"/> ${WeixinRepair.evaluationTotal}条</div>

 <!--维修厂头部-->
<%--   <div class="fb_Repair">
    <div style="padding-top:15px; padding-bottom:15px; font-size:0.825em; border-bottom:1px solid #dedede; font-family:'微软雅黑'; font-weight:700; color:#4b4b4b;"  onclick="goToMapPage('${WeixinRepair.latitude}','${WeixinRepair.longitude}')"><span class="am-icon-map-marker am-icon-sm"></span>&nbsp;&nbsp;&nbsp;${WeixinRepair.address}<span class="am-icon-angle-right am-icon-md" style="float:right;"></span></div>
    
    <div style="padding-top:15px; padding-bottom:15px; font-size:0.825em; font-family:'微软雅黑'; font-weight:700; color:#4b4b4b;"><span class="am-icon-phone am-icon-sm"></span>&nbsp;&nbsp;${WeixinRepair.telephone}<span class="am-icon-angle-right am-icon-md" style="float:right;"></span></div>
    
     </div> --%>
     
     
     
      <div class="fb_Repair" onclick="goToMapPage('${WeixinRepair.latitude}','${WeixinRepair.longitude}')"  >
  
       <div class="fb_Repair_left" ><span class="am-icon-map-marker am-icon-sm"></span></div>
       <div class="fb_Repair_middle">${WeixinRepair.address}</div>
       <div class="fb_Repair_right"><span class="am-icon-angle-right am-icon-sm" style="float:right;"></span></div>
       
     </div>
       <div class="fb_Repair" style="clear: both; border-top: 1px solid #dedede; ">
  
       <div class="fb_Repair_left" ><span class="am-icon-phone am-icon-sm"></span></div>
       <div class="fb_Repair_middle"><a href="tel:${WeixinRepair.telephone}">${WeixinRepair.telephone}</a></div>
       <div class="fb_Repair_right"><span class="am-icon-angle-right am-icon-sm" style="float:right;"></span></div>
       
     </div>
     <div style="height:20px; background-color:#f0f0f0; border-top: 1px solid #dedede;  clear: both;" >&nbsp;</div>
     <!-- 礼包 -->
     <div class="fb_Repair" style="clear: both; border-top: 1px solid #dedede; ">
       <div class="fb_Repair_middle_1"><span class="am-icon-gift am-icon-sm"></span> &nbsp;礼包</div>
     </div>
     <div id="giftsetListId">
     	<c:forEach items="${giftSetList}" var="giftSet" varStatus="status">
     		<div class="fb_Repair_1" style="clear: both; border-top: 1px solid #dedede; display:none" onclick="goToGiftSetDetail('${giftSet.id}')">
     			<div class="fb_Repair_middle_2" >${giftSet.name}</div>
     		</div>
     	</c:forEach>
     </div>
     

     
     
     
     
     <div style="height:20px; background-color:#f0f0f0; border-bottom: 1px solid #dedede; border-top: 1px solid #dedede; clear: both;" >&nbsp;</div>
     <div style="padding-top:10px; padding-bottom:10px; font-size:0.825em; border-bottom:1px solid #dedede; padding-left:10px; " onclick="goHistoricalEvaluation('${WeixinRepair.id}')">&nbsp;&nbsp;网友点评(${evaluationcount })<span class="am-icon-angle-right am-icon-md" style="float:right; padding-right:15px;"></span></div>
     <c:if test="${evaluationList== null || fn:length(evaluationList) == 0}">
     	<div style="height: 50px;  clear: both;">&nbsp;</div>
 	 </c:if>
     <!--评论人物-->
     <c:forEach items="${evaluationList}" var="WeixinEvaluation"
				varStatus="status">
     <div class="fb_Comment">
      <div class="fb_Comment_img"></div>
      <div class="fb_Comment_text">
       <div style=" padding:1px;">${WeixinEvaluation.nickname }</div>
       <div style=" padding:1px;"><img src="../plug-in/repair/star-${WeixinEvaluation.evaluation }.png" width="66" height="12"/><span style="float:right; color:#333;"><fmt:formatDate
									value='${WeixinEvaluation.insertTime }' pattern="MM-dd HH:mm" /></span></div>
       <div style=" padding:1px;">${WeixinEvaluation.comment }</div>
      </div>
     </div>
     </c:forEach>
  
    </div>
		
		
		
		
		

		<%-- <div id="wrapper" data-am-widget="list_news"
			class="am-list-news am-list-news-default">
			<div class="fb_Repair_table_right_text_2">
				<img src="../plug-in/repair/star-${WeixinRepair.evaluation}.png"
					width="66" height="12" /> ${WeixinRepair.evaluationTotal}条
			</div>

			<!--维修厂头部-->
			<div class="fb_Repair">
			   <div style="font-size: 0.825em;">
				<div style="padding-top: 10px; padding-bottom: 10px;  float: left; width: 93%;" onclick="goToMapPage('${WeixinRepair.latitude}','${WeixinRepair.longitude}')"><span class="am-icon-map-marker"></span>&nbsp;&nbsp;${WeixinRepair.address}</div>
				<div style="float: right; width: 5%; padding-top: 10px; padding-left: 8px;"><img src="${webRoot}/plug-in/fo/images/right2.png"
					width="6" height="13" /></div>
			   </div>
				
				
				<div
					style="padding-top: 10px; padding-bottom: 10px; font-size: 0.825em; clear: both; border-top: solid 1px #dedede; border-bottom: 1px solid #dedede;">
					<span class="am-icon-phone"></span>&nbsp;&nbsp;${WeixinRepair.telephone}<span
						 style="float: right;"><img src="${webRoot}/plug-in/fo/images/right2.png"
					width="6" height="13" /></span>
				</div>

			</div>
			<div onclick="goHistoricalEvaluation('${WeixinRepair.id}')"
				style="padding-top: 10px; padding-bottom: 10px; font-size: 0.825em; border-bottom: 1px solid #dedede; padding-left: 10px;">
				&nbsp;&nbsp;点评<span style="float: right; padding-right: 15px;"><img src="${webRoot}/plug-in/fo/images/right2.png"
					width="6" height="13" /></span>
			</div>
			<!--评论人物-->
			<c:forEach items="${evaluationList}" var="WeixinEvaluation"
				varStatus="status">
				<div class="fb_Comment">
					<div class="fb_Comment_img">
						<img alt="" src="${WeixinEvaluation.headimgurl }"
							style="border-radius: 50px; width: 50px; height: 50px;">
					</div>
					<div class="fb_Comment_text">
						<div style="padding: 1px;">${WeixinEvaluation.nickname }</div>
						<div style="padding: 1px;">
							<img
								src="../plug-in/repair/star-${WeixinEvaluation.evaluation }.png"
								width="66" height="12" /><span
								style="float: right; color: #333;"><fmt:formatDate
									value='${WeixinEvaluation.insertTime }' pattern="MM-dd HH:mm" /></span>
						</div>
						<div style="padding: 1px;">${WeixinEvaluation.comment }</div>
					</div>
				</div>
			</c:forEach>
		</div> --%>
		
		
		
		
		
		
		
		


	</div>
	<div style="height: 50px; clear: both;">&nbsp;</div>
    <div style="display:none" id="evaluationflag" >${evaluationflag}</div>
    <%--   <c:if test="${evaluationflag=='1'}">  --%>
	<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
		<a href="javascript:void(0);"
			onclick="goEvaluation('${WeixinRepair.id}')">
			<div style="line-height: 50px;">点 &nbsp;&nbsp;&nbsp;&nbsp;评</div>
		</a>
	</header>
	  <%-- </c:if> --%>	
	<!--<![endif]-->
</body>
<script>
	function goEvaluation(repairId) {
		var evaluationflag=$("#evaluationflag").html();
		var WeixinRepairName='${WeixinRepair.name}';
		var WeixinRepairNameZ=escape(encodeURIComponent(WeixinRepairName)); //转码
		if(evaluationflag=='1'){
			location.href = "${webRoot}/fo/repairFactoryController.do?method=evaluation&openid=${openid}&repairId="
				+ repairId + "&repairname="+WeixinRepairNameZ;
		}else{
			alert("您没有在此维修厂修理过或者已经评论过，不能评价。 ");
		}
		
	}

	function goHistoricalEvaluation(repairId) {
		var WeixinRepairName='${WeixinRepair.name}';
		var WeixinRepairNameZ=escape(encodeURIComponent(WeixinRepairName)); //转码
		location.href = "${webRoot}/fo/repairFactoryController.do?method=historicalEvaluation&openid=${openid}&repairId="
				+ repairId+"&repairname="+WeixinRepairNameZ;
	}
	//进入地图页面
	function goToMapPage(latitude, longitude) {
		//带有路径规划
		//window.open('http://apis.map.qq.com/uri/v1/geocoder?coord='+latitude+','+longitude);
		  var repairname=escape(encodeURIComponent('${WeixinRepair.name}')); //转码
		window
				.open('${webRoot}/fo/repairFactoryController.do?method=goToMapPage&openid=${openid}&repairname='+repairname+'&latitude='
						+ latitude + '&longitude=' + longitude);
	}
	
	//进入抵用券页面
	function  goToGiftSetDetail(giftSetId){
		location.href="${webRoot}/fo/repairFactoryController.do?method=goToGiftSetDetail&openid=${openid}&giftSetId="+giftSetId;
	}
	
	$(document).ready(function(){
		var size = $("#giftsetListId > div:gt(2)").size();
		$("#giftsetListId > div:lt(3)").show();
		if(size>0){
			$("#giftsetListId").append("<div class=\"fb_Repair_1\" style=\"clear: both;border-top:1px solid #dedede;\" id=\"loadMoreGiftSet\"><div class=\"fb_Repair_middle_2\" style=\"color:#0e90d2;text-align:center\">查看更多</div></div>");
			$("#loadMoreGiftSet").click(function(){
				$(this).remove();
				$("#giftsetListId > div:gt(2)").show();
			});
		}
	});
</script>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
