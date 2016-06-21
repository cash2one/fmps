<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width,height=device-height,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>


<title>幸运大转盘抽奖</title>
<link href="${webRoot}/plug-in/weixin/zp/turnplate.css" rel="stylesheet" type="text/css">
<link href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${webRoot}/plug-in/weixin/zp/js/awardRotate.js"></script>

</head>

<body class="" >
    <img src="${webRoot}/plug-in/weixin/zp/images/3.png" id="sorry-img" style="display:none;" />
    <img src="${webRoot}/plug-in/weixin/zp/images/2.png" id="money-img" style="display:none;" />
    <img src="${webRoot}/plug-in/weixin/zp/images/1.png" id="coin-img" style="display:none;" />
    
     <div class="turnplate_top_bg">
		  <div class="img"></div>
	 </div>
	<div class="banner" >
		<div class="turnplate" style="">
			<canvas class="item" id="wheelcanvas" width="422px" height="422px"></canvas>
			<img class="pointer" src="${webRoot}/plug-in/weixin/zp/images/turnplate-pointer.png"/>
		</div>
	</div>
	<div class="drow-count">您当前保额：<span>${amount}</span> 元，已抽奖：<span class="drawRecordCount">${drawRecordCount} </span> 次，剩余次数：<span class="drawCount">${drowCount}</span> 次</div>
 <div id="outercont">
	<div class="content">
		<!-- <div class="boxcontent boxyellow" id="result" style="display:none">
			<div class="box">
				<div class="title-orange"><span>恭喜你中奖了</span></div>
				<div class="Detail">
			            <a class="ui-link" href="#" id="opendialog" style="display: none;" data-rel="dialog"></a>
						<p>你中了：<span class="red" id="prizetype">一等奖</span></p>
						<p>你的兑奖SN码：<span class="red" id="sncode"></span></p>
						<p class="red">本次兑奖码已经关联你的微信号，你可向公众号发送 兑奖 进行查询!</p>
			               
						<p>
							<input name="" class="px" id="tel" type="text" placeholder="输入您的手机号码">
						</p>
						<p>
							<input class="pxbtn" id="save-btn" name="提 交" type="button" value="提 交">
						</p>
				</div>
			</div>
		</div> -->
		
		<section class="win-prize">
		  <div class="reward-title"><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_5.png" /></div>
		  <div class="award-description Detail">
		  
		  </div>
		 </section>
		 
		 <section class="award-carousel">
		  <div class="reward-title"><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_tp7.png" /></div>
		  <div class="award-description">
		  	<p>1. 特等奖5名，报销来回路费，最高1000元</p>
		  	<p>2. 一等奖20元红包/50个</p>
		  	<p>3. 二等奖10元红包/200个</p>
		  	<p>4. 三等奖5元红包/400个</p>
		  </div>
		 </section>
		
		<section class="award-carousel">
		  <div class="reward-title"><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_tp6.png" /></div>
		  <div class="award-description">
		  	<p>1.  凡抽中特等奖的用户，可凭票根报销来回路费（限本人机票，火车票）。</p>
			<p>2.  路费上限1000元，低于1000元按票根金额实报，高于1000元按1000元报销。</p>
			<p>3.  用户将票根寄于我司，核对无误，根据用户提供的账号进行转账返还。仅接受2月1号~2月15号的票根报销。</p>
			<p>4.  票根报销时间限定为：2月15~22号，一星期为限。逾期作废。</p>
			<p>5.  中奖用户将票根寄往【福建省厦门市思明区湖滨北路101号商业银行大厦4楼4A富邦财险】电子商务部。联系电话0592-5353666-51143。</p> 
		  </div>
		 </section>
		<!-- 弹出框内容 -->
		 <div id="popBackground" onclick="hideMessage();"></div>
		 <div id="showCard">谢谢您的参与，再接再厉哦
		 	<input class="btnGetCard" type="button" value="确定" onclick="hideMessage();"/>
		 </div>
</div>

<script type="text/javascript">
var turnplate={
		restaraunts:[],				//大转盘奖品名称
		colors:[],					//大转盘奖品区块对应背景颜色
		outsideRadius:192,			//大转盘外圆的半径
		textRadius:155,				//大转盘奖品位置距离圆心的距离
		insideRadius:75,			//大转盘内圆的半径
		startAngle:0,				//开始角度
		
		bRotate:false				//false:停止;ture:旋转
};

$(document).ready(function(){
	var hdId = "${hdId}";
	var openid = "${openid}";
	var count = ${drowCount};
	var doneCount = ${drawRecordCount};//已抽奖次数
	var awardMap = [1,3,5,8,2,4,6,7,9,10];//特一二三等奖的映射
	var prize = "${prize}";
	
	//动态添加大转盘的奖品与奖品区域背景颜色
	turnplate.restaraunts = ["特等奖", "谢谢参与", "一等奖", "谢谢参与","二等奖", "谢谢参与",  "谢谢参与", "三等奖", "谢谢参与", "谢谢参与"];
	turnplate.colors = ["#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF","#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF","#FFF4D6", "#FFFFFF"];

	showPrize(prize,turnplate.restaraunts[awardMap[prize]-1]);
	
	var rotateTimeOut = function (){
		$('#wheelcanvas').rotate({
			angle:0,
			animateTo:2160,
			duration:8000,
			callback:function (){
				alert('网络超时，请检查您的网络设置！');
			}
		});
	};

	//旋转转盘 item:奖品位置; txt：提示语;
	var rotateFn = function (item, txt, prize){
		var angles = item * (360 / turnplate.restaraunts.length) - (360 / (turnplate.restaraunts.length*2));
		if(angles<270){
			angles = 270 - angles; 
		}else{
			angles = 360 - angles + 270;
		}
		$('#wheelcanvas').stopRotate();
		$('#wheelcanvas').rotate({
			angle:0,
			animateTo:angles+1800,
			duration:8000,
			callback:function (){
				if(prize<=3){
					alert(txt);
				}
				showPrize(prize,turnplate.restaraunts[item-1]);
				turnplate.bRotate = !turnplate.bRotate;
			}
		});
	};
	
	//开始抽奖
	$('.pointer').click(function (){
		
		if(turnplate.bRotate)return;
		
		if(count<=0){
			alert("您的抽奖次数已用完，赶紧召唤小伙伴帮忙抢保额，增加抽奖次数。");
			return
		}
		
		//判断每次抽奖之前，是否有资格抽，与数据库交互
		$.ajax({
			url:"zpController.do?getTurnplatePrize",
			dataType:"json",
			data:{"hdId":hdId,"openid":openid,"version":new Date()},
			success:function(data){
				if(data.attributes.error=="exhaust"){
					alert("您的抽奖次数已用完，赶紧召唤小伙伴帮忙抢保额，增加抽奖次数。");
					count=0;
				}else if(data.attributes.error=="expired"){
					alert("活动已过期。");
/* 					count = 0;
					$('.drawCount').text(count);
 */				}
				if(data.success){
					//抽奖抽中的号码 1、2、3对应一二三等奖
					var prize=data.attributes.prizetype;
					turnplate.bRotate = !turnplate.bRotate;
					//获取随机数(奖品个数范围内)
					var item = awardMap[prize];
					//奖品数量等于10,指针落在对应奖品区域的中心角度[252, 216, 180, 144, 108, 72, 36, 360, 324, 288]
					rotateFn(item, turnplate.restaraunts[item-1],prize);
					count--;
					doneCount++;
					$('.drawCount').text(count);
					$('.drawRecordCount').text(doneCount);
				}else{
					prize=null;
				}
			},
			error:function(){
				prize=null;
				alert("出错了，请重新抽奖");
			},
			timeout:40000
		})
	});
	
});

//页面所有元素加载完毕后执行drawRouletteWheel()方法对转盘进行渲染
window.onload=function(){
	drawRouletteWheel();
};

function drawRouletteWheel() {    
  var canvas = document.getElementById("wheelcanvas");    
  if (canvas.getContext) {
	  //根据奖品个数计算圆周角度
	  var arc = Math.PI / (turnplate.restaraunts.length/2);
	  var ctx = canvas.getContext("2d");
	  //在给定矩形内清空一个矩形
	  ctx.clearRect(0,0,422,422);
	  //strokeStyle 属性设置或返回用于笔触的颜色、渐变或模式  
	  ctx.strokeStyle = "#FFBE04";
	  //font 属性设置或返回画布上文本内容的当前字体属性
	  ctx.font = '16px Microsoft YaHei';      
	  for(var i = 0; i < turnplate.restaraunts.length; i++) {       
		  var angle = turnplate.startAngle + i * arc;
		  ctx.fillStyle = turnplate.colors[i];
		  ctx.beginPath();
		  //arc(x,y,r,起始角,结束角,绘制方向) 方法创建弧/曲线（用于创建圆或部分圆）    
		  ctx.arc(211, 211, turnplate.outsideRadius, angle, angle + arc, false);    
		  ctx.arc(211, 211, turnplate.insideRadius, angle + arc, angle, true);
		  ctx.stroke();  
		  ctx.fill();
		  //锁画布(为了保存之前的画布状态)
		  ctx.save();   
		  
		  //----绘制奖品开始----
		  ctx.fillStyle = "#E5302F";
		  var text = turnplate.restaraunts[i];
		  var line_height = 17;
		  //translate方法重新映射画布上的 (0,0) 位置
		  ctx.translate(211 + Math.cos(angle + arc / 2) * turnplate.textRadius, 211 + Math.sin(angle + arc / 2) * turnplate.textRadius);
		  
		  //rotate方法旋转当前的绘图
		  ctx.rotate(angle + arc / 2 + Math.PI / 2);
		  
		  /** 下面代码根据奖品类型、奖品名称长度渲染不同效果，如字体、颜色、图片效果。(具体根据实际情况改变) **/
		  if(text.indexOf("M")>0){//流量包
			  var texts = text.split("M");
			  for(var j = 0; j<texts.length; j++){
				  ctx.font = j == 0?'bold 20px Microsoft YaHei':'16px Microsoft YaHei';
				  if(j == 0){
					  ctx.fillText(texts[j]+"M", -ctx.measureText(texts[j]+"M").width / 2, j * line_height);
				  }else{
					  ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
				  }
			  }
		  }else if(text.indexOf("M") == -1 && text.length>6){//奖品名称长度超过一定范围 
			  text = text.substring(0,6)+"||"+text.substring(6);
			  var texts = text.split("||");
			  for(var j = 0; j<texts.length; j++){
				  ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
			  }
		  }else{
			  //在画布上绘制填色的文本。文本的默认颜色是黑色
			  //measureText()方法返回包含一个对象，该对象包含以像素计的指定字体宽度
			  ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
		  }
		  
		  //添加对应图标
		  if(text.indexOf("特等奖")>0){
			  var img= document.getElementById("coin-img");
			  img.onload=function(){  
				  ctx.drawImage(img,-15,10);      
			  }; 
			  ctx.drawImage(img,-15,10);  
		  }else if(text.indexOf("谢谢参与")>=0){
			  var img= document.getElementById("sorry-img");
			  img.onload=function(){  
				  ctx.drawImage(img,-15,10);      
			  };  
			  ctx.drawImage(img,-15,10);  
		  }else if(text.indexOf("等奖")>=0){
			  var img= document.getElementById("money-img");
			  img.onload=function(){  
				  ctx.drawImage(img,-15,10);      
			  };  
			  ctx.drawImage(img,-15,10);  
		  }
		  //把当前画布返回（调整）到上一个save()状态之前 
		  ctx.restore();
		  //----绘制奖品结束----
	  }     
  } 
}

//显示中奖情况(1.刚进页面时显示（0,1,2,3）、隐藏（null）2.抽奖时抽中了显示（0,1,2,3），没抽中不隐藏)
function showPrize(prize,text){
	/* prize: "",0,1,2... */
	if((prize === "0" || prize>0) && prize<=3){//1、刚进页面，中奖了  2、抽奖中奖了 
		$('.win-prize').show();
		var showMessage = '恭喜您获得了：';
		showMessage += '<span style="color:#f9bb3c;">'+text+' </span>、';
		showMessage += '<span class="map"  onclick="goGreetingCard()" >猴年贺卡</span>';
		$('.win-prize').find('.Detail').html(showMessage);
	}else if(prize!==0 && !prize && ${drawRecordCount} == 0){ //刚进页面，没抽过奖
		$('.win-prize').hide();
	}else if(prize!==0 && !prize && ${drawRecordCount} > 0){ //刚进页面，抽过奖，没中奖
		var showMessage = '恭喜您获得了：';
		showMessage += '<span class="map"  onclick="goGreetingCard()" >猴年贺卡</span>';
		$('.win-prize').find('.Detail').html(showMessage);
	}else{	
		//显示贺卡信息，已显示了就不重复显示
		if($('.win-prize').find('.Detail span').length==0){
			var showMessage = '恭喜您获得了：';
			showMessage += '<span class="map"  onclick="goGreetingCard()" >猴年贺卡</span>';
			$('.win-prize').find('.Detail').html(showMessage);
			$('.win-prize').show();
		}
		popMessage();
	} 
}

/* 弹出、隐藏提示信息 */
function popMessage(){ 
	var windowWidth = document.body.clientWidth;       
	var windowHeight = document.body.clientHeight;
	$("#popBackground").width(windowWidth)   
    .height(windowHeight) .css("display","block") ;
	 $("#showCard").css("display","block");
}
 function hideMessage() {
	 $("#popBackground").css("display","none");
	 $("#showCard").css("display","none");
 }
 //跳转贺卡页面
 function goGreetingCard(){
	location.href="http://viewer.maka.im/k/4WYKCTBJ";
 }
</script>

</body></html>