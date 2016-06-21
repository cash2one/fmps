<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
 <style type="text/css">
    [data-am-widget='tabs']
    { margin: 0px 0px -5px 0px; 
    }
	.am-navbar{
	height:51px;
	}
	.am-tabs-bd{
	border:0px;
	}
</style>
</head>
<body>
<script type="text/javascript"> 
$(function () {
	$('.Service_text').click(function() {
		location.href = "${webRoot}/plug-in/weixin/image/daolu.html#mp.weixin.qq.com";//解决微信屏蔽tel
	});
	$('#lpsmsj').click(function() {
		location.href = "${webRoot}/plug-in/huodong/claim/Inbox.html#mp.weixin.qq.com";//解决微信屏蔽tel
	});
	$('#service_addr').click(function() {
		location.href = "${webRoot}/fo/serviceBranch.do?list#mp.weixin.qq.com";//解决微信屏蔽tel
	});
})
</script>
  <!--  服务		-->
  <header data-am-widget="header" class="am-header am-header-default">
   <h1 class="am-header-title">
    <a href="#title-link" class="">个人信息</a>
  </h1>
 </header>
 <div class="user_bg">
 	 <div style="height:18px;"></div>
	 <div class="user_touxiang">
	 	<img src="${headimgurl}"  width="54" height="54" style="-webkit-border-radius:50px; -moz-border-radius:50px; -o-border-radius:50px;border-radius:50px;">
	 </div>
	 <div class="name_text"><h2 class="am-header-title">${nickname}</h2></div>
 </div>
 
 <div data-am-widget="tabs" class="am-tabs am-tabs-default"  id="doc-my-tabs">
  <div class="am-tabs-bd ">
       <!-- 服务 -->
    <div  data-tab-panel-1 class="am-tab-panel am-active">
       <div class="Service_center">
        <div class="Service_center_float">
          <div class="Service_icon"><img src="${webRoot}/plug-in/weixin/image/Service_icon_1.jpg" width="25" height="25" style="-webkit-border-radius:5px; -moz-border-radius:5px; -o-border-radius:5px; border-radius:5px;"/></div>
          <div class="Service_text">非事故道路救援</div>
        </div>
        <div class="Service_center_float">
          <div class="Service_icon"><img src="${webRoot}/plug-in/weixin/image/Service_icon_2.jpg" width="25" height="25" style="-webkit-border-radius:5px; -moz-border-radius:5px; -o-border-radius:5px; border-radius:5px;"/></div>
          <div class="Service_text"	id="lpsmsj">理赔上门收件</div>
        </div>
        <div class="Service_center_float_1">
          <div class="Service_icon_1"><img src="${webRoot}/plug-in/weixin/image/Service_icon_3.jpg" width="25" height="25" style="-webkit-border-radius:5px; -moz-border-radius:5px; -o-border-radius:5px; border-radius:5px;"/></div>
          <div class="Service_text_1" id="service_addr">服务网点</div>
        </div>
       </div>
    </div>
   
  </div>

  <ul class="fb-am-tabs-nav am-cf  am-navbar " >
    <li class="" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter.do?method=personindex&openid=${openid}">
        <span class="am-icon-edit"></span>  
        <span class="am-tabs-label">保单</span> 
      </a>
    </li>
    <li class="am-active" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter/service.do?serviceindex&openid=${openid}">
        <span class="am-icon-user"></span>
        <span class="am-tabs-label">服务</span>   
      </a>
    </li>
    <li class="" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter/accomplishment.do?achvindex&openid=${openid}">
        <span class="am-icon-trophy"></span>
        <span class="am-tabs-label">成就</span>    
      </a>
    </li>
  </ul>
</div>

</body>
</html>