package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import Info.ProjectInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import constant.Page;
import constant.SortType;
import stub.RepositoryController_Stub;
import stub.UserController_Stub;

/**
 *项目信息主页 
 */
@SuppressWarnings("serial")
public class ProjectPage extends JPanel {
	
	private RepositoryBLService repository = new RepositoryController_Stub();
	
	private UserBLService user = new UserController_Stub();
	
	/**
	 *所有的项目信息 
	 */
	private List<ProjectInfo> allProjects;
	
	/**
	 *当前显示的项目信息 
	 */
	private List<ProjectInfo> currentProjects;
	
	/**
	 *当前页面所显示的项目信息 面板
	 */
	private SwitchPanel currentPanel;
	
	/**
	 *显示的信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public ProjectPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分为三个部分，搜索面板：排序面板：信息面板 = 1 : 1 : 4
		
		//信息面板
		JPanel switchCards = new JPanel(new BorderLayout());	//项目信息面板
		allProjects = null;
		try {
			allProjects = this.repository.getAllRepositorys();
		} catch (Exception e) {
			//TODO 异常处理
		}
		currentProjects = allProjects;
		SwitchPanel projectPanel = null;
		try {
			projectPanel = InfoManager.getProjectInfoPanel(
					allProjects, switchCards, switcher, lineCardNum,
					this, CARD_ROW, repository, user);
		} catch (Exception e) {
			// TODO 异常处理
		}
		currentPanel = projectPanel;
		switchCards.add(currentPanel, BorderLayout.CENTER);
		
		//搜索面板
		int searchH = height / 6;
		int searchW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		String tip = "项目名称";//TODO 字符串统一管理
		SearchPanel search = new SearchPanel(searchW, searchH, tip);
		search.setClickHandler(this.getSearchHandler(
				search, tip, switcher, switchCards, lineCardNum));
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
				"general", SortType.General, 
				this.getSortHandler(SortType.General, switcher, switchCards, lineCardNum));
		SortButton star = new SortButton(btnW, btnH,
				"star", SortType.Star,
				this.getSortHandler(SortType.Star, switcher, switchCards, lineCardNum));
		SortButton fork = new SortButton(btnW, btnH,
				"fork", SortType.Fork,
				this.getSortHandler(SortType.Fork, switcher, switchCards, lineCardNum));
		SortButton contributor = new SortButton(btnW, btnH,
				"contributor", SortType.Contributors,
				this.getSortHandler(SortType.Contributors, switcher, switchCards, lineCardNum));
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
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(sort);
		container.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(container);
	}
	
	/**
	 *点击搜索按钮后的事件处理 
	 *@param search 搜索面板
	 *@param tip 搜索框的提示信息
	 *@param switcher 页面跳转器
	 *@param parent 信息面板的父容器
	 *@param col 信息面板一行的信息卡片数量
	 */
	private ClickHandler getSearchHandler(SearchPanel search,
			String tip, PanelSwitcher switcher,
			JPanel parent, int col) {
		ClickHandler handler = () -> {
			List<ProjectInfo> result = null;
			try {
				result = repository.searchRepositorys(search.getText());
			} catch (Exception e1) {
				// TODO 异常处理
			}
			if(search.getText().isEmpty() || search.getText().equals(tip)) {
				this.jump(allProjects, switcher, parent, col, PanelSwitcher.RIGHT);
			}else {
				this.jump(result, switcher, parent, col, PanelSwitcher.LEFT);
			}
		};
		return handler;
	}
	
	/**
	 *获得排序按钮被点击后的事件处理 
	 *@param type 排序类型
	 *@param switcher 页面切换器
	 *@param parent 项目信息面板的父容器
	 *@param col 信息面板显示的信息卡片的列数
	 *@param direction 面板切换的方向
	 */
	private ClickHandler getSortHandler(SortType type,
			PanelSwitcher switcher, JPanel parent, int col) {
		ClickHandler handler = () -> {
			currentProjects = repository.SortSearchRepositorys(type, currentProjects);
			jump(currentProjects, switcher, parent, col, PanelSwitcher.LEFT);
		};
		return handler;
	}
	
	/**
	 *从当前项目信息面板跳转到
	 *根据新的项目信息创建的面板
	 *@param projects 项目信息 
	 *@param switcher 页面切换器
	 *@param parent 面板的父容器
	 *@param col 面板显示的信息卡片列数
	 *@param direction 面板切换的方向
	 */
	private void jump(List<ProjectInfo> projects, PanelSwitcher switcher,
			JPanel parent, int col, int direction) {
		JPanel from = currentPanel.getCurrentPanel();
		SwitchPanel to = null;
		try {
			to = InfoManager.getProjectInfoPanel(
					projects, parent, switcher,
					col, this, CARD_ROW, repository, user);
		} catch (Exception e) {
			// TODO 异常处理
		}
		switcher.jump(parent, from, to, direction);
		currentPanel = to;
		currentProjects = projects;
	}
	
//	/**
//	 *将所有项目信息传入，让面板自行管理信息面板的跳转
//	 *@param projects 所有的项目信息
//	 *@param parent 项目信息面板的父容器
//	 *@param switcher 面板转换器
//	 *@param 项目面板一行所要显示的项目信息数量 
//	 */
//	private SwitchPanel getProjectInfoPanel(List<ProjectInfo> projects,
//			JPanel parent, PanelSwitcher switcher, int lineCardNum) {
//		if(projects.size() == 0) {
//			CardsPanel panel = CardsPanel.createPlainPanel(CARD_ROW, lineCardNum);
//			return SwitchPanel.noSwitch(panel);
//		}else{
//			SwitchPanel p = new SwitchPanel();
//			try {
//				return p.projectListPanel(projects, this, parent,
//						switcher, CARD_ROW, lineCardNum, repository, user);
//			} catch (Exception e) {
//				// TODO 异常处理
//			}
//			return null;
//		}
//	}
	
	/**
	 *排序依据按钮 
	 */
	private class SortButton extends JButton {
		public SortButton(int width, int height, String text,
				SortType type, ClickHandler handler) {
			this.setPreferredSize(new Dimension(width, height));
			this.setText(text);
			this.addActionListener(e -> {
				handler.handle();
			});
		}
	}
}
