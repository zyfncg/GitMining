package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class LanguageChart extends JPanel{

	public LanguageChart(int width, int height) {
		// 设置主题
		StandardChartTheme standardChartTheme = new StandardChartTheme("name");//这里的"name"参数；是什么意思我也不知道，反正这样可以用
		standardChartTheme.setLargeFont(new Font("楷体",Font.BOLD, 12));//可以改变轴向的字体
		standardChartTheme.setRegularFont(new Font("宋体",Font.BOLD, 12));//可以改变图例的字体
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD, 12));//可以改变图标的标题字体
		ChartFactory.setChartTheme(standardChartTheme);//Theme.getTheme()
		// 构造数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();//柱状图数据
		DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();//折线图数据
		//TODO 使用语言数量
		dataset.addValue(100, "Language", "Ruby");
		dataset.addValue(700, "Language", "Python");
		dataset.addValue(300, "Language", "JavaScript");
		dataset.addValue(400, "Language", "C");
		dataset.addValue(500, "Language", "Perl");
		dataset.addValue(600, "Language", "PHP");
		dataset.addValue(600, "Language", "Java");
		dataset.addValue(600, "Language", "C++");
		dataset.addValue(600, "Language", "HTML");
		dataset.addValue(600, "Language", "Shell");
		dataset.addValue(600, "Language", "others");
		

		lineDataset.addValue(100, "累计比率", "Ruby");
		lineDataset.addValue(200, "累计比率", "Python");
		lineDataset.addValue(600, "累计比率", "JavaScript");
		lineDataset.addValue(400, "累计比率", "C");
		lineDataset.addValue(700, "累计比率", "Perl");
		lineDataset.addValue(600, "累计比率", "PHP");
		lineDataset.addValue(100, "累计比率", "Java");
		lineDataset.addValue(200, "累计比率", "C++");
		lineDataset.addValue(600, "累计比率", "HTML");
		lineDataset.addValue(400, "累计比率", "Shell");
		lineDataset.addValue(700, "累计比率", "others");

		JFreeChart chart = ChartFactory.createBarChart("Numbers of Repository in Different Languages",
				"Language",// 目录轴的显示标签
				"Numbers of Repository", // 数值轴的显示标签
				dataset,// 数据集
				PlotOrientation.VERTICAL,// 图表方向：水平、垂直
				true,// 是否显示图例(对于简单的柱状图必须是false)
				true,//是否生成工具
				false);// 是否生成URL链接
		chart.getTitle().setFont(new Font("隶书", Font.BOLD, 26));//设置title标题
		chart.setBackgroundPaint(new Color(238, 238, 255));//设置背景色
		chart.getLegend().setItemFont(new Font("隶书", Font.BOLD, 18));// 底部

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();//图本身
		categoryplot.setDataset(1, lineDataset);//放折线图数据
		LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		categoryplot.setRenderer(1, lineandshaperenderer);
   
		ValueAxis valueAxis = categoryplot.getRangeAxis();
		valueAxis.setLabelFont(new Font("黑体", Font.ITALIC, 18)); // 设置数据字体(纵轴)
		CategoryAxis categoryaxis = categoryplot.getDomainAxis();
		categoryaxis.setLabelFont(new Font("黑体", Font.ITALIC, 18)); // 设置时字体（横轴）
		categoryaxis.setLowerMargin(0.0); // 柱状图和纵轴紧靠
   
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
		categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);//折线在柱面前面显示

		ChartPanel panel = new ChartPanel(chart);
		panel.setSize(width, height);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
	}
}
