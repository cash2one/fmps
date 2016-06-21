<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
.am-modal-bd {
 
  border-bottom: 0px solid #dedede;
  padding: 5px 10px;
}
.am-modal-footer {
  height: 1px;
}
.am-modal-hd {
  padding: 15px 10px 15px 10px;
   font-size: 15px;
}
</style>

<c:if test="${issubscribe==0}">

<div class="am-dimmer am-active" data-am-dimmer="" style="display: block;"></div>

<div class="am-modal am-modal-alert am-modal-active" tabindex="-1" id="my-alert" style="display: block; margin-top: -119px; ">
  <div class="am-modal-dialog" style="border-radius:10px;">
    <div class="am-modal-hd" style="font-family: '微软雅黑' 'Helvetica Neue', Helvetica, STHeiTi, sans-serif; ">您可能未关注富邦财险公众号，请先长按二维码关注。</div>
    <div class="am-modal-bd">
      <div class="erweima">
					<img id="QRcode"
						src="${webRoot}/plug-in/fo/images/weixinQ.png"
						width="130" height="130" />
				</div>
				 <div class="am-modal-hd" style="font-size: 11px;">如果长按二维码不能识别，可以搜索富邦财险进行关注。</div>
   
    </div>
     <div class="am-modal-footer">
     <!--  <span class="am-modal-btn" onclick="reload();">关 闭</span>  -->
    </div>
  </div>
</div>

</c:if>
<script>
function reload(){
	//$("#my-alert").attr("style","display: none; margin-top: -119px;");
	//$("#my-alert").attr("style","display: block; margin-top: -119px;");
	//window.setTimeout(load(),500);
	
	//$("#my-alert").css('display','none'); 
	//$("#my-alert").css('display','block'); 
	
	 location.reload();
}
function load(){
	//$("#my-alert").attr("style","display: block; margin-top: -119px;");
}

</script>