package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.BarChart;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;

public class CreateTimeofRepository extends JPanel{

	public CreateTimeofRepository(RepositoryStatisticFactory repositoryStatisticFactory, int width,int height) {
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
		for (int i = 2007; i < 2016; i++) {
			barChart.addXScaleText(i + "");
		}
		//TODO 添加chart value的值
		A.addChartValue(20);
		A.addChartValue(32);
		box.addElement(A);
		//设置柱状图的显示样式
		barChart.setBarType(TWaverConst.BAR_TYPE_GROUP);
		
		barChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(barChart, BorderLayout.CENTER);
	}
}
