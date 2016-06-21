<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>加油宝活动</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${webRoot }/plug-in/gasolinegift/css/there.css" />
  <script type="text/javascript"> 
  $(document).ready(function(){   
	  goTopay()   
	 }); 
  
function goTopay(){		
		var applyId='${applyId}';
		var oilcardPayUrl='${oilcardPayUrl}';
		var backUrl="${webRoot}/fo/binded/gasolinegift/gasolinegiftController/payNotify.do" ;
		var url=oilcardPayUrl+"?applyId="+applyId+"&devsimulatewxopenid=apitestxdcxvxcvdsfsd&backUrl="+ encodeURIComponent(backUrl);
		//alert(url);
		location.href =url;
	}	
  </script>
</head>

<body> 
</body>
</html>