<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html>
<html class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>抽红包</title>
    <style type="text/css">
html {
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
}
body {
  line-height: 1.6;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
* {
  margin: 0;
  padding: 0;
}
body, html {
	height:100%;
	-webkit-tap-highlight-color:transparent
}
.page, body {
	background-color:#fff3e2;
}
.container {
	overflow:hidden
}
.container, .page {
	position:absolute;
	top:0;
	right:0;
	bottom:0;
	left:0
}
.page {
	overflow-y:auto;
	-webkit-overflow-scrolling:touch;
	}
.weui_msg {
  padding-top: 45px;
  text-align: center;
}
.weui_msg .weui_icon_area {
  margin-bottom: 30px; 
  width:60%; 
  margin:0 auto;
}
.weui_msg .weui_text_area {
  margin-top: 25px;
  margin-bottom: 30px;
  padding: 0 20px;
  color:#895205;
  font-weight:bold;
}
.weui_text_area .col{ color:#e11423; font-size:34px;}
.weui_msg .weui_msg_title {
  margin-bottom: 5px;
  font-weight: 700;
  font-size: 20px;
  color:#895205;
}
.weui_msg .weui_msg_desc {
  font-size: 14px;
  color: #888;
}
.weui_msg .weui_opr_area {
  margin-bottom: 25px;
}
.weui_msg .weui_extra_area {
  margin-bottom: 15px;
  font-size: 14px;
  color: #888;
}
.weui_msg .weui_extra_area a {
  color: #61749B;
}
@media screen and (min-height: 438px) {
  .weui_extra_area {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    text-align: center;
  }
}
.weui_btn_area {
  margin: 1.17647059em 15px 0.3em;
}

}
.weui_icon_msg:before {
  font-size: 104px;
}

.weui_icon_success:before {
  color: #09BB07;
}
.weui_btn {
  position: relative;
  display: block;
  margin-left: auto;
  margin-right: auto;
  padding-left: 14px;
  padding-right: 14px;
  box-sizing: border-box;
  font-size: 18px;
  text-align: center;
  text-decoration: none;
  color: #FFFFFF;
  line-height: 2.33333333;
  border-radius: 5px;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  overflow: hidden; 
  background-color:#e11423;
}
img {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0;
}

    </style>
</head>
<body>
<div class="page">
    <div class="weui_msg">
        <div class="weui_icon_area"><img src="${webRoot}/plug-in/fo/images/bag.jpg" alt="#"/></div>
        <div class="weui_text_area">
            <p>恭喜你抽中<span class="col">${cashCoupon}元</span>现金红包<br/>请留意公众号的红包发放信息</p>
        </div>
        <div class="weui_opr_area">
            <p class="weui_btn_area">
            <a href="${webRoot}/fo/binded/personalCenter/policyController.do?method=Index&openid=${openid}" class="weui_btn"  >继续查看我的保单</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>