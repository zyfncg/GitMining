
/**
 * 分析项目成功原因的所有图表
 */

/**
 * 样本中成功项目比非成功项目所占比例(扇形图)
 * Rate of successful projects
 */
function succRate(id, numSuccess, numFail) {
	var myChart = echarts.init(document.getElementById(id));
	myChart.setOption({
		title : {
			text : '成功项目与非成功项目所占比例'
		},
		series : [ {
			name : '项目情况',
			type : 'pie',
			radius : '55%',
			data : [ {
				value : numSuccess,
				name : '成功项目'
			}, {
				value : numFail,
				name : '非成功项目'
			}]
		} ]
	});
}

/**
 * 项目协作者数目的分布图
 * Distribution of collaborators in successful projects
 */
function CollaDistr(id, name, collaNums) {
	var myChart = echarts.init(document.getElementById(id));
	var data = echarts.dataTool.prepareBoxplotData([collaNums]);
    option = {
        title: [
            {
                text: name,
                left: 'center',
            },
            {
                text: 'upper: Q3 + 1.5 * IRQ \nlower: Q1 - 1.5 * IRQ',
                borderColor: '#999',
                borderWidth: 1,
                textStyle: {
                    fontSize: 14
                },
                left: '10%',
                top: '90%'
            }
        ],
        legend: {
            data: ['line', 'line2', 'line3']
        },
        tooltip: {
            trigger: 'item',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '10%',
            right: '10%',
            bottom: '15%'
        },
        xAxis: {
            type: 'category',
            data: data.axisData,
            boundaryGap: true,
            nameGap: 30,
            splitArea: {
                show: false
            },
            axisLabel: {
                formatter: 'expr {value}'
            },
            splitLine: {
                show: false
            }
        },
        yAxis: {
            type: 'value',
            name: '数量',
            splitArea: {
                show: true
            }
        },
        series: [
            {
                name: 'boxplot',
                type: 'boxplot',
                data: data.boxData,
                tooltip: {
                    formatter: function (param) {
                        return [
                            'Experiment ' + param.name + ': ',
                            'upper: ' + param.data[0],
                            'Q1: ' + param.data[1],
                            'median: ' + param.data[2],
                            'Q3: ' + param.data[3],
                            'lower: ' + param.data[4]
                        ].join('<br/>')
                    }
                }
            },
            {
                name: 'outlier',
                type: 'scatter',
                data: data.outliers
            }
        ]
    };
    myChart.setOption(option);
}

/**
 * 项目大牛占collaborator总数超过50%的比例(扇形图)
 * Rate of projects which Mr Big(excellent person) is more than
 * 50% of collaborator numbers in successful projects
 */
function MrBigOccupied(id, name, moreNum, lessNum) {
	var myChart = echarts.init(document.getElementById(id));
	option = {
			title : {
				text : name,
				subtext : '大牛占比',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				x : 'center',
				y : 'bottom',
				data : [ '超过50%', '低于50%' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'pie', 'funnel' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			series : [{
				name : '面积模式',
				type : 'pie',
				radius : [ 30, 110 ],
				center : [ '75%', 200 ],
				roseType : 'area',
				data : [ {
					value : moreNum,
					name : '超过50%'
				}, {
					value : lessNum,
					name : '低于50%'
				}]
			} ]
		};

		myChart.setOption(option);
}


/**
 * 各语言/各公司的项目个数(柱状图)
 */
function BarDistr(id, name, types, names, nums) {
	var myChart = echarts.init(document.getElementById(id));
	var option = {
			title : {
				text : name,
			},
			tooltip : {},
			legend : {
				data : [types]
			},
			xAxis : {
				data : [names]
			},
			yAxis : {},
			series : [ {
				name : types,
				type : 'bar',
				data : [nums]
			} ]
	};
	myChart.setOption(option);
}


