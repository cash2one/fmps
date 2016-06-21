<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<style type="text/css">
	.am-table > thead > tr > th,
	.am-table > tbody > tr > th,
	.am-table > tfoot > tr > th,
	.am-table > thead > tr > td,
	.am-table > tbody > tr > td,
	.am-table > tfoot > tr > td {
	  padding: 0.1rem;
	  line-height: 1.6;
	  vertical-align:middle;
	  border-top: 1px solid #dddddd;
	}
	.am-titlebar {
	  margin-top: 5px;
	}
</style>
<script>
     var pageTotal=${fn:length(customerPolicyList)}; //总页面数量 
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

	<c:forEach items="${customerPolicyList}" var="customerPolicys" varStatus="status">
		<div  id="page${status.index +1}" class="thePage" style="display: none;">
			<header data-am-widget="header" class="am-header am-header-default">
			    <h1 class="am-header-title">
			      	${title}
			    </h1>
			</header>
			<div   class="am-cf admin-main">
				<div  	class="admin-content">
					 <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
	  					<h2 class="am-titlebar-title">用户信息</h2>
					 </div>
				 <div style="width:94%; margin:0 auto; border-bottom:1px 0 0 0 solid #ddd; height:auto; margin-bottom:10px; font-size:1em; padding:5px 0px 5px 5px;">       
					保单号：${customerPolicys.policyno}
			        <br/>被保险人：${customerPolicys.insuredname}
			        <br/>车牌号：${customerPolicys.licenseno}
			        <c:if test="${customerPolicys.licensed == 0  }">
							<span style="float: center; font-size: 1em; font-weight: normal;">
								<a href="${webRoot}/fo/binded/customerNewCarLicenceController.do?method=getCustomerNewCarLicence&openid=${openid}"
								style="text-decoration: none; float: right; padding-right: 10px;">新车上牌</a>
							</span>
					</c:if>
					<jsp:useBean id="now" class="java.util.Date" />
					<c:set var="todaydate">
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" type="date" />
					</c:set>
					<c:set var="enddate">
						<fmt:formatDate value="${customerPolicys.enddate}" pattern="yyyy-MM-dd" type="date" />
					</c:set>
			        <br/>保险起始日期：<fmt:formatDate value="${customerPolicys.startdate}" type="date" dateStyle="long" />
			        <br/>保险终止日期：<fmt:formatDate value="${customerPolicys.enddate}" type="date" dateStyle="long" />
			        <c:if test="${todaydate gt enddate}">
							<span style="color: red;font-size: 12px;"> 保单已过期</span>
					</c:if>
				</div>
			    
			    <div class="am-g">
			      <div class="am-u-sm-12">
			        <form class="am-form">
			          <table class="am-table  am-table-hover table-main">
			            <thead>
			              <div style="width:25%; float:left; text-align:center; color:#0099FF;">险种名称</div>
			              <div style="width:25%; float:left; text-align:center; color:#0099FF;">不计免赔</div>
			              <div style="width:25%; float:left; text-align:center; color:#0099FF;">保额</div>
			              <div style="width:25%; float:left; text-align:center; color:#0099FF;">费用</div>
			          </thead>
			          <tbody>
			          	<c:forEach items="${customerPolicys.customerPolicyDetailList}" var="customerPolicyDetails">
				            <tr>
				              <td style="width:25%;  text-align:center; font-size:14px;">${customerPolicyDetails.kindname }</td>
				              <td style="width:25%;  text-align:center;">${customerPolicyDetails.isdeductible }</td>
				              <td style="width:25%;  text-align:right;">
							  	<c:if test="${customerPolicyDetails.amount eq 0}">
								</c:if> 
								<c:if test="${customerPolicyDetails.amount ne 0}">
									<fmt:formatNumber value="${customerPolicyDetails.amount}" pattern="#,##0.00#" />
								</c:if>				
							  </td>
				              <td style="width:25%;  text-align:right;">
							  	<fmt:formatNumber value="${customerPolicyDetails.premium}" pattern="#,##0.00#" />
							  </td>
				            </tr>
				         </c:forEach>
				         <tr	>
							<td style="text-align:center; color:#FF6600;"" >合计</td>
							<td colspan="2"></td>
							<td style="text-align:right; color:#FF6600;"">
								<fmt:formatNumber	value="${customerPolicys.sumPremium}" pattern="#,##0.00#" />
							</td>
						</tr>
			          </tbody>
			        </table>
			        <!-- 翻页 -->
			          <div class="am-cf">
						  <div class="am-fr">
						    <ul class="am-pagination">
						      <li >
						      	<c:if test="${fn:length(customerPolicyList) != 1  }">
									<c:if test="${status.index +1 != 1  }">
										<a href="#" name='Forward' onclick='swipeRightPage()'>«</a>
									</c:if>
								</c:if>
						      </li>
						      <li class="am-active"><a href="#">${status.index +1}/${fn:length(customerPolicyList)}</a></li>
						      <li>
						      <c:if test="${fn:length(customerPolicyList) != 1  }">
								<c:if test="${status.index +1 != fn:length(customerPolicyList) }">
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