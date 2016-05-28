/**
 * 推荐模块所需要的图表
 */

/**
 * 雷达图
 */
function radar(id, averageData, realData) {
	var myChart = echarts.init(document.getElementById(id));
	option = {
		tooltip : {},
		legend : {
			data : [ '平均值', '实际值' ]
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
			data : [ {
				value : averageData,
				name : '平均值'
			}, {
				value : realData,
				name : '实际值'
			} ]
		} ]
	};
	myChart.setOption(option);
}