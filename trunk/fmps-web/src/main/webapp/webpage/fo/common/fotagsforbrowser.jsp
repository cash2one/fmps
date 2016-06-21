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
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<!-- amaze.ui  -->
<script src="${webRoot}/plug-in/jquery/jquery-1.9.1.min.js"></script>
<script src="${webRoot}/plug-in/amaze-ui/js/amazeui.min.js"></script>
<link href="${webRoot}/plug-in/amaze-ui/css/amazeui.min.css" rel="stylesheet" type="text/css" />



