package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;
import Info.RepStatisticInfo.ForkStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetForkStatistic;
import res.Strings;

public class ForkLine extends JPanel{

	public ForkLine(RepositoryStatisticFactory repositoryFactory, int width, int height) {
		GetForkStatistic forkStatistic = repositoryFactory.GetFork();
		List<ForkStatistics> forkList = forkStatistic.getForkStatistic();
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		
		Element A = new Node();
		A.setName(Strings.Project.FORK_LABEL);
		A.putChartColor(Color.GREEN);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		//TODO 获取fork数量
		for (int i = 0; i < forkList.size(); i++) {
			lineChart.addXScaleText(forkList.get(i).getFork());
			A.addChartValue(forkList.get(i).getNums());
		}
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RepositoryStatisticFactory repositoryStatisticFactory = new RepositoryStatisticFactory();
		ForkLine company = new ForkLine(repositoryStatisticFactory, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(company);
		frame.pack();
		frame.setVisible(true);
	}
}
