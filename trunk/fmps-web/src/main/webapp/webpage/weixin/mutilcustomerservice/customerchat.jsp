<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>客服聊天窗口</title>
<t:base type="jquery,easyui,tools"></t:base>
<link href="${webRoot}/plug-in/fo/css/wechatclaims.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//检测窗口是否最小化
	function isMinStatus() { 
		var isMin = false; 
		if (window.outerWidth != undefined) { 
			isMin = window.outerWidth <= 160 && window.outerHeight <= 27; 
		} 
		else { 
			isMin = window.screenTop < -30000 && window.screenLeft < -30000; 
		} 
		return isMin; 
	}
	
	window.onload = function(){
		window.onfocus();
		//alert('onload...');
	}
	
	var is_Blur = false;	
	window.onblur = function(){
		is_Blur = true;
		//  alert('fired window blur event:'+is_Blur);
		//console.log('fired window blur event');
	} 
	
	window.onfocus = function(){
		is_Blur = false;
		 //alert('fired window onfocus event:'+is_Blur);
		//console.log('fired window blur event');
	} 
	//捕捉失去焦点事件
	function intervalOnblur(message){
		// alert(isBlur); //关闭消息提示
		if(is_Blur){
			alert(message); //关闭消息提示
		}
		is_Blur = false;
	}
	
	//检测是否转移焦点
	function isOnBlur(){		
	//	window.onfocus = function(){
	//		isBlur = true;	    
	//	}		
		alert(is_Blur);
	//	return isBlur;		
	}

	//捕捉ie最小化事件(调用)
    function intervalMinStatusClick(message){
		if(isMinStatus()){
			//alert(message);
		}
    }

	//禁止刷新 
	/* 
	document.onkeydown = function(){
	    if ( event.keyCode==116){
		    event.keyCode = 0;
		    event.cancelBubble = true;
		    return false;
	    }
	  };
	
	  //禁止右键弹出菜单
	  document.oncontextmenu = function(){
	  	return false;
	  };
	 */
	// 绑定右键菜单事件
	 function tabCloseEven(mainTabs) {
	 	// 刷新
	 	$('#mm-tabupdate').click(function() {
	 		var currTab = mainTabs.tabs('getSelected');
	 		var url = $(currTab.panel('options').content).attr('src');
	 		mainTabs.tabs('update', {
	 			tab : currTab,
	 			options : {
	 				content : createFrame(url)
	 			}
	 		})
	 	})
	 	// 关闭当前
	 	$('#mm-tabclose').click(function() {
	 		var currtab_title = $('#mm').data("currtab");
	 		mainTabs.tabs('close', currtab_title);
	 	})
	 	// 全部关闭
	 	$('#mm-tabcloseall').click(function() {
	 		$('.tabs-inner span').each(function(i, n) {
	 			var t = $(n).text();
	 			if(t != "首页"){
	 				mainTabs.tabs('close', t);
	 			}
	 		});
	 	});
	 	// 关闭除当前之外的TAB
	 	$('#mm-tabcloseother').click(function() {
	 		$('#mm-tabcloseright').click();
	 		$('#mm-tabcloseleft').click();
	 	});
	 	// 关闭当前右侧的TAB
	 	$('#mm-tabcloseright').click(function() {
	 		var nextall = $('.tabs-selected').nextAll();
	 		if (nextall.length == 0) {
	 			return false;
	 		}
	 		nextall.each(function(i, n) {
	 			var t = $('a:eq(0) span', $(n)).text();
	 			mainTabs.tabs('close', t);
	 		});
	 		return false;
	 	});
	 	// 关闭当前左侧的TAB
	 	$('#mm-tabcloseleft').click(function() {
	 		var prevall = $('.tabs-selected').prevAll();
	 		if (prevall.length == 0) {
	 			return false;
	 		}
	 		prevall.each(function(i, n) {
	 			var t = $('a:eq(0) span', $(n)).text();
	 			if(t =="首页") return false;
	 			mainTabs.tabs('close', t);
	 		});
	 		return false;
	 	});

	 	// 退出
	 	$("#mm-exit").click(function() {
	 		$('#mm').menu('hide');
	 	});
	 }
	 
	 function tabClose() {
			/* 为选项卡绑定右键 */
			$(".tabs-inner").live('contextmenu', function(e) {
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
				var subtitle = $(this).children(".tabs-closable").text();
				$('#mm').data("currtab", subtitle);
				return false;
			});
	}
	$(function() {
		var mainTabs = $('#maintabs');
		tabClose();
		tabCloseEven(mainTabs);
		//快捷定位案件号
		$("#kopenTab").click(
				function() {
					var kregistno = $("#kregistno").val();//输入的registno
					if (kregistno == "") {
						$.messager.alert('温馨提示', '请输入接入的案件号！');
						return;
					}
					var s_title = $("#title" + kregistno).val();
					var registno = $("#registno" + kregistno).val();
					var openid = $("#openid" + kregistno).val();
					var operatorcode = $("#operatorcode" + kregistno).val();
					var rolecode = $("#rolecode" + kregistno).val();
					if (s_title == "" || s_title == undefined || 
							registno == "" || registno == undefined || 
							openid == ""   || openid == undefined || 
							operatorcode == "" || operatorcode == undefined || 
							rolecode == undefined || rolecode =="") {
						$.messager.alert('温馨提示', '未找到对应案件号！');
						return;
					}
					openTab(registno, registno, openid, operatorcode,rolecode);
					
					//设置案件列表激活的样式
					$("#firstpane div.menu_head").siblings().removeClass("current");
					var headdiv = $("div[name='"+registno+"']");
					headdiv.addClass("current");
					//定位
					var oInput = document.getElementById("focus"+registno);
					oInput.focus();
		});
		
		//tabs事件（激活，捕捉每个子tab）
		mainTabs.tabs({
			onSelect: function(title,index) {//选中当前tab事件,每次关闭都自动选中前一个tab
				//设置主页的隐藏域当前激活的案件
				$("#activedRegistNo").val(title);
				
				//设置案件列表激活的样式
				$("#firstpane div.menu_head").siblings().removeClass("current");
				var headdiv = $("div[name='"+title+"']");
				headdiv.addClass("current");
				
				//清空激活案件列表的消息为0
			    $("#menu_head_count_msg"+title).html(" <div class=\"menu_head_content_msg_count2\">0</div>");
			},
			onUpdate:function (title,index){
			
			},
	        onAdd: function(title,index) {//关闭之后的操作
	        
	        },
	        onBeforeClose:function(title,index){//关闭之前操作
	        
	        },
	        onClose: function(title,index) {//关闭之后的操作
	        	
	        }
		});
	});
	 
</script>
</head>
<body class="easyui-layout">
	<input type="hidden" id="customerServiceImageUrl" value="${userImageUrl}">
	<input type="hidden" id="activedRegistNo" value="">
	<!-- 左侧-->
	<div region="west" split="true"
		href="${webRoot}/wechatClaims/CustomerChat.do?registNoListIndex&operatorCode=${operatorCode}&roleCode=${roleCode}&notReadCount=${totalNotReadedMessageCount}"
		title="案件列表" class="main_left">
	</div>

	<!-- 中间-->
	<div id="mainPanle" region="center">

		<div id="maintabs" class="easyui-tabs" fit="true" border="false">
			<div title="首页" class="main_right">
				<div class="main_right_auto">
					<div class="main_right_title">
					  欢迎使用微信闪赔实时对接系统
						<!-- <img src="${webRoot}/plug-in/fo/images/customerwechat/main_title.jpg" alt="多客服系统" /> -->
					</div>
					<div class="main_right_title1">
						<img src="${webRoot}/plug-in/fo/images/customerwechat/title_1.jpg" alt="#" />
					</div>
					<div class="main_right_notprocessed">
						<div class="main_right_registnocount">
							<div class="main_right_registnocount_icon">
								<img src="${webRoot}/plug-in/fo/images/customerwechat/icon_1.jpg" width="120" height="120" />
							</div>
							<div class="main_right_registnocount_content" id="main_right_registnocount_content">
								当前未处理的案件数量为${registNoCount}个
							</div>
						</div>
						<div class="main_right_totalNotReadedMessageCount">
							<div class="main_right_totalNotReadedMessageCount_icon">
								<img src="${webRoot}/plug-in/fo/images/customerwechat/icon_2.jpg" width="120" height="120" />
							</div>
							<div class="main_right_totalNotReadedMessageCount_content" id="main_right_totalNotReadedMessageCount_content">
								当前未读信息数量为${totalNotReadedMessageCount}条
							</div>
						</div>
					</div>
					<div class="main_right_title2">
						<img src="${webRoot}/plug-in/fo/images/customerwechat/title_2.jpg" alt="#" />
					</div>
					<div class="main_right_quickaccess">
						<div class="main_right_title3">
							<img src="${webRoot}/plug-in/fo/images/customerwechat/title_3.jpg" alt="#" />
						</div>
						<div class="main_right_quickaccess_content">
							<div>快速接入会话</div>
							<div class="main_right_quickaccess_content_padding">
								<input id="kregistno" class="easyui-textbox" style="height: 20px;width: 180px;" placeholder="请输入案件号">
							</div>
							<div class="main_right_quickaccess_content_link">
								<a href="#" id="kopenTab" class="easyui-linkbutton">接入</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- 图片放大窗口 -->
	<div id="w" class="easyui-window" title="image" data-options="modal:true,inline:false,closed:true,minimizable:false,collapsible:false" style="width:1000px;height:600px;padding:5px;">
			<img id="img" alt=""/>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabupdate">刷新</div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
	</div>
</body>
</html>