package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Info.ProjectInfo;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogic.businessLogicController.UserController.UserController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import constant.SortType;
import res.Colors;
import res.Img;
import res.Strings;

/**
 *项目信息主页 
 */
@SuppressWarnings("serial")
public class ProjectPage extends JPanel {
	
	private RepositoryBLService repository = new RepositoryController();
	
	private UserBLService user = new UserController();
	
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
		switchCards.setOpaque(false);
		allProjects = null;
		try {
			allProjects = this.repository.getAllRepositorys();
		} catch (Exception e) {
			//TODO 异常处理
		}
		currentProjects = allProjects;
		SwitchPanel projectPanel = InfoManager.getProjectInfoPanel(
				allProjects, switchCards, switcher, lineCardNum,
				this, CARD_ROW, repository, user, Img.PROJECT_LIST_TIP);
		currentPanel = projectPanel;
		switchCards.add(currentPanel, BorderLayout.CENTER);
		
		//搜索面板
		int searchH = height / 6;
		int searchW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		String tip = Strings.PROJECT_SEARCH_TIP;
		SearchPanel search = new SearchPanel(searchW, searchH, tip);
		search.setClickHandler(this.getSearchHandler(
				search, tip, switcher, switchCards, lineCardNum));
//		ClickHandler left =
//				() -> switcher.jump(Page.PROJECT, Page.START, PanelSwitcher.RIGHT);
//		ClickHandler right =
//				() -> switcher.jump(Page.PROJECT, Page.USER, PanelSwitcher.LEFT);
		SwitchPanel switcherPanel = SwitchPanel.noSwitch(search, null);
//				bothSides(left, right, search);
		
		//排序面板
		int sortH = searchH;
		int sortW = searchW;
		int btnH = sortH / 3;
		int btnW = sortW >> 2;
		btnW = (btnW > btnH * 3) ? (btnH * 3) : btnW;
		//四种排序依据
		ButtonManager m = new ButtonManager();
		SortButton general = new SortButton(btnW, btnH,
				Img.GENERAL_SELECT, Img.GENERAL_NOT_SELECT, SortType.General);
		general.setHandler(this.getSortHandler(SortType.General, m, general,
						switcher, switchCards, lineCardNum));
		SortButton star = new SortButton(btnW, btnH,
				Img.STAR_SELECT, Img.STAR_NOT_SELECT, SortType.Star);
		star.setHandler(this.getSortHandler(SortType.Star, m, star,
				switcher, switchCards, lineCardNum));
		SortButton fork = new SortButton(btnW, btnH,
				Img.FORK_SELECT, Img.FORK_NOT_SELECT, SortType.Fork);
		fork.setHandler(this.getSortHandler(SortType.Fork, m,
				fork, switcher, switchCards, lineCardNum));
		SortButton contributor = new SortButton(btnW, btnH,
				Img.CONTRIBUTOR_SELECT, Img.CONTRIBUTOR_NOT_SELECT, SortType.Contributors);
		contributor.setHandler(this.getSortHandler(SortType.Contributors,
				m, contributor, switcher, switchCards, lineCardNum));
		m.add(general);
		m.add(star);
		m.add(fork);
		m.add(contributor);
		//四个按钮的按钮面板
		FlowLayout inLayout = new FlowLayout();
		inLayout.setHgap(0);
		inLayout.setVgap(sortH / 3);
		JPanel btnPanel = new JPanel(inLayout);
		btnPanel.setOpaque(false);
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
		sort.setOpaque(false);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(sort);
		container.add(switchCards);
		container.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(container);
		this.setBackground(Colors.PAGE_BG);
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
	 *@param manager 按钮管理器
	 *@param button 被点击的按钮
	 *@param switcher 页面切换器
	 *@param parent 项目信息面板的父容器
	 *@param col 信息面板显示的信息卡片的列数
	 *@param direction 面板切换的方向
	 */
	private ClickHandler getSortHandler(SortType type, ButtonManager manager,
			SortButton button, PanelSwitcher switcher, JPanel parent, int col) {
		ClickHandler handler = () -> {
			currentProjects = repository.SortSearchRepositorys(type, currentProjects);
			manager.setSelect(button);
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
		SwitchPanel to = InfoManager.getProjectInfoPanel(
				projects, parent, switcher,
				col, this, CARD_ROW, repository, user, null);//TODO 给出项目信息的图片
		switcher.jump(parent, from, to, direction);
		currentPanel = to;
		currentProjects = projects;
	}
	
	/**
	 *排序依据按钮 
	 */
	private class SortButton extends JButton {
		
		private ImageIcon select;
		
		private ImageIcon notSelect;
		
		private ClickHandler handler;
		
		public SortButton(int width, int height, ImageIcon select,
				ImageIcon notSelect, SortType type) {
			this.setIcon(notSelect);
			this.select = select;
			this.notSelect = notSelect;
			this.setPreferredSize(new Dimension(width, height));
			this.addActionListener(e -> {
				handler.handle();
			});
		}
		
		public void setSelect() {
			this.setIcon(this.select);
		}
		
		public void setNotSelect() {
			this.setIcon(this.notSelect);
		}
		
		public void setHandler(ClickHandler handler) {
			this.handler = handler;
		}
	}
	
	/**
	 *按钮管理器，用户按钮其图标的显示 
	 */
	private class ButtonManager {
		private List<SortButton> list = new ArrayList<>();
		
		public void add(SortButton button) {
			list.add(button);
		}
		
		public void setSelect(SortButton button) {
			for (SortButton btn : list) {
				if(btn == button) {
					btn.setSelect();
				}else {
					btn.setNotSelect();
				}
			}
			repaint();
		}
	}
}
