<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<title>个人中心</title>

<style type="text/css">
.geren_center_bg {
	background: url(${webRoot}/plug-in/fo/images/geren_center_bg.jpg) no-repeat scroll left top / 100% auto;
	height: 150px;
	width: auto;
}
i{
  display:block;
  background:#f00;
  border-radius:50%;
  width:5px;
  height:5px;
  top:0px;
  right:0px;
  position:absolute;
}
.circle { 
width: 10px; 
height: 10px; 
background: red; 
-moz-border-radius: 50px; 
-webkit-border-radius: 50px; 
border-radius: 50px; 
} 
.geren_center_img {
	border: 3px solid #c5b39d;
	width: 80px;
	height: 80px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	-o-border-radius: 50px;
	border-radius: 50px;
	margin-left: 20px;
	float: left;
}

.geren_center_name {
	color: #FFFFFF;
	font-size: 0.825em;
	float: left;
	width: 53%;
	text-align: center;
	line-height: 90px; 

}

.geren_center_icon {
	color: #FFFFFF;
	float: left;
	width: 10%;
	padding-top: 37px;
	text-align: right;
}

.geren_center_insurance {
	padding: 0px 15px 15px 15px;
	width: 100%;
}

.geren_center_insurance_text {
	font-size: 0.825em;
	color: #c5c5c5;
	border-bottom: 1px solid #e8e8e8;
	height: 30px;
}

.geren_center_insurance_anniu {
	width: 100%;
	float: left;
	border-bottom: 1px solid #e8e8e8;
	height: 55px;
	padding-top: 8px;
}
.geren_center_insurance_anniu_1 {
	width: 100%;
	float: left;
	border-bottom: 0px solid #e8e8e8;
	height: 55px;
	padding-top: 8px;
}

.geren_center_insurance_anniu .icon {
	width: 12%;
	float: left;
	text-align: right; padding-top: 8px;
}
@media screen and (min-width:360px){ .geren_center_insurance_anniu .icon{ width: 10%;}}
@media screen and (min-width:375px){ .geren_center_insurance_anniu .icon{ width: 10%;}}
@media screen and (min-width:384px){ .geren_center_insurance_anniu .icon{ width: 10%;}}
@media screen and (min-width:414px){ .geren_center_insurance_anniu .icon{ width: 10%;}}
@media screen and (min-width:640px){ .geren_center_insurance_anniu .icon{ width: 10%;}} 
.geren_center_insurance_anniu_1 .icon {
	width: 12%;
	float: left;
	text-align: right; 
	padding-top: 8px; padding-left: 10px;
}

.geren_center_insurance_anniu .text {
	width: 83%;
	float: left;
	color: #292929;
	font-size: 15px;
	padding: 8px 0px 10px 8px;
}
.geren_center_insurance_anniu_1 .text {
	width: 83%;
	float: left;
	color: #292929;
	font-size: 15px;
	padding: 10px 0px 10px 8px;
}

.geren_center_insurance_anniu .tu {
	width: 5%;
	float: left;
	color: #c3c3c3;
	padding: 12px 0px 10px 0px;
}
.geren_center_insurance_anniu_1 .tu {
	width: 5%;
	float: left;
	color: #c3c3c3;
	padding: 12px 0px 10px 0px;
}
</style>
</head>

<body>
	<div class="geren_center_bg">
		<div style="height: 30px;">&nbsp;</div>
		<a
			href="${webRoot}/fo/binded/personalCenterController.do?PersonalInfo&openid=${openid}">
			<div style="width: 100%;">
				<div class="geren_center_img">
					<img src="${headimgurl}" width="75" height="74"
						style="-webkit-border-radius: 50px; -moz-border-radius: 50px; -o-border-radius: 50px; border-radius: 50px;">
				</div>
				<div class="geren_center_name">${nickname}</div>
				<div class="geren_center_icon"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>

			</div>
		</a>
	</div>



    <div style="height: 10px; background-color: #f6f6f6; clear: both; width: 100%;"></div>
	<div class="geren_center_style">
		<div class="geren_center_insurance">
			<!-- <div class="geren_center_insurance_text">我的</div> -->
			<a href="${webRoot}/pay/taipayController.do?index&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon" >
						<img src="${webRoot}/plug-in/fo/images/center_2.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">订单</div> 
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a> 
			<a href="${webRoot}/fo/binded/personalCenter/policyController.do?method=Index&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon" >
						<img src="${webRoot}/plug-in/fo/images/center_1.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">保单</div> 
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a> 
			
			<a href="${webRoot}/fo/binded/personalCenterController.do?CardIndex&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_3.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">保险卡</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a> 
			
			<a href="${webRoot}/fo/binded/customerClaims/newCustomerClaimsController.do?getClaimInfo">
				<div class="geren_center_insurance_anniu" style="border-bottom: 0px solid #e8e8e8;">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_4.jpg" alt="#" width="25" height="25" />
					</div>
					<div class="text">
					<div style="width: 15%; float: left;">理赔</div>
					</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a>
			</div>
			<div style="height: 10px; background-color: #f6f6f6; clear: both; width: 100%;"></div>
			<div class="geren_center_insurance">
						<a href="${webRoot}/fo/binded/repairFactoryGiftController.do?method=giftList&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_5.jpg" alt="#" width="25" height="25" />
					</div>
					<div class="text">
					<div style="width: 15%; float: left;">礼包</div>
					
					
					</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a>
			
			<a href="${webRoot}/fo/binded/personalCenterController.do?myEvaluation&openid=${openid}"><div class="geren_center_insurance_anniu">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_6.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">
					<div style="width: 15%; float: left;">评价</div>
					<c:if test="${evaluationflag!=null&&evaluationflag=='1'}">
  <div style="width: 10%; float: left;">
					 <div style=" width:16px; height:16px; background-color:#F00; border-radius:8px;">
					  <span style="height:16px; line-height:16px; display:block; color:#FFF; text-align:center">${count}</span>
					 </div>
					</div>
 
  </c:if>
					
					</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a>
			
			
			
			
		 	<a href="${webRoot}/fo/binded/customerHonorTitleController.do?method=customerHonorTitle&openid=${openid}">
				
				<div class="geren_center_insurance_anniu" style="border-bottom: 0px solid #e8e8e8;">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_7.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">封神榜</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a> 
			</div>
			
            <div style="height: 10px; background-color: #f6f6f6; clear: both; width: 100%;"></div>
			<div class="geren_center_insurance">
			<!-- <div class="geren_center_insurance_text" style="clear: both;">服务</div> -->
			
			<a href="${webRoot}/fo/binded/customerNewCarLicenceController.do?method=getCustomerNewCarLicence&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_8.jpg" alt="#" width="25" height="25" />
					</div>
					<div class="text">新车车牌变更</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a> 
			
			<a href="${webRoot}/fo/serviceBranch.do?list&openid=${openid}">
				<div class="geren_center_insurance_anniu">
					<div class="icon">
						<img src="${webRoot}/plug-in/fo/images/center_9.jpg" alt="#" width="25" height="25"/>
					</div>
					<div class="text">服务网点</div>
					<div class="tu"><img alt="" src="${webRoot}/plug-in/fo/images/lt.png" width="8" height="15"></div>
				</div>
			</a>
			
			</div>
          <div style="height:20px;clear:both;">&nbsp;</div>
		  
	</div>
</body>
</html>