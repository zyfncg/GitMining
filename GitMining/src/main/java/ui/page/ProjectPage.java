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
import ui.statistics.ProjectStatPage;

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
	 *当前显示的项目信息 
	 */
	private List<ProjectInfo> currentProjects;
	
	/**
	 *所有项目信息 
	 */
	private List<ProjectInfo> allProjects;
	
	/**
	 *当前页面所显示的项目信息面板
	 */
	private SwitchPanel showingPanel;
	
	/**
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *项目信息面板的父容器
	 */
	private JPanel infoParent;
	
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
		this.infoParent = new JPanel(new BorderLayout());
		infoParent.setOpaque(false);
		try {
			currentProjects = this.repository.getAllRepositorys();
		} catch (Exception e) {
			currentProjects = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		allProjects = currentProjects;
		showingPanel = InfoManager.getProjectInfoPanel(
				currentProjects, infoParent, switcher, lineCard,
				this, CARD_ROW, repository, user,
				Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		infoParent.add(showingPanel, BorderLayout.CENTER);
		
		//搜索面板
		FlowLayout searchFL = new FlowLayout();
		int searchH = height / 18;	//搜索面板高度占总高度的1/6，搜索框高度占搜索面板高度的1/3
		int searchW = width - (SwitchPanel.SWITCH_WIDTH << 3);
		searchFL.setVgap(searchH);
		searchFL.setHgap(SwitchPanel.SWITCH_WIDTH);
		JPanel center = new JPanel(searchFL);
		int centerW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		int centerH = height / 6;
		center.setPreferredSize(new Dimension(centerW, centerH));
		center.setOpaque(false);
		//搜索框与搜索按钮
		String tip = Strings.Project.PROJECT_SEARCH_TIP;
		SearchPanel search = new SearchPanel(searchW, searchH, tip);
		search.setClickHandler(this.getSearchHandler(
				search, tip));
		//统计按钮
		JButton statistics = new JButton();
		statistics.setPreferredSize(new Dimension(
				SwitchPanel.SWITCH_WIDTH << 1, searchH));
		statistics.addActionListener(e -> switcher.backableJump(this,
				new ProjectStatPage(switcher), PanelSwitcher.LEFT));
		statistics.setIcon(Img.STATISTICS);
		//将搜索框、搜索按钮和统计按钮添加到搜索面板
		center.add(search);
		center.add(statistics);
		SwitchPanel switcherPanel = SwitchPanel.noSwitch(center, null);
		
		//排序面板
		int sortH = centerH;
		int sortW = searchW;
		int btnH = sortH / 3;
		int btnW = sortW >> 2;
		btnW = (btnW > btnH * 3) ? (btnH * 3) : btnW;
		//四种排序依据
		ButtonManager manager = new ButtonManager();
		SortButton general = new SortButton(btnW, btnH,
				Img.GENERAL_SELECT, Img.GENERAL_NOT_SELECT, SortType.General);
		general.setHandler(this.getSortHandler(SortType.General, manager, general));
		SortButton star = new SortButton(btnW, btnH,
				Img.STAR_SELECT, Img.STAR_NOT_SELECT, SortType.Star);
		star.setHandler(this.getSortHandler(SortType.Star, manager, star));
		SortButton fork = new SortButton(btnW, btnH,
				Img.FORK_SELECT, Img.FORK_NOT_SELECT, SortType.Fork);
		fork.setHandler(this.getSortHandler(SortType.Fork, manager,
				fork));
		SortButton contributor = new SortButton(btnW, btnH,
				Img.CONTRIBUTOR_SELECT, Img.CONTRIBUTOR_NOT_SELECT, SortType.Contributors);
		contributor.setHandler(this.getSortHandler(SortType.Contributors,
				manager, contributor));
		manager.add(general);
		manager.add(star);
		manager.add(fork);
		manager.add(contributor);
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
		container.add(infoParent);
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
			} catch (Exception e) {
				result = new ArrayList<>();
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			}
			
			//如果用户没有输入搜索关键字，则从当前项目信息面板跳转到当前项目信息面板
			if(search.getText().isEmpty() || search.getText().equals(tip)) {
				this.jump(allProjects, PanelSwitcher.RIGHT);
			}else {//否则，跳转到查询结果信息面板
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
		SwitchPanel from = this.showingPanel.getCurrentPanel();
		//释放面板占用的资源
		from.clearPanelList();
		
		SwitchPanel to = InfoManager.getProjectInfoPanel(
				projects, infoParent, switcher,
				lineCard, this, CARD_ROW, repository, user,
				Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoParent, from, to, direction);
		showingPanel = to;
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
		SwitchPanel current = this.showingPanel.getCurrentPanel();
		try {
			if(currentProjects == null || currentProjects.isEmpty()) {
				currentProjects = repository.getAllRepositorys();
			}
		} catch (Exception e) {
			currentProjects = new ArrayList<>();
		}
		current.clearPanelList();
		SwitchPanel to = InfoManager.getProjectInfoPanel(currentProjects,
				infoParent, switcher, lineCard, this, CARD_ROW,
				repository, user, Img.PROJECT_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoParent, current, to, PanelSwitcher.LEFT);
		showingPanel = to;
	}
}
