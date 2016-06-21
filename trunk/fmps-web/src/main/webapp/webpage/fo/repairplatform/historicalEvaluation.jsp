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

<style>
html, body, .page {
	height: 100%;
}

#wrapper {
	position: relative;
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

.am-header .am-header-title {
	margin: 0 15%;
}

[data-am-widget='tabs'] {
	margin: 0px;
}

.fb_Comment {
	padding: 10px 15px;
	clear: both;
	height: auto;
	width: 100%;
	border-bottom: 1px solid #dedede;
	float: left;
}

.fb_Comment_img {
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	-o-border-radius: 50px;
	border-radius: 50px;
	background: url(../plug-in/repair/futai_index_pro.jpg) scroll center
		no-repeat;
	height: 50px;
	width: 50px;
	float: left;
}

.fb_Comment_img_1 {
	float: left;
}

.fb_Comment_text {
	float: left;
	width: 80%;
	padding-left: 10px;
	font-size: 0.825em;
	color: #222222;
}

.am-tabs-bd {
	border: 0px solid #ddd;
}

header {
	height: 50px;
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
	<div class="page">
		<header data-am-widget="header" class="am-header am-header-default">
			<h1 class="am-header-title" style="font-size: 1em;">
				<a href="#title-link" class="" style="color: #171717;">${weixinRepairName}</a>
			</h1>
			<div class="am-header-right am-header-nav"></div>
		</header>
        <div id="repairIdx" style="display:none;">${repairId}</div>
		<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
			<ul id="ual" class="am-tabs-nav am-cf">
				<li class="am-active" onclick="getEvaList('全部')" ><a href="[data-tab-panel-0]">全部</a></li>
				<li class="" onclick="getEvaList('好评')"><a
					href="[data-tab-panel-1]">好评</a></li>
				<li class="" onclick="getEvaList('差评')"><a href="[data-tab-panel-2]">差评</a></li>
			</ul>
			<div class="am-tabs-bd">
				<div data-tab-panel-0 class="am-tab-panel am-active" id="alldiv">
					<%-- <ul style="padding-left: 0em;" >
						<c:forEach items="${evaluationList}" var="WeixinEvaluation"
							varStatus="status">
							<li >
								<div class="fb_Comment">
									<div class="fb_Comment_img_1">
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
													value='${WeixinEvaluation.insertTime }'
													pattern="MM-dd HH:mm" /></span>
										</div>
										<div style="padding: 1px;">${WeixinEvaluation.comment }</div>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul> --%>
				</div>
				 
				<div data-tab-panel-1 class="am-tab-panel " id="haodiv">
				
				</div>
				
				 <!-- <div class="get_more"><span>努力加载中...</span></div> --> 
				<div data-tab-panel-2 class="am-tab-panel " id="chadiv">
					<%-- <c:forEach items="${evaluationList}" var="WeixinEvaluation"
						varStatus="status">
						<div class="fb_Comment">
							<div class="fb_Comment_img_1">
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
					</c:forEach> --%>
				</div>
				 <!-- <div class="get_more"><span>努力加载中...</span></div>  -->
			</div>
			
			<div class="get_more" style="text-align: center;"><span>努力加载中...</span></div> 
             <div id="divgjj" style="display:none;">1</div>
			<div id="wrapper" data-am-widget="list_news"
				class="am-list-news am-list-news-default">




				<header style="display: none;"
					class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
					<div style="line-height: 50px;">获取保修二维码</div>
				</header>

			</div>
		</div>
		<!--<![endif]-->
		<script type="text/javascript">
			function getEvaList(flag) {
				//alert(flag);
				//ajax读取评价历史列表，拼装显示信息
				if(flag=="全部"){
					ajaxtip(" ");
					$("#alldiv").html("");
					$("#divgjj").html("1");
					start = 1; 
					ajax();
					
				}
				if(flag=="好评"){
					ajaxtip(" ");
					$("#haodiv").html("");
					$("#divgjj").html("2");
					start = 1; 
					ajaxhao();
					
				}
				if(flag=="差评"){
					ajaxtip(" ");
					$("#chadiv").html("");
					$("#divgjj").html("3");
					start = 1; 
					ajaxcha();
				}
			}
			
		 	
			
		//滑动下拉框	
			function scroll(){
				$(window).scroll(function(){
					//alert("1------------------------");
					 var wst = $(window).scrollTop();
					var bodyHeight = $(document).height();
					if (!ajaxload) {
						//console.log("start="+start);
						if (wst + winHeight > bodyHeight - 20) {
							ajaxtip("努力加载中...");
							console.log("inajax");
							if (iisstop==0) {
								iisstop=1; //锁定
								ff();
							/* 	$('#ual li').each(function(index) {
									  if($(this).attr("class","am-active")=="全部"){
										  ajax();
									  }
                                      if($(this).text()=="好评"){
                                    	  ajaxhao();
									  }
                                      if($(this).text()=="差评"){
                                    	  ajaxcha();
									  }
									
								 }); */	
								 var gjjdiv=$('#divgjj').html();
								 if(gjjdiv==0){
									 ajax(); 
								 }
								 if(gjjdiv==1){
									 ajax(); 
								 }
                                 if(gjjdiv==2){
                                	 //var start = 1; 
                                	 ajaxhao();
								 }
                                 if(gjjdiv==3){
                                	 //var start = 1; 
                                	 ajaxcha();
								 }
							iisstop=0; //解除锁定
							}
							} 
							}
						});
				
				
			}
			
			
			
			
			//加载更多评价列表 
            var start = 1; 
			var count = 10;
			var ajaxload = false; 
			var iisstop=0;
			var paging=10;
			
			winHeight = $(window).height();
			scroll();
		
		 	$(document).ready(function () {
				ajax();
			 });
				 
			function ff(){
				ajaxload = true;
			}
			function ajax(){
				var evaluationstate="1";
				var repairId=$("#repairIdx").html();
				 $.ajax({
						type: "POST",
						url : "${webRoot}/fo/repairFactoryController.do?method=historicalEvaluationajax",
						data:{start:start,evaluationstate:evaluationstate,repairId:repairId},
						dataType: "json",
						success: function(data){
							if(data.length != 0){	
								var html = ""; 
								 for (var i = 0; i < data.length; i++) {
									 var evaluation="../plug-in/repair/star-"+data[i].evaluation+".png";
                                    html += '<div class="fb_Comment">';
		                            html += '<div class="fb_Comment_img_1">';
		                            html += '<img alt="" src="'+data[i].headimgurl+'" style="border-radius: 50px; width: 50px; height: 50px;"></div> ' ;
		                            html += '<div class="fb_Comment_text"><div style="padding: 1px;">'+data[i].nickname+'</div>';
		                            html += '<div style="padding: 1px;"><img src="'+evaluation+'"';
		                            html += 'width="66" height="12" /><span style="float: right; color: #333;"></span>'; 
		                            html += '</div><div style="padding: 1px;">'+data[i].comment+'</div></div></div>';  
			                      }
								$("#alldiv").append(html);
								 start = start + 1;
								ajaxload = false;
								console.log("paging="+paging);
								ajaxtip("");
						  	}else{
								ajaxload = true;
								ajaxtip("没有评论数据了！");
							}
							
						}
				});
				

				
			}
			function ajaxhao(){
				var evaluationstate="2";
				var repairId=$("#repairIdx").html();
				 $.ajax({
						type: "POST",
						url : "${webRoot}/fo/repairFactoryController.do?method=historicalEvaluationajax",
						data:{start:start,evaluationstate:evaluationstate,repairId:repairId},
						dataType: "json",
						success: function(data){
							if(data.length != 0){	
								var html = ""; 
								 for (var i = 0; i < data.length; i++) {
									 var evaluation="../plug-in/repair/star-"+data[i].evaluation+".png";
                                    html += '<div class="fb_Comment">';
		                            html += '<div class="fb_Comment_img_1">';
		                            html += '<img alt="" src="'+data[i].headimgurl+'" style="border-radius: 50px; width: 50px; height: 50px;"></div> ' ;
		                            html += '<div class="fb_Comment_text"><div style="padding: 1px;">'+data[i].nickname+'</div>';
		                            html += '<div style="padding: 1px;"><img src="'+evaluation+'"';
		                            html += 'width="66" height="12" /><span style="float: right; color: #333;"></span>'; 
		                            html += '</div><div style="padding: 1px;">'+data[i].comment+'</div></div></div>';  
			                      }
								$("#haodiv").append(html);
								ajaxload = false;
								start = start + 1;
								console.log("paging="+paging);
								ajaxtip("");
						  	}else{
								ajaxload = true;
								ajaxtip("没有好评数据了 ！");
							}
							
						}
				});
				
				}
				
			function ajaxcha(){
				//var start=1;
				var evaluationstate="3";
				var repairId=$("#repairIdx").html();
				 $.ajax({
						type: "POST",
						url : "${webRoot}/fo/repairFactoryController.do?method=historicalEvaluationajax",
						data:{start:start,evaluationstate:evaluationstate,repairId:repairId},
						dataType: "json",
						success: function(data){
							if(data.length != 0){	
								var html = ""; 
								 for (var i = 0; i < data.length; i++) {
									 var evaluation="../plug-in/repair/star-"+data[i].evaluation+".png";
                                    html += '<div class="fb_Comment">';
		                            html += '<div class="fb_Comment_img_1">';
		                            html += '<img alt="" src="'+data[i].headimgurl+'" style="border-radius: 50px; width: 50px; height: 50px;"></div> ' ;
		                            html += '<div class="fb_Comment_text"><div style="padding: 1px;">'+data[i].nickname+'</div>';
		                            html += '<div style="padding: 1px;"><img src="'+evaluation+'"';
		                            html += 'width="66" height="12" /><span style="float: right; color: #333;"></span>'; 
		                            html += '</div><div style="padding: 1px;">'+data[i].comment+'</div></div></div>';  
			                      }
								$("#chadiv").append(html);
								ajaxload = false;
								start = start + 1;
								console.log("paging="+paging);
								ajaxtip("");
						  	}else{
								ajaxload = true;
								ajaxtip("没有差评数据了 ！");
							}
							
							
						}
				});
				
				}
			
			function ajaxtip(txt) {
				  $(".get_more span").html(txt);
				}
		</script>
</body>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
