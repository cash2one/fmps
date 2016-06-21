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
 <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
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

.erweima_bg {
	background-color: #0f90d2;
	width: 100%;
	height: auto;
}

.erweima {
	margin: 0 auto;
	width: 100%;
	text-align: center;
	padding-bottom: 5px;
	padding-top: 25px;
}

.erweima_text {
	color: #fff;
	font-family: "微软雅黑";
	font-size: 1.25em;
	text-align: center;
	line-height: 25px;
	padding-bottom: 10px;
}

.erweima_tiao {
	background: #0f90d2;
	width: 100%;
	height: 12px;
}

.erweima_di {
	height: 20px;
	background-color: #fff;
	width: 100%;
}

.erweima_tips {
	height: 130px;
	background-color: #fff;
}

.erweima_tips_text {
	line-height: 26px;
	width: 90%;
	margin: 0 auto;
}

.erweima_tips_text_2 {
	line-height: 22px;
	width: 90%;
	margin: 0 auto;
	font-size: 0.825em;
	padding-top: 15px;
}
.ui-dialog .ui-dialog-titlebar{
   padding:0em; 
}
.ui-dialog .ui-dialog-content {
  padding: .6em 4em;
}

</style>

<script type="text/javascript">


	function getNewQRcode() {	
		var QRphone = document.getElementById("QRphone");
		var img = document.getElementById("QRcode");
		var uuid='${uuid}';
		var value=QRphone.value;
		var openid='${openid}';
		   img.src = '${webRoot}/fo/repairFactoryController.do?getQRcode&QRphone='
				+ value+'&uuid='+uuid; 
		//alert($('#QRcode').attr('src'));
		 $.ajax({
				type: "POST",
				url : "${webRoot}/fo/repairFactoryController.do?qPhoneRcodeajax",
				data:{uuid:uuid,QRphone:value},
				dataType: "json",
				success: function(json){
					//存在二维码则弹出提示框
					if(json.success){
							setTimeout(function(){
								$( "#dialog" ).dialog("open");
						         $("body").animate({"top":"0px"},1000,function(){
						             $( "#dialog" ).dialog("close");
						         });
								},1000); 
					}
					
				}
		});
		//alert(img.src);
		
	}
	//每20分钟刷新一次页面 
	function myrefresh() 
	{ 
	       window.location.reload(); 
	} 
	setTimeout('myrefresh()',240000); // 指定4分钟刷新一次 
	
    //每5秒ajax 检查memcache key=uuid , value=2(已扫码)
	setInterval("checkMemcache()", 5000); //5秒执行一次checkMemcache函数。
	
	
	function checkMemcache()
	{
		var uuid='${uuid}';
		 $.ajax({
				type: "POST",
				url : "${webRoot}/fo/repairFactoryController.do?method=qRcodeajax",
				data:{uuid:uuid},
				dataType: "json",
				success: function(data){
					var QRphone = document.getElementById("QRphone").value;
					if(data=="1"){
						location.href ="${webRoot}/fo/repairFactoryController.do?method=toCaseList&openid=${openid}&QRphone="+QRphone+"&uuid=${uuid}"; 
					}
					
				}
		});

	}
	
	
    $(document).ready(function(){
        $( "#dialog" ).dialog();
        $( "#dialog" ).dialog("close");
    });
</script>
</head>
<body>
	<div class="page">
		<div id="wrapper" data-am-widget="list_news"
			class="am-list-news am-list-news-default">
			<div class="erweima_bg">
				<div class="erweima">
					<img id="QRcode"
						src="${webRoot}/fo/repairFactoryController.do?getQRcode&flag=1"
						width="183" height="178" />
				</div>
				<div class="erweima_text">
					使用前请出示此二维码
				</div>
				<div id="uuid" style="display:none">${uuid}</div>
				<div class="erweima_tiao"></div>
				<%-- <div class="erweima_tips">
					<div class="erweima_tips_text">温馨提示：</div>
					<div class="erweima_tips_text_2">
						1. 维修前出示此二维码，维修平台的所有厂商将保证赔款足够修理，无须多掏费用<br /> 2.
						如处理其他报案手机的闪赔案件，可点此 <a style="color: #0f90d2;"href="${webRoot}/fo/repairFactoryController.do?method=QRcodePagePhone">输入报案电话</a>
					</div>
				</div> --%>
				<div class="erweima_di">&nbsp;</div>
				<div class="erweima_tips" style="height: 80px;">
					<div class="erweima_tips_text">请输入报案手机号获取二维码：</div>
					<div class="erweima_tips_text_2">
						<div style="float: left; width: 70%;">
							<input id="QRphone" name="" type="text"
								style="height: 30px; width: 90%; border-bottom: 1px solid #dedede; border-top: 0px solid #dedede; border-left: 0px solid #dedede; border-right: 0px solid #dedede;">
						</div>
						<a href="#" onclick="getNewQRcode()">
							<div
								style="background-color: #0f90d2; width: 80px; height: 30px; float: left; text-align: center; color: #FFFFFF; line-height: 30px;">
								获 取</div>
						</a>
					</div>
				</div> 
			</div>
		</div>
		
		 <div id="dialog">二维码已经更新</div>
	</div>
	<!--<![endif]-->
</body>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
