<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>保单首页</title>
</head>
<style type="text/css">
body{ background-color:#f7f6f6;}
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
.am-checkbox {
  margin-top: 0px;
  }
img{ height:15px; width:16px; }
.img_right{ width: 8px; height: 15px; margin-top: 17px;}
.insurance_input{ height:30px; background-color:#fff; padding-left:16px; padding-top:5px;}
.insurance_center_date{ border-bottom:#e8e8e8 solid 1px; border-top:#e8e8e8 solid 1px; height:auto; background-color:#fff;}
.insurance_center_date_text_1{ padding:10px 5px 10px 5px; font-size:0.825em; color:#b8b8b8; border-bottom:#e8e8e8 solid 1px; width:93%; margin:0 auto;}
.insurance_center_date_text_2{ padding:8px 5px 10px 5px; font-size:0.725em;  border-bottom:#e8e8e8 solid 1px; width:93%; margin:0 auto; height:70px;}
.div_h10{height:10px; clear:both; background:#f6f6f6; border-top:#e8e8e8 solid 1px; border-bottom:#e8e8e8 solid 1px}
</style>
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; ">
    保单
  </h1>
</header>
<div class="insurance_input">
    <label class="am-checkbox">
    <input type="checkbox" id="policyStatu" onclick="changePolicyStatu();"> 只显示有效保单</label>
</div>

<div class="insurance_center_date">
	<c:forEach items="${policys }" var="policy">
		<div class="yearDiv">
		<!-- 保单首页按投保年份分段 -->
		<c:if test="${policy.tempOperateYear != null}">
			<div class="div_h10"></div>
			<div class="insurance_center_date_text_1">
				<img src="${webRoot}/plug-in/fo/images/date_icon.jpg" /> ${policy.tempOperateYear}
			</div>
		</c:if>
	
		 <div class="insurance_center_date_text_2" flag="${policy.status}" onclick="policyDetail('${policy.policyno }','${policy.m }');">
		  <div style="float:left; width:70%; line-height: 27px; overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
		    <span style="color:#292929; font-size: 14px;">${policy.policyname }</span>
		    <br />
		    <span style="color:#666666; font-size: 12px;">${policy.enddate }
		    <c:if test="${policy.endhour != null && policy.endhour ne '00' && policy.endhour ne '24' }">${policy.endhour }时</c:if>
		    </span>
		  </div>
		  <div style="float:left; width:30%; text-align:right;">
			  <c:if test="${policy.status != null }">
			  	<img src="${webRoot}/plug-in/fo/images/shixiao_icon.jpg" width="126" height="104" style="height:41px; width:50px;"/>
		  	  </c:if>
		  	  <!-- 电销红包 -->
		  	  <%-- <c:if test="${policy.telesalepolicy.toString() eq '1'  && policy.status== null }">
			  	<img src="${webRoot}/plug-in/fo/images/hongbao_icon.jpg" width="126" height="104" style="height:41px; width:50px;"/>
		  	  </c:if> --%>
		   <img class="img_right" alt="" src="${webRoot}/plug-in/fo/images/lt.png" > </div>
		 </div>
		</div>
	</c:forEach>	
</div>
<script>
function changePolicyStatu(){
	//只显示有效保单
	var policyStatusDivs = $("div[flag]");
	if($("#policyStatu").is(':checked')){
		policyStatusDivs.each(function(i) {
			if($(this).attr("flag") == "已过期"){
				$(this).hide();
			}
		});			
		
	} else{
		policyStatusDivs.show();
	}
}
function policyDetail(policyno,m){
	//1:oracle data/2:mysql data
	if(m != null && m==1)
		location.href = "${webRoot}/fo/binded/personalCenter/policyController.do?method=Detail&openid=${openid}&policyno=" + policyno;
		else
			location.href = "${webRoot}/fo/cardController.do?viewnewdetail&openid=${openid}&policyNo=" + policyno;	
}

$(function(){
	$(".insurance_center_date").find("div[class='yearDiv']:first > .div_h10").css("border-top","none");
	$.each($(".yearDiv"), function(id, item) {
		$(this).find("div[class='insurance_center_date_text_2']:last").css("border-bottom","none");
	});
})
</script>
</body>
</html>