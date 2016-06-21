<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
  <style type="text/css">
    .am-table > thead > tr > th,
    .am-table > tbody > tr > th,
    .am-table > tfoot > tr > th,
    .am-table > thead > tr > td,
    .am-table > tbody > tr > td,
    .am-table > tfoot > tr > td {
      padding: 0.1rem;
      line-height: 1.6;
      vertical-align:middle;
      border-top: 1px solid #dddddd;
    }
    .am-titlebar {
      margin-top: 1px;
      height: 45px;
      font-size: 100%;
    }
  </style>
	<script type="text/javascript">
	$().ready(function () {
		$('#paySub').click(function () {
			//alert("enter");
			//var $btn = $(this);
			//$btn.button('loading');
			 //var x_json = ${json};
			var checkPayCodeUrl = "${webRoot}/pay/offlinePay.do?checkPayCode";
			$.ajax({
				type : 'POST',
				url : checkPayCodeUrl,
				data : "&openid=${openid}&payCode=${payCode}",
				dataType : "json",
				error : function() {// 请求失败处理函数
					showError('请求失败！');
					//$btn.button('reset');
				},
				success : function(json) {
					var result = "fail";
					if (json.success) {	
						var paytext = eval('(' + json.obj + ')');
						//alert(x_json);
						//alert(paytext);
						WeixinJSBridge.invoke('getBrandWCPayRequest',paytext ,function(res){
							if(res.err_msg == 'get_brand_wcpay_request:ok'){
								//支付成功
								result="success";
								goToPayResult(result,res.err_msg);
							}else{
								showError('保费支付失败，请确认您的银行卡是否可正常使用，或者支付额度是否足够！');
								//$btn.button('reset');
							}
						 });
						//goToPayResult('success', 'get_brand_wcpay_request:ok');
					} else {
						showError(json.err_msg);
						//$btn.button('reset');
					}
				}
			});
		 });
		});
		function goToPayResult(result, err_msg) {
			var url = "${webRoot}/pay/offlinePay.do?showPayResult&result="
					+ result + "&payCode=${payCode}&orderId=${orderId}&openid=${openid}&msg="
					+ err_msg;
			location.href = url;
		};
		//显示错误提示
		function showError(str) {
			$('#alertMessage').addClass('error').html(str);
			//$btn.button('reset'); 
		}
	</script>
</head>
<body>
	 <header data-am-widget="header" class="am-header am-header-default">
	    <h1 class="am-header-title">
	      保费信息
	    </h1>
	  </header>
	
	<div class="am-cf admin-main">
 	<!-- sidebar start -->

	  <!-- content start -->
	  <div class="admin-content">
	  	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
 		 	<h2 class="am-titlebar-title">用户信息</h2>
		</div>
		<c:if test="${kindType eq 0}">
		<%-- 车险 --%>
			<div style="width:94%; margin:0 auto; border-bottom:1px solid #ddd; height:auto; margin-bottom:10px; font-size:0.825em; padding:5px 0px 5px 5px;">        
				被投保人：${weiXinOfflineOrderInfo.insuredName}<br/>
				车牌号：${weiXinOfflineOrderInfo.licenseNo}
			</div>
			
		    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
			 	 <h2 class="am-titlebar-title">险种信息</h2>
			</div>
			
			<div class="am-g">
    		  <div class="am-u-sm-12">
		        <form class="am-form">
		          <table class="am-table am-table-striped am-table-hover table-main">
		            <thead>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">险种名称</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">不计免赔</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">保障</div>
		              <div style="width:25%; float:left; text-align:center; color:#0099FF;">费用</div>
		            </thead>
		            <tbody>
		              <c:forEach  items="${weiXinOfflineOrderInfo.weiXinOfflineOrderDetails}"  var="orderInfoDetails">
						 <tr>
			              <td style="width:25%;  text-align:center; font-size:14px;">${orderInfoDetails.kindName }</td>
			              <td style="width:25%;  text-align:center;">
							<c:choose>
								<c:when test="${orderInfoDetails.nondeductible eq 'N'}">
									否
								</c:when>
								<c:when test="${orderInfoDetails.nondeductible eq 'Y'}">
									是
								</c:when>
							</c:choose>
						  </td>
			              <td style="width:25%;  text-align:center;">
							<fmt:formatNumber value="${orderInfoDetails.amount}" pattern="#,##0.00#" />
						  </td>
			              <td style="width:25%;  text-align:center;">
						  	<fmt:formatNumber value="${orderInfoDetails.premium}" pattern="#,##0.00#" />
						  </td>
			           	 </tr>
		           	  </c:forEach>
     	  		        <tr style="width:100%;">
			              <td style="width:25%;  text-align:center; font-size:14px; color:#FF6600;">合计</td>
			              <td style="width:25%;  text-align:center;"></td>
			              <td style="width:25%;  text-align:center;"></td>
			              <td style="width:25%;  text-align:center; color:#FF6600;">${weiXinOfflineOrderInfo.sumPremium} </td>
			            </tr>
		          	</tbody>
		          </table>  
       			</form>
       		  </div>
  		  </div>
		</c:if>
		
		<c:if test="${kindType eq 1}">
		<%-- 非车险 --%>
			<div style="width:94%; margin:0 auto; border-bottom:1px solid #ddd; height:auto; margin-bottom:10px; font-size:0.825em; padding:5px 0px 5px 5px;">        
				被投保人：${weiXinOfflineOrderInfo.insuredName}<br/>
				证件号码:${weiXinOfflineOrderInfo.identifyNumber}
			</div>
			
		    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
			 	 <h2 class="am-titlebar-title">险种信息</h2>
			</div>
			
			<div class="am-g">
    		  <div class="am-u-sm-12">
		        <form class="am-form">
		          <table class="am-table am-table-striped am-table-hover table-main">
		            <thead>
		              <div style="width:70%; float:left; text-align:left; color:#0099FF;">险种名称</div>
		              <div style="width:30%; float:left; text-align:left; color:#0099FF;">费用</div>
		            </thead>
		            <tbody>
		             <c:forEach	items="${weiXinOfflineOrderInfo.weiXinOfflineOrderDetails}" var="orderInfoDetails">
						 <tr>
			              <td style="width:70%;  text-align:left; font-size:14px;">${orderInfoDetails.kindName }</td>
			              <td style="width:30%;  text-align:left;">
						  	<fmt:formatNumber value="${orderInfoDetails.premium}" pattern="#,##0.00#" />
						  </td>
			           	 </tr>
		           	  </c:forEach>
		           	   <tr style="width:100%;">
			              <td style="width:70%;  text-align:left; font-size:14px; color:#FF6600;">合计</td>
			            
			              <td style="width:30%;  text-align:left; color:#FF6600;"> ${weiXinOfflineOrderInfo.sumPremium}</td>
			            </tr>
		          	</tbody>
		          </table>  
       			</form>
       		  </div>
  		  </div>
		</c:if>
		<div class="am-cf">
			<button type="button" class="am-btn am-btn-primary am-btn-lg am-btn-block"	id="paySub">确 认</button>
	    </div>
		
	</div>
	 <!-- /admin-content end -->
	<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
	  <h2 class="am-titlebar-title">温馨提示</h2>
	</div>
	<div style="width:90%; margin:0 auto;">请确认您的保单信息，如无误，请支付保费。</div>
 </div>	<!-- /am-cf admin-main -->

</body>