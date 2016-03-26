package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Info.RepStatisticInfo.TimeStatistics;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetTimeStatistic;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

public class UserCreateTime extends JPanel{

	public UserCreateTime(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetTimeStatistic userCreateTime = userStatisticFactory.GetCreatTime();
		List<TimeStatistics> userCreateList = userCreateTime.getTimeStatistic();
		TDataBox box = new TDataBox();
		BarChart barChart = new BarChart(box);
		//设置Y的尺度值是否可见，默认是不可见的
		barChart.setYScaleTextVisible(true);
		//设置Y最小的尺度值是否可见，默认是不可见的
		barChart.setYScaleMinTextVisible(true);
		//设置Y的最大尺度值
		barChart.setUpperLimit(10000);
		//设置Y坐标的间距
		barChart.setYScaleValueGap(2500);
		//添加一个节点
		Element A = new Node("A");
		A.setName("User");
		//设置chart的颜色
		A.putChartColor(Color.RED);
		//添加X轴上组的名称
		for (int i = 0; i < userCreateList.size(); i++) {
			barChart.addXScaleText(userCreateList.get(i).getYear());
			A.addChartValue(userCreateList.get(i).getNum());
		}
//		for (int i = 2007; i < 2016; i++) {
//			barChart.addXScaleText(i + "");
//			A.addChartValue(Math.random() * 10000);
//		}
		//TODO 添加chart value的值
//		A.addChartValue(20);
//		A.addChartValue(32);
		box.addElement(A);
		//设置柱状图的显示样式
		barChart.setBarType(TWaverConst.BAR_TYPE_GROUP);
		
		barChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(barChart, BorderLayout.CENTER);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserCreateTime userChart = new UserCreateTime(800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
