<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<script src="${webRoot}/plug-in/weixin/js/modernizr.js"></script>
<script>  
  //响应式显示
  $(function(){
  var $timeline_block = $('.cd-timeline-block');
  //hide timeline blocks which are outside the viewport
  $timeline_block.each(function(){
    if($(this).offset().top > $(window).scrollTop()+$(window).height()) {
      $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
    }
  });
  //on scolling, show/animate timeline blocks when enter the viewport
  $(window).on('scroll', function(){
    $timeline_block.each(function(){
      if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
        $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
      }
    });
  });
});

</script>
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
 <!--  成就    --> 
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
  <div class="am-tabs-bd">
    <!-- 成就 -->
    <div data-tab-panel-2 class="am-tab-panel am-active cd-container	">
      	<c:forEach items="${accomplishmentList}" var="accomplishments" varStatus="status">
      		<c:forEach items="${accomplishments.accomplishmentDetailList}" var="accomplishmentDetails" varStatus="statusdetail">
      			<c:choose>
      				 <c:when test="${accomplishmentDetails.size()> 1}">	
		      			 <section id="cd-timeline" >
					        <div class="cd-timeline-block">
					          <div class="cd-timeline-img cd-location">
					            <img src="${webRoot}/plug-in/weixin/image/cd-icon-location.svg" alt="Picture">
					          </div><!-- cd-timeline-img --> 
					          
					           <div class="cd-timeline-content">
					            <h3>${accomplishmentDetails.name }</h3>
					            <p>${accomplishmentDetails.describe }</p>
					            <span class="cd-date">${accomplishments.year}-${accomplishmentDetails.month }</span>
					          </div> <!-- cd-timeline-content -->
					        </div> <!-- cd-timeline-block -->
				         </section> <!-- cd-timeline -->
			         </c:when> 
				</c:choose>
				
	        </c:forEach>
        </c:forEach>
      </div>
  </div>	<!-- /am-tabs-bd -->

 <ul class="fb-am-tabs-nav am-cf  am-navbar " >
    <li class="" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter.do?method=personindex&openid=${openid}">
        <span class="am-icon-edit"></span>  
        <span class="am-tabs-label">保单</span> 
      </a>
    </li>
    <li class="" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter/service.do?serviceindex&openid=${openid}">
        <span class="am-icon-user"></span>
        <span class="am-tabs-label">服务</span>   
      </a>
    </li>
    <li class="am-active" style="margin-top:3px;">
      <a href="${webRoot}/fo/binded/personalCenter/accomplishment.do?achvindex&openid=${openid}">
        <span class="am-icon-trophy"></span>
        <span class="am-tabs-label">成就</span>    
      </a>
    </li>
  </ul>
</div>
 
</body>
</html>