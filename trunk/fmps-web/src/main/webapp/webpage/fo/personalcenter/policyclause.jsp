<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>条款详情</title>
</head>
<style type="text/css">
body{ background-color:#fff;}
.am-header-default {
  background-color: #fff;
}
.am-header {
  position: relative;
  width: 100%;
  height: 49px;
  line-height: 49px;
  padding: 0 10px;
  border-bottom:2px solid #0e90d2;
}
   img {
    box-sizing: border-box;
    max-width: 100%;
    height: auto;
    vertical-align: middle;
    border: 0px none;
       }
pre {
  display: block;
  padding: 0.1rem;
  margin: 0rem 0;
  font-size: 1.3rem;
  line-height: 1.6;
  word-break: break-all;
  word-wrap: break-word;
  color: #555555;
  background-color: #fff;
  border: 0px solid #dedede;
  border-radius: 0;
}
.top_text{ text-align:center; font-size:14px; height:3rem; line-height:3rem;}
.bottom_text{ text-align:center; font-size:12px; height:3rem; line-height:3rem;}
.weui_btn_area {
  margin: 1.17647059em 11px 0.3em;
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
.am-accordion-gapped .am-accordion-item {
  border: 0px solid #dedede;
  border-bottom: none;
  margin: .5rem 0;
}
.read_center{ width:90%; margin:0 auto; padding-bottom:10px; padding-top:10px}
.read_center_left{ width:6%; float:left;}
.read_center_right{ width:94%; float:left; font-size:14px; text-align:left; padding-top:1px;}
</style> 
<body>
<header data-am-widget="header" class="am-header am-header-default" >
  <h1 class="am-header-title" style=" color:#171717; ">
    条款详情
  </h1>
</header>
<c:choose>
	<c:when test="${clauseList.size()>0}">	
		 <!-- <div class="top_text">请认真阅读以下产品条款，参与抽红包活动。</div> -->
		 <div class="top_text">请认真阅读以下产品条款。</div>
		  <section class="am-accordion am-accordion-gapped">
		  <c:forEach items="${clauseList}"	var="clause" varStatus="status">
		      <dl class="am-accordion-item">
					<dt class="am-accordion-title">
						<a href="${webRoot}/fo/binded/personalCenter/policyController.do?method=clauseDetail&openid=${openid}&policyno=${policyno}&productcode=${productcode}&afid=${clause.afid}"><div id="description">${clause.description}</div></a>
					</dt>
				</dl>
			</c:forEach>	
		  </section>
		  
		  <c:if test="${hasUnReadClause=='YES'}">
			  <div>
				  <div class="read_center">
				   		<label class="am-checkbox">
				   		<div class="read_center_left"> <input type="checkbox" name="checkClause" id="checkClause" /></div>
				   		<div class="read_center_right" onclick="changeClausStatus();">我已阅读并同意以上条款</div>
				   		</label>
				  </div>
			  </div>
			  <div id="alertMessage" style="color: red; text-align: left; text-indent: 10px;" ></div>
			  <div class="weui_opr_area">
				   <p class="weui_btn_area">
				   <!-- <a onclick="submitFrom()" class="weui_btn ">确定并参与活动</a> -->
				   <a onclick="submitFrom()" class="weui_btn ">确定</a>
				   </p>
			  </div>
		</c:if>
		<c:if test="${hasUnReadClause=='NO'}">
			  <div class="bottom_text">您已于${readtime}阅读确认过条款内容。</div>
			  <div class="weui_opr_area">
				   <p class="weui_btn_area">
				   <a onclick="javascript:history.go(-1);" class="weui_btn ">返回</a>
				   </p>
			  </div>
		</c:if>
	</c:when>
	<c:otherwise>
		<div class="top_text">没有关联条款！</div>
	</c:otherwise>
</c:choose>
 <script type="text/javascript">
 function changeClausStatus(){
		$("#checkClause").trigger('click');
	}
 function submitFrom(){
	 	if($("#checkClause").is(':checked')!=true){
	 		showError('**请确认你已阅读并同意以上条款');
	 		return;
	 	}
	 	location.href = "${webRoot}/fo/binded/personalCenter/policyController.do?method=cashcoupon&openid=${openid}&policyno=${policyno}";
   }
 
 	function showError(str) {
		$('#alertMessage').addClass('error').html(str);
	}
 </script>
</body>
</html>