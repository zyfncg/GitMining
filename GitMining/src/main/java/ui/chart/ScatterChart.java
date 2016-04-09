package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;

import Info.HistogramInfo;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import res.Colors;

/**
 *散点图面板 
 */
@SuppressWarnings("serial")
public class ScatterChart extends JPanel {

	public ScatterChart(ScatterLabel label, double[][] data, int width, int height) {
		//创建数据集
		DefaultXYDataset set = new DefaultXYDataset();
		set.addSeries("", data);
		//创建散点图
		JFreeChart chart = ChartFactory.createScatterPlot(label.getTitle(),
				label.getxLabel(), label.getyLabel(),
				set,
				PlotOrientation.VERTICAL,
				true, true, false);
		chart.getTitle().setFont(ChartConst.TITLE_FONT);
		chart.setBackgroundPaint(Colors.STAT_BG);
		chart.getLegend().setItemFont(ChartConst.LABEL_FONT);
		//设置散点图参数
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(null);
		plot.setRangeGridlinePaint(Color.ORANGE);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(width, height));
		this.add(panel, BorderLayout.CENTER);
		this.setOpaque(false);
	}
	
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		double[][] data = new double[2][];
		RepositoryStatisticFactory f = new RepositoryStatisticFactory();
		f.GetHistogramFork().getRepHistogramInfo();
		f.GetHistogramFork();
//		double[] star = f.GetHistogramStar().getRepHistogramInfo().getAllNum();
//		data[0] = fork;
//		data[1] = star;
//		System.out.println(fork);
//		System.out.println(star);
//		ScatterChart chart = new ScatterChart(new ScatterLabel("Hello", "fork", "star"),
//				data, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(chart);
//		frame.pack();
//		frame.setVisible(true);
	}
}
