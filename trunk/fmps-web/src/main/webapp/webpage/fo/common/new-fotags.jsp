<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="t" uri="/easyui-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

 <%@page import="java.util.ResourceBundle"%>
<% 
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
ResourceBundle bundler = ResourceBundle.getBundle(configFileName);
String basePath = bundler.getString("domain");
String currentEnv = bundler.getString("currentEnv");
String userAgent = request.getHeader("user-agent");

System.out.println("userAgent==>" + userAgent);
%>
<c:set var="webRoot" value="<%=basePath%>" />
<%@ include file="/webpage/fo/common/fo-metas.jsp"%>

<% if (currentEnv.equalsIgnoreCase("prod") && userAgent.indexOf("MicroMessenger") <= -1) { %>
<meta http-equiv="Refresh" content="0; url=${webRoot}/plug-in/weixin/onlyweixin.html" />
<%} %>


<% if (currentEnv.equalsIgnoreCase("prod")) {%>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?3b62d4c2f2d2718cfcdca0a716aed32e";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<%} %>

<%--<script src="${webRoot}/plug-in/jquery/jquery.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="${webRoot}/plug-in/jquerymobile/js/jquery.mobile-1.4.4.min.js"></script>
<link href="${webRoot}/plug-in/jquerymobile/css/jquery.mobile-1.4.4.min.css" rel="stylesheet" type="text/css" />
<link href="${webRoot}/plug-in/assets/css/weixin-1.4.4.css?version=999" rel="stylesheet" type="text/css" /> --%>
<!--  
<link href="${webRoot}/plug-in/weixin/css/main.css" rel="stylesheet" type="text/css"  >
-->
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<!-- amaze.ui  -->
<script src="${webRoot}/plug-in/jquery/jquery-1.9.1.min.js"></script>
<script src="${webRoot}/plug-in/amaze-ui/2.5/js/amazeui.min.js"></script>
<link href="${webRoot}/plug-in/amaze-ui/2.5/css/amazeui.min.css" rel="stylesheet" type="text/css" />
<script src="${webRoot}/plug-in/weixin/js/fb-main.js"></script>



<c:if test="${issubscribe==0}">
<script>
 $(function(){
	popCardMessage();	
	});

 function popCardMessage(){ 
	var windowWidth = document.body.clientWidth;       
	var windowHeight =document.body.scrollHeight;
	$("#bg").width(windowWidth)   
    .height(windowHeight) .css("display","block") ;
	 $("#show").css("display","block");
  }
</script>

</c:if>

 <style type="text/css">
 #bg{ display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:1001; -moz-opacity: 0.7; opacity:.70; filter: alpha(opacity=70);}
 #show{display: none; position: absolute; top: 20%; left: 13%; width: 70%; height:auto; padding: 8px; border: 1px solid #e8e8e8; background-color:#fff; z-index:1002; overflow: auto; border-radius: 5px;}
 .erweima_text_1{ text-align:center; font-size:14px; padding-top:12px; font-family:"黑体";}
 .erweima_img{ text-align:center; padding:12px 0px 12px 0px;}
 </style>
  <div id="bg" ></div>
 <div id="show">
  <div class="erweima_text_1">你可能未关注富邦财险公众号，请先长按二维码关注。</div>
  <div class="erweima_img"><img src="${webRoot}/plug-in/fo/images/weixinQ.png" style="width:70%;" /></div>
  <div class="erweima_text_1">如果长按二维码不能识别，可以搜索富邦财险进行关注。</div>
 </div>

