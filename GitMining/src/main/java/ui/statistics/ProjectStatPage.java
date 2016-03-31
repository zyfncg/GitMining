package ui.statistics;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import res.Colors;
import res.Strings;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.chart.CreateTimeofRepository;
import ui.chart.ForkLine;
import ui.chart.LanguageChart;
import ui.chart.StarLine;
import ui.component.BackPanel;
import ui.component.MyScrollBar;
import ui.component.TitlePanel;

/**
 *项目信息统计结果页面 
 */
@SuppressWarnings("serial")
public class ProjectStatPage extends JPanel implements Refreshable{
	
	/**
	 *页面顶层面板 
	 */
	private JScrollPane scrollPane;
	
	public ProjectStatPage(PanelSwitcher switcher) {
		//获取统计数据
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		//项目创建时间统计标题
		TitlePanel timeTitle = new TitlePanel(
				Strings.Project.PROJECT_TIME_BAR_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//项目创建时间统计
		CreateTimeofRepository time = new CreateTimeofRepository(
				factory, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//使用语言统计
		LanguageChart language = new LanguageChart(
				factory, StatConst.CHART_WIDTH, (int)(StatConst.CHART_HEIGHT * 1.5));
		//star折线图标题
		TitlePanel starLine = new TitlePanel(
				Strings.Project.STAR_LINE_TILE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//star折线图统计
		StarLine star = new StarLine(factory,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//fork折线图标题
		TitlePanel forkLine = new TitlePanel(
				Strings.Project.FORK_LINE_TILE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//fork折线图统计
		ForkLine fork = new ForkLine(factory,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//组装统计面板
		Box box = Box.createVerticalBox();
		box.add(new BackPanel(() -> switcher.back(this, PanelSwitcher.RIGHT),
				StatConst.PANEL_WIDTH, StatConst.GAP,
				StatConst.GAP << 1, StatConst.GAP,
				null));
		box.add(timeTitle);
		box.add(new ChartPanel(time,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(new ChartPanel(language,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(starLine);
		box.add(new ChartPanel(star,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(forkLine);
		box.add(new ChartPanel(fork,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.getVerticalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.getHorizontalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.setOpaque(false);
		this.scrollPane.setViewportView(box);
		this.scrollPane.getViewport().setOpaque(false);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Colors.STAT_BG);
		this.add(this.scrollPane, BorderLayout.CENTER);
	}
	
	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}

}
