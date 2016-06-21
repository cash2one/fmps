<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦保险</title>
<style type="text/css">
body {
	font-family: "黑体";
	font-size: 14px;
	background-color: #f5f5f5;
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

[data-am-widget='tabs'] {
	margin: 0px;
}

.am-tabs-d2 .am-tabs-nav {
	background-color: #fff;
	border-bottom: 1px solid #e8e8e8;
}

.am-tabs-d2 .am-tabs-nav>.am-active {
	position: relative;
	background-color: #fff;
	border-bottom: 1px solid #0e90d2;
}

.am-tabs-d2 .am-tabs-nav>.am-active:after {
	position: absolute;
	width: 0;
	height: 0;
	bottom: 0px;
	left: 50%;
	margin-left: -5px;
	border: 0px rgba(0, 0, 0, 0) solid;
	content: "";
	z-index: 1;
	border-bottom-color: #0e90d2;
}

.am-tabs-bd {
	position: relative;
	overflow: hidden;
	border: 0px solid #ddd;
	border-top: none;
	z-index: 100;
	-webkit-transition: height .3s;
	transition: height .3s;
}

.am-tabs-bd .am-tab-panel {
	position: absolute;
	top: 0;
	z-index: 99;
	float: left;
	width: 100%;
	padding: 0px 0px 0px 0px;
}

.order_name {
	border-bottom: 1px solid #e8e8e8;
	height: 40px;
	padding: 10px 10px 0px 10px;
	background-color: #fff;
}

.order_details {
	background: #fff;
	height: 90px;
	border-bottom: 1px solid #e8e8e8;
	padding: 10px 10px 0px 10px;
	line-height: 24px;
}

.order_button {
	width: 100%;
	float: left;
	border-bottom: 1px solid #e8e8e8;
	height: 40px;
	background-color: #fff;
}

.order_button .left {
	width: 70%;
	float: left;
	padding-top: 8px; text-indent: 10px;
}

.order_button .left .color {
	color: #e7781d;
}

.order_button .right {
	width: 30%;
	float: left;
	background-color: #e7781d;
	color: #fff;
	text-align: center;
	height: 40px;
    padding-top: 8px;
}

.blank {
	clear: both;
	height: 10px;
	border-bottom: 1px solid #e8e8e8;
	border-top: 1px solid #e8e8e8;
	background-color: #f5f5f5;
}

.tips_center {
	margin: 0 auto;
	width: 100%;
	text-align: center;
}

.tips_center_text {
	color: #4a4b4d;
	text-align: center;
}

.tips_center_text_2 {
	width: 30%;
	height: auto;
	text-align: center;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	color: #727378;
	border: 1px solid #5c5c5e;
	padding: 1px 0px 1px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid }">
	<input type="hidden" id="status" name="status" value="">
	<header data-am-widget="header" class="am-header am-header-default">
		<h1 class="am-header-title" style="color: #132a39; font-size: 16px;">
			订单管理</h1>
	</header>
	<div data-am-widget="tabs" class="am-tabs am-tabs-d2" data-am-tabs-noswipe="1">
		<ul class="am-tabs-nav am-cf">
			<li class="am-active" onclick="loadPolicyList('0')"><a href="[data-tab-panel-0]">待支付</a></li>
			<li class="" onclick="loadPolicyList('1')"><a
				href="[data-tab-panel-1]">已支付</a></li>
			<li class="" onclick="loadPolicyList('2')"><a
				href="[data-tab-panel-2]">已承保</a></li>
		</ul>
		<div class="am-tabs-bd">
			<div id="tab-panel-1" data-tab-panel-0 class="am-tab-panel am-active">				
			</div>
			<div id="tab-panel-2" data-tab-panel-1 class="am-tab-panel ">				
			</div>
			<div id="tab-panel-3" data-tab-panel-2 class="am-tab-panel ">
			</div>
			<div class="grid" ID="load"  >
               <div class="cell">
                  <div class="card"> <span class="spinner-loader">Loading&#8230;</span> 
                   <div style="clear:both;">正在加载</div>
                  </div>                  
               </div>
             </div>
			<div class="tips_center" id="tips" style="display: none">
					<br /> <br /> <br />
					<div class="tips_center_img">
						<img src="${webRoot }/plug-in/weixin/image/info.jpg" width="140"
							height="140" />
					</div>
					<br />
					<div class="tips_center_text">您没有相关订单</div>
					<br />
				</div>
		</div>
	</div>

	<script type="text/javascript">
		var start = 1;
		var isendpage = false;
		var controlFlag=true; 
		$(document).ready(function () {
			loadPolicyList('0');
		});
		function cancelOrder(orderno) {
			var openid = $("#openid").val();
			if (confirm('您是否确定删除当前订单')) {
				$
						.ajax({
							async : false,
							type : 'POST',
							url : "${webRoot}/fo/binded/personalCenter/orderController.do?cancelOrder",
							data : {
								orderno : orderno,
								openid : openid
							},
							dataType : "json",
							error : function() {// 请求失败处理函数
								alert('请求失败！');
							},
							success : function(json) {
								if (json.success) {
									var divid = "#" + orderno;
									$(divid).remove();
									if ($("#tab-panel-1").html()==0) {
										$("#tips").css("display", "block");
									}
								} else {
									alert('订单删除失败，请重试');
								}
							}
						});
			}
		}

		function orderinfo(orderno) {
		   var status=$("#status").val();			
			if(status=='2'){
				location.href = "${webRoot}/fo/cardController.do?viewnewdetail&openid=${openid}&policyNo=" + orderno;		
			}else{
			location.href = "${webRoot}/fo/taiwanController.do?showProduct&openid=${openid}&orderno="
					+ orderno;
			   }
		}

		function loadPolicyList(status) {
			$("#tips").css("display", "none");
			start = 1;
			isendpage=false ;
			if(status=='0'){
				$("#tab-panel-2").html('');
				$("#tab-panel-3").html('');
			}
			if(status=='1'){
				$("#tab-panel-3").html('');
				$("#tab-panel-1").html('');
			}
			if(status=='2'){
				$("#tab-panel-2").html('');
				$("#tab-panel-1").html('');
			}			
			$("#status").val(status);
			appendPolicyList(status, start);
		}

		function appendPolicyList(status, start) {
			var openid = $("#openid").val();
			showdiv();
			$
					.ajax({
						async : false,
						type : 'POST',
						url : "${webRoot}/fo/binded/personalCenter/orderController.do?getPolicyList",
						data : {
							status : status,
							openid : openid,
							start : start
						},
						dataType : "json",
						error : function() {// 请求失败处理函数
							alert('请求失败！');
						},
						success : function(json) {							
							if (json.success) {
								var appendhtml="";
								$.each(json.obj,function(i, item) {
									appendhtml+="<div id=\""+item.orderno+"\"><div  class=\"order_name\">"
									+ item.productname;
									if(status=='0'){
										appendhtml+=" <span class=\"am-icon-trash\"	style=\"float: right; padding-top: 2px; color: #92c126;\" onclick=\"cancelOrder('"+item.orderno+"');\"></span>";
									}
									//appendhtml+=" </div><div class=\"order_details\" onclick=\"orderinfo('"
								//	+ item.orderno
								//	+ "');\"><div>订单号："
								//	+ item.orderno
								//	+ "</div>";
									if(status=='2'){
										appendhtml+=" </div><div class=\"order_details\" style=\"height:120px\" onclick=\"orderinfo('"
											+ item.policyno
											+ "');\"><div>订单号："
											+ item.orderno
											+ "</div>";
										appendhtml+="<div>保单号: "+item.policyno+"</div>";
									}else{
										appendhtml+=" </div><div class=\"order_details\" onclick=\"orderinfo('"
											+ item.orderno
											+ "');\"><div>订单号："
											+ item.orderno
											+ "</div>";
									}
									appendhtml+="<div>保障期限："
									+ FormatDate(item.startdate)
									+ "-"
									+ FormatDate(item.enddate)
									+ "<span style=\"float:right; padding-top:6px; teat-align:right;\"><img src=\"${webRoot}/plug-in/fo/images/right2.png\" width=\"8\" height=\"13\"/></span></div><div>被保险人："
									+ item.name
									+ "</div></div><div class=\"order_button\"><div class=\"left\">订单金额： <span class=\"color\">"
									+ item.premium
									+ "元</span></div>";
									if(status=='0'){
										appendhtml+="<div class=\"right\" onclick=\"pay('"+item.orderno+"')\">立即支付</div>";
									}
									appendhtml+="</div><div class=\"blank\">&nbsp;</div></div>";
													
								});
								if (status == '0') {
									$("#tab-panel-1").append(appendhtml);
								}
								if (status == '1') {
									$("#tab-panel-2").append(appendhtml);
								}
								if (status == '2') {
									$("#tab-panel-3").append(appendhtml);
								}
							} else {
								isendpage = true;
								if (status == '0') {									
									if ($("#tab-panel-1").html()==0) {
										$("#tips").css("display", "block");
									} else {
										$("#tab-panel-1").append('已经到达尾页了');
									}
								}
								
								if (status == '1') {									
									if ($("#tab-panel-2").html()==0) {
										$("#tips").css("display", "block");
									} else {
										$("#tab-panel-2").append('已经到达尾页了');
									}
								}
								if (status == '2') {
									if ($("#tab-panel-3").html()==0) {
										$("#tips").css("display", "block");
									} else {
										$("#tab-panel-3").append('已经到达尾页了');
									}
								}
							}
							controlFlag=true;
							hidediv();
						}
					});
		}

		function FormatDate(strTime) {
			var date = new Date(strTime);
			return date.getFullYear() + "." + (date.getMonth() + 1) + "."
					+ date.getDate();
		}

		function pay(orderno) {
			var openid = $("#openid").val();
			$
					.ajax({
						async : false,
						type : 'POST',
						url : "${webRoot}/pay/taipayController.do?pay",
						data : {
							openid : openid,
							orderno : orderno
						},
						dataType : "json",
						error : function() {// 请求失败处理函数
							alert('请求失败！');
						},
						success : function(json) {
							if (json.success) {
								var paytext = eval('(' + json.obj + ')');
								WeixinJSBridge.invoke('getBrandWCPayRequest',paytext,function(res) {
													if (res.err_msg == 'get_brand_wcpay_request:ok') {
														//支付成功
														result = "success";
														goToPayResult(result,
																res.err_msg,
																orderno);
													} else {
														//showError('保费支付失败，请确认您的银行卡是否可正常使用，或者支付额度是否足够！');
														var msg = res.err_msg;
														$
																.ajax({
																	type : 'POST',
																	url : "${webRoot}/pay/taipayController.do?goToPayResultfail",
																	data : "&orderno="
																			+ orderno
																			+ "&openid="
																			+ openid
																			+ "&msg="
																			+ msg,
																	dataType : "json",
																	success : function(
																			json) {

																	}
																});
													}
												});
							} else {
								showError(json.msg);
							}
						}
					});
		}

		function goToPayResult(result, err_msg, orderno) {
			var appliName = $("#appliName").val();
			var appliIdentifyType = $("#appliIdentifyType").val();
			var appliIdentifyNumber = $("#appliIdentifyNumber").val();
			var openid = $("#openid").val();
			var url = "${webRoot}/pay/taipayController.do?showPayResult&result="
					+ result
					+ "&orderno="
					+ orderno
					+ "&openid="
					+ openid
					+ "&msg="
					+ err_msg
					+ "&appliName="
					+ appliName
					+ "&appliIdentifyType="
					+ appliIdentifyType
					+ "&appliIdentifyNumber" + appliIdentifyNumber;
			location.href = url;
		};

		function showError(str) {
			alert(str);
		}
		$(window)
				.scroll(
						function() {
							var bot = 20; //bot是底部距离的高度
							if ((bot + $(window).scrollTop()) >= ($(document)
									.height() - $(window).height())) {
								var status = $("#status").val();								
								if (!isendpage&&controlFlag) {
									controlFlag=false;
									start = start + 1;
									appendPolicyList(status, start);
								}
							}
						});
		function showdiv() { 
		     document.getElementById("load").style.display ="block";   
		  }
	   function hidediv() {
		    document.getElementById("load").style.display ='none';   
		 } 
	</script>
</body>
</html>