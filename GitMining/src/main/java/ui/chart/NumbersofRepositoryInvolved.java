package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetJoinRepositoryStatistic;

public class NumbersofRepositoryInvolved extends JPanel{

	public NumbersofRepositoryInvolved (UserStatisticFactory userStatisticFactory, int width, int height) {
		GetJoinRepositoryStatistic joinRepositoryStatistic = userStatisticFactory.GetJoinRepository();
		List<JoinRepositoryStatistics> joinRepositoryList = joinRepositoryStatistic.getJoinRepositoryStatistic();
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		lineChart.setTitle("Numbers of Repository Involved By Users in each Year");
		
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
		A.setName("Repository");
		A.putChartColor(Color.GREEN);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		//获取参与项目数量
		for (int i = 0; i < joinRepositoryList.size(); i++) {
			lineChart.addXScaleText(joinRepositoryList.get(i).getYear());
			A.addChartValue(joinRepositoryList.get(i).getNum());
		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
		NumbersofRepositoryInvolved userChart = new NumbersofRepositoryInvolved(userStatisticFactory, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(userChart);
		frame.pack();
	}
}
