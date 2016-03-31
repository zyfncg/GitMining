package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatRepositoryStatistic;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;

/**
 *项目创建时间统计面板 
 */
@SuppressWarnings("serial")
public class NumbersofRepositoryCreated extends JPanel{

	public NumbersofRepositoryCreated(UserStatisticFactory userStatisticFactory, int width, int height) {
		GetCreatRepositoryStatistic createRepositoryStatistic = userStatisticFactory.GetCreatRepository();
		List<CreatRepositoryStatistics> createRepositoryList = createRepositoryStatistic.getCreatRepositoryStatistic();
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		Element A = new Node();
		A.setName("Repository");
		A.putChartColor(Color.RED);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		// 获取参与项目数量
		for (int i = 0; i < createRepositoryList.size() ; i++) {
			lineChart.addXScaleText(createRepositoryList.get(i).getYear());
			A.addChartValue(createRepositoryList.get(i).getNum());
		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
//		NumbersofRepositoryCreated userChart = new NumbersofRepositoryCreated(userStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
