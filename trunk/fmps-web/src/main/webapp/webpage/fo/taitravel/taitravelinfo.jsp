<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/webpage/fo/common/fotags.jsp"%>  
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
  <title>富邦财险</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">

  <style>
    html,
    body,
    .page {
      height: 100%;
    }

    #wrapper {
      position:relative;
      
      bottom: 0;
  
      margin: 0;
      width: 100%;
      background-color: #fff;
    }

    .am-list {
      margin: 0;
    }

    .am-list > li {
      background: none;
      box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.8); padding:10px 0px 10px 0px;
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

.am-btn {
  font-size: 1.4rem;
  padding: 0.1em 0.1em;
     }
	 .am-topbar {
  min-height: 50px;}

.am-header .am-header-title {
  margin:0 15%
  ;}
  [data-am-widget='tabs'] {
  margin: 0px;
}
  .fb_Comment{ padding:10px 15px; clear:both; height:auto; width:100%; border-bottom:1px solid #dedede; float:left;}
  .fb_Comment_img{
-webkit-border-radius:50px;
-moz-border-radius:50px;
-o-border-radius:50px;
border-radius:50px; 
background:url(images/futai_index_pro.jpg) scroll center no-repeat; 
height:50px; 
width:50px;
float:left;
}
.fb_Comment_text{ float:left; width:80%; padding-left:10px; font-size:0.825em; color:#222222;}
.am-tabs-bd {

  border: 0px solid #ddd;

}
.am-tabs-bd .am-tab-panel {
  position: absolute;
  top: 0;
  z-index: 99;
  float: left;
  width: 100%;
  padding: 10px 10px 15px;
  visibility: hidden;
}
.am-titlebar {
  margin-top: 2px;

}
table tr td{ height:40px; text-align:center; font-size: 0.75em;}
.am-tabs-bd {
  margin-bottom: 1px;}
  </style>
</head>
<body>
<div class="page">
<header data-am-widget="header" class="am-header am-header-default">
  <div class="am-header-left am-header-nav">
    
  </div>
  <h1 class="am-header-title" style="font-size:1em;">
    <a href="#title-link" class="">赴台旅游险</a>
  </h1>
  <div class="am-header-right am-header-nav">
  </div>
</header>

<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
  <div class="am-tabs-bd">
    <div data-tab-panel-0 class="am-tab-panel am-active">
     <div style="margin:0 auto; width:100%; font-size:0.75em; text-align:center;">
<form action="${webRoot}/pay/taipayController.do?savePolicy" method="post"  id="form1" name="form1">
<table width="100%" border="0" style=" border-bottom:1px solid #dedede;">
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; background-color:#f3f3f3; font-size:0.825em; text-indent:2px; text-align:left;">保障内容</td>
    <td style="border-bottom:1px solid #dedede; width:19%; background-color:#f3f3f3; font-size:0.825em;">方案一</td>
    <td style="border-bottom:1px solid #dedede; width:19%; background-color:#f3f3f3;  font-size:0.825em;">方案二</td>
    <td style="border-bottom:1px solid #dedede; width:19%; background-color:#f3f3f3;  font-size:0.825em;">方案三</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">突发急性病身故保险金</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">50万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">40万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">30万</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">意外伤害风险保障</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">50万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">40万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">30万</td>
  </tr>
  <tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">医疗费用保险金 </td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">30万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">20万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">10万</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">住院关怀慰问金</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">500元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">400元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">300元</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">紧急救援保障限额</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">10万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">10万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">10万</td>
  </tr>
    <tr>
    <td  style="border-bottom:1px solid #dedede; width:40%; text-align:left;">亲友探视及住宿</td>
    <td colspan="3" style="border-bottom:1px solid #dedede; width:19%; ">单程经济舱机票及住宿费用</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">个人责任保障金</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">50万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">40万</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">30万</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">旅行证件丢失保险金</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">2000元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">2000元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">2000元</td>
  </tr>
  <tr>
    <td style="border-bottom:1px solid #dedede; width:43%; text-align:left;">托运行李延误赔偿金</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">1000元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">1000元</td>
    <td style="border-bottom:1px solid #dedede; width:19%; ">1000元</td>
  </tr>
  <!--保险期间-->
    <tr>
    <td colspan="4" style="border-bottom:1px solid #dedede; width:40%;  background-color:#f3f3f3; font-size:0.825em; text-indent:2px; text-align:left;">保险期限及保险费<span style="color: red; font-weight: 700;">（请点击选择下方保费方案）</span></td>
    </tr>
    
      <c:forEach items="${schemeAddressList}"	var="schemeAddress" varStatus="status">
     <tr id="tr${status.index}">
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:40%; text-align:left;">${schemeAddress.period}</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">${schemeAddress.premiumsf}</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">${schemeAddress.premiumss}</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">${schemeAddress.premiumst}</td>
  </tr > 
       </c:forEach> 
    
 <!--  <tr id="tr1">
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:40%; text-align:left;">6个月</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1080元</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">780元</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">600元</td>
  </tr > -->
  
  
   <!--  <tr id="tr2">
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:40%; text-align:left;">10个月</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1620元</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1180元 </td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">900元</td>
  </tr>
    <tr id="tr3">
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:40%; text-align:left;">一年期</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1800元</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1300元</td>
    <td onclick="radioShow(this);" style="border-bottom:1px solid #dedede; width:20%; ">1000元</td>
  </tr> -->
</table>
 <%--  <input type="hidden" id="id" name="id" value="${customerg.id}"> --%>
  <input type="hidden" id="name" name="name" value="${name}">
  <input type="hidden" id="identifytype" name="identifytype" value="${identifytype}">
  <input type="hidden" id="identifynumber" name="identifynumber" value="${identifynumber}">
  <input type="hidden" id="phone" name="phone" value="${phone}">
  <input type="hidden" id="school" name="school" value="${school}">
  <input type="hidden" id="province" name="province" value="${province}">
  <input type="hidden" id="city" name="city" value="${city}">
  <input type="hidden" id="area" name="area" value="${area}">
  <input type="hidden" id="detail" name="detail" value="${detail}">
 


  <input type="hidden" id="schemetype" name="schemetype" value="${schemetype}">
  <input type="hidden" id="period" name="period" value="${period}">
  <input type="hidden" id="premium" name="premium"  value="${premium}">
  <input type="hidden" id="openid" name="openid" value="${openid}">
  </form>
  
</div>

    </div>
    </div>
  </div>
  <div id="messagtemp" style="color: red; text-align: left; text-indent: 10px;" ></div>
  
    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
  <h2 class="am-titlebar-title">温馨提示</h2>

</div>
<div style="width:90%; margin:0 auto; font-size:0.75em;">
1、医疗费用保障每次事故无绝对免赔额。
<br/>
2、住院3日以上一次性给付住院关怀慰问金，保险期间内以一次为限。
<br/>
3、紧急救援保障内容含医疗运送运返、身故遗体送返。
<br/>
4、个人责任保障每次事故绝对免赔额为500元。
<br/>
5、因遗失证件所导致的额外交通、酒店、证件补领费用，每次最高1000元。
<br/>
6、托运行李每延误8小时赔偿500元，最高以保险金额为限。
</div>
<button type="button" style="height:45px;   width: 100%;" class="am-btn am-btn-primary btn-loading-example" data-am-loading="{spinner: 'circle-o-notch'}" id="next">下一步</button>
 
</div>
</div>
</div>

<script type="text/javascript">
//radio点击切换 
	function radioShow(obj){
    var value=obj.innerText;  
    $('#tr0').find('td').each(function(){
    	if($(this).index()==0){
    		$(this).attr("style","border-bottom:1px solid #dedede; width:40%; text-align:left; ");	
    	}else{
    		$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");
    	}
    	
      }); 
    $('#tr1').find('td').each(function(){
    	if($(this).index()==0){
    		$(this).attr("style","border-bottom:1px solid #dedede; width:40%; text-align:left; ");	
    	}else{
    		$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");
    	}
    }); 
    $('#tr2').find('td').each(function(){
    	if($(this).index()==0){
    		$(this).attr("style","border-bottom:1px solid #dedede; width:40%; text-align:left; ");	
    	}else{
    		$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");
    	}
    }); 
    
		$('#tr0').find('td').each(function(){
			if(value==$(this).html()){
				if($(this).index()!=0){
					if($(this).attr("style").trim()=="border-bottom:1px solid #dedede; width:20%;"){
					$(this).attr("style","border-bottom:1px solid #dedede; width:20%; background-color: #0e90d2; color: #fff;");
					$("#premium").val(value);
				    }else{
				    	$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");		
				    }
				}
			}
		}); 
		$('#tr1').find('td').each(function(){
			if(value.trim()==$(this).html().trim()){
				if($(this).index()!=0){
					if($(this).attr("style").trim()=="border-bottom:1px solid #dedede; width:20%;".trim()){
					$(this).attr("style","border-bottom:1px solid #dedede; width:20%; background-color: #0e90d2; color: #fff;");
					$("#premium").val(value);
					}else{
				    	$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");		
				    }
				}
			}
		}); 
		$('#tr2').find('td').each(function(){
			
			if(value==$(this).html()){
				if($(this).index()!=0){
					if($(this).attr("style").trim()=="border-bottom:1px solid #dedede; width:20%;"){
					$(this).attr("style","border-bottom:1px solid #dedede; width:20%; background-color: #0e90d2; color: #fff;");
					$("#premium").val(value);
				    }else{
				    	$(this).attr("style","border-bottom:1px solid #dedede; width:20%; ");				
				    }
				}	
			}
		}); 	   
			   }

//初始化
	$(document).ready(function () {
		
	
	//下一步点击提交 
	$('#next').click(function () {
		var actionurl = $('form').attr('action');//提交路径
		var premium = $("#premium").val();
		var schemetype = $("#schemetype").val();
		var period = $("#period").val();
		if(schemetype==""||schemetype==null){
			schemetype="方案一";
		}
		if(period==""||period==null){
			period="6个月";		
		}
		$("#messagtemp").text('');
		if(premium==""||premium==null){
			$("#messagtemp").text('**请选择具体的投保方案。');
			return;
		}
		
	 	
		if(premium.trim()=="1080元 ".trim()||premium.trim()=="780元 ".trim()||premium.trim()=="600元 ".trim()){
			period="6个月";
    	}
		if(premium.trim()=="1620元 ".trim()||premium.trim()=="1180元 ".trim()||premium.trim()=="900元 ".trim()){
			period="10个月";
		}
		if(premium.trim()=="1800元 ".trim()||premium.trim()=="1300元 ".trim()||premium.trim()=="1000元 ".trim()){
			period="一年";
		} 
		
		if(premium.trim()=="1080元 ".trim()||premium.trim()=="1620元 ".trim()||premium.trim()=="1800元 ".trim()){
			schemetype="方案一";
    	}
		if(premium.trim()=="780元 ".trim()||premium.trim()=="1180元 ".trim()||premium.trim()=="1300元 ".trim()){
			schemetype="方案二";
		}
		if(premium.trim()=="600元 ".trim()||premium.trim()=="900元 ".trim()||premium.trim()=="1000元 ".trim()){
			schemetype="方案三";
		} 

		var openid= $("#openid").val();
		var btn = $(this);	
		 btn.button('loading');
		    setTimeout(function(){
		        btn.button('reset');
		    }, 15000);
		    premium=premium.replace("元","");
		    
		    $("#period").val(period);
		    $("#schemetype").val(schemetype);
		    $("#premium").val(premium);
		    $("#openid").val(openid);
		    
		    document.form1.submit(); 
		/* location.href = actionurl + "&period="+period+"&schemetype="+schemetype+"&premium="+premium+"&openid="+openid;	 
 */
 	});

});
</script>
</body>
</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
