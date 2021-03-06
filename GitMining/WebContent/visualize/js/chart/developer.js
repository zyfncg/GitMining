/**
 * 开发者模块的图表显示
 */

/**
 *开发者地理位置分布图 
 */
function map(id, lat, long, cityName, value) {
	var myChart = echarts.init(document.getElementById(id));
	
	var attr = [];

	for(i = 0; i < lat.length; ++i) {
		attr.push("attr" + i);
	}
	
	var latlong = {};
	for(i = 0; i < lat.length; ++i) {
		latlong[attr[i]] = {'latitude': lat[i], 'longitude': long[i]};
	}
	var color;
	var mapData = [];

	for(i = 0; i < lat.length; ++i) {
		mapData[i] = {'code':latlong[attr[i]] , 'name':name[i], 'value':value[i], 'color':color};
	}
	
	function colorChoose(valueOne) {
		if(0 <valueOne< 50) {
			color = '#eea638';
		} 
		else if (50 <= valueOne < 100) {
			color = '#d8854f';
		}
		else if(100 <= valueOne < 150) {
			color = '#de4c4f';
		}
		else if(150 <= valueOne < 200) {
			color = '#86a965';
		}
		else if (valueOne >= 200) {
			color = '#8aabb0';
		} else {
			color = '#a7a737';
		}
	}
	
	for(i = 0; i < lat.length; ++i) {
		colorChoose(value[i]);
		mapData[i] = {'code':attr[i] , 'name':cityName[i], 'value':value[i], 'color':color};
	}
	
	var max = -Infinity;
	var min = Infinity;
	mapData.forEach(function (itemOpt) {
		if (itemOpt.value > max) {
			max = itemOpt.value;
		}
		if (itemOpt.value < min) {
			min = itemOpt.value;
		}
	});
	
	
	
	option = {
		backgroundColor: '#ffffff',
		title : {
			text: '开发者地理分布图',
			left: 'center',
			top: 'top',
			textStyle: {
				color: '#000'
			}
		},
		tooltip : {
			trigger: 'item',
			formatter : function (params) {
				var value = (params.value + '').split('.');
				value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,')
						+ '.' + value[1];
				return params.seriesName + '<br/>' + params.name + ' : ' + value;
			}
		},
		visualMap: {
			show: false,
			min: 0,
			max: max,
			inRange: {
				symbolSize: [6, 60]
			}
		},
		geo: {
			name: 'World Population (2010)',
			type: 'map',
			map: 'world',
			roam: true,
			label: {
				emphasis: {
					show: false
				}
			},
			itemStyle: {
				normal: {
					areaColor: '#233',
					borderColor: '#111'
				},
				emphasis: {
					areaColor: '#ff333d'
				}
			}
		},
		series : [
			{
				type: 'scatter',
				coordinateSystem: 'geo',
				data: mapData.map(function (itemOpt) {
					return {
						name: itemOpt.name,
						value: [
							latlong[itemOpt.code].longitude,
                        	latlong[itemOpt.code].latitude,
							itemOpt.value
						],
						label: {
							emphasis: {
								position: 'right',
								show: true
							}
						},
						itemStyle: {
							normal: {
								color: itemOpt.color
							}
						}
					};
				})
			}
		]
	};
    myChart.setOption(option);
}

/**
 *开发者社交网络图 
 */
function network(id, geoCoordMap, personName, Data) {
	var chart = echarts.init(document.getElementById(id));
	var planePath = 'path://M1705.06';

	var convertData = function (data) {
		var res = [];
		for (var i = 0; i < data.length; i++) {
			var dataItem = data[i];
			var fromCoord = geoCoordMap[dataItem[0].name];
			var toCoord = geoCoordMap[dataItem[1].name];
			if (fromCoord && toCoord) {
				res.push([{
					coord: fromCoord
				}, {
					coord: toCoord
				}]);
			}
		}
		return res;
	};
	
     var color = ['#ffa022'];
     var series = [];
    
     [[personName, Data]].forEach(function (item, i) {
    	    series.push({
    	        name: item[0],
    	        type: 'lines',
    	        zlevel: 1,
    	        effect: {
    	            show: true,
    	            period: 6,
    	            trailLength: 0.7,
    	            color: '#fff',
    	            symbolSize: 3
    	        },
    	        lineStyle: {
    	            normal: {
    	                color: color[i],
    	                width: 0,
    	                curveness: 0.2
    	            }
    	        },
    	        data: convertData(item[1])
    	    },
    	    {
    	        name: item[0],
    	        type: 'lines',
    	        zlevel: 2,
    	        effect: {
    	            show: true,
    	            period: 6,
    	            trailLength: 0,
    	            symbol: planePath,
    	            symbolSize: 15
    	        },
    	        lineStyle: {
    	            normal: {
    	                color: color[i],
    	                width: 1,
    	                opacity: 0.4,
    	                curveness: 0.2
    	            }
    	        },
    	        data: convertData(item[1])
    	    },
    	    {
    	        name: item[0],
    	        type: 'effectScatter',
    	        coordinateSystem: 'geo',
    	        zlevel: 2,
    	        rippleEffect: {
    	            brushType: 'stroke'
    	        },
    	        label: {
    	            normal: {
    	                show: true,
    	                position: 'right',
    	                formatter: '{b}'
    	            }
    	        },
    	        symbolSize: function (val) {
    	            return val[2] / 8;
    	        },
    	        itemStyle: {
    	            normal: {
    	                color: color[i]
    	            }
    	        },
    	        data: item[1].map(function (dataItem) {
    	            return {
    	                name: dataItem[1].name,
    	                value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
    	            };
    	        })
    	    });
    	});
     
     option = {
         backgroundColor: '#fdfdfd',
         tooltip : {
             trigger: 'item'
         },
         legend: {
             orient: 'vertical',
             top: 'bottom',
             left: 'right',
             data:[personName],
             textStyle: {
                 color: '#fff'
             },
             selectedMode: 'single'
         },
         geo: {
             map: 'world',
             label: {
                 emphasis: {
                     show: false
                 }
             },
             roam: true,
             itemStyle: {
                 normal: {
                     areaColor: '#326c98',
                     borderColor: '#404a59'
                 },
                 emphasis: {
                     areaColor: '#2a333d'
                 }
             }
         },
         series: series
     };
     // 使用刚指定的配置项和数据显示图表。
     chart.on('click', function (params) {
	    var city = params.name;
	    if(geoCoordMap.hasOwnProperty(city)) {
	    	window.location = "/DeveloperDetail?chooseDeveloper=" + city;
	    }
	 });
     chart.setOption(option);
}