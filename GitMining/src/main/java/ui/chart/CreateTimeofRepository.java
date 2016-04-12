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
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import Info.RepStatisticInfo.TimeStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;

/**
 *项目创建时间统计面板 
 */
@SuppressWarnings("serial")
public class CreateTimeofRepository extends JPanel{

	public CreateTimeofRepository(List<TimeStatistics> timeList, int width,int height) {
		 CategoryDataset dataset = getDataSet(timeList); 
	     JFreeChart chart = ChartFactory.createBarChart3D( 
	                       "", // 图表标题
                           "", // 目录轴的显示标签
                           "", // 数值轴的显示标签
	                       dataset, // 数据集
	                       PlotOrientation.VERTICAL, // 图表方向：水平、垂直
	                       true,  // 是否显示图例(对于简单的柱状图必须是 false)
	                       true, // 是否生成工具
	                       false  // 是否生成 URL 链接
                           ); 
	     
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        categoryplot.getRenderer().setSeriesPaint(0, Color.RED);
        categoryplot.setBackgroundPaint(null);
		categoryplot.setRangeGridlinePaint(Color.ORANGE);
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
        CategoryAxis domainAxis = categoryplot.getDomainAxis();  
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));      
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
        domainAxis.setLowerMargin(0.11);
		domainAxis.setUpperMargin(0.11);
		domainAxis.setCategoryMargin(0.5);
		
		numberaxis.setUpperMargin(0.16);
		
        ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
	    } 

	    /** 
	    * 获取数据集对象
	    * @return 
	    */ 
	    private static CategoryDataset getDataSet(List<TimeStatistics> timeList) { 
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        for (int i = 0; i < timeList.size(); i++) {
	        	dataset.addValue(timeList.get(i).getNum(), "Company", timeList.get(i).getYear()); 
			}
	        return dataset; 
	    } 
//		 CategoryDataset dataset = getDataSet(timeList); 
//		 JFreeChart chart = ChartFactory.createBarChart3D( 
//		                       "", // 图表标题
//	                           "", // 目录轴的显示标签
//	                           "", // 数值轴的显示标签
//		                       dataset, // 数据集
//		                       PlotOrientation.VERTICAL, // 图表方向：水平、垂直
//		                       true,  // 是否显示图例(对于简单的柱状图必须是 false)
//		                       true, // 是否生成工具
//		                       true  // 是否生成 URL 链接
//	                           ); 
//		     
//	        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();//设置图的高级属性
//			BarRenderer3D renderer = new BarRenderer3D();//3D属性修改
//			CategoryAxis domainAxis = categoryplot.getDomainAxis();  //对x轴做操作
//			ValueAxis rAxis = categoryplot.getRangeAxis();//对Y轴做操作 
//			
//			//设置X轴坐标上的文字 
//			domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
//			//设置X轴的标题文字 
//			domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12)); 
//			domainAxis.setAxisLinePaint(Color.red);//X轴横线颜色 
//			domainAxis.setTickMarksVisible(true);//标记线是否显示 
//			domainAxis.setTickMarkOutsideLength(3);//标记线向外长度 
//			domainAxis.setTickMarkInsideLength(3);//标记线向内长度 
//			domainAxis.setTickMarkPaint(Color.red);//标记线颜色 
//			domainAxis.setUpperMargin(0.1);//设置距离图片左端距离 
//			domainAxis.setLowerMargin(0.1); //设置距离图片右端距离 
//			//横轴上的 Lable 是否完整显示 
//			domainAxis.setMaximumCategoryLabelWidthRatio(0.6f); 
//
//			//设置Y轴坐标上的文字 
//			rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12)); 
//			//设置Y轴的标题文字 
//			rAxis.setLabelFont(new Font("黑体", Font.PLAIN, 12)); 
//			//Y轴取值范围（下面不能出现 rAxis.setAutoRange(true) 否则不起作用） 
//			rAxis.setRange(0, 1600); 
//			rAxis.setMinorTickMarksVisible(true);//标记线是否显示 
//			rAxis.setMinorTickCount(7);//节段中的刻度数 
//			rAxis.setMinorTickMarkInsideLength(3);//内刻度线向内长度 
//			rAxis.setMinorTickMarkOutsideLength(3);//内刻度记线向外长度 
//			rAxis.setTickMarkInsideLength(3);//外刻度线向内长度 
//			rAxis.setTickMarkPaint(Color.red);//刻度线颜色 
//			rAxis.setTickLabelsVisible(true);//刻度数值是否显示 
//			// 所有Y标记线是否显示（如果前面设置rAxis.setMinorTickMarksVisible(true); 则其照样显示） 
//			rAxis.setTickMarksVisible(true); 
//			rAxis.setAxisLinePaint(Color.red);//Y轴竖线颜色 
//			rAxis.setAxisLineVisible(true);//Y轴竖线是否显示 
//			//设置最高的一个 Item 与图片顶端的距离 (在设置rAxis.setRange(100, 600);情况下不起作用) 
//			rAxis.setUpperMargin(0.15); 
//			//设置最低的一个 Item 与图片底端的距离 
//			rAxis.setLowerMargin(0.15); 
//			rAxis.setAutoRange(true);//是否自动适应范围 
//			rAxis.setVisible(true);//Y轴内容是否显示 
//
//			/**
//			 *设置柱子
//			 */
//			renderer.setBaseOutlinePaint(Color.ORANGE); //边框颜色 
//			renderer.setDrawBarOutline(true); 
//			renderer.setWallPaint(Color.gray);//设置墙体颜色 
//			renderer.setMaximumBarWidth(0.08); //设置柱子宽度 
//			renderer.setMinimumBarLength(0.1); //设置柱子高度 
//			renderer.setSeriesPaint(0,Color.ORANGE); //设置柱的颜色 
//			renderer.setItemMargin(0); //设置每个地区所包含的平行柱的之间距离 
//			//在柱子上显示相应信息 
//			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
//			renderer.setBaseItemLabelsVisible(true); 
//			renderer.setBaseItemLabelPaint(Color.BLACK);//设置数值颜色，默认黑色 
//			//搭配ItemLabelAnchor TextAnchor 这两项能达到不同的效果，但是ItemLabelAnchor最好选OUTSIDE，因为INSIDE显示不出来 
//			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT)); 
//			//下面可以进一步调整数值的位置，但是得根据ItemLabelAnchor选择情况. 
//			renderer.setItemLabelAnchorOffset(10); 
//
//			/** 
//			* plot 设置 
//			***/ 
//			//设置网格竖线颜色 
//			categoryplot.setDomainGridlinePaint(Color.blue); 
//			categoryplot.setDomainGridlinesVisible(true); 
//			//设置网格横线颜色 
//			categoryplot.setRangeGridlinePaint(Color.blue); 
//
//			categoryplot.setRangeGridlinesVisible(true); 
//			//图片背景色 
//			categoryplot.setBackgroundPaint(Color.LIGHT_GRAY); 
//			categoryplot.setOutlineVisible(true); 
//			//图边框颜色 
//			categoryplot.setOutlinePaint(Color.magenta); 
//			//设置柱的透明度 
//			categoryplot.setForegroundAlpha(1.0f); 
//			categoryplot.setRenderer(renderer);//将修改后的属性值保存到图中 
//			
//	        ChartPanel panel = new ChartPanel(chart);
//			panel.setPreferredSize(new Dimension(width, height));
//			this.setOpaque(false);
//			this.setLayout(new BorderLayout());
//			this.add(panel,BorderLayout.CENTER);
//		    } 
//
//		    /** 
//		    * 获取数据集对象
//		    * @return 
//		    */ 
//		    private static CategoryDataset getDataSet(List<TimeStatistics> timeList) { 
//		        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
//		        for (int i = 0; i < timeList.size(); i++) {
//		        	dataset.addValue(timeList.get(i).getNum(), "Company", timeList.get(i).getYear()); 
//				}
//		        return dataset; 
//		    } 
	}
	
