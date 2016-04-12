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
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

/**
 *用户注册时间统计面板 
 */
@SuppressWarnings("serial")
public class UserCreateTime extends JPanel{

	public UserCreateTime(List<CreatTimeStatistics> userCreateList, int width, int height) {
		 CategoryDataset dataset = getDataSet(userCreateList); 
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
        domainAxis.setLowerMargin(0.02D);
		domainAxis.setUpperMargin(0.02D);
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
	    private static CategoryDataset getDataSet(List<CreatTimeStatistics> userCreateList) { 
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	        for (int i = 0; i < userCreateList.size(); i++) {
	        	dataset.addValue(userCreateList.get(i).getNum(), "Company", userCreateList.get(i).getTime()); 
			}
	        return dataset; 
	    } 
}
