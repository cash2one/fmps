<%@ page contentType="text/html; charset=utf-8" import="java.util.Enumeration,java.util.ResourceBundle"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
ResourceBundle bundler = ResourceBundle.getBundle(configFileName);
String basePath = bundler.getString("domain");
String currentEnv = bundler.getString("currentEnv");
String userAgent = request.getHeader("user-agent");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<% if (currentEnv.equalsIgnoreCase("prod") && userAgent.indexOf("MicroMessenger") <= -1) { %>
<meta http-equiv="Refresh" content="0; url=<%=basePath%>/plug-in/weixin/onlyweixin.html" />
<%} %>
<title>悠游天下卡</title>
<style type="text/css">
 body{ margin:0 auto; background:url(<%=basePath%>/plug-in/fo/images/womens_day_bg_2.jpg) repeat center scroll;}
 .nbsp{ height:15px;}
 .a_title{ text-align:center;}
 .a_card{ font-size:14px; text-align:left; line-height:20px; color:#222; width:270px; margin:0 auto; margin-top:20px; }
 .a_text_1{ font-size:14px; text-align:left; line-height:18px; color:#e82404; width:270px; margin:0 auto;} 
 .a_text_title{ color:#222; text-align:left; padding-top:20px; font-size:14px; width:280px; margin:0 auto; padding-top:30px; clear:both; margin-bottom:5px;}
 .a_text_2{ font-size:14px; text-align:left; line-height:18px; color:#222; width:270px; margin:0 auto; border-top:1px solid #222; padding-top:5px;}
 .a_erweima{ text-align:center;}
 .a_text_3{ font-size:14px; text-align:left; line-height:18px; color:#222; width:270px; margin:0 auto; padding-top:5px;}
 .a_text_4{ font-size:14px; text-align:left; line-height:18px; color:#222; width:270px; margin:0 auto; padding-top:5px; border-bottom:1px solid #222; margin-bottom:20px; padding-bottom:5px;}
</style>

</head>

<body>
 <div class="nbsp">&nbsp;</div>
 <div class="a_title"><img src="<%=basePath%>/plug-in/fo/images/a_title.png" /></div>
 <div class="a_card">
 <c:choose>
   <c:when test="${receivetime != null }">
	   <div>您已于${receivetime }领取过悠游卡。</div>
   </c:when>
 </c:choose>
   <div>您的卡号：${cardno }</div>
   <div>您的密码：${password }</div>
 </div>
 <div class="nbsp">&nbsp;</div>
 <div class="a_text_1">
本卡为赠险，请在2015年12月31日前激活过期作废。<br />
请复制保存卡号密码，在您旅游出行前激活。
 </div>
  <div class="a_text_title">【激活方式】</div>
  <div class="a_text_2">
激活方式一：<br />
菜单首页，【服务】—【保险卡激活】—【输入卡号，密码】—【填写个人信息】—【确认激活】。<br />
如有疑问欢迎致电客服热线4008-817-518。<br />
  </div>
  <div class="a_erweima"><img src="<%=basePath%>/plug-in/fo/images/erweima.jpg" width="160" height="160" /></div>
  </div>
  <div class="a_text_4">
激活方式二：<br />
百度搜索富邦财险(www.fubon.com.cn/insurance/)-进入保险卡专区选择悠游天下卡。</div>
  </div>
</body>
</html>
