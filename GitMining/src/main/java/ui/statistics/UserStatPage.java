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
import ui.chart.NumbersofRepositoryCreated;
import ui.chart.NumbersofRepositoryInvolved;
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
	 *用户参与项目数目直方图统计数据 
	 */
	private static final HistogramInfo INVOLVE_HISTOGRAM =
			DATA_FACTORY.GetHistogramJoin().getUsrHistogramInfo();
	
	/**
	 *用户参与项目数目直方图标签 
	 */
	private static final HistogramLabel INVOLVE_LABEL = new HistogramLabel(
			Strings.User.INVOLVE_HISTOGRAM_TITLE, Strings.User.INVOLVE_PROJECTS);
	
	/**
	 *用户创建项目数目折线图统计数据 
	 */
	private static final List<CreatRepositoryStatistics> CREATE_LINE =
			DATA_FACTORY.GetCreatRepository().getCreatRepositoryStatistic();
	
	/**
	 *用户创建项目数目直方图统计数据 
	 */
	private static final HistogramInfo CREATE_HISTOGRAM =
			DATA_FACTORY.GetHistogramCreat().getUsrHistogramInfo();
	
	/**
	 *用户创建项目数目直方图标签 
	 */
	private static final HistogramLabel CREATE_LABEL = new HistogramLabel(
			Strings.User.CREATE_HISTOGRAM_TITLE, Strings.User.CREATE_PROJECTS);
	
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
		//用户参与项目数目分布统计面板
		Histogram involveHistogram = new Histogram(INVOLVE_HISTOGRAM,
				INVOLVE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
//		//用户创建项目数目变化趋势统计面板标题
//		TitlePanel createTitle = new TitlePanel(
//				Strings.User.CREATE_LINE_TITLE,
//				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
//		//用户创建项目数目变化趋势统计面板
//		NumbersofRepositoryCreated create = new NumbersofRepositoryCreated(
//				CREATE_LINE, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建项目数目分布统计面板
		Histogram createHistogram = new Histogram(CREATE_HISTOGRAM,
				CREATE_LABEL, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
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
		//用户参与项目数目分布统计面板
		box.add(new ChartPanel(involveHistogram,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
//		//用户创建项目数目变化趋势统计面板
//		box.add(createTitle);
//		box.add(new ChartPanel(create,
//				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
//		box.add(new BoxStrut());
		//用户创建项目数目分布统计面板
		box.add(new ChartPanel(createHistogram,
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
