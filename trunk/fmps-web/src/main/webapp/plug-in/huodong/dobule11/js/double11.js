//懒加载初始化
echo.init({
	offset : 30,
	throttle : 250,
	unload : false,
});
var endtime = '';
var time_city = '';
$().ready(function() {
	time_city = $("#city").val();
	var bodyWidth = document.body.clientWidth - 20;
	$("#doc-dropdown-justify").width(bodyWidth);
	$('.am-dropdown').dropdown({
		justify : '#doc-dropdown-justify'
	});
	/* 开始动态绑定 礼券链接 */
	// setLints();
	// 其他需要 初始化信息
	endtime = '2015/11/11 09:00:00';
	var time_end = new Date(endtime).getTime();
	var time_start = new Date().getTime(); // 设定当前时间 //
	if (time_start < time_end) {
		var $modal = $('#time-modal');
		$modal.modal({
			closeViaDimmer : 0,
			width : 270,
			height : 400
		});
		$modal.modal('open');
		timeid = window.setInterval(show_time, 1000);
	} else {
		if (time_city == 'xiamen') {
			var href = window.location.href; // 当前链接
			/* 选择后载入页面，不进行定位 */
			if (href.indexOf("?") < 0) {
				doLocate();
			}
		}
		setLints();
	}
});
function setLints() {
	/* 开始动态绑定 礼券链接 */
	var giftSetLink = $('.gifts');
	$
			.each(
					giftSetId,
					function(i, n) {
						var giftSetDescUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
								+ APPID
								+ "&redirect_uri="
								+ domain
								+ "/fo/repairFactoryController.do?method=goToGiftSetDetail&response_type=code&scope=snsapi_base&state="
								+ n + "#wechat_redirect";
						giftSetLink[i].href = giftSetDescUrl;
					});
}

var timeid;
function show_time() {
	var time_end = new Date(endtime).getTime();
	var time_start = new Date().getTime(); // 设定当前时间 //
	if (time_start < time_end) {
		// 计算时间差
		var time_distance = time_end - time_start;
		// 天
		var int_day = Math.floor(time_distance / 86400000)
		time_distance -= int_day * 86400000;
		// 时
		var int_hour = Math.floor(time_distance / 3600000)
		time_distance -= int_hour * 3600000;
		// 分
		var int_minute = Math.floor(time_distance / 60000)
		time_distance -= int_minute * 60000;
		// 秒
		var int_second = Math.floor(time_distance / 1000)
		// 时分秒为单数时、前面加零
		int_day = checkTime(int_day);
		int_hour = checkTime(int_hour);
		int_minute = checkTime(int_minute);
		int_second = checkTime(int_second);
		$("#eleven_time").html(
				"<div class=\"eleven_time\">" + int_day + "&nbsp;:&nbsp;"
						+ int_hour + "&nbsp;:&nbsp;" + int_minute
						+ "&nbsp;:&nbsp;" + int_second + "</div>");
	} else {
		window.clearInterval(timeid);
		var $modal = $('#time-modal');
		$modal.modal('close');
		if (time_city == 'xiamen') {
			var href = window.location.href; // 当前链接
			/* 选择后载入页面，不进行定位 */
			if (href.indexOf("?") < 0) {
				doLocate();
			}
		}
		setLints();
	}
}

function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}

// 市变化 跳转到不同页面
function RefreshList(city) {
	var page = city + ".html";
	if (city == "index") {
		page = page + "?xiamen"
	}
	var url = domain + "/plug-in/huodong/dobule11/" + page;
	location.href = url;
}
// 区变化
function RefreshCoupon(area, areaName) {
	countyCode = area;
	$(".eleven_coupon").hide();
	$("." + area).show();
	$(".areaDropdown").dropdown('close');
	$(".areaDropdown").find("button").html(
			areaName + '<span class="am-icon-caret-down"></span>');
}

// 跳转到 加油卡分享页面
function GoFuelCard() {
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID
			+ "&redirect_uri="
			+ domain
			+ "%2Ffo%2FgasCardController.do%3FgasCardIndex%26id%3D8a828ebb49166847014916deca570006&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	location.href = url;
}

// 跳转到我的礼包
function goMyGift() {
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID
			+ "&redirect_uri="
			+ domain
			+ "/fo/binded/repairFactoryGiftController.do?method=giftList&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	location.href = url;
}

// 跳转到个人中心
function goPersonCenter() {
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID
			+ "&redirect_uri="
			+ domain
			+ "/fo/binded/personalCenterController.do?method=Index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	location.href = url;
}

// 跳转到爱车之家
function goRepairPlate() {
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID
			+ "&redirect_uri="
			+ domain
			+ "/fo/repairFactoryController.do?method=repairList&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	location.href = url;
}

// 跳转到Uber
function goUber() {
	var url = "http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=400239037&idx=1&sn=38a8b969a754db083985b28d47f7a989#wechat_redirect";
	location.href = url;
}

// 跳转到代价券
function goEdaijia() {
	var url = "http://h5.edaijia.cn/activities/bd_1439448948?state=&from=groupmessage&isappinstalled=0&code=01191d9a7c444de71df2ecfddf5e1dd9&state=#page-new";
	location.href = url;
}

// 跳转到加油宝
function goGasOline() {
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID
			+ "&redirect_uri="
			+ domain
			+ "/fo/binded/gasolinegift/gasolinegiftController.do?getTheHomePage&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
	location.href = url;
}

// 获取更多
function getMore() {
	countyJson =escape(encodeURIComponent(JSON.stringify(countyJson)));
	var url = domain+"/fo/binded/repairFactoryGiftController.do?moreGiftSet&countyCode="+countyCode+"&countyJson="+countyJson;
	location.href = url;
}