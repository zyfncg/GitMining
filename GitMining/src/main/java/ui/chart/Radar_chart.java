package ui.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Info.StatisticDetail;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.RadarChart;

/**
 *单个项目特征描述面板 
 */
@SuppressWarnings("serial")
public class Radar_chart extends JPanel{

	public Radar_chart(StatisticDetail statisticDetail, int width, int height) {
		TDataBox box = new TDataBox();
		RadarChart chart = new RadarChart(box);
		chart.setTitle("Score of Repository(total:" + (statisticDetail.getTotalStatistic() * 10 )+ ")");
		
		//添加数据
		addElement(box,statisticDetail,false,new Color(0, 100, 255, 100),TWaverConst.STROKE_SOLID_1);
		addElement(box,statisticDetail,true,new Color(255, 0, 0, 200),TWaverConst.STROKE_SOLID_1);
		
		//设置主要刻度的数量
		chart.setScaleMajorCount(5);
		//填充网元的形状
		chart.setShapeFill(true);
		//填充时不需要渐变
		chart.setShapeFillGradient(false);
		//设置刻度的字体
		chart.setScaleMajorTextColor(Color.BLACK);
		//设置轴的字体
		chart.setAxisTextFont(new Font("Forte", Font.PLAIN, 14));
		chart.setScaleMaxValue(10.0);
		chart.addAxisText("contributor");
		chart.addAxisText("mature");
		chart.addAxisText("popular");
		chart.addAxisText("hot");
		chart.addAxisText("size");
		chart.addAxisText("famous");
		//设置不可拖动
		chart.setEnableXTranslate(false);
		chart.setEnableYTranslate(false);
		//设置不可缩放
		chart.setEnableXZoom(false);
		chart.setEnableYZoom(false);
		
		chart.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(chart, BorderLayout.CENTER);
	}

	private void addElement(TDataBox box, StatisticDetail statisticDetail, boolean IsAve, Color color, String stroke) {
		Element element = new Node();
		//设置网元的显示颜色
		element.putChartColor(color);
		//设置网元的显示样式
		element.putChartInflexionStyle(TWaverConst.INFLEXION_STYLE_CIRCLE);
		//设置网元的画笔
		element.putChartStroke(stroke);
		element.getChartValue();
		//给网元设置数值
		if(IsAve)
			setElementAveValue(element, statisticDetail);
		else
			setElementValue(element, statisticDetail);
		
		box.addElement(element);
	}
	
	private Element setElementValue(Element element, StatisticDetail statisticDetail) {
		//给网元设置数值
		element.addChartValue(statisticDetail.getContributorStatistic() * 10);
		element.addChartValue(statisticDetail.getCommitStatistic() * 10);
		element.addChartValue(statisticDetail.getStarStatistic() * 10);
		element.addChartValue(statisticDetail.getPullRequestStatistic() * 10);
		element.addChartValue(statisticDetail.getSizeStatistic() * 10);
		element.addChartValue(statisticDetail.getIssueStatistic() * 10);
		return element;
	}
	
	private Element setElementAveValue(Element element, StatisticDetail statisticDetail) {
		//给网元设置数值
		element.addChartValue(statisticDetail.getAveContributorStatistic() * 10);
		element.addChartValue(statisticDetail.getAveCommitStatistic() * 10);
		element.addChartValue(statisticDetail.getAveStarStatistic() * 10);
		element.addChartValue(statisticDetail.getAvePullRequestStatistic() * 10);
		element.addChartValue(statisticDetail.getAveSizeStatistic() * 10);
		element.addChartValue(statisticDetail.getAveIssueStatistic() * 10);
		return element;
	}
	
	
	
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		StatisticDetail d = new StatisticDetail(0.01, 0.02, 0.02, 0.03, 0.04, 0.05, 0.06);
//		f.add(new Radar_chart(d, 600, 600));
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.pack();
//		f.setVisible(true);
//	}
}