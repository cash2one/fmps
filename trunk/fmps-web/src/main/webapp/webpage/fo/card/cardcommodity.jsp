<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<%@ include file="/webpage/fo/common/mobiscroll.jsp"%>
<!doctype html>
<html class="no-js">
<head>
<title>富邦财险</title>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
<script src="${webRoot}/plug-in/fo/verificationIdentity.js"></script>
</head>

<style type="text/css">
.am-selected-btn {
	text-align: right;
	width: 100px;
}

.am-btn-default {
	border: 0px;
}

.am-btn {
	display: inline-block;
	margin-bottom: 0;
	padding: 0.225em 1em;
}

.am-btn-primary {
	width: 96%;
}

img {
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
a {
  color: #000;
}
.am-btn-success {
	color: #fff;
	background-color: #f8a3a8;
	border: 0px;
}

.input::-ms-clear {
	display: none;
}

.input:valid+.clear {
	display: inline;
}

.am-header .am-header-title {
	margin: 0 20%;
}

.am-modal-hd+.am-modal-bd {
	padding-top: 10px;
}

.am-form-field {
	padding: 0em;
}
input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill {
  background-color:#fff;
}
.am-modal-no-btn .am-modal-bd {

   margin: 0 auto; width: 85%;
}
.am-modal-bd{ font-size: 12px; text-align: center; padding: 5px 5px 5px 5px;}
.viewName{
	 background-color: #F2FBFC;
/* 	 margin-top: 20%; */
	 margin-bottom: 10%;
}
.am-modal-hd .am-close {
  position: absolute;
  top: 0px;
  right: 0px;
}
.am-popup {
  text-align: center;
  top: 35%;
 }
.checkData {
	border-radius: 5px;
	font-size: 14px; 
	height: 30px;
  	width: 22%;
	background-color: #6CADCF; 
	color: #fff;   
	margin-left: 10px;
	position: relative;
	line-height:30px;
}
.keyword {
	border: 1px solid #E0D5D5; 
	width: 60%; 
	height: 30px;
	line-height:30px;
	font-size: 14px; 
	border-radius: 5px;
	position: relative;
} 
.occupationName{
	font-size: 16px;
	height: 30px; 
	text-align: left; 
	width: 100%; 
	border: 0px; 
	padding-right: 10px;
}
.occupationdiv {
	width: 60%; 
	float: left; 
	padding-top: 10px; 
	text-align: left; 
	height: 6%;
}
</style>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<header class="am-topbar admin-header">
		<header data-am-widget="header" class="am-header am-header-default">
			<h1 class="am-header-title">${product.productname  }</h1>
		</header>



	</header>
	<!-- <div id="jjj"  style="display:none" data-am-sticky="{animation: 'slide-top'}">
  <button style="color: rgb(44, 41, 41);"  id="jjjn" class="am-btn am-btn-success am-btn-block">固定到顶部动画效果</button>
</div> -->
	<div class="am-cf admin-main">
		<!-- sidebar start -->


		<!-- content start -->
		<div class="admin-content">

			<div class="am-slider am-slider-default">
				<img src="${webRoot}/${product.imagehref}" width="873" height="354"
					alt="#" />
			</div>


			<form action="${webRoot}/fo/cardController.do?saveCard" method="post"
				id="form1" name="form1">
				<div
					style="margin: .5rem 1rem; border: 1px solid #dedede; height: auto; position: relative;">

					<div class="am-accordion-title"
						style="background-color: #f5f5f5; padding: 0.8rem 2rem 0.8rem 1rem; border-bottom: 1px solid #dedede;">
						<i class=" am-icon-user"></i> 被保险人信息
					</div>
					<div
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">姓
							名:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input size="13" class="input" id="insuredName"
								name="insuredName" type="text"
								style="font-size: 16px; height: 30px; text-align: left; width: 100%; border: 0px; padding-right: 10px;"
								value="${customer.customercname}" placeholder="请输入姓名" required
								maxlength="120">
						</div>
						<div id="insuredNametemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
					</div>
					<input type="hidden" id="cardno" name="cardno" value="${cardno}">
					<input type="hidden" id="type" name="type" value="${product.type}">
					<div
						style="position: relative; height: 49px; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 29%; float: left;">证件类型:</div>
						<div style="width: 50%; float: left; padding-top: 10px;">
							<div style="float: left;">
								<select data-am-selected name="insuredIdentifytype" id="ci">
									<option value="01"
										<c:if test="${customer.identifyType=='01'  }">selected</c:if>>身份证</option>
									<option value="02"
										<c:if test="${customer.identifyType=='02'  }">selected</c:if>>户口簿</option>
									<option value="03"
										<c:if test="${customer.identifyType=='03'  }">selected</c:if>>护照</option>
									<option value="04"
										<c:if test="${customer.identifyType=='04'  }">selected</c:if>>军官证</option>
									<option value="05"
										<c:if test="${customer.identifyType=='05'  }">selected</c:if>>驾驶执照</option>
									<option value="06"
										<c:if test="${customer.identifyType=='06'  }">selected</c:if>>返乡证</option>
									<option value="08"
										<c:if test="${customer.identifyType=='08'  }">selected</c:if>>士兵证</option>
									<option value="09"
										<c:if test="${customer.identifyType=='09'  }">selected</c:if>>警官证</option>
									<option value="07"
										<c:if test="${customer.identifyType=='99'  }">selected</c:if>>其它</option>
								</select>
							</div>
						</div>
					</div>

					<div
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">证件号码:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="insuredIdentifynumber"
								value="${customer.identifynumber}" name="insuredIdentifynumber"
								type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								placeholder="输入证件号码">
						</div>
						<div id="insuredIdentifynumbertemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>

					</div>

					<div id="genderf"
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 29%; float: left;">性
							别:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left; text-indent: 13px;">
							<select id="insuredGender" name="insuredGender"
								style="width: 50px;">
								<option value="M"
									<c:if test="${customer.customerSex=='M'  }">selected</c:if>>男</option>
								<option value="F"
									<c:if test="${customer.customerSex=='F'  }">selected</c:if>>女</option>

							</select>
						</div>
						<div id="insuredGendertemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>

					</div>


					<!--<div id="birthdayf" class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}" style="position:relative; height:auto; border-bottom:1px solid #dedede;">
 <div style="float: left; padding: 12px 0px 0px 12px">出生日期：</div>
   <div style="float: left; width: 30%;" onclick="changecolor();" ><input class="am-form-field" id="insuredBirthday" name="insuredBirthday"  readonly="readonly" value="<fmt:formatDate value='${customer.customerBirthday}' type="date" dateStyle="medium"/>" type="text" class="am-form-field" style="border:0px; padding-top:15px; width: 140px; color:black;background-color: #fff;"></div>
     <span class="am-input-group-btn am-datepicker-add-on" style="border:0px; background:#fff;">
    <button class="am-btn am-btn-default" type="button" onclick="changecolor();" style="border:0px; background:#fff;"><span class="am-icon-calendar" ></span> </button>
  </span> 
  <div id="insuredBirthdaytemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
</div>-->
					<!--  <div id="birthdayf" class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}" style="position:relative; height:auto; border-bottom:1px solid #dedede;">
  -->
					<div id="birthdayf"
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">

						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">出生日期:</div>
						<div style="width: 50%; float: left; text-align: left;"
							onclick="changecolor();">
							<input class="am-form-field" id="insuredBirthday"
								name="insuredBirthday" readonly="readonly"
								value="<fmt:formatDate value='${customer.customerBirthday}' type="date" dateStyle="medium"/>"
								type="text"
								style="border: 0px; padding-top: 15px; width: 100%; color: black; background-color: #fff;">
						</div>
						<div id="insuredBirthdaytemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>

					</div>


					<div
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">手机号码:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="insuredPhone" value="${customer.mobile}"
								name="insuredPhone" type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								placeholder="用于接收激活成功短信">
						</div>
						<div id="insuredPhonetemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
						
					</div>
				<input type="hidden" id="occupLevels" name="occupLevels" readonly="readonly" value="${product.occupationLevels}">
					<c:if test="${product.type == 1 && product.occupationLevels!='' }">
						<div style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
							<div style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">工作职业:</div>
							<div class="occupationdiv" id="occupationdiv">
<!-- 								<div id="occupationName" name="occupationName" data-am-modal="{target: '#my-popup'}">请输入您的职业名称...</div>
								<input type="hidden" id="occupName" name="occupName"> -->
								<input type="text" id="occupationName" name="occupationName" readonly="readonly" placeholder="请输入您的职业名称...">
								<input type="hidden" id="codeCode" name="codeCode">
								<input type="hidden" id="flagCode" name="flagCode">
								
							</div>
							<div id="occupationNametemp"
								style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
						</div>
					</c:if>
					<div class="am-popup" tabindex="-1" id="my-popup" >
						<div class="am-modal-dialog" style="overflow-y: scroll; width: 100%; height: 60%; " >
							<div class="am-modal-hd" style="border-bottom: 1px solid #E0D5D5; padding-bottom: 16px; background-color: #E7F4FA; width: 100%;">
								<input name="keyword" class="keyword" id="keyword" type="text" placeholder="请输入您的职业名称..." />
								<button type="button" class="checkData" id="checkData" name="checkData">搜 索</button>
								<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
							</div>
							<div id="viewName" class="viewName"></div>
						</div>
					</div>
	<!-- 车主守护卡新增字段 -->	
				<c:if test="${showCarMessage =='Y'}">	
				 <div style="position: relative; height: 49px; border-bottom: 1px solid #dedede;">
					<div style="padding: 1.2rem 0rem 0.8rem 1rem; width: 29%; float: left;">是车主的:</div>
						<div style="width: 50%; float: left; padding-top: 10px;">
							<div style="float: left;">
								<select data-am-selected name="insuredCarOwners" id="insuredCarOwners">
									<option value="请选择" >请选择</option>
									<option value="01" >本人</option>
									<option value="11" >丈夫</option>
									<option value="12" >妻子</option>
								</select>
							</div>
						</div>
					</div>
				<div id="insuredCarOwnerstemp"	style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>	
				<input type="hidden" id="insuredCarOwnersValue" name="insuredCarOwnersValue" >
				<input type="hidden" id="insuredCarOwnersText" name="insuredCarOwnersText" >
				   <div style="position: relative; height: auto; border-bottom: 1px solid #dedede;" id="insuredCarOwnerInput"  >
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">车主姓名:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="insuredCarOwnerName"
								value="" name="insuredCarOwnerName"
								type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								placeholder="输入车主姓名">
						</div>
						<div id="insuredCarOwnerNametemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
					</div>	
					
					<div style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">车牌号码:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="insuredLicenseNo"
								value="" name="insuredLicenseNo"
								type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								placeholder="输入车牌号码">
						</div>
						<div id="insuredLicenseNotemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
					</div>	
				</c:if>
					
				</div>
	<!-- 根据商品配置参数，判断是否出现标的地址 -->
				<c:if test="${showContractAddress =='Y'}">
					<div
						style="margin: .5rem 1rem; border: 1px solid #dedede; height: auto; position: relative;">

						<div class="am-accordion-title"
							style="background-color: #f5f5f5; padding: 0.8rem 2rem 0.8rem 1rem; border-bottom: 1px solid #dedede;">
							<i class=" am-icon-home"></i> 标的地址
						</div>

						<div
							style="position: relative; height: 49px; border-bottom: 1px solid #dedede;">
							<!-- <div style=" padding: 1.2rem 1rem 0.8rem 1rem; width:36%; float:left;"></div> -->
							<div
								style="width: 100%; float: left; padding-top: 10px; padding-left: 5px;">
								<div style="float: left; width: 33%;">
									<div class="am-form-group">
										<select id="provinceId" name="provinceCode">
											<option value="a">选择省</option>

										</select>
									</div>
								</div>
								<div style="float: left; width: 33%;">
									<div class="am-form-group">
										<select name="cityCode" id="cityId">
											<option value="a">选择市</option>
										</select>
									</div>
								</div>
								<div style="float: left; width: 33%;">
									<div class="am-form-group">
										<select name="areaCode" id="areaId">
											<option value="a">选择区</option>

										</select>
									</div>
								</div>
								<!-- <div id="provincetemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 -->
							</div>
						</div>

						<div style="position: relative; height: auto;">
							<div
								style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">详细地址：</div>
							<div
								style="width: 60%; float: left; padding-top: 10px; text-align: left;">
								<input size="13" maxlength="100" id="detial" name="detial"
									type="text"
									style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
									placeholder="地址具体到门牌">
							</div>
							<div id="detialtemp"
								style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
						</div>

					</div>


				</c:if>

				<div style="padding-left: 13px;">
					<!-- <label class="am-checkbox"  >
      <input type="checkbox" id="hjj" checked="true" onchange="this.value=(hjj.checked)?1:0" value="1" data-am-ucheck  > 投保人同被保险人
</label> -->
					<input style="width: 20px; height: 20px;" type="checkbox" id="hjj"
						checked value="1"> 投保人同被保险人 <input type="hidden"
						name="checkh" id="checkh" />
				</div>

				<div id="kjj"
					style="margin: .5rem 1rem; border: 1px solid #dedede; height: auto; position: relative; display: none">

					<div class="am-accordion-title"
						style="background-color: #f5f5f5; padding: 0.8rem 2rem 0.8rem 1rem; border-bottom: 1px solid #dedede;">
						<i class=" am-icon-user"></i> 投保人信息
					</div>
					<div
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">姓
							名:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="applicantName" size="13" maxlength="120"
								name="applicantName" type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								value="" placeholder="请输入姓名">
						</div>
						<div id="applicantNametemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
					</div>




					<div
						style="position: relative; height: 49px; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 29%; float: left;">证件类型:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: right;">

							<div style="float: left;">
								<select data-am-selected name="applicantIdentifytype" id="cii">
									<option value="01">身份证</option>
									<option value="02">户口簿</option>
									<option value="03">护照</option>
									<option value="04">军官证</option>
									<option value="05">驾驶执照</option>
									<option value="06">返乡证</option>
									<option value="08">士兵证</option>
									<option value="09">警官证</option>
									<option value="99">其它</option>
								</select>
							</div>

						</div>
					</div>
					<input type="hidden" id="token" name="token" value="${token}" />
					<div
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">证件号码:</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="applicantNumber" size="19" name="applicantNumber"
								type="text"
								style="font-size: 16px; width: 100%; height: 30px; text-align: left; border: 0px;"
								placeholder="输入证件号码">
						</div>
						<div id="applicantNumbertemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
					</div>


					<div id="applicantGenderf"
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 29%; float: left;">性
							别：</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left; text-indent: 13px;">
							<select id="applicantGender" name="applicantGender"
								style="width: 50px;">
								<option value="M">男</option>
								<option value="F">女</option>
							</select>
						</div>
						<div id="applicantGendertemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>

					</div>


					<!--  <div id="applicantBirthdayf" class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd'}" style="position:relative; height:auto; border-bottom:1px solid #dedede;">
 <div style="float: left; padding: 12px 0px 0px 12px">出生日期：</div>
   <div style="float: left; width: 30%;"><input id="applicantBirthday" name="applicantBirthday"  readonly="readonly" type="text" class="am-form-field" style="border:0px; padding-top:15px; width: 140px;color:black; background-color: #fff;"></div>
    <span class="am-input-group-btn am-datepicker-add-on" style="border:0px; background:#fff;">
    <button class="am-btn am-btn-default" type="button" onclick="changecolorapplicant();" style="border:0px; background:#fff;"><span class="am-icon-calendar" ></span> </button>
   </span>
  <div id="applicantBirthdaytemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
</div> -->

					<div id="applicantBirthdayf"
						style="position: relative; height: auto; border-bottom: 1px solid #dedede;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">出生日期：</div>
						<div style="width: 50%; float: left; text-align: left;"
							onclick="changecolorapplicant();">
							<input id="applicantBirthday" name="applicantBirthday"
								readonly="readonly" type="text" class="am-form-field"
								style="border: 0px; padding-top: 15px; width: 100%; color: black; background-color: #fff;">
						</div>
						<div id="insuredBirthdaytemp"
							style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>

					</div>

					<!--   <div id="applicantBirthdayf" class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}" style=" position:relative; height:auto; border-bottom:1px solid #dedede;">
 
 <div style="float: left; padding: 12px 0px 0px 12px">出身日期：</div><input  readonly="readonly" id="applicantBirthday"  type="text" class="am-form-field" style="border:0px; padding-top:15px; width: 40px;background-color: #fff;">
  <span class="am-input-group-btn am-datepicker-add-on" style="border:0px; background:#fff;">
    <button class="am-btn am-btn-default" type="button" style="border:0px; background:#fff;"><span class="am-icon-calendar" ></span> </button>
  </span>
  <div id="applicantBirthdaytemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
 
 
 </div> -->
					<div style="position: relative; height: auto;">
						<div
							style="padding: 1.2rem 0rem 0.8rem 1rem; width: 34%; float: left;">手机号码：</div>
						<div
							style="width: 60%; float: left; padding-top: 10px; text-align: left;">
							<input id="applicantPhone" size="13" name="applicantPhone"
								type="text"
								style="font-size: 16px; height: 30px; width: 100%; text-align: left; border: 0px; padding-right: 10px;"
								placeholder="用于接收激活成功短信">
						</div>
					</div>

					<div id="applicantPhonetemp"
						style="color: red; text-align: left; text-indent: 10px; clear: both;"></div>
				</div>
				<input type="hidden" id="openid" name="openid" value="${openid}">
			</form>
			<input type="hidden" id="toubaoage" name="" value="${toubaoage}">
			<input type="hidden" id="age" name="" value="${age}">
			<section data-am-widget="accordion"
				class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
				<dl class="am-accordion-item am-active" style="clear: both;">
					<dt class="am-accordion-title" style="background-color: #f5f5f5;">保险卡详情</dt>
					<dd class="am-accordion-bd am-collapse am-in">
						<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
						<div class="am-accordion-content">
							<c:if
								test="${product.premium == 0 ||product.premium == null||product.premium == ''}">
        	保费：赠卡<br>
							</c:if>
							<c:if
								test="${product.premium!=0&&product.premium!=null&&product.premium!='' }">
        	保费：${product.premium}元 <br>
							</c:if>

							<%-- <c:if test="${plan.codeproductcode!='0312000100000000' }"> --%>
							<c:if test="${product.type == 1  }">
       适用人群：${age}<br>
							</c:if>
							保险期限：${product.period}${product.periodtype}<br>
						</div>
					</dd>
				</dl>


			</section>

			<section data-am-widget="accordion"
				class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
				<dl class="am-accordion-item am-active" style="clear: both;">
					<dt class="am-accordion-title" style="background-color: #f5f5f5;">您的保障</dt>
					<dd class="am-accordion-bd am-collapse am-in" style="height: auto;">
						<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
						<c:if
							test="${ responsibilityList!= null && fn:length(responsibilityList) > 0 }">
							<div class="am-accordion-content"
								style="font-size: 1.4rem; float: left; border: 1px #dedede solid; width: 100%;">

								<%--   <c:forEach items="${responsibilityList}"	var="responsibility" varStatus="status">
      
      ${responsibility.liability}             <span style="text-align:right; float:right;">￥<fmt:formatNumber value="${responsibility.amount}" pattern="#,#00"/>${responsibility.unit}</span></br>
      
      </c:forEach> --%>

								<c:forEach items="${responsibilityList}" var="responsibility"
									varStatus="status">
									<c:if test="${responsibility.itemDetailName!= null }">
										<c:set var="string1" value="${responsibility.itemDetailName}" />
										<div style="width: 75%; float: left;">${fn:trim(string1)}</div>

										<div style="width: 23%; float: right; text-align: right;">
											${responsibility.amount} 
											${responsibility.unit}
										</div>
									</c:if>
								</c:forEach>

							</div>
						</c:if>
					</dd>
				</dl>


			</section>

			<div style="padding-left: 13px; font-size: 1.4rem; clear: both;">
				<label class="am-checkbox"
					style="font-size: 1.4rem; line-height: 30px;"> <input
					style="width: 20px; height: 20px;" type="checkbox"
					onchange="check(this)" id="gjj"> 我已阅读并同意
					<a	href="${webRoot}/fo/cardController.do?showNotice&openid=${openid}&productid=${product.id}">《投保须知》</a>、
					<a	href="${webRoot}/fo/cardController.do?showArticle&openid=${openid}&productid=${product.id}&planid=${product.planid}">《保险条款》</a>
					<span style="font-size: 22px; color: red" id="promptMessage"></span></label>
				<div id="gjjtemp"
					style="color: red; text-align: left; text-indent: 10px; margin-bottom: 10px;"></div>
				<div id="gjjtempp"
					style="color: red; text-align: left; text-indent: 10px; margin-bottom: 10px;"></div>
				<div id="gjjtemppp"
					style="color: red; text-align: left; text-indent: 10px; margin-bottom: 10px;"></div>
				<div id="gjjtempp1"
					style="color: red; text-align: left; text-indent: 10px; margin-bottom: 10px;"></div>
				<div id="gjjtemppp1"
					style="color: red; text-align: left; text-indent: 10px; margin-bottom: 10px;"></div>

			</div>

			<!-- <a href="#"  ><div style="margin:0 auto; width:90%; height:45px; margin-bottom: 20px; background-color:#0e90d2; text-align:center;  padding:10px 0px 0px 0px; color:#fff; margin-bottom:20px; border-radius:5px;" data-am-loading="{spinner: 'circle-o-notch', loadingText: '激活中...' resetText: '确认激活'}">确认激活</div></a>
 -->
			<button type="button" style="height: 45px; width: 100%;"
				class="am-btn am-btn-primary btn-loading-example" id="submitbutton" >确认激活</button>

		</div>
		<!-- content end -->
		<div style="width: 603px; height: 300px; display: none" id="container"></div>

		<input type="hidden" id="json" value="${json}">
	</div>


	<script>
	$("#checkData").click(function(){
		var occupLevels = $("#occupLevels").val();
		var occupationName = $("#keyword").val();
		var openid = $("#openid").val();
		var cardno = $("#cardno").val();
		if(occupationName !=null){
			$.post('${webRoot}/fo/cardController.do?occupationLevels',{"occupationName":occupationName,"occupLevels": occupLevels,"openid": openid},function(data){
                var ocpList=eval('(' + data + ')');
                var str = '';
                if(ocpList != null){
                	for(var i=0;i<ocpList.length;i++){
                		if(ocpList[i].codeCname1 != null && ocpList[i].codeCname1 != ""){
                			str+='<div class="am-modal-bd"><a href="javascript:void(0);" onclick="setValue(this);" code="'+ocpList[i].codeCode3+'" flag="'+ocpList[i].flag+'" ocpName="'+ocpList[i].codeCname3+'" class="codeCname" id="codeCname">'+ocpList[i].codeCname1+' / '+ocpList[i].codeCname2+' / '+ocpList[i].codeCname3+'</a></div>';
                		}
                	}
                	$("#viewName").html(str);
                }else{
                	str+='<h5>模糊查询个人职业失败，没找到。<h5>';
                	$("#viewName").html(str);
                	$("#viewName").css("padding-top","50px");
                	
                }
            });
		}
	});
	
	/*	function setValue(obj){
		var $modal = $('#my-popup');
		var occupation = $("#occupationName").empty();
		var codeCode = $("#codeCode").attr("value",'');
		var falgCode = $("#flagCode").attr("value",'');
		var occupName = $("#occupName").attr("value",'');
		var code = $(obj).attr("code");
		var flag = $(obj).attr("flag");
		var codeCname = $(obj).attr("ocpName");
		$("#occupationName").html(codeCname);
		$("#codeCode").val(code);
		$("#flagCode").val(flag);
		$("#occupName").val(codeCname);
//		$("#keyword").blur();
		$modal.modal('close');
// 		$(".am-close").trigger("click");
		$("#keyword").val("");
		$("#viewName").empty();
	}*/
		$("#occupationName").click(function(){
		var $modal = $('#my-popup').modal('open');
// 		 $("#keyword").focus();
	});
 	function setValue(obj){
		var occupation = $("#occupationName").attr("value",'');
		var codeCode = $("#codeCode").attr("value",'');
		var falgCode = $("#flagCode").attr("value",'');
		var code = $(obj).attr("code");
		var flag = $(obj).attr("flag");
		var codeCname = $(obj).attr("ocpName");
		$("#occupationName").attr("value",codeCname);
		$("#codeCode").val(code);
		$("#flagCode").val(flag);
		$(".am-close").trigger("click");
		$("#keyword").val("");
		$("#viewName").empty();
	} 

//根据商品配置参数，判断是否出现标的地址 	
 	
<c:if test="${showContractAddress =='Y'}">

//自动获得地址 	
 	var latitude=24.482166;   //用户当前经度
	var longitude=118.099313;  //用户当前纬度
	var ss='${json}';
	var parsedJson = jQuery.parseJSON(ss); 
    //微信地图 js 
	wx.config(${JSONString});
	//1.判断当前版本是否支持指定 JS 接口，支持批量判断
	 wx.ready(function () {
		 getLocation();
	  });  
	wx.error(function (res) {	
		  alert(res.errMsg);	
		  });
	
     //去掉数组中的重复的元素 
	 var    inArray = function(arr, elt) {
         for(var i = 0, len = arr.length; i < len; i++) {
             if(arr[i] === elt) {
                 return true;
             }
         }
         return false;
     };
     
     var    unique = function(arr) {
         if(arr.length < 2) return arr;
         var i = 0, len = arr.length; re = [];
         for(; i < len; i++) {
             if(!inArray(re, arr[i])) {
                 re.push(arr[i]);
             }
         }
         return re;
     };
	
	// 7.2 获取当前地理位置
	function getLocation(){	
	  wx.getLocation({
	    success: function (res) {    	 
	      longitude=res.longitude;
	 	  latitude=res.latitude;
	 	  initLocation (latitude,longitude);
	     },
	    cancel: function (res) {
	    alert('用户拒绝授权获取地理位置');	 
	  //  sanjiliandong();
	    
	    }
	  });
	}
	
	//腾讯地图js
	var citylocation,map,marker = null;  
	 //根据 用户实际位置定位 	 
	function initLocation(latitude,longitude){
		 var center = new qq.maps.LatLng(latitude,longitude);
		 map = new qq.maps.Map(document.getElementById('container'),{
		        center: center,
		        zoom: 13
		 });
		    var info = new qq.maps.InfoWindow({map: map});
		    geocoder = new qq.maps.Geocoder({
		        complete : function(result){
		        	//该处修改为设置省市下拉框
		        	//alert(result.detail.addressComponents.province+result.detail.addressComponents.city);
		        	var provinceW=result.detail.addressComponents.province;
		        	var cityW=result.detail.addressComponents.city;

					  var tmpprovinceCC = new Array(); 
					  var tmpcityCC = new Array();

			 			$.each(parsedJson,function(key,value){
			 		       if(value.province==provinceW){
			 		    	  tmpprovinceCC.push(value.provinceCode);
			 		        }
			 		       
			 		      if(value.city==cityW){
			 		    	 tmpcityCC.push(value.cityCode);
			 		        }
	 
			 		      });
			 	        
			       		var tmpprovinceCodeC=unique(tmpprovinceCC);
			       		var tmpcityCodeC=unique(tmpcityCC);
			       	    $("#provinceId").html("");
			 		    $("#cityId").html("");
			 		    for(var i in tmpprovinceCodeC){
			               	//该元素在tmp内部不存在才允许追加 
		                   //alert(tmpprovinceCodeC[i]);  
		                  // alert(tmpcityCodeC[i]);  
		                   
				 		   $("#provinceId").append("<option value='"+tmpprovinceCodeC[i] +"'>"+provinceW+"</option>");
				 		    $("#cityId").append("<option value='"+tmpcityCodeC[i]+"'>"+cityW+"</option>");
				 		  // $("#provinceId").find("option[value='"+tmpprovinceCodeC[i]+"']").attr("selected",true);  
				 		  // $("#cityId").find("option[value='"+tmpcityCodeC[i]+"']").attr("selected",true);  
				 		 
			 		    }  
			 		    sanjiliandong();
			 		    
						  var tmpcityNA = new Array(); 
						  var tmpcityCA = new Array();

				 			$.each(parsedJson,function(key,value){
				 		       if(value.province==provinceW){
				 		    	  tmpcityNA.push(value.city);
				 		    	  tmpcityCA.push(value.cityCode);
				 		        }
				 		      });
 
				       		var tmpcityNameA=unique(tmpcityNA);
				       		var tmpcityCodeA=unique(tmpcityCA);
				 		    for(var i in tmpcityNameA){
				               	//该元素在tmp内部不存在才允许追加
			                    $("#cityId").append("<option value='"+tmpcityCodeA[i]+"'>"+tmpcityNameA[i]+"</option>");
				               	}   
    
				 		   var tmpcountyNA = new Array(); 
				 			  var tmpcountyCA = new Array();

					 			$.each(parsedJson,function(key,value){
					 		       if(value.cityCode==$("#cityId").val()){
					 		    	  tmpcountyNA.push(value.county);
					 		    	  tmpcountyCA.push(value.countyCode);
					 		        }
					 		      });
					
			      
					       		var tmpcountyNameA=unique(tmpcountyNA);
					       		var tmpcountyCodeA=unique(tmpcountyCA);
					 		    for(var i in tmpcountyNameA){
				 	               	//该元素在tmp内部不存在才允许追加
				                      $("#areaId").append("<option value='"+tmpcountyCodeA[i]+"'>"+tmpcountyNameA[i]+"</option>");
				 	               	
				 	               	
				 	               	}   
		            map.setCenter(result.detail.location);
		            var marker = new qq.maps.Marker({
		                map:map,
		                position: result.detail.location
		            });
		            qq.maps.event.addListener(marker, 'click', function() {
		                info.open();
		                info.setContent('<div style="width:280px;height:100px;">'+
		                    result.detail.address+'</div>');
		                info.setPosition(result.detail.location);
		            });
		        }
		    });	
		    geocoder.getAddress(center);  //根据 经纬度 定位用户所属市区、地址 
	}

	//家财卡初始化 
	$(document).ready(function () {
		   sanjiliandong(); 
	});
	//三级联动 
	function sanjiliandong(){
	  	 /*	三级联动   */ 
	 	
 		
		  var tmpprovinceN = new Array(); 
		  var tmpprovinceC = new Array();
		  //var parsedJson = jQuery.parseJSON(ss); 
		  
			$.each(parsedJson,function(key,value){
		    	  tmpprovinceN.push(value.province);
		    	  tmpprovinceC.push(value.provinceCode);
		      });

     		var tmpprovinceName=unique(tmpprovinceN);
     		var tmpprovinceCode=unique(tmpprovinceC);
     		
		    for(var i in tmpprovinceName){
             	//该元素在tmp内部不存在才允许追加
       
            $("#provinceId").append("<option value='"+tmpprovinceCode[i] +"'>"+tmpprovinceName[i]+"</option>");  

             	}      

	        $("#provinceId").change(function () {  
	       	 var data2="provinceId="+$("#provinceId").val();
	       	 if($("#provinceId").val()!="a"){
	      

			  var tmpcityN = new Array(); 
			  var tmpcityC = new Array();

	 			$.each(parsedJson,function(key,value){
	 		       if(value.provinceCode==$("#provinceId").val()){
	 		    	  tmpcityN.push(value.city);
	 		    	  tmpcityC.push(value.cityCode);
	 		        }
	 		      });
	
	 	        
	       		var tmpcityName=unique(tmpcityN);
	       		var tmpcityCode=unique(tmpcityC);
	       		$("#cityId").html("");
	 		    for(var i in tmpcityName){
	               	//该元素在tmp内部不存在才允许追加
                    $("#cityId").append("<option value='"+tmpcityCode[i]+"'>"+tmpcityName[i]+"</option>");
	               	}   
	 		    
	 		    
	 			  var tmpcountyN = new Array(); 
	 			  var tmpcountyC = new Array();

		 			$.each(parsedJson,function(key,value){
		 		       if(value.cityCode==$("#cityId").val()){
		 		    	  tmpcountyN.push(value.county);
		 		    	  tmpcountyC.push(value.countyCode);
		 		        }
		 		      });
		
      
		       		var tmpcountyName=unique(tmpcountyN);
		       		var tmpcountyCode=unique(tmpcountyC);
		       		$("#areaId").html("");
		 		    for(var i in tmpcountyName){
	 	               	//该元素在tmp内部不存在才允许追加
	                      $("#areaId").append("<option value='"+tmpcountyCode[i]+"'>"+tmpcountyName[i]+"</option>");
	 	               	
	 	               	
	 	               	}      	
	 		    
	 		    
	       	 }else{
	       	  $("#cityId").html("");
	       	  $("#cityId").append("<option value='a'>选择市</option>");
	       	$("#areaId").html("");
	        $("#areaId").append("<option value='a'>选择区</option>"); 
	       	 }
	       });
	    $("#cityId").change(function () {
	    	 var data3="cityId="+$("#cityId").val();
	    	 if($("#cityId").val()!="a"){

	 			  var tmpcountyN = new Array(); 
	 			  var tmpcountyC = new Array();

		 			$.each(parsedJson,function(key,value){
		 		       if(value.cityCode==$("#cityId").val()){
		 		    	  tmpcountyN.push(value.county);
		 		    	  tmpcountyC.push(value.countyCode);
		 		        }
		 		      });
		
      
		       		var tmpcountyName=unique(tmpcountyN);
		       		var tmpcountyCode=unique(tmpcountyC);
		       		$("#areaId").html("");
		 		    for(var i in tmpcountyName){
	 	               	//该元素在tmp内部不存在才允许追加
	                      $("#areaId").append("<option value='"+tmpcountyCode[i]+"'>"+tmpcountyName[i]+"</option>");

	 	               	}      	 
	    	 }
	    }); 

	}	 
		
</c:if>
		var typee='${product.type}';
		var flag;
		var flagtoubao;
		$("#gjjtempp").text('');
		//初始化		
	   $(document).ready(function () {
		   
	          $('#insuredBirthday').mobiscroll().date({
                  theme: 'android-holo-light',     // Specify theme like: theme: 'ios' or omit setting to use default 
                  mode: 'modal',       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
                  lang: 'zh',        // Specify language like: lang: 'pl' or omit setting to use default 
                  dateFormat: 'yy-mm-dd',
                  maxDate: new Date(),
                  yearText: "年",

              });
	          
	          $('#applicantBirthday').mobiscroll().date({
                  theme: 'android-holo-light',     // Specify theme like: theme: 'ios' or omit setting to use default 
                  mode: 'modal',       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
                  lang: 'zh',        // Specify language like: lang: 'pl' or omit setting to use default 
                  dateFormat: 'yy-mm-dd',
                  maxDate: new Date(),
                  yearText: "年",

              });
		   
		var check=document.getElementById("hjj").value;
	    /**初始化	显示投保人信息 **/		
		if(document.getElementById("hjj").checked){  
			 $("#hjj").attr("value","1"); 
			$("#kjj").hide();
			$("#checkh").attr("value","1");
		}else{
			 $("#hjj").attr("value","0"); 
			$("#kjj").show();
			$("#checkh").attr("value","0");
		}		
		
		//根据身份类型判断 是否将性别，生日日期隐藏 
		$("#ci").change(function () {
	      	 var identifytype=$("#ci").val();
	      	 if(identifytype=="01"){
	    		 $("#birthdayf").hide();
	    		 $("#genderf").hide();
	    	 }else{
	    		 $("#birthdayf").show();
	    		 $("#genderf").show();
	    		 
	    	 }
	    });
		$("#cii").change(function () {
	     	 var identifytypee=$("#cii").val();
	     	 if(identifytypee=="01"){
	   		 $("#applicantBirthdayf").hide();
	   		 $("#applicantGenderf").hide();
	   	 }else{
	   		 $("#applicantBirthdayf").show();
	   		 $("#applicantGenderf").show();
	   		 
	   	 }
	   }); 
		
		/*	 点击投保人同被保人显示隐藏切换       */  
		$("#hjj").click(function(){
			var check=document.getElementById("hjj").value;
			
			if(document.getElementById("hjj").checked){  
				 $("#hjj").attr("value","1"); 
				$("#kjj").hide();
				 $("#checkh").attr("value","1");
			}else{
				 $("#hjj").attr("value","0"); 
				$("#kjj").show();
				 $("#checkh").attr("value","0");
			}
		});
		
	
	
		//var i=0;  //判断点击次数寄存
		//var closetimer = null;  //延时函数寄存
	    /*  提交处理函数    */
		$('#submitbutton').click(function () {
			//console.log('1');
			//i++;  //记录点击次数
			//closetimer = window.setTimeout(setout,200);  
			
		/* 	function setout(){  //点击执行事件
			if(i>1)   //如果点击次数超过1
			{
			console.log('wrong');
			window.clearTimeout(closetimer);  //清除延时函数
			closetimer = null;  //设置延时寄存为null
			//添加操作代码        
			i=0;  //重置点击次数为0
			}
			else{  //如果点击次数为1
			console.log('right');
			i=0;  //重置点击次数为0
			//添加执行操作的代码
			}
			} */
	
			 var checkh=document.getElementById("hjj").value;//投保人与被保人是否 是同一个   
			 var cardno=$("#cardno").val();
			 var type=$("#type").val();//卡号类型 （家财/意外 ）
			 var openid=$("#openid").val();
	
			 var insuredName=$("#insuredName").val();
		  	 var insuredIdentifytype=$("#ci").val();
		  	 
			 var insuredIdentifynumber=$("#insuredIdentifynumber").val();
			
			 var insuredGender=$("#insuredGender").val();
			 var insuredBirthday=$("#insuredBirthday").val().replace("出生日期：","");
			 
			 var insuredPhone=$("#insuredPhone").val();
			 
			 if($("#provinceId").val()!=null&&$("#provinceId").val()!="undefined"){
				 provinceCode=$("#provinceId").val();
				 cityCode=$("#cityId").val();
				 areaCode=$("#areaId").val();
				 detial=$("#detial").val();   
			 }
			 
			 var token=$("#token").val();
			 var applicantName="";
			 var applicantIdentifytype="";
			 var applicantNumber="";
			 var applicantPhone="";
			 var applicantGender="";
			 var applicantBirthday="";
				if(checkh==0){
					  applicantName=$("#applicantName").val();
					  applicantIdentifytype=$("#cii").val();				  
					  applicantNumber=$("#applicantNumber").val();
					  applicantPhone=$("#applicantPhone").val();
					  applicantGender=$("#applicantGender").val();
					  applicantBirthday=$("#applicantBirthday").val().replace("出生日期：","");
				}
		  //  var btn = $('#submitbutton');				  
			  if(checkAll()){ 
			/* 	  btn.button('loading');
				    setTimeout(function(){
				        btn.button('reset');
				    }, 15000); */
				    $("#submitbutton").attr("disabled","disabled");
				  document.form1.submit(); 
			        
			  }  
		});
	});
//失去焦点检查 
	/*  失去焦点提示信息(姓名) */
	$('#insuredName').blur(function(){
		 var name1=$("#insuredName").val();
		 $("#insuredNametemp").text('');
		 if(name1==""||name1==null){
			$("#insuredNametemp").text('**姓名不能为空！   ');
			 result = false; 
		 }
	});
	/*  失去焦点提示信息(工作职业 ) 
	var type1=$("#type").val();
	$('#occupationName').blur(function(){
		 var ocupName=$("#occupationName").val(); 
		 if(type1=='1'){
			 $("#occupationNametemp").text('');
			 if(ocupName==""||ocupName==null){
					$("#occupationNametemp").text('**工作职业不能为空！    ');
				 result = false; 
			 }	 
		 }
	});	*/
	/*  失去焦点提示信息(证件 类型) */
	$('#insuredIdentifytype').blur(function(){
		var identifytype1=$("#insuredIdentifytype").val();
		 $("#insuredIdentifytypetemp").text('');
		 if(identifytype1==""||identifytype1==null){
			$("#insuredIdentifytypetemp").text('**身份证类型不能为空！    ');
			 result = false; 
		 }
	});
	/*  失去焦点提示信息(证件号码 ) */
	$('#insuredIdentifynumber').blur(function(){
		 var identifynumber1=$("#insuredIdentifynumber").val();
		 $("#insuredIdentifynumbertemp").text('');
		 if(identifynumber1==""||identifynumber1==null){
				$("#insuredIdentifynumbertemp").text('**证件号码不能为空！     ');
			 result = false; 
		 }
	});
	/*  失去焦点提示信息(性别 ) */
	$('#insuredGender').blur(function(){
		 var gender1=$("#insuredGender").val();	
		 $("#insuredGendertemp").text('');
		 if(gender1==""||gender1==null){
				$("#insuredGendertemp").text('**性别不能为空！     ');
			 result = false; 
		 }
	});
	/*  失去焦点提示信息(出生日期  ) */
	$('#insuredBirthday').blur(function(){
		 var birthday1=$("#insuredBirthday").val().replace("出生日期：","");
		 $("#insuredBirthdaytemp").text('');
		 if(birthday1==""||birthday1==null){
				 $("#insuredBirthday").attr("value","**生日日期不能为空！");
				 $("#insuredBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:red; background-color: #fff;");//单个属性的设置 
			 result = false; 
		 }
	});
	/*  失去焦点提示信息(手机号码 ) */
	$('#insuredPhone').blur(function(){
		 var phone1=$("#insuredPhone").val();
		 $("#insuredPhonetemp").text('');
		   var re=/^1[0-9]{10}$/; 
			if(!re.test(phone1)){   
				$("#insuredPhonetemp").text('**手机号格式不对！       ');
			 result = false; 
			}
	});

	/*  失去焦点提示信息(投保人姓名 ) */
	$('#applicantName').blur(function(){
		 var applicantName=$("#applicantName").val();
		 $("#applicantNametemp").text('');
		 if(applicantName==""||applicantName==null){
			$("#applicantNametemp").text('**姓名不能为空！   ');
			 result = false; 
		 }
	});
	
	/*  失去焦点提示信息(投保人证件类型  ) */
	$('#applicantIdentifytype').blur(function(){
		var applicantIdentifytype=$("#applicantIdentifytype").val();
		 $("#applicantIdentifytypetemp").text('');
		 if(applicantIdentifytype==""||applicantIdentifytype==null){
			$("#applicantIdentifytypetemp").text('**身份证类型不能为空！    ');
			 result = false; 
		 }
	});
	
	/*  失去焦点提示信息(投保人证件号码   ) */
	$('#applicantNumber').blur(function(){
		 var applicantNumber1=$("#applicantNumber").val();
		 $("#applicantNumbertemp").text('');
		 if(applicantNumber1==""||applicantNumber1==null){
				$("#applicantNumbertemp").text('**证件号码不能为空！     ');
			 result = false; 
		 }
	});
	
	
	/*  失去焦点提示信息(投保人证件性别    ) */
	$('#applicantGender').blur(function(){
		 var applicantGender=$("#applicantGender").val();	
		 $("#applicantGendertemp").text('');
		 if(applicantGender==""||applicantGender==null){
				$("#applicantGendertemp").text('**性别不能为空！     ');
			 result = false; 
		 }
	});
	
  <c:if test="${showCarMessage =='Y'}">	
	$('#insuredCarOwners').change(function(){
		 var insuredCarOwners= $("#insuredCarOwners") ; 		
        var val= insuredCarOwners.val();
        var text= insuredCarOwners.find("option:selected").text(); 
        if(text=='本人'||val=='01'){			            	
        	 $("#insuredCarOwnerName").val($("#insuredName").val());        	
        	 $("#insuredCarOwnerInput").hide();
          }else{
        	  $("#insuredCarOwnerName").val(""); 
        	  $("#insuredCarOwnerInput").show();
          }		
	   });
	//车牌号校验 
	$('#insuredLicenseNo').blur(function(){
		 var licenseNo=$("#insuredLicenseNo").val();
		 $("#insuredLicenseNotemp").text('');
		var licenseNoLength=licenseNo.length;
		 
		 if(licenseNoLength<5||licenseNoLength>8){
			$("#insuredLicenseNotemp").text('**请正确输入车牌号**');
			 result = false; 
		 }
	});
	
  </c:if>
	/*  失去焦点提示信息(投保人出生日期     ) */
	$('#applicantBirthday').blur(function(){
		 var applicantBirthday=$("#applicantBirthday").val().replace("出生日期：","");	
		 $("#applicantBirthdaytemp").text('');	
		 if(applicantBirthday==""||applicantBirthday==null){
				 $("#applicantBirthday").attr("value","**生日日期不能为空！");	
				 $("#applicantBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:red; background-color: #fff;");//单个属性的设置 
			 result = false; 
		 } 
	});
	/*  失去焦点提示信息(投保人手机号   ) */
	$('#applicantPhone').blur(function(){
		 var applicantPhone=$("#applicantPhone").val();
		 $("#applicantPhonetemp").text('');
		   var re=/^1[0-9]{10}$/; 
			if(!re.test(applicantPhone)){   
			 $("#applicantPhone").focus();
				$("#applicantPhonetemp").text('**手机号格式不对！       ');
			 result = false; 
			}
	});
	
	/*  失去焦点提示信息(详细地址   ) */
	$('#detial').blur(function(){
		 var type2=$("#type").val();
		 if($("#provinceId")!=null){
			 detial2=$("#detial").val(); 
		 }
		 if(type2=='2'){
			 $("#detialtemp").text('');
			 if(detial2==""||detial2==null){
					$("#detialtemp").text('**详细地址不能为空！      ');
				 result = false; 
			 }	 
		 }
	});	
	
	
	function check(obj) {
		if(obj.checked==true){
			$("#gjjtemp").text('');
		}else{
			$("#gjjtemp").text('**请先勾选我已经阅读！   ');
		}
	}



//按钮点击检查 
          /*根据出生日期计算出 年龄   */
	       function jsGetAge(strBirthday){       
			var returnAge;
			var strBirthdayArr=strBirthday.split("-");
			var birthYear = strBirthdayArr[0];
			var birthMonth = strBirthdayArr[1];
			var birthDay = strBirthdayArr[2];
			
			d = new Date();
			var nowYear = d.getFullYear();
			var nowMonth = d.getMonth() + 1;
			var nowDay = d.getDate();
			
			if(nowYear == birthYear)
			{
				returnAge = 0;//同年 则为0岁
			}
			else
			{
				var ageDiff = nowYear - birthYear ; //年之差
				if(ageDiff > 0)
				{
					if(nowMonth == birthMonth){
						var dayDiff = nowDay - birthDay;//日之差
						if(dayDiff < 0)
						{returnAge = ageDiff - 1;}
						else
						{returnAge = ageDiff ;}
					}else{
						var monthDiff = nowMonth - birthMonth;//月之差
						if(monthDiff < 0)
						{returnAge = ageDiff - 1;}
						else
						{returnAge = ageDiff ;}
					}
				}
				else
				{returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天}
			}
			return returnAge;//返回周岁年龄
	    }
	  
	    }

	  /*处理改变生日日期颜色函数 （被保人） */
		function changecolor(){
			 if($("#insuredBirthday").val()=="**生日日期不能为空！"){
				 $("#insuredBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:black; background-color: #fff;");//单个属性的设置 
				 $("#insuredBirthday").attr("value","");
			 }
			 if($("#insuredBirthday").val()!=""&&$("#insuredBirthday").val()!="**生日日期不能为空！"){
				 $('.am-form-field').datepicker('setValue', $("#insuredBirthday").val());
			 }
			 
		}
		 /*处理改变生日日期颜色函数 （投保人）  */
		function changecolorapplicant(){ 
			 if($("#applicantBirthday").val()=="**生日日期不能为空！"){
				 $("#applicantBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:black; background-color: #fff;");//单个属性的设置 
				 $("#applicantBirthday").attr("value","");
			 }
			 if($("#applicantBirthday").val()!=""&&$("#applicantBirthday").val()!="**生日日期不能为空！"){
				 $('.am-form-field').datepicker('setValue', $("#insuredBirthday").val());
			 }
		}
    
		var $btn = $('#submitbutton');
		/*检查页面输入完整性*/ 
		function  checkAll() {	
			var result = true;
			 var agree=document.getElementById("gjj").value;
			 var insuredName=$("#insuredName").val();
			 var insuredIdentifytype=$("#ci").val();
			 var insuredIdentifynumber=$("#insuredIdentifynumber").val();
			 var type=$("#type").val();
			 var occupLevels = $("#occupLevels").val();
			 var insuredGender=$("#insuredGender").val();
			 var occName = $("#occupationName").val();
			 var insuredBirthday=$("#insuredBirthday").val().replace("出生日期：","");
			 var insuredPhone=$("#insuredPhone").val();
			 if($("#provinceId")!=null){
				 provinceCode=$("#provinceId").val();
				 cityCode=$("#cityId").val();
				 areaCode=$("#areaId").val();
				 detial=$("#detial").val(); 
			 }
			 var applicantName="";
			 var applicantIdentifytype="";
			 var applicantNumber="";
			 var applicantPhone="";
			 var applicantGender="";
			 var applicantBirthday="";
			 var checkh=document.getElementById("hjj").value;
				if(checkh==0){
					  applicantName=$("#applicantName").val();
					  applicantIdentifytype=$("#applicantIdentifytype").val();
					  applicantNumber=$("#applicantNumber").val();
					  applicantPhone=$("#applicantPhone").val();
					  applicantGender=$("#applicantGender").val();
					  applicantBirthday=$("#applicantBirthday").val().replace("出生日期：","");
				}
				 
				$("#gjjtemp").text('');
			  if(!document.getElementById("gjj").checked){
				$("#gjjtemp").text('**请先勾选我已经阅读！   ');
				 result = false;	 
			 }

			 if(type=="2"){
			
				 $("#detialtemp").text('');
				 if(detial==""||detial==null){
					 $("#detial").focus();
						$("#detialtemp").text('**详细地址不能为空！      ');
					 result = false; 
				 }	 
			 }
			 
			 $("#insuredNametemp").text('');
			 if(insuredName==""||insuredName==null){
				$("#insuredName").focus();
				$("#insuredNametemp").text('**姓名不能为空！   ');
				 result = false; 
			 }
			 if(type=="1" && occupLevels!="" ){
				 $("#occupationNametemp").text('');
				 if(occName==""||occName==null){
					$("#occupationNametemp").text('**工作职业不能为空！   ');
					 result = false; 
				 }
			 }
			 $("#insuredIdentifytypetemp").text('');
			 if(insuredIdentifytype==""||insuredIdentifytype==null){
				 $("#insuredIdentifytype").focus();
				$("#insuredIdentifytypetemp").text('**身份证类型不能为空！    ');
				 result = false; 
			 }
			 $("#insuredIdentifynumbertemp").text('');
			 if(insuredIdentifynumber==""||insuredIdentifynumber==null){
				 $("#insuredIdentifynumber").focus();
					$("#insuredIdentifynumbertemp").text('**证件号码不能为空！     ');
				 result = false; 
			 }
			 $("#insuredGendertemp").text('');
			 if(insuredGender==""||insuredGender==null){
				 $("#insuredGender").focus();
					$("#insuredGendertemp").text('**性别不能为空！     ');
				 result = false; 
			 }
		
			 $("#insuredBirthdaytemp").text('');	
			 if(insuredBirthday==""||insuredBirthday==null){
					 $("#insuredBirthday").attr("value","**生日日期不能为空！");
					 $("#insuredBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:red; background-color: #fff;");//单个属性的设置 
					
				 result = false; 
			 }
			
			 
			 $("#insuredPhonetemp").text('');
			   var re=/^1[0-9]{10}$/; 
				if(!re.test(insuredPhone)){   
				 $("#insuredPhone").focus();
					$("#insuredPhonetemp").text('**手机号格式不对！       ');
					//$btn.button('reset');
				 result = false; 
				}	
				 $("#gjjtemppp1").text('');
				 $("#gjjtempp1").text('');
				 if(checkh==0){	 
 
					 $("#applicantNametemp").text('');
					 if(applicantName==""||applicantName==null){
						$("#applicantName").focus();
						$("#applicantNametemp").text('**姓名不能为空！   ');
						 result = false; 
					 }
					 
					 
					 $("#applicantNumbertemp").text('');
					 if(applicantNumber==""||applicantNumber==null){
						 $("#applicantNumber").focus();
							$("#applicantNumbertemp").text('**证件号码不能为空！     ');
						 result = false; 
					 }
					 
					 
					 $("#applicantGendertemp").text('');
					 if(applicantGender==""||applicantGender==null){
						 $("#applicantGender").focus();
							$("#applicantGendertemp").text('**性别不能为空！     ');
						 result = false; 
					 }
					 $("#applicantBirthdaytemp").text('');
					 if(applicantBirthday==""||applicantBirthday==null){
							 $("#applicantBirthday").attr("value","**生日日期不能为空！");	
							 $("#applicantBirthday").attr("style", "border:0px; padding-top:15px; width: 170px;color:red; background-color: #fff;");//单个属性的设置 
						 result = false; 
					 }
					 
					 
					 
					 $("#applicantPhonetemp").text('');
					   var re=/^1[0-9]{10}$/; 
						if(!re.test(applicantPhone)){   
						 $("#applicantPhone").focus();
							$("#applicantPhonetemp").text('**手机号格式不对！       ');
						 result = false; 
						} 
						
						


					var age='${age}';
					
					if(age!="0-0岁"){
					 if(insuredBirthday!=""){ 
						  var strAgetem=jsGetAge(insuredBirthday);
			        		//alert(strAgetem);
						 $("#gjjtempp").text('');
		        		 // var   r   =   insuredBirthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
		  		        //if(r==null)return   false;     
		  		        //var   d=   new   Date(r[1],   r[3]-1,   r[4]);     
		  		       // if   (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])   
		  		        //{   	
		  		              //var   Y   =   new   Date().getFullYear();   
		  		              //var strAge=Y-r[1];
		  		              var agee=age.split("-");
		  		              var min=agee[0];
		  		              var max=agee[1].replace("岁","");
		  		              if(strAgetem<min||strAgetem>max){ 
		  		            	  $("#gjjtempp1").text("**被保人为 "+strAgetem+"岁，不在年龄范围（"+age+"）内！  "); 
			        			  result = false;  
		  		              }
		  		        //}   
	     			
					 }
					}

					 var toubaoage='${toubaoage}';
					 
					 if(toubaoage!="0-0岁"){
					 if(applicantBirthday!=""){ 
						 var strAgeetem=jsGetAge(applicantBirthday);
			        		//alert(strAgeetem);
						 $("#gjjtemppp").text('');
			  		      //var   rr   =   applicantBirthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
					       // if(rr==null)return   false;     
					       // var   dd=   new   Date(rr[1],   rr[3]-1,   rr[4]);     
					        //if   (dd.getFullYear()==rr[1]&&(dd.getMonth()+1)==rr[3]&&dd.getDate()==rr[4])   
					       // {   	
					        	 
					              //var   YY   =   new   Date().getFullYear();   
					             // var strAgee=YY-rr[1];
					              var ageee=toubaoage.split("-");
					              var minn=ageee[0];
					              var maxx=ageee[1].replace("岁","");
					              if(strAgeetem<minn||strAgeetem>maxx){
					            	  $("#gjjtemppp1").text("**投保人为 "+strAgeetem+"岁，不在年龄范围（"+toubaoage+"）内！  "); 
				        			  result = false; 
					              } 
					       // }   

					 }	
					 }		
				 }
				
				 $("#gjjtempp").text('');
			         if(checkh==1){
			        	 $("#gjjtemppp1").text('');
						 $("#gjjtempp1").text('');
			        	if(insuredBirthday!=""){
			        		var strAgetemp=jsGetAge(insuredBirthday);
			        		//alert(strAgetemp);
			        		
			        		
			        		  $("#gjjtempp").text('');
			        		  var age1='${age}'; 
			        		  if(age1!="0-0岁"){
			        		 // var   r   =   insuredBirthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
			  		       // if(r==null)return   false;     
			  		        //var   d=   new   Date(r[1],   r[3]-1,   r[4]);     
			  		        //if   (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])   
			  		        //{   	
			  		        	  
			  		              //var   Y   =   new   Date().getFullYear();   
			  		              //var strAge=Y-r[1];
			  		              var agee=age1.split("-");
			  		              var min=agee[0];
			  		              var max=agee[1].replace("岁","");
			  		              if(strAgetemp<min||strAgetemp>max){
			  		            	  $("#gjjtempp").text("**被保人为 "+strAgetemp+"岁，不在年龄范围（"+age1+"）内！  "); 
				        			  result = false;  
			  		              } 
			  		        //} 
			        		  }
			  		      $("#gjjtemppp").text('');	 
			  		    var toubaoage1='${toubaoage}';
			  		  var strAgeetemp=jsGetAge(insuredBirthday);
		        		//alert(strAgeetemp);
			  		      if(toubaoage1!="0-0岁"){
			  		     // var   rr   =   insuredBirthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
					       // if(rr==null)return   false;     
					       // var   dd=   new   Date(rr[1],   rr[3]-1,   rr[4]);     
					        //if   (dd.getFullYear()==rr[1]&&(dd.getMonth()+1)==rr[3]&&dd.getDate()==rr[4])   
					       // {   	
					        	 
					              //var   YY   =   new   Date().getFullYear();   
					             // var strAgee=YY-rr[1];
					              var ageee=toubaoage1.split("-");
					              var minn=ageee[0];
					              var maxx=ageee[1].replace("岁",""); 
					              if(strAgeetemp<minn||strAgeetemp>maxx){
					            	  $("#gjjtemppp").text("**投保人为 "+strAgeetemp+"岁，不在年龄范围（"+toubaoage1+"）内！  "); 
				        			  result = false; 
					              }
					       // }  
					        
			  		      }
			        	  }
						 }
			         <c:if test="${showCarMessage =='Y'}">	
			            var insuredCarOwners= $("#insuredCarOwners") ;  
			            var val= insuredCarOwners.val();
			            var text= insuredCarOwners.find("option:selected").text(); 
			            $("#insuredCarOwnerstemp").text("");
			            if(text=='请选择'||val=='请选择'){
			             $("#insuredCarOwnerstemp").text(" 请选择与车主的关系  ");
			             result = false; 
			            }else {
			            	  $("#insuredCarOwnersValue").val(val);
			                  $("#insuredCarOwnersText").val(text);
			               }
			            if(text=='本人'||val=='01'){			            	
			            	 $("#insuredCarOwnerName").val($("#insuredName").val()); 
			              }
			               var insuredLicenseNo=$("#insuredLicenseNo").val();			            
			               $("#insuredLicenseNotemp").text('');
						 if(insuredLicenseNo==""||insuredLicenseNo==null){
								 $("#insuredLicenseNo").focus();
									$("#insuredLicenseNotemp").text('**车牌号不能为空**');
								 result = false; 
							 }							 						 
					     var insuredCarOwnerName=$("#insuredCarOwnerName").val();			            
				            $("#insuredCarOwnerNametemp").text('');
							 if(insuredCarOwnerName==""||insuredCarOwnerName==null){
								$("#insuredCarOwnerName").focus();
								$("#insuredCarOwnerNametemp").text('**车主姓名不能为空**');
								 result = false; 
							  }			            
			          </c:if>			         
			return result;
		}
//外来js(身份证号码检查 )
	
	
	
	//响应单击事件
	$(function() {
	  $('#insuredIdentifynumber').blur(function() {
	      var strinput = $("#insuredIdentifynumber").val();
	      var identifytype22 = $("#ci").val()
	      if (identifytype22 == '01') {
	          if (isCardIDD(strinput, 1)) { 
	        	  var setx=(strinput.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
				 /*   if(strinput.replace(/x$/i,"a").substr(16,1)%2){
					   sex="男";
				   }else{
					   sex="女";
				   } */
	              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
	              if (sBirthdayy!= "undefined" && setx != "undefined"&&sBirthdayy!= "" && setx != "") {
	            	  if(setx=="男"){
	            		  setx="M";
	            	  }
	            	  if(setx=="女"){
	            		  setx="F";
	            	  }
	            	  var iss=sBirthdayy.split("-");
	            	  if(iss[2].length=='1'&&iss[1].length!='1'){
	            		  sBirthdayy=iss[0]+"-"+iss[1]+"-"+"0"+iss[2];
	            	  }
	            	  if(iss[1].length=='1'&&iss[2].length!='1'){
	            		  sBirthdayy=iss[0]+"-0"+iss[1]+"-"+iss[2];
	            	  }
	            	  if(iss[1].length=='1'&&iss[2].length=='1'){
	            		  sBirthdayy=iss[0]+"-0"+iss[1]+"-"+"0"+iss[2];
	            	  }
	            	  $("#insuredGender").val(setx);
	                  $("#insuredBirthday").val(sBirthdayy);
	              }
	          }
	      }
	  });
	
	  $('#applicantNumber').blur(function() {
	      var strinput2 = $("#applicantNumber").val();
	      var identifytype = $("#cii").val();
	      if (identifytype == '01') {
	          if (isCardID(strinput2, 2))
	          {
	        	
	        	  var applicantsex=(strinput2.replace(/x$/i,"a").substr(16,1)%2?"男":"女"); 
			
	              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
	              if (sBirthday != "undefined" && applicantsex != "undefined"&&sBirthday != "" &&applicantsex != "") {
	            	  if(applicantsex=="男"){
	            		  applicantsex="M";
	            	  }
	            	  if(applicantsex=="女"){
	            		  applicantsex="F";
	            	  }
	            	  var ass=sBirthday.split("-");
	            	  if(ass[2].length=='1'&&ass[1].length!='1'){
	            		  sBirthday=ass[0]+"-"+ass[1]+"-"+"0"+ass[2];
	            	  }
	            	  if(ass[1].length=='1'&&ass[2].length!='1'){
	            		  sBirthday=ass[0]+"-0"+ass[1]+"-"+ass[2];
	            	  }
	            	  if(ass[1].length=='1'&&ass[2].length=='1'){
	            		  sBirthday=ass[0]+"-0"+ass[1]+"-"+"0"+ass[2];
	            	  }
	            	  
	            	  $("#applicantGender").val(applicantsex);
	                  $("#applicantBirthday").val(sBirthday);
	              }
	          }
	      }
	  });
	 
	
	});
	
	 
	  //证件类型修改触发(被保人 ) 
	     $("#insuredIdentifynumbertemp").text('');
	  $("#ci").change(function(){
		  //code...
		   var strinputt = $("#insuredIdentifynumber").val();
		   var identifytypeci = $("#ci").val();
		   if(strinputt!=""){ 
		   if (identifytypeci == '01') {
			   if (isCardIDD(strinputt, 1)) {
				
				   var sex=(strinputt.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
					
		              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
		              if (sBirthdayy != "undefined" && sex!= "undefined"&&sBirthdayy != "" && sex!= "") {
		            	  if(sex=="男"){
		            		  sex="M";
		            	  }
		            	  if(sex=="女"){
		            		  sex="F";
		            	  }
		            	  var sss=sBirthdayy.split("-");
		            	  if(sss[2].length=='1'&&sss[1].length!='1'){
		            		  sBirthdayy=sss[0]+"-"+sss[1]+"-"+"0"+sss[2];
		            	  }
		            	  if(sss[1].length=='1'&&sss[2].length!='1'){
		            		  sBirthdayy=sss[0]+"-0"+sss[1]+"-"+sss[2];
		            	  }
		            	  if(sss[1].length=='1'&&sss[2].length=='1'){
		            		  sBirthdayy=sss[0]+"-0"+sss[1]+"-"+"0"+sss[2];
		            	  }
		            	  $("#insuredGender").val(sex);
		                  $("#insuredBirthday").val(sBirthdayy);
		              }
		          }
		   }
		   }
	  });
	  
	  //证件类型修改触发(投保人  ) 
	  $("#cii").change(function(){
		  //code...
		   var strinputtt = $("#applicantNumber").val();
		   var identifytypecii = $("#cii").val();
		   
		   if(strinputtt!=""){ 
		   if (identifytypecii == '01') {
			   if (isCardID(strinputtt, 2)) { 
				   var sexp=(strinputtt.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
			              //alert('输入正确！请核对您的信息:出生日期：'+birthday+'.性别：'+sex+'.出生地：'+address);
			              if (sBirthday != "undefined" && sexp != "undefined"&&sBirthday != "" &&sexp != "") {
			            	  if(sexp=="男"){
			            		  sexp="M";
			            	  }
			            	  if(sexp=="女"){
			            		  sexp="F";
			            	  }
			            	  var ss=sBirthday.split("-");
			            	  if(ss[2].length=='1'&&ss[1].length!='1'){
			            		  sBirthday=ss[0]+"-"+ss[1]+"-"+"0"+ss[2];
			            	  }
			            	  if(ss[1].length=='1'&&ss[2].length!='1'){
			            		  sBirthday=ss[0]+"-0"+ss[1]+"-"+ss[2];
			            	  }
			            	  if(ss[1].length=='1'&&ss[2].length=='1'){
			            		  sBirthday=ss[0]+"-0"+ss[1]+"-"+"0"+ss[2];
			            	  }
			            	  $("#applicantGender").val(sexp);
			                  $("#applicantBirthday").val(sBirthday);
			              }
		          }
		   }
		   }
	  });

	  //验证身份证合法性  
	    var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
	    		21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",  
	    		34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",  
	    		43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川"  
	    		,52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",  
	    		64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}   

	    function isCardIDD(sId,flag){ 
	    	
      	 var resulta=true;
	   		  if (flag == 1) {
	   		      identifynumber3 = "insuredIdentifynumber";
	   		      identifynumbertemp3 = "insuredIdentifynumbertemp";
	   		  } else {
	   		      identifynumber3 = "applicantNumber";
	   		      identifynumbertemp3 = "applicantNumbertemp";
	   		  }          
	
	
			  var iSum=0 ;  
			  var info="" ;  
			  if(!/^\d{17}(\d|x)$/i.test(sId)){	  
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
		          resulta = false;  
			  }
			  var ss;
			  sId=sId.replace(/x$/i,"a"); 
			  ss=sId;
			  if(aCity[parseInt(sId.substr(0,2))]==null){				  
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;  
			  }
			  sBirthdayy=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));  
			  var d=new Date(sBirthdayy.replace(/-/g,"/")) ;  
			  if(sBirthdayy!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())){
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;
			  }
			  for(var i = 17;i>=0;i --){
				  iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;
			  }
			  if(iSum%11!=1){ 
				  $("#" + identifynumbertemp3 + "").text('**身份证号格式不对 ！     ');
	              resulta = false;
			  }   
	           return resulta;   
		}  

</script>

	<!--[if (gte IE 9)|!(IE)]><!-->
	<!--<![endif]-->
	<script src="${webRoot}/plug-in/amaze-ui/js/app.js"></script>
</body>
</html>
