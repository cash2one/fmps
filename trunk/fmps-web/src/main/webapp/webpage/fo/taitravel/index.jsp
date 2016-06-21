<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦保险</title>
<link href="${webRoot}/plug-in/totaiwan/css/futai_index.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<input type="hidden" id="openid" name="openid" value="${openid }">
	<input type="hidden" id="provinceCode" name="provinceCode" value="">
	<input type="hidden" id="cityCode" name="cityCode" value="">
	<input type="hidden" id="countyCode" name="countyCode" value="">
	<div  id="gotopay" 
		style="position: absolute; background: #dff0d8; color: #4f8253; height: 40px; font-family: '黑体'; width: 100%; font-size: 14px; opacity: 0.95; padding: 11px 5px; text-indent: 5px;">
		<span onclick="ordercenter()">您有未支付的保单，可点此查看。立即进入。</span><span class="am-icon-close"
			style="float: right; padding-top: 3px;" onclick="hidetips()"></span>
	</div>

	<div class="page">
		<div data-am-widget="slider">
			<img src="${webRoot }/plug-in/totaiwan/img/futai_index.jpg">
		</div>
		<div class="futai_tel">报案电话</div>
		<div class="futai_tel_center">
			<div class="left">
				<a href="tel:4008-817-518">大陆：4008-817-518</a>
			</div>
			<div class="right">
				<a href="tel:02-6603-1581">台湾：（02）6603-1581</a>
			</div>
		</div>
		<div class="futai_index_xian">&nbsp;</div>
		<%-- <c:forEach items="${productList}" var="product" varStatus="productINX">
			<c:if test="${product.internalcode =='ft0001' }"> --%>
				<div class="futai_index_pro" id="8a828ec655518b8b015551c2399d0001"
					onclick="showProduct(this)">
					<div class="img">
						<img
							src="${webRoot }/plug-in/totaiwan/img/futai_pro_1.jpg">
					</div>
				</div>
          <%--   </c:if>			
		</c:forEach> --%>
				
		<c:forEach items="${productList}" var="product" varStatus="productINX">
			<c:if test="${product.internalcode =='X00001' }">
				<div class="futai_index_pro_1" id="${product.id}"
					onclick="showProduct(this)">
					<div class="img">
						<img
							src="${webRoot }/plug-in/totaiwan/img/futai_pro_2.jpg">
					</div>
				</div>
            </c:if>
		</c:forEach>		
		 
		<div class="futai_index_pro_1">
			<div class="img">
				<img src="${webRoot }/plug-in/totaiwan/img/futai_pro_4.jpg">
			</div>
		</div>
		<div class="futai_index_xian">&nbsp;</div>
		<div class="futai_index_bottom">
			<div class="futai_index_bottom_left" onclick="showPro()">
				<div class="img">
					<img src="${webRoot }/plug-in/totaiwan/img/futai_lipeizhuanqu.jpg">
				</div>
			</div>
			<div class="futai_index_bottom_right" onclick="welfare()">
				<div class="img">
					<img src="${webRoot }/plug-in/totaiwan/img/futai_welfare.jpg">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			if ('${hasUnpaidPolicy}' == 'YES') {
				$("#gotopay").css("display", "block");
			}else{
				$("#gotopay").css("display", "none");
			}
		});
		
		function hidetips(){
			$("#gotopay").css("display", "none");
		}
		function showProduct(obj) {
			var id = obj.id;
			location.href = "${webRoot}/fo/taiwanController.do?showProduct&openid=${openid}&productid="+ id+"&version="+Math.random();
		}

		function uploadclaimImg() {
			location.href = "${webRoot}/fo/TotaiwanController.do?upload&openid=${openid}";
		}

		function welfare() {
			location.href = "${webRoot}/plug-in/totaiwan/futaishanjia.html";
		}

		function ordercenter() {
			location.href="${webRoot}/pay/taipayController.do?index&openid=${openid}";
		}
		
		function showPro(){			 
			location.href="${webRoot}/fo/notCarClaimController.do?claimsindex&openid=${openid}&version="+Math.random();
		}
	</script>
</body>
</html>