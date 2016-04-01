package ui.chart;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetStarStatistic;

/**
 *star分布的直方图 
 */
@SuppressWarnings("serial")
public class StarHistogram extends JPanel {

	public StarHistogram(RepositoryStatisticFactory factory, int width, int height) {
		//获取数据
		GetStarStatistic stat = factory.GetStar();
		
		HistogramDataset dataset = new HistogramDataset();
		ChartFactory.createHistogram(
				"test", "star", "num",
				null,	
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
	}
}
