<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="map" onclick="goActivityInfo()">点击查看红包奖品及活动规则说明 >></div>

<section class="reward-carousel">
	<div class="reward-title">
		<img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_1.png" />
	</div>
	<div class="reward-center" onclick="goYWXPage()">
		<div class="text_left">
			<div class="text_1">延长保障至一年</div>
			<div class="text_2">给常出行的自己一份保障，是对家人的负责</div>
		</div>
		<div class="text_right">
			<img src="${webRoot}/plug-in/huodong/lunarnewyear/images/right.png"
				width="8" height="15" />
		</div>
	</div>
	<div class="reward-center_2" onclick="goGZXPage()">
		<div class="text_left">
			<div class="text_1">老年骨折保障</div>
			<div class="text_2">他们经得起风雨，却经不起风险</div>
		</div>
		<div class="text_right">
			<img src="${webRoot}/plug-in/huodong/lunarnewyear/images/right.png"
				width="8" height="15" />
		</div>
	</div>
</section>
<div class="nbsp">&nbsp;</div>
<section class="reward-carousel-2">
	<div class="reward-title-2">
		<img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_3.png" />
	</div>
	<c:forEach items="${friendList }" var="friend">
		<div class="reward-center_3">
			<div class="text_left">${friend.nickname }</div>
			<div class="text_right">${friend.amount }元保额</div>
		</div>
	</c:forEach>
</section>
<div class="spring_foot">
	<div class="foot_text" onclick="goMapPage()"> 已为 <span class="col">${peopleCount}</span>人出行提供保障 >></div>
</div>
