<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <title>加油宝</title>
    <script src="${webRoot}/plug-in/fo/js/gasolinegift/gasolinegift.js"></script>
    <script src="${webRoot}/plug-in/fo/js/gasolinegift/pageControl.js"></script>
    <script type="text/javascript"> 
     
    var isSubMit=false; //检查是否重复提交
    
    function submitFrom(){  
    	if(!isSubMit){  //第一次提交 
    		isSubMit=true; //修改提交控制     	
    	if(checkVal()){//检查用户输入信息    	
    	    checkCode();//校验验证码，通过的话 直接提交表单 
    	 }else{
    		 isSubMit=false ;//页面校验不通过，开启修改 后可提交   
    	 }      	  	
      }
    }
    
      //检查表单输入的合法性 
   function checkVal(){   
       //检查用户客户名是否输入  	
	if($("#username").size()>0 && $("#username").val() == ""){
		showError("请输入您的姓名");
		$("#username").focus();
		return false;
	}    
	   //检查车牌号输入  ，非车客户	
	if($("#carNo").size()>0 && $("#carNo").val() == ""){
		showError("请输入您的车牌号");
		$("#carNo").focus();
		return false;
	}	 
	 //检查车牌号选择 ，车险客户   	
	if($("#licenseno").size()>0 && $("#licenseno").find("option:selected").text() =="请选择"){		 
		showError("请选择您的车牌号");
		$("#licenseno").focus();
		return false;
	}    
	//手机号校验  
	var mobile = $('#mobile').val();
	var re=/^1[0-9]{10}$/; 
	if(!re.test(mobile)){
	 $("#mobile").focus();
	 	showError('**手机号格式不对！');
	 	return false;
	}	
	//验证码 不能为空校验 
	var dynamicpasswordother = $('#dynamicpasswordother').val();
	if(dynamicpasswordother==null || dynamicpasswordother ==''){
		$("#dynamicpasswordother").focus();
		showError('**验证码不为空！');
		return false;
	 }	 
    var receiveWay = $('input:radio[name="receiveWay"]:checked').val();	
     if(receiveWay){
    	   if(receiveWay=='10'){  //邮寄 
             if(!checkaddress()){  //地址检查不通过
            	return false ;
             }
 
    	    } else{
    		      if(!checkreceiveAddress()){ //上门领取地址没选择 
    		    	  return false ;  
    		      } 
    		     }    	
       } else{   	 
        showError('**请选择加油卡领取方式！');
	    return false;
     }	   
     return true;    
    }
    //检查用户邮件地址输入  
   function checkaddress(){
    	var area_parent = $("#area_parent").find("option:selected").text();  
    	if(area_parent=="请选择"){
    		 showError('**请选择邮件城市 ');
    		 return false;
    	}     	
    	var area_child = $("#area_child").find("option:selected").text();  
    	if(area_child=="请选择"){
    		 showError('**请选择邮件区县 ');
    		 return false;
    	}     	
    	var villages = $('#villages').val();
		if(villages==null || villages ==''){
			$("#villages").focus();
			showError('**请输入详细地址');
			return false;
		}    	 
	   $("#address").val(area_parent+area_child+villages);
    	 return true; 
      }
      
    function checkreceiveAddress(){
    	var receiveAddress = $("#receiveAddress").find("option:selected").val();
    	if(receiveAddress=="请选择"){
   		 showError('**请选择上门领取地址 ');
   		 return false;
   	    } 
    	return true;    	
     } 
    
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
						isSubMit=true;
					 document.getElementById("oilFrom").submit(); //验证通过，提交表单。					
				}else{	
					 isSubMit=false;
					showError('**验证码错误，请重新输入');
					return false;
				}
			}
		});
	}
	
	//显示错误提示
	function showError(str) {
		$('#dynamicpasswordothertemp').text(str);
	}
	
	
	 $(function(){
			$("input:radio[name='receiveWay']").change(function () {
				var getstatus = $('input:radio[name="receiveWay"]:checked').val();
				if("10"==getstatus){
					$("#receiveAddress option:first").attr("selected", "selected");					
					$("#receiveAddress").attr("disabled", "disabled");
					$("#area_parent").removeAttr("disabled");
					$("#area_child").removeAttr("disabled");
					$("#villages").removeAttr("disabled");
				}else if("20"==getstatus){
					$("#area_parent option:first").attr("selected", "selected");
					$("#area_child option:first").attr("selected", "selected");
					$("#address").val("");
					$("#villages").val("");
					$("#area_parent").val("请选择");;
					$("#area_child").val("请选择");;
					$("#area_parent").attr("disabled", "disabled");
					$("#area_child").attr("disabled", "disabled");
					$("#villages").attr("disabled", "disabled");
					$("#receiveAddress").removeAttr("disabled");
				}
		    });
		 });
    
    </script>
     
    <link rel="stylesheet" href="${webRoot}/plug-in/gasolinegift/css/data.css">
</head>

<body>
 <section class="container wx">
 <form  id="oilFrom"  action="${webRoot}/fo/binded/gasolinegift/gasolinegiftController.do?applyMyGasolinegift" method="post"  > 
  <div class="container-hd">
    <div><img src="${webRoot}/plug-in/gasolinegift/images/new_index_top.jpg" alt="#" /></div>
     <div class="form">
     <input type="hidden" id="webRoot" name="webRoot" value="${webRoot}" />
     <input type="hidden" id="cityCode" name="cityCode" value="${cityCode}" />
     <input type="hidden" id="openid" name="openid" value="${openid}" />
     <input type="hidden" id="channel" name="channel" value="${channel}" />
     <input type="hidden" id="isCarCustomer" name="isCarCustomer" value="${isCarCustomer}" />
      <input type="hidden" id="address" name="address" value="${address}" />
     <input type="hidden" id="licensenoList" name="licensenoList" value="${licensenoList}" />
     <input type="hidden" name="token" value="${token}">
      <div class="form_1">
       <div class="form_1_left">姓 名：</div>
       <div class="form_1_right"><input class="form_input" id="username"  name="username"  value='${username}'  type="text" placeholder="请输入您的姓名"></div>
      </div>    
      
      <div class="form_2">      
       <c:if test="${isCarCustomer=='No'||channel!=1}">
         <div class="form_2_left">车牌号：</div>
           <select  id="carLicense"  name="carLicense" class="form_2_middle" >              
             <c:if test="${cityCode!='510100'&&cityCode!='500000'}"> 
                  <option value="闽" >闽</option>
             </c:if>
             <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
                 <option value="川" <c:if test="${cityCode=='510100'}">selected</c:if>>川</option>
                 <option value="渝" <c:if test="${cityCode=='500000'}">selected</c:if>>渝</option>
              </c:if>
	      </select>   
         <div class="form_2_right"><input class="form_input"  id="carNo"  name="carNo"  value='${carNo}'  type="text" placeholder="请输入您的车牌号" style="width:1.4rem;"></div>
      </c:if>      
     <c:if test="${isCarCustomer=='Yes'}">
       <div class="form_5_left">请选择车牌号：</div>
        <div class="form_5_right">
        <select name="licenseno" id="licenseno">
           <option value="请选择" >请选择</option>
              <c:forEach items="${licensenoList}"	var="licenseno" varStatus="status">
                <option value="${licenseno}">${licenseno}</option>        
              </c:forEach>
        </select>  
        </div>
    </c:if>     
      </div>      
       <div class="form_3">
       <div class="form_3_left">手机号：</div>
       <div class="form_3_right"><input  id="mobile" name="mobile"  value='${mobile}'   class="form_input" name="" type="text" placeholder="请输入您的手机号"></div>
      </div>
      
       <div class="form_4">
       <div class="form_4_left">验证码：</div>
       <div class="form_4_middle"><input class="form_input" name="dynamicpasswordother" id="dynamicpasswordother" type="text" placeholder="验证码" style="width:0.9rem;"></div>
       <div class="form_4_right" onclick="sendDynamicPassword(this, $('#mobile'), $('#dynamicpasswordothertemp'),'${openid}');"   >获取验证码</div>
       </div>     
       <div class="form_tips" id="dynamicpasswordothertemp" >${message}</div>      
      <div class="from_line"></div>      
     </div>
     
     <div class="form_express">
      <div class="form_title">请选择加油卡领取方式:</div>
      <div class="form_radio">
       <div class="form_radio_left"><input name="receiveWay" type="radio" value="10"></div>
             
       <c:if test="${cityCode!='510100'&&cityCode!='500000'|| channel==2}"> 
           <div class="form_radio_right">顺丰快递到付:厦门12元，其他地区13元</div>
       </c:if>
       <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
           <div class="form_radio_right">顺丰快递到付:市区11元，郊县13元</div>
       </c:if>     
     
      </div>
      <div class="form_radio">
       <div class="form_radio_left">&nbsp;</div>
       <div class="form_radio_right">邮寄地址: 
        <select name="area_parent"  id="area_parent" onchange="changeValue(this.value);" >
            <option value="请选择"  >请选择</option>		    	 
		   <c:if test="${(cityCode!='510100'&&cityCode!='500000')||channel==2 }"> 
                 <option value="1">福州市</option>
			     <option value="2">泉州市</option>
			     <option value="3">漳州市</option>
			     <option value="4">厦门市</option>
          </c:if>
          <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
                 <option value="5">成都市</option>			   		     
          </c:if>			    
		 </select>
         <select name="area_child" id="area_child"> <option value="请选择" >请选择</option> </select>       
       </div>
      </div>
      <div><input name="villages" id="villages"  type="text" class="form_input_2" placeholder="请输入详细地址"></div>
      <div class="form_radio">
       <div class="form_radio_left"><input name="receiveWay" type="radio" value="20"></div>
       <div class="form_radio_right">上门领取      
         <select name="receiveAddress" id="receiveAddress" style="padding-top: -3px;width:85%">
		    	<option value="请选择">请选择</option>		    	
		    	<c:if test="${cityCode!='510100'&&cityCode!='500000'&&channel==1}"> 
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
              <c:if test="${(cityCode=='510100'||cityCode=='500000')&&channel==1}"> 
                   <option value="成都市锦江区一环路东5段8号">成都市锦江区一环路东5段8号</option>		    	      	    
              </c:if>
              <c:if test="${channel==2}"> 
                 <option value="厦门金桥路金桥文化创业园101号A座102室">厦门金桥路金桥文化创业园101号A座102室</option>
              </c:if>
		    </select>
        </div>
      </div>
     
    </div>
     <div class="from_line"></div>
     <div class="illustrate_title"><img src="${webRoot}/plug-in/gasolinegift/images/index_title_1.png" style="width:35%" /></div>
     <div class="illustrate_text">     
    <c:if test="${(cityCode!='510100'&&cityCode!='500000')||channel==2 }"> 
        a.首次办卡需预充值金额300元（实际支付285元）。<br/>
    </c:if>
    <c:if test="${cityCode=='510100'||cityCode=='500000'}"> 
        a.首次办卡需预充值金额300元（实际支付294元）。<br/>			   		     
    </c:if>    
       b.充值平台为第三方提供，充值过程遇到问题请联系<span class="col">0592-2233870</span>。
     </div>  
    </div>
   </form> 
    <a onclick="submitFrom()" > <div class="illustrate_button"><img src="${webRoot}/plug-in/gasolinegift/images/index_button.png"  /></div> </a>   
 </section>
</body>
</html>
