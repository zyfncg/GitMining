package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import Info.RepStatisticInfo.TimeStatistics;
import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

/**
 *项目创建时间统计面板 
 */
@SuppressWarnings("serial")
public class CreateTimeofRepository extends JPanel{

	public CreateTimeofRepository(List<TimeStatistics> timeList, int width,int height) {
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
		//设置不可拖动
		barChart.setEnableXTranslate(false);
		barChart.setEnableYTranslate(false);
		//设置不可缩放
		barChart.setEnableXZoom(false);
		barChart.setEnableYZoom(false);
		//添加一个节点
		Element A = new Node("A");
		A.setName(Strings.Project.REPOSITORY_LABEL);
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
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		RepositoryStatisticFactory repositoryStatisticFactory = new RepositoryStatisticFactory();
//		CreateTimeofRepository company = new CreateTimeofRepository(repositoryStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(company);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
}
