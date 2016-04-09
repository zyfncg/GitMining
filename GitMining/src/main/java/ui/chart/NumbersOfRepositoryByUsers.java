package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;

public class NumbersOfRepositoryByUsers extends JPanel{


	public NumbersOfRepositoryByUsers (List<CreatRepositoryStatistics> createRepositoryList,
			List<JoinRepositoryStatistics> joinRepositoryList, int width, int height) {
			//生成图表对象JFreeChart
			//定义图表对象
	        JFreeChart chart = ChartFactory.createLineChart(null,// 报表题目，字符串类型
	                                  "", // 横轴
	                                  "", // 纵轴
	                                  this.createDataset(createRepositoryList, joinRepositoryList), // 获得数据集
	                                  PlotOrientation.VERTICAL, // 图表方向垂直
	                                  true, // 显示图例
	                                  true, // 生成工具
	                                  false // 不用生成URL地址
	                                  );
	        // 生成图形
	        CategoryPlot plot = chart.getCategoryPlot();
	        // 图像属性部分
	        plot.setBackgroundPaint(Color.white);
	        plot.setDomainGridlinesVisible(true);  //设置背景网格线是否可见
	        plot.setBackgroundAlpha(0.3f);//设置背景透明度
	        plot.setDomainGridlinePaint(Color.ORANGE); //设置背景网格线颜色
	        plot.setRangeGridlinePaint(Color.GRAY);
	        plot.setNoDataMessage("没有数据");//没有数据时显示的文字说明。 
	        CategoryAxis domainAxis = plot.getDomainAxis();
	        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
	        domainAxis.setLabelFont(labelFont);
	        domainAxis.setTickLabelFont(labelFont);//X轴坐标上数值字体 
	        // 设置距离图片左端距离 
	        domainAxis.setLowerMargin(0.0); 
	        // 设置距离图片右端距离 
	        domainAxis.setUpperMargin(0.0);
	        // 数据轴属性部分
	        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	        rangeAxis.setAutoRangeIncludesZero(true); //自动生成
	        rangeAxis.setUpperMargin(0.20);
	        rangeAxis.setLabelAngle(Math.PI / 2.0); 
	        rangeAxis.setAutoRange(false);
	        // 数据渲染部分 主要是对折线做操作
	        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
	        renderer.setBaseItemLabelsVisible(true);
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesPaint(1, Color.BLUE);
	        renderer.setBaseShapesFilled(true);
	        renderer.setBaseItemLabelsVisible(true);     
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                      ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  

	        //设置提示折点数据形状
	        renderer.setSeriesItemLabelFont(0, new Font("Dialog", 3, 18));
	        renderer.setSeriesItemLabelPaint(0, Color.RED);
	        plot.setRenderer(renderer);
	        
	    	ChartPanel panel = new ChartPanel(chart);
			panel.setPreferredSize(new Dimension(width, height));
			this.setOpaque(false);
			this.setLayout(new BorderLayout());
			this.add(panel,BorderLayout.CENTER);
	      }
	      //获得数据集
	      public DefaultCategoryDataset createDataset(List<CreatRepositoryStatistics> createRepositoryList,
	    		  List<JoinRepositoryStatistics> joinRepositoryList) { 
	          DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
	          // 曲线名称
	          String create = "RepositoryCreated";
	          String join = "RepositoryInvolved";
	          // 横轴名称(列名称) 
	          String[] time = new String[joinRepositoryList.size()];
	          for (int i = 0; i < joinRepositoryList.size(); i++) {
	               time[i] = joinRepositoryList.get(i).getYear();
	             }
	          //添加数据
	          for (int i = 0; i < joinRepositoryList.size(); i++) {
	            linedataset.addValue(createRepositoryList.get(i).getNum(),  //值
	            		create,  //哪条数据线
	                    time[i]); // 对应的横轴
	            linedataset.addValue(joinRepositoryList.get(i).getNum(),
	            		join, time[i]); }
	          return linedataset;
	      }
}
