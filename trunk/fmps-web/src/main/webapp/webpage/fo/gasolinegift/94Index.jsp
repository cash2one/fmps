<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <link rel="stylesheet" href="${webRoot }/plug-in/gasolinegift/css/new_index_94.css">
    <title>94加油宝</title>    
    <script src="${webRoot}/plug-in/fo/js/gasolinegift/pageControl.js"></script>
    <script type="text/javascript">
   
    function submitApply(){    	
    	//手机号校验  
    	var mobile = $('#mobile').val();
    	var re=/^1[0-9]{10}$/; 
    	if(!re.test(mobile)){
    	 $("#mobile").focus();
    	 	alert('**手机号格式不对！');
    	 	return false;
    	}	    	
    	location.href ="${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?isEligibility&openid=${openid}=&channel=${channel}&cityCode=${cityCode}&mobile="+mobile;
      } 
    function myOilCar(){  	  
  	  location.href = "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?oilCard&openid=${openid}"; 
       }
    
    function goToQA(){ 
    	location.href = "http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=504507579&idx=1&sn=b76b235d5836757df17515ce408a625d#rd";
           }
    
    
    </script>
   </head>

<body>
 <section class="container wx">
  <div class="container-hd">
    <div><img src="${webRoot }/plug-in/gasolinegift/images/new_index_94.jpg" alt="#" /></div>
      <i class="apply_but but"></i> 

      <div class="apply_text_2">恭喜您获得<span class="col">《奔跑吧私家车》</span>为您提供的加油返利优惠！</div>
      
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
        <div class="right_col">厦门、福州、泉州、漳州地区的客户全年享受9.5折</div> 
       </div>
      </div>
      
      <div class="box">
       <div class="box_left"><i class="box_left_3 left_3"></i>&nbsp;</div>
       <div class="box_right">
        <div>返利方式</div>
        <div class="right_col">即充即返，如要充值1000元油费实际只需缴费950元</div> 
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
      
      <div onclick="goToQA()"  class="del_button del"></div>
     
 
     <div class="form">
      <div class="form_1">
       <div class="form_1_left">手机号：</div>
       <div class="form_1_right"><input class="form_input" id="mobile"  name="mobile" type="text" placeholder="请输入您预留的手机号"></div>
      </div>
            
     <!-- 
       <div class="form_4">
       <div class="form_4_left">验证码：</div>
       <div class="form_4_middle"><input class="form_input"  name="" type="text" placeholder="验证码" style="width:0.9rem;"></div>
       <div class="form_4_right">获取验证码</div>
      </div> -->
     
      
     </div>
     <div class="index_title title"></div>
    <div class="apply_text_1">本加油卡的折扣和充值等服务均由第三方和信华通服务有限公司提供，相关服务和责任将由该第三方承担。如有问题请致电该第三方客服<br/><span class="col">0592-2233870</span></div>
     </div>
     
      <div class="card_button">
      <div class="card_left"><img onclick="submitApply()"  src="${webRoot}/plug-in/gasolinegift/images/button_left.png" alt="#"/></div>
      <div class="card_right"><img onclick="myOilCar()"  src="${webRoot}/plug-in/gasolinegift/images/button_right.jpg" alt="#"/></div>
     </div>
     <%-- 
     <div class="card_button"><img  onclick="submitApply()"  src="${webRoot }/plug-in/gasolinegift/images/card_bottom.jpg" alt="#"/></div>
      --%>
 </section>
</body>
</html>
