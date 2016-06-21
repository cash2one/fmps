<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet"
	href="${webRoot}/plug-in/carHome/css/cleaning_car.css" /> -->
<style>
 .recommend_business{ float:left; width:100%; padding:0 10px; margin-bottom:6px; padding-bottom: 5px; background-color: #fff;}
 .business_img{ float:left; width:25%; padding-top:9px;}
 .business_img img{ width:75px; height:61px; }
 .business_text{ float:left; width:70%; margin-left:3%; padding-top: 6px;}
 @media screen and (min-width:360px){ .business_text{ float:left; width:74%; margin-left:0%;}}
 @media screen and (min-width:375px){ .business_text{ float:left; width:75%; margin-left:-2%;}}
 @media screen and (min-width:414px){ .business_text{ float:left; width:76%; margin-left:-3%;}}
 .business_text .name{ font-size:14px; color:#333; float:left; width:78%; padding-top: 2px; padding-bottom:1px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap; }
 .business_text .km{ float:left; width:22%; text-align:right; padding-top:3px; }
 .business_text .add{ color:#666; font-size:12px; clear:both; padding-top:8px; border-bottom:1px solid #e8e8e8; padding-bottom:5px;}
 .business_text .ticket_name{ font-size:12px; color:#666; float:left; width:65%; margin-top:5px;}
 .business_text .receive{ float:left; width:35%; margin-top:5px; font-size:10px; }
 .business_text .receive .border{  border:1px dotted #ff4a90; border-radius: 5px; text-align:center; height:20px; color:#ff4a90;}
 .business_text .ticket_name_1{ font-size:12px; color:#666; float:left; width:65%; margin-top:5px;}
 .business_text .receive_1{ float:left; width:35%; margin-top:10px; font-size:10px; }
 .business_text .receive_1 .border{  border:1px solid #85ce4e; border-radius: 5px; text-align:center; height:20px; color:#85ce4e;}
 .business_text .receive_2{ float:left; width:10%; margin-top:5px; font-size:12px; }
 .business_text .receive_2 .border_1{  border-radius:3px; text-align:center; width:20px; height:20px; color:#fff; background-color:#fa952f; margin-left:5px;}
 .project_1{ padding-top:10px; height:25px; font-size:11px;}
 .project_1 .border_1{ border-radius:3px; text-align:center; width:21px; height:17px; color:#fff; background-color:#04d4be; padding:1px 5px 1px 5px; font-size:11px;}
 .project_1 .border_2{ border-radius:3px; text-align:center; width:25px; height:25px; color:#cc0000; padding:2px 3px 2px 3px; border:1px dotted #cc0000;}
 .project_1 .border_3{ border-radius:3px; text-align:center; width:21px; height:17px; color:#fff; background-color:#ff6666; padding:1px 5px 1px 5px; font-size:11px;}
 .project_1 .border_4{ border-radius:3px; text-align:center; width:21px; height:17px; color:#fff; background-color:#5194ef; padding:1px 5px 1px 5px; font-size:11px;}
 .recommend_business .time{padding-top:12px; font-size: 11px;}
  @media screen and (min-width:360px){ .recommend_business .time{ padding-top:19px;}}
  @media screen and (min-width:384px){ .recommend_business .time{ padding-top:20px;}}
  @media screen and (min-width:414px){ .recommend_business .time{ padding-top:21px;}}
 .recommend_business .time .time_text{padding:1px 2px 1px 2px; background:#ff8e3f; color:#fff; border-radius:3px;}
</style>

  <div  id="repairList"> </div>  

<script> 
   //获取商户列表  type;  1、现金券, 2、抵用券,4、会员洗车券, 5、超值洗车券
   function  getRepairList (repairList){
	   var divhtml = '';
	   $("#repairList").empty(); //清空列表
	   $.each(repairList,function(id, item) {
			var giftListDiv = "";
			var remainQuantity = 0;
			var starttime="";
			var endtime="";
			var timeDiv="";	
			if(item.giftSetList){
			for (var i = 0; i < item.giftSetList.length; i++) {
				remainQuantity = item.giftSetList[i].remainQuantity;
				starttime=item.giftSetList[i].starttime;
				endtime=item.giftSetList[i].endtime;
				giftListDiv += '<div class="project_1">';				
				if (item.giftSetList[i].type == '5') {
					giftListDiv += "<div style=\"float:left; width:92%;\"><span class=\"border_1\">超</span>&nbsp;<span style=\"text-overflow:ellipsis; overflow:hidden; white-space:nowrap;\">"
						+ item.giftSetList[i].name
						+ "</span>&nbsp;<span style=\"float:right; padding-right:5px;\">剩"
						+ remainQuantity
						+ "份</span></div>";
					var starttimes=starttime.split(":");
					var endtimes=endtime.split(":");
					timeDiv+=" <div class=\"time\"><span class=\"time_text\">";
					timeDiv+=starttimes[0]+":"+starttimes[1]+"-"+endtimes[0]+":"+endtimes[1]+"</span></div>";
					if(beforeStarttime(starttime)){															
						giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#fff; border:1px solid #e8e8e8; color:#666;\">抢</span></div>";
					}else if(afterEndtime(endtime)){
						giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#fff; border:1px solid #e8e8e8; color:#666;\">抢</span></div>";
					}else{
						giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\"  onclick=\"goToGiftSetDetail('"+item.giftSetList[i].id+"')\">抢</span></div>";
					}
					
				} else {
					if (item.giftSetList[i].type == '4') {
						giftListDiv += " <div style=\"float:left; width:92%;\"><span class=\"border_3\">会</span>&nbsp;"
								+ item.giftSetList[i].name
								+ "</div><div style=\"float:left; width:8%;\"></div>";
					} else {
						giftListDiv += "<div style=\"float:left; width:92%;\"><span class=\"border_4\">券</span>&nbsp;<span style=\"text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:80%;\">"
							+ item.giftSetList[i].name
							+ "</span>&nbsp;<span style=\"float:right; padding-right:5px;\">已领"+item.giftSetList[i].receivedQuantity+"份</span></div>";
						//giftListDiv +=" <div style=\"float:left; width:8%;\"><span class=\"border_2\" style=\"background:#999;\">抢</span></div>";
					}
				}
				giftListDiv += "</div>";
			 }
	        }			
		divhtml += "<div class=\"recommend_business\" onclick=\"goRepairMain("+item.id+")\"> <div class=\"business_img\" onclick=\"goRepairMain("
				+ item.id
				+ ")\"><img src=\""+item.imgUrl+"\" />";
			divhtml+=timeDiv;		
			divhtml += "</div><div class=\"business_text\"><div onclick=\"goRepairMain("
				+ item.id
				+ ")\"><div class=\"name\">"
					+ item.name
					+ "</div><div class=\"km\">"
					+ item.distance
					+ "km</div><div class=\"receive_1\"><img src=\"../plug-in/repair/star-"+item.evaluation+".png\" /></div><div class=\"add\">"
					+ item.shortAddr
					+ "</div></div>";
			divhtml += giftListDiv
					+ "</div></div>";
			divhtml +="<div class=\"Double_activity_xian\">&nbsp;</div>"		
     });
	   $("#repairList").append(divhtml); 
   }
   
   var now =new Date();
   function beforeStarttime(starttime){
		var times=starttime.split(":");	
		if(times[0]>now.getHours()){
			return true;
		}else if(times[0]==now.getHours()&&times[1]>now.getMinutes()){
			return true;
		}else if(times[0]==now.getHours()&&times[1]==now.getMinutes()&&times[2]>now.getSeconds()){
				return true;
		}
		return false;
	}
	
	function afterEndtime(endtime){
		var times=endtime.split(":");
		if(times[0]<now.getHours()){
			return true;
		}else if(times[0]==now.getHours()&&times[1]<now.getMinutes()){
			return true;
		}else if(times[0]==now.getHours()&&times[1]==now.getMinutes()&&times[2]<now.getSeconds()){
				return true;
		}
		return false;
	}
   
</script>
