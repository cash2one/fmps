<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>加油宝活动</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${webRoot }/plug-in/gasolinegift/css/two.css" />
</head>

<body>
 <form class=" am-form-horizontal" name="payForm" id="payForm" action="${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?applyMyGasolinegift" method="post">
 <div><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_two_bg.jpg" /></div>
 <div class="input_1"><input class="input_12" name="mobile" id="mobile" type="text" size="13"  /></div>
 <div class="input_2"><input class="input_13" name="licenseno" id="licenseno" type="text" size="10"  /></div>
 
 <div class="input_1"><input class="input_12" name="mobile" id="mobile" type="checkbox" size="13"  /></div>
 <div class="input_2"><input class="input_13" name="licenseno" id="licenseno" type="text" size="10"  /></div>
 
 <div class="input_3"><input type="text" class="am-form-field" name="dynamicpasswordother" id="dynamicpasswordother" placeholder="请输入验证码"></div>
 <div class="oil_text_code"><input type="button" class="btn-checkcode" id="getDynamicPasswordOther" name="getDynamicPasswordOther" onclick="sendDynamicPassword(this, $('#mobile'), $('#alertMessage'),'${openid}');" value="获取验证码"   /></div>
 <div class="oil_text_tips" id="alertMessage"></div>
 <div class="oil_button"><a href="javascript:void(0);" id="paySub"><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_two_button.jpg" /></a></div>
 <div class="oil_bottom">Copyright © 富邦财险</div>
 </form>
 <script type="text/javascript">
 	var result = true;
		$().ready(function() {
			$('#paySub').click(function() {
				CheckMobile();
				CheckLicenseno();
				if(result){
					var actionurl = $('form').attr('action');//提交路径
					location.href = actionurl;
					}
		   		});
		});
		//显示错误提示
		function showError(str) {
			$('#alertMessage').addClass('error').html(str);
		}
		function CheckMobile(){
			var mobile = $('#mobile').val();
			var re=/^1[0-9]{10}$/; 
			if(!re.test(mobile)){
			 $("#mobile").focus();
			 	showError('**手机号格式不对！');
			 	result = false; 
			}
		}
		function CheckLicenseno(){
			var licenseno = $('#licenseno').val();
			if(licenseno==null || licenseno ==''){
				$("#licenseno").focus();
				showError('**车牌号不为空！');
				result = false;
			}
		}
	</script>
<script src="${webRoot}/plug-in/fo/js/customerbind/customerBind.js?vesion=2"></script>
</body>
</html>