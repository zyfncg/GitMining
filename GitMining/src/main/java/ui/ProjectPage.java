package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;
import constant.Page;
import constant.SortType;

/**
 *项目信息主页 
 */
@SuppressWarnings("serial")
public class ProjectPage extends JPanel {
//	/**
//	 * 页面切换面板
//	 */
//	private SwitchPanel Switcher;
//	
//	/**
//	 *搜索框面板 
//	 */
//	private SearchPanel search;
//	
//	/**
//	 *排序依据面板 
//	 */
//	private JPanel sort;
//	
//	/**
//	 *无序 
//	 */
//	private JButton general;
//	
//	/**
//	 *根据star数量排序 
//	 */
//	private JButton star;
//	
//	/**
//	 *根据fork数量排序 
//	 */
//	private JButton fork;
//	
//	/**
//	 *根据contributor数量排序 
//	 */
//	private JButton contributor;
	
	
	public ProjectPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分为三个部分，搜索面板：排序面板：信息面板 = 1 : 1 : 4
		
		//搜索面板
		int searchH = height / 6;
		int searchW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		SearchPanel search = new SearchPanel(searchW, searchH, "项目名称");//TODO 字符串统一管理
		ClickHandler left =
				() -> switcher.jump(Page.PROJECT, Page.START, PanelSwitcher.RIGHT);
		ClickHandler right =
				() -> switcher.jump(Page.PROJECT, Page.USER, PanelSwitcher.LEFT);
		SwitchPanel switcherPanel = SwitchPanel.bothSides(left, right, search);
		
		//排序面板
		int sortH = searchH;
		int sortW = searchW;
		int btnH = sortH / 3;
		int btnW = sortW >> 2;
		btnW = (btnW > btnH * 3) ? (btnH * 3) : btnW;
		//四种排序依据
		SortButton general = new SortButton(btnW, btnH,
				"general", SortType.General);
		SortButton star = new SortButton(btnW, btnH,
				"star", SortType.Star);
		SortButton fork = new SortButton(btnW, btnH,
				"fork", SortType.Fork);
		SortButton contributor = new SortButton(
				btnW, btnH,"contributor", SortType.Contributors);
		//四个按钮的按钮面板
		FlowLayout inLayout = new FlowLayout();
		inLayout.setHgap(0);
		inLayout.setVgap(sortH / 3);
		JPanel btnPanel = new JPanel(inLayout);
		btnPanel.add(general);
		btnPanel.add(star);
		btnPanel.add(fork);
		btnPanel.add(contributor);
		//排序面板
		FlowLayout outLayout = new FlowLayout();
		outLayout.setHgap((width - sortW) >> 1); 
		outLayout.setVgap(0);
		JPanel sort = new JPanel(outLayout);
		sort.add(btnPanel);
		
		//TODO 具体信息获取
		//第一行信息卡片面板
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			projects.add(new ProjectInfo(null, null, 0, 0, 0));
		}
		CardsPanel line1 = CardsPanel.createProjectCards(projects);
		//第二行信息卡片面板
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			users.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel line2 = CardsPanel.createUserCards(users);
		//组合卡片面板，形成信息面板
		JPanel cards = new JPanel(new BorderLayout());
		Box box = Box.createVerticalBox();
		box.add(line1);
		box.add(line2);
		cards.add(box, BorderLayout.CENTER);
		SwitchPanel switchCards = SwitchPanel.rightOnly(null, cards);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(sort);
		container.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(container);
	}
	
	/**
	 *排序依据按钮 
	 */
	private class SortButton extends JButton {
		public SortButton(int width, int height, String text, SortType type) {
			this.setPreferredSize(new Dimension(width, height));
			this.setText(text);
			
		}
	}
}
