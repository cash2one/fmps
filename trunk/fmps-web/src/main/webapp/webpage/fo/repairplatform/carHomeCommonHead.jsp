<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${webRoot}/plug-in/carHome/css/carHomeCommonHead.css" />
<header data-am-widget="header" class="am-header am-header-default"
	data-am-sticky>
	<div class="am-header-left am-header-nav fb-singleDropdown" style="padding-top: 16px;">
		<a href="javascript:">
			<span class="am-header-nav-title" id="currentCity">
				<c:if test="${citycode=='350200'}">厦门</c:if>
				<c:if test="${citycode=='350100'}">福州</c:if>
				<c:if test="${citycode=='350600'}">漳州</c:if>
				<c:if test="${citycode=='350500'}">泉州</c:if>
				<c:if test="${citycode=='510100'}">成都</c:if>
				<c:if test="${citycode=='500000'}">重庆</c:if>
			</span>
		</a>
	</div>
	<div class="citySlide margin-header">
	 <div style="height: 15px;">&nbsp;</div>
		<ul class="">
			<div style="width:95%;margin:auto;">
				<li class=""><a href="javascript:;" class="" code="350200">厦门</a>
				</li>
				<li class=""><a href="javascript:;" class="" code="350100">福州</a>
				</li>
				<li class=""><a href="javascript:;" class="" code="350600">漳州</a>
				</li>
				<li class=""><a href="javascript:;" class="" code="350500">泉州</a>
				</li>
				<li class=""><a href="javascript:;" class="" code="510100">成都</a>
				</li>
				<li class=""><a href="javascript:;" class="" code="500000">重庆
				</a></li>
			</div>
		</ul>
		<div style="height: 15px; clear: both;">&nbsp;</div>
	</div>
	<div class="am-header-title" onClick="gotoSearch()">
		<div class="search">
			<div class="search_img">
				<img src="${webRoot}/plug-in/carHome/images/search_icon_2.jpg" />
			</div>
			<div class="search_input">
				<input name="" type="text" placeholder="请输入券、商家信息" />
			</div>
		</div>
	</div>
	<div class="am-header-right am-header-nav" style="padding-top: 18px;">
		<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${domain}/fo/binded/repairFactoryGiftController.do?method=giftList&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"
			class=""> <span class="am-header-nav-title"> 礼包</span></a>
	</div>
</header>
