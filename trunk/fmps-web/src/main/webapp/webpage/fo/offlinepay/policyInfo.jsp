<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotagsforbrowser.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦财险</title>
<style type="text/css">
body{ font-family:"黑体"; background:#f5f5f5;}
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
  height: 25px;
}
.am-header .am-header-title {
  margin: 0 1%;
}
.am-panel-group {
  margin-bottom: 0px;
}
.square_1 {
width: 10px;
height: 10px;
background: #7ac1fc; float:left; margin:4px 10px 10px 3px;
}
.square_2 {
width: 10px;
height: 10px;
background: #ff6447; float:left; margin:4px 10px 10px 3px;
}
.square_3 {
width: 10px;
height: 10px;
background: #edef27; float:left; margin:4px 10px 10px 3px;
}
.square_4 {
width: 10px;
height: 10px;
background: #2dc5a3; float:left; margin:4px 10px 10px 3px;
}
.square_5 {
width: 10px;
height: 10px;
background: #912dc5; float:left; margin:4px 10px 10px 3px;
}
.square_6 {
width: 10px;
height: 10px;
background: #c52db1; float:left; margin:4px 10px 10px 3px;
}
.square_7 {
width: 10px;
height: 10px;
background: #da892a; float:left; margin:4px 10px 10px 3px;
}
.square_8 {
width: 10px;
height: 10px;
background: #2adac3; float:left; margin:4px 10px 10px 3px;
}
.square_9 {
width: 10px;
height: 10px;
background: #421edf; float:left; margin:4px 10px 10px 3px;
}
.square_10 {
width: 10px;
height: 10px;
background: #ef5627; float:left; margin:4px 10px 10px 3px;
}
.am-panel-default > .am-panel-hd {
  color: #132a39;
  background-color: #fff;
   font-size:12px; border-bottom:1px solid #e8e8e8;
}
.am-panel {
	border: none;
}
.pay_info_bg{ height:75px; background-color:#09a9ec;}
.pay_info_bg_text{ color:#fff; font-size:15px; padding:7px 18px 0px 18px;}
.pay_info_type{ font-size:15px; color:#132a39; padding:10px 0px 10px 18px; width:100%; height:40px; background:#fff;margin-top: 5px;  border-bottom: 1px solid #e8e8e8;}
.pay_info_type .type_left{ float:left; width:73%;}
.pay_info_type .type_right{ float:left; width:22%; text-align: right; margin-right: 5%;}
@media only screen and (min-width : 360px) {.pay_info_type .type_right{ padding-left:7px;} }
@media only screen and (min-width : 375px) {.pay_info_type .type_right{ padding-left:10px;} }
@media only screen and (min-width : 414px) {.pay_info_type .type_right{ padding-left:16px;} }
.pay_info_type_1{ border-bottom:1px solid #dedede;}
.pay_info_type_1 .type_text{ font-size:14px; color:#191919; height:44px; border-bottom:1px solid #dedede;}
.pay_info_type_1 .type_text .text{ float:left; padding-top:10px;}
.pay_type_one{ width:90%; margin:0 auto;}
.pay_type_one_left{ float:left; width:15%; font-size:12px; padding:5px 0 0 0;}
.pay_type_one_right{ float:left; width:85%; font-size:12px; padding:5px 5px 5px 0px;}
.pay_type_two{ width:90%; margin:0 auto; height:auto; }
.pay_type_two_left{ float:left; width:60%; font-size:12px; padding:5px 0 5px 0;}
.pay_type_two_right{ float:right; width:30%; font-size:12px; padding:5px 0 5px 0; text-align:right;}
.consult{ margin:0 auto; width:80%; font-size:16px; color:#132a39; text-align:center; padding-top:25px; padding-bottom:25px;}
.pay_button{ width:100%; float:left; border-top:#e8e8e8 solid 1px;}
.pay_button_money{ width:55%; float:left; color:#d10e1f; font-size:16px; text-align:center; vertical-align:middle; padding-top:10px;}
.pay_button_anniu{ width:45%; float:left; background:#02bd16; font-size:16px; height:50px; padding-top:10px; text-align:center;}
.am-topbar-inverse {
  background-color: #fff;
  border-color: #fff;
  color: #eeeeee;
}
.am-topbar {
  min-height: 50px;
  background: #fff;
  border-width: 0 0 0px; 
  border-style: solid;
  border-color: #fff; 
  color: #ffffff; 
}
.showMessage{
  text-align: center;
  margin-top: 50%;
  font-size: 14px;
  color: red;
}
header {height:0;line-height: 1.6;}
.clearfix { clear:both; display:block; height:0px; overflow:hidden; }
</style>
<script type="text/javascript">
	function submitOrder() {
		document.orderform.submit();
	}
	$().ready(function() {
						$('#paySub')
								.click(
										function() {
											var $modal = $('#my-modal-loading');
											$modal.modal('open');
											var checkPayCodeUrl = "${webRoot}/pay/offlinePay.do?checkPayCode";
											$.ajax({
														type : 'POST',
														url : checkPayCodeUrl,
														data : "&openid=${openid}&payCode=${payCode}&totalpremium=${totalpremium}",
														dataType : "json",
														error : function() {// 请求失败处理函数
															$modal.modal('close');
															showError('请求失败！');
															//$btn.button('reset');
														},
														success : function(json) {
															$modal.modal('close');
															var result = "fail";
															if (json.success&&json.obj.length>5) {
																var paytext = eval('('
																		+ json.obj
																		+ ')');
																WeixinJSBridge.invoke('getBrandWCPayRequest',paytext,function(res) {
																	if (res.err_msg == 'get_brand_wcpay_request:ok') {
																		  //支付成功
																	      result = "success";
																		goToPayResult(result,res.err_msg);
																	} else {
																		showError('保费支付失败，请确认您的银行卡是否可正常使用，或者支付额度是否足够！');
																    }
																});
															} else {
																alert('微信下单失败');
															}
														}
													});
										});
					});
	function goToPayResult(result, err_msg) {
		var url = "${webRoot}/pay/offlinePay.do?showPayResult&result="
				+ result
				+ "&payCode=${payCode}&orderId=${orderId}&openid=${openid}&msg="
				+ err_msg;
		location.href = url;
	};
	//显示错误提示
	function showError(str) {
		$('#alertMessage').addClass('error').html(str);
	}
	
	$(document).ready(function(){
		$("#viewSubpremium").html($("#subpremium").val());
	});
</script>
</head>

<body>
<form id="orderform" name="orderform" action="${webRoot}/pay/payController.do?paypolicy" method="post">
		<input type="hidden" id="webroot" value="${webRoot }" /> 
		<input type="hidden" id="total_fee" name="total_fee" value="${weiXinOfflineOrderInfo.sumPremium}" /> 
		<input type="hidden" id="subject" name="subject" value="${subject }" />
		<input type="hidden" id="orderid" name="orderid" value="${weiXinOfflineOrderInfo.id}" />
		<input type="hidden" id="paytype" name="paytype" value="${paytype }" />
		<input type="hidden" id="payCode" name="payCode" value="${payCode }" />
<header data-am-widget="header" class="am-header am-header-default" >
  <div class=" am-header-nav" style="padding-top:13px;">
    <a href="#left-link" >
      <img src="${webRoot }/plug-in/fo/images/car_house_icon.jpg" width="30" height="30" alt="#"/>
    </a>
  </div>
		<h1 class="am-header-title" style=" color:#171717; ">投保信息</h1>
</header>
 <div class="pay_info_bg">
  <div class="pay_info_bg_text">被保人：${weiXinOfflineOrderInfo.insuredName}</div>
	<c:if test="${kindType eq 1}">
		<div class="pay_info_bg_text">身份证号：${weiXinOfflineOrderInfo.identifyNumber}</div>
	</c:if>
	<c:if test="${kindType eq 0}">
		<div class="pay_info_bg_text">车牌号：${weiXinOfflineOrderInfo.licenseNo}</div>
	</c:if>
 </div>
 <c:if test="${detailList.size() == 0 }">
 	<div class="showMessage">显示数据失败，请在线联系微信客服或拨打4008-518-718</div>
 </c:if>
 <c:if test="${kindType eq 1}">
	 <c:forEach items="${detailList}" var="detailListRiskName" varStatus="detailListRiskNameINX">
		 <div class="pay_info_type">
			  <div class="type_left">${detailListRiskName.key }</div>
			  <c:set var="subpremium" value="0"></c:set>
			  <c:forEach items="${detailListRiskName.value}" var="orderInfoDetails" varStatus="orderInfoDetailsINX">
			  	<c:set var="subpremium" value="${subpremium+orderInfoDetails.Premium }"></c:set>
			  </c:forEach>
			  <div class="type_right"><fmt:formatNumber value="${subpremium }" pattern="#,##0.00#" /></div>
		 </div>
	 	<c:forEach items="${detailListRiskName.value}" var="orderInfoDetails" varStatus="orderInfoDetailsINX">
			 <div class="am-panel-group" id="accordion">
			  <div class="am-panel am-panel-default">
			   <div class="am-panel-hd" data-am-collapse="{parent: '#accordion', target: '#do-not-say-${detailListRiskNameINX.index%10+1}-${orderInfoDetailsINX.index+1}'}">
				   <div class="type_text">
					   <div class="square_${orderInfoDetailsINX.index+1}"></div>
					   <div class="text">${orderInfoDetails.KindName }</div>
					   <input type="hidden" id="subpremium" name="subpremium" value="${orderInfoDetails.subpremium }"/>
				   </div>
			    </div>
			  <div id="do-not-say-${detailListRiskNameINX.index%10+1}-${orderInfoDetailsINX.index+1}" class="am-panel-collapse am-collapse am-in">
			  <c:if test="${orderInfoDetails.itemname !=null &&  orderInfoDetails.itemname != '' }">
				  <div class="pay_type_one">
				   <div class="pay_type_one_left">保障</div>
				   <div class="pay_type_one_right">${orderInfoDetails.itemname }</div>
				  </div>
			  </c:if>
			  <div class="clearfix"></div>
				  <div class="pay_type_two">
				   <div class="pay_type_two_left">保额</div>
				   <div class="pay_type_two_right"><fmt:formatNumber value="${orderInfoDetails.Amount }" pattern="#,##0.0#" /></div>
				  </div>
			   <div class="clearfix"></div>
				  <div class="pay_type_two">
				   <div class="pay_type_two_left">保费</div>
				   <div class="pay_type_two_right"><fmt:formatNumber value="${orderInfoDetails.Premium}" pattern="#,##0.0#" /></div>
				  </div>
			 	<div class="clearfix"></div>
			    </div>
			  </div>
			</div>
		</c:forEach>
	</c:forEach>
</c:if>
<c:if test="${kindType eq 0}">
	<c:forEach items="${detailList}" var="detailListRiskName" varStatus="detailListRiskNameINX">
		 <div class="pay_info_type">
			  <div class="type_left">${detailListRiskName.key }</div>
			  <c:set var="subpremium" value="0"></c:set>
			  <c:forEach items="${detailListRiskName.value}" var="orderInfoDetails" varStatus="orderInfoDetailsINX">
			  	<c:set var="subpremium" value="${subpremium+orderInfoDetails.Premium }"></c:set>
			  </c:forEach>
			  <div class="type_right"><fmt:formatNumber value="${subpremium }" pattern="#,##0.00#" /></div>
			  
		 </div>
	 	<c:forEach items="${detailListRiskName.value}" var="orderInfoDetails" varStatus="orderInfoDetailsINX">
			 <div class="am-panel-group" id="accordion">
			  <div class="am-panel am-panel-default">
			  
			   <div class="am-panel-hd" data-am-collapse="{parent: '#accordion', target: '#do-not-say-${detailListRiskNameINX.index%10+1}-${orderInfoDetailsINX.index+1}'}">
				   <div class="type_text">
					   <div class="square_${orderInfoDetailsINX.index+1}"></div>
					   <div class="text">${orderInfoDetails.KindName }
					    <span style="float: right; text-align: right;">
					    <c:if test="${orderInfoDetails.RiskKind==3}">
					    <fmt:formatNumber value="${orderInfoDetails.Premium}" pattern="#,##0.0#" />
					    </c:if>
					    </span>
					   </div>
					   <input type="hidden" id="subpremium" name="subpremium" value="${orderInfoDetails.subpremium }"/>
					   
				   </div>
				  
			    </div>
			  
			  <div id="do-not-say-${detailListRiskNameINX.index%10+1}-${orderInfoDetailsINX.index+1}" class="am-panel-collapse am-collapse am-in">
			  <c:if test="${orderInfoDetails.Nondeductible != ''}">
					<div class="pay_type_one">
						<div class="pay_type_one_left">不计免赔</div>
						<div class="pay_type_two_right">
							<c:choose>
								<c:when test="${orderInfoDetails.Nondeductible eq 'N'}">否</c:when>
								<c:when test="${orderInfoDetails.Nondeductible eq 'Y'}">是</c:when>
							</c:choose>
						</div>
					</div>
			  </c:if>
			  <div class="clearfix"></div>
			  <c:if test="${orderInfoDetails.Amount>0 }">
					<div class="pay_type_two">
						<div class="pay_type_two_left">保额</div>
						<div class="pay_type_two_right"><fmt:formatNumber value="${orderInfoDetails.Amount}" pattern="#,##0.0#" /></div>
					</div>
				</c:if>				
			  <div class="clearfix"></div>
			  <c:if test="${orderInfoDetails.RiskKind!=3}">
			  	<div class="pay_type_two">
					<div class="pay_type_one_left">保费</div>
					<div class="pay_type_two_right"><fmt:formatNumber value="${orderInfoDetails.Premium}" pattern="#,##0.0#" /></div>
			  	</div>
			 	<div class="clearfix"></div>
			 	</c:if>
			    </div>
			  </div>
			</div>
		</c:forEach>
	</c:forEach>
</c:if>
<input  type="hidden" id="totalpremium" name="totalpremium" value="${totalpremium}"/>
<div class="pay_page_tips" id="alertMessage" style="color: red; clear: both; text-align: center; margin: 0 auto; width: 90%;">${message }</div>
 <header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
  <div class="pay_button">
   <div class="pay_button_money">￥ ${weiXinOfflineOrderInfo.sumPremium}</div>
	   <c:if test="${paytype eq 'alipay' }">
		    <div class="pay_button_anniu" onclick="submitOrder()">支付宝支付</div>
	   </c:if>
	   <c:if test="${paytype eq 'wxpay' }">
		    <div class="pay_button_anniu" id="paySub">微信支付</div>
	  </c:if>
  </div>
 </header>
 <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">下单中...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>
 </form>
 <script>
  $(function() {
    var $modal = $('.am-modal-no-btn');

    $modal.siblings('.am-btn').on('click', function(e) {
      var $target = $(e.target);
      if (($target).hasClass('js-modal-open')) {
        $modal.modal();
      } else if (($target).hasClass('js-modal-close')) {
        $modal.modal('close');
      } else {
        $modal.modal('toggle');
      }
    });
  });
</script>
	
</body>
</html>