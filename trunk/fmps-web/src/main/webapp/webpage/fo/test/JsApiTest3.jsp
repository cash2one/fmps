<%@ page contentType="text/html; charset=utf-8" import="java.util.Enumeration,java.util.ResourceBundle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>jssdk测试</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

<script> 
  wx.config(${JSONString});
  //1.判断当前版本是否支持指定 JS 接口，支持批量判断
  wx.ready(function () {
	// 1 判断当前版本是否支持指定 JS 接口，支持批量判断
  document.querySelector('#checkJsApi').onclick = function () {
	    wx.checkJsApi({
	      jsApiList: [
	        'getNetworkType',
	        'previewImage'
	      ],
	      success: function (res) {
	        alert(JSON.stringify(res));
	      }
	    });
	  };

     // 6.1 获取当前网络状态
	document.querySelector('#getNetworkType').onclick = function () {
	    wx.getNetworkType({
	      success: function (res) {
	        alert(res.networkType);
	      },
	      fail: function (res) {
	        alert(JSON.stringify(res));
	      }
	    });
	  };

	  
 // 2. 分享接口
	// 2.1 监听“发送给朋友”，按钮点击、自定义分享内容及分享结果接口
  wx.onMenuShareAppMessage({
    title: '分享给盆友百度',
    desc: 'xxxxxxxxxx',
    link: '${url}',
    imgUrl: '${Domain}/plug-in/fo/images/pic300.jpg',
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
    title: '分享到盆友圈百度',
    link: '${url}',
    imgUrl: '${Domain}/plug-in/fo/images/pic300.jpg',
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
      <p>*********分享朋友圈测试**********</p>
      <p>*********分享朋友测试**********</p>  
       <p>*********判断当前客户端是否支持指定JS接口*******</p>
      <button  id="checkJsApi">checkJsApi</button>    
      <p>********获取网络状态接口*******</p>
      <button  id="getNetworkType">getNetworkType</button> 
      <p>*********分享测试**********</p> 
</body>
</html>
