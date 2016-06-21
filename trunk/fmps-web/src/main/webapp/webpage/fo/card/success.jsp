<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/webpage/fo/common/fotags.jsp"%>  
 <!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title></title>
</head>
<style type="text/css">
 body{ background-color:#f5f5f5;}
 input[type="checkbox"] {
  margin: 6px 0 0;
  margin-top: 1px \9;
  /* IE8-9 */
  line-height: normal;
}
.tips_center_text{ width:90%; margin:0 auto; text-align:center;}
.tips_center_text_2{ border-color:#0e90d2; color:#0e90d2;}
.am-selected-btn {
text-align: right;
width: 100px;
}


.am-btn-default {
border:0px;
}

.am-btn {
display: inline-block;
margin-bottom: 0;
padding: 0.225em 1em;}

.am-btn-primary{ width:96%;}
img{ 
  max-width: 100%;
  height: auto;
   }
   
header {
  height: 50px;
  line-height: 0px;
  }
  
.am-topbar {
  position: none;
  min-height: 0px;
  margin-bottom: 0rem;
  }
   .am-btn-success {
  color: #fff;
  background-color: #f8a3a8;
  border: 0px;
}
</style>
<body>

<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title">
      信息提示
    </h1>
  </header>
</header>
<div class="tips_center">
 <br />
 <br />
 
 
 <div class="tips_center_img"><img src="${webRoot}/plug-in/fo/images/jihuo_card.jpg"  width="140" height="140"/></div>
 <br />
 <div class="tips_center_text">恭喜，卡号为${cardno}的${productName}已激活成功。</div>
 <br />
 <br />
 
 
 <c:if test="${isbinded==false }">
 <div class="am-checkbox" style="width:250px; margin:0 auto; text-align:center; padding-bottom:20px; font-size:1em;">
       <input type="checkbox" onchange="check(this)" checked>本人激活，自动认证富邦微信
 </div>
 <div id="renzheng">
		<a	href="#" onclick="clickHref();">
		<div class="tips_center_text_2">我要认证</div></a> </div>
		<div id="close" style="display:none"><a href="javascript:void(0)"
			onclick="cs()"><div class="tips_center_text_2">关闭</div></a></div>
 </c:if>
 
 <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title ">温馨提示</h2>
</div>
 <div style="width:90%; margin:0 auto; font-size:1em; text-align:left;">保险卡激活成功后，可再次输入卡号、密码查看保单信息。<a href="${webRoot}/fo/cardController.do?viewnewdetail&openid=${openid}&policyNo=${cardno}" style="color:#0e90d2;">立即查看</a>。</div>
</div>
<script type="text/javascript">
		function check(obj) {
			if(obj.checked==true){
				document.getElementById("renzheng").style.display="";
				document.getElementById("close").style.display="none";
			}else{
				document.getElementById("renzheng").style.display="none";
				document.getElementById("close").style.display="";
			}
		}
		function cs() {
			wx.closeWindow();
		}
		function clickHref(){
			var applicantName='${applicantName}';
			var applicantNameZ=escape(encodeURIComponent(applicantName)); //转码
			var applicantNumber='${applicantNumber}';
			var applicantPhone='${applicantPhone}';
			var openid='${openid}';
			var applicode='${applicode}';
			
			var actionurl="${webRoot}/fo/customerBindController.do?bindCardCustomer";
			var dat="&customercname="+applicantNameZ+"&identitynumber="+applicantNumber+"&phonenum="+applicantPhone+"&openid="+openid+"&applicode="+applicode;
			  location.href=actionurl+dat;
			
		}
		
		
	</script>

</body>
</html>