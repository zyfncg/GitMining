package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;

import Info.HistogramInfo;
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
		plot.setBackgroundPaint(null);
		plot.getRenderer().setSeriesPaint(0, Color.red);
		plot.setRangeGridlinePaint(Color.ORANGE);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
	}
	
}
