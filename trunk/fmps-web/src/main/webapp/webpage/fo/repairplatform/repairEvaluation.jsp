<!doctype html>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<title>爱车之家</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style>
html, body, .page {
	height: 100%;
}

#wrapper {
	position: relative;
	bottom: 0;
	margin: 0;
	width: 100%;
	background-color: #fff;
}

.am-list {
	margin: 0;
}

.am-list>li {
	background: none;
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8);
	padding: 10px 0px 10px 0px;
}

.pull-action {
	text-align: center;
	height: 45px;
	line-height: 45px;
	color: #999;
}

.pull-action .am-icon-spin {
	display: none;
}

.pull-action.loading .am-icon-spin {
	display: block;
}

.pull-action.loading .pull-label {
	display: none;
}

.am-btn-primary {
	color: #222;
	background-color: #fff;
	border-color: #fff;
}

.am-btn {
	font-size: 1.4rem;
	padding: 0.3em 0.3em;
}

.am-topbar {
	min-height: 50px;
}

.am-header .am-header-title {
	margin: 0 15%;
}

.am-btn-secondary {
	color: #3bb4f2;
	background-color: #ffffff;
	border-color: #3bb4f2;
}

.am-btn-primary {
	width: 100%;
	background: #0f90d2;
	color: #fff;
	height: 45px;
}

ul {
	list-style-type: none;
}

#star {
	position: relative;
	width: 100%;
	margin: 0px auto;
}

#star ul, #star span {
	float: left;
	display: inline;
	height: 40px;
	line-height: 30px;
}

#star ul {
	margin: 0px 10px 0;
}

#star li {
	float: left;
	width: 40px;
	height: 32px;
	cursor: pointer;
	text-indent: -9999px;
	cursor: pointer;
	text-indent: -9999px;
	background: url('../plug-in/repair/star.png') no-repeat;
}

#star strong {
	color: #AAAAAA;
	padding-left: 10px;
}

#star li.on {
	background-position: 0 -40px;
}

ul, ol {
	padding-left: 0.1em;
}
</style>

</head>
<body>
	<div class="page">
		<header data-am-widget="header" class="am-header am-header-default">
			<div class="am-header-left am-header-nav"></div>
			<h1 class="am-header-title" style="font-size: 1em;">
				<a href="#title-link" class="">${repairname}</a>
			</h1>
			<div class="am-header-right am-header-nav"></div>
		</header>
		<form id="evaform" name="evaform"
			action="${webRoot}/fo/repairFactoryController.do?eval" method="post">
			<div id="wrapper" data-am-widget="list_news"
				class="am-list-news am-list-news-default">
				<!-- <div
				style="margin: 0 auto; width: 100%; text-align: center; padding-top: 15px;">
				总体 <img src="../plug-in/repair/start_2.jpg" width="200" height="35" />
				3星
			</div>-->
				<div id="star"
					style="clear: both; margin: 0 auto; width: 100%; text-align: center; padding-top: 15px; height: 50px;">
					<div style="float: left; width: 15%; text-align: right;">总体</div>
					<div>
						<ul>
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>
						</ul>
					</div>
					<span></span>
					<!--<p></p>-->
				</div>
				<input type="hidden" id="openid" name="openid" value="${openid}" />
				<input type="hidden" id="repairId" name="repairId"
					value="${repairId }" /> <input type="hidden" id="score"
					name="score" value="" />
				<div
					style="margin: 0 auto; width: 100%; text-align: center; padding-bottom: 15px; line-height: 35px; clear: both;">
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="速度非常快啊">速度非常快啊</button>
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="修的跟新的一样">修的跟新的一样</button>
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="态度非常好">态度非常好</button>
					<br />
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="师傅手艺非常好噢！推荐">师傅手艺非常好噢！推荐</button>
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="修的一般">修的一般</button>
					<button type="button" class="am-btn am-btn-secondary am-radius"
						onclick="setIdea(this)" value="非常差">非常差</button>
				</div>
				<div
					style="border-top: 1px solid #dedede; padding: 0 15px; height: 150px;">
					<textarea id="idea" name="idea"
						placeholder="服务是否专业？价格是否合理？您的意见非常重要。"
						style="width: 100%; border: 0px; margin-top: 10px;"></textarea>
				</div>
                <div id="ideatemp" style="color: red; text-align: left; text-indent: 10px;clear: both;" ></div>
				
				<div
					style="background-color: #f8f8f8; border-top: 1px solid #dedede; padding-top: 20px;">
					<input type="button" style="height: 45px; width: 100%;"
						class="am-btn am-btn-primary btn-loading-example"
						onclick="submitOrder()" value="提交"></input>
				</div>
			</div>
		</form>
		<div style="display:none" id="evaluationflag" >${evaluationflag}</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var oStar = document.getElementById("star");
					var aLi = oStar.getElementsByTagName("li");
					var oUl = oStar.getElementsByTagName("ul")[0];
					var oSpan = oStar.getElementsByTagName("span")[0];
					var oP = oStar.getElementsByTagName("p")[0];
					var i = iScore = iStar = 0;
					for (i = 1; i <= aLi.length; i++) {
						aLi[i - 1].index = i;
						//鼠标移过显示分数
						aLi[i - 1].onmouseover = function() {
							fnPoint(this.index);
						};
						//鼠标离开后恢复上次评分
						aLi[i - 1].onmouseout = function() {
							fnPoint();
						};
						//点击后进行评分处理
						aLi[i - 1].onclick = function() {
							iStar = this.index;
							oSpan.innerHTML = "<strong>" + (this.index)
									+ " 星</strong>";
							$("#score").val(this.index);
							fnPoint();
						}
					}
					//评分处理
					function fnPoint(iArg) {
						//分数赋值
						iScore = iArg || iStar;
						for (i = 0; i < aLi.length; i++)
							aLi[i].className = i < iScore ? "on" : "";
					}
				});

		function setIdea(obj) {
			var touchtext = obj.value;
			document.getElementById("idea").value = touchtext;
		}

		function submitOrder() {
			var idea=document.getElementById("idea").value;
			var score=document.getElementById("score").value;
			if(idea==""){
				$("#ideatemp").text("**请输入评价内容");
			}else{
				if(score==""){
					$("#ideatemp").text("**请点选总体星级 ");
				}else{
					var evaluationflag=$("#evaluationflag").html();
					if(evaluationflag=='1'){
						document.evaform.submit();
					}else{
						alert("该维修厂您已经评论过，不能评价。 ");
					}
	
				}
			}
		}
	</script>
	<!--<![endif]-->
</body>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
