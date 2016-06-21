<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<head>
<meta charset="UTF-8">
<title>理赔资料上传</title>
<script charset="utf-8"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
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

.lipei_input {
	width: 90%;
	margin: 0 auto;
	border: 1px solid #f1f1f1;
	height: 42px;
	font-family: "微软雅黑";
	font-size: 14px;
}

.lipei_input_left {
	float: left;
	width: 30%;
	padding: 10px 0px 0px 16px;
}

.lipei_input_right {
	float: right;
	width: 68%;
	border-left: 1px solid #f1f1f1;
	height: 41px;
	padding: 10px 0px 0px 16px;
}

.choose_img {
	width: 90%;
	margin: 0 auto;
}

img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

.lipei_picture {
	width: 90%;
	margin: 0 auto;
}

.lipei_picture_1 {
	float: left;
	width: 25%;
	padding-top: 8px;
	padding-left: 5px;
	overflow: hidden;
	position: relative;
}

.lipei_picture_2 {
	float: left;
	width: 25%;
	padding-top: 8px;
	padding-left: 5px;
	overflow: hidden;
	position: relative;
}

.lipei_hr {
	width: 90%;
	margin: 0 auto;
	border-top: 1px solid #e8e8e8;
	font-family: "微软雅黑";
	font-size: 10px;
	color: red;
	padding-top: 10px;
}

.lipei_anniu {
	width: 90%;
	margin: 0 auto;
}

.lipei_anniu_1 {
	background-color: #8e9cdc;
	width: 45%;
	float: left;
	color: #FFFFFF;
	font-size: 14px;
	font-family: "微软雅黑";
	text-align: center;
	border-radius: 5px;
	height: 35px;
	line-height: 33px;
}

.lipei_anniu_2 {
	background-color: #8e9cdc;
	width: 45%;
	float: right;
	color: #FFFFFF;
	font-size: 14px;
	font-family: "微软雅黑";
	text-align: center;
	border-radius: 5px;
	height: 35px;
	line-height: 33px;
}

.icon-delete {
	position: absolute;
	right: 2px;
	top: 1px;
	width: 24px;
	height: 24px;
	display: none;
}
.claim_flow_top{ width:90%; margin:0 auto; }
.lipei_tips{ width:90%; margin:0 auto; font-size:13px; color:#1d74a3; clear:both; padding-top:20px;}
</style>
</head>

<body>
	<header data-am-widget="header" class="am-header am-header-default">
		<div class=" am-header-nav" style="padding-top: 15px;">
			<a href="#left-link"> <img
				src="../plug-in/totaiwan/img/lipei_icon.jpg" width="20" height="22"
				alt="#" />
			</a>
		</div>
		<h1 class="am-header-title" style="color: #171717;">理赔资料在线上传</h1>
	</header>
	<input type="hidden" id="openid" name="openid" value="${openid}" />
	<input type="hidden" id="uploadnum" name="uploadnum"
		value="${uploadnum}" />
	<div style="height:20px;">&nbsp;</div>
	<div class="claim_flow_top" onclick="showPro()"><img src="../plug-in/totaiwan/img/claim_flow_top.jpg" style="border:1px solid #e8e8e8;" /></div>
	<div style="height: 20px;">&nbsp;</div>
	<div class="lipei_input">
		<div class="lipei_input_left">姓 &nbsp;名</div>
		<div class="lipei_input_right">
			<input id="customername" name="customername" type="text"
				style="border: 0px;" />
		</div>
	</div>
	<div style="height: 20px;">&nbsp;</div>
	<div class="lipei_input">
		<div class="lipei_input_left">报案电话</div>
		<div class="lipei_input_right">
			<input id="phonenum" name="phonenum" type="text" style="border: 0px;" maxlength="30" />
		</div>

	</div>
	<div style="height: 30px;">

		<div id="msgtemp" class="lipei_hr" style="text-align: center"></div>

	</div>
	<div class="choose_img">
		<img src="../plug-in/totaiwan/img/lipei_choose.jpg" />
	</div>
	<div style="height: 12px;">&nbsp;</div>
	<div class="lipei_picture">
		<div class="lipei_picture_1" id="chooseImage">
			<img src="../plug-in/totaiwan/img/picture_2.jpg" width="63"
				height="63" />
		</div>
	</div>
	<div style="height: 20px; clear: both;">&nbsp;</div>
	<div class="lipei_hr">备注：图片上传后将无法更改，请确认后再上传</div>
	<div style="height: 20px;">&nbsp;</div>
	<div class="lipei_anniu">
		<div class="lipei_anniu_1" onclick="gotoImgHistory()">历史图片</div>
		<div class="lipei_anniu_2" id="uploadImage">一键批量上传</div>
	</div>
	<div id="imglist"></div>
	<div class="lipei_tips">
		温馨提示：<br />
		以下证件都是理赔依据的重要文件，务必上传:<br />
		<span style="color:#999; font-size:11px;">身份证复印件 / 出入境许可证复印件 / 大陆居民往来台湾通行证复印件 /  医师诊断书正本 / 医疗收据正本 / 其他证明文件 / 银行账号</span>
	</div>
	<div style="height:10px; clear:both;">&nbsp;</div>
	<script type="text/javascript">
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
    serverId: []
  };
var currentdate=new Date();
var currenttime=currentdate.getTime();
document.querySelector('#chooseImage').onclick = function () {
	$('.icon-delete').css({display:'none'});
    wx.chooseImage({
      success: function (res) {
        if(images.localId.length == 0)
        {
            images.localId = res.localIds;
            nNeedInstertCount = res.localIds.length;
        }else{
            nNeedInstertCount = 9 - images.localId.length;
            if(res.localIds.length > nNeedInstertCount)
            {
                alert("微信只支持单次批量上传9张！");
            }else{
                nNeedInstertCount = res.localIds.length;
            }
            for(var i = 0; i < nNeedInstertCount;i++)
            {
                images.localId.push(res.localIds[i]);
            }
        }
        InsertPreViewDiv();
      }
    });
};

function InsertPreViewDiv() {
	var nLength = images.localId.length -1;
	for(var i = 0; i < nNeedInstertCount; i++){
		var url = images.localId[nLength];
		var num=nLength;
        nLength--;
        var arrTemp=url.split("//"); //字符分割
        var strID = arrTemp[arrTemp.length-1];
        var divHtml="<div id=\""+strID+"\" class=\"lipei_picture_1\"><img src=\""+url+"\" style=\"width:63px;height:63px;\" /><i class=\"icon-delete\" onclick=\"removeImg('"+url+"',"+num+")\"></i></div>";
        $("#chooseImage").before(divHtml);

	}
}	

document.querySelector('#uploadImage').onclick = function () {
	$('.icon-delete').css({display:'none'});
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
        success: function (res) {
          images.serverId.push(res.serverId); 
          downloadImg(res.serverId,currenttime); 
          i++;
          if (i <length) {
        	  setTimeout(function(){        		  
                  upload()
                  
              },100);
          }else{
        	  setTimeout(function(){
        	  	location.href="${webRoot}/fo/TotaiwanController.do?uploadsuccess"; 
        	  },200);
          }                 
        },
        fail: function (res) {
          alert('上传图片失败，请检查网络或稍后再试');
        }
      }); 
    }
    upload();  
    
  };
  
function removeImg(url,i){
	(images.localId).splice(i, 1);
	var arrTemp=url.split("//"); //字符分割
    var strID = arrTemp[arrTemp.length-1];
	var mydiv= document.getElementById(strID);
	mydiv.parentNode.removeChild(mydiv);
}
 
function testdown(){
	$('.icon-delete').css({display:'none'});
	var url="asdfasdf//12345"
	var divHtml="<div  id=\"12345\" class=\"lipei_picture_1\"><img src=\"../plug-in/totaiwan/img/picture_1.jpg\" style=\"width:63px;height:63px;\" /><i class=\"icon-delete\" onclick=\"removeImg('"+url+"',"+1+")\"></i></div>";
	alert(divHtml);
    $("#chooseImage").before(divHtml);
}

function test(num){
	alert(num);
	var mydiv= document.getElementById(num);
	mydiv.parentNode.removeChild(mydiv);
}

function gotoImgHistory(){
	var openid=$("#openid").val();
	location.href="${webRoot}/fo/TotaiwanController.do?futaiuploadimghistory&openid="+openid;
} 

function downloadImg(serverId,currenttime){
	var customername=$("#customername").val();
	var phonenum=$("#phonenum").val();
	var openid=$("#openid").val();
	$.ajax({
		type: "POST",
		url : "${webRoot}/fo/TotaiwanController.do?downloadimg",
		data:{serverid:serverId,openid:openid,customername:customername,phonenum:phonenum,currenttime:currenttime},
		dataType: "json",
		success: function(data){
			if(data=="1"){
				
			}
		}
	});
}

$(".lipei_picture").hammer().on('press', function(e) {
	  console.log(e);
	  var display = $('.icon-delete').css("display");
	    if(display == 'none' || display == 'None' || display == 'NONE')
	    {
	        $('.icon-delete').css({background:"url(../plug-in/totaiwan/img/icon-delete.png) no-repeat"});
	        $('.icon-delete').css({display:'block'});
	    }else{
	        $('.icon-delete').css({display:'none'});
	    }
});

function showPro(){
	var openid=$("#openid").val();
	location.href="${webRoot}/fo/TotaiwanController.do?baoan&openid="+openid;
}
</script>
</body>
</html>
