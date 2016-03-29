package ui.statistics;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import ui.Refreshable;
import ui.chart.CreateTimeofRepository;
import ui.chart.ForkLine;
import ui.chart.LanguageChart;
import ui.chart.StarLine;
import ui.component.MyScrollBar;

/**
 *项目信息统计结果页面 
 */
@SuppressWarnings("serial")
public class ProjectStatPage extends JPanel implements Refreshable{
	
	/**
	 *页面顶层面板 
	 */
	private JScrollPane scrollPane;
	
	public ProjectStatPage() {
		//获取统计数据
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		//项目创建时间统计
		CreateTimeofRepository time = new CreateTimeofRepository(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//使用语言统计
		LanguageChart language = new LanguageChart(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//star统计
		StarLine star = new StarLine(factory,
				StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//fork统计
		ForkLine fork = new ForkLine(factory,
				StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//组装统计面板
		Box box = Box.createVerticalBox();
		box.add(time);
		box.add(language);
		box.add(star);
		box.add(fork);
		box.setOpaque(false);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.getVerticalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.setOpaque(false);
		this.scrollPane.setViewportView(box);
		
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.add(this.scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}

}
