<%@ page contentType="text/html; charset=utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>富邦财险</title>
<%@ include file="/webpage/fo/common/fotags.jsp" %>
<style type="text/css">
body{ background:url(${webRoot}/plug-in/fo/images/rank_1.jpg) scroll center no-repeat; margin:0 auto; height:766px; width:100%;}
.feng_rank_text_1{ text-align:center; color:#3b302b; margin:0 auto;}
table{ margin:0 auto; text-align:center; font-size:0.75em; color:#3b302b; line-height: 22px;}
.feng_left{ padding-left:2%;}
</style>
</head>
<body>
 <div style="height:75px;">&nbsp;</div>
 <div class="feng_rank_text_1">
 <table width="300" border="0" >
  <tr>
    <td style="font-weight:700; width:14%;"class="feng_left">排名</td>
    <td style="font-weight:700; width:28%;">用户</td>
    <td style="font-weight:700; width:28%;">保费</td>
    <td style="font-weight:700; width:28%;">称号</td>
  </tr>
  <c:forEach items="${customerPremRankingList}" var="customerPremRankings">
  	<!-- 如果当前用户保费在前20名中则显示为#ffff33色 -->
  	<c:choose>
  		<c:when test="${customerPremRankings.rank == rank }">	
		  <tr style="color:#ff0000;">
	    </c:when>
	    <c:otherwise>
	      <tr style="color:#000;">
	    </c:otherwise>
  	</c:choose>
  
		  	<td class="feng_left">${customerPremRankings.rank }</td>
		    <td>${customerPremRankings.customername }</td>
		    <td>
		    	<fmt:formatNumber pattern="###,###,###.00" value="${customerPremRankings.premium }"></fmt:formatNumber>
		    </td>
		    <td>${customerPremRankings.honor_name }</td>
		  </tr>
  </c:forEach>
  
	<c:choose>
		<c:when test="${customerPremRanking != null }">
	    <tr style="color:#ff0000;">
	      <td class="feng_left">${customerPremRanking.rank }</td>
	      <td>${customerPremRanking.customername }</td>
	      <td>
	      <fmt:formatNumber value="${customerPremRanking.premium }"></fmt:formatNumber>
		  </td>
	      <td>
			${customerPremRanking.honor_name }
	      </td>
	    </tr>
	    </c:when>
	</c:choose>
				
</table>

</div>

</body>
</html>
