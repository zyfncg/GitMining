package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;

import Info.HistogramInfo;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import res.Colors;

/**
 *绘制直方图的面板 
 */
@SuppressWarnings("serial")
public class Histogram extends JPanel {

	public Histogram(HistogramInfo info, HistogramLabel label, int width, int height) {
		HistogramDataset dataset = new HistogramDataset();
		dataset.addSeries(label.getKey(), info.getAllNum(),
				info.getGroupNum(), info.getMinNum(), info.getMaxNum());
		JFreeChart chart = ChartFactory.createHistogram(label.getTitle(),
				null, null,
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false);
		chart.getTitle().setFont(ChartConst.TITLE_FONT);
		chart.setBackgroundPaint(Colors.STAT_BG);
		chart.getLegend().setItemFont(ChartConst.LABEL_FONT);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRenderer().setSeriesPaint(0, Color.GREEN);
		plot.setBackgroundPaint(null);
		plot.setRangeGridlinePaint(Color.ORANGE);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		double[] num = new double[1000];
		for(int i = 0; i < num.length; ++i) {
			num[i] = i;
		}
		HistogramInfo info = new HistogramInfo(1000, 0, 10, num);
		Histogram company = new Histogram(info,
				new HistogramLabel("hello", "A"), 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(company);
		frame.pack();
		frame.setVisible(true);
	}
}
