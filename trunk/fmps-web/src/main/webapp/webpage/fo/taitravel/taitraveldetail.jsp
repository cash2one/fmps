<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%> 
<%@ include file="/webpage/fo/common/mobiscroll.jsp"%> 
<!doctype html>
<html class="no-js">
<head>
  <title>富邦财险</title>
  <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script> 
</head>

<style type="text/css">
.am-selected-btn {
text-align: right;
width: 100px;
}


.am-btn-default {
border:0px;
}

.am-btn {
display: inline-block;
margin-bottom: 0;
padding: 0.225em 1em;}

.am-btn-primary{ width:96%;}
img{ 
  max-width: 100%;
  height: auto;
   }
   
header {
  height: 50px;
  line-height: 0px;
  }
  
.am-topbar {
  position: none;
  min-height: 0px;
  margin-bottom: 0rem;
  }
  .am-btn-success {
  color: #fff;
  background-color: #f8a3a8;
  border: 0px;
}
.input::-ms-clear { display: none; }
.input:valid + .clear { display: inline; }
  

.am-header .am-header-title {
  margin: 0 20%;}
.am-form-field {

  padding: 0em;

}
</style>
<body>
<!--[if lte IE 9]>

<![endif]-->

<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title" >
    赴台旅游
    </h1>
  </header>

</header>


<div class="am-cf admin-main">
  <!-- sidebar start -->


  <!-- content start -->
  <div class="admin-content">
    


<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title">被保人信息</h2>

</div>
<div style="width:94%; margin:0 auto; border-bottom:1px solid #ddd; height:auto; margin-bottom:10px; font-size:0.825em; padding:5px 0px 5px 5px;">        
姓名：${customerg.name }
<br/>证件类型：<c:if test="${customerg.identifytype =='01'  }">身份证 </c:if><c:if test="${customerg.identifytype =='99'  }">其它 </c:if>
<br/>证件号码：${customerg.identifynumber }
<br/>手机：${customerg.phone }
<br/>学校：${customerg.school }
 <br/>常用地址：${customerg.province }${customerg.city }${customerg.area }${customerg.detail }
</div>

<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title">投保方案</h2>

</div>
<div style="width:94%; margin:0 auto; border-bottom:1px solid #ddd; height:auto; margin-bottom:10px; font-size:0.825em; padding:5px 0px 5px 5px;">        
方案名称：${customerg.schemetype }
<br/>保障期限：${customerg.period }
<br/>保费：${customerg.premium }元
</div>

<button type="button" style="height:45px;   width: 100%;" class="am-btn am-btn-primary am-btn-lg am-btn-block"  id="paySub">确认</button>

   <div id="alertMessage" style="color: red; text-align: left; text-indent: 10px;" ></div>
    
  </div>

  <!-- content end -->
<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title">温馨提示</h2>

</div>
<div style="width:90%; margin:0 auto;">请确认您的投保信息，如无误，请支付保费。</div>
</div>

<script>
//保费支付 
$(document).ready(function () {
		$('#paySub').click(function () {
				    $("#paySub").attr("disabled","disabled");
			var checkPayCodeUrl = "${webRoot}/pay/taipayController.do?payStuP";
			var schemetype="富邦赴台学生专案";
			$.ajax({
				type : 'POST',
				url : checkPayCodeUrl,
				data : "&openid=${openid}&premium=${premium}&schemetype="+schemetype+"&id=${id}&name=${customerg.name}&phone=${customerg.phone}",
				dataType : "json",
				error : function() {// 请求失败处理函数
					showError('请求失败！');
					$('#paySub').removeAttr("disabled");
				},
				success : function(json) {
					if (json.success) {
						
						var paytext = eval('(' + json.obj + ')');						
						WeixinJSBridge.invoke('getBrandWCPayRequest',paytext ,function(res){
							if(res.err_msg == 'get_brand_wcpay_request:ok'){
								//支付成功
								result="success";
								goToPayResult(result,res.err_msg);
								$('#paySub').removeAttr("disabled");
							}else{
								showError('保费支付失败，请确认您的银行卡是否可正常使用，或者支付额度是否足够！');
								
								var msg=res.err_msg;
								$.ajax({
									type : 'POST',
									url : "${webRoot}/pay/taipayController.do?goToPayResultfail",
									data : "&openid=${openid}&id=${id}&msg="+msg,
									dataType : "json",
									success : function(json) {
										
									}
								});
								$('#paySub').removeAttr("disabled");
							}
						 });
						} else {
						showError(json.err_msg);
						$('#areaSelect').removeAttr("disabled");
					}
				}
			});
		 });
		});

		function goToPayResult(result, err_msg) {
			var url = "${webRoot}/pay/taipayController.do?showPayResult&result="
					+ result + "&payCode=${payCode}&id=${id}&openid=${openid}&msg="
					+ err_msg;
			location.href = url;
		};
		//显示错误提示
		function showError(str) {
			$('#alertMessage').addClass('error').html(str);
		}

</script>

<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<script src="${webRoot}/plug-in/amaze-ui/js/app.js"></script>
</body>
</html>
