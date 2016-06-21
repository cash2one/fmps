<%@page import="org.jeecgframework.core.util.ResourceUtil"%>
<%@ page contentType="text/html; charset=utf-8" import="java.util.Enumeration,java.util.ResourceBundle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>女王令</title>
<%
ResourceBundle bundler = ResourceUtil.getBundleEnvAbout();
String basePath = bundler.getString("domain");
String currentEnv = bundler.getString("currentEnv");
String userAgent = request.getHeader("user-agent");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<% if (currentEnv.equalsIgnoreCase("prod") && userAgent.indexOf("MicroMessenger") <= -1) { %>
<meta http-equiv="Refresh" content="0; url=<%=basePath%>/plug-in/weixin/onlyweixin.html" />
<%} %>
<style type="text/css">
 body{ background:url(<%=basePath%>/plug-in/fo/images/womens_day_bg_1.jpg) scroll center no-repeat; height:660px; margin:0 auto;}
 .nbsp{ height:290px;}
 .nbsp_1{ height:40px;}
 .nbsp_2{ height:100px;}
 .title_text{ color:#892117; margin:0 auto; width:100%; text-align:center; font-size:18px; font-weight:700;}
 .title_text_center{ width:205px; margin:0 auto; text-align:left; font-size:12px; color:#892117; margin-top:15px; line-height:17px; height:60px;}
 .anniu{ width:205px; margin:0 auto; text-align:center; color:#892117; font-weight:700; font-size: 18px;}
 .anniu_1{  width:205px; text-align:center;}
 .tip{ color:#f61803; font-size:12px; text-align:center; width:100%; line-height:20px;}
</style>
<script> 
  wx.config(${JSONString});
  //1.判断当前版本是否支持指定 JS 接口，支持批量判断
  wx.ready(function () {

    wx.checkJsApi({
      jsApiList: [
        'onMenuShareTimeline',
        'onMenuShareAppMessage'
      ],
      success: function (res) {
        alert(JSON.stringify(res));
      }
    });


	// 2. 分享接口
	// 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareAppMessage({
      title: '女王令',
      desc: '在长大的过程中，我才慢慢发现，我身边的所有事，别人跟我说的所有事，那些所谓本来如此，注定如此的事，它们其实没有非得如此，事情是可以改变的。更重要的是，有些事既然错了，那就该做出改变。',
      link: '${link}',
      imgUrl: '<%=basePath%>/plug-in/fo/images/pic300.jpg',
      trigger: function (res) {
        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
        alert('用户点击发送给朋友');
      },
      success: function (res) {
        alert('已发送给朋友');
      },
      cancel: function (res) {
        alert('已取消发送给朋友');
      },
      fail: function (res) {
        alert(JSON.stringify(res));
      }
    });



  // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareTimeline({
      title: '女王有令,速速领旨',
      link: '${link}',
      imgUrl: '<%=basePath%>/plug-in/fo/images/pic300.jpg',
      trigger: function (res) {
        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
        alert('用户点击分享到朋友圈');
      },
      success: function (res) {
        alert('已分享朋友圈');
      },
      cancel: function (res) {
        alert('已取消分享朋友圈');
      },
      fail: function (res) {
        alert(JSON.stringify(res));
      }
    });
  });

	wx.error(function (res) {
	  alert(res.errMsg);
	});

</script>
</head>

<body>
 <input type="hidden" id="openid" value="${openid }" />
 
 <div id='wx_pic' style='margin:0 auto;display:none;'>
 <img src='<%=basePath%>/plug-in/fo/images/pic300.jpg' />
 </div>

 <div class="nbsp">&nbsp;</div>
 <div class="title_text" id="title">${title }</div>
 <div class="title_text_center" id="content">${content }</div>
 <div class="nbsp_1">&nbsp;</div>
 <div class="anniu"><a href="#" onclick="changeTitle();" style="text-decoration:none; color: #892117;">换</a></div>
 <div class="nbsp_2">&nbsp;</div>
 <div class="tip"><a style="color: #f61803;" href="<%=basePath%>/fo/womensDayCardController.do?method=prepareReceiveCard&openid=${openid}">免费领取富邦3.8节关爱礼物</a><br />活动有效期至2015年4月8日，礼品有限，领完即止
</div>
<script src="<%=basePath%>/plug-in/jquery/jquery-1.8.3.js"></script>
<script>
$(document).ready(function() { 
	if($("#title").text() == ""){
		changeTitle();
	}
}); 

function changeTitle(){
    var index = Math.floor(Math.random() * 20);
    
    var titleArr = ['一场说走就走的旅游','豪华情调大餐','游乐场游玩一天','高级美容SPA','给我包个大红包','项链一条','小金库如数上缴',
                    '做一餐美食给我','陪我逛街一天，拎包买单','为我做一天家务','送我个名牌包包','送我一组化妆品','送辆车',
                    '亲自为我按摩','陪我看一场电影','替我带宝宝一天','感受自由','帅气拉风','送一台iphone6','送平板电脑'];
    var contentArr = ['亲，带我去旅游吧！伦家好想去云南的大理、泰国的普吉岛、希腊的爱琴海，还有……','如果这时候，我们坐在迪拜的帆船酒店，品尝着阿拉伯美食，那该有多好啊！',
                      '今天，我不想别的，就想去游乐场坐旋转木马！','今天我做spa，你来买单。','爱我就给我包个520元的红包！','你要送我条高大上的项链！',
                      '前不久你私藏的小金库，今天也该拿出来充公了吧！','难得今天我最大！你还不下厨做点好吃的！','商场打折天天有，难得今天3.8节，这拎包买单的活你都给包了吧！',
                      '解放女人,从解放双手开始!今天的家务活你来做。','听说有一种包叫lv(驴)，还是世界名牌，你给我也买一个！','让我感觉自己美美哒！',
                      '亲，求赐车一部。听说最近公交站人多的挤得鞋后跟都挤没了，挤得男生都怀孕了！','听说你之前学过“马杀鸡”？难得今天给你施展身手的机会，你可得好好给我按按。',
                      '还记得以前，我们去看恐怖电影吗？结果你比我还胆小……','一年365天，只有今天你是法定的超级奶爸！','让我过一天真正不用做家务、不要煮饭、不用管小孩的女人节吧！',
                      '用哈雷机车载我去兜风下吧','亲，你造吗？最近卖肾的人又多了，因为iphone6出来了！为了我健康的身体，你就买一台给我吧！',
                      '你知道我爱看剧，可是手机屏幕太小，盯得眼睛好花啊！不说ipad，你也懂的！']; 
    $("#title").text(titleArr[index]);
    $("#content").text(contentArr[index]);
    
    var url = "<%=basePath%>/fo/womensDayCardController.do?method=changeTitle";
    
    //更新女王令表
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {openid:$('#openid').val(), title:$('#title').text(), content:$('#content').text() },
		 async: true,
		 error : function(result) {
			 // 请求失败处理函数
		 },
		 success: function(result){
			 var data = $.parseJSON(result);
			 if(data.success){
				 //success
			 }else{
				 //warn
			 }
			 
		 } 
		});

}
</script>
</body>
</html>
