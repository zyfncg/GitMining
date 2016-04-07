package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.UsrStatisticInfo.CatalogStatistics;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.PieChart;
import ui.component.EmptyPanel;

/**
 *用户类型统计面板 
 */
@SuppressWarnings("serial")
public class UserType extends JPanel{

	public UserType(List<CatalogStatistics> userTypeList, int width, int height) {
		TDataBox box = new TDataBox();
		PieChart pieChart = new PieChart(box);
		//设置不可拖动
		pieChart.setEnableXTranslate(false);
		pieChart.setEnableYTranslate(false);
		//设置不可缩放
		pieChart.setEnableXZoom(false);
		pieChart.setEnableYZoom(false);
		
		for (int i = 0; i < userTypeList.size(); i++) {
			Element element = new Node();
			element.setName(userTypeList.get(i).getCatalog());
			element.putChartValue(userTypeList.get(i).getNum());
			if(i==1)
				element.putChartColor(Color.BLUE);
			else
				element.putChartColor(Color.RED);
			box.addElement(element);
		}
		pieChart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
		pieChart.setPreferredSize(new Dimension(width >> 1,height));
		Box b = Box.createHorizontalBox();
		b.add(new EmptyPanel(width >> 2, height));
		b.add(pieChart);
		b.add(new EmptyPanel(width >> 2, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		pieChart.setHollow(true);
		pieChart.setHollowPercent(0.2);
		this.add(b, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
//		UserType company = new UserType(userStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(company);
//		frame.pack();
//		frame.setVisible(true);
//	}
}
