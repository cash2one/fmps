<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">

<t:datagrid name="policyReportList" title="保单查询报表"
	actionUrl="PolicyReportController.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
<!-- 保单号、被保人姓名、证件号码、地址、电话、学校、保费、投保日期、保单状态、支付金额 -->	
	<t:dgCol title="openid"  field="openid" ></t:dgCol>
	<t:dgCol title="昵称"  field="nickname"></t:dgCol>
	<t:dgCol title="保单号"  field="policyNo" query="true"></t:dgCol>
	<t:dgCol title="被保人姓名"  field="insuredName" query="true"></t:dgCol>
	<t:dgCol title="证件号码"  field="identifyNumber" query="true"></t:dgCol>
	<t:dgCol title="地址"  field="address" ></t:dgCol>
    <t:dgCol title="电话"  field="phone" query="true"></t:dgCol>
    <t:dgCol title="学校"  field="school"></t:dgCol>
    <t:dgCol title="保费"  field="premium" ></t:dgCol>
    <t:dgCol title="投保日期"  field="createTime"  formatter="yyyy-MM-dd hh:mm:ss" query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="保单状态" field="policyStatus" replace="未支付_0,支付完成_1,支付成功_2,支付失败_3,取消支付_4" query="true"></t:dgCol>
	<t:dgCol title="支付金额"  field="totalFee" ></t:dgCol>
	<t:dgToolBar title="导出Excel(可选字段)" icon="icon-add" funname="popupDiv();"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<div id="policyReportListtb">
	<div id='pop-div' style="width: 600px;" class="pop-box">
		<h4 style="color: #000;">导出excel字段选择</h4>
		<div class="pop-box-body">
			<form name="form1" id="formid"
				action="PolicyReportController.do?exportXlscheck" method="post">
				请选择要导出的字段<br />
				<br /> <input type="checkbox" class="checkbox" name="chk_all" id="SelectAll" onclick="selectAll();" />全选/取消全选 <br />
				<br /> &nbsp; &nbsp; 
				<label><input name="openid1" id="subcheck" type="checkbox" class="checkbox" value="微信号" />微信号 </label>
				&nbsp;&nbsp; 
				<label><input name=policyNo1 id="subcheck" type="checkbox" class="checkbox" value="昵称" />昵称 </label> 
				<label><input name="sex1" id="subcheck" type="checkbox" class="checkbox" value="保单号" />保单号 </label> 
				<label><input name="insuredName1" type="checkbox" class="checkbox" value="被保人姓名" />被保人姓名 </label> 
				<label><input name="identifyNumber1" type="checkbox" class="checkbox" value="证件号码" />证件号码 </label> 
				<label><input name="address1" type="checkbox" class="checkbox" value="地址" />地址</label> 
				<br /> <br />
				&nbsp; &nbsp; 
				<label><input name="phone1" type="checkbox" class="checkbox" value="电话" />电话 </label> 
				<label><input name="school1" type="checkbox" class="checkbox" value="学校" />学校</label> 
				<label><input name="premium1" type="checkbox" class="checkbox" value="保费" />保费 </label>
				<label><input name="createTime1" type="checkbox" class="checkbox" value="投保日期 " />投保日期 </label> 
				<label><input name="status1" type="checkbox" class="checkbox" value="保单状态" />保单状态</label> 
				<label><input name="totalFee1" type="checkbox" class="checkbox" value="支付金额 " />支付金额 </label> 
				<br /> <br />
				<div style="float: right; padding-bottom: 25px;">
					<input type="submit" name="submit" value="确认" onclick="courseListExportXlscheck();" /> 
					<input id=btnClose type="button" onclick="hideDiv('pop-div');" value="关闭" />
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='createTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='createTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='phone']").attr("style","height:20px;width:90px;");
});

/*
 *	excel导出
 */
function courseListExportXls() {
	JeecgExcelExport("PolicyReportController.do?exportXls","policyReportList");
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