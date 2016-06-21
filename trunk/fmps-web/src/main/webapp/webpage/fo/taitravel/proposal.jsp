<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<%@ include file="/webpage/fo/common/mobiscroll.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦保险</title>
<link href="${webRoot}/plug-in/totaiwan/css/proposal.css"
	rel="stylesheet" type="text/css">
<script src="${webRoot}/plug-in/fo/verificationIdentity.js"></script>
<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
</head>
<body>
	<form id="proposalform">
		<header data-am-widget="header" class="am-header am-header-default">
			<h1 class="am-header-title" style="color: #132a39; font-size: 16px;">
				投保人信息</h1>
		</header>
		<div class="info_index">
			<div class="info_form_1">
				<div class="text_name">姓 名:</div>
				<div class="text_input">
					<input name="appliName" id="appliName" type="text"
						value="${applicant.name }" />
				</div>
				<div id="appliNameMsg" style="color: red; display: none;">**投保人姓名不能为空</div>
			</div>
			<div class="info_form_2">
				<div class="text_type">证件类型:</div>
				<div>
					<select name="appliIdentifyType" id="appliIdentifyType">
						<option value="">请选择</option>
						<option value="01" <c:if test="${applicant.identifytype=='01'  }">selected</c:if>>身份证</option>
						<option value="03" <c:if test="${applicant.identifytype=='03'  }">selected</c:if>>护照</option>
						<option value="99" <c:if test="${applicant.identifytype=='99'  }">selected</c:if>>其它</option>
					</select> <div id="appliIdentifyTypeMsg" style="color: red;display: none;">**请选择投保人证件类型</div>
				</div>
			</div>
			<div class="info_form_2">
				<div class="text_type">证件号码:</div>
				<div class="text_input">
					<input name="appliIdentifyNumber" id="appliIdentifyNumber"
						type="text" value="${applicant.identifynumber }" />
				</div>
				<div id="appliIdentifyNumberMsg" style="color: red; display: none;">**投保人证件号码不能为空</div>
			</div>
			<div id="appliBirthAndGender" style="display: none;">
				<div class="info_form_2">
					<div class="text_type">出生日期:</div>
					<div class="text_input">
						<input class="am-form-field" readonly="readonly" style="background-color: #fff;"
							value="<fmt:formatDate value='${applicant.birthday }' pattern='yyyy-MM-dd'/>"
							name="appliBirthday" id="appliBirthday" type="text" />
					</div><input type="hidden" id="appliBirthdayTemp" name="appliBirthdayTemp" value="">
					<div id="appliBirthdayMsg" style="color: red; display: none;">**投保人出生日期不能为空</div>
				</div>
				<div class="info_form_2">
					<div class="text_type">性别:</div>
					<div>
						<select name="appliGender" id="appliGender">
							<option value="">请选择</option>
							<option value="M" <c:if test="${applicant.gender=='M'  }">selected</c:if>>男</option>
							<option value="F" <c:if test="${applicant.gender=='F'  }">selected</c:if>>女</option>
						</select> <input type="hidden" id="orderAppliGender"
							value="" />
					</div>
					<div id="appliGenderMsg" style="color: red; display: none;">**投保人性别不能为空</div>
				</div>
			</div>
			<div class="info_form_2">
				<div class="text_type">手机号码:</div>
				<div class="text_input">
					<input name="appliPhone" id="appliPhone" type="text"
						value="${applicant.phone }" />
				</div>
				<div id="appliPhoneMsg" style="color: red; display: none;">**投保人手机号码不能为空</div>
			</div>
			
			<!-- 需要填寄送地址的商品 -->
			<c:if test="${NEED_MAILING_ADDRESS != null }">
			<div class="info_form_2">
				<div class="text_type">联系地址:</div>
				<div class="text_input">
					<input name="applicantAddress" id="applicantAddress" type="text"
						value="${applicant.address }" />
				</div>
				<div id="applicantAddressMsg" style="color: red; display: none;">**联系地址地址不能为空</div>
			</div>
			</c:if>
			
			<!-- 需要填寄送email地址的商品 -->
			<c:if test="${delivery == 'email'}">
			<div class="info_form_2">
				<div class="text_type">Email地址:</div>
				<div class="text_input">
					<input name="applicantEmail" id="applicantEmail" type="text"
						value="${applicant.email }" />
				</div>
				<div id="applicantEmailMsg" style="color: red; display: none;">**Email地址地址不能为空</div>
			</div>
			</c:if>
			
			<!-- 赴台交换生保险可以有大陆学校 -->
			<c:if test="${TO_TAI != null }">
			<div class="info_form_2">
				<div class="text_type">学校:</div>
				<div class="text_input">
					<input name="applischool" id="applischool"
						type="text" value="${applicant.school }" placeholder="${TO_TAI_Description }"  />
				</div>
				<div id="appliSchoolMsg" style="color: red; display: none;">**投保人同被保险人时，学校不能为空</div>
			</div>
			</c:if>				
			<c:if test="${department != null }">
			<div class="info_form_2">
				<div class="text_type">院系:</div>
				<div class="text_input">
					<input name="applidepartment" id="applidepartment"
						type="text" value="${applicant.department }" />
				</div>
				<div id="applidepartmentMsg" style="color: red; display: none;">**请填写所属院系</div>
			</div>
		
		    <div class="info_form_2">
				<div class="text_type">学号:</div>
				<div class="text_input">
					<input name="applistudentNo" id="applistudentNo"
						type="text" value="${applicant.studentNo }" />
				</div>
				<div id="applistudentNoMsg" style="color: red; display: none;">**请填写学号</div>
			</div>
			</c:if>
			
			<div class="info_form_4">
				<div class="text_type">被保险人</div>
				<div class="text_nbsp">&nbsp;</div>
				<div class="text_input">
					<input id="insuredIdentityFlag" name="insuredIdentityFlag" type="checkbox" class="option-input checkbox"
					<c:if test="${empty policy.insuredidentity || policy.insuredidentity == '01'}">checked="checked"</c:if>
						style="border: 1px solid #0e90d2;"/><span
						id="insuredIdentityFlagSpan"> 同投保人</span>
				</div>
				<input type="hidden" id="orderInsuredIdentity"
					value="" />
			</div>
			<!-- 投保人与被保人不同时展开以下代码  -->
			<div class="insured" style="display: none;">
				<div class="info_form_1">
					<div class="text_name">姓 名:</div>
					<div class="text_input">
						<input name="insuredName" id="insuredName" type="text"
							value="${insured.name }" />
					</div>
					<div id="insuredNameMsg" style="color: red; display: none;">**被保险人姓名不能为空</div>
				</div>
				<div class="info_form_2">
					<div class="text_type">证件类型:</div>
					<div>
						<select name="insuredIdentifyType" id="insuredIdentifyType">
							<option value="">请选择</option>
							<option value="01" <c:if test="${insured.identifytype=='01'  }">selected</c:if>>身份证</option>
							<option value="03" <c:if test="${insured.identifytype=='03'  }">selected</c:if>>护照</option>
							<option value="99" <c:if test="${insured.identifytype=='99'  }">selected</c:if>>其它</option>
						</select> <div id="insuredIdentifyTypeMsg" style="color: red;display: none;">**请选择被保险人证件类型</div>
					</div>
				</div>
				<div class="info_form_2">
					<div class="text_type">证件号码:</div>
					<div class="text_input">
						<input name="insuredIdentifyNumber" id="insuredIdentifyNumber"
							type="text"
							value="${insured.identifynumber }" />
					</div>
					<div id="insuredIdentifyNumberMsg"
						style="color: red; display: none;">**被保险人证件号码不能为空</div>
				</div>
				<div id="insuredBirthAndGender" style="display: none;">
					<div class="info_form_2">
						<div class="text_type">出生日期:</div>
						<div class="text_input">
							<input class="am-form-field" readonly="readonly" style="background-color: #fff;"
								value="<fmt:formatDate value='${insured.birthday }' pattern='yyyy-MM-dd'/>"
								name="insuredBirthday" id="insuredBirthday" type="text" />
						</div><input type="hidden" id="insuredBirthdayTemp" name="insuredBirthdayTemp" value="">
						<div id="insuredBirthdayMsg" style="color: red; display: none;">**被保险人出生日期不能为空</div>
					</div>
					<div class="info_form_2">
						<div class="text_type">性别:</div>
						<div>
							<select name="insuredGender" id="insuredGender">
								<option value="">请选择</option>
								<option value="M" <c:if test="${insured.gender=='M'  }">selected</c:if>>男</option>
								<option value="F" <c:if test="${insured.gender=='F'  }">selected</c:if>>女</option>
							</select> <input type="hidden" id="orderInsuredGender"
								value="" />
						</div>
						<div id="insuredGenderMsg" style="color: red; display: none;">**被保险人性别不能为空</div>
					</div>
				</div>
				<div class="info_form_2">
					<div class="text_type">手机号码:</div>
					<div class="text_input">
						<input name="insuredPhone" id="insuredPhone" type="text"
							value="${insured.phone }" />
					</div>
					<div id="insuredPhoneMsg" style="color: red; display: none;">**被保险人手机号码不能为空</div>
				</div>				
				<!-- 需要填寄送地址的商品 -->
			 <c:if test="${NEED_MAILING_ADDRESS != null }">
			    <div class="info_form_2">
				  <div class="text_type">联系地址:</div>
				 <div class="text_input">
					<input name="insuredAddress" id="insuredAddress" type="text"
						value="${insured.address }" />
				 </div>
				 <div id="insuredAddressMsg" style="color: red; display: none;">**联系地址地址不能为空</div>
			   </div>
			</c:if>
			
			<c:if test="${delivery == 'email' }">
			    <div class="info_form_2">
				  <div class="text_type">Email地址:</div>
				 <div class="text_input">
					<input name="insuredEmail" id="insuredEmail" type="text"
						value="${insured.email }" />
				 </div>
				 <div id="insuredEmailMsg" style="color: red; display: none;">**Email地址地址不能为空</div>
			   </div>
			</c:if>
				<!-- 赴台交换生保险可以有大陆学校 -->
				<c:if test="${TO_TAI != null }">
				<div class="info_form_2">
					<div class="text_type">学校:</div>
					<div class="text_input">
						<input name="insuredSchool" id="insuredSchool"
							type="text" value="${insured.school }"  placeholder="${TO_TAI_Description }"  />
					</div>
					<div id="insuredSchoolMsg" style="color: red; display: none;">**被保险人学校不能为空</div>
				</div>
				</c:if>				
			<c:if test="${department != null }">	
			<div class="info_form_2">
				<div class="text_type">院系:</div>
				<div class="text_input">
					<input name="insureddepartment" id="insureddepartment"
						type="text" value="${insured.department }" />
				</div>
				<div id="insureddepartmentMsg" style="color: red; display: none;">**请填写所属院系</div>
			</div>
		
		    <div class="info_form_2">
				<div class="text_type">学号:</div>
				<div class="text_input">
					<input name="insuredstudentNo" id="insuredstudentNo"
						type="text" value="${insured.studentNo }" />
				</div>
				<div id="insuredstudentNoMsg" style="color: red; display: none;">**请填写学号</div>
			</div>
			</c:if>	
				<div class="info_form_2">
					<div class="text_type" style="width: 40%;">与投保人的关系</div>
					<div>
						<select name="insuredIdentity" id="insuredIdentity">
							<option value="01">请选择</option>
							<option value="10" <c:if test="${policy.insuredidentity=='10'  }">selected</c:if>>配偶</option>
							<option value="40" <c:if test="${policy.insuredidentity=='40'  }">selected</c:if>>儿女</option>
							<option value="50" <c:if test="${policy.insuredidentity=='50'  }">selected</c:if>>父母</option>
							<option value="61" <c:if test="${policy.insuredidentity=='61'  }">selected</c:if>>孙子、孙女与祖父母</option>
							<option value="62" <c:if test="${policy.insuredidentity=='62'  }">selected</c:if>>外孙、外孙女与外祖父母</option>
						</select> <input type="hidden" id="orderInsuredIdentity"
							value="" />
					</div>
					<div id="insuredIdentityMsg" style="color: red; display: none;">**请选择被保险人与投保人的关系</div>
				</div>
			</div>
			<div class="info_form_6">
				<div class="text_type">保单生效日期:</div>
				<div class="text_input">
					<input type="text" class="am-form-field" id="startDate"
						name="startDate" readonly="readonly" style="background-color: #fff;"
						value="<fmt:formatDate value='${policy.startdate }' pattern='yyyy-MM-dd'/>" />
				</div><input type="hidden" id="startDateTemp" name="startDateTemp" value="">
				<div id="startDateMsg" style="color: red; display: none;">**保单生效日期不能为空</div>
				<div id="invalidstartDateMsg" style="color: red; display: none;">**保单生效日期最早从明天开始</div>
			</div>
			<div class="info_form_5">
				<div class="text_type">受益人</div>
				<div class="text_nbsp">
					<label class="am-radio"> <input type="radio"
						name="isBeneficiary" value="1" data-am-ucheck checked />法 定
					</label>
				</div>
			</div>
			<div class="info_table">
				<table width="100%" border="1" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="3" height="40"
							style="font-size: 14px; color: #616c71; text-align: center;">${policy.productname }</td>
					</tr>
					<tr>
						<td height="30" width="33%"
							style="font-size: 14px; color: #616c71; text-align: center;">保险期限</td>
						<td width="33%"
							style="font-size: 14px; color: #616c71; text-align: center;">保障方案</td>
						<td width="33%"
							style="font-size: 14px; color: #616c71; text-align: center;">份
							数</td>
					</tr>
					<tr>
						<td height="66"
							style="font-size: 14px; color: #616c71; text-align: center;">${policy.period }</td>
						<td style="font-size: 14px; color: #616c71; text-align: center;">${policy.planname }</td>
						<td style="font-size: 14px; color: #616c71; text-align: center;">1</td>
					</tr>
				</table>
			</div>			
			<input type="hidden" name="huodongid" value="${param.huodongid }" /> 
			<input type="hidden" id="productid" name="productid" value="${policy.productid }" /> 
			<input type="hidden" name="productname" value="${policy.productname }" /> 
			<input type="hidden" name="identityFlag" value="1" /> 
			<input type="hidden" id="openid" name="openid" value="${policy.openid }" /> 
			<input type="hidden" name="period" value="${policy.period }" /> 
			<input type="hidden" name="planid" value="${policy.planid }" /> 
			<input type="hidden" name="planname" value="${policy.planname }" /> 
			<input type="hidden" name="premium" value="${policy.premium }" /> 
			<input type="hidden" name="orderno" value="${policy.orderno }" /> 	
			<input type="hidden" id="isPaid" name="isPaid" value="${ispaid }">	
			<input type="hidden" id="insuranceAge" name="insuranceAge" value="${insuranceAge }">		
			<div class="info_form_7">
				<label class="am-checkbox"> <input id="readed" type="checkbox"
					  class="option-input checkbox"  style="border: 1px solid #0e90d2;" /> &nbsp;我已阅读并同意<a
					href="${webRoot}/fo/taiwanController.do?showNotice&openid=${policy.openid }&productid=${policy.productid}"><span
						style="color: #d20e1c;">《投保须知》</span></a>、<a
					href="${webRoot}/fo/taiwanController.do?showArticle&openid=${policy.openid }&productid=${policy.productid}&planid=${policy.planid}"><span
						style="color: #d20e1c;">《保险条款》</span></a>
				</label>
			</div>
			<div id="readedMsg" style="color: red; display: none;">**请先勾选我已阅读</div>		
		<div style="width: 603px; height: 300px; display: none" id="container"></div>
		<header id="payheader" class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
			<div class="pay_button">
				<div class="pay_button_money">￥ ${policy.premium }</div>
				<div id="paySub"  class="pay_button_anniu">微信支付</div>
			</div>
		</header>
	</div>
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">下单中...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>
	</form>
	
	<script type="text/javascript">
	$(document).ready(function () {
		if($("#appliBirthdayTemp").val()){
			$("#appliBirthday").val( $("#appliBirthdayTemp").val() );
		}		
		if($("#insuredBirthdayTemp").val()){
			$("#insuredBirthday").val( $("#insuredBirthdayTemp").val() );
		}		
		if($("#startDateTemp").val()){
			$("#startDate").val( $("#startDateTemp").val() );
		}
		if($("#appliIdentifyType").val()!='01'){
			$("#appliBirthAndGender").css("display","block");
		}
		if($("#insuredIdentifyType").val()!='01'){
			$("#insuredBirthAndGender").css("display","block");
		}
		
		if($("#isPaid").val()){
			onlyRead();
			$("#payheader").css("display","none");
		}
		changeInsuredIdentityFlag();
		//省,change事件,产生市选项
		$("#provinceCode").bind("change",function(){
			var provinceCode = $("#provinceCode").val();
			var cityCode = $("#cityCode").val();			
			var openid = $("#openid").val();
			//如果省不为空,获取市
			if(provinceCode != ""){
				$.ajax({
					async: false,
					type : 'POST',
					url : "${webRoot}/fo/taiwanController.do?loadCityList",
					data : {
						openid : openid,
						provinceCode : provinceCode
					},
					dataType : "json",
					error : function() {// 请求失败处理函数
						alert('加载城市失败，请稍候重试！');
					},
					success : function(result) {
						$("#cityCode").empty();
						$.each(result.obj, function(i, item){
							$("#cityCode").append("<option value='" + item.citycode + "'>" + item.city + "</option>"); 
						});
						//默认选中第一个市选项
						$("#cityCode option:first-child").attr("selected","selected");
						$("#cityCode").change();
					}
				});
			}else{
				//省为空,重置市和区
				$("#cityCode").empty();
				$("#cityCode").append("<option value=''>选择市</option>"); 
				$("#countyCode").empty();
				$("#countyCode").append("<option value=''>选择区</option>"); 
			}			
		});
		
		//市,change事件,产生区选项
		$("#cityCode").bind("change",function(){
			var cityCode = $("#cityCode").val();			
			var openid = $("#openid").val();
			$.ajax({
				async: false,
				type : 'POST',
				url : "${webRoot}/fo/taiwanController.do?loadCountyList",
				data : {
					openid : openid,
					cityCode : cityCode
				},
				dataType : "json",
				error : function() {// 请求失败处理函数
					alert('加载区县失败，请稍候重试！');
				},
				success : function(result) {
					$("#countyCode").empty();
					$.each(result.obj, function(i, item){
						$("#countyCode").append("<option value='" + item.countycode + "'>" + item.county + "</option>"); 
					});
				}
			});
		});	
		
		
	});
	
	function goToPayResult(result,orderno, err_msg) {
		var appliName=$("#appliName").val();
		var appliIdentifyType=$("#appliIdentifyType").val();
		var appliIdentifyNumber=$("#appliIdentifyNumber").val();
		var url = "${webRoot}/pay/taipayController.do?showPayResult&result="
				+ result + "&orderno=" + orderno + "&openid=${policy.openid}&msg="
				+ err_msg+"&appliName="+appliName+"&appliIdentifyType="+appliIdentifyType+"&appliIdentifyNumber"+appliIdentifyNumber;
		location.href = url;
	};
	
	function showError(str) {
		alert(str);
	}
	
	//根据投保人身份证号计算性别和生日
	 $('#appliIdentifyNumber').blur(function() {
	      var appliIdentifyNumber = $("#appliIdentifyNumber").val();
	      var appliIdentifyType = $("#appliIdentifyType").val()
	      if (appliIdentifyType == '01') {
	          if (isCardID(appliIdentifyNumber, 1)) { 
	        	  var gender=(appliIdentifyNumber.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
	        	  var birthday=appliIdentifyNumber.substring(6, 10) + "-" + appliIdentifyNumber.substring(10, 12) + "-" + appliIdentifyNumber.substring(12, 14);
	              if (gender != "undefined"&& gender != "") {
	            	  if(gender=="男"){
	            		  gender="M";
	            	  }
	            	  if(gender=="女"){
	            		  gender="F";
	            	  }		            	  
	            	  $("#appliGender").val(gender);
	                  $("#appliBirthday").val(birthday);
	              }
	          }
	      }
	  });
	 //根据被保人身份证号计算被保人生日和性别
	 $('#insuredIdentifyNumber').blur(function() {
	      var identifyNumber = $("#insuredIdentifyNumber").val();
	      var identifyType = $("#insuredIdentifyType").val()
	      if (identifyType == '01') {
	          if (isCardID(identifyNumber, 1)) { 
	        	  var gender=(identifyNumber.replace(/x$/i,"a").substr(16,1)%2?"男":"女");
	        	  var birthday=identifyNumber.substring(6, 10) + "-" + identifyNumber.substring(10, 12) + "-" + identifyNumber.substring(12, 14);
	              if (gender != "undefined"&& gender != "") {
	            	  if(gender=="男"){
	            		  gender="M";
	            	  }
	            	  if(gender=="女"){
	            		  gender="F";
	            	  }		            	  
	            	  $("#insuredGender").val(gender);
	                  $("#insuredBirthday").val(birthday);
	              }
	          }
	      }
	  });
	
	if(!'${FIXED_STARTDATE}'){
		//alert("设置起保日期单击事件");
		//保单生效日期
	   $("#startDate").mobiscroll().date({
	       theme: 'android-holo-light',     // Specify theme like: theme: 'ios' or omit setting to use default 
	       mode: 'modal',       // Specify scroller mode like: mode: 'mixed' or omit setting to use default 
	       lang: 'zh',        // Specify language like: lang: 'pl' or omit setting to use default 
	       dateFormat: 'yy-mm-dd',
	       minDate: new Date(new Date().valueOf() + 1*24*60*60*1000), //最小日期是明天
	       showNow: true,
	       onSelect: function (valueText, inst) {
	           $("#startDateTemp").val(valueText); //设值同时也赋一个隐藏域,用户从投保须知返回时回显
	       }

	   });
	}
	

	
   $("#appliBirthday").mobiscroll().date({
       theme: 'android-holo-light', 
       mode: 'modal', 
       lang: 'zh', 
       dateFormat: 'yy-mm-dd',
       defaultValue: new Date(new Date().getFullYear() - 20,0,1),
       maxDate: new Date(),
       onSelect: function (valueText, inst) {
           $("#appliBirthdayTemp").val(valueText); //设值同时也赋一个隐藏域,用户从投保须知返回时回显
       }

   });
   
   $("#insuredBirthday").mobiscroll().date({
       theme: 'android-holo-light', 
       mode: 'modal', 
       lang: 'zh', 
       dateFormat: 'yy-mm-dd',
       defaultValue: new Date(new Date().getFullYear() - 20,0,1),
       maxDate: new Date(),
       onSelect: function (valueText, inst) {
           $("#insuredBirthdayTemp").val(valueText); //设值同时也赋一个隐藏域,用户从投保须知返回时回显
       }
   });
   
   /*显示或隐藏被保险人,设置被保险人与投保人的关系,默认与投保人的关系为本人*/
	$("#insuredIdentityFlag").bind("click",function(){
		changeInsuredIdentityFlag();
	});
	
   $("#insuredIdentityFlagSpan").bind("click",function(){
   	//alert("insuredIdentityFlagSpan clicked");
   	var insuredIsApplicant = $("#insuredIdentityFlag").is(':checked');
   	if(insuredIsApplicant){
   		$("#insuredIdentityFlag").removeAttr("checked");
   	}else{
   		//用attr设置checked没有效果,改用prop
   		$("#insuredIdentityFlag").prop("checked",true);
   	}
   	changeInsuredIdentityFlag();
   });
   
	// 同投保人复选框事件
	function changeInsuredIdentityFlag(){
		//alert("insuredIdentityFlag clicked");
		var insuredIsApplicant = $("#insuredIdentityFlag").is(':checked');
		//如果被保险人同投保人
		if(insuredIsApplicant){
			$(".insured").hide();
			//01 本人
			$("#insuredIdentity").val("01");
			$("#appliOccupationDiv").css("display","block");
		}else{
			$(".insured").show();
			$("#appliOccupationDiv").css("display","none");
			//$("#insuredIdentity").val("");
		}
	};
	
	//投保人证件类型非身份证时,要录入生日和性别
   $("#appliIdentifyType").bind("change",function(){
   	if( $("#appliIdentifyType").val() != "01"){
   		$("#appliBirthAndGender").css("display","block");
   	}else{
   		$("#appliBirthAndGender").css("display","none");
   	}
   });
   //被保险人证件类型非身份证时,要录入生日和性别
   $("#insuredIdentifyType").bind("change",function(){
   	if( $("#insuredIdentifyType").val() != "01"){
   		$("#insuredBirthAndGender").css("display","block");
   	}else{
   		$("#insuredBirthAndGender").css("display","none");
   	}
   });
   
   $('#paySub').click(function () {	   
		if($("#appliName").val() == ""){
			$("#appliNameMsg").css("display","block");
			$("#appliName").focus();
			return false;
		}
		$("#appliNameMsg").css("display","none");
		
		//投保人证件类型不能为空
		if($("#appliIdentifyType").val() == ""){
			$("#appliIdentifyTypeMsg").css("display","block");
			$("#appliIdentifyType").focus();
			return false;
		}
		$("#appliIdentifyTypeMsg").css("display","none");
		//投保人证件号码不能为空
		if($("#appliIdentifyNumber").val() == ""){
			$("#appliIdentifyNumberMsg").css("display","block");
			$("#appliIdentifyNumber").focus();
			return false;
		}
		$("#appliIdentifyNumberMsg").css("display","none");
		
		//投保人身份证号校验
		if($("#appliIdentifyType").val() == "01"){
			var isIdCard = isCardID($("#appliIdentifyNumber").val(),$("#appliIdentifyNumberMsg"));
			if(!isIdCard){
				$("#appliIdentifyNumberMsg").text("**证件号码错误");
				$("#appliIdentifyNumberMsg").css("display","block");
				$("#appliIdentifyNumber").focus();
				return false;
			}
		}
		$("#appliIdentifyNumberMsg").css("display","none");			
		//如果投保人证件类型不是身份证
		if($("#appliIdentifyType").val() != "01"){
			//投保人出生日期不能为空
			if($("#appliBirthday").val() == ""){
				$("#appliBirthdayMsg").css("display","block");
				$("#appliBirthday").focus();
				return false;
			}
			$("#appliBirthdayMsg").css("display","none");
			
			//投保人性别不能为空
			if($("#appliGender").val() == ""){
				$("#appliGenderMsg").css("display","block");
				$("#appliGenderMsg").focus();
				return false;
			}
			$("#appliGenderMsg").css("display","none");
		}
		
		//投保人联系方式不能为空
		if($("#appliPhone").val() == ""){
			$("#appliPhoneMsg").css("display","block");
			$("#appliPhone").focus();
			return false;
		}
		$("#appliPhoneMsg").css("display","none");
		
		//如果有提供保单寄送地址的录入,地址不能为空
		if($("#applicantAddress").size()>0 && $("#applicantAddress").val() == ""){
			$("#applicantAddressMsg").text("**联系地址不能为空");
			$("#applicantAddressMsg").css("display","block");
			$("#applicantAddress").focus();
			return false;
		}
		$("#applicantAddressMsg").css("display","none");
		
		//如果有提供保单寄送Email地址的录入,Email地址不能为空
		if($("#applicantEmail").size()>0 && !emailCheck($("#applicantEmail").val())){			
			$("#applicantEmailMsg").text("**Email地址不能为空,或不合法 ");			
			$("#applicantEmailMsg").css("display","block");
			$("#applicantEmail").focus();
			return false;
		}
		$("#applicantEmailMsg").css("display","none");

		//投保人同被保险人时，学校不能为空
		if($("#applischool").size()>0 && $("#insuredIdentityFlag").is(':checked') == true){
			if($("#applischool").val()==""){
				$("#appliSchoolMsg").css("display","block");
				$("#applischool").focus();
				return false;
			}
		}
		
		if($("#applidepartment").size()>0 && $("#insuredIdentityFlag").is(':checked') == true){
			if($("#applidepartment").val()==""){
				$("#applidepartmentMsg").css("display","block");
				$("#school").focus();
				return false;
			}
		}
		
		if($("#applistudentNo").size()>0 && $("#insuredIdentityFlag").is(':checked') == true){
			if($("#applistudentNo").val()==""){
				$("#applistudentNoMsg").css("display","block");
				$("#applistudentNo").focus();
				return false;
			}
		}
		
		$("#appliSchoolMsg").css("display","none");
		//如果与投保人关系为'01'且同投保人复选框没有选中,提示选择与投保人关系
		if($("#insuredIdentity").val() == "01" && $("#insuredIdentityFlag").is(':checked') == false){
			$("#insuredIdentityMsg").css("display","block");
			$("#insuredIdentityFlag").focus();
			return false;
		}
		$("#insuredIdentityMsg").css("display","none");
		var insuredIsApplicant = $("#insuredIdentityFlag").is(':checked');
		if(insuredIsApplicant){
				var insuredage=jsGetAge($("#appliBirthday").val());
				var insuranceAge=$("#insuranceAge").val();
				var insuredAges=insuranceAge.split("-");
				var minage=insuredAges[0];
	            var maxage=insuredAges[1];
	            if(insuredage<minage||insuredage>maxage){
	            	alert("被保人为 "+insuredage+"岁，不在年龄范围（"+insuranceAge+"）内！  ");
	            	$("#appliBirthday").focus();
	            	return false;
	            }
		}
		//如果被保险人不是投保人,校验被保险人不能为空值的表单
		if($("#insuredIdentity").val() != "01"){
			//被保险人姓名不能为空
			if($("#insuredName").val() == ""){
				$("#insuredNameMsg").css("display","block");
				$("#insuredName").focus();
				return false;
			}
			$("#insuredNameMsg").css("display","none");
			//被保险人证件类型不能为空
			if($("#insuredIdentifyType").val() == ""){
				$("#insuredIdentifyTypeMsg").css("display","block");
				$("#insuredIdentifyType").focus();
				return false;
			}
			$("#insuredIdentifyTypeMsg").css("display","none");
			
			//被保险人证件号码不能为空
			if($("#insuredIdentifyNumber").val() == ""){
				$("#insuredIdentifyNumberMsg").css("display","block");
				$("#insuredIdentifyNumber").focus();
				return false;
			}
			$("#insuredIdentifyNumberMsg").css("display","none");
			
			//被保险人身份证号校验
			if($("#insuredIdentifyType").val() == "01"){
				var isIdCard = isCardID($("#insuredIdentifyNumber").val(),$("#insuredIdentifyNumberMsg"));
				if(!isIdCard){
					$("#insuredIdentifyNumberMsg").text("**证件号码错误");
					$("#insuredIdentifyNumberMsg").css("display","block");
					$("#insuredIdentifyNumber").focus();
					return false;
				}
			}
			$("#insuredIdentifyNumberMsg").css("display","none");
			
			//被保险人与投保人关系不能为空
			if($("#insuredIdentity").val() == ""){
				$("#insuredIdentityMsg").css("display","block");
				$("#insuredIdentity").focus();
				return false;
			}
			$("#insuredIdentityMsg").css("display","none");
			
			//如果投保人证件类型不是身份证
			if($("#insuredIdentifyType").val() != "01"){
				//投保人出生日期不能为空
				if($("#insuredBirthday").val() == ""){
					$("#insuredBirthdayMsg").css("display","block");
					$("#insuredBirthday").focus();
					return false;
				}
				$("#insuredBirthdayMsg").css("display","none");
				//投保人性别不能为空
				if($("#insuredGender").val() == ""){
					$("#insuredGenderMsg").css("display","block");
					$("#insuredGender").focus();
					return false;
				}
				$("#insuredGenderMsg").css("display","none");
			}
			var insuredage=jsGetAge($("#insuredBirthday").val());
			var insuranceAge=$("#insuranceAge").val();
			var insuredAges=insuranceAge.split("-");
			var minage=insuredAges[0];
            var maxage=insuredAges[1];
            if(insuredage<minage||insuredage>maxage){
            	alert("被保人为 "+insuredage+"岁，不在年龄范围（"+insuranceAge+"）内！  ");
            	$("#insuredBirthday").focus();
            	return false;
            }
			
			//被保险人联系方式不能为空
			if($("#insuredPhone").val() == ""){
				$("#insuredPhoneMsg").css("display","block");
				$("#insuredPhone").focus();
				return false;
			}
			$("#insuredPhoneMsg").css("display","none");				
			
			//如果有提供保单寄送地址的录入,地址不能为空
			if($("#insuredAddress").size()>0 && $("#insuredAddress").val() == ""){
				$("#insuredAddressMsg").text("**联系地址不能为空");
				$("#insuredAddressMsg").css("display","block");
				$("#insuredAddress").focus();
				return false;
			}
			$("#insuredAddressMsg").css("display","none");
			
			//如果有提供保单Email寄送地址的录入,地址不能为空
			if($("#insuredEmail").size()>0 &&!emailCheck($("#insuredEmail").val())){
				$("#insuredEmailMsg").text("**Email地址不能为空,或不合法");
				$("#insuredEmailMsg").css("display","block"); 
				$("#insuredEmail").focus();
				return false;
			}
			$("#insuredEmailMsg").css("display","none");
			
			//被保险人学校不能为空
			if($("#insuredSchool").size()>0 && $("#insuredSchool").val() == ""){
				$("#insuredSchoolMsg").text("**被保险人学校不能为空").css("display","block");
				$("#insuredSchool").focus();
				return false;
			}			
			//被保险人学校长度不能超过50
			if($("#insuredSchool").size()>0 && $("#insuredSchool").val().length > 50){
				$("#insuredSchoolMsg").text("**被保险人学校长度不能超过50").css("display","block");
				$("#insuredSchool").focus();
				return false;
			}
			$("#insuredSchoolMsg").css("display","none");
			
			
			
			if($("#insureddepartment").size()>0 && $("#insureddepartment").val()== ""){
				$("#insureddepartmentMsg").text("**请输入被保人院系").css("display","block");
				$("#insureddepartment").focus();
				return false;
			}
			$("#insureddepartmentMsg").css("display","none");
			
			if($("#insuredstudentNo").size()>0 && $("#insuredstudentNo").val()== ""){
				$("#insuredstudentNoMsg").text("**请输入被保人学号").css("display","block");
				$("#insuredstudentNo").focus();
				return false;
			}
			$("#insuredstudentNoMsg").css("display","none");
			
		}			
		//保单生效日期不能为空
		if($("#startDate").val() == ""){
			$("#startDateMsg").css("display","block");
			$("#startDate").focus();
			return false;
		}
		$("#startDateMsg").css("display","none");
		var startDate = new Date($("#startDate").val().replace(/\-/g, "\/")); 
		if(startDate<=new Date()){
			$("#invalidstartDateMsg").css("display","block");
			$("#startDate").focus();
			return false;
		}
		$("#invalidstartDateMsg").css("display","none");
		if(!$("#readed").is(':checked')){
			$("#readedMsg").css("display","block");
			$("#readed").focus();
			 return false;	 
		 }
		$("#readedMsg").css("display","none");
		$("#paySub").attr("disabled","disabled");
		 var $modal = $('#my-modal-loading');
			$modal.modal('open');
		$.ajax({
			//async: false,
			type : 'POST',
			url : "${webRoot}/pay/taipayController.do?proposal",
			data : $('#proposalform').serialize(),
			dataType : "json",
			error : function() {// 请求失败处理函数
				$modal.modal('close');
				alert('请求失败！');
				$('#paySub').removeAttr("disabled");
			},
			success : function(json) {
				var orderno = json.attributes.orderno;
				var $modal = $('#my-modal-loading');
				$modal.modal('close');
				if(json.success&&json.obj.length>30){
					var paytext = eval('(' + json.obj + ')');						
					WeixinJSBridge.invoke('getBrandWCPayRequest',paytext ,function(res){
						if(res.err_msg == 'get_brand_wcpay_request:ok'){
							//支付成功
							result="success";
							$("#isPaid").val(result);
							goToPayResult(result,orderno,res.err_msg);
							$('#paySub').removeAttr("disabled");
						}else{														
							var msg=res.err_msg;							
							$.ajax({
								type : 'POST',
								url : "${webRoot}/pay/taipayController.do?goToPayResultfail",
								data : "&orderno=" + orderno + "&openid=${policy.openid}&msg="+msg,
								dataType : "json",
								success : function(json) {
									
								}
							});
							if(msg=='get_brand_wcpay_request:fail'){
								showError('保费支付失败，请确认您的银行卡是否可正常使用，或者支付额度是否足够！');	
							}
							$('#paySub').removeAttr("disabled");
						}
					 });
				}else{
					var isTest=json.obj.indexOf("已跳过微信支付");	
					 alert(json.obj);
					if(isTest>=0){					 
					  goToPayResult("success",orderno,"ok");	
					  }				
					$('#paySub').removeAttr("disabled");
				}
			}
		});
	});
   
   function onlyRead(){
	    var inputs=document.getElementsByTagName("input");
	    for(var i=0;i<inputs.length;i++){
	    inputs[i].setAttribute("readOnly",true);
	    }
	}
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
			}else{
				returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天}
			}
			return returnAge;//返回周岁年龄
   		}
   }
      
   //email 地址校验
   function emailCheck (emailStr) {
	   var emailPat=/^(.+)@(.+)$/;
	   var matchArray=emailStr.match(emailPat);
	   if (matchArray==null) {	   
	   return false;
	   }
	   return true;
	   }
	</script>
</body>
</html>