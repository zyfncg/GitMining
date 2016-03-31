package ui.statistics;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import UserStatistic.GetUserStatistic.UserStatisticFactory;
import res.Colors;
import ui.Refreshable;
import ui.chart.Company;
import ui.chart.NumbersofRepositoryCreated;
import ui.chart.NumbersofRepositoryInvolved;
import ui.chart.UserCreateTime;
import ui.chart.UserType;
import ui.component.MyScrollBar;

/**
 *用户信息统计结果页面 
 */
@SuppressWarnings("serial")
public class UserStatPage extends JPanel implements Refreshable {
	
	private JScrollPane scrollPane;
	
	public UserStatPage() {
		//获取统计数据
		UserStatisticFactory factory = new UserStatisticFactory();
		//用户类型统计数据
		UserType type = new UserType(factory,
				StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//用户注册时间
		UserCreateTime registry = new UserCreateTime(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//用户参加项目数目
		NumbersofRepositoryInvolved involve = new NumbersofRepositoryInvolved(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//用户创建项目数目
		NumbersofRepositoryCreated create = new NumbersofRepositoryCreated(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//用户所属公司
		Company company = new Company(
				factory, StatConst.STAT_WIDTH, StatConst.STAT_HEIGHT);
		//组装统计面板
		Box box = Box.createVerticalBox();
		box.add(type);
		box.add(new BoxStrut());
		box.add(registry);
		box.add(new BoxStrut());
		box.add(involve);
		box.add(new BoxStrut());
		box.add(create);
		box.add(new BoxStrut());
		box.add(company);
		
		this.scrollPane = new JScrollPane(box);
		this.scrollPane.getVerticalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.getHorizontalScrollBar().setUI(new MyScrollBar());
		this.scrollPane.setOpaque(false);
		this.scrollPane.getViewport().setOpaque(false);
		
		this.setLayout(new BorderLayout());
		this.add(this.scrollPane, BorderLayout.CENTER);
		this.setBackground(Colors.STAT_BG);
	}

	@Override
	public void refresh() {
		// TODO 暂时无事可做
	}

}
