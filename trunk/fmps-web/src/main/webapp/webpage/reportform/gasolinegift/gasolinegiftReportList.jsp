<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">

<t:datagrid name="gasolineGiftReportList" title="加油宝报表" fit="true" actionUrl="gasolineGiftReportController.do?datagrid"  fitColumns="true" idField="id" queryMode="group" pageSize="20">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="openid"  field="openid"></t:dgCol>
	<t:dgCol title="客户姓名" field="customercname" query="true"></t:dgCol>
	<t:dgCol title="身份证号"  field="identifynumber"></t:dgCol>
	<t:dgCol title="车牌号"  field="licenseno" query="true" ></t:dgCol>
	<t:dgCol title="手机" field="mobile"  query="true" ></t:dgCol>
	<t:dgCol title="领取方式" field="receiveWay" replace="邮寄_10,渠道自取_20"></t:dgCol>
	<t:dgCol title="快递寄送地址" field="expressAddress"></t:dgCol>
	<t:dgCol title="上门自取机构名称" field="pickupAddress"></t:dgCol>
	<t:dgCol title="业务员姓名"  field="handlername" query="true"></t:dgCol>
	<t:dgCol title="业务员工号"  field="handlercode"></t:dgCol>
	<t:dgCol title="归属机构"  field="comcname" query="true"></t:dgCol>
	<t:dgCol title="申请日期"  field="applyTime" formatter="yyyy-MM-dd" query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="卡截止日期"  field="rchgDctExpire" formatter="yyyy-MM-dd" ></t:dgCol>
	<t:dgCol title="加油宝券id"  field="giftid"></t:dgCol>
	<t:dgCol title="加油卡卡号"  field="oilCardNo"></t:dgCol>
    
	<t:dgToolBar title="导出Excel(可选字段)" icon="icon-add" funname="popupDiv();"></t:dgToolBar>

</t:datagrid>
</div>
</div>

<div id="noticeUserReportListtb" >
  <div id='pop-div' style="width:800px;" class="pop-box"> 
	<h4 style="color: #000;">导出excel字段选择</h4> 
    <div class="pop-box-body" > 
        <form name="form1" id="formid" action="gasolineGiftReportController.do?exportXlscheck" method="post">
			请选择要导出的字段<br /><br /> 
			<input type="checkbox" class="checkbox"  name="chk_all" id="SelectAll"  onclick="selectAll();" />全选/取消全选
			<br /><br /> 
			&nbsp; &nbsp;
			<label><input name="openid1" id="subcheck"  type="checkbox" class="checkbox" value="openid" />openid </label>
			<label><input name="customercname1" id="subcheck" type="checkbox" class="checkbox" value="客户姓名" />客户姓名 </label>
			<label><input name="identifynumber1" id="subcheck" type="checkbox" class="checkbox"  value="身份证号" />身份证号 </label>
			<label><input name="licenseno1" type="checkbox" class="checkbox"  value="车牌号" />车牌号 </label>
			<label><input name="mobile1" id="subcheck" type="checkbox" class="checkbox" value="手机" />手机 </label>
			<label><input name="getWay1" type="checkbox" class="checkbox" value="领取方式" />领取方式 </label>
			<label><input name="expressAddress1" type="checkbox" class="checkbox" value="快递寄送地址" />快递寄送地址 </label>
			<label><input name="pickupAddress1" type="checkbox" class="checkbox" value="上门自取机构名称" />上门自取机构名称</label>
			<label><input name="handlername1" type="checkbox" class="checkbox"  value="业务员姓名" />业务员姓名</label>
			<label><input name="handlercode1" type="checkbox" class="checkbox"  value="业务员工号" />业务员工号</label>
			<label><input name="comcname1" type="checkbox" class="checkbox"  value="归属机构 " />归属机构 </label>
			<label><input style="font-size: 18px;font-family: Tahoma,Verdana,微软雅黑,新宋体;" name="applyTime1" type="checkbox" class="checkbox"  value="申请日期" />申请日期</label> 
			<label><input style="font-size: 18px;font-family: Tahoma,Verdana,微软雅黑,新宋体;" name="rchgDctExpire1" type="checkbox" class="checkbox"  value="优惠有效期" />优惠有效期</label> 
			<label><input name="giftid1" type="checkbox" class="checkbox"  value="加油宝券id" />加油宝券id</label>
			<label><input name="oilCardNo1" type="checkbox" class="checkbox"  value="加油卡卡号" />加油卡卡号</label>
			<br /><br />
			<div style="float: right; padding-bottom: 25px;">  
				<input type="submit" name="submit" value="确认" onclick="courseListExportXlscheck();" />
				<input id=btnClose type="button" onclick="hideDiv('pop-div');" value="关闭"/>
			</div>
		</form>
      </div>
  </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	  $("input[name='applyTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	  $("input[name='applyTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});

function courseListExportXlscheck() {
	$("#begindate").remove();
	$("#enddate").remove();	
	var begindate = $("input[name='applyTime_begin']").val();
	var enddate = $("input[name='applyTime_end']").val();	
	var customercname = $("input[name='customercname']").val();
	var licenseno = $("input[name='licenseno']").val();	
	var mobile = $("input[name='mobile']").val();
	var handlername = $("input[name='handlername']").val();
	var comcname = $("input[name='comcname']").val();	
	$("#formid").append("<input name=\"begindate\" id=\"begindate\"  type=\"hidden\" value=\""+begindate+"\" />");
	$("#formid").append("<input name=\"enddate\" id=\"enddate\"  type=\"hidden\" value=\""+enddate+"\" />");	
	$("#formid").append("<input name=\"customercname\" id=\"customercname\"  type=\"hidden\" value=\""+customercname+"\" />");
	$("#formid").append("<input name=\"licenseno\" id=\"licenseno\"  type=\"hidden\" value=\""+licenseno+"\" />");
	$("#formid").append("<input name=\"mobile\" id=\"mobile\"  type=\"hidden\" value=\""+mobile+"\" />");
	$("#formid").append("<input name=\"handlername\" id=\"handlername\"  type=\"hidden\" value=\""+handlername+"\" />");
	$("#formid").append("<input name=\"comcname\" id=\"comcname\"  type=\"hidden\" value=\""+comcname+"\" />");
	$("#formid").submit();
}

function popupDiv(div_id) {
	var div_obj = $("#pop-div");
	var windowWidth = document.body.clientWidth;
	var windowHeight = document.body.clientHeight;
	var popupHeight = div_obj.height();
	var popupWidth = div_obj.width();
	//添加并显示遮罩层  

	div_obj.css({
		"position" : "absolute"
	}).animate({
		left : windowWidth / 2 - popupWidth / 2,
		top : windowHeight / 2 - popupHeight / 2,
		opacity : "show"
	}, "slow");

}
//复选框事件  
//全选、取消全选的事件  
function selectAll() {
	if ($("#SelectAll").attr("checked")) {
		$(":checkbox").attr("checked", true);
	} else {
		$(":checkbox").attr("checked", false);
	}
}

function hideDiv(div_id) {
	$("#mask").remove();
	$("#" + div_id).animate({
		left : 0,
		top : 0,
		opacity : "hide"
	}, "slow");
} 
</script>

<style type="text/css">
.pop-box {
	z-index: 9999;
	margin-bottom: 3px;
	display: none;
	position: absolute;
	background: #FFF;
	border: solid 1px #6e8bde;
}

.checkbox {
	width: 18px;
	height: 18px;
}

.pop-box h4 {
	color: #FFF;
	cursor: default;
	height: 18px;
	font-size: 14px;
	font-weight: bold;
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
	color: #C7EDCC;
	background-color: #C7EDCC;
	position: absolute;
	top: 0px;
	left: 0px;
	filter: Alpha(Opacity = 60);
}
</style>