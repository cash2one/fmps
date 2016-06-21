<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
.shop_confirm{ padding:0 20px;}
.shop_confirm_border{ border:1px solid #e8e8e8; border-radius: 3px; margin-top:50px;}
.shop_confirm_border .confirm_text_1{ font-size:12px; text-align:left; color:#292929; padding-top:40px; padding-left:24px; line-height:28px;}
.shop_confirm_border .confirm_text_2{ font-size:12px; text-align:left; color:#292929; padding-left:24px; line-height:28px;}
.shop_confirm_border .confirm_text_3{ font-size:12px; text-align:left; color:#292929; padding-left:24px; line-height:28px;}
.shop_confirm_border .confirm_text_4{ font-size:12px; text-align:left; color:#292929; padding-left:24px; padding-bottom:35px; line-height:28px;}
.confirm_anniu{ margin:0 auto; width:85%; background-color:#0e90d2; color:#fff; text-align:center; padding-top:10px; padding-bottom:10px; font-size:14px; border-radius: 5px; margin-bottom:40px;}
 </style>
<script type="text/javascript">
   $().ready(function () {
	if('${isPaid}'=='true'){  //已经支付过了 
		 $('#pay').removeAttr('onclick'); //避免重复支付 
		 $("#payText").text('此单已经支付！');	
	   }
	  var totalFee=parseInt(${totalFee})/100;
	   $("#totalFee").text('金额：'+totalFee+'元');	 	
	});
  function pay () {			
			 $('#pay').removeAttr('onclick'); //避免重复支付 
			 $("#payText").text('支付中...');
			var checkPayCodeUrl = "${webRoot}/pay/fcpsPay.do?wechatPay";
			$.ajax({
				type : 'POST',
				url : checkPayCodeUrl,
				data : "&openid=${openid}&fmcpPayCode=${fmcpPayCode}&totalFee=${totalFee}&policyInfo=${policyInfo}&fmcpPayAttach=${fmcpPayAttach}",
				dataType : "json",
				error : function() {// 请求失败处理函数
					showError('请求失败！');			
				},
				success : function(json) {
					var result = "fail";
					if (json.success&&json.obj.length>5) {	
						alert(json.obj);
						var paytext = eval('(' + json.obj + ')');					
						WeixinJSBridge.invoke('getBrandWCPayRequest',paytext ,function(res){
							if(res.err_msg == 'get_brand_wcpay_request:ok'){
								//支付成功								
								goToPayResult("success",res.err_msg);
							}else{
								alert(res.err_msg);
								goToPayResult("failure","支付失败");
								}
						 });						
					} else {
						  alert('微信下单失败');						 				
					}
				}
			});
		 };
		
		function goToPayResult(result, err_msg) {
			var url = "${notify_url}&result="+result +"&fmcpPayCode=${fmcpPayCode}&msg="+ err_msg;
		    location.href = url;
		};
		//显示错误提示
		function showError(errMsg) {
		   var url = "${fail_url}&fmcpPayCode=${fmcpPayCode}&errMsg="+errMsg;
		     
		     location.href = url;
		}
	</script>
	
</head>
<body>
<div class="shop_confirm">
  <div class="shop_confirm_border">
   <div class="confirm_text_1">付款商户：富邦财产保险有限公司</div>
   <div class="confirm_text_2">商品名称：${policyInfo}</div>
   <div class="confirm_text_3" id="totalFee"></div> 
  <a   onclick="pay()"   id="pay" >  <div class="confirm_anniu"  id="payText" >确认</div> </a>   
  </div>
 </div>

<!-- 
<p>-------------------------</p>
<p>isPaid:${isPaid}</p>
<p>fmcpPayCode:${fmcpPayCode}</p>
<p>totalFee:${totalFee}</p>
<p>policyInfo:${policyInfo}</p>
<p>fmcpPayAttach:${fmcpPayAttach}</p>
<p>notify_url:${notify_url}</p>
<p>openid:${openid}</p>

  <% if (userAgent.indexOf("MicroMessenger") <= -1) { %>
  <div>支付宝支付</div>
  <%} else { %>
   <div>微信支付</div>
   <button type="button" class="am-btn am-btn-primary am-btn-lg am-btn-block"	id="paySub">确 认</button>
   <%} %>

  -->
</body>
</html>	
