//test
function test(a) {
	var myChart = echarts.init(document.getElementById('main'));
	var option = {
			title : {
				text : '各种语言产生的优秀项目'
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
	alert(a);
}


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
	var option = {
			title : {
				text : '各种语言产生的优秀项目'
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
 * 成功项目协作者数目的分布图
 * Distribution of collaborators in successful projects
 */
function succCollaDistr() {
	//TODO test
	var myChart = echarts.init(document.getElementById('succCollaDistr'));
	myChart.setOption({
		title : {
			text : '各个成员的团队贡献情况'
		},
		series : [ {
			name : '团队贡献',
			type : 'pie',
			radius : '55%',
			data : [ {
				value : 400,
				name : '程序猿A'
			}, {
				value : 335,
				name : '程序猿B'
			}, {
				value : 310,
				name : '程序猿C'
			}, {
				value : 274,
				name : '程序猿D'
			}, {
				value : 235,
				name : '程序猿E'
			} ]
		} ]
	});
}

/**
 * 非成功项目的协作者数目的分布图
 * Distribution of collaborators in unsuccessful projects
 */
function unsuccCollaDistr() {
	//TODO test
	var myChart = echarts.init(document.getElementById('unsuccCollaDistr'));
	option = {
		title : {
			text : '一周commit情况'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '程序猿A', '程序猿B', '程序猿C', '程序猿D', '程序猿E' ]
		},
		toolbox : {
			feature : {
				saveAsImage : {}
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '程序猿A',
			type : 'line',
			stack : 'commit',
			areaStyle : {
				normal : {}
			},
			data : [ 120, 132, 101, 134, 90, 230, 210 ]
		}, {
			name : '程序猿B',
			type : 'line',
			stack : 'commit',
			areaStyle : {
				normal : {}
			},
			data : [ 220, 182, 191, 234, 290, 330, 310 ]
		}, {
			name : '程序猿C',
			type : 'line',
			stack : 'commit',
			areaStyle : {
				normal : {}
			},
			data : [ 150, 232, 201, 154, 190, 330, 410 ]
		}, {
			name : '程序猿D',
			type : 'line',
			stack : 'commit',
			areaStyle : {
				normal : {}
			},
			data : [ 320, 332, 301, 334, 390, 330, 320 ]
		}, {
			name : '程序猿E',
			type : 'line',
			stack : 'commit',
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			areaStyle : {
				normal : {}
			},
			data : [ 820, 932, 901, 934, 1290, 1330, 1320 ]
		} ]
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
	var dataAll = [
			[ [ 10.0, 8.04 ], [ 8.0, 6.95 ], [ 13.0, 7.58 ],
					[ 9.0, 8.81 ], [ 11.0, 8.33 ],
					[ 14.0, 9.96 ], [ 6.0, 7.24 ],
					[ 4.0, 4.26 ], [ 12.0, 10.84 ],
					[ 7.0, 4.82 ], [ 5.0, 5.68 ] ],
			[ [ 10.0, 9.14 ], [ 8.0, 8.14 ], [ 13.0, 8.74 ],
					[ 9.0, 8.77 ], [ 11.0, 9.26 ],
					[ 14.0, 8.10 ], [ 6.0, 6.13 ],
					[ 4.0, 3.10 ], [ 12.0, 9.13 ],
					[ 7.0, 7.26 ], [ 5.0, 4.74 ] ],
			[ [ 10.0, 7.46 ], [ 8.0, 6.77 ], [ 13.0, 12.74 ],
					[ 9.0, 7.11 ], [ 11.0, 7.81 ],
					[ 14.0, 8.84 ], [ 6.0, 6.08 ],
					[ 4.0, 5.39 ], [ 12.0, 8.15 ],
					[ 7.0, 6.42 ], [ 5.0, 5.73 ] ],
			[ [ 8.0, 6.58 ], [ 8.0, 5.76 ], [ 8.0, 7.71 ],
					[ 8.0, 8.84 ], [ 8.0, 8.47 ],
					[ 8.0, 7.04 ], [ 8.0, 5.25 ],
					[ 19.0, 12.50 ], [ 8.0, 5.56 ],
					[ 8.0, 7.91 ], [ 8.0, 6.89 ] ] ];

	var markLineOpt = {
		animation : false,
		label : {
			normal : {
				formatter : 'y = 0.5 * x + 3',
				textStyle : {
					align : 'right'
				}
			}
		},
		lineStyle : {
			normal : {
				type : 'solid'
			}
		},
		tooltip : {
			formatter : 'y = 0.5 * x + 3'
		},
		data : [ [ {
			coord : [ 0, 3 ],
			symbol : 'none'
		}, {
			coord : [ 20, 13 ],
			symbol : 'none'
		} ] ]
	};

	option = {
		title : {
			text : '项目成功原因分析散点图',
			x : 'center',
			y : 0
		},
		grid : [ {
			x : '7%',
			y : '7%',
			width : '38%',
			height : '38%'
		}, {
			x2 : '7%',
			y : '7%',
			width : '38%',
			height : '38%'
		}, {
			x : '7%',
			y2 : '7%',
			width : '38%',
			height : '38%'
		}, {
			x2 : '7%',
			y2 : '7%',
			width : '38%',
			height : '38%'
		} ],
		tooltip : {
			formatter : 'Group {a}: ({c})'
		},
		xAxis : [ {
			gridIndex : 0,
			min : 0,
			max : 20
		}, {
			gridIndex : 1,
			min : 0,
			max : 20
		}, {
			gridIndex : 2,
			min : 0,
			max : 20
		}, {
			gridIndex : 3,
			min : 0,
			max : 20
		} ],
		yAxis : [ {
			gridIndex : 0,
			min : 0,
			max : 15
		}, {
			gridIndex : 1,
			min : 0,
			max : 15
		}, {
			gridIndex : 2,
			min : 0,
			max : 15
		}, {
			gridIndex : 3,
			min : 0,
			max : 15
		} ],
		series : [ {
			name : '活跃程度和参与人数',
			type : 'scatter',
			xAxisIndex : [ 0 ],
			yAxisIndex : [ 0 ],
			data : dataAll[0],
			markLine : markLineOpt
		}, {
			name : '项目大小和项目成功关系',
			type : 'scatter',
			xAxisIndex : [ 1 ],
			yAxisIndex : [ 1 ],
			data : dataAll[1],
			markLine : markLineOpt
		}, {
			name : '项目创建时间与项目成功关系',
			type : 'scatter',
			xAxisIndex : [ 2 ],
			yAxisIndex : [ 2 ],
			data : dataAll[2],
			markLine : markLineOpt
		}, {
			name : '项目规模和人员配置关系',
			type : 'scatter',
			xAxisIndex : [ 3 ],
			yAxisIndex : [ 3 ],
			data : dataAll[3],
			markLine : markLineOpt
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
			text : '项目使用语言',
			subtext : '不同语言的项目分布',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			x : 'center',
			y : 'bottom',
			data : [ 'C', 'C++', 'Java', 'Python', 'C#', 'PHP',
					'Ruby', 'Other' ]
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
				name : 'C'
			}, {
				value : 5,
				name : 'C++'
			}, {
				value : 15,
				name : 'Java'
			}, {
				value : 25,
				name : 'Python'
			}, {
				value : 20,
				name : 'C#'
			}, {
				value : 35,
				name : 'PHP'
			}, {
				value : 30,
				name : 'Ruby'
			}, {
				value : 40,
				name : 'Other'
			} ]
		}, {
			name : '面积模式',
			type : 'pie',
			radius : [ 30, 110 ],
			center : [ '75%', 200 ],
			roseType : 'area',
			data : [ {
				value : 10,
				name : 'C'
			}, {
				value : 5,
				name : 'C++'
			}, {
				value : 15,
				name : 'Java'
			}, {
				value : 25,
				name : 'Python'
			}, {
				value : 20,
				name : 'C#'
			}, {
				value : 35,
				name : 'PHP'
			}, {
				value : 30,
				name : 'Ruby'
			}, {
				value : 40,
				name : 'Other'
			} ]
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
	option = {
			title : {
				text : '项目成功所受因素影响'
			},
			tooltip : {},
			legend : {
				data : [ '预估', '实际' ]
			},
			radar : {
				// shape: 'circle',
				indicator : [ {
					name : '语言',
					max : 6500
				}, {
					name : '技术人员',
					max : 16000
				}, {
					name : '团队气氛',
					max : 30000
				}, {
					name : '团队模式',
					max : 38000
				}, {
					name : '创意',
					max : 52000
				}, {
					name : '市场',
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

/**
 * 非成功项目中各语言的项目个数(柱状图)
 * Distribution of programming language
 * in unsuccessful projects
 */
function unsuccLangDistr() {
	
}

/**
 * 成功项目中各公司的项目个数(柱状图)
 * Distribution of company
 * in successful projects
 */
function succComDistr() {
	
}

/**
 * 非成功项目中各公司的项目个数(柱状图)
 * Distribution of programming language
 * in unsuccessful projects
 */
function unsuccComDistr() {
	
}

/**
 * 成功项目中团队类型为民主团队的项目比例(柱状图)
 * Rate of the two kind of team types
 * (management team or communication channel)
 * in successful projects
 */
function succTeamTypeRate() {
	
}

/**
 * 非成功项目中团队类型为民主团队的项目比例(柱状图)
 * Rate of the two kind of team types
 * (management team or communication channel)
 * in unsuccessful projects
 */
function unsuccTeamTypeRate() {
	
}