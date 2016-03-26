package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatRepositoryStatistic;

public class NumbersofRepositoryCreated extends JPanel{

	public NumbersofRepositoryCreated(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetCreatRepositoryStatistic createRepositoryStatistic = userStatisticFactory.GetCreatRepository();
		List<CreatRepositoryStatistics> createRepositoryList = createRepositoryStatistic.getCreatRepositoryStatistic();
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		
		Element A = new Node();
		A.setName("Repository");
		A.putChartColor(Color.RED);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		// 获取参与项目数量
		for (int i = 0; i < createRepositoryList.size() ; i++) {
			lineChart.addXScaleText(createRepositoryList.get(i).getYear());
			A.addChartValue(createRepositoryList.get(i).getNum());
		}
//		for (int i = 2007; i < 2016; i++) {
//			lineChart.addXScaleText(" " + i);
//			A.addChartValue(Math.random() * 2000);
//		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		NumbersofRepositoryCreated userChart = new NumbersofRepositoryCreated(800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
