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
import res.Strings;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.LineChart;

/**
 *项目创建数目统计面板 
 */
@SuppressWarnings("serial")
public class NumbersofRepositoryCreated extends JPanel{

	public NumbersofRepositoryCreated(List<CreatRepositoryStatistics> createRepositoryList, int width, int height) {
		TDataBox box = new TDataBox();		
		LineChart lineChart = new LineChart(box);
		
		lineChart.setYAxisVisible(true);
		lineChart.setYScaleTextVisible(true);
		lineChart.setXAxisVisible(true);
		lineChart.setXScaleTextVisible(true);
		//设置不可拖动
		lineChart.setEnableXTranslate(false);
		lineChart.setEnableYTranslate(false);
		//设置不可缩放
		lineChart.setEnableXZoom(false);
		lineChart.setEnableYZoom(false);
		//每个点上是否需要显示标记
		lineChart.setInflexionVisible(true);
		Element A = new Node();
		A.setName(Strings.Project.REPOSITORY_LABEL);
		A.putChartColor(Color.RED);
		//设置标记的显示样式
		A.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_TRIANGLE);
		box.addElement(A);
		// 获取参与项目数量
		for (int i = 0; i < createRepositoryList.size() ; i++) {
			lineChart.addXScaleText(createRepositoryList.get(i).getYear());
			A.addChartValue(createRepositoryList.get(i).getNum());
		}
		
		lineChart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
//		NumbersofRepositoryCreated userChart = new NumbersofRepositoryCreated(userStatisticFactory, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(userChart);
//		frame.pack();
//	}
}
