<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加油宝活动</title>
  <meta name="description" content="加油宝活动" />
  <meta name="keywords" content="user" />
  <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width" />
  <meta name="format-detection" content="telephone=no" />
  <meta name="renderer" content="webkit" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <%@ include file="/webpage/fo/common/fotags.jsp"%>
  <script type="text/javascript">
  	var json = ${jsonString};
	wx.config(json);
	
	wx.ready(function(){
		wx.onMenuShareTimeline({
			title: '这就是你要的加油神器，全国中石化95折！没有上限！加多少都95折！',
			link: '${link}',
			imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
			trigger: function (res) {
			},
			success: function (res) {
			},
			cancel: function (res) {
			},
			fail: function (res) {
				alert(JSON.stringify(res));
			}
		});
		
		wx.onMenuShareAppMessage({
			title: '给你推荐一款95折无上限加油神器。',
			desc: '这就是你要的加油神器，全国中石化95折！没有上限！加多少都95折！',
			link: '${link}',
			imgUrl: '${webRoot}/plug-in/cashcoupon/images/logo.jpg',
			trigger: function (res) {
			},
			success: function (res) {
			},
			cancel: function (res) {
			},
			fail: function (res) {
				alert(JSON.stringify(res));
			}
		});
	});

	wx.error(function(res){
		//信息验证失败
	});
  </script>
<style type="text/css">
body{ margin:0 auto; background-color:#2d3455; width:100%;}
.index_all{ margin:0 auto; background-color:#2d3455; width:100%; }
img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
}
.index_bg_4{ font-family:"微软雅黑"; font-size:14px; color:#FFFFFF; text-align:left; max-width:640px; padding:0 20px; line-height: 26px; padding-bottom:20px; padding-top:10px;}
ol li{list-style:decimal;}
</style>
</head>

<body>
 <div class="index_all">
  <div class="index_bg_1"><img src="${webRoot}/plug-in/gasolinegift/jiayou_1.jpg" /></div>
  <div class="index_bg_4">
凡厦门地区富邦车主参加加油宝活动，加油返利5%无门槛杠杠滴！比如每月加油1500元，立省75元，一年即省900元，加油金额不限，次数不限，加越多省越多哦！
  </div>
  <div class="index_bg_2"><img src="${webRoot}/plug-in/gasolinegift/jiayou_6.jpg" /></div>

  <div class="index_bg_5"><img src="${webRoot}/plug-in/gasolinegift/jiayou_3.jpg" /></div>
  <div class="index_bg_4">
   <ol type="1" style="padding-left:20px; margin:0px 0px 0px 0px;">
    <li>仅限厦门地区富邦家用车险客户（车牌闽开头） 办理 </li>
    <li>车主凭本人身份证原件、行驶证原件及申请邀请码至厦门地区任意厦门银行网点现场办理，每月可定额代扣或网银自助充值加油使用，次月15日返还充值金额5%至银行卡，无充值上限</li>
    <li>加油卡为中石化加油卡，在全国中石化加油站均可使用</li>
   </ol>
  </div>
   <div class="index_bg_6"><a href="${btnLink}"><img <c:choose><c:when test="${isApply}"> src="${webRoot}/plug-in/gasolinegift/jiayou_2_1.jpg" </c:when><c:otherwise> src="${webRoot}/plug-in/gasolinegift/jiayou_4.jpg" </c:otherwise></c:choose> /></a></div>
   <div class="index_bg_7"><img src="${webRoot}/plug-in/gasolinegift/jiayou_5.jpg" /></div>
 </div>
</body>
</html>
