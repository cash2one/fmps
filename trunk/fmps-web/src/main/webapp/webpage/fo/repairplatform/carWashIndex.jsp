<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦保险</title>
<link href="${webRoot}/plug-in/carHome/css/dropdown.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${webRoot}/plug-in/carHome/css/cleaning_car.css" />
<link rel="stylesheet"
	href="${webRoot}/plug-in/carHome/css/merchant.css" />
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid }">
	<input type="hidden" id="orderby" name="orderby" value="distance">
	<input type="hidden" id="countycode" name="countycode" value="">
	<input type="hidden" id="catagoryid" name="catagoryid" value="">
	<input type="hidden" id="addressId" name="addressId" value="${address }">
	<%@ include file="carHomeCommonHead.jsp"%>
	<dl class="fb-dropdown">
		<dt>
			<a id="classify" href="javascript:;">分类 </a> <a id="wholeCity"
				href="javascript:;">全城</a><a id="order" href="javascript:;">排序</a>
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
				<li><a href="#" orderId="distance" onclick="sortby('distance')">距离</a></li>
				<li><a href="#" orderId="evaluation" onclick="sortby('evaluation')">评价</a></li>
			</ul>
		</dd>
	</dl>

	<div class="Double_activity_nbsp">&nbsp;</div>
	<div data-am-widget="slider" class="am-slider am-slider-a1">
		<ul class="am-slides">
			<li style="border-bottom: 1px solid #e8e8e8;"><a href="#"
				class="#"><img
					src="${webRoot}/plug-in/carHome/images/banner_car_top.jpg" /></a></li>
		</ul>
	</div>


	<div class="Double_banner">
		<div class="Double_banner_left">
			<a href="${webRoot}/webpage/fo/repairplatform/superpremcarWash.jsp"><img
				src="${webRoot}/plug-in/carHome/images/banner_car_1.jpg" /></a>
		</div>
		<div class="Double_banner_right">
			<a href="${webRoot}/webpage/fo/repairplatform/vipcarWash.jsp"><img
				src="${webRoot}/plug-in/carHome/images/banner_car_2.jpg" /></a>
		</div>
	</div>
	<div class="Double_activity_xian">&nbsp;</div>

	<div class="repairFactoryArrayId" id="repairFactoryArrayId">

	</div>
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
			<div class="am-modal-hd" style="height:40px;font-size:16px;">正在加载...</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${webRoot}/plug-in/carHome/js/dropdown.js"></script>
	<script>
	wx.config(${JSONString});    
    wx.ready(function () {
    	// 2. 分享接口
    	// 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
        wx.onMenuShareAppMessage({
          title: '富邦保险',
          desc: '六城百店可享会员价洗车，更有不定时超值洗车低至5元、0元！！ ',
          link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FcarWashController.do%3FcarWashIndex%26citycode%3D${citycode}%26address%3D${address}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
          imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
          trigger: function (res) {
            // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
            //alert('用户点击发送给朋友');
          },
          success: function (res) {
            //alert('已发送给朋友');
          },
          cancel: function (res) {
            //alert('已取消发送给朋友');
          },
          fail: function (res) {
            alert(JSON.stringify(res));
          }
        });



      // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
        wx.onMenuShareTimeline({
          title: '六城百店可享会员价洗车，更有不定时超值洗车低至5元、0元！！',
          link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${webRoot}%2Ffo%2FcarWashController.do%3FcarWashIndex%26citycode%3D${citycode}%26address%3D${address}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect',
          imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
          trigger: function (res) {
            // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
            //alert('用户点击分享到朋友圈');
          },
          success: function (res) {
            //alert('已分享朋友圈');
          },
          cancel: function (res) {
            //alert('已取消分享朋友圈');
          },
          fail: function (res) {
            alert(JSON.stringify(res));
          }
        });
      });

    	wx.error(function (res) {
    	  alert(res.errMsg);
    	});
	
		var paging = 1;
		var isendpage = false;
		var controlFlag=true;
		var initFlag=true;
		var citycode = '${citycode}';
		var orderby = "distance";
		var countycode = "";
		var categoryid = "";
		var now =new Date();
		$(document).ready(function() {			
			loadmerchantList();
		});
		
		$(window).scroll(function () {
			if ($(window).scrollTop() >= ($(document).height() - $(window).height())) {
				if(!isendpage&&controlFlag){
	      	    	controlFlag=false;  
					paging = paging + 1;
					loadmerchantList();
				}
			}
		});

		function loadmerchantList() {	
			controlFlag=false;
			var openid = $("#openid").val();
			var address = $("#addressId").val();
			var $modal = $('#my-modal-loading');
			$modal.modal('open');
			$.ajax({
						type : 'POST',
						url : '${webRoot}/fo/carWashController.do?getMerchantList',
						dataType : "json",
						data : {
							"openid" : openid,
							"paging" : paging,
							"citycode":citycode,
							"orderby":orderby,
							"countycode":countycode,
							"categoryid":categoryid,
							"address":address
						},
						success : function(json) {
							controlFlag=true;
							var merchantjson = eval("(" + json + ")");
							var divhtml = '';
							var isnull = (0==merchantjson.repairList.length);
							if(!isnull){
								if(initFlag){
								     var allTypeArray = [];
								     $.each(merchantjson.catagoryList,function(id, item) {
									     var firstName = item.catagoryname;
									     var firstCount = item.sum;
									     var subCategoryArray = [];
									     for (var j = 0; j < item.subCatagoryList.length; j++) {
										     var subCategoryObj = {};
										     subCategoryObj.secondId = item.subCatagoryList[j].id;
										     subCategoryObj.secondName = item.subCatagoryList[j].catagoryname;
										     subCategoryObj.secondCount = item.subCatagoryList[j].sum;
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
								 		
								      $("#addresscodeList").empty();
								      $("#addresscodeList").append("<li><a href=\"#\" aredId=\"\" onclick=\"changeaddress('')\">不限</a></li>");
								      $.each(merchantjson.addresscodeList, function(id,item) {
									      $("#addresscodeList").append("<li><a href=\"#\" aredId=\"" + item.countycode + "\" onclick=\"changeaddress('"+item.countycode+"')\">"+ item.county + "</a></li>");
								      });
								      $("#addresscodeList").dropdown('selectedSingle');
								      addWholeCityListener();
								      addOrderListener();
								      
								      initFlag=false;
								}
							      $.each(merchantjson.repairList,function(id, item) {
												var giftListDiv = "";
												var remainQuantity = 0;
												var starttime="";
												var endtime="";
												var timeDiv="";
												for (var i = 0; i < item.giftSetList.length; i++) {
													remainQuantity = item.giftSetList[i].remainQuantity;
													starttime=item.giftSetList[i].starttime;
													endtime=item.giftSetList[i].endtime;
													giftListDiv += '<div class="project_1">';
													if (remainQuantity > 0) {
														giftListDiv += "<div style=\"float:left; width:92%;\" onclick=\"goRepairMain("+ item.id+ ")\"><span class=\"border_1\">超</span>&nbsp;<span style=\"text-overflow:ellipsis; overflow:hidden; white-space:nowrap;\">"
															+ item.giftSetList[i].name
															+ "</span>&nbsp;<span style=\"float:right; padding-right:5px;\">剩"
															+ remainQuantity
															+ "份</span></div>";
														var starttimes=starttime.split(":");
														var endtimes=endtime.split(":");
														timeDiv+=" <div class=\"time\"><span class=\"time_text\">";
														timeDiv+=starttimes[0]+":"+starttimes[1]+"-"+endtimes[0]+":"+endtimes[1]+"</span></div>";
														if(beforeStarttime(starttime)){															
															giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#fff; border:1px solid #e8e8e8; color:#666;\">抢</span></div>";
														}else if(afterEndtime(endtime)){
															giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#fff; border:1px solid #e8e8e8; color:#666;\">抢</span></div>";
														}else{
															giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" onclick=\"goToGiftSetDetail('"+item.giftSetList[i].id+"')\">抢</span></div>";
														}
														
													} else {
														if (item.giftSetList[i].type == '4') {
															giftListDiv += " <div style=\"float:left; width:92%;\" onclick=\"goRepairMain("+ item.id+ ")\"><span class=\"border_3\">会</span>&nbsp;"
																	+ item.giftSetList[i].name
																	+ "</div><div style=\"float:left; width:8%;\"></div>";
														} else if (item.giftSetList[i].type == '5') {
															giftListDiv += "<div style=\"float:left; width:100%;\" onclick=\"goRepairMain("+ item.id+ ")\"><span class=\"border_1\">超</span>&nbsp;<span style=\"text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:80%;\">"
																+ item.giftSetList[i].name
																+ "</span>&nbsp;<span style=\"float:right;\">剩0份</span></div>";
															giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#999;\">抢</span></div>";
														}
													}
													giftListDiv += "</div>";
												}
												divhtml += "<div class=\"recommend_business\"><div class=\"business_img\" onclick=\"goRepairMain("
													+ item.id
													+ ")\"><img src=\""+item.imgUrl+"\" />";
												divhtml+=timeDiv;		
												divhtml += "</div><div class=\"business_text\"><div onclick=\"goRepairMain("
													+ item.id
													+ ")\"><div class=\"name\">"
														+ item.name
														+ "</div><div class=\"km\">"
														+ item.distance
														+ "km</div><div class=\"receive_1\"><img src=\"../plug-in/repair/star-"+item.evaluation+".png\" /></div><div class=\"add\">"
														+ item.shortAddr
														+ "</div></div>";
												divhtml += giftListDiv
														+ "</div></div><div class=\"Double_activity_xian\">&nbsp;</div>";
								    });
							        $("#repairFactoryArrayId").append(divhtml);							       
							}else{	
								 isendpage=true;
								 $("#repairFactoryArrayId").append('<div class="recommend_business" style="text-align:center;color:#4fc6ee;height:20px; line-height:10px;">已经到达尾页了</div>');
							}
							closemodel();
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert("加载数据失败");
							closemodel();
						}
					});
		}

		function closemodel() {
			var $modal = $('#my-modal-loading');
			$modal.modal('close');
		}
		function changeCityRefresh(obj) {
			citycode = $("#selectedArea :selected").val();
			resetInitParam();
			loadmerchantList();
		}
		
		function sortby(ordercode){
			orderby=ordercode;
			resetInitParam();
			//loadmerchantList();
		}

		function changeaddress(address){
			countycode=address;
			resetInitParam();
			//loadmerchantList();
		}
		
		function resetInitParam(){
			paging = 1;
			isendpage = false;
			controlFlag=true;
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
		
		function goSearchPage() {
			var address = escape(encodeURIComponent($("#addressId").val()));			
			var url = "${webRoot}/fo/carHomeController.do?method=carHomeSearch"+
				"&openid=${openid}"+
				"&citycode="+citycode+
				"&address="+address;
			location.href = url;
		}

		function goRepairMain(repairId) {
			location.href = "${webRoot}/fo/carHomeController.do?method=MerchantMain&openid=${openid}&repairId="
					+ repairId;
		}
		
		//进入抵用券页面
		function  goToGiftSetDetail(giftSetId){
			location.href="${webRoot}/fo/carHomeController.do?method=goToGiftSetDetail&openid=${openid}&giftSetId="+giftSetId;
		}
		
		$(".citySlide a").on("click",function(){
			citycode = $(this).attr("code");
			$("#currentCity").text($(this).text());
			
			resetInitParam();
			changeCityResetInitParam();
			loadmerchantList();
		});
		
		function beforeStarttime(starttime){
			var times=starttime.split(":");	
			if(times[0]>now.getHours()){
				return true;
			}else if(times[0]==now.getHours()&&times[1]>now.getMinutes()){
				return true;
			}else if(times[0]==now.getHours()&&times[1]==now.getMinutes()&&times[2]>now.getSeconds()){
					return true;
			}
			return false;
		}
		
		function afterEndtime(endtime){
			var times=endtime.split(":");
			if(times[0]<now.getHours()){
				return true;
			}else if(times[0]==now.getHours()&&times[1]<now.getMinutes()){
				return true;
			}else if(times[0]==now.getHours()&&times[1]==now.getMinutes()&&times[2]<now.getSeconds()){
					return true;
			}
			return false;
		}
		
		function addClassifyListener(){
			$(".fb-secondary-dropdown a").on("click",function(){
				var selectedId = $(this).find("span:last").text();
				
				categoryid = selectedId;
				$("#repairFactoryArrayId").empty();	//清空
				//切换时重置相关参数
				paging = 1;
				isendpage = false;
				controlFlag = true;
				loadmerchantList();
			});
		}
		
		function addWholeCityListener(){
			$(".city .downlist a").on("click",function(){
				var areaId = $(this).attr("aredId");
				
				countycode = areaId;
				$("#repairFactoryArrayId").empty();	//清空
				//切换时重置相关参数
				paging = 1;
				isendpage = false;
				controlFlag = true;
				loadmerchantList();
			});
		}
		
		function addOrderListener(){
			$(".order .downlist a").on("click",function(){
				var orderId = $(this).attr("orderId");
				
				order = orderId;
				$("#repairFactoryArrayId").empty();	//清空
				//切换时重置相关参数
				paging = 1;
				isendpage = false;
				controlFlag = true;
				loadmerchantList();
			});
		}

	</script>
</body>
</html>