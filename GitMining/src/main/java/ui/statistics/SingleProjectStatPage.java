package ui.statistics;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Info.StatisticDetail;
import ui.Refreshable;
import ui.chart.Radar_chart;
import ui.component.MyScrollBar;

/**
 *单个项目统计结果页面 
 */
@SuppressWarnings("serial")
public class SingleProjectStatPage extends JPanel implements Refreshable {
	
	private JScrollPane scrollPane;
	
	public SingleProjectStatPage(StatisticDetail info) {
		//单个项目各项信息的统计
		Radar_chart chart = new Radar_chart(
				info, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		box.add(chart);
		
		this.scrollPane = new JScrollPane(box);
		this.scrollPane.getHorizontalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.setOpaque(false);
		
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.add(this.scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}
}
