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

import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.StarStatistics;

/**
 *项目star随着年份变化趋势的折线图面板 
 */
@SuppressWarnings("serial")
public class StarLine extends JPanel{

	public StarLine(List<StarStatistics> starList, List<ForkStatistics> forkList, int width, int height) {
		//生成图表对象JFreeChart
		//定义图表对象
        JFreeChart chart = ChartFactory.createLineChart(null,// 报表题目，字符串类型
                                  "", // 横轴
                                  "", // 纵轴
                                  this.createDataset(starList, forkList), // 获得数据集
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
        renderer.setSeriesPaint(0, Color.RED);    //设置折线的颜色
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setBaseShapesFilled(true);
        renderer.setBaseItemLabelsVisible(true);     
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                      ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  

        //设置提示折点数据形状
        renderer.setSeriesItemLabelFont(0, new Font("Dialog", 3, 18));
        renderer.setSeriesItemLabelFont(1, new Font("宋体", 3, 14));
        renderer.setSeriesItemLabelPaint(0, Color.RED);
        renderer.setSeriesItemLabelPaint(1, Color.BLUE);
        plot.setRenderer(renderer);
        
    	ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
      }
      //获得数据集
      public DefaultCategoryDataset createDataset(List<StarStatistics> starList, List<ForkStatistics> forkList) { 
          DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
          // 曲线名称
          String star = "Star";  //     对应 Star
          String fork = "Fork"; //		对应Foek
          // 横轴名称(列名称) 
          String[] time = new String[starList.size()];
          for (int i = 0; i < starList.size(); i++) {
               time[i] = starList.get(i).getStar();
             }
          //添加数据
          for (int i = 0; i < starList.size(); i++) {
            linedataset.addValue(starList.get(i).getNums(),  //值
            		star,  //哪条数据线
                    time[i]); // 对应的横轴
            linedataset.addValue(forkList.get(i).getNums(),
            		fork, time[i]);
             }
          return linedataset;
      }
//		TDataBox box = new TDataBox();		
//		LineChart lineChart = new LineChart(box);
//		
//		lineChart.setYAxisVisible(true);
//		lineChart.setYScaleTextVisible(true);
//		lineChart.setXAxisVisible(true);
//		lineChart.setXScaleTextVisible(true);
//		//每个点上是否需要显示标记
//		lineChart.setInflexionVisible(true);
//		//设置不可拖动
//		lineChart.setEnableXTranslate(false);
//		lineChart.setEnableYTranslate(false);
//		//设置不可缩放
//		lineChart.setEnableXZoom(false);
//		lineChart.setEnableYZoom(false);
//		
//		Element A = new Node();
//		A.setName(Strings.Project.STAR_LABEL);
//		A.putChartColor(Color.BLUE);
//		//设置标记的显示样式
//		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
//		box.addElement(A);
//		// 获取star数量
//		for (int i = 0; i < starList.size(); i++) {
//			lineChart.addXScaleText(starList.get(i).getStar());
//			A.addChartValue(starList.get(i).getNums());
//		}
//		
//		lineChart.setPreferredSize(new Dimension(width, height));
//		this.setOpaque(false);
//		this.setLayout(new BorderLayout());
//		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		RepositoryStatisticFactory repositoryFactory = new RepositoryStatisticFactory();
//		StarLine userChart = new StarLine(repositoryFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
//}
