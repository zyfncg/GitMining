package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import twaver.Element;
import twaver.Node;
import twaver.PopupMenuGenerator;
import twaver.TDataBox;
import twaver.TView;
import twaver.TWaverConst;
import twaver.chart.BarChart;
import Info.RepStatisticInfo.TimeStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetTimeStatistic;
import UserStatistic.GetUserStatistic.UserStatisticFactory;

public class CreateTimeofRepository extends JPanel{

	public CreateTimeofRepository(RepositoryStatisticFactory repositoryFactory, int width,int height) {
		GetTimeStatistic getTimeStatistic = repositoryFactory.GetTime();
		List<TimeStatistics> timeList = getTimeStatistic.getTimeStatistic();
		TDataBox box = new TDataBox();
		BarChart barChart = new BarChart(box);
		//设置Y的尺度值是否可见，默认是不可见的
		barChart.setYScaleTextVisible(true);
		//设置Y最小的尺度值是否可见，默认是不可见的
		barChart.setYScaleMinTextVisible(true);
		//设置Y的最大尺度值
		barChart.setUpperLimit(2000);
		//设置Y坐标的间距
		barChart.setYScaleValueGap(500);
		//添加一个节点
		Element A = new Node("A");
		A.setName("Repository");
		//设置chart的颜色
		A.putChartColor(Color.RED);
		//添加X轴上组的名称
		for (int i = 0; i < timeList.size(); i++) {
			barChart.addXScaleText(timeList.get(i).getYear());
			//获取数据
			A.addChartValue(timeList.get(i).getNum());
		}
		box.addElement(A);
		//设置柱状图的显示样式
		barChart.setBarType(TWaverConst.BAR_TYPE_GROUP);
		
		barChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(barChart, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RepositoryStatisticFactory repositoryStatisticFactory = new RepositoryStatisticFactory();
		CreateTimeofRepository company = new CreateTimeofRepository(repositoryStatisticFactory, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(company);
		frame.pack();
		frame.setVisible(true);
	}
	
}
