package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Info.UsrStatisticInfo.CatalogStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCatalogStatistic;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.PieChart;

public class UserType extends JPanel{

	public UserType(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetCatalogStatistic userType = userStatisticFactory.GetCatalog();
		List<CatalogStatistics> userTypeList = userType.getCatalogStatistic();
		TDataBox box = new TDataBox();
		PieChart pieChart = new PieChart(box);
		pieChart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
		
		Random random = new Random();
		for (int i = 0; i < userTypeList.size(); i++) {
			Element element = new Node();
			element.setName(userTypeList.get(i).getCatalog());
			element.putChartValue(userTypeList.get(i).getNum());
			element.putChartColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			box.addElement(element);
		}
//		Random random = new Random();
//		for (int i = 0; i < 6; i++) {
//			Element element = new Node();
//			element.setName("E" + i);
//			element.putChartValue(10 * (i + 1));
//			element.putChartColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
//			box.addElement(element);
//		}
		
		pieChart.setPreferredSize(new Dimension(width,height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(pieChart, BorderLayout.CENTER);
	}
}
