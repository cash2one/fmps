<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>富邦财险</title>
	<meta name="keywords" content="user">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<meta name="renderer" content="webkit" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png" />
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<%@ include file="/webpage/fo/common/fotags.jsp"%>
  	<link href="http://cdn.amazeui.org/amazeui/2.5.0/css/amazeui.min.css" />
  	<link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/dropdown.css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/repair_depot.css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/merchant.css" />
	<style type="text/css">
	.fb-dropdown dt a {
	  position: relative;
	  float: left;
	  width: 50%;
	  height: 40px;
	  line-height: 40px;
	  color: #333;
	  font-size: 12px;
	  text-align: center;
	}
	</style>
</head>

<body>
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
		<div class="am-modal-dialog" style="border-top:5px solid #fff;background:#fff">
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
			<div class="am-modal-hd" style="height:40px;font-size:16px;color:#000">正在加载...</div>
		</div>
	</div>
	<%@ include file="carHomeCommonHead.jsp"%>
	<dl class="fb-dropdown">
		<dt>
			<a id="wholeCity" href="javascript:;">全城</a>
			<a id="order" href="javascript:;">排序</a>
		</dt>
		<dd class="city">
			<ul class="slide downlist" id="addresscodeList">
			</ul>
		</dd>
		<dd class="order">
			<ul class="slide downlist" id="orderList">
			</ul>
		</dd>
	</dl>
	<div class="Double_activity_nbsp">&nbsp;</div>
	<div data-am-widget="slider" class="am-slider am-slider-a1">
		<ul class="am-slides">
			<li style="border-bottom: 1px solid #e8e8e8;"><a href="#"
				class="#"><img src="${webRoot}/plug-in/carHome/images/other_top.jpg" /></a></li>
		</ul>
	</div>
	<div class="Double_activity_xian">&nbsp;</div>
	<div class="Double_activity_recommend" id="repairFactoryArrayId">
	</div>
	<input type="hidden" id="addressId" value="${address }" />

	<script type="text/javascript" src="${webRoot}/plug-in/carHome/js/dropdown.js"></script>
	<script>
	var paging = 1;
	var isendpage = false;
	var controlFlag=true;
	var initFlag=true;
	
	var citycode = '${citycode}';
	var order = "distance";
	var countycode = "";
	var categoryid = "";
	loadmerchantList();
	
	$(function() {
		$(window).scroll(function () {
			if ($(window).scrollTop() >= ($(document).height() - $(window).height())) {
				if(!isendpage&&controlFlag){
	      	    	controlFlag=false;  
					paging = paging + 1;
					loadmerchantList();
				}
			}
		});
		//初始化城市选择
		$('.fb-singleDropdown').dropdown('selectedCity');
		
		$(".citySlide a").on("click",function(){
			citycode = $(this).attr("code");
			$("#currentCity").text($(this).text());
			
			resetInitParam();
			changeCityResetInitParam();
			loadmerchantList();
		});
	});
	
	function loadmerchantList(){
		var address = $("#addressId").val();
		
		$.ajax({
			url : "${webRoot}/fo/carHomeController.do?method=getOtherServicesList",
			data : {
				"openid":'${openid}',
				"citycode":citycode,
				"countycode":countycode,
				"categoryid":categoryid,
				"address":address,
				"order":order,
				"paging":paging
			},
			type : "POST",
			dataType: "json",
			beforeSend : function(){
				openmodel();
			},
			success : function(data) {
		 		var json = eval('('+data+')');
		 		
		 		var isnull = (0==json.repairList.length);
				controlFlag=true;
				if(!isnull){
					if(initFlag){
				 		//全城
				 		$("#addresscodeList").empty();
				 		$("#addresscodeList").append('<li><a href="#" aredId="">不限</a></li>');
				 		$.each(json.addresscodeList, function(id, item) {
				 			$("#addresscodeList").append('<li><a href="#" aredId=' + item.countycode + '>' + item.county + '</a></li>');
				 		});
				 		$("#addresscodeList").dropdown('selectedSingle');
				 		addWholeCityListener();
				 		
				 		//排序
				 		$("#orderList").empty();
				 		$("#orderList").append('<li><a href="#" orderId="distance">距离</a></li><li><a href="#" orderId="evaluation">评价</a></li>');
				 		$("#orderList").dropdown('selectedOrder');
				 		addOrderListener();
				 		
				 		initFlag = false;
					}
					
			 		//列表
			 		$.each(json.repairList, function(id, item) {
						
			 			var giftListDiv = "";
			 			for (var i = 0; i < item.giftSetList.length; i++) {
		 					giftListDiv += 
			 					'		<div class="project_1">'+
			 					'			<span class="border_1" style="background-color:#5194ef">劵</span> '+item.giftSetList[i].name+' <span style="float: right;">已领'+item.giftSetList[i].receivedQuantity+'份</span>'+
			 					'		</div>';
			 			}
						
			 			$("#repairFactoryArrayId").append(
			 					'<div class="recommend_business" onClick="gotoRepair(\''+item.id+'\')">'+
			 					'	<div class="business_img">'+
			 					'		<img src="'+item.imgUrl+'" />'+
			 					'	</div>'+
			 					'	<div class="business_text">'+
			 					'		<div class="name">'+item.name+'</div>'+
			 					'		<div class="km">'+item.distance+'km</div>'+
			 					'		<div class="receive_1">'+
			 					'			<img src="${webRoot}/plug-in/repair/star-'+item.evaluation+'.png" />'+
			 					'		</div>'+
			 					'		<div class="add">'+item.shortAddr+'</div>'+
			 					'		'+giftListDiv+
			 					'	</div>'+
			 					'</div>'+
			 					'<div class="Double_activity_xian">&nbsp;</div>');
			 		});
				}else{
					isendpage = true;
					if(initFlag){
						$("#repairFactoryArrayId").append('<div class="recommend_business" style="text-align:center;color:#4fc6ee;height:20px; line-height:10px;">暂无商家</div>');
					}else{
						$("#repairFactoryArrayId").append('<div class="recommend_business" style="text-align:center;color:#4fc6ee;height:20px; line-height:10px;">已经到达尾页了</div>');
					}
				}
		 		
				closemodel();
			},
			error : function(e) {
				closemodel();
				alert("加载数据失败");
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
	function gotoSearch() {
		var address = escape(encodeURIComponent($("#addressId").val()));
		
		var url = "${webRoot}/fo/carHomeController.do?method=carHomeSearch"+
			"&citycode="+citycode+
			"&address="+address;
		location.href = url;
	}
	function gotoRepair(repairId) {
		var url = "${webRoot}/fo/carHomeController.do?method=MerchantMain&repairId="+repairId;
		location.href = url;
	}
	
	function addClassifyListener(){
		$(".fb-secondary-dropdown a").on("click",function(){
			var selectedId = $(this).find("span:last").text();
			
			categoryid = selectedId;
			resetInitParam();
			loadmerchantList();
		});
	}
	
	function addWholeCityListener(){
		$(".city .downlist a").on("click",function(){
			var areaId = $(this).attr("aredId");
			
			countycode = areaId;
			resetInitParam();
			loadmerchantList();
		});
	}
	
	function addOrderListener(){
		$(".order .downlist a").on("click",function(){
			var orderId = $(this).attr("orderId");
			
			order = orderId;
			resetInitParam();
			loadmerchantList();
		});
	}
	
	function resetInitParam(){
		paging = 1;
		isendpage = false;
		controlFlag = true;
		$("#repairFactoryArrayId").empty();
	}
	function changeCityResetInitParam(){
		initFlag = true;
		countycode = "";
		categoryid = "";
		$("#classify").text("分类");
		$("#wholeCity").text("全城");
		
		$(".second-stage").empty();
		$(".fb-secondary-dropdown").empty();
		$("#addresscodeList").empty();
	}
	</script>
</body>
</html>
