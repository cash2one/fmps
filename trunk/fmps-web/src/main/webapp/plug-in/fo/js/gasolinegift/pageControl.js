 
   window.pt = 'wx';

    function $getCookie(name) {
        //读取COOKIE
        var reg = new RegExp("(^| )" + name + "(?:=([^;]*))?(;|$)"),
            val = document.cookie.match(reg);
        return val ? (val[2] ? unescape(val[2]) : "") : null;
    }

    function $getQuery(name, url) {
        //参数：变量名，url为空则表从当前页面的url中取
        var u = arguments[1] || window.location.search,
            reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"),
            r = u.substr(u.indexOf("\?") + 1).match(reg);
        return r != null ? r[2] : "";
    }
	
    window.debug = $getQuery('debug') == '1'?true:false;
    if (!$getQuery('code')) {
        var url = url || location.href.replace(/[?|&]code=[^&]*/g, '').replace(/[?|&]state=[^&]*/g, '').replace(/#.*/, '');
        /*location.href = 'http://open.weixin.qq.com/connect/oauth2/authorize?appid=wx47031447c8352579&redirect_uri=' + encodeURIComponent(url) + '&response_type=code&scope=snsapi_base&state=qqchongzhi#wechat_redirect';*/
    }

    (function(doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function() {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                var docElWidth = 100 * (clientWidth / 320);
                if (docElWidth > 200) docElWidth = 200;
                console.log(docElWidth);
                docEl.style.fontSize = docElWidth + 'px';
                };

        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);