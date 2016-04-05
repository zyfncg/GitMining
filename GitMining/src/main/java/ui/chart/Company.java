package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import Info.UsrStatisticInfo.CompanyStatistics;
import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

/**
 *用户所属公司统计面板 
 */
@SuppressWarnings("serial")
public class Company extends JPanel{

	public Company(List<CompanyStatistics> companyList, int width, int height) {
		TDataBox box = new TDataBox();
		BarChart barChart = new BarChart(box);
		
		//设置Y的尺度值是否可见，默认是不可见的
		barChart.setYScaleTextVisible(true);
		//设置Y最小的尺度值是否可见，默认是不可见的
		barChart.setYScaleMinTextVisible(true);
		//设置Y的最大尺度值
		barChart.setUpperLimit(50);
		//设置Y坐标的间距
		barChart.setYScaleValueGap(2);
		barChart.setFocusable(false);
		
		barChart.setXScaleTextOrientation(TWaverConst.ORIENTATION_SOUTH_EAST);
		//添加一个节点
		Element A = new Node();
		A.setName(Strings.User.COMPANY_LABEL);
		//设置chart的颜色
		A.putChartColor(Color.RED);
		//添加X轴上组的名称和数据
		for (int i = 0; i < companyList.size(); i++) {
			barChart.addXScaleText(companyList.get(i).getCompany());
			A.addChartValue(companyList.get(i).getNum());
		}
		box.addElement(A);
		//设置柱状图的显示样式
		barChart.setBarType(TWaverConst.BAR_TYPE_GROUP);
		//设置不可拖动
		barChart.setEnableXTranslate(false);
		barChart.setEnableYTranslate(false);
		//设置不可缩放
		barChart.setEnableYZoom(false);
		barChart.setEnableXZoom(false);
		//设置x轴显示为斜体
		barChart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
		barChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(barChart, BorderLayout.CENTER);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserStatisticFactory repositoryStatisticFactory = new UserStatisticFactory();
//		Company company = new Company(repositoryStatisticFactory, 1200, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(company);
//		frame.pack();
//		frame.setVisible(true);
//	}
}
