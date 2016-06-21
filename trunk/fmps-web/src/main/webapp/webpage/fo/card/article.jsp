<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%> 
<!doctype html>
<html class="no-js">
<head>
  <title>保险条款</title>
  <link href="${webRoot}/plug-in/fo/css/new.css" rel="stylesheet" type="text/css" />
</head>

<style type="text/css">
.am-selected-btn {
text-align: right;
width: 100px;
}


.am-btn-default {
border:0px;
}

.am-btn {
display: inline-block;
margin-bottom: 0;
padding: 0.225em 1em;}

.am-btn-primary{ width:96%;}
img{ 
  max-width: 100%;
  height: auto;
   }
   
header {
  height: 50px;
  line-height: 0px;
  }
  
.am-topbar {
  position: none;
  min-height: 0px;
  margin-bottom: 0rem;
  }
  .am-btn-success {
  color: #fff;
  background-color: #f8a3a8;
  border: 0px;
}
.am-header-default {
	background-color: #fff;
}

.am-header {
	position: relative;
	width: 100%;
	height: 49px;
	line-height: 49px;
	padding: 0 10px;
	border-bottom: 2px solid #0e90d2;
}
</style>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
 <header data-am-widget="header" class="am-header am-header-default">
    <h1 class="am-header-title" style="color: #171717;">
      保险条款
    </h1>
  </header>


  
</header>





 <section data-am-widget="accordion" class="am-accordion am-accordion-gapped"
data-am-accordion='{  }'>
<%-- <c:forEach var="i" items="${title}">
  <c:forEach var="j" items="${affiliatedstr}"> --%>
  <dl class="am-accordion-item" style="clear:both;">
     <c:forEach items="${affiliatedList}"	var="affiliated" varStatus="status">
      
          
     <dt class="am-accordion-title" style="background-color:#f5f5f5;">  ${affiliated.document}  <%-- <c:out value="${i}"/> --%></dt>
  
  
    <dd class="am-accordion-bd am-collapse"  style="height: 0px;">
      <!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
      <div class="am-accordion-content" style="font-size:0.625em;">
      
    ${affiliated.description}
     
      <%-- <c:out value="${j}"/> --%>             
     
    </div>
    </dd>
    </c:forEach> 
  </dl>
<%--   </c:forEach> 
   </c:forEach> --%>
  
</section>



</div>
  <!-- content end -->

</div>


<!--[if (gte IE 9)|!(IE)]><!-->
<!-- <script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script> -->
<!--<![endif]-->
<script src="${webRoot}/plug-in/amaze-ui/js/app.js"></script>
</body>
</html>