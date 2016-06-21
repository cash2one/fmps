<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>条款详情</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3, user-scalable=yes">
<style>
 .am-accordion-gapped .am-accordion-item {
    border: 0px solid #dedede;
}
.am-accordion-gapped {
    margin: .1rem .1rem;
}

img {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0;
}
</style>
</head>
<body>
  <section class="am-accordion am-accordion-gapped">
      <dl class="am-accordion-item">
			<dd class="am-accordion-bd am-collapse am-in">
				<div class="am-accordion-content">
					<div id="document">${document}</div></div>
			</dd>
		</dl>
  </section>
</body>
</html>