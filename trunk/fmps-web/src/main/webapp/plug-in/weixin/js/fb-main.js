/*input输入框清除*/
; (function($) {
  $.fn.textClear = function() {
		$(this).on({
			'focus' : function(e) {
				if($(this).val()!=null && ""!=($(this).val())){
					$(this).addClass('crossClear');
				}
			},
			'keypress' : function(e) {
				$(this).addClass('crossClear');
			},
			'focusout' : function() {
				$(this).removeClass('crossClear');
			},
			'click' : function(e) {
				if (($(this).hasClass('crossClear'))) {
					var mousePosInElement = e.pageX - $(this).position().left;
					if (mousePosInElement > $(this).width()) {
						$(this).removeClass('crossClear');
						$(this).val('');
					}
				}
			}
		});
	}
})(jQuery);

$(function() {
//usage 
	$('.noTextClear').textClear();
});