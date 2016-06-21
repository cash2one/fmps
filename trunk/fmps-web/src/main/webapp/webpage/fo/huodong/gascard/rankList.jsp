<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/webpage/fo/common/fotags.jsp"%>
<!doctype html>
<html>
<head>
<title>富邦财险</title>
<style type="text/css">
img {
	box-sizing: border-box;
	max-width: 100%;
	height: auto;
	vertical-align: middle;
	border: 0px none;
}

.am-topbar-inverse {
	background-color: #f4f1f0;
	border-color: #f4f1f0;
	color: #eeeeee;
}

.am-with-topbar-fixed-bottom {
	padding-bottom: 50px;
}

body {
	background: #f4f1f0;
}

.eleven_rank {
	padding: 0 15px;
}

.eleven_rank_img {
	margin: 0 auto;
	text-align: center;
	width: 55%;
	padding-top: 20px;
}

.eleven_rank_text {
	text-align: center;
	font-size: 12px;
	color: #222;
}

.eleven_table {
	text-align: center;
	font-size: 12px;
	padding-top: 5px;
	line-height: 25px;
}

.table_title {
	font-size: 14px;
	color: #37312e;
	font-weight: 700;
}

header {
	height: 50px;
	line-height: 50px;
	text-align: center;
	background: #303e49;
}

@media screen and (min-width: 320px) {
	header {
		height: 50px;
	}
}

@media screen and (min-width: 375px) {
	header {
		height: 60px;
	}
}

@media screen and (min-width: 768px) {
	header {
		height: 100px;
	}
}

td {
	text-align: center;
	font-style: 12px;
	color: #222;
	line-height: 27px;
}
</style>
</head>
<body>
	<div class="eleven_rank">
		<div class="eleven_rank_img">
			<img src="${webRoot}/plug-in/fo/images/pop_top_2.png" />
		</div>
		<c:if test="${rankList.size()>0}">
			<div class="eleven_rank_text">
				（更新时间：
				<fmt:formatDate value="${updateTime }"
					pattern="YYYY年MM月dd日 HH:mm:ss" />
				）
			</div>
		</c:if>
		<div class="eleven_table">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="25%" class="table_title">排名</td>
					<td width="50%" class="table_title">用户</td>
					<td width="25%" class="table_title">好友助力</td>
				</tr>
				<c:forEach items="${rankList}" var="rank" varStatus="rankINX">
					<tr>
						<td>${rankINX.index+1}</td>
						<td>${rank.nickname }</td>
						<td>${rank.cnt }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div style="height: 10px; clear: both;">&nbsp;</div>
	<header class="am-topbar am-topbar-inverse am-topbar-fixed-bottom">
		<div>
			<img src="${webRoot}/plug-in/fo/images/eleven_rank.jpg" />
		</div>
	</header>

</body>
</html>