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
  <link rel="stylesheet" href="${webRoot }/plug-in/gasolinegift/css/one.css" />
  <script type="text/javascript">
  	 
  </script>
  
  <script type="text/javascript">
	$(function(){
		$("#applyBtn").on("click",function(){	  
			if("false"=='${isbind}'){
				//提示并跳转到认证地址
				if(confirm("此优惠仅限富邦客户申请使用。如您是富邦客户请先认证再申请，保单生效后第二天才可认证。跳转认证？")){
					btnLink = "${webRoot }/fo/customerBindController.do?method=bindIndex&requestPath=fo/binded/gasolinegift/gasolinegiftController.do?isEligibility";
					location.href = btnLink;
				}
				return;
			} 
			location.href = "${webRoot }/fo/binded/gasolinegift/gasolinegiftController.do?isEligibility";
		});
	})
  </script>
</head>

<body>
 <div>
    <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
    <img src="${webRoot }/plug-in/gasolinegift/images/new_oil_top.jpg" />
    </c:if>
    <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
     <img src="${webRoot }/plug-in/gasolinegift/images/new_oil_top_2.jpg" />
    </c:if>
 </div>
 <div class="oil_bg">
  <div class="oil_superiority_1">
   <div class="oil_superiority_img"><img src="${webRoot }/plug-in/gasolinegift/images/oil_icon_1.png" />
   </div>
   <div class="oil_superiority_text"><span class="title">优势</span><br /><br /><span class="center">使用无门槛、加油金额无上限，加越多赚越多.</span></div>
  </div>
  
  <div class="oil_superiority_1">
   <div class="oil_superiority_img"><img src="${webRoot }/plug-in/gasolinegift/images/oil_icon_2.png" /></div>
   <div class="oil_superiority_text"><span class="title">折扣</span><br /><br />
    <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
     <span class="center">厦门、福州、泉州、漳州地区的客户全年享9.5折<br /></span>
    </c:if>
    <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
     <span class="center">成都、重庆地区客户全年享受9.7折<br /></span>
    </c:if>
   </div>
  </div>
  
  <div class="oil_superiority_1">
   <div class="oil_superiority_img"><img src="${webRoot }/plug-in/gasolinegift/images/oil_icon_3.png" /></div>
   <div class="oil_superiority_text"><span class="title">返利方式</span><br /><br />
   <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
   <span class="center">即充即返，如要充值1000元油费实际只需缴费950元<br /></span>
    </c:if>
    <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
   <span class="center">即充即返，如要充值1000元油费实际只需缴费970元<br /></span>
    </c:if>
   </div>
  </div>
  
  <div class="oil_superiority_1">
   <div class="oil_superiority_img"><img src="${webRoot }/plug-in/gasolinegift/images/oil_icon_4.png" /></div>
   <div class="oil_superiority_text"><span class="title">充值方式</span><br /><br />
   <span class="center">银联卡在线支付、微信支付</span>
   </div>
</div>

  <div class="oil_superiority_1">
   <div class="oil_superiority_img"><img src="${webRoot }/plug-in/gasolinegift/images/oil_icon_5.png" /></div>
   <div class="oil_superiority_text"><span class="title">使用范围</span><br /><br /><span class="center">全国中石化网点均可使用</span></div>
  </div>
  <div><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_bg_bottom.jpg" /></div>
  </div>
    <div class="oil_details">
    <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
    <a href="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=401287057&idx=1&sn=3f9a3fd044dfbe83972a7d010ae3fa17#rd">
    </c:if>
    <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
   <a href="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=403058935&idx=1&sn=25a2e4827604f855c237f374b2f80da7#rd">
    </c:if>
    <img src="${webRoot }/plug-in/gasolinegift/images/new_oil_bg_botton.jpg" />
    </a>
    </div>
    <div class="oil_one_button"><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_one_button.jpg" id="applyBtn"/></div>
</body>
</html>