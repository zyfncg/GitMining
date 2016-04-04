package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;

/**
 *用户参与项目数量统计面板 
 */
@SuppressWarnings("serial")
public class NumbersofRepositoryInvolved extends JPanel{

	public NumbersofRepositoryInvolved (List<JoinRepositoryStatistics> joinRepositoryList, int width, int height) {
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		//设置不可拖动
		lineChart.setEnableXTranslate(false);
		lineChart.setEnableYTranslate(false);
		//设置不可缩放
		lineChart.setEnableXZoom(false);
		lineChart.setEnableYZoom(false);
		
		Element A = new Node();
		A.setName(Strings.Project.REPOSITORY_LABEL);
		A.putChartColor(Color.GREEN);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		//获取参与项目数量
		for (int i = 0; i < joinRepositoryList.size(); i++) {
			lineChart.addXScaleText(joinRepositoryList.get(i).getYear());
			A.addChartValue(joinRepositoryList.get(i).getNum());
		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
//		NumbersofRepositoryInvolved userChart = new NumbersofRepositoryInvolved(userStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
