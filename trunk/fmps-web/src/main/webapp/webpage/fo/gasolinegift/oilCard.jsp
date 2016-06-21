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
    <script src="${webRoot}/plug-in/fo/js/gasolinegift/pageControl.js"></script>
    <script type="text/javascript"> 
   
   function goToPay( applyId ){	   
		var oilcardPayUrl='${oilcardPayUrl}';
		var backUrl="${webRoot}/fo/binded/gasolinegift/gasolinegiftController/payNotify.do" ;
		var url=oilcardPayUrl+"?applyId="+applyId+"&devsimulatewxopenid=apitestxdcxvxcvdsfsd&backUrl="+ encodeURIComponent(backUrl);
	//	alert(url);
		location.href =url; 
	   
   }
   
   
   </script>
    <link rel="stylesheet" href="${webRoot}/plug-in/gasolinegift/css/card.css">
</head>

<body>
 <section class="container wx">
  <div class="container-hd">    
   <div class="top_tips">注：加油卡优惠期过后可以正常价格继续充值使用。</div>
 
  <c:forEach items="${gasolineGiftList}"	var="gasolineGift" varStatus="status">
  <div class="card">   
    <div class="info_1">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">持卡人：</div>
     <div class="info_right"> ${gasolineGift.username}</div>
    </div>
    <div class="info_1">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">车牌号：</div>
     <div class="info_right"> ${gasolineGift.licenseno}</div>
    </div>
    <div class="info_1">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">手机号：</div>
     <div class="info_right">${gasolineGift.mobile}</div>
    </div>
    <div class="info_1">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">优惠期限：</div>
         <c:if test="${gasolineGift.rchgDctExpire!=null}"> 
            <div class="info_right">${gasolineGift.rchgDctExpire}</div>
         </c:if>
         <c:if test="${gasolineGift.rchgDctExpire==null}"> 
           <div class="info_right">&nbsp;</div>
        </c:if>
    </div>
    <div class="info_1">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">卡状态：</div>
     <div class="info_right">${gasolineGift.applyStatus}&nbsp;&nbsp; 
         <c:if test="${gasolineGift.applyStatus=='待预充值'&&gasolineGift.applyId!=null&&gasolineGift.applyId!=''}"> 
           <a onclick="goToPay('${gasolineGift.applyId}')" > <span class="col">>去付款</span>  </a>
         </c:if>
      </div>
    </div>
    <div class="info_2">
     <div class="info_left">&nbsp;</div>
     <div class="info_middle">卡 号：</div>
     <div class="info_right">${gasolineGift.oilCardNo}</div>
    </div>    
   </div> 
   </c:forEach>

  </div>
 </section>
</body>
</html>