
/**
 * 分析项目成功原因的所有图表
 */

/**
 * 样本中成功项目比非成功项目所占比例(扇形图)
 * Rate of successful projects
 */
function succRate() {
	//TODO test
	var myChart = echarts.init(document.getElementById('succRate'));
	myChart.setOption({
		title : {
			text : '成功项目与非成功项目所占比例'
		},
		series : [ {
			name : '项目情况',
			type : 'pie',
			radius : '55%',
			data : [ {
				value : 400,
				name : '成功项目'
			}, {
				value : 335,
				name : '非成功项目'
			}]
		} ]
	});
}

/**
 * 成功项目协作者数目的分布图
 * Distribution of collaborators in successful projects
 */
function succCollaDistr() {
	//TODO test
	var myChart = echarts.init(document.getElementById('succCollaDistr'));
	var data = echarts.dataTool.prepareBoxplotData([
	                                                [850, 740, 900, 1070, 930, 850, 950, 980, 980, 880, 1000, 980, 930, 650, 760, 810, 1000, 1000, 960, 960],
	                                                [960, 940, 960, 940, 880, 800, 850, 880, 900, 840, 830, 790, 810, 880, 880, 830, 800, 790, 760, 800],
	                                                [880, 880, 880, 860, 720, 720, 620, 860, 970, 950, 880, 910, 850, 870, 840, 840, 850, 840, 840, 840],
	                                                [890, 810, 810, 820, 800, 770, 760, 740, 750, 760, 910, 920, 890, 860, 880, 720, 840, 850, 850, 780],
	                                                [890, 840, 780, 810, 760, 810, 790, 810, 820, 850, 870, 870, 810, 740, 810, 940, 950, 800, 810, 870]
	                                            ]);
    option = {
        title: [
            {
                text: '成功项目协作者数目分布图',
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
            name: 'km/s minus 299,000',
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
 * 非成功项目的协作者数目的分布图
 * Distribution of collaborators in unsuccessful projects
 */
function unsuccCollaDistr() {
	//TODO test
	var myChart = echarts.init(document.getElementById('unsuccCollaDistr'));
	var data = echarts.dataTool.prepareBoxplotData([
	                                                [850, 740, 900, 1070, 930, 850, 950, 980, 980, 880, 1000, 980, 930, 650, 760, 810, 1000, 1000, 960, 960],
	                                                [960, 940, 960, 940, 880, 800, 850, 880, 900, 840, 830, 790, 810, 880, 880, 830, 800, 790, 760, 800],
	                                                [880, 880, 880, 860, 720, 720, 620, 860, 970, 950, 880, 910, 850, 870, 840, 840, 850, 840, 840, 840],
	                                                [890, 810, 810, 820, 800, 770, 760, 740, 750, 760, 910, 920, 890, 860, 880, 720, 840, 850, 850, 780],
	                                                [890, 840, 780, 810, 760, 810, 790, 810, 820, 850, 870, 870, 810, 740, 810, 940, 950, 800, 810, 870]
	                                            ]);
    option = {
        title: [
            {
                text: '非成功项目协作者数目分布图',
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
            name: 'km/s minus 299,000',
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
 * 成功项目大牛占collaborator总数超过50%的比例(扇形图)
 * Rate of projects which Mr Big(excellent person) is more than
 * 50% of collaborator numbers in successful projects
 */
function succMrBigOccupied() {
	//TODO test
	var myChart = echarts.init(document.getElementById('succMrBigOccupied'));
	option = {
			title : {
				text : '成功项目大牛占collaborator总数超过50%的比例',
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
			series : [ {
				name : '半径模式',
				type : 'pie',
				radius : [ 20, 110 ],
				center : [ '25%', 200 ],
				roseType : 'radius',
				label : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				lableLine : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				data : [ {
					value : 10,
					name : '超过50%'
				}, {
					value : 5,
					name : '低于50%'
				} ]
			}, {
				name : '面积模式',
				type : 'pie',
				radius : [ 30, 110 ],
				center : [ '75%', 200 ],
				roseType : 'area',
				data : [ {
					value : 10,
					name : '超过50%'
				}, {
					value : 5,
					name : '低于50%'
				}]
			} ]
		};

		myChart.setOption(option);
}

/**
 * 非成功项目大牛占collaborator总数超过50%的比例(扇形图)
 * Rate of projects which Mr Big(excellent person) is more than
 * 50% of collaborator numbers in unsuccessful projects
 */
function unsuccMrBigOccupied() {
	//TODO test
	var myChart = echarts.init(document.getElementById('unsuccMrBigOccupied'));
	option = {
			title : {
				text : '成功项目大牛占collaborator总数超过50%的比例',
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
			series : [ {
				name : '半径模式',
				type : 'pie',
				radius : [ 20, 110 ],
				center : [ '25%', 200 ],
				roseType : 'radius',
				label : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				lableLine : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				data : [ {
					value : 10,
					name : '超过50%'
				}, {
					value : 5,
					name : '低于50%'
				} ]
			}, {
				name : '面积模式',
				type : 'pie',
				radius : [ 30, 110 ],
				center : [ '75%', 200 ],
				roseType : 'area',
				data : [ {
					value : 10,
					name : '超过50%'
				}, {
					value : 5,
					name : '低于50%'
				}]
			} ]
		};

		myChart.setOption(option);
}

/**
 * 成功项目中各语言的项目个数(柱状图)
 * Distribution of programming language
 * in successful projects
 */
function succLangDistr() {
	//TODO test
	var myChart = echarts.init(document.getElementById('succLangDistr'));
	var option = {
			title : {
				text : '成功项目各语言的项目个数'
			},
			tooltip : {},
			legend : {
				data : [ 'Language' ]
			},
			xAxis : {
				data : [ "C", "C++", "Java", "Python", "JavaScript",
				         "Other" ]
			},
			yAxis : {},
			series : [ {
				name : 'Language',
				type : 'bar',
				data : [ 51, 201, 361, 101, 101, 201]
			} ]
	};
	myChart.setOption(option);
}

/**
 * 非成功项目中各语言的项目个数(柱状图)
 * Distribution of programming language
 * in unsuccessful projects
 */
function unsuccLangDistr() {
	var myChart = echarts.init(document.getElementById('unsuccLangDistr'));
	var option = {
			title : {
				text : '非成功项目各语言的项目个数'
			},
			tooltip : {},
			legend : {
				data : [ 'Language' ]
			},
			xAxis : {
				data : [ "C", "C++", "Java", "Python", "JavaScript",
				         "Other" ]
			},
			yAxis : {},
			series : [ {
				name : 'Language',
				type : 'bar',
				data : [ 5, 20, 36, 10, 10, 20 ]
			} ]
	};
	myChart.setOption(option);
}

/**
 * 成功项目中各公司的项目个数(柱状图)
 * Distribution of company
 * in successful projects
 */
function succComDistr() {
	var myChart = echarts.init(document.getElementById('succComDistr'));
	var option = {
			title : {
				text : '成功项目中各公司的项目个数'
			},
			tooltip : {},
			legend : {
				data : [ 'Company' ]
			},
			xAxis : {
				data : [ "Google", "Facebook", "Apple", "Baidu", "Tencent",
				         "Other" ]
			},
			yAxis : {},
			series : [ {
				name : 'Company',
				type : 'bar',
				data : [ 150, 200, 360, 100, 100, 200 ]
			} ]
	};
	myChart.setOption(option);
}

/**
 * 非成功项目中各公司的项目个数(柱状图)
 * Distribution of programming language
 * in unsuccessful projects
 */
function unsuccComDistr() {
	var myChart = echarts.init(document.getElementById('unsuccComDistr'));
	var option = {
			title : {
				text : '非成功项目中各公司的项目个数'
			},
			tooltip : {},
			legend : {
				data : [ 'Company' ]
			},
			xAxis : {
				data : [ "Google", "Facebook", "Apple", "Baidu", "Tencent",
				         "Other" ]
			},
			yAxis : {},
			series : [ {
				name : 'Company',
				type : 'bar',
				data : [ 15, 120, 136, 110, 110, 120 ]
			} ]
	};
	myChart.setOption(option);
}

