<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <%@ include file="/webpage/fo/common/fotags.jsp"%>
    <title>加油宝</title>
    <script type="text/javascript">
    window.pt = 'wx';

    function $getCookie(name) {
        //读取COOKIE
        var reg = new RegExp("(^| )" + name + "(?:=([^;]*))?(;|$)"),
            val = document.cookie.match(reg);
        return val ? (val[2] ? unescape(val[2]) : "") : null;
    }

    function $getQuery(name, url) {
        //参数：变量名，url为空则表从当前页面的url中取
        var u = arguments[1] || window.location.search,
            reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"),
            r = u.substr(u.indexOf("\?") + 1).match(reg);
        return r != null ? r[2] : "";
    }
	
    window.debug = $getQuery('debug') == '1'?true:false;
    if (!$getQuery('code')) {
        var url = url || location.href.replace(/[?|&]code=[^&]*/g, '').replace(/[?|&]state=[^&]*/g, '').replace(/#.*/, '');
        /*location.href = 'http://open.weixin.qq.com/connect/oauth2/authorize?appid=wx47031447c8352579&redirect_uri=' + encodeURIComponent(url) + '&response_type=code&scope=snsapi_base&state=qqchongzhi#wechat_redirect';*/
    }

    (function(doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function() {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                var docElWidth = 100 * (clientWidth / 320);
                if (docElWidth > 200) docElWidth = 200;
                console.log(docElWidth);
                docEl.style.fontSize = docElWidth + 'px';
                };

        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);
    </script>
    <link rel="stylesheet" href="${webRoot}/plug-in/gasolinegift/css/new_index.css">
  <script type="text/javascript">
  
  function detailsDescription(){
	   var url="";	   
	   if('${cityCode}'=='510100'||'${cityCode}'=='500000'){  //四川或重庆
		   url="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=403058935&idx=1&sn=25a2e4827604f855c237f374b2f80da7#rd";  
	   }else{
		   url="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=401287057&idx=1&sn=3f9a3fd044dfbe83972a7d010ae3fa17#rd"; 
	   }
	   location.href=url;
  }
    
  function applyOil(){	  
	  if("false"=='${isbind}'){
			//提示并跳转到认证地址
			if(confirm("此优惠仅限富邦客户申请使用。如您是富邦客户请先认证再申请，保单生效后第二天才可认证。跳转认证？")){
				btnLink = "${webRoot }/fo/customerBindController.do?method=bindIndex&requestPath=fo/binded/gasolinegift/gasolinegiftController.do?isEligibility";
				location.href = btnLink;
			}
			return;
		} 
		location.href = "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?isEligibility&openid=${openid}&channel=${channel}&cityCode=${cityCode}"; 
	  }
  
  function myOilCar(){
	  
	  location.href = "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?oilCard&openid=${openid}"; 
   }
  
  </script>
</head>

<body>
 <section class="container wx">
  <div class="container-hd">
    <div><img src="${webRoot}/plug-in/gasolinegift/images/new_index_top.jpg" alt="#" /></div>
      <i class="apply_but but"></i>       
       <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
              <div class="apply_text_2">加油95折优惠仅限富邦客户申请使用</div> 
         </c:if>
         <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
              <div class="apply_text_2">加油98折优惠仅限富邦客户申请使用</div>        
         </c:if>
      
      <!--top-->
      <div class="box">
       <div class="box_left"><i class="box_left_1 left_1"></i>&nbsp;</div>
       <div class="box_right">
        <div>优势</div>
        <div class="right_col">使用无门槛、加油金额无上限，加越多赚越多</div> 
       </div>
      </div>
      
      <div class="box">
       <div class="box_left"><i class="box_left_2 left_2"></i>&nbsp;</div>
       <div class="box_right">
        <div>折扣</div>
         <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
             <div class="right_col">厦门、福州、泉州、漳州地区的客户全年享受9.5折</div> 
         </c:if>
         <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
             <div class="right_col">成都、重庆地区客户全年享受9.8折</div>        
         </c:if>
       </div>
      </div>      
      <div class="box">
       <div class="box_left"><i class="box_left_3 left_3"></i>&nbsp;</div>
       <div class="box_right">
        <div>返利方式</div>
         <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
            <div class="right_col">即充即返，如要充值1000元油费实际只需缴费950元</div>          
         </c:if>
         <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
             <div class="right_col">即充即返，如要充值1000元油费实际只需缴费980元</div>         
         </c:if>
       </div>
      </div>
      
      <div class="box">
       <div class="box_left"><i class="box_left_4 left_4"></i>&nbsp;</div>
       <div class="box_right">
        <div>充值方式</div>
        <div class="right_col">支持银联卡在线支付、微信支付</div> 
       </div>
      </div>
      
      <div class="box">
       <div class="box_left"><i class="box_left_5 left_5"></i>&nbsp;</div>
       <div class="box_right">
        <div>使用范围</div>
        <div class="right_col">全国中石化网点均可使用</div> 
       </div>
      </div>
      <a onclick="detailsDescription()" ><div class="del_button del"></div></a> 
   
     <!-- 
      <a onclick="applyOil()" ><div class="apply_button apply"></div></a>
     -->
    
     <div class="index_title title"></div>

    <div class="apply_text_1">本加油卡的折扣和充值等服务均由第三方和信华通服务有限公司提供，相关服务和责任将由该第三方承担。如有问题请致电该第三方客服<br/><span class="col">0592-2233870</span></div>   
     <div class="card_button">
      <div class="card_left"><img onclick="applyOil()"  src="${webRoot}/plug-in/gasolinegift/images/button_left.png" alt="#"/></div>
      <div class="card_right"><img onclick="myOilCar()"  src="${webRoot}/plug-in/gasolinegift/images/button_right.jpg" alt="#"/></div>
     </div>
     </div>
 </section>
</body>
</html>
