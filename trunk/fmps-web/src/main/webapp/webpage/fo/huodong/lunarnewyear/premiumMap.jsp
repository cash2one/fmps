<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ include file="/webpage/fo/common/huodong-fotags.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>抢保额</title>
  <meta name="description" content="user data">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link href="${webRoot}/plug-in/huodong/lunarnewyear/css/spring.css" rel="stylesheet" type="text/css">
  <link href="${webRoot}/plug-in/weixin/zp/turnplate.css" rel="stylesheet" type="text/css">
</head>
<body style=" background-color:#8c0c0b;">
 	<div><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/map_title.jpg" /></div>
 	<div id="main" style="height:380px;"></div>
 	<div class="drow-count">您当前保额：<span>${amount}</span> 元，可抽奖次数：<span>${drowCount}</span> 次</div>
	<section class="award-carousel">
		  <div class="reward-title"><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/title_tp7.png" /></div>
		  <div class="award-description">
		  	<p>1. 特等奖5名，报销来回路费，最高1000元</p>
		  	<p>2. 一等奖20元红包/50个</p>
		  	<p>3. 二等奖10元红包/200个</p>
		  	<p>4. 三等奖5元红包/400个</p>
		  </div>
	</section>
	<div class="map" style="padding-top:10px;" onclick="goZPPage()" >前往抽奖专区</div>
	<div><img src="${webRoot}/plug-in/huodong/lunarnewyear/images/map-bottom.jpg" /></div>
	
	
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
    var hdid = "${hdid}";
    var peopleCount = ${peopleCount};
    var premiumCount = ${premiumCount};
    var peopleInProvince=${provinceList};
    var defaultPeopleInProvince =[
			{name: '北京',value: 0},
			{name: '天津',value: 0},
			{name: '上海',value: 0},
			{name: '重庆',value: 0},
			{name: '河北',value: 0},
			{name: '河南',value: 0},
			{name: '云南',value: 0},
			{name: '辽宁',value: 0},
			{name: '黑龙江',value: 0},
			{name: '湖南',value: 0},
			{name: '安徽',value: 0},
			{name: '山东',value: 0},
			{name: '新疆',value: 0},
			{name: '江苏',value: 0},
			{name: '浙江',value: 0},
			{name: '江西',value: 0},
			{name: '湖北',value: 0},
			{name: '广西',value: 0},
			{name: '甘肃',value: 0},
			{name: '山西',value: 0},
			{name: '内蒙古',value: 0},
			{name: '陕西',value: 0},
			{name: '吉林',value: 0},
			{name: '福建',value: 0},
			{name: '贵州',value: 0},
			{name: '广东',value: 0},
			{name: '青海',value: 0},
			{name: '西藏',value: 0},
			{name: '四川',value: 0},
			{name: '宁夏',value: 0},
			{name: '海南',value: 0},
			{name: '台湾',value: 0},
			{name: '香港',value: 0},
			{name: '澳门',value: 0}
                                  ]
    	//同一省份存在多条时，会覆盖，将默认数组与后台数据concat成新的数组
    	peopleInProvince = defaultPeopleInProvince.concat(peopleInProvince);
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'),"infographic"); 
/*                 myChart.showLoading({
                        text: '正在努力的读取数据中...',    //loading话术
                }); 
                
			$.ajax({
        			url:"${webRoot}/fo/lunarNewYearController.do?getPeopleInProvince",
        			dataType:"json",
        			data:{"hdid":hdid},
        			success:function(data){
        				if(data.obj){
        					peopleInProvince = data.obj;
        					myChart.hideLoading();
        				}
        			},
        			error:function(){
        				myChart.hideLoading();
        				alert("获取数据出错");
        			},
        			timeout:4000
        		}) */
                
                var option = {
                    title : {
                        text: '目前参与人数'+peopleCount+'人，已领取'+premiumCount+'元保额',
                        //subtext: '各省分布情况',
                        x:'center',
                        textStyle:{
                            fontSize: 12,
                            color: '#fff'
                        }   
                    },
                    tooltip : {
                        trigger: 'item'
                    },
                    
                    dataRange: {
                        min: 0,
                        max: 1000,
                        x: 'left',
                        y: 'bottom',
                        text:['高','低'],           // 文本，默认为数值文本
                        calculable : true,
                        textStyle:{color: '#fff'}
                    },
                   /*  legend: {
                        orient: 'vertical',
                        x:'left',
                        data:['premium'],
                    	textStyle:{color: '#333', fontSize: 10,},
                    }, */
                   
                   /*  roamController: {
                        show: true,
                        x: 'right',
                        mapTypeControl: {
                            'china': true
                        }
                    }, */
                    series : [
                        {
                            name: '',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            itemStyle:{
                                normal:{label:{show:true}},
                                emphasis:{label:{show:true}}
                            },
                            data: peopleInProvince	//后台获取
                            
                        },
                        
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
        
        //跳转抽奖页面 
        function  goZPPage(){
     	   location.href="${webRoot}/fo/lunarNewYearController.do?turnplatePage&productId=8a8195b3523334d4015233534e370018&version="+new Date();
          }
    </script>
	 	
	 
	 
</body>
</html>

