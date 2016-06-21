<%@ page contentType="text/html; charset=utf-8" import="java.util.Enumeration,java.util.ResourceBundle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
String activedProfile = request.getSession().getServletContext().getInitParameter("spring.profiles.active");
String configFileName = activedProfile != null && activedProfile.length() > 0 ? "dbconfig-" + activedProfile : "dbconfig";
ResourceBundle bundler = ResourceBundle.getBundle(configFileName);
String basePath = bundler.getString("domain");
String currentEnv = bundler.getString("currentEnv");
String userAgent = request.getHeader("user-agent");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<% if (currentEnv.equalsIgnoreCase("prod") && userAgent.indexOf("MicroMessenger") <= -1) { %>
<meta http-equiv="Refresh" content="0; url=<%=basePath%>/plug-in/weixin/onlyweixin.html" />
<%} %>
<title>悠游天下卡投保须知</title>
<style type="text/css">
 body{ margin:0 auto;  background:url(<%=basePath%>/plug-in/fo/images/womens_day_bg_2.jpg) repeat left scroll;}
 .Instructions_title{ color:#222; text-align:left; padding-top:20px; font-size:14px; font-weight:700; margin-bottom:15px;}
 .Instructions_center{ font-size:12px; padding:10px; line-height:20px;}
</style>
</head>

<body>
 <div class="Instructions_title">【投保须知】</div>

 <div class="Instructions_center">
<div>⒈本保险承保公司为富邦财产保险有限公司；<br /><br /></div>
<div>⒉获赠保险适用条款《富邦个人交通工具乘客意外伤害保险条款》；为保障您的合法权益，请您在领取本卡时，特别注意阅读保险条款、保险责任及责任免除的部分；<br /><br />
</div>
<div>⒊本卡号（密码）仅提供投保使用，非保险凭证；被保险人需在有效时间内激活，保险公司根据激活约定开始承担保险责任；<br /><br /></div>
<div>⒋本卡投保成功后不办理退保、被保险人变更等保全事宜；<br /><br /></div>
<div>⒌本卡为赠险，请在2015年12月31日前激活，过期作废。<br /><br /></div>

 </div>
</body>
</html>
