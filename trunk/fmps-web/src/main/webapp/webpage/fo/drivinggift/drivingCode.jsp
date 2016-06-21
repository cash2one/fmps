<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>代驾券</title>
<meta name="description" content="这是一个 user 页面">
<meta name="keywords" content="user">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link type="text/css" href="${webRoot}/plug-in/drivinggift/css/spring_e_drive.css" rel="stylesheet" />
</head>
<script type="text/javascript">
	$().ready(function(){
			var userInfoUrl = "${webRoot}/fo/drivingGifeController.do?getUserInfo";
			$.ajax({
				type : 'POST',
				url : userInfoUrl,
				data : "&huodongid=${huodongid}&openid=${openid}",
				dataType : "json",
				error : function() {// 请求失败处理函数
					showError('请求失败！');
				},success : function(json) {
							if (json.success) {
								var info = json.obj;
								var str = '';
				                if(info != null){
				                	for(var i=0;i<info.length;i++){
				                		if(info[i].amount != null && info[i].nickname != ""){
				                			str+='<div class="e_regular_list"><div class="img"><img src="'+info[i].headimgurl+'" style=" width:30px; height:30px; border-radius:15px;" /></div>';
				                			str+='<div class="name">'+info[i].nickname+'</div>';
				                			str+='<div class="time">'+info[i].starttime+'</div>';
				                			str+='<div class="price">'+info[i].amount+'元</div>';
				                			str+='</div>';
				                		}
				                	}
				                	$("#viewName").html(str);
				                }else{
				                	str+='获取数据失败！';
				                	showError(json.msg);
				                }
							} else {
								showError(json.msg);
							}
						}
					});
			});
	//显示错误提示
	function showError(str) {
		$('#alertMessage').addClass('error').html(str);
	}
</script>
<body>


  <div class="spring_center"></div>
  <div class="spring_center_img">
    <div><img src="${webRoot}/plug-in/drivinggift/images/spring_center_img_bg.png"  style="width:100%;"/></div>
    <div class="ticket_text">${amount }元代驾券</div>
    <div class="nbsp"></div>
    <div class="receive_1"><a href="#" style="color: #fff">${externalno }</a></div>
    <div class="nbsp"></div>
     <div class="middle">
      <a href="http://h5.edaijia.cn/app/index.html?from=01051269" ><div class="left">立即下单</div></a>
      <a href="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=401497196&idx=1&sn=96ddb35f119dfeb8afa9c2cb2246b08f#rd"><div class="right">如何使用</div></a>
     </div>
  </div>
  
  <div class="e_regular">
  <div class="e_regular_title">使用规则：</div>
  <div class="e_regular_title_center">
   仅限绑定后7日内使用，结算代驾费时会自动扣除，不与其他优惠累计，不设找零.<br />
   <br />
   ● 随机代驾券金额：5元、9元、19元、29元、39元<br />
   ● 本活动仅限富邦微信认证客户，未认证的富邦用户请<a href="${webRoot}/fo/customerBindController.do?method=bindIndex&openid=${openid}"><span style="color:#fcb82c;">点此认证</span></a><br />
   ● 每周只能领取一次，有效期7天，过期可再重复领 <br />
   ● 通过e代驾电话下单不能使用<br />
   ● 本活动不支持e代驾vip用户<br /> 
   ● 本活动严禁刷单，一经发现，代驾券作废<br />
  </div>
  <div class="e_regular_title_xian">&nbsp;</div>
  <div class="e_regular_title">看看小伙伴们的手气</div>
  <div id="viewName" class="viewName"></div> 
 </div>
</body>
</html>