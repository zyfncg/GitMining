/**
 * 推荐模块所需要的图表
 */

/**
 *雷达图 
 */
function radar(id) {
	//TODO test
	var myChart = echarts.init(document.getElementById(id));
	option = {
//			title : {
//			text : '项目成功所受因素影响'
//			},
			tooltip : {},
			legend : {
				data : [ 'Estimation', 'Actual' ]
			},
			radar : {
				// shape: 'circle',
				indicator : [ {
					name : 'Language',
					max : 6500
				}, {
					name : 'Developer',
					max : 16000
				}, {
					name : 'Tea',
					max : 30000
				}, {
					name : '团队模式',
					max : 38000
				}, {
					name : '创意',
					max : 52000
				}, {
					name : 'Market',
					max : 25000
				} ]
			},
			series : [ {
				name : '预估 vs 实际',
				type : 'radar',
				// areaStyle: {normal: {}},
				data : [
				        {
				        	value : [ 4300, 10000, 28000, 35000,
				        	          50000, 19000 ],
				        	          name : '预估'
				        },
				        {
				        	value : [ 5000, 14000, 28000, 31000,
				        	          42000, 21000 ],
				        	          name : '实际'
				        } ]
			} ]
	};
	myChart.setOption(option);
}