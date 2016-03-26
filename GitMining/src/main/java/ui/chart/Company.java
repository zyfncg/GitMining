package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCompanyStatistic;

public class Company extends JPanel{

	public Company(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetCompanyStatistic getCompanyStatistic = userStatisticFactory.GetCompany();
		List<CompanyStatistics> companyList = getCompanyStatistic.getCompanyStatistic();
		TDataBox box = new TDataBox();
		BarChart barChart = new BarChart(box);
		//设置Y的尺度值是否可见，默认是不可见的
		barChart.setYScaleTextVisible(true);
		//设置Y最小的尺度值是否可见，默认是不可见的
		barChart.setYScaleMinTextVisible(true);
		//设置Y的最大尺度值
		barChart.setUpperLimit(400);
		//设置Y坐标的间距
		barChart.setYScaleValueGap(100);
		//添加一个节点
		Element A = new Node("A");
		A.setName("User");
		//设置chart的颜色
		A.putChartColor(Color.RED);
		//添加X轴上组的名称和数据
		for (int i = 0; i < companyList.size(); i++) {
			barChart.addXScaleText(companyList.get(i).getCompany());
			A.addChartValue(companyList.get(i).getNum());
		}
//		barChart.addXScaleText("Shopify");
//		barChart.addXScaleText("GitHub");
//		barChart.addXScaleText("Google");
//		barChart.addXScaleText("Twitter");
//		barChart.addXScaleText("Facebook");
//		barChart.addXScaleText("Xamarln");
//		barChart.addXScaleText("Red Hat");
//		barChart.addXScaleText("Heroku");
//		barChart.addXScaleText("Microsoft");
//		barChart.addXScaleText("Mozilla");
//		barChart.addXScaleText("Chef");
//		barChart.addXScaleText("thoughtbot");
//		barChart.addXScaleText("Freelance");
//		for (int i = 0; i < 13; i++) {
//			A.addChartValue(Math.random() * 400);
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
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		UserStatisticFactory repositoryStatisticFactory = new UserStatisticFactory();
		Company company = new Company(repositoryStatisticFactory, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(company);
		frame.pack();
		frame.setVisible(true);
	}
}
