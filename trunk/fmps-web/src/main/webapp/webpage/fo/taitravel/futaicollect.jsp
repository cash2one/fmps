<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/webpage/fo/common/fotags.jsp"%>  
<!doctype html>
<head>
  <meta charset="UTF-8">
  <title>富邦财险</title>
    <style>
    html,
    body,
    .page {
      height: 100%;
    }

    #wrapper {
      position: absolute;
      top: 49px;
      bottom: 0;
      overflow: hidden;
      margin: 0;
      width: 100%;
      padding: 0 8px;
      background-color: #f8f8f8;
    }
   .am-tabs-bd {

  border: 0px solid #ddd;

}
	.Business_list{ width:100%; float:left; margin-bottom:8px; border-bottom:1px solid #dbdbdb;}
	.Business_title{ text-align:left; font-weight:700; }
	.Business_img{ width:30%; float:left;}
	.Business_text{ width:70%; float:left; font-size:14px;}
	.Business_add{ clear:both; font-size:14px; line-height:16px; color:#777777; padding-bottom:10px; padding-top:3px;}
	.liangdian_1_text_3{ text-align:left; font-size:12px; color:000; padding-bottom:8px; line-height:20px; width:91%; margin:0 auto;}
	.am-btn-primary {width: 100%;  color: #fff; background-color: #0e90d2; border-color: #0e90d2;}
	</style>
</head>

<body>
<header data-am-widget="header" class="am-header am-header-default">

  <h1 class="am-header-title">
    <a href="#title-link" class="">赴台专区</a>
  </h1>
</header>

<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title ">理赔资料在线上传</h2>

</div>
<div class="liangdian_1_text_3">
亲爱的同学，如已确认索赔，则视同您已同意以下声明<br /><br />
兹声明，本人向富邦财产保险有限公司索赔的资料均为真实，无任何虚假和隐瞒，否则，愿放弃本保险单之一切权利并承担相应的法律责任。<br />
请将相关理赔资料直接上传，谢谢<br />
</div>
 <!-- <header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
<div style="line-height:50px;">上传资料</div>
</header> -->

<button type="button" style="height:45px;   width: 100%;" class="am-btn am-btn-primary am-btn-lg am-btn-block"  id="upSub">上传资料</button>

<script type="text/javascript">

$(document).ready(function () {
	 
	   
    /*  提交处理函数    */
	$('#upSub').click(function () {
			 
		window.location.href="${webRoot}/fo/TotaiwanController.do?upload&openid=${openid}";
		        
});
    
});

</script>

</body>
</html>
