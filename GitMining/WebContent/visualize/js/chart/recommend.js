/**
 * 推荐模块所需要的图表
 */

/**
 * 雷达图
 */
function radar(id, averageData, realData) {
	// TODO test
	var myChart = echarts.init(document.getElementById(id));
	option = {
//		 title : {
//		 text : '项目成功所受因素影响'
//		 },
		tooltip : {},
		legend : {
			data : [ 'Average', 'This' ]
		},
		radar : {
			// shape: 'circle',
			indicator : [ {
				name : 'contributor',
				max : 10
			}, {
				name : 'commit',
				max : 10
			}, {
				name : 'star',
				max : 10
			}, {
				name : 'pullRequest',
				max : 10
			}, {
				name : 'size',
				max : 10
			}, {
				name : 'issue',
				max : 10
			} ]
		},
		series : [ {
			name : 'Average vs This',
			type : 'radar',
			// areaStyle: {normal: {}},
			data : [ {
				value : averageData,
				name : 'Average'
			}, {
				value : realData,
				name : 'This'
			} ]
		} ]
	};
	myChart.setOption(option);
}