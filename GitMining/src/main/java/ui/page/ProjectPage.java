package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
import ui.ClickHandler;
import ui.InfoManager;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.SearchPanel;
import ui.component.SwitchPanel;

/**
 *项目信息主页 
 */
@SuppressWarnings("serial")
public class ProjectPage extends JPanel implements Refreshable {
	
//	private RepositoryBLService repository = new RepositoryController_Stub();
//	
//	private UserBLService user = new UserController_Stub();
	
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
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *展现项目信息的面板 
	 */
	private JPanel infoPanel;
	
	/**
	 *一行显示的信息卡片数量 
	 */
	private int lineCard;
	
	/**
	 *显示的信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public ProjectPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		this.switcher = switcher;
		this.lineCard = lineCardNum;
		//分为三个部分，搜索面板：排序面板：信息面板 = 1 : 1 : 4
		
		//信息面板
		this.infoPanel = new JPanel(new BorderLayout());	//项目信息面板
		infoPanel.setOpaque(false);
		allProjects = null;
		try {
			allProjects = this.repository.getAllRepositorys();
		} catch (Exception e) {
			//TODO 异常处理
			allProjects = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		currentProjects = allProjects;
		SwitchPanel projectPanel = InfoManager.getProjectInfoPanel(
				allProjects, infoPanel, switcher, lineCard,
				this, CARD_ROW, repository, user,
				Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		currentPanel = projectPanel;
		infoPanel.add(currentPanel, BorderLayout.CENTER);
		
		//搜索面板
		int searchH = height / 6;
		int searchW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		String tip = Strings.PROJECT_SEARCH_TIP;
		SearchPanel search = new SearchPanel(searchW, searchH, tip);
		search.setClickHandler(this.getSearchHandler(
				search, tip));
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
		general.setHandler(this.getSortHandler(SortType.General, m, general));
		SortButton star = new SortButton(btnW, btnH,
				Img.STAR_SELECT, Img.STAR_NOT_SELECT, SortType.Star);
		star.setHandler(this.getSortHandler(SortType.Star, m, star));
		SortButton fork = new SortButton(btnW, btnH,
				Img.FORK_SELECT, Img.FORK_NOT_SELECT, SortType.Fork);
		fork.setHandler(this.getSortHandler(SortType.Fork, m,
				fork));
		SortButton contributor = new SortButton(btnW, btnH,
				Img.CONTRIBUTOR_SELECT, Img.CONTRIBUTOR_NOT_SELECT, SortType.Contributors);
		contributor.setHandler(this.getSortHandler(SortType.Contributors,
				m, contributor));
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
		container.add(infoPanel);
		container.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(container);
		this.setBackground(Colors.PAGE_BG);
	}
	
	/**
	 *点击搜索按钮后的事件处理 
	 *@param search 搜索面板
	 *@param tip 搜索框的提示信息
	 */
	private ClickHandler getSearchHandler(SearchPanel search,
			String tip) {
		ClickHandler handler = () -> {
			List<ProjectInfo> result = null;
			try {
				result = repository.searchRepositorys(search.getText());
			} catch (Exception e1) {
				// TODO 异常处理
				result = new ArrayList<>();
				JOptionPane.showMessageDialog(null, e1.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			}
			if(search.getText().isEmpty() || search.getText().equals(tip)) {
				this.jump(allProjects, PanelSwitcher.RIGHT);
			}else {
				this.jump(result, PanelSwitcher.LEFT);
			}
		};
		return handler;
	}
	
	/**
	 *获得排序按钮被点击后的事件处理 
	 *@param type 排序类型
	 *@param manager 按钮管理器
	 *@param button 被点击的按钮
	 *@param direction 面板切换的方向
	 */
	private ClickHandler getSortHandler(SortType type, ButtonManager manager,
			SortButton button) {
		ClickHandler handler = () -> {
			currentProjects = repository.SortSearchRepositorys(type, currentProjects);
			manager.setSelect(button);
			jump(currentProjects, PanelSwitcher.LEFT);
		};
		return handler;
	}
	
	/**
	 *从当前项目信息面板跳转到
	 *根据新的项目信息创建的面板
	 *@param projects 项目信息 
	 *@param direction 面板切换的方向
	 */
	private void jump(List<ProjectInfo> projects,
			int direction) {
		JPanel from = currentPanel.getCurrentPanel();
		SwitchPanel to = InfoManager.getProjectInfoPanel(
				projects, infoPanel, switcher,
				lineCard, this, CARD_ROW, repository, user,
				Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoPanel, from, to, direction);
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

	@Override
	public void refresh() {
		SwitchPanel current = this.currentPanel.getCurrentPanel();
		try {
			if(allProjects == null || allProjects.isEmpty()) {
				allProjects = repository.getAllRepositorys();
			}
		} catch (Exception e) {
			allProjects = new ArrayList<>();
		}
		SwitchPanel to = InfoManager.getProjectInfoPanel(allProjects,
				infoPanel, switcher, lineCard, this, CARD_ROW,
				repository, user, Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoPanel, current, to, PanelSwitcher.LEFT);
		currentPanel = to;
	}
}
