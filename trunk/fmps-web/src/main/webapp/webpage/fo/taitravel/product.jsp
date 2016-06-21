<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦保险</title>
<link href="${webRoot}/plug-in/totaiwan/css/product.css" rel="stylesheet"
	type="text/css">
<script src="${webRoot}/plug-in/fo/js/jsonsql/jsonsql-0.1.js"></script>
</head>
<body>
	
		<div class="shop_product_img">
			<img src="${product.imagehref }" />
			<div class="shop_product_text">
				<div class="text_productname">${product.productname }</div>
			</div>
			<c:if test="${product.insuranceAge != null && !empty product.insuranceAge }">
				<div class="shop_product_text_1">
					<!-- 有年龄规则要显示年龄-->
					<div class="text_productname" style="color:#0e90d2">适用人群：${product.insuranceAge } 岁</div>
				</div>
			</c:if>
		</div>
		<div class="shop_product">
		<div style="height: 20px; clear: both;">&nbsp;</div>
		<button type="button" class="am-btn_1 am-btn-danger_1"
			data-am-modal="{target: '#my-popup'}">
			<div class="shop_product_choice">
				选择：保障期限/保障年龄/保障方案<span style="float: right; padding-top: 5px;"><img
					src="${webRoot }/plug-in/totaiwan/img/right.png" width="8"
					height="13" /></span>
			</div>
		</button>
	</div>

	<div class="grid" id="load" style="display: none;">
		<div class="cell">
			<div class="card">
				<span class="spinner-loader">Loading&#8230;</span>
				<div style="clear: both;">正在加载</div>
			</div>
		</div>
	</div>

	<div data-am-widget="tabs" class="am-tabs am-tabs-d2" data-am-tabs-noswipe="1">
		<ul class="am-tabs-nav am-cf">
			<li id="productIntroduction" class="am-active"><a
				href="[data-tab-panel-0]">介绍</a></li>
			<li id="productDetail" class=""><a href="[data-tab-panel-1]">详情</a></li>
			<li id="commonProblem" class=""><a href="[data-tab-panel-2]">常见问题</a></li>
		</ul>
		<div class="am-tabs-bd">
			<div data-tab-panel-0 class="am-tab-panel am-active" style="-webkit-transition: -webkit-transform 0.0001s;transition: transform 0.0001s;" >
				<c:choose>
					<c:when
						test="${fn:contains(product.introduction,'null') || fn:trim(product.introduction) eq '' }">
						<div style="color: #616c72; font-size: 12px; line-height: 28px;">无</div>
					</c:when>
					<c:otherwise>${product.introduction }</c:otherwise>
				</c:choose>
			</div>
			<div data-tab-panel-1 class="am-tab-panel " style="-webkit-transition: -webkit-transform 0.0001s;transition: transform 0.0001s;" >				
				<div class="details_center"></div>
			</div>
			<div data-tab-panel-2 class="am-tab-panel " style="-webkit-transition: -webkit-transform 0.0001s;transition: transform 0.0001s;" >
				<div class="faq"></div>
			</div>
		</div>
	</div>

	<div style="height: 20px;">&nbsp;</div>
	<form name="singleProduct"
		action="${webRoot }/fo/taiwanController.do?prepareProposal"
		method="post">
		<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
			<div class="pay_button">
				<div class="pay_button_money">
					<c:choose>
						<c:when test="${product.minpremium eq product.maxpremium}">￥${product.minpremium }</c:when>
						<c:otherwise>￥${product.minpremium }&nbsp;-&nbsp;${product.maxpremium }</c:otherwise>
					</c:choose>
				</div>
				<div class="pay_button_text" id="toPurchase"
					data-am-modal="{target: '#my-popup'}">购买</div>
			</div>
		</header>
		<!--弹出层-->
		<div class="am-popup" id="my-popup">
			<div class="am-popup-inner">

				<div class="pop_product">
					<!-- 商品缩略图 -->
					<div class="pop_img">
						<img src="${product.imagehref }" width="120" height="60"
							style="border-radius: 5px; border: 1px solid #e8e8e8;" />
					</div>
					<div class="pop_text">
						<div class="text_1">${product.productname }</div>
						<div class="premiumScale">
							<c:choose>
								<c:when test="${product.minpremium eq product.maxpremium}">￥${product.minpremium }</c:when>
								<c:otherwise>￥${product.minpremium }&nbsp;-&nbsp;${product.maxpremium }</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="pop_close">
						<span data-am-modal-close class="am-close">&times;</span>
					</div>
				</div>

				<div class="am-popup-bd">

					<div class="plannames">保障方案</div>
					<div class="center_choice">
					<!-- 
				      <div class="choice">方案一</div>
				     -->
					</div>
					<div class="periods">保障期限</div>
					<div class="center_choice">
					</div>
					<div class="pop_center_4">份数</div>
					<div class="center_choice">
					   <!-- 
				       <div class="choice_b">－</div>
					    -->
				    <div class="choice_b">1</div>
				       <!-- 
				       <div class="choice_b">＋</div>
				        -->
				   </div>
				   <div style="height: 50px; clear: both;">&nbsp;</div>
				</div>
				<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
					<div class="pay_button">
						<div class="confirmButton">确 认 购 买</div>
					</div>
				</header>
			</div>
		</div>

		<!-- 从上一个请求获取到的参数 -->
		<input type="hidden" id="productStatus" name="productStatus" value="${product.status }" />
		<input type="hidden" id="type" name="type" value="${product.type }" />
		
		<!-- 重新支付时商品id从attribute中取 -->
		<input type="hidden" name="productid" id="productid" value="${productid }" /> 
		<input type="hidden" id="productname" name="productname" value="${product.productname }" />

		<!-- 以下是确认按钮需要产生的隐藏域数据 -->
		<input type="hidden" id="period" name="period" value="" /> 
		<input type="hidden" id="coreproductcode" name="coreproductcode" value="" />
		<input type="hidden" id="occupationLevels" name="occupationLevels" value="" /> 
		<input type="hidden" id="premium" name="premium" value="" /> 
		<input type="hidden" id="planname" name="planname" value="" /> 
		<input type="hidden" id="planid" name="planid" value="" />
		<input type="hidden" id="openid" name="openid" value="${openid }" />
		<input type="hidden" id="orderno" name="orderno" value="${orderno }"/>

	</form>
	<script>
	var product = ${product};
		$(function() {
			//status==2 表示商品已下架
			if ($("#productStatus").val() == 2) {
				$(".text_productname").after(
						"<div class='text_right'>已下架</div>");
				$("#toPurchase").css("background-color", "grey");
				$("#toPurchase").removeAttr("data-am-modal");
				$(".confirmButton").css("background-color", "grey");
			}
			var plannameList = product.plannameList;
			//查找保障方案后的选项div
			var plannamesChoiceDiv = $(".plannames").next(".center_choice").first();
			//清空保障方案的所有子选项
			plannamesChoiceDiv.empty();
			for (var i = 0; i < plannameList.length; i++) {
				plannamesChoiceDiv
						.append("<div class=choice onclick='generatePeriods(this);'>"
								+ plannameList[i].planname + "</div>");
			}
			//如果是用订单号重新支付,保障方案和保障期限以及隐藏域的值都取投保单的值,否则默认初始化第一个方案选项的保障期限
			if ("${orderno}") {
				//订单所选方案赋值，选项样式加红色边框
				var currentPlannameElement = plannamesChoiceDiv
						.children(".choice:contains('${planname}')");
				generatePeriods(currentPlannameElement, 'Y');
				//重新支付时productId从attribute中取
				$("input[name=productid]").val("${productid}");
			} else {
				var firstPlanElement = plannamesChoiceDiv.children(".choice")
						.first();
				//generatePeriods(firstPlanElement);
				var planname = $(firstPlanElement).text();
			    //jsonsql的where条件要用括号否则读不到
			    var periods = jsonsql.query("select period from product.premiumList where (planname == '"+ planname + "')", product);
			    //查找保障期限后的选项div
			    var periodsChoiceDiv = $(".periods").next(".center_choice").first();
			    //清空保障期限的所有子选项
			    periodsChoiceDiv.empty();
			    for (var i = 0; i < periods.length; i++) {
				     // <div class="choice">1年</div>
				     periodsChoiceDiv
						.append("<div class=choice name='" + periods[i].period + "' onclick=setPeriodAndPlanHidden($(this),'"
								+ planname
								+ "'); >"
								+ periods[i].period
								+ "</div>");
			    }
			}

			//确定按钮的单击事件，关闭选择框，跳到填写投保信息页面
			$(".confirmButton").bind("click", function() {
				//如果商品已下架，单击不处理
				if ($("#productStatus").val() == 2) {
					return false;
				}
				//检查保障期限和保障方案是否已选，检查是否已生成最终保费
				if (!$("#planname").val() || !$("#period").val()) {
					alert("请选择方案和保障期限！");
					return false;
				}
				if (!$("#coreproductcode").val() /* || !$("#occupationLevels").val() 财产险职业类别可以为空 */
						|| !$("#premium").val() || !$("#planid").val()) {
					alert("数据不完整，无法购买！");
					return false;
				}
				var insuranceAge='${product.insuranceAge}';
				var planid=$("#planid").val();
				var productid = $("#productid").val();
				var period = $("#period").val();
				var premium = $("#premium").val();
				var planname = $("#planname").val();
				var productname = $("#productname").val();
				var orderno=$("#orderno").val();
				/*
				alert("productname=>" + $("#productname").val() + "\n"
						  + "planname=>" + $("#planname").val() + "\n"
						  + "period=>" + $("#period").val() + "\n"
						  );
				*/
				location.href="${webRoot }/pay/taipayController.do?prepareProposal&openid=${openid}&productid="+productid
						+"&period="+period+"&planname="+planname+"&productname="+productname+"&premium="+premium
						+"&planid="+planid+"&orderno="+orderno+"&insuranceAge="+insuranceAge+"&huodongid=${param.huodongid}";
			});
			
			/**商品详情tab**/
			$("#productDetail").bind("click", function() {
				var openid = $("#openid").val();
				var productid = $("#productid").val();
				//如果详情div中无内容，通过ajax获取一次
				if (!$(".details_center").html()) {
					$("#load").css("display", "block");
					$.ajax({
						type : 'POST',
						url : "${webRoot}/fo/taiwanController.do?details",
						data : {
							openid : openid,
							productid : productid,
							afftype : '4'
						},
						dataType : "json",
						error : function() {// 请求失败处理函数
							alert('请求失败！');
						},
						success : function(data) {
							
							if(data == "null" || !data){
								$(".details_center").html("无");
							}else{
					          	$(".details_center").html(data);
							}
						}
					});
					$("#load").css("display", "none");
				}
			});

			/**商品常见问题tab**/
			$("#commonProblem").bind("click", function() {
				//如果常见问题div中无内容，通过ajax获取一次
				if (!$(".faq").html()) {
					$("#load").css("display", "block");
					var openid = $("#openid").val();
					var productid = $("#productid").val();
					//如果详情div中无内容，通过ajax获取一次
					if (!$(".faq").html()) {
						$("#load").css("display", "block");
						$.ajax({
							type : 'POST',
							url : "${webRoot}/fo/taiwanController.do?details",
							data : {
								openid : openid,
								productid : productid,
								afftype : '5'
							},
							dataType : "json",
							error : function() {// 请求失败处理函数
								alert('请求失败！');
							},
							success : function(data) {
								if(data == "null" || !data){
						          	$(".faq").html("无");
						          }else{
						          	$(".faq").html(data);
						          }
							}
						});
					}
					$("#load").css("display", "none");
				}
			});

		});

		//根据方案产生保障期限，每个保障方案的单击事件，更新保障期限的子项
		function generatePeriods(currentPlannameElement, isFirstInvoke) {
			var planname = $(currentPlannameElement).text();

			//jsonsql的where条件要用括号否则读不到
			var periods = jsonsql.query(
					"select period from product.premiumList where (planname == '"
							+ planname + "')", product);

			//查找保障期限后的选项div
			var periodsChoiceDiv = $(".periods").next(".center_choice").first();
			//清空保障期限的所有子选项
			periodsChoiceDiv.empty();
			for (var i = 0; i < periods.length; i++) {
				// <div class="choice">1年</div>
				periodsChoiceDiv
						.append("<div class=choice name='" + periods[i].period + "' onclick=setPeriodAndPlanHidden($(this),'"
								+ planname
								+ "'); >"
								+ periods[i].period
								+ "</div>");
			}

			//所选方案赋值，选项样式加红色边框
			$(currentPlannameElement).css("border", "1px solid #dc2623");
			$(currentPlannameElement).siblings(".choice").css("border",
					"1px solid #e8e8e8");
			$("#planname").val(planname);
			//如果是订单重新支付,选中投保时的保障期限,否则默认选中第一个保障期限
			if ('${orderno}' && isFirstInvoke == 'Y') {
				var currentPeriodElement = periodsChoiceDiv
						.children(".choice[name='${period}']");
				setPeriodAndPlanHidden(currentPeriodElement, planname);
			} else {
				setPeriodAndPlanHidden(periodsChoiceDiv.children(".choice")
						.first(), planname);
			}

		}

		function setPeriodAndPlanHidden(period, planname) {
			//所选保障期限样式加红色边框
			period.css("border", "1px solid #dc2623");
			period.siblings(".choice").css("border", "1px solid #e8e8e8");
			$("#period").val(period.text());

			var otherHidden = jsonsql.query(
					"select * from product.premiumList where (planname == '"
							+ planname + "' && period == '" + period.text()
							+ "')", product);

			$("#occupationLevels").val(product.occupationLevels);
			$("#coreproductcode").val(otherHidden[0].coreproductcode);
			$("#premium").val(otherHidden[0].premium);
			$("#planid").val(otherHidden[0].id);
			//弹框中的保费范围变化
			$(".premiumScale").text("￥ " + otherHidden[0].premium);
			//弹框关闭后，本页面显示的保费
			$(".pay_button_money").text("￥ " + otherHidden[0].premium);
		}
	</script>
</body>
</html>