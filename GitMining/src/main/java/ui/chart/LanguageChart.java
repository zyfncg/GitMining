package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.SortOrder;

import Info.RepStatisticInfo.LanguageStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetLanguageStatistic;
import res.Colors;

/**
 *项目使用语言统计面板 
 */
@SuppressWarnings("serial")
public class LanguageChart extends JPanel{
	
	private Font font = new Font("斜体", Font.ITALIC, 12);

	public LanguageChart(RepositoryStatisticFactory repositoryFactory, int width, int height) {
		GetLanguageStatistic getLanguage = repositoryFactory.GetLanguage();
		List<LanguageStatistics> languageList = getLanguage.getLanguageStatistic();
		// 构造数据
		DefaultKeyedValues defaultkeydvalues = new DefaultKeyedValues();//柱状图数据
		// 使用语言数量
		for (int i = 0; i < languageList.size(); i++) {
			defaultkeydvalues.addValue(languageList.get(i).getLanguage(), languageList.get(i).getNum());
		}
		defaultkeydvalues.sortByValues(SortOrder.DESCENDING);
		KeyedValues keydvalues = DataUtilities.getCumulativePercentages(defaultkeydvalues);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Language", defaultkeydvalues);
		CategoryDataset lineDataset = DatasetUtilities.createCategoryDataset("Cumulative", keydvalues);
		
		JFreeChart chart = ChartFactory.createBarChart("Numbers of Repository in Different Languages",
				"",// 目录轴的显示标签
				"", // 数值轴的显示标签
				dataset,// 数据集
				PlotOrientation.VERTICAL,// 图表方向：水平、垂直
				true,// 是否显示图例(对于简单的柱状图必须是false)
				true,//是否生成工具
				false);// 是否生成URL链接
		chart.getTitle().setFont(new Font("黑体", Font.BOLD, 20));
		chart.setBackgroundPaint(Colors.STAT_BG);
		chart.getLegend().setItemFont(font);

		//设置图的样式
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();//图本身
		categoryplot.getRenderer().setSeriesPaint(0, Color.BLACK);
		categoryplot.setBackgroundPaint(null);
		categoryplot.setRangeGridlinePaint(Color.ORANGE);
		CategoryAxis categoryaxis = categoryplot.getDomainAxis();
		categoryaxis.setLowerMargin(0.02D);
		categoryaxis.setUpperMargin(0.02D);
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		lineandshaperenderer.setSeriesPaint(0, Color.RED);
		NumberAxis numberaxis1 = new NumberAxis("");
		numberaxis1.setNumberFormatOverride(NumberFormat.getPercentInstance());
		categoryplot.setRangeAxis(1, numberaxis1);
		categoryplot.setDataset(1, lineDataset);
		categoryplot.setRenderer(1, lineandshaperenderer);
		categoryplot.mapDatasetToRangeAxis(1, 1);
		categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
   
		ValueAxis valueAxis = categoryplot.getRangeAxis();
		valueAxis.setLabelFont(font); // 设置数据字体(纵轴)
		categoryaxis.setLabelFont(font); // 设置时字体（横轴）
		categoryaxis.setLowerMargin(0.0); // 柱状图和纵轴紧靠
   
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
		categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);//折线在柱面前面显示

		ChartPanel panel = new ChartPanel(chart);
		panel.setSize(width, height);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		RepositoryStatisticFactory repositoryStatisticFactory = new RepositoryStatisticFactory();
//		LanguageChart company = new LanguageChart(repositoryStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(company);
//		frame.pack();
//		frame.setVisible(true);
//	}
}
