package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import Info.RepStatisticInfo.StarStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetStarStatistic;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;

public class StarLine extends JPanel{

	public StarLine(RepositoryStatisticFactory repositoryFactory, int width, int height) {
		GetStarStatistic starStatistic = repositoryFactory.GetStar();
		List<StarStatistics> starList = starStatistic.getStarStatistic();
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		
		Element A = new Node();
		A.setName("Fork");
		A.putChartColor(Color.GREEN);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		// 获取star数量
		for (int i = 0; i < starList.size(); i++) {
			lineChart.addXScaleText(starList.get(i).getStar());
			A.addChartValue(starList.get(i).getNums());
		}
//		for (int i = 2007; i < 2016; i++) {
//			lineChart.addXScaleText(" " + i);
//			A.addChartValue(Math.random() * 50);
//		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
}
