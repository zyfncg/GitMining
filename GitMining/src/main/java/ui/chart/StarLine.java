package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;
import Info.RepStatisticInfo.StarStatistics;

/**
 *项目star随着年份变化趋势的折线图面板 
 */
@SuppressWarnings("serial")
public class StarLine extends JPanel{

	public StarLine(List<StarStatistics> starList, int width, int height) {

		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		//设置不可拖动
		lineChart.setEnableXTranslate(false);
		lineChart.setEnableYTranslate(false);
		//设置不可缩放
		lineChart.setEnableXZoom(false);
		lineChart.setEnableYZoom(false);
		
		Element A = new Node();
		A.setName(Strings.Project.STAR_LABEL);
		A.putChartColor(Color.BLUE);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		// 获取star数量
		for (int i = 0; i < starList.size(); i++) {
			lineChart.addXScaleText(starList.get(i).getStar());
			A.addChartValue(starList.get(i).getNums());
		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		RepositoryStatisticFactory repositoryFactory = new RepositoryStatisticFactory();
//		StarLine userChart = new StarLine(repositoryFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
