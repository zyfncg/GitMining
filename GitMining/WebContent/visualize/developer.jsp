<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/visualize/css/font.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>Developer</title>
</head>

<body>
	<%@include file="/visualize/common/navigation.jsp"%>

	<div class="container">
		<section class="col-md-12 ">
			<div class="col-lg-6 col-md-6 content" id="top">
				<div id="main" style="width: 600px; height: 600px;"></div>
				<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

          var option = {
            title: {
                text: '参与项目较多的用户及其参与项目数量'
            },
            tooltip: {},
            legend: {
                data:['User']
            },
            xAxis: {
                data: ["A","B","C","D","E","F"]
            },
            yAxis: {},
            series: [{
                name: 'User',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        myChart.setOption(option);
    </script>
			</div>
			<div class="col-lg-6 col-md-6 content" id="dot">
				<div id="dot" style="width: 600px; height: 600px;"></div>
				<script type="text/javascript">
				var myChart = echarts.init(document.getElementById('dot'));
				var dataAll = [
    			[
        [10.0, 8.04],
        [8.0, 6.95],
        [13.0, 7.58],
        [9.0, 8.81],
        [11.0, 8.33],
        [14.0, 9.96],
        [6.0, 7.24],
        [4.0, 4.26],
        [12.0, 10.84],
        [7.0, 4.82],
        [5.0, 5.68]
    ],
    [
        [10.0, 9.14],
        [8.0, 8.14],
        [13.0, 8.74],
        [9.0, 8.77],
        [11.0, 9.26],
        [14.0, 8.10],
        [6.0, 6.13],
        [4.0, 3.10],
        [12.0, 9.13],
        [7.0, 7.26],
        [5.0, 4.74]
    ],
    [
        [10.0, 7.46],
        [8.0, 6.77],
        [13.0, 12.74],
        [9.0, 7.11],
        [11.0, 7.81],
        [14.0, 8.84],
        [6.0, 6.08],
        [4.0, 5.39],
        [12.0, 8.15],
        [7.0, 6.42],
        [5.0, 5.73]
    ],
    [
        [8.0, 6.58],
        [8.0, 5.76],
        [8.0, 7.71],
        [8.0, 8.84],
        [8.0, 8.47],
        [8.0, 7.04],
        [8.0, 5.25],
        [19.0, 12.50],
        [8.0, 5.56],
        [8.0, 7.91],
        [8.0, 6.89]
    ]
];

var markLineOpt = {
    animation: false,
    label: {
        normal: {
            formatter: 'y = 0.5 * x + 3',
            textStyle: {
                align: 'right'
            }
        }
    },
    lineStyle: {
        normal: {
            type: 'solid'
        }
    },
    tooltip: {
        formatter: 'y = 0.5 * x + 3'
    },
    data: [[{
        coord: [0, 3],
        symbol: 'none'
    }, {
        coord: [20, 13],
        symbol: 'none'
    }]]
};

option = {
    title: {
        text: '个人能力与参与项目数量关系',
        x: 'center',
        y: 0
    },
    grid: [
        {x: '7%', y: '7%', width: '38%', height: '38%'},
        {x2: '7%', y: '7%', width: '38%', height: '38%'},
        {x: '7%', y2: '7%', width: '38%', height: '38%'},
        {x2: '7%', y2: '7%', width: '38%', height: '38%'}
    ],
    tooltip: {
        formatter: 'Group {a}: ({c})'
    },
    xAxis: [
        {gridIndex: 0, min: 0, max: 20},
        {gridIndex: 1, min: 0, max: 20},
        {gridIndex: 2, min: 0, max: 20},
        {gridIndex: 3, min: 0, max: 20}
    ],
    yAxis: [
        {gridIndex: 0, min: 0, max: 15},
        {gridIndex: 1, min: 0, max: 15},
        {gridIndex: 2, min: 0, max: 15},
        {gridIndex: 3, min: 0, max: 15}
    ],
    series: [
        {
            name: 'I',
            type: 'scatter',
            xAxisIndex: [0],
            yAxisIndex: [0],
            data: dataAll[0],
            markLine: markLineOpt
        },
        {
            name: 'II',
            type: 'scatter',
            xAxisIndex: [1],
            yAxisIndex: [1],
            data: dataAll[1],
            markLine: markLineOpt
        },
        {
            name: 'III',
            type: 'scatter',
            xAxisIndex: [2],
            yAxisIndex: [2],
            data: dataAll[2],
            markLine: markLineOpt
        },
        {
            name: 'IV',
            type: 'scatter',
            xAxisIndex: [3],
            yAxisIndex: [3],
            data: dataAll[3],
            markLine: markLineOpt
        }
    ]
};	
				myChart.setOption(option);
		 </script>
			</div>
		</section>

		<section class="col-md-12 ">
			<div class="col-lg-6 col-md-6 col-md-push-6 content" id="relation">
				<img src="/visualize/images/relation.png" alt="人物关系图"
					class="tm-image">
			</div>
			<div class="col-lg-6 col-md-6 col-md-pull-6 content" id="map">
				<img src="/visualize/images/map.png" alt="WorldMap" class="tm-image">
			</div>
			<h1>
				<%out.println(request.getAttribute("Message")); %>
			</h1>

		</section>

		<section class="col-md-12 content" id="clients">
			<div class="col-lg-6 col-md-6 content-item"></div>
			<div class="col-lg-6 col-md-6 content-item background flexbox">

			</div>
		</section>


		<section class="col-md-12 content" id="contact">
			<div class="col-lg-6 col-md-6 col-md-push-6 content-item"></div>
			<div
				class="col-lg-6 col-md-6 col-md-pull-6 content-item background flexbox">

			</div>
		</section>

		<footer class="col-md-12 content" id="externals">
			<div class="col-lg-6 col-md-6 last"></div>
			<div class="col-lg-6 col-md-6 background last about-text-container">

			</div>
		</footer>

	</div>

	<script src="/visualize/js/echarts.min.js"></script>
	<script src="/visualize/js/jquery.min.js"></script>
	<script src="/visualize/js/bootstrap.min.js"></script>
</body>
</html>