package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Info.UsrStatisticInfo.CompanyStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;

/**
 *用户所属公司统计面板 
 */
@SuppressWarnings("serial")
public class Company extends JPanel{

	public Company(List<CompanyStatistics> companyList, int width, int height) {
		 CategoryDataset dataset = getDataSet(companyList); 
	     JFreeChart chart = ChartFactory.createBarChart3D( 
	                       "", // 图表标题
                           "", // 目录轴的显示标签
                           "", // 数值轴的显示标签
	                        dataset, // 数据集
	                        PlotOrientation.VERTICAL, // 图表方向：水平、垂直
	                        true,  // 是否显示图例(对于简单的柱状图必须是 false)
	                        false, // 是否生成工具
	                        false  // 是否生成 URL 链接
                            ); 
	        //中文乱码
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
	        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
	        domainAxis.setLowerMargin(0.02D);
			domainAxis.setUpperMargin(0.02D);
			
	        ChartPanel panel = new ChartPanel(chart);
			panel.setPreferredSize(new Dimension(width, height));
			this.setOpaque(false);
			this.setLayout(new BorderLayout());
			this.add(panel,BorderLayout.CENTER);
	    } 

	    /** 
	    * 获取一个演示用的组合数据集对象
	    * @return 
	    */ 
	    private static CategoryDataset getDataSet(List<CompanyStatistics> companyList) { 
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        for (int i = 0; i < companyList.size(); i++) {
	        	dataset.addValue(companyList.get(i).getNum(), "Company", companyList.get(i).getCompany()); 
			}
	        return dataset; 
	    } 
//		TDataBox box = new TDataBox();
//		BarChart barChart = new BarChart(box);
//		
//		//设置Y的尺度值是否可见，默认是不可见的
//		barChart.setYScaleTextVisible(true);
//		//设置Y最小的尺度值是否可见，默认是不可见的
//		barChart.setYScaleMinTextVisible(true);
//		//设置Y的最大尺度值
//		barChart.setUpperLimit(50);
//		//设置Y坐标的间距
//		barChart.setYScaleValueGap(2);
//		barChart.setFocusable(false);
//		
//		barChart.setXScaleTextOrientation(TWaverConst.ORIENTATION_SOUTH_EAST);
//		//添加一个节点
//		Element A = new Node();
//		A.setName(Strings.User.COMPANY_LABEL);
//		//设置chart的颜色
//		A.putChartColor(Color.RED);
//		//添加X轴上组的名称和数据
//		for (int i = 0; i < companyList.size(); i++) {
//			barChart.addXScaleText(companyList.get(i).getCompany());
//			A.addChartValue(companyList.get(i).getNum());
//		}
//		box.addElement(A);
//		//设置柱状图的显示样式
//		barChart.setBarType(TWaverConst.BAR_TYPE_GROUP);
//		//设置不可拖动
//		barChart.setEnableXTranslate(false);
//		barChart.setEnableYTranslate(false);
//		//设置不可缩放
//		barChart.setEnableYZoom(false);
//		barChart.setEnableXZoom(false);
//		//设置x轴显示为斜体
//		barChart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
//		barChart.setPreferredSize(new Dimension(width, height));
//		this.setOpaque(false);
//		this.setLayout(new BorderLayout());
//		this.add(barChart, BorderLayout.CENTER);

}
