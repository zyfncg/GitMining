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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.PowerFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import res.Colors;
import res.Strings;

/**
 *散点图面板 
 */
@SuppressWarnings("serial")
public class ScatterChart extends JPanel {

	public ScatterChart(ScatterLabel label, double[][] data,
			int min, int max, int width, int height) {
		//创建数据集
		DefaultXYDataset set = new DefaultXYDataset();
		set.addSeries(Strings.DOT_LABEL, data);
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
		
		
		//绘制线性回归直线
		double[] coefficients = Regression.getPowerRegression(set, 0);   
        Function2D curve = new PowerFunction2D(coefficients[0], coefficients[1]);   
        XYDataset regressionData = DatasetUtilities.sampleFunction2D(curve,   
                min, max, 300, Strings.REGRESSION_LABEL);   
           
        XYLineAndShapeRenderer line = new XYLineAndShapeRenderer(true,    
                false);   
        line.setSeriesPaint(0, Color.blue);   
        plot.setDataset(1, regressionData);   
        plot.setRenderer(1, line);  
//		XYLineAndShapeRenderer line = new XYLineAndShapeRenderer(false, true);
//		NumberAxis xAxis = new NumberAxis(label.getxLabel());   
//        xAxis.setAutoRangeIncludesZero(false);   
//        NumberAxis yAxis = new NumberAxis(label.getyLabel());   
//        yAxis.setAutoRangeIncludesZero(false); 
//		XYPlot xyPlot = new XYPlot(set, xAxis, yAxis, line);
//        renderer2.setSeriesPaint(0, Color.blue); 
//		plot.setRenderer(1, renderer2);
//		plot.setDataset(1, regressionData);   
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(width, height));
		this.add(panel, BorderLayout.CENTER);
		this.setOpaque(false);
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		double[][] data = new double[2][];
//		RepositoryStatisticFactory f = new RepositoryStatisticFactory();
//		f.GetHistogramFork().getRepHistogramInfo();
//		f.GetHistogramFork();
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
//	}
}
