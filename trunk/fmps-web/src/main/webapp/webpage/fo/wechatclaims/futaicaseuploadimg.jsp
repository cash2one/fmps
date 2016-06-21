<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
  <head>
	<meta charset="UTF-8">
	<meta name="format-detection" content="telephone=no"/>
	<title>理赔资料上传</title>
	<script charset="utf-8" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<style type="text/css">
	.am-header-default {
		background-color: #fff;
	}
	
	.am-header {
		position: relative;
		width: 100%;
		height: 49px;
		line-height: 49px;
		padding: 0 10px;
		border-bottom: 2px solid #0e90d2;
	}
	
	.am-checkbox {
		margin-top: 0px;
	}
	
	.am-header .am-header-nav img {
		height: 20px;
	}
	
	.am-header .am-header-title {
		margin: 0 1%;
	}
	
	.am-accordion-gapped .am-accordion-item.am-active {
		border-bottom: 0px solid #dedede;
	}
	
	.am-accordion-gapped .am-accordion-item {
		border: 0px solid #dedede;
		border-bottom: none;
		margin: .5rem 0;
	}
	
	.am-accordion-gapped .am-active .am-accordion-title {
		background-color: #fff;
		color: rgba(0, 0, 0, 0.8);
	}
	
	.am-accordion-content {
		margin-top: 0;
	    padding: 0.8rem 1rem 1.2rem;
	    font-size: 1.4rem;
	    border-bottom: none;
	    border-width: 0px 0px;
	    border-image: none;
	    border-color: #fff;
	    background-color: #FFFFFF;
	}
	.am-accordion-gapped .am-accordion-title{ color:#1d74a3; }
	.am-accordion-gapped .am-active .am-accordion-title{ color:#1d74a3; }
	.lipei_input{ width:90%; margin:0 auto; border:1px solid #f1f1f1; height:42px; font-family:"微软雅黑"; font-size:14px;}
	.lipei_input_left{ float:left; width:30%;  padding:10px 0px 0px 16px;}
	.lipei_input_right{ float:right; width:68%; border-left:1px solid #f1f1f1; height:41px; padding:10px 0px 0px 16px;}
	.choose_img{ width:90%; margin:0 auto;}
	
	img {
		box-sizing: border-box;
		max-width: 100%;
		height: auto;
		vertical-align: middle;
		border: 0px none;
	}
	
	.lipei_picture{ width:90%; margin:0 auto;}
	.lipei_picture_1{ float:left; width:25%; padding-top:8px; padding-left:5px;position: relative;}
	.lipei_hr{ width:90%; margin:0 auto; border-top:1px solid #e8e8e8; font-family:"微软雅黑"; font-size:10px; color:red; padding-top:10px;}
	.lipei_hr_2{ width:90%; margin:0 auto; font-family:"微软雅黑"; font-size:10px; color:#1d74a3; padding-top:10px;}
	.lipei_anniu{width:90%; margin:0 auto;}
	.lipei_anniu_1{ background-color:#f7f7f7; width:100%; color:#454545; font-size:14px; font-family:"微软雅黑"; text-align:center; border-radius: 5px; height:35px; line-height:33px; margin-top:10px; border:1px solid #e9e9e9;}
	.lipei_anniu_2{ background-color:#04be02; width:100%; color:#FFFFFF; font-size:14px; font-family:"微软雅黑"; text-align:center; border-radius: 5px; height:35px; line-height:33px;}
	.icon-delete {
		position: absolute;
		left: 45px;
		top: 1px;
		width: 24px;
		height: 24px;
		display: block;
		background: url(../plug-in/totaiwan/img/icon-delete_2.png) no-repeat;
	}
	.claim_flow_top{ width:90%; margin:0 auto; }
	.lipei_tips{ width:90%; margin:0 auto; font-size:13px; color:#1d74a3; clear:both;}
	.text_1{ padding-top:5px;}
	.evaluate_all{ padding:0 15px;}
	.evaluate_all_title{ color:#e6e6e8; font-size:12px; border-bottom:1px solid #e8e8e8; height:25px; font-family:"微软雅黑"; clear:both;}
	.evaluate_all_name{ width:100%;}
	.evaluate_all_name_text{ width:80%; float:left; font-family:"微软雅黑"; font-size:14px; color:#0f90d2; line-height:30px; padding-left:6px;}
	.evaluate_all_name_button{ width:20%; float:left;}
	.describe{ float:left; width:25%; font-size:14px;}
	.describe_2{ float:left; width:75%; font-size:14px;}
	 #bg_1{ display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:1001; -moz-opacity: 0.7; opacity:.70; filter: alpha(opacity=70);}
     #show_1{display: none; position: absolute; top:55%; left: 10%; width: 80%; height:auto; padding: 8px; border: 1px solid #e8e8e8; background-color:#fff; z-index:1002; overflow:scroll; border-radius: 5px;}
     
.weui_msg {
  padding-top: 36px;
  text-align: center;
  height: 350px;
}
.weui_msg .weui_icon_area {
  margin-bottom: 30px;
}
.weui_msg .weui_text_area {
  margin-bottom: 25px;
  padding: 0 20px;
}
.weui_msg .weui_msg_title {
  margin-bottom: 5px;
  font-weight: 400;
  font-size: 20px;
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
  background-color:#09BB07;
}
	</style>
  </head>
  
  <body>
  	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
		<div class="am-modal-dialog" style="border-top:5px solid #fff;background:#fff">
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
			<div class="am-modal-hd" style="height:60px;font-size:16px;color:#000">正在上传第 <span id="uploadIndex">0</span>/<span id="uploadTotal">0</span> 张...</div>
		</div>
	</div>
  	<input type="hidden" id="customername" name="customername" value="${reportinfo.reportorName}" />
  	<input type="hidden" id="insuredName" name="insuredName" value="${reportinfo.insuredName}" />
	<input type="hidden" id="phonenum" name="phonenum" value="${phonenum}" />
  	<input type="hidden" id="openid" name="openid" value="${openid}" />
	<input type="hidden" id="caseno" name="caseno" value="${reportinfo.registNo}" />
	<input type="hidden" id="uploadnum" name="uploadnum" value="${uploadnum}" />
	
  	<header data-am-widget="header" class="am-header am-header-default" >
	  <h1 class="am-header-title" style="color:#171717;">理赔资料上传</h1>
	</header>
	<section data-am-widget="accordion" class="am-accordion am-accordion-gapped" data-am-accordion='{  }'>
		<dl class="am-accordion-item">
			<dt class="am-accordion-title">报案号：${reportinfo.registNo}</dt>
	        <dd class="am-accordion-bd am-collapse">
	        	<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
	        	<div class="am-accordion-content">
	        		<div class="describe">报案时间</div>  
			      	<div class="describe_2">${reportinfo.reportDate} ${reportinfo.reportTime}</div>
			      	<div class="describe">保单号</div>  
			      	<div class="describe_2">${reportinfo.policyNo}</div>
			      	<div class="describe">保险期间</div>  
			      	<div class="describe_2"><fmt:parseDate value="${reportinfo.startDate}" var="start_date" pattern="yyyy-MM-dd"/><fmt:formatDate value="${start_date}" pattern="yyyy-MM-dd" /> 至 <fmt:parseDate value="${reportinfo.endDate}" var="end_date" pattern="yyyy-MM-dd"/><fmt:formatDate value="${end_date}" pattern="yyyy-MM-dd" /></div>
			      	<div class="describe">被保险人</div>
					<div class="describe_2">${reportinfo.insuredName}</div>
			      	<div class="describe">案件信息</div>  
			      	<div class="describe_2">${reportinfo.remark}</div>
	        	</div>
	        </dd>
		</dl>
	</section>
	<div style="height:8px; clear:both;">&nbsp;</div>

	<div class="lipei_tips">
		<div class="lipei_hr_2">温馨提示：<br />以下证件都是理赔依据的重要文件，务必上传:</div>
		<div style="height:8px; clear:both;">&nbsp;</div>
		<div class="choose_img">
			<img src="../plug-in/totaiwan/img/lipei_choose.jpg" />
		</div>
		<div style="height: 12px;">&nbsp;</div>
		<div class="lipei_picture" style="clear:both;">
			<div>● 身份证（最多2张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==1}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="shenfenzheng" imgtype="1">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 入台许可证（最多2张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==2}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="xukezheng" imgtype="2">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 大陆居民往来台湾通行证（最多2张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==3}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="tongxingzheng" imgtype="3">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 医师诊断书（最多30张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==4}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="zhenduanshu" imgtype="4">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 医疗收据正版（最多30张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==5}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="yiliaoshouju" imgtype="5">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 银行卡（最多2张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==6}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="width:63px;height:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="bankcard" imgtype="6">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div class="lipei_picture" style="clear:both">
			<div>● 其他证明文件（最多30张）</div>
			<c:forEach items="${imglist}" var="img">
			<c:if test="${img.imgtype==7}">
			<div class="lipei_picture_1">
				<img src="${webRoot}/fo/notCarClaimController.do?getStream&id=${img.id}&version=<%=java.lang.Math.random()%>" style="height:63px;width:63px;" />
			</div>
			</c:if>
			</c:forEach>
			<div class="lipei_picture_1 chooseClass" id="other" imgtype="7">
				<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63" height="63" />
			</div>
		</div>
		<div style="height: 20px; clear: both;">&nbsp;</div>
		
		<div id="msgtemp" class="lipei_hr" style="padding-bottom: 10px;border:none;text-align: center;"></div>
			
		<div class="lipei_hr">备注：图片上传后将无法更改，请确认后再上传</div>
		<div style="height: 20px;">&nbsp;</div>
		<div class="lipei_anniu">
			<div class="lipei_anniu_2" id="uploadImage">确认上传</div>
			<!--  
			<div class="lipei_anniu_1" onclick="gotoImgHistory()">历史图片</div>
			-->
		</div>
		<div id="bg_1" ></div>
       <div id="show_1">
       <div class="page">
        <div class="weui_msg">
        <div class="weui_icon_area"><img src="${webRoot}/plug-in/fo/images/icon_two.png" width="100" height="100"/></div>
        <div class="weui_text_area">
            <h2 class="weui_msg_title">操作成功</h2>
            <p class="weui_msg_desc" id="showSuessMessage" >    </p>
        </div>
        <div class="weui_opr_area">
            <p class="weui_btn_area">
                <a href="javascript:;"  onclick="closeMessage()" class="weui_btn ">确定</a>
            </p>
        </div>
       </div>
       </div>
       </div>
		<div style="clear:both;height:10px;">&nbsp;</div>
	</div>

	<script type="text/javascript">
	var caseno = '${reportinfo.registNo}';
	var shenfenzhengCount = '${map.shenfenzhengCount}'==''?0:parseInt('${map.shenfenzhengCount}');
	var xukezhengCount = '${map.xukezhengCount}'==''?0:parseInt('${map.xukezhengCount}');
	var tongxingzhengCount = '${map.tongxingzhengCount}'==''?0:parseInt('${map.tongxingzhengCount}');
	var zhenduanshuCount = '${map.zhenduanshuCount}'==''?0:parseInt('${map.zhenduanshuCount}');
	var yiliaoshoujuCount = '${map.yiliaoshoujuCount}'==''?0:parseInt('${map.yiliaoshoujuCount}');
	var bankcardCount = '${map.bankcardCount}'==''?0:parseInt('${map.bankcardCount}');
	var otherCount = '${map.otherCount}'==''?0:parseInt('${map.otherCount}');
	var falseCount = 0;
	
	$(function() {
		$("#toggleOtherInfo").click(function(){
			$("#otherInfo").toggle();
			if($("#otherInfo").is(":hidden")){
				$(this).text("﹀");
			}else{
				$(this).text("︿");
			}
		});
		
		$(".chooseClass").on("click",function(){
			var imgId = $(this).attr("id");
			var imgtype = $(this).attr("imgtype");//imgtype	照片类型,1:身份证,2:许可证,3:通行证,4:医疗诊断书,5:医疗收据正版,6:银行卡,7:其他证明文件
			commonChooseImage(imgId,imgtype);
		});
	});
	
	//...资料上传...
	wx.config(${JsonStr});
	wx.ready(function() {
	    // 1 判断当前版本是否支持指定 JS 接口，支持批量判断
	    wx.checkJsApi({
	        jsApiList: [
	            'checkJsApi',
	            'previewImage',
	            'chooseImage',
	            'closeWindow',
	            'uploadImage'
	        ],
	        success: function(res) {
	            //alert(res.errMsg);
	            var strResult = res.errMsg;
	            if (strResult .indexOf(':ok')<0)
	            {
	                alert('您当前的微信版本不支持，请确保您的微信为最新版本！');
	            }
	        }
	    });
	});
	wx.error(function (res) {	
		alert(res.errMsg);	
	});
	var nNeedInstertCount = 0 ;
	var images = {
	    localId: [],
	    serverId: [],
	    imgtype: []
	  };
	var currentdate=new Date();
	var currenttime=currentdate.getTime();
	var numLimit = {"shenfenzheng":2,"xukezheng":2,"tongxingzheng":2,"zhenduanshu":30,"yiliaoshouju":30,"bankcard":2,"other":30};
	var chooseTemp1 = 0,chooseTemp2 = 0,chooseTemp3 = 0,chooseTemp4 = 0,chooseTemp5 = 0,chooseTemp6 = 0,chooseTemp7 = 0;
	var map = new Array();//key-value:图片标示-图片类型
	
	function commonChooseImage(imgId,imgtype){
		$('.icon-delete').css({display:'block'});
	    wx.chooseImage({
	      success: function (res) {
	    	  //检验图片数量是否超标
	    	  if(!checkNumValild(imgtype,res.localIds.length)){
	    		  return;
	    	  }
	        if(images.localId.length == 0)
	        {
	            images.localId = res.localIds;
	            nNeedInstertCount = res.localIds.length;
	            for(var i=0; i < res.localIds.length;i++){
	            	map[res.localIds[i]] = imgtype;
	            }
	        }else{
				//每次选择最多9张
				if(res.localIds.length > 9)
	            {
	                alert("微信只支持单次批量上传9张！");
	            }else{
					nNeedInstertCount += res.localIds.length;
	            }
	            for(var i = 0; i < res.localIds.length;i++)
	            {
	                images.localId.push(res.localIds[i]);
	                map[res.localIds[i]] = imgtype;
	            }
	        }
	        commonInsertPreViewDiv(imgId,res.localIds.length);
	      }
	    });
	}
	
	function commonInsertPreViewDiv(imgId,thisNum) {
		var nLength = images.localId.length -1;
		for(var i = 0; i < thisNum; i++){
			var url = images.localId[nLength];
			var num=nLength;
	        nLength--;
	        var arrTemp=url.split("//"); //字符分割
	        var strID = arrTemp[arrTemp.length-1];
	        var divHtml="<div id=\""+strID+"\" class=\"lipei_picture_1\"><img src=\""+url+"\" style=\"width:63px;height:63px;\" /><i class=\"icon-delete\" onclick=\"removeImg('"+url+"',"+num+")\"></i></div>";
	        $("#"+imgId).before(divHtml);
		}
	};

	document.querySelector('#uploadImage').onclick = function () {		 
		if(confirm("图片一经上传将无法更改，确认上传吗？")){
			$('.icon-delete').css({display:'block'});
			var customername=$("#customername").val();
			var phonenum=$("#phonenum").val();
			var uploadnum=$("#uploadnum").val();
			var re=/^[0-9]*$/;
			if(customername==""||customername==null){
		    	$("#msgtemp").text('**姓名不能为空');
		        return;
		    }
		    if(phonenum==""||phonenum==null){
		    	$("#msgtemp").text('**报案电话不能为空');
		        return;
		    }
		    if(phonenum.length<5){
		    	$("#msgtemp").text('**报案电话要大于5位');
		        return;
		    }
			if(!re.test(phonenum)){
				$("#msgtemp").text('**报案电话只能是数字');
		        return;
		    }
		    if (images.localId.length == 0) {
		      $("#msgtemp").text('**请先添加图片');
		      return;
		    }  
		    
		    var i = 0, length = images.localId.length;
		    if(length>uploadnum){
		    	$("#msgtemp").text('**您最多只能再上传'+uploadnum+'张图片');
		        return;
		    }
		    images.serverId = [];
		    function upload() {
		      wx.uploadImage({
		        localId: images.localId[i],
		        isShowProgressTips: 0,
		        success: function (res) {
		          images.serverId.push(res.serverId); 
// 		          alert("images.localId[i]:"+images.localId[i]+",res.serverId:"+res.serverId+",map[images.localId[i]]:"+map[images.localId[i]])
		          //正在上传第 2/10 张
		          var currentIndex = i+1;
		          $("#uploadIndex").text(currentIndex);
		          $("#uploadTotal").text(length);
		          openmodel();
		          
		          downloadImg(res.serverId,currenttime,map[images.localId[i]]); 
		          i++;
		          if (i <length) {
		        	  setTimeout(function(){        		  
		                  upload()
		                  
		              },100);
		          }else{
		        	  closemodel();
		        	  setTimeout(function(){	
		        		  var uploadTotal=length-falseCount;
		        		  showMessage(uploadTotal); //全部上传完成后，弹出提示框 。		        		  
		        	  },200);
		          }                 
		        },
		        fail: function (res) {
		        	closemodel();
		          alert('上传图片失败，请检查网络或稍后再试');
		        }
		      }); 
		    }
		    upload();
		}
	};
	  
	function removeImg(url,i){
// 		alert("url:"+url+",i:"+i);
		updateChooseTemp(url);
// 		alert("删除前长度images.localId:"+images.localId.length);
// 		(images.localId).splice(i, 1);
		(images.localId).remove(url);
// 		alert("删除后长度images.localId:"+images.localId.length);
		var arrTemp=url.split("//"); //字符分割
	    var strID = arrTemp[arrTemp.length-1];
		var mydiv= document.getElementById(strID);
		mydiv.parentNode.removeChild(mydiv);
	};

	function downloadImg(serverId,currenttime,imgtype){
		var customername=$("#customername").val();
		var insuredName=$("#insuredName").val();
		var phonenum=$("#phonenum").val();
		var openid=$("#openid").val();
		$.ajax({
			type: "POST",
			url : "${webRoot}/fo/notCarClaimController.do?downloadimg",
			data:{serverid:serverId,openid:openid,customername:customername,insuredName:insuredName,phonenum:phonenum,currenttime:currenttime,caseno:caseno,imgtype:imgtype},
			dataType: "json",
			success: function(data){
				if(data=="1"){
					
				}else{
					falseCount++;
				}
			}
		});
	};
	
// 	function sendClaimImg(currenttime){
// 		var insuredName = $("#insuredName").val();
// 		var phonenum = $("#phonenum").val();
// 		var openid = $("#openid").val();
// 		var registNo = $("#caseno").val();
// 		$.ajax({
// 			type: "POST",
// 			url : "${webRoot}/fo/notCarClaimController.do?sendClaimImg",
// 			data:{insuredName:insuredName,phonenum:phonenum,openid:openid,registNo:registNo,currenttime:currenttime},
// 			dataType: "json",
// 			success: function(data){
// 				if(data=="1"){
// 					location.href="${webRoot}/fo/notCarClaimController.do?uploadsuccess";
// 				}else{
// 					alert("上传资料有问题，请重新上传");
// 				}
// 			}
// 		});
// 	};

// 	$(".lipei_picture").hammer().on('press', function(e) {
// 		  console.log(e);
// 		  var display = $('.icon-delete').css("display");
// 		    if(display == 'none' || display == 'None' || display == 'NONE')
// 		    {
// 		        $('.icon-delete').css({background:"url(../plug-in/totaiwan/img/icon-delete.png) no-repeat"});
// 		        $('.icon-delete').css({display:'block'});
// 		    }else{
// 		        $('.icon-delete').css({display:'none'});
// 		    }
// 	});
	
	function gotoImgHistory(){
		var openid=$("#openid").val();
		location.href="${webRoot}/fo/notCarClaimController.do?futaiuploadimghistory&openid="+openid+"&caseno="+caseno;
	};
	
	//数量校验
	function checkNumValild(imgtype,currentChooseNum){
		//imgtype->照片类型,1:身份证,2:许可证,3:通行证,4:医疗诊断书,5:医疗收据正版,6:银行卡,7:其他证明文件
		if(imgtype=="1"){
			chooseTemp1 += currentChooseNum;
			if(shenfenzhengCount + chooseTemp1 > numLimit["shenfenzheng"]){
				chooseTemp1 -= currentChooseNum;
				alert("身份证最多不超过2张，如需上传，请在\"其他证明文件\"上传");
				return false;
			}
		}else if(imgtype=="2"){
			chooseTemp2 += currentChooseNum;
			if(xukezhengCount + chooseTemp2 > numLimit["xukezheng"]){
				chooseTemp2 -= currentChooseNum;
				alert("许可证最多不超过2张，如需上传，请在\"其他证明文件\"上传");
				return false;
			}
		}else if(imgtype=="3"){
			chooseTemp3 += currentChooseNum;
			if(tongxingzhengCount + chooseTemp3 > numLimit["tongxingzheng"]){
				chooseTemp3 -= currentChooseNum;
				alert("通行证最多不超过2张，如需上传，请在\"其他证明文件\"上传");
				return false;
			}
		}else if(imgtype=="4"){
			chooseTemp4 += currentChooseNum;
			if(zhenduanshuCount + chooseTemp4 > numLimit["zhenduanshu"]){
				chooseTemp4 -= currentChooseNum;
				alert("医疗诊断书最多不超过30张");
				return false;
			}
		}else if(imgtype=="5"){
			chooseTemp5 += currentChooseNum;
			if(yiliaoshoujuCount + chooseTemp5 > numLimit["yiliaoshouju"]){
				chooseTemp5 -= currentChooseNum;
				alert("医疗收据正版最多不超过30张");
				return false;
			}
		}else if(imgtype=="6"){
			chooseTemp6 += currentChooseNum;
			if(bankcardCount + chooseTemp6 > numLimit["bankcard"]){
				chooseTemp6 -= currentChooseNum;
				alert("银行卡最多不超过2张，如需上传，请在\"其他证明文件\"上传");
				return false;
			}
		}else if(imgtype=="7"){
			chooseTemp7 += currentChooseNum;
			if(otherCount + chooseTemp7 > numLimit["other"]){
				chooseTemp7 -= currentChooseNum;
				alert("其他证明文件最多不超过30张");
				return false;
			}
		}
		return true;
	}
	
	//更新页面内某图片类型已选择图片数量
	function updateChooseTemp(url){
		var imgtype = map[url];
		if(imgtype=="1"){
			chooseTemp1--;
		}else if(imgtype=="2"){
			chooseTemp2--;
		}else if(imgtype=="3"){
			chooseTemp3--;
		}else if(imgtype=="4"){
			chooseTemp4--;
		}else if(imgtype=="5"){
			chooseTemp5--;
		}else if(imgtype=="6"){
			chooseTemp6--;
		}else if(imgtype=="7"){
			chooseTemp7--;
		}
	}
	
	function openmodel(){
		var $modal = $('#my-modal-loading');
		$modal.modal('open');
	}
	function closemodel(){
		var $modal = $('#my-modal-loading');
		$modal.modal('close');
	}
	
	Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
    

    function showMessage( uploadTotal ){ 
    	
   	var windowWidth = $(document).width();       
   	var windowHeight =$(document).height();
    $("#showSuessMessage").text("已经成功上传"+uploadTotal+"张照片");
   	$("#bg_1").width(windowWidth)   
       .height(windowHeight) .css("display","block") ;
   	 $("#show_1").css("display","block");
     }
    
    function closeMessage(){       	 
       	 $("#bg_1").css("display","none") ;
       	 $("#show_1").css("display","none");
       	 var registNo='${reportinfo.registNo}';
         var phonenum=$("#phonenum").val();
       	 location.href="${webRoot}/fo/notCarClaimController.do?toUploadimg&falseCount="+falseCount+"&registNo_refresh="+registNo+"&phonenum="+phonenum+"&openid='${openid}'&version="+Math.random();
        }
    
	</script>
  </body>
</html>