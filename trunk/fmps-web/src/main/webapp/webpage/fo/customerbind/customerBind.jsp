<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<style type="text/css">
    body{ background-color:#fff;}
.am-header-default {
  background-color: #fff;
}
.am-header {
  position: relative;
  width: 100%;
  height: 49px;
  line-height: 49px;
  padding: 0 10px;
  border-bottom:2px solid #0e90d2;
}
   img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
       }
.user{ width:90%; margin:0 auto;}
.user_top_text{ text-align:left; font-size:12px; font-family:"微软雅黑"; width:90%; margin:0 auto; padding-top:20px;}
.user_text{ width:29%; float:left; font-size:16px;}
.user_input{ width:70%; float:left;}
input{ border-bottom:1px solid #dedede; border-left:0px solid #dedede; border-right:0px solid #dedede; border-top:0px solid #dedede; height:21px; width:100%; text-align:left;}
.validate{ width:90%; margin:0 auto;}
.validate_text{ width:29%; float:left; font-size:16px;}
.validate_input{ width:40%; float:left;}
.validate_letter{ width:24%; float:left; font-size:11px; text-align:center; border:1px solid #e8e8e8; padding:2px 2px 2px 2px; margin-left:6%; margin-top:-4px;}
.user_button{border-radius:5px; background-color:#0e90d2; color:#fff; font-size:18px; text-align:center; height:47px; width:90%; margin:0 auto; line-height:43px;}
.am-topbar-inverse {
  background-color: #fff;
  border-color: #fff;
  } 
.users_tips{ margin: 0 auto; width: 90%; clear: both; color:#ff0000; }
    
</style>

</head>
<body>

<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; ">
    用户认证
  </h1>
</header>
 <div style="height:35px; clear:both;">&nbsp;</div> 
 	<form name="bindForm" action="${webRoot}/fo/customerBindController.do?bindCustomer&requestPath=${requestPath }" method="post">
		<input type="hidden" name="webRoot" id="webRoot" value="${webRoot}" />
		<input type="hidden" name="openid" id="openid" value="${openid }" />
		
		 <div class="user">
             <div class="user_text">姓 名：</div>
             <div class="user_input"><input name="customercname" id="customercname" value="${customercname }"  type="text" placeholder="请输入投/被保人真实姓名" /></div>
         </div>
          <div id="customercnametemp"  class="users_tips"></div>         
			<div style="height:35px; clear:both;">&nbsp;</div>
             <div class="user">
              <div class="user_text">证件号码：</div>
              <div class="user_input"><input name="identifynumberother" id="identifynumberother" value="${identifynumberother }" type="text" placeholder="请输入投/被保人证件号码"/></div>
           </div>
		   <div id="identifynumberothertemp" class="users_tips"></div>			
			 <div style="height:35px; clear:both;">&nbsp;</div>
              <div class="user">
               <div class="user_text">手机号码：</div>
               <div class="user_input"><input name="mobileother" id="mobileother" placeholder="请输入有效手机号" value="${mobileother }"  placeholder="请输入有效手机号" type="text" /></div>
              </div>
              <div id="mobileothertemp" class="users_tips"></div>              
			   <div style="height:35px; clear:both;">&nbsp;</div>
               <div class="validate">
                <div class="validate_text">验 证 码：</div>
                <div class="validate_input"><input  type="text" size="18" name="dynamicpasswordother" id="dynamicpasswordother" value="${dynamicpasswordother }" placeholder="请输入验证码"/></div>
                <div class="validate_letter" id="getDynamicPasswordOther" name="getDynamicPasswordOther"      onclick="sendDynamicPassword($('#getDynamicPasswordOther'), $('#mobileother'), $('#dynamicpasswordothertemp'),'${openid}');" >获取验证码  </div>
               </div> 
			   <div id="dynamicpasswordothertemp" class="users_tips">${messageother }</div>
				  <div style="height:50px; clear:both;">&nbsp;</div>
                   <a name="bindother" id="bindother" onclick="submitOther()"><div class="user_button"> 确 &nbsp;&nbsp;&nbsp;认 </div></a>
				
	</form>		
		
<div style="  height:22px;">&nbsp;</div>
<div style="text-align:center;"><img src="${webRoot}/plug-in/fo/images/user_tips.jpg" width="90%" /></div>
			
<script src="${webRoot}/plug-in/fo/js/customerbind/customerBind.js?vesion=2"></script>


</body>
</html>
