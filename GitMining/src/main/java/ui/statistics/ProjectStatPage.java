package ui.statistics;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.HistogramInfo;
import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.RepStatisticInfo.StarStatistics;
import Info.RepStatisticInfo.TimeStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import res.Colors;
import res.Strings;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.chart.CreateTimeofRepository;
import ui.chart.Histogram;
import ui.chart.HistogramLabel;
import ui.chart.LanguageChart;
import ui.chart.ScatterChart;
import ui.chart.ScatterLabel;
import ui.chart.StarAndForkLine;
import ui.component.BackPanel;
import ui.component.ChartScrollPane;
import ui.component.TitlePanel;

/**
 *项目信息统计结果页面 
 */
@SuppressWarnings("serial")
public class ProjectStatPage extends JPanel implements Refreshable{
	
	/**
	 *页面顶层面板 
	 */
	private ChartScrollPane scrollPane;
	
	/**
	 *统计数据 
	 */
	private static final RepositoryStatisticFactory DATA_FACTORY =
			new RepositoryStatisticFactory();
	
	/**
	 *项目创建时间统计数据 
	 */
	private static final List<TimeStatistics> TIME_STAT =
			DATA_FACTORY.GetTime().getTimeStatistic();
	
	/**
	 *项目使用语言统计数据 
	 */
	private static final List<LanguageStatistics> LANG_STAT =
			DATA_FACTORY.GetLanguage().getLanguageStatistic();
	
	/**
	 *项目star折线图统计数据 
	 */
	private static final List<StarStatistics> STAR_LINE =
			DATA_FACTORY.GetStar().getStarStatistic();
	
	/**
	 *项目star直方图统计数据 （小数值部分）
	 */
	private static final HistogramInfo SMALL_STAR_HISTOGRAM =
			DATA_FACTORY.GetHistogramStar().getSmallRepHistogramInfo();
	
	/**
	 *项目star直方图统计数据 （大数值部分）
	 */
	private static final HistogramInfo BIG_STAR_HISTOGRAM =
			DATA_FACTORY.GetHistogramStar().getBigRepHistogramInfo();
	
	/**
	 *项目star直方图的标签 （小数值部分）
	 */
	private static final HistogramLabel SMALL_STAR_LABEL = new HistogramLabel(
			Strings.Project.SMALL_STAR_HISTOGRAM_TILE, Strings.Project.STAR_LABEL);
	
	/**
	 *项目star直方图的标签 （大数值部分）
	 */
	private static final HistogramLabel BIG_STAR_LABEL = new HistogramLabel(
			Strings.Project.BIG_STAR_HISTOGRAM_TILE, Strings.Project.STAR_LABEL);
	
	/**
	 *项目fork折线图统计数据 
	 */
	private static final List<ForkStatistics> FORK_LINE =
			DATA_FACTORY.GetFork().getForkStatistic();
	
	/**
	 *项目fork直方图统计数据 （小数值部分）
	 */
	private static final HistogramInfo SMALL_FORK_HISTOGRAM =
			DATA_FACTORY.GetHistogramFork().getSmallRepHistogramInfo();
	
	/**
	 *项目fork直方图统计数据 （大数值部分）
	 */
	private static final HistogramInfo BIG_FORK_HISTOGRAM =
			DATA_FACTORY.GetHistogramFork().getBigRepHistogramInfo();
	
	/**
	 *项目star直方图的标签 （小数值部分）
	 */
	private static final HistogramLabel SMALL_FORK_LABEL = new HistogramLabel(
			Strings.Project.SMALL_FORK_HISTOGRAM_TILE, Strings.Project.FORK_LABEL);
	
	/**
	 *项目star直方图的标签 （大数值部分）
	 */
	private static final HistogramLabel BIG_FORK_LABEL = new HistogramLabel(
			Strings.Project.BIG_FORK_HISTOGRAM_TILE, Strings.Project.FORK_LABEL);
	
	public ProjectStatPage(PanelSwitcher switcher) {
		//项目创建时间统计标题
		TitlePanel timeTitle = new TitlePanel(
				Strings.Project.PROJECT_TIME_BAR_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//项目创建时间统计
		CreateTimeofRepository time = new CreateTimeofRepository(
				TIME_STAT, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//使用语言统计
		LanguageChart language = new LanguageChart(
				LANG_STAT, StatConst.CHART_WIDTH, (int)(StatConst.CHART_HEIGHT * 1.5));
		//star折线图和fork折线图标题
		TitlePanel starTitle = new TitlePanel(
				Strings.Project.STAR_FORK_LINE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//star折线图和fork折线图
		StarAndForkLine star_fork = new StarAndForkLine(STAR_LINE, FORK_LINE,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//star直方图统计（小数值部分）
		Histogram smallStar = new Histogram(SMALL_STAR_HISTOGRAM, SMALL_STAR_LABEL,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//star直方图统计（大数值部分）
		Histogram bigStar = new Histogram(BIG_STAR_HISTOGRAM, BIG_STAR_LABEL,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
//		//fork折线图标题
//		TitlePanel forkTitle = new TitlePanel(
//				Strings.Project.FORK_LINE_TILE,
//				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
//		//fork折线图统计
//		ForkLine fork = new ForkLine(FORK_LINE,
//				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//fork直方图统计（小数值部分）
		Histogram smallFork = new Histogram(SMALL_FORK_HISTOGRAM, SMALL_FORK_LABEL,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//fork直方图统计（小数值部分）
		Histogram bigFork = new Histogram(BIG_FORK_HISTOGRAM, BIG_FORK_LABEL,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//star和fork的散点图（小数值部分）
		double[][] data = new double[2][];
		data[0] = SMALL_STAR_HISTOGRAM.getAllNum();
		data[1] = SMALL_FORK_HISTOGRAM.getAllNum();
		System.out.println(data[0].length);
		System.out.println(data[1].length);
		int min1 = SMALL_FORK_HISTOGRAM.getMinNum();
		int max1 = SMALL_FORK_HISTOGRAM.getMaxNum();
		ScatterChart smallScatter = new ScatterChart(new ScatterLabel(Strings.Project.SMALL_STAR_FORK_SCATTER,
				Strings.Project.STAR_LABEL, Strings.Project.FORK_LABEL),
				data, min1, max1, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
//
		//star和fork的散点图（大数值部分）
		double[][] data1 = new double[2][];
		data1[0] = BIG_STAR_HISTOGRAM.getAllNum();
		data1[1] = BIG_FORK_HISTOGRAM.getAllNum();
		System.out.println(data1[0].length);
		System.out.println(data1[1].length);
//		int min2 = BIG_FORK_HISTOGRAM.getMinNum();
//		int max2 = BIG_FORK_HISTOGRAM.getMaxNum();
//		ScatterChart bigScatter = new ScatterChart(new ScatterLabel(Strings.Project.BIG_STAR_FORK_SCATTER,
//				Strings.Project.STAR_LABEL, Strings.Project.FORK_LABEL),
//				data1, min2, max2, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
				
		
		//组装统计面板
		Box box = Box.createVerticalBox();
		//返回按钮面板
		box.add(new BackPanel(() -> switcher.back(this, PanelSwitcher.RIGHT),
				StatConst.PANEL_WIDTH, StatConst.GAP,
				StatConst.GAP << 1, StatConst.GAP,
				null));
		//项目创建时间统计面板
		box.add(timeTitle);
		box.add(new ChartPanel(time,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//项目使用语言统计面板
		box.add(new ChartPanel(language,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//项目star变化趋势和fork变化趋势统计面板
		box.add(starTitle);
		box.add(new ChartPanel(star_fork,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//项目star分布统计面板（小数值部分）
		box.add(new ChartPanel(smallStar,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//项目star分布统计面板（小数值部分）
		box.add(new ChartPanel(bigStar,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
//		//项目fork变化趋势统计面板
//		box.add(forkTitle);
//		box.add(new ChartPanel(fork,
//				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
//		box.add(new BoxStrut());
		//项目fork分布统计面板（小数值部分）
		box.add(new ChartPanel(smallFork,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//项目fork分布统计面板（大数值部分）
		box.add(new ChartPanel(bigFork,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//star和fork的关系分析面板（小数值部分）
		box.add(new ChartPanel(smallScatter,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
//		//star和fork的关系分析面板（小数值部分）
//		box.add(new ChartPanel(bigScatter,
//				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
				
		this.scrollPane = new ChartScrollPane(box);
		this.setLayout(new BorderLayout());
		this.setBackground(Colors.STAT_BG);
		this.add(this.scrollPane, BorderLayout.CENTER);
	}
	
	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}

}
