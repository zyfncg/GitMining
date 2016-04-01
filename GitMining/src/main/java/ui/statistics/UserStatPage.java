package ui.statistics;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import UserStatistic.GetUserStatistic.UserStatisticFactory;
import res.Colors;
import res.Strings;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.chart.Company;
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
	
	public UserStatPage(PanelSwitcher switcher) {
		//获取统计数据
		UserStatisticFactory factory = new UserStatisticFactory();
		//用户类型统计面板标题
		TitlePanel typeTitle = new TitlePanel(
				Strings.User.USER_TYPE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户类型统计面板
		UserType type = new UserType(factory,
				StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户注册时间统计面板标题
		TitlePanel regTitle = new TitlePanel(
				Strings.User.REGISTRY_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户注册时间统计面板
		UserCreateTime registry = new UserCreateTime(
				factory, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户参加项目数目统计面板标题
		TitlePanel involveTitle = new TitlePanel(
				Strings.User.INVOLVE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户参加项目数目统计面板
		NumbersofRepositoryInvolved involve = new NumbersofRepositoryInvolved(
				factory, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户创建项目数目统计面板标题
		TitlePanel createTitle = new TitlePanel(
				Strings.User.CREATE_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户创建项目数目统计面板
		NumbersofRepositoryCreated create = new NumbersofRepositoryCreated(
				factory, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//用户所属公司统计面板标题
		TitlePanel comTitle = new TitlePanel(
				Strings.User.COMPANY_TITLE,
				StatConst.PANEL_WIDTH, StatConst.TITLE_HEIGHT);
		//用户所属公司统计面板
		Company company = new Company(
				factory, StatConst.CHART_WIDTH, StatConst.CHART_HEIGHT);
		//组装统计面板
		Box box = Box.createVerticalBox();
		box.add(new BackPanel(() -> switcher.back(this, PanelSwitcher.RIGHT),
				StatConst.PANEL_WIDTH, StatConst.GAP,
				StatConst.GAP << 1, StatConst.GAP,
				null));
		box.add(typeTitle);
		box.add(new ChartPanel(type,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(regTitle);
		box.add(new ChartPanel(registry,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(involveTitle);
		box.add(new ChartPanel(involve,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
		box.add(createTitle);
		box.add(new ChartPanel(create,
				StatConst.PANEL_WIDTH, StatConst.PANEL_HEIGHT));
		box.add(new BoxStrut());
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
