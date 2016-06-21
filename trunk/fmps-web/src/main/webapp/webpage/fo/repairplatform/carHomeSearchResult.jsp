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
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<%@ include file="/webpage/fo/common/fotags.jsp"%>
  	<link href="http://cdn.amazeui.org/amazeui/2.5.0/css/amazeui.min.css" />
  	<link href="${webRoot}/plug-in/weixin/css/spinners.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/dropdown.css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/search_list.css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/search.css" />
	<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/merchant.css" />
</head>

<body>
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
		<div class="am-modal-dialog" style="border-top:5px solid #fff;background:#fff">
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
			<div class="am-modal-hd" style="height:40px;font-size:16px;color:#000;padding:0px;">正在加载...</div>
		</div>
	</div>
	<div class="top_search" data-am-sticky>
		<div class="top_search_left">
			<div class="top_search_left_img">
				<img src="${webRoot}/plug-in/carHome/images/search_icon_2.jpg" width="22" height="22" />
			</div>
			<div class="top_search_left_input">
				<input id="searchnameId" type="text" size="30" placeholder="请搜索" value="${searchname }" onClick="gotoSearch()" />
			</div>
		</div>
		<div class="top_search_right" style="color:#4fc6ee;padding:16px 0px 0px 5px" onClick="javascript:history.go(-1);">取消</div>
	</div>

	<div class="list_center">

		<dl class="fb-dropdown">
			<dt>
				<a id="classify" href="javascript:;">分类 </a> 
				<a id="wholeCity" href="javascript:;">全城</a>
				<a id="order" href="javascript:;">排序</a>
			</dt>
			<dd class="secondary">
				<ul class="slide downlist second-stage">

				</ul>
				<!-- 下拉菜单右侧列表 -->
				<ul class="fb-secondary-dropdown">

				</ul>
			</dd>
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
		<div class="Double_activity_recommend" id="repairFactoryArrayId">
		</div>
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
	});
	
	function loadmerchantList(){
		var address = $("#addressId").val();
		var searchname = $("#searchnameId").val();
		
		$.ajax({
			url : "${webRoot}/fo/carHomeController.do?method=getAllFactoryList",
			data : {
				"openid":'${openid}',
				"citycode":citycode,
				"countycode":countycode,
				"address":address,
				"searchname":searchname,
				"categoryid":categoryid,
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
						//分类
				 		var allTypeArray = [];
				 		$.each(json.catagoryList, function(id, item) {
				 			var firstName = item.catagoryname;
				 			var firstCount = item.sum;
				 			var subCategoryArray = [];
				 			for (var i = 0; i < item.subCatagoryList.length; i++) {
				 				var subCategoryObj = {};
				 				subCategoryObj.secondId = item.subCatagoryList[i].id;
				 				subCategoryObj.secondName = item.subCatagoryList[i].catagoryname;
				 				subCategoryObj.secondCount = item.subCatagoryList[i].sum;
				 				subCategoryArray.push(subCategoryObj);
				 			}
				 			var firstObj = {};
				 			firstObj.firstName = firstName;
				 			firstObj.firstCount = firstCount;
				 			firstObj.children = subCategoryArray;
							
				 			allTypeArray.push(firstObj);
				 		});
				 		$(".secondary").dropdown(allTypeArray);
				 		$(".second-stage a").each(function(index,element){
							$(this).on("click",function(){
								addClassifyListener();
							});
						});
				 		$(".second-stage a:first").trigger("click");//默认点击第一项

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
			 				var washFlag = item.giftSetList[i].type;	//超值洗车取的是剩余数，抵用券取的是领用数量
			 				if(washFlag=="4"){
			 					giftListDiv += 
				 					'		<div class="project_1">'+
				 					'			<span class="border_1" style="background-color:#ff6666;color:#fff">会</span> '+item.giftSetList[i].name+' </span>'+
				 					'		</div>';
			 				}else if(washFlag=="5"){
				 				giftListDiv += 
				 					'		<div class="project_1">'+
				 					'			<span class="border_1" style="background-color:#04d4be;color:#fff">超</span> '+item.giftSetList[i].name+' <span style="float: right;">剩余'+item.giftSetList[i].remainQuantity+'份</span>'+
				 					'		</div>';
			 				}else if(washFlag=="1"||washFlag=="2"){
			 					giftListDiv += 
				 					'		<div class="project_1">'+
				 					'			<span class="border_1" style="background-color:#5194ef">劵</span> '+item.giftSetList[i].name+' <span style="float: right;">已领'+item.giftSetList[i].receivedQuantity+'份</span>'+
				 					'		</div>';
			 				}else if(washFlag=="999"){//其他
			 					giftListDiv += 
				 					'		<div class="project_1">'+
				 					'			<span class="border_1" style="background-color:#5194ef">劵</span> '+item.giftSetList[i].name+' <span style="float: right;">已领'+item.giftSetList[i].receivedQuantity+'份</span>'+
				 					'		</div>';
			 				}
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
		var address = $("#addressId").val();
		var searchname = $("#searchnameId").val();
		var encodeAddress = escape(encodeURIComponent(address)); //转码
		var encodeSearchname = escape(encodeURIComponent(searchname)); //转码
		
		var url = "${webRoot}/fo/carHomeController.do?method=carHomeSearch"+
			"&citycode="+citycode+
			"&address="+encodeAddress+ 
			"&searchname="+encodeSearchname;
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
	</script>
</body>
</html>
