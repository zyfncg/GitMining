package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Utilities;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCompanyStatistic;
import res.Strings;

public class Company extends JPanel{

	public Company(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetCompanyStatistic getCompanyStatistic = userStatisticFactory.GetCompany();
		List<CompanyStatistics> companyList = getCompanyStatistic.getCompanyStatistic();
		TDataBox box = new TDataBox();
		BarChart barChart = new BarChart(box);
		
		barChart.setTitle("Numbers of Users in each Company");
		//设置Y的尺度值是否可见，默认是不可见的
		barChart.setYScaleTextVisible(true);
		//设置Y最小的尺度值是否可见，默认是不可见的
		barChart.setYScaleMinTextVisible(true);
		//设置Y的最大尺度值
		barChart.setUpperLimit(50);
		//设置Y坐标的间距
		barChart.setYScaleValueGap(2);
		barChart.setFocusable(false);
		//添加一个节点
		Element A = new Node("A");
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
