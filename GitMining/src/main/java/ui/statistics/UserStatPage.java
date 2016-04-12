package ui.statistics;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.HistogramInfo;
import Info.UsrStatisticInfo.CatalogStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import res.Colors;
import res.Strings;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.chart.Company;
import ui.chart.Histogram;
import ui.chart.HistogramLabel;
import ui.chart.NumbersOfRepositoryByUsers;
import ui.chart.ScatterChart;
import ui.chart.ScatterLabel;
import ui.chart.UserCreateTime;
import ui.chart.UserType;
import ui.component.BackPanel;
import ui.component.ChartScrollPane;
import ui.component.TitlePanel;

/**
 *用户信息统计结果页面 
 */
@SuppressWarnings("serial")
public class UserStatPage extends JPanel implements Refreshable {
	
	private ChartScrollPane scrollPane;
	
	/**
	 *统计数据 
	 */
	private static final UserStatisticFactory DATA_FACTORY = new UserStatisticFactory();
	
	/**
	 *用户类型统计数据 
	 */
	private static final List<CatalogStatistics> TYPE_STAT =
			DATA_FACTORY.GetCatalog().getCatalogStatistic();
	
	/**
	 *用户注册时间统计数据 
	 */
	private static final List<CreatTimeStatistics> TIME_STAT =
			DATA_FACTORY.GetCreatTime().getCreatTimeStatistic();
	
	/**
	 *用户参与项目数目折线图统计数据 
	 */
	private static final List<JoinRepositoryStatistics> INVOLVE_LINE =
			DATA_FACTORY.GetJoinRepository().getJoinRepositoryStatistic();
	
	/**
	 *用户参与项目数目直方图统计数据 （小数值部分）
	 */
	private static final HistogramInfo SMALL_INVOLVE_HISTOGRAM =
			DATA_FACTORY.GetHistogramJoin().getSmallUsrHistogramInfo();
	
	/**
	 *用户参与项目数目直方图统计数据 （大数值部分）
	 */
	private static final HistogramInfo BIG_INVOLVE_HISTOGRAM =
			DATA_FACTORY.GetHistogramJoin().getBigUsrHistogramInfo();
	
	/**
	 *用户参与项目数目直方图标签 （小数值部分）
	 */
	private static final HistogramLabel SMALL_INVOLVE_LABEL = new HistogramLabel(
			Strings.User.SMALL_INVOLVE_HISTOGRAM_TITLE, Strings.User.INVOLVE_PROJECTS);
	
	/**
	 *用户参与项目数目直方图标签 （大数值部分）
	 */
	private static final HistogramLabel BIG_INVOLVE_LABEL = new HistogramLabel(
			Strings.User.BIG_INVOLVE_HISTOGRAM_TITLE, Strings.User.INVOLVE_PROJECTS);
	
	/**
	 *用户创建项目数目折线图统计数据 
	 */
	private static final List<CreatRepositoryStatistics> CREATE_LINE =
			DATA_FACTORY.GetCreatRepository().getCreatRepositoryStatistic();
	
	/**
	 *用户创建项目数目直方图统计数据 （小数值部分）
	 */
	private static final HistogramInfo SMALL_CREATE_HISTOGRAM =
			DATA_FACTORY.GetHistogramCreat().getSmallUsrHistogramInfo();
	
	/**
	 *用户创建项目数目直方图统计数据 （大数值部分）
	 */
	private static final HistogramInfo BIG_CREATE_HISTOGRAM =
			DATA_FACTORY.GetHistogramCreat().getBigUsrHistogramInfo();
	
	/**
	 *用户创建项目数目直方图标签 （小数值部分）
	 */
	private static final HistogramLabel SMALL_CREATE_LABEL = new HistogramLabel(
			Strings.User.SMALL_CREATE_HISTOGRAM_TITLE, Strings.User.CREATE_PROJECTS);
	
	/**
	 *用户创建项目数目直方图标签 （大数值部分）
	 */
	private static final HistogramLabel BIG_CREATE_LABEL = new HistogramLabel(
			Strings.User.BIG_CREATE_HISTOGRAM_TITLE, Strings.User.CREATE_PROJECTS);
	
	/**
	 *用户所属公司统计数据 
	 */
	private static final List<CompanyStatistics> COM_STAT =
			DATA_FACTORY.GetCompany().getCompanyStatistic();
	
	public UserStatPage(PanelSwitcher switcher) {
		//用户类型统计面板标题
		TitlePanel typeTitle = new TitlePanel(
				Strings.User.USER_TYPE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户类型统计面板
		UserType type = new UserType(TYPE_STAT,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户注册时间统计面板标题
		TitlePanel regTitle = new TitlePanel(
				Strings.User.REGISTRY_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户注册时间统计面板
		UserCreateTime registry = new UserCreateTime(
				TIME_STAT, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户参加项目数目和创建项目标题
		TitlePanel involveTitle = new TitlePanel(
				Strings.User.INVOLVE_CREATE_LINE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户参加项目和创建数目统计面板
		NumbersOfRepositoryByUsers involve_create = new NumbersOfRepositoryByUsers(
				CREATE_LINE, INVOLVE_LINE, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户参与项目数目分布统计面板（小数值部分）
		Histogram smallInvolve = new Histogram(SMALL_INVOLVE_HISTOGRAM,
				SMALL_INVOLVE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户参与项目数目分布统计面板（小数值部分）
		Histogram bigInvolve = new Histogram(BIG_INVOLVE_HISTOGRAM,
				BIG_INVOLVE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
//		//用户创建项目数目变化趋势统计面板标题
//		TitlePanel createTitle = new TitlePanel(
//				Strings.User.CREATE_LINE_TITLE,
//				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
//		//用户创建项目数目变化趋势统计面板
//		NumbersofRepositoryCreated create = new NumbersofRepositoryCreated(
//				CREATE_LINE, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建项目数目分布统计面板（小数值部分）
		Histogram smallCreate = new Histogram(SMALL_CREATE_HISTOGRAM,
				SMALL_CREATE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建项目数目分布统计面板（大数值部分）
		Histogram bigCreate = new Histogram(BIG_CREATE_HISTOGRAM,
				BIG_CREATE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建数目与参与数目之间关系分析（小数值部分）
		double[][] data1 = new double[2][];
		data1[0] = SMALL_CREATE_HISTOGRAM.getAllNum();
		data1[1] = SMALL_INVOLVE_HISTOGRAM.getAllNum();
		int min1 = SMALL_CREATE_HISTOGRAM.getMinNum();
		int max1 = SMALL_CREATE_HISTOGRAM.getMaxNum();
		ScatterChart smallNum = new ScatterChart(
				new ScatterLabel(Strings.User.SMALL_CREATE_INVOLVE_RELATION,
						Strings.User.CREATE_PROJECTS, Strings.User.INVOLVE_PROJECTS),
				data1, min1, max1, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建数目与参与数目之间关系分析（小数值部分）
		double[][] data2 = new double[2][];
		data2[0] = BIG_CREATE_HISTOGRAM.getAllNum();
		data2[1] = BIG_INVOLVE_HISTOGRAM.getAllNum();
		int min2 = BIG_CREATE_HISTOGRAM.getMinNum();
		int max2 = BIG_CREATE_HISTOGRAM.getMaxNum();
		ScatterChart bigNum = new ScatterChart(
				new ScatterLabel(Strings.User.BIG_CREATE_INVOLVE_RELATION,
						Strings.User.CREATE_PROJECTS, Strings.User.INVOLVE_PROJECTS),
				data2, min2, max2, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户所属公司统计面板标题
		TitlePanel comTitle = new TitlePanel(
				Strings.User.COMPANY_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户所属公司统计面板
		Company company = new Company(
				COM_STAT, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		
		
		//组装统计面板
		Box box = Box.createVerticalBox();
		//回退按钮面板
		box.add(new BackPanel(() -> switcher.back(this, PanelSwitcher.RIGHT),
				StatConst.PANEL_WIDTH, StatConst.GAP,
				StatConst.GAP << 1, StatConst.GAP,
				null));
		//用户类型统计面板
		box.add(typeTitle);
		box.add(new ChartPanel(type,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户注册时间统计面板
		box.add(regTitle);
		box.add(new ChartPanel(registry,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户参与项目数目变化趋势统计面板
		box.add(involveTitle);
		box.add(new ChartPanel(involve_create,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户参与项目数目分布统计面板（小数值部分）
		box.add(new ChartPanel(smallInvolve,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户参与项目数目分布统计面板（大数值部分）
		box.add(new ChartPanel(bigInvolve,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
//		//用户创建项目数目变化趋势统计面板
//		box.add(createTitle);
//		box.add(new ChartPanel(create,
//				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
//		box.add(new BoxStrut());
		//用户创建项目数目分布统计面板（小数值部分）
		box.add(new ChartPanel(smallCreate,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户创建项目数目分布统计面板（大数值部分）
		box.add(new ChartPanel(bigCreate,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户创建项目与参与项目之间关系的分析（小数值部分）
		box.add(new ChartPanel(smallNum,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//用户创建项目与参与项目之间关系的分析（大数值部分）
		box.add(new ChartPanel(bigNum,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		//公司创建项目个数统计面板
		box.add(comTitle);
		box.add(new ChartPanel(company,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		
		this.scrollPane = new ChartScrollPane(box);
		this.setLayout(new BorderLayout());
		this.add(this.scrollPane, BorderLayout.CENTER);
		this.setBackground(Colors.STAT_BG);
	}

	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}

}
