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
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
<%@ include file="/webpage/fo/common/fotags.jsp"%>
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
	.am-btn-primary {
  color: #222;
  background-color: #fff;
  border-color: #fff;
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
  .fb_Repair{ padding:0 15px; clear:both; height:auto; width:100%;}
  .fb_Repair_table_right_text_2{ font-size:0.825em; font-family:"微软雅黑"; color:#888; border-bottom:1px solid #dedede; height:25px; padding-left:15px;}
  .fb_Comment{ padding:10px 0px 0px 10px; clear:both; height:auto; width:100%; border-bottom:1px solid #dedede; float:left;}
  .fb_Comment_img{height:50px; width:20px; float:left;}
.fb_Comment_text{ float:left; width:80%; padding-left:10px; font-size:0.825em; color:#222222;}
.fb_Comment_text_1{ width:100%; padding-top:10px; font-size:0.825em; color:#222222; clear:both;}
.am-checkbox { margin-top: 1px;}
  </style>

<script type="text/javascript">

	
	
</script>
</head>
<body style="background-color:#f0f0f0;">
<form id="caseform" name="caseform"
			action="${webRoot}/fo/repairFactoryController.do?checkcase" method="post">
		
<div class="page">
 <header data-am-widget="header" class="am-header am-header-default">

  <h1 class="am-header-title" style="font-size:1em;">
    <a href="#title-link" class="">案件列表</a>
  </h1>
  <div class="am-header-right am-header-nav">
  </div>
</header>



  <div id="wrapper" data-am-widget="list_news" class="am-list-news am-list-news-default">

 <!--维修厂头部-->
  
     <div style="height:20px; background-color:#f0f0f0; border-bottom: 1px solid #dedede; border-top:1px solid #dedede;">&nbsp;</div>
     <div style="padding-top:10px; padding-bottom:10px; font-size:0.825em; border-bottom:1px solid #dedede; padding-left:10px; ">
        
     <c:if test="${repairname!= null&&repairname!=''}"> 
        <span style=" font-weight:bold;">${repairname}</span> 已扫描您出示的二维码。<br>
      </c:if>  
      <c:if test="${countsize!= null&&countsize!=''}">
      有${countsize}个案件待处理，请选择推修案件并确认。
      </c:if>
       <c:if test="${countsize== null||countsize==''}"> 
      您有0个案件待处理.
      </c:if>
  <!-- 
     <span style="color:red">*左滑案件可删除</span> -->
     </div>
    <!-- 
     <ul id="jjj">  -->   
      <c:forEach items="${reportInfoList}"	var="reportInfo" varStatus="status">
      <c:if test="${reportInfo!= null}"> 
      
               <c:if test="${countsize!= null}"> 
        <input type="hidden" id="countsize" name="countsize" value="${countsize}">
        </c:if>
  
<!--  <li>  -->      
<div >
 <div id="hjj" class="fb_Comment" style="background-color:#f7f7f7;">
 
  <div style="float: left; width: 100%;">
   <div onclick="changevalue(this.id);" id="${status.index}">  
   <label id="kkk" class="am-checkbox am-warning" >
   <input  reportInfo="0" data-am-ucheck class="checkin"  type="checkbox" id="${status.index}reportInfoid"     value="${reportInfo.id}"  name="ra${status.index}"> 
    <%--  <input  reportInfo="0" data-am-ucheck onclick="changevalue(this.id);" type="checkbox" id="${status.index}reportInfoid"     value="${reportInfo.id}"  name="ra${status.index}">
    --%> <%--  <input type="checkbox" id="reportInfoid" data-am-ucheck value="${reportInfo.id}"  name="ra${status.index}" >  --%>
   车牌：${reportInfo.licenseNo}<br/>时间：${reportInfo.reportDate} ${reportInfo.reportTime}<br/>案件信息： 
${reportInfo.remark}
   </label>
  </div>  
  
  </div>
 </div>
 
 <div id="kjj" class="kjj" gjj="${reportInfo.id}" style="float: left; display:none; width: 20%; height: auto; background-color:#ff3a31; color: #fff;text-align: center;">已维修<br/>不再显示</div>
 
 

 <!-- </li> -->

     <div  style="height:20px; background-color:#f0f0f0; clear:both; border-bottom:1px #dedede solid;">&nbsp;</div>
 </div>     
       </c:if> 
     </c:forEach>
  <!--   </ul>   --> 
     
     
     
   
    </div>
      <div id="sty" style="display:none;"></div>
       <input type="hidden" id="deleteId" name="deleteId" value="">
       <input type="hidden" name="openid" value="${openid}">
       <input type="hidden" name="uuid" value="${uuid}">
       <input type="hidden" name="phone" value="${phone}">
        <input type="hidden" name="repairname" value="${repairname}">
       
  </div>
 <button type="button" style="height:45px;   width: 100%;" class="am-topbar am-topbar-inverse am-topbar-fixed-bottom"  onclick="submitOrder()" id="paySub">确认</button>

  </div>
</div>
</form>
</body>
<script>

function submitOrder() {
	       //判断有没有选中多选框
		    var ss=0;
		     $("#kkk input").each(function() { 
		    	if($(this).attr("reportInfo")=="1") {
		    		ss=ss+1;
		    	}
		    	 }); 
		     
            var uncheck=$("#deleteId").val(); 

		    if(ss!=0||uncheck!=""){
			    document.caseform.submit(); 	
		    }else{
		    	alert("您还未选择要处理的案件，请选择或者删除案件 。");
		    }

}

</script>
<!-- 
<script src="http://code.jquery.com/mobile/1.4.3/jquery.mobile-1.4.3.min.js"></script> -->
<script type="text/javascript">
function changevalue(reportInfoid){

	var flag=0;
	if(flag==0){
		flag++;
	  if($("#"+reportInfoid+" input").attr("reportInfo")=="0"){
		$("#"+reportInfoid+" input").attr("reportInfo","1");
	}
	  
	  
	  if(flag==0&&$("#"+reportInfoid+" input").attr("reportInfo")=="1"){
    	$("#"+reportInfoid+" input").attr("reportInfo","0");
	}  
	}
	
}
$(function() {

    function prevent_default(e) {
        e.preventDefault();
    }

    function disable_scroll() {
        $(document).on('touchmove', prevent_default);
    }


    function enable_scroll() {
    	//alert("++");
    	//$('#hjj').hide()
        $(document).unbind('touchmove', prevent_default)
    }

    var x;
    $("#kjj").attr("style","float: left; display:none; width: 20%; height: auto; background-color:#ff3a31; color: #fff; text-align: center;")
    var y;
    $('.fb_Comment')
        .on('touchstart', function(e) {
        	//alert("还未触发滑动动作  ");
        
        	  $(this).next().attr("style","float: left; display:none; width: 20%; height: auto; background-color:#ff3a31; color: #fff; text-align: center;")
          y = $(this).height();
          console.log("y----"+y)
            console.log("1----"+e.originalEvent.pageX)
            /* 
            $('.fb_Comment.open').css('left', '0px').removeClass('open') // close em all
            $(e.currentTarget).addClass('open')*/
            x = e.originalEvent.targetTouches[0].pageX // anchor point
          
            console.log("x----"+x)
        }).on('touchmove', function(e) {
    	// e.preventDefault();
        	console.log("触发滑动动作了 ")
            var change = e.originalEvent.targetTouches[0].pageX - x
            if(change<0){
            	$(this).next().attr("style","float: left; display:none; width: 20%; height: auto; background-color:#ff3a31; color: #fff; text-align: center;")
           }
            console.log("change1----"+change)
               //左移动：100，右边移动0
            change = Math.min(Math.max(-100, change), 0) // restrict to -100px left, 0px right
            e.currentTarget.style.marginLeft = change + 'px'
            if (change < -10) disable_scroll()  // disable scroll once we hit 10px horizontal slide
            console.log("进来了 ----")
        }).on('touchend', function(e) {
        	 console.log("进入了----")
        		
         /* 	if($(this+"input").attr("reportInfo")=="0"){
         		this.getElementsByTagName("input").reportInfo=="1";
         		// $(this)"input").attr("reportInfo","1");
         		$(this+"input").uCheck('check');
         	}else{
         		this.getElementsByTagName("input").reportInfo=="0";
             	//$(this+"input").attr("reportInfo","0");
             	$(this+"input").uCheck('uncheck');
         	} */
             var marginleft = parseInt(e.currentTarget.style.marginLeft)
              console.log("change11----++ "+marginleft)
              if(marginleft=='0'){
            	  $(this).next().attr("style","float: left; display:none; width: 20%; height: auto; background-color:#ff3a31; color: #fff; text-align: center;")
             }
            var new_left;
            if (marginleft<-35) {
            	console.log("left < -35----")
                new_left = '-100px'
            } else if (marginleft > 35) {
            	//往右边移动 
            	console.log("left > 35----")
                new_left = '0px'
                	
                      
            } else {
            	console.log("left < -__----")
                new_left = '0px'
            }
            console.log("change221----++ "+new_left)
            console.log("change111----++ "+e.currentTarget.style.marginLeft)
            /* if(new_left!='0px'){ */
            	 e.currentTarget.style.marginLeft = new_left 
            /* } */
            
            if(new_left!='0px'){ 
                
                //$("#kjj").attr("style","float: left;  width: 20%; height: auto; background-color: red; color: #fff; text-align: center;")
         // anchor point
       y=y+10
       console.log("yyyyyyy----++ "+y)
       $(this).next().attr("style","float: left;  width: 24%; height:"+y+"px;padding-top: "+y/40+"reM; background-color:#fe3a2f; color: #fff; text-align: center;")
       
                
            }
            e.currentTarget.style.marginLeft = new_left 
        /*   //  $(e.currentTarget).animate({left: new_left}, 200) */
           /* $('.fb_Comment').animate({marginleft:new_left},"fast"); */
            //$('#hjj').animate({left:'-19em'},"fast");
            // $('#hjj').hide(2
            enable_scroll() 
            
        });
            
       // $('.kjj').confirmer({msg:'确认删除吗?'}); 

    $('.kjj').on('touchend', function(e) {
        e.preventDefault()
        console.log("----")
        if (confirm("确认不再显示此案件吗？")) {  
        	  $(this).parent().html("")
              console.log("----11333"+$(this).attr("gjj"))
              $("#deleteId").val($("#deleteId").val()+","+$(this).attr("gjj"));
              //alert($("#deleteId").val());
              //console.log("----1133"+$(this).next().html())
                
        }  
        else {  

        }  
        
      
        //$(this).parent().next().attr("style"," ")
        //$(this).html("")
       /*  $('#hjj').slideUp('fast', function() { 
            $('#hjj').remove()
         })  */
    });



});
</script>

</html>
<!--http://pnc.co.il/dev/iscroll-5-pull-to-refresh-and-infinite-demo.html-->
