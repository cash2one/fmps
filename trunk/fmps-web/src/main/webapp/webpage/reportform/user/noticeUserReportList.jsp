<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">

<t:datagrid name="noticeUserReportList" title="关注用户报表"
	actionUrl="NoticeUserReportController.do?datagrid"  fit="true"   fitColumns="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>

	<t:dgCol title="openid"  field="openid" ></t:dgCol>
	<%-- <t:dgCol title="昵称"  field="nickname" query="true"></t:dgCol> --%>
	<t:dgCol title="用户头像" imageSize="70,70" field="headimgurl" image="true"></t:dgCol>
	
	
	
	<t:dgCol title="性别"  field="sex" replace="男_1,女_2"></t:dgCol>
	<t:dgCol title="城市"  field="city" ></t:dgCol>
	<t:dgCol title="省份"  field="province"></t:dgCol>
	<t:dgCol title="国家"  field="country" ></t:dgCol>
	
	  
    <t:dgCol title="备注名称"  field="bzname" ></t:dgCol>
    <t:dgCol title="关注时间"  field="subscribeTime"  formatter="yyyy-MM-dd hh:mm:ss" query="true" queryMode="group" ></t:dgCol>
    <t:dgCol title="客户名称"  field="customercname" query="true" ></t:dgCol>
    <t:dgCol title="微信昵称"  field="nickname" query="true" ></t:dgCol>

	<t:dgCol title="认证时间"   field="bindTime" formatter="yyyy-MM-dd hh:mm:ss" query="true" queryMode="group" ></t:dgCol>   <!-- ????????查询不可以？ -->
	<t:dgCol title="二维码场景值"  field="EventKey" ></t:dgCol> 
	<t:dgCol title="认证手机号"  field="mobile" query="true"></t:dgCol>
	<t:dgCol title="认证证件号"  field="identifynumber" query="true"></t:dgCol>
	
	<t:dgCol title="是否已认证"  field="isbind" replace="已经认证_0,未认证_1" query="true" hidden="false" ></t:dgCol> 
   
	<t:dgToolBar title="导出Excel(可选字段)" icon="icon-add" url="userReport/NoticeUserReportController.do?checknoticeUserReport" funname="popupDiv();"></t:dgToolBar>
	

</t:datagrid>
</div>
</div>

<div id="noticeUserReportListtb" >
  <div id='pop-div' style="width: 600px;" class="pop-box"> 
            <h4 style="color: #000;">导出excel字段选择</h4> 
            <div class="pop-box-body" > 
                <form name="form1" id="formid" action="NoticeUserReportController.do?exportXlscheck" method="post">
  请选择要导出的字段<br /><br /> 
  <input type="checkbox" class="checkbox"  name="chk_all" id="SelectAll"  onclick="selectAll();" />全选/取消全选
  <br /><br /> 
 &nbsp; &nbsp;
<label><input name="openid1" id="subcheck"  type="checkbox" class="checkbox" value="微信号" />微信号 </label> 
&nbsp;&nbsp;
<label><input name="nickname1" id="subcheck" type="checkbox" class="checkbox"  value="昵称" />昵称 </label> 
<!-- <label><input name="account_id" type="checkbox" class="checkbox"  value="微信账号" />微信账号 </label>  -->
	<label><input name="sex1" id="subcheck" type="checkbox" class="checkbox" value="性别" />性别 </label>
	<label><input name="subscribe_time1" type="checkbox" class="checkbox"  value="关注时间" />关注时间 </label>
	<label><input name="headimgurl1" type="checkbox" class="checkbox"  value="用户头像" />用户头像 </label>
	<label><input name="bzName1" type="checkbox" class="checkbox"  value="备注名称" />备注名称</label>
	<label><input style="font-size: 18px;font-family: Tahoma,Verdana,微软雅黑,新宋体;" name="addtime1" type="checkbox" class="checkbox"  value="添加时间" />添加时间 </label> 
	 
 
   <br /> 
  <br />  
  &nbsp; &nbsp;
  <label><input name="bindType1" type="checkbox" class="checkbox"  value="认证类型" />认证类型 </label> 
 
  <label><input  name="bindTime1" type="checkbox" class="checkbox"  value="认证时间" />认证时间</label> 
  <label><input name="subscribe1" type="checkbox" class="checkbox"  value="是否关注" />是否关注 </label> 
  <label><input name="country1" type="checkbox" class="checkbox" value="国家 " />国家 </label>
  <label><input name="province1" type="checkbox" class="checkbox" value="省份" />省份 </label>

  
  <label><input name="city1" type="checkbox" class="checkbox"  value="城市 " />城市 </label>
  <label><input name="customercode1" type="checkbox" class="checkbox"  value="客户代码" />客户代码</label> 
 
  
  <br /> 
  <br /> 
  &nbsp; &nbsp;
 
  <label><input name="customercname1" type="checkbox" class="checkbox"  value="客户名称" />客户名称</label> 
  <label><input name="identifynumber1" type="checkbox" class="checkbox"  value="证件号码" />证件号码</label> 
  <label><input name="mobile1" type="checkbox" class="checkbox"  value="手机号" />手机号</label>
  <label><input  name="licenseno1" type="checkbox" class="checkbox"  value="车牌号" />车牌号</label>

  <label><input name="groupId1" type="checkbox" class="checkbox"  value="组ID" />组ID </label>
  <label><input name="customerSex1" type="checkbox" class="checkbox"  value="认证客户的性别" />认证客户的性别</label> 
 
   <br /> 
  <br /> 
  &nbsp; &nbsp; 
   
  <label><input name="customerBirthday1" type="checkbox" class="checkbox"  value="认证客户的生日" />认证客户的生日</label>
  <label><input name="EventKey1" type="checkbox" class="checkbox"  value="扫码关注预设值" />扫码关注预设值</label> 
  <label><input name="identifyType1" type="checkbox" class="checkbox"  value="认证客户的证件类型" />认证客户的证件类型</label> 
  
   <!--  <br /> 
  <br />  
  &nbsp; &nbsp;  -->
 

<br /> 
  <br />
  <div style="float: right; padding-bottom: 25px;">  
<input type="submit" name="submit"  value="确认" onclick="courseListExportXlscheck();" />
<input id=btnClose type="button" onclick="hideDiv('pop-div');" value="关闭"/>
</div>
 </form>
                
            </div> 
       
       
       
       
        </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='subscribe_time_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='subscribe_time_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	
	$("input[name='bindTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='bindTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});

	
	$("input[name='mobile']").attr("style","height:20px;width:90px;");

});

/*
 *	excel导出
 */
function courseListExportXls() {
	JeecgExcelExport("NoticeUserReportController.do?exportXls","noticeUserReportList");
}

function courseListExportXlscheck() {
	$("#formid").submit();
}



	 
	 
</script>
 <style type="text/css">
        .pop-box {  
            z-index: 9999;
            margin-bottom: 3px;  
            display: none;  
            position: absolute;  
            background: #FFF;  
            border:solid 1px #6e8bde;  
        } 
	  .checkbox{
		width:18px;
		
		height:18px;
		
		}
        .pop-box h4 {  
            color: #FFF;  
            cursor:default;  
            height: 18px;  
            font-size: 14px; 
            font-weight:bold;  
            text-align: left;  
            padding-left: 8px;  
            padding-top: 4px;  
            padding-bottom: 2px;  
            background: url("../images/header_bg.gif") repeat-x 0 0;  
        }  
         
        .pop-box-body {  
            clear: both;  
            margin: 4px;  
            padding: 2px;  
        }
       
       
        .mask {  
            color:#C7EDCC;
            background-color:#C7EDCC;
            position:absolute;
            top:0px;
            left:0px;
            filter: Alpha(Opacity=60);
        } 
    </style>
   <script language=javascript type="text/javascript">
    function popupDiv(div_id) {  
        var div_obj = $("#pop-div"); 
        var windowWidth = document.body.clientWidth;      
        var windowHeight = document.body.clientHeight; 
        var popupHeight = div_obj.height();      
        var popupWidth = div_obj.width();   
        //添加并显示遮罩层  

        div_obj.css({"position": "absolute"})  
               .animate({left: windowWidth/2-popupWidth/2,   
                         top: windowHeight/2-popupHeight/2, opacity: "show" }, "slow");  
                       
    }  
  //复选框事件  
  //全选、取消全选的事件  
  function selectAll(){  
      if ($("#SelectAll").attr("checked")) {  
          $(":checkbox").attr("checked", true);  
      } else {  
          $(":checkbox").attr("checked", false);  
      }  
  }  
  //子复选框的事件  
  function setSelectAll(){  
      //当没有选中某个子复选框时，SelectAll取消选中  
      if (!$("#subcheck").checked) {  
          $("#SelectAll").attr("checked", false);  
      }  
      var chsub = $("input[type='checkbox'][id='subcheck']").length; //获取subcheck的个数  
      var checkedsub = $("input[type='checkbox'][id='subcheck']:checked").length; //获取选中的subcheck的个数  
      if (checkedsub == chsub) {  
          $("#SelectAll").attr("checked", true);  
      }  
  }  
    function hideDiv(div_id) {  
        $("#mask").remove();  
        $("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow");  
    } 
    
   </script>