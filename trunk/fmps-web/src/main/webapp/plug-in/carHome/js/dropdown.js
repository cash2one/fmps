;(function($) {
	$dropdown = $('.fb-dropdown dt a');
	$downlist = $('.downlist');

	$dropdown.click(function(){
		var $t=$(this);
		if($t.hasClass('up')){
			$dropdown.removeClass('up');
			$downlist.hide();
			$(".fb-secondary-dropdown").hide();
		}else{
			$dropdown.removeClass('up');
			$downlist.hide();
			$t.addClass('up');
			$downlist.eq($dropdown.index($(this)[0])).show();
			$(".fb-secondary-dropdown").css({"display":"block","height": $(".fb-secondary-dropdown").siblings("ul").height()});

			$dropdown.each(function(index,element){
				$dropdown.parent().siblings("dd").find("a:contains('"+$(element).text()+"')").addClass('selected');
				
			})
		}
	});

	

	// 在我们插件容器内，创造一个公共变量来构建一个私有方法
	var privateFunction = function() {
        
	// code here
    }
 
	// 通过字面量创造一个对象，存储我们需要的共有方法
    var methods = {
        
	// 在字面量对象中定义每个单独的方法
        init: function(option) {
		// 为了更好的灵活性，对来自主函数，并进入每个方法中的选择器其中的每个单独的元素都执行代码
            return this.each(function() {
            	var $this = $(this);
            	var jsonData = option;
	 			var item ="";
	 			var childrenItem ="";
	 			for (var i = 0; i < jsonData.length; i++) {
	 				var obj = jsonData[i];
	 				for (var j in obj) {
	 					if(j === "firstName"){
	 						 item +='<li><a href="#"><span>'+obj[j]+'</span><span class="keep-right">'+obj['firstCount']+'</span></a></li>';
	 					}
	 					
	 				};
	 			};
				var firstObj = jsonData[0];
				var childObj =firstObj['children'];
				for (var i = 0; i < childObj.length; i++) {
					var obj = childObj[i];
					childrenItem +='<li><a href="#"><span>'+obj['secondName']+'</span><span class="keep-right">'+obj['secondCount']+'</span><span style="display:none;">'+obj['secondId']+'</span></a></li>';
				};

	            $this.find(".second-stage").html(item);
	            $(".fb-secondary-dropdown").html(childrenItem);
	            
	            //点击左侧，右侧内容变化
				 $(".second-stage a").each(function(index,element){
													
				 	var firstObj = jsonData[index];
				 	$(this).on("click",function(){
						$(".second-stage a").removeClass("selected");
						$(this).addClass("selected");
				 		childrenItem ="";
						var childObj =firstObj['children'];
						for (var i = 0; i < childObj.length; i++) {
							var obj = childObj[i];
							childrenItem +='<li><a href="#"><span>'+obj['secondName']+'</span><span class="keep-right">'+obj['secondCount']+'</span><span style="display:none;">'+obj['secondId']+'</span></a></li>';
						};
						$(".fb-secondary-dropdown").html(childrenItem);
						methods.selectedRight();
					});
				});
				methods.selectedRight();
				methods.selectedSingle();
				methods.selectedOrder();
				methods.selectedCity();
		// 为每个独立的元素创建一个jQuery对象
 
                
		// 例如： privateFunction();
            });
        }, /*end init*/


        //右侧选择操作，
		 selectedRight: function(){
			 $(".fb-secondary-dropdown a").each(function(index,element){
					$(this).on("click",function(){
						var selectedId = $(this).find("span:last").text();
						var selectedName = $(this).find("span:first").text();
						$("#classify").text(selectedName);
						$("#classify").attr("classifyId",selectedId);
						$(".fb-secondary-dropdown li a").removeClass('selected');
						$dropdown.removeClass('up');
						$downlist.hide();
						$(".fb-secondary-dropdown").hide();
				  });
			});
		 },
		  //单排选择，选中事件
		 selectedSingle: function(){
			 $(".city .downlist a").each(function(index,element){
					$(this).on("click",function(){
						var areaId = $(this).attr("aredId");
						var selectedName = $(this).text();
						$(".city ul li a").removeClass('selected');
						$("#wholeCity").text(selectedName);
						$("#wholeCity").attr("areaId",areaId);
						$dropdown.removeClass('up');
						$downlist.hide();
						$(".fb-secondary-dropdown").hide();
				  });
			});
		 },
		 /* 排序 */
		 selectedOrder: function(){
			$(".order .downlist a").each(function(index, element) {
				$(this).on("click", function() {
					var orderId = $(this).attr("orderId");
					var selectedName = $(this).text();
					$(".order ul li a").removeClass('selected');
					$("#order").text(selectedName);
					$("#order").attr("orderId",orderId);
					$dropdown.removeClass('up');
					$downlist.hide();
					$(".fb-secondary-dropdown").hide();
				});
			});
		 },
		 
		 selectedCity: function(){
	       	  //激活、取消下拉选项
			  $('.fb-singleDropdown a').off();
		      $('.fb-singleDropdown a').on('click',function(){
				      var $slide = $(this).parent().siblings('.citySlide');
				      $slide.css('display') == "block" ? $slide.hide(): $slide.show();
			  });

		      //选中选项
			  $('.citySlide').find('a').on('click',function(){
			     $('.citySlide').find('a').removeClass('citySelected');
			      $(this).addClass('citySelected');
			      $('.citySlide').find('li').removeClass('citySelected');
			      $(this).parent().addClass('citySelected');
			      var selectedName = $(this).text();
			      $(this).parents('.citySlide').siblings('.fb-singleDropdown').find('span').text(selectedName);
			      $(this).parents('.citySlide').hide();
			  });
	  
	       },
    };
 
   $.fn.dropdown = function() {
        
	// 获取我们的方法，遗憾的是，如果我们用function(method){}来实现，这样会毁掉一切的
        var method = arguments[0];
 
	// 检验方法是否存在
        if(methods[method]) {
			// 如果方法存在，存储起来以便使用
			// 注意：我这样做是为了等下更方便地使用each（）
            method = methods[method];
        
		// 如果方法不存在，检验对象是否为一个对象（JSON对象）或者method方法没有被传入
        } else if( typeof(method) == 'object' || !method ) {
        	//将参数arguments 的第一个参数转换成array
        	param = Array.prototype.slice.call(arguments, 0);
			// 如果我们传入的是一个对象参数，或者根本没有参数，init方法会被调用
            method = methods.init;
        } else {
            
		// 如果方法不存在或者参数没传入，则报出错误。需要调用的方法没有被正确调用
            $.error( 'Method ' +  method + ' does not exist on jQuery.dropdown' );
            return this;
        }
 
        
	// 调用我们选中的方法
        
	// 再一次注意我们是如何将each（）从这里转移到每个单独的方法上的
        return method.apply(this, param);
 
    }
})(jQuery);