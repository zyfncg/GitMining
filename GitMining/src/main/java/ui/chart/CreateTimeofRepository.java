package ui.chart;

import java.awt.Color;

import javax.swing.JFrame;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverUtil;
import twaver.chart.BarChart;

public class CreateTimeofRepository {

	public CreateTimeofRepository() {
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
		//设置chart value
		A.putChartValue(50);
		box.addElement(A);
	}
}
