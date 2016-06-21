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
<title>悠游卡领取</title>
<style type="text/css">
 body{ margin:0 auto;  background:url(<%=basePath%>/plug-in/fo/images/womens_day_bg_2.jpg) repeat center scroll;}
 .nbsp{ height:20px;}
 .nbsp_1{ height:15px; }
 .lanse_top{  width:100%; height:600px; text-align:center;}
 .lanse_center{ color:#5c9b02; text-align:left; padding-top:20px; font-size:14px; font-weight:700;}
 .icon{ float:left; width:100%; margin-top:10px;}
 .icon_1{ float:left; width:50%;}
 .icon_2{ float:left; width:50%;}
 .icon_text{ color:#222; font-size:12px; line-height:20px;}
 .input_center_text{ text-align:center; font-size:12px; color:#222; clear:both; padding-top:10px;}
 .lvse_center{ height:70px; width:100%;}
 .buy_anniu{ border-radius: 10px; width:130px; height:40px; background-color:#0484f0; margin:0 auto; color:#fff; font-size:20px; font-weight:700; line-height:40px;}
</style>
</head>

<body>
 <div class="nbsp">&nbsp;</div>
  <div class="lanse_top">
   <div><img src="<%=basePath%>/plug-in/fo/images/product_title.png"  /></div>
   <div class="lanse_center">【悠游天下保障内容】</div>
   <div class="icon">
    <div class="icon_1">
     <div><img src="<%=basePath%>/plug-in/fo/images/icon_1.png" /></div>
     <div class="icon_text">轮船意外伤害保险<span style="color:#047de4; font-size:20px; font-weight:700;">10</span>万</div>
    </div>
    <div class="icon_2">
     <div><img src="<%=basePath%>/plug-in/fo/images/icon_2.png" /></div>
     <div class="icon_text">火车意外伤害保险<span style="color:#047de4; font-size:20px; font-weight:700;">10</span>万</div></div>
   </div>
   
   <div class="icon">
    <div class="icon_1">
     <div><img src="<%=basePath%>/plug-in/fo/images/icon_3.png" /></div>
     <div class="icon_text">航空意外伤害保险<span style="color:#047de4; font-size:20px; font-weight:700;">50</span>万</div>
    </div>
    <div class="icon_2">
     <div><img src="<%=basePath%>/plug-in/fo/images/icon_4.png" /></div>
     <div class="icon_text">悠游天下保险期限<span style="color:#047de4; font-size:20px; font-weight:700;">8</span>天</div></div>
   </div>
   
   <div class="icon">
    <div class="icon_1">
     <div><img src="<%=basePath%>/plug-in/fo/images/icon_5.png" /></div>
     <div class="icon_text">适用人群<span style="color:#047de4; font-size:20px; font-weight:700;">0</span>岁至<span style="color:#047de4; font-size:20px; font-weight:700;">80</span>岁</div>
    </div>
    <div class="icon_2">
     <div>&nbsp;</div>
     <div class="icon_text">&nbsp;</div>
   </div>
 </div>
 <div class="lanse_center" style=" padding-top:10px; clear:both;">【投保须知】</div>
 <div class="icon">
    <div class="icon_1">
     <div><a href="<%=basePath%>/webpage/fo/huodong/card/instructions.jsp"><img src="<%=basePath%>/plug-in/fo/images/icon_6.png" /></a></div>
     <div class="icon_text">用户投保须知</div>
    </div>
    <div class="icon_2">
	     <!-- 富邦个人交通工具乘客意外伤害保险条款.pdf -->
	     <div>
		     <a href="<%=basePath%>/fo/womensDayCardController.do?method=readClause&openid=${openid}&fileUrl=<%=basePath%>/userfiles/productfiles/Card2754.pdf" >
		     <img src="<%=basePath%>/plug-in/fo/images/icon_7.png" /></a></div>
	     <div class="icon_text">保险条款</div>
     </div>
     
   </div>
   
   <!-- 如果已经领取过悠游卡,则不显示复选框 -->
   <c:choose>
    	<c:when test="${receiveCount != null }">
		  <div class="input_center_text">&nbsp;</div>
   		</c:when>
   		<c:otherwise>
   		  <div class="input_center_text">
			<span onclick="changeAgreeStatus();">
			<input id="agreeCheckbox" type="checkbox" onclick="changeAgreeStatus();" style="vertical-align:middle" />我已阅读并同意以上条款内容</span></div>
   		</c:otherwise>
    </c:choose>
    
   <div class="nbsp">&nbsp;</div>
   <div class="lvse_center">
    <div class="nbsp_1">&nbsp;</div>
    
    <c:choose>
    	<c:when test="${receiveCount != null }">
		    <div class="buy_anniu" onclick="receiveCard('received');">查看悠游卡</div>
    	</c:when>
    	<c:otherwise>
		    <div class="buy_anniu" onclick="receiveCard();">领 取</div>
    	</c:otherwise>
    </c:choose>
   </div>
 
</div>
<script src="<%=basePath%>/plug-in/jquery/jquery-1.8.3.js"></script>
<script>
function changeAgreeStatus(){
	$("#agreeCheckbox").attr("checked",!$("#agreeCheckbox").is(':checked'));
}
function receiveCard(field){
	if(field != "received" && $("#agreeCheckbox").is(':checked') == false){
		alert("请确认您已阅读并同意以上条款内容!");
		return false;
	}
	location.href="<%=basePath%>/fo/womensDayCardController.do?method=receiveCard&openid=${openid}&huodongid=${huodongid}";
}
</script>
</body>
</html>
