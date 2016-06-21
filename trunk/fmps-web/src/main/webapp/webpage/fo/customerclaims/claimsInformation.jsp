<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
	.am-titlebar {
	  margin-top: 5px;
	}
</style>
<script>
var pageTotal=${fn:length(customerClaimsList)}; //总页面数量 
var pageNumber=1;//当前页编号
var page="page"+pageNumber ;//当前页DOM查找ID 

//下一页 
function swipeLeftPage(){
	   document.getElementById(page).style.display="none";
	  	if(pageNumber<pageTotal){ 
		  pageNumber++;
		} else{
			  return ;
		}
	      page="page"+pageNumber; 
	      document.getElementById(page).style.display="";
 } 
 //上一页 
 function swipeRightPage(){
 	document.getElementById(page).style.display="none";
    if(pageNumber>1){
 	   pageNumber--;
    }else{  
 	   return;
    }  
      page="page"+pageNumber;  
      document.getElementById(page).style.display="";
 }
</script>
</head>
<body>

  <c:forEach items="${customerClaimsList}" var="customerClaims" varStatus="status">
  		<div id="page${status.index +1}" class="thePage"	style="display: none;">
			<header data-am-widget="header" class="am-header am-header-default">
			    <h1 class="am-header-title">
			      	 理赔进度查询
			    </h1>
			</header>
			<div   class="am-cf admin-main">
				<div  	class="admin-content">
					 <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
	  					<h2 class="am-titlebar-title">用户信息</h2>
					 </div>
				 <div style="width:94%; margin:0 auto;  height:auto; margin-bottom:10px; font-size:0.825em; padding:5px 0px 5px 5px;">       
						  保单号：${customerClaims.policyno}
			        <br/>被投保人：${customerClaims.applyName}
			      	<br/>被保险人: ${customerClaims.insureName}
			        <br/>车牌号：${customerClaims.licenseno}
			       
					<jsp:useBean id="now" class="java.util.Date" />
					<c:set var="todaydate">
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" type="date" />
					</c:set>
					<c:set var="enddate">
						<fmt:formatDate value="${customerClaims.enddate}" pattern="yyyy-MM-dd" type="date" />
					</c:set>
			        <br/>保险起始日期：<fmt:formatDate value="${customerClaims.startdate}" type="date" dateStyle="long" />
			        <br/>保险终止日期：<fmt:formatDate value="${customerClaims.enddate}" type="date" dateStyle="long" />
				</div>
			    
			    <div class="am-g">
			      <div class="am-u-sm-12">
			        <form class="am-form">
			          <table class="am-table  am-table-hover table-main">
			            <thead>
			              <div style="width:35%; float:left; text-align:center; color:#0099FF;">理赔时间</div>
			              <div style="width:35%; float:left; text-align:center; color:#0099FF;">理赔金额</div>
			              <div style="width:30%; float:left; text-align:center; color:#0099FF;">理赔状态</div>
			          </thead>
			          <tbody>
			          
			          	<c:forEach items="${customerClaims.claimRecord}" var="customerClaimsRecord">
				            <tr>
				              <td colspan="2" style="width:35%;  text-align:center; font-size:14px;">
								<fmt:formatDate value="${customerClaimsRecord.claimsdate}" type="date" dateStyle="long"/>
							  </td>
				              <td style="width:35%;  text-align:right;">${customerClaimsRecord.claimsamount}</td>
				              <td style="width:30%;  text-align:center;">${customerClaimsRecord.claimsStatus} </td>
				            </tr>
				         </c:forEach>
			          </tbody>
			        </table>
			         <!-- 翻页 -->
			          <div class="am-cf">
						  <div class="am-fr">
						    <ul class="am-pagination">
						      <li >
						      	<c:if test="${fn:length(customerClaimsList) != 1  }">
									<c:if test="${status.index +1 != 1  }">
										<a href="#" name='Forward' onclick='swipeRightPage()'>«</a>
									</c:if>
								</c:if>
						      </li>
						      <li class="am-active"><a href="#">${status.index +1}/${fn:length(customerClaimsList)}</a></li>
						      <li>
						      <c:if test="${fn:length(customerClaimsList) != 1  }">
								<c:if test="${status.index +1 != fn:length(customerClaimsList) }">
									<a href="#" name='Backward' onclick='swipeLeftPage()' >»</a>
								</c:if>
							  </c:if>
						      </li>
						    </ul>
						  </div>
					  </div>
			        
					  
			        </form>
			      </div>
			
			    </div>  <!--  /am-g -->
			        
			</div>	<!-- /admin-content -->
		</div>
	  </div>
		
		
	</c:forEach>


 <script>
	$(document).ready(function(){
		initShow();
	});
	function initShow(){	//显示第一页
		$(".thePage").first().attr('style','display:;');
	}
 </script>
</body>
</html>
