<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>加油宝活动</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <script src="${webRoot}/plug-in/fo/js/gasolinegift/gasolinegift.js"></script>
<style type="text/css">
  body {
	margin:0;
	max-width:640px;
	font-family:"黑体";
	background-color:#68c7fc;
	font-size:16px; color:#0e5470;
}
img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}
*, :before, :after {
   -webkit-box-sizing: border-box; 
  box-sizing: inherit;
}
input{ border:1px solid #68c0e1;}
	.new_oil_center{ background:url(${webRoot}/plug-in/gasolinegift/images/new_oil_two_bg_xian.jpg) scroll top left repeat-y; background-size: contain; padding-bottom:15px;}
	.new_oil_center .center_bg{ background-color:#e8f8fd; margin:0 auto; width:76%; border:1px solid #bae9fa; padding:10px; height:auto; padding-bottom:15px;}
	.area_city{ width:100%; padding-top:10px;}
	.area_city .area_city_text{ float:left; width:27%; }
	.area_city .area_city_button{ float:left; vertical-align:top;}
	.tel{ width:100%; clear:both; padding-top:15px;}
	.tel .tel_text{ float:left; width:30%; }
	.tel .tel_input{ float:left;width: 65%; padding-top: 2px;}
	.car{ width:100%; clear:both; padding-top:5px;}
	.car .car_text{ float:left; width:30%; }
	.car .car_input{ float:left;}
	.code{ width:100%; clear:both; padding-top:15px;}
	.code .code_text{ float:left; width:30%; padding-top:2px;}
	.code .code_input{ float:left; width:29.5%;}
	@media (min-width: 375px){.code .code_input{ width:30.5%;}}
	@media (min-width: 414px){.code .code_input{ width:35%;}}
	.code .code_button{ float:left; width:33%; font-size:12px; text-align:center; border:1px solid #46b8dd; color:#0e5470; background:#def6ff; margin-left:3%; padding-top:3px; padding-bottom:3px;}
	@media (min-width: 360px){.code .code_button{ width:66px;}}
	@media (min-width: 375px){.code .code_button{ width:64px;}}
	.oil_title{ padding-top:15px; clear:both;}
	.oil_shunfeng{ padding-top:5px; font-size:14px; height:20px; vertical-align:middle;}
	.oil_shunfeng_input{ float:left; width:10%;   padding-top: 3px;}
	.oil_shunfeng_text{ float:left; width:90%; padding-top:2px;} 
	.oil_add{ width:100%; clear:both; padding-top:15px;}
	.oil_add .oil_add_text{ float:left; width:30%; font-size:14px; padding-top:2px;}
	.oil_add .oil_add_city{ float:left; width:70%;font-size: 14px;}
	.select{ margin-right:1px;}
	.fubon_add{ width:100%; clear:both; padding-top:15px; font-size:12px; border-top:dashed 1px #ccc;}
	.fubon_add .fubon_add_button_1{ float:left; width:10%; padding-top:5px;}
	.fubon_add .fubon_add_text{ float:left; width:30%; padding-top:4px; font-size: 14px;}
	.fubon_add .fubon_add_button_2{ float:left;  width:90px; text-align:center; border:1px solid #46b8dd; color:#0e5470; background:#def6ff; padding-top:3px; padding-bottom:3px; font-size: 14px;}
	.fubon_add .fubon_add_text_2{ float:left; width:30%; font-size:14px; padding-top:2px;}
	.fubon_add .fubon_add_city{ float:left; width:70%;font-size: 14px;}
	.oil_tips{ width:100%; clear:both; text-align:center; color:#fc2f50; padding-top:15px; font-size:12px;}
	.bottom_xian{ background:url(${webRoot }/plug-in/gasolinegift/images/new_oil_two_bg_buttom_xian.jpg) scroll center no-repeat; height:2px; background-size: contain;}
	.oil_two_button{ text-align:center; padding-top:20px; width:50%; margin:0 auto; padding-bottom:25px;}
  </style>
</head>

<body>
<form class=" am-form-horizontal" name="applyForm" id="applyForm" action="${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?applyMyGasolinegift" method="post">
<input type="hidden" id="openid" name="openid" value="${openid}">
<input type="hidden" id="isCarCustomer" name="isCarCustomer" value="${isCarCustomer}">
<input type="hidden" id="webRoot" name="webRoot" value="${webRoot}" />
 <div class="new_oil_top"><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_two_top.jpg" /></div>
 <div class="new_oil_center">
  <div class="center_bg">
   <div class="car">
    <div class="car_text">车牌号：</div>    
    <div class="car_input">
    <c:if test="${isCarCustomer=='No'}">
       <select name="license" id="license">
          <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
            <option>闽</option>
          </c:if>
        <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
           <option <c:if test="${cityCode=='510100'}">selected</c:if>>川</option>
           <option <c:if test="${cityCode=='500000'}">selected</c:if>>渝</option>
        </c:if>
	    </select>   
       <input id="licenseno" name="licenseno" value="" type="text" size="17.5" />
    </c:if>
    <c:if test="${isCarCustomer=='Yes'}">
       <select name="license" id="license">
          <c:forEach items="${licensenoList}"	var="licenseno" varStatus="status">
            <option>${licenseno}</option>        
          </c:forEach>
        </select>  
    </c:if>
    
    </div>
    
   </div>
   <div class="tel">
    <div class="tel_text">姓　名：</div>
    <div class="tel_input"><input id="username" name="username" value="${username }" type="text" size="19" readonly /></div>
   </div>
   <div class="tel">
    <div class="tel_text">手机号：</div>
    <div class="tel_input"><input id="mobile" name="mobile" value="${mobile }" type="text" size="19" /></div>
   </div>
   <div class="code">
    <div class="code_text">验证码：</div>
    <div class="code_input">
    	<input type="text" style="height:25px;  width: 100%;" size="8" name="dynamicpasswordother" id="dynamicpasswordother" placeholder="请输入">
    </div>
    <div class="code_button">
    	<div onclick="sendDynamicPassword(this, $('#mobile'), $('#dynamicpasswordothertemp'),'${openid}');">获取验证码</div>
    </div>
   </div>
   <div style="clear: both;"></div>
   <div id="dynamicpasswordothertemp" style="color:red;font-size: 12px;">${messageother }</div>
   <!--选择福建下面DIV才展开-->
   
   <div class="oil_title">请选择加油卡领取方式：</div>
   <div id="showAdress" style=" padding: 3px; border: 0px dashed #68c0e1; ">
	   <div class="oil_shunfeng">
	    <div class="oil_shunfeng_input"><input name="getstatus" type="radio" value="1" /></div>
	    <div class="oil_shunfeng_text">
	    <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
                              顺丰快递到付(厦门12元、福建13元)
        </c:if>
        <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
                          成都和重庆市区11元，郊县13元
        </c:if>
	    </div>
	   </div>
	   <div class="oil_add">
	    <div class="oil_add_text">邮寄地址:</div>
	    <div class="oil_add_city">	    
		  <select name="area_parent"  id="area_parent" onchange="changeValue(this.value);" style="padding-top: -3px;">
		    	  <option>请选择</option>		    	 
		   <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
                 <option value="1">福州市</option>
			     <option value="2">泉州市</option>
			     <option value="3">漳州市</option>
			     <option value="4">厦门市</option>
          </c:if>
          <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
                 <option value="5">成都市</option>
			     <option value="6">重庆市</option>			     
          </c:if>			    
		 </select>
		    
		    <select name="area_child" id="area_child">
		    <option>请选择</option>
		    </select>
		     <script>
				function changeValue(val){
					var area_child = document.getElementById("area_child");
					if(val==1){		
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("鼓楼区","001"));
						area_child.add(new Option("台江区","002"));
						area_child.add(new Option("仓山区","003"));
						area_child.add(new Option("马尾区","004"));
						area_child.add(new Option("晋安区","005"));
						area_child.add(new Option("闽侯县","006"));
						area_child.add(new Option("连江县","007"));
						area_child.add(new Option("罗源县","008"));
						area_child.add(new Option("闽清县","009"));
						area_child.add(new Option("永泰县","0010"));
						area_child.add(new Option("平潭县","0011"));
						area_child.add(new Option("长乐市","0012"));
						area_child.add(new Option("福清市","0013"));
					}else if(val == 2){
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("丰泽区","010"));
						area_child.add(new Option("鲤城区","011"));
						area_child.add(new Option("洛江区","012"));
						area_child.add(new Option("泉港区","013"));
						area_child.add(new Option("石狮市","014"));
						area_child.add(new Option("晋江市","015"));
						area_child.add(new Option("南安市","016"));
						area_child.add(new Option("惠安县","017"));
						area_child.add(new Option("安溪县","018"));
						area_child.add(new Option("永春县","019"));
						area_child.add(new Option("德化县","020"));
						area_child.add(new Option("金门县","021"));
					}else if(val == 3){
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("芗城区","100"));
						area_child.add(new Option("龙文区","101"));
						area_child.add(new Option("龙海市","102"));
						area_child.add(new Option("云霄县","103"));
						area_child.add(new Option("漳浦县","104"));
						area_child.add(new Option("诏安县","105"));
						area_child.add(new Option("长泰县","106"));
						area_child.add(new Option("东山县","107"));
						area_child.add(new Option("南靖县","108"));
						area_child.add(new Option("平和县","109"));
						area_child.add(new Option("华安县","110"));
					}else if(val == 4){
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("思明区","200"));
						area_child.add(new Option("湖里区","201"));
						area_child.add(new Option("集美区","202"));
						area_child.add(new Option("同安区","203"));
						area_child.add(new Option("海沧区","204"));
						area_child.add(new Option("翔安区","205"));
					}else if(val == 5){
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("锦江区","200"));
						area_child.add(new Option("青羊区","201"));
						area_child.add(new Option("金牛区","202"));
						area_child.add(new Option("武侯区","203"));
						area_child.add(new Option("成华区","204"));
						area_child.add(new Option("青白江区","205"));						
						area_child.add(new Option("龙泉驿区","200"));
						area_child.add(new Option("新都区","201"));
						area_child.add(new Option("温江区","202"));
						area_child.add(new Option("高新区","203"));
						area_child.add(new Option("天府新区","204"));
						area_child.add(new Option("金堂县","205"));						
						area_child.add(new Option("双流县","205"));
						area_child.add(new Option("郫县","205"));
						area_child.add(new Option("大邑县","205"));
						area_child.add(new Option("蒲江县","205"));
						area_child.add(new Option("新津县","205"));
						area_child.add(new Option("都江堰市","205"));
						area_child.add(new Option("彭州市","205"));
						area_child.add(new Option("崇州市","205"));
						area_child.add(new Option("邛崃市","205"));						
					}else if(val == 6){
						cleanOption();
						area_child.add(new Option("请选择","请选择"));
						area_child.add(new Option("渝中区","200"));
						area_child.add(new Option("沙坪坝区","201"));
						area_child.add(new Option("江北区","200"));
						area_child.add(new Option("渝北区","201"));
						area_child.add(new Option("南岸区","200"));
						area_child.add(new Option("九龙坡区","201"));
						area_child.add(new Option("大渡口区","200"));
						area_child.add(new Option("巴南区","201"));
						area_child.add(new Option("北碚区","200"));
						area_child.add(new Option("万州区","201"));
						area_child.add(new Option("涪陵区","200"));
						area_child.add(new Option("长寿区","201"));
						area_child.add(new Option("黔江区","200"));
						area_child.add(new Option("永川区","201"));
						area_child.add(new Option("江津区","200"));
						area_child.add(new Option("南川区","201"));
						area_child.add(new Option("合川区","201"));
						area_child.add(new Option("綦江区","201"));
						area_child.add(new Option("大足区","201"));
						area_child.add(new Option("潼南县","201"));
						area_child.add(new Option("铜梁县","201"));
						area_child.add(new Option("荣昌县","201"));
						area_child.add(new Option("璧山县","201"));
						area_child.add(new Option("梁平县","201"));
						area_child.add(new Option("城口县","201"));
						area_child.add(new Option("丰都县","201"));
						area_child.add(new Option("垫江县","201"));
						area_child.add(new Option("武隆县","201"));
						area_child.add(new Option("忠县","201"));
						area_child.add(new Option("开县","201"));
						area_child.add(new Option("云阳县","201"));
						area_child.add(new Option("奉节县","201"));
						area_child.add(new Option("巫山县","201"));
						area_child.add(new Option("巫溪县","201"));												
					}
				}
				function cleanOption(){
					var obj = document.getElementById("area_child");
					for(var i=obj.options.length-1 ; i>= 0 ; i--){ 
						obj.options[i] = null;
					}
				}
			</script>
	    </div>
	   </div>
	   <div class="oil_add" style=" padding-bottom: 30px;">
	    <div class="oil_add_text">&nbsp;</div>
	    <div class="oil_add_city"><input id="address" name="address" type="text" size="22" style="height: 20px;" /></div>
	   </div>

	 </div>
	 	   <div class="fubon_add">
	    <div class="fubon_add_button_1"><input name="getstatus" type="radio" value="0" /></div>
	    <div class="fubon_add_text">上门自领：</div>
	    <div class="fubon_add_text_2" style="clear:both;padding-top:15px;">领取地址:</div>
	    <div class="fubon_add_city" style="padding-top:17px;">
		    <select name="receive_address" id="receive_address" style="padding-top: -3px;width:85%">
		    	<option value="">请选择</option>		    	
		    	<c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
                   <option value="厦门市湖滨北路101号">厦门市湖滨北路101号</option> 
		    	   <option value="厦门软件园二期望海路">厦门软件园二期望海路</option>
		    	   <option value="福州鼓楼区温泉街道东大路">福州鼓楼区温泉街道东大路</option>
		    	   <option value="平潭县潭城镇万宝路南侧">平潭县潭城镇万宝路南侧</option>
		    	   <option value="泉州刺桐南路晚报社">泉州刺桐南路晚报社</option>
		    	   <option value="晋江和平中路华泰大厦3楼">晋江和平中路华泰大厦3楼</option>
		    	   <option value="漳州芗城新华北路华元公寓">漳州芗城新华北路华元公寓</option>
		    	   <option value="南靖县山城镇东大路翠眉村">南靖县山城镇东大路翠眉村</option>
		    	   <option value="长泰官山村山前官九线西侧">长泰官山村山前官九线西侧</option>  
		    	   <option value="漳州平和县小溪镇旧县村新店35号">漳州平和县小溪镇旧县村新店35号</option>    
                </c:if>
              <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
                   <option value="成都市锦江区一环路东5段8号">成都市锦江区一环路东5段8号</option>
		    	   <option value="重庆渝中邹容路68号大都会商厦">重庆渝中邹容路68号大都会商厦</option>
		    	   <option value="重庆长寿区桃源路15号蓝筹银座">重庆长寿区桃源路15号蓝筹银座</option>		    	    
              </c:if>
		    </select>
		</div>
	    <!-- <div class="fubon_add_button_2"><a href="http://mp.weixin.qq.com/s?__biz=MzA5NzkyNTMxMg==&mid=401307016&idx=1&sn=c0d55bb60ed1502dfbbc60be2e4253a8#rd">查看领取地址</a></div> -->
	   </div>
   	<div class="oil_tips" id="alertMessage">${message }</div>
  </div>
 </div>
 <div class="bottom_xian">&nbsp;</div>
 <div class="oil_two_button"><a href="javascript:void(0);" onclick="submitApply()" id="paySub"><img src="${webRoot }/plug-in/gasolinegift/images/new_oil_two_button.jpg" /></a></div>
 </form>
 <script type="text/javascript">
 $(function(){
	$("input:radio[name='getstatus']").change(function () {
		var getstatus = $('input:radio[name="getstatus"]:checked').val();
		if("1"==getstatus){
			$("#receive_address option:first").attr("selected", "selected");
			
			$("#receive_address").attr("disabled", "disabled");
			$("#area_parent").removeAttr("disabled");
			$("#area_child").removeAttr("disabled");
			$("#address").removeAttr("disabled");
		}else if("0"==getstatus){
			$("#area_parent option:first").attr("selected", "selected");
			$("#area_child option:first").attr("selected", "selected");
			$("#address").val("");
			$("#area_parent").val("请选择");;
			$("#area_child").val("请选择");;
			$("#area_parent").attr("disabled", "disabled");
			$("#area_child").attr("disabled", "disabled");
			$("#address").attr("disabled", "disabled");
			$("#receive_address").removeAttr("disabled");
		}
    });
 });
 
 function submitApply(){
	 if(checkVal()){
		 var area=$('input:radio[name="getstatus"]:checked').val();
		 if(undefined == area){
			 showError('**请选择加油卡领取方式！');
			 return false;
		 }else{
			 if(checkArea()){
				 checkCode();
			 }
		 }
	 }
 }
 function getAreaValue(){
		var areaparent = $("#area_parent").find("option:selected").text();
		var areachild = $("#area_child").find("option:selected").text();
		var address = $("#address").val(); 
		if(areaparent!='请选择' && areachild !='请选择'){
			var areaName = areaparent + areachild;
			 $("#address").val(areaName+address);
			return true;
		}else{
			showError('**请选择市区！');
			return false;
		}
		
    }
		//显示错误提示
		function showError(str) {
			$('#alertMessage').text(str);
		}
		function checkVal(){
			var licenseno = $('#licenseno').val();	
			<c:if test="${isCarCustomer=='No'}">   //非车客户才要输入车牌号，车险客户使用下来选择 
			  if(licenseno==null || licenseno ==''){
				   $("#licenseno").focus();
				  showError('**车牌号不为空！');
				   return false;
			       }			
			     if(licenseno.length!=6){
				    showError('**请正确输入车牌号！');
				    return false;
			      }	
			 </c:if>
			var username = $('#username').val();
			if(username==null || username ==''){
				$("#username").focus();
				showError('**姓名不为空！');
				return false;
			}
			var mobile = $('#mobile').val();
			var re=/^1[0-9]{10}$/; 
			if(!re.test(mobile)){
			 $("#mobile").focus();
			 	showError('**手机号格式不对！');
			 	return false;
			}
			var dynamicpasswordother = $('#dynamicpasswordother').val();
			if(dynamicpasswordother==null || dynamicpasswordother ==''){
				$("#dynamicpasswordother").focus();
				showError('**验证码不为空！');
				return false;
			}
			return true;
		}
		function checkArea(){
			var getstatus = $('input:radio[name="getstatus"]:checked').val();
			if(getstatus == null || getstatus == ''){
				showError('**请选择加油卡领取方式！');
				return false;
			}else if(getstatus == 0){
				var receiveAddress = $("#receive_address").find("option:selected").val();
				if(receiveAddress==''){
					showError('**请选择领取地址！');
					return false;
				}
				return true;
			}else{
				var address = $('#address').val();
				if(address==null || address ==''){
					$("#address").focus();
					showError('**地址不为空！');
					return false;
				}
				 if(getAreaValue()){ //如果选择了 市区
					 return true; 
				 }else{
					 return false;
					 } 				
				
			}
		}
		function checkCode(){
			var dynamicpassword= $('#dynamicpasswordother').val();
			var mobile = $('#mobile').val();
			$.ajax({
				type : "POST",
				url : "${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?checkPhone",
				data : "&dynamicpassword="+dynamicpassword +"&mobile="+mobile,
				dataType : "json",
				success : function(data) {
					if (data == "0") {
					 	$('#applyForm').submit();//提交路径
					}else{
						$("#address").val("");
						showError('**验证码有误！');
						return false;
					}
				}
			});
		}
	</script>

</body>
</html>