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

import Info.ProjectDetail;
import Info.ProjectInfo;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogic.businessLogicController.UserController.UserController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import constant.SortType;
import res.Colors;
import res.Img;
import res.Strings;
import ui.CardsManager;
import ui.ClickHandler;
import ui.MainFrame;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.ProjectCard;
import ui.component.SearchPanel;
import ui.component.SwitchButton;
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
	
	/**
	 *获取和处理项目信息的接口 
	 */
	private RepositoryBLService repository = new RepositoryController();
	
	/**
	 *获取和处理用户信息的接口 
	 */
	private UserBLService user = new UserController();
	
	/**
	 *包含所有项目信息的可切换面板 
	 */
	private SwitchPanel allInfoPanel;
	
	/**
	 *当前展示的是否是包含所有项目信息的可切换面板 
	 */
	private boolean isAllInfo = true;

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
	 *卡片管理器 
	 */
	private CardsManager cardsManager;
	
	/**
	 *项目信息面板的父容器
	 */
	private JPanel infoParent;
	
	/**
	 *卡片面板信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public ProjectPage(int width, int height, PanelSwitcher switcher) {
		this.switcher = switcher;
		//分为三个部分，搜索面板：排序面板：信息面板 = 1 : 1 : 4
		
		//信息面板
		this.infoParent = new JPanel(new BorderLayout());
		infoParent.setOpaque(false);
		//获取项目信息
		try {
			currentProjects = this.repository.getAllRepositorys();
		} catch (Exception e) {
			currentProjects = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		//创建项目信息显示面板
		this.allProjects = this.currentProjects;
		this.showingPanel = this.createSwitchPanel(currentProjects);
		this.allInfoPanel = this.showingPanel;
		infoParent.add(showingPanel, BorderLayout.CENTER);
		
		//搜索面板
		FlowLayout searchFL = new FlowLayout();
		int searchH = height / 18;	//搜索面板高度占总高度的1/6，搜索框高度占搜索面板高度的1/3
		int searchW = width - (SwitchButton.SWITCH_WIDTH << 3);
		searchFL.setVgap(searchH);
		searchFL.setHgap(SwitchButton.SWITCH_WIDTH);
		JPanel center = new JPanel(searchFL);
		int centerW = width - (SwitchButton.SWITCH_WIDTH << 1);
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
				SwitchButton.SWITCH_WIDTH << 1, searchH));
		statistics.addActionListener(e -> switcher.backableJump(this,
				new ProjectStatPage(switcher), PanelSwitcher.LEFT));
		statistics.setIcon(Img.STATISTICS);
		//将搜索框、搜索按钮和统计按钮添加到搜索面板
		center.add(search);
		center.add(statistics);
		SwitchButton pre = new SwitchButton(centerH, null);
		SwitchButton next = new SwitchButton(centerH, null);
		SwitchPanel switcherPanel = new SwitchPanel(center, pre, next);
		
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
	 *根据项目信息创建可切换卡片面板 
	 */
	private SwitchPanel createSwitchPanel(List<ProjectInfo> projects) {
		List<ProjectCard> cards = new ArrayList<>();
		int size = projects.size();
		ProjectInfo projectInfo = null;
		for (int i = 0; i < size; ++i) {
			projectInfo = projects.get(i);
			cards.add(new ProjectCard(
					this.toDetailInfo(projectInfo), projectInfo));
		}
		cardsManager = new CardsManager(Img.PROJECT_LIST_TIP, CARD_ROW,
				cards, infoParent, switcher);
		return cardsManager.first();
	}
	
	/**
	 *获得由信息卡片跳转到详细信息页面的控制器 
	 */
	private ClickHandler toDetailInfo(ProjectInfo info) {
		ClickHandler handler = () -> {
			ProjectDetail detail = null;
			try {
				detail = repository.getRepositoryByName(info.getProjectName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			switcher.backableJump(this,
					new ProjectInfoPage(MainFrame.PAGE_WIDTH,
							MainFrame.PAGE_HEIGHT, switcher,
							detail, repository, user),
					PanelSwitcher.LEFT);
		};
		return handler;
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
				return ;
			}
			
			//用户是否输入
			boolean isUserType = !(search.getText().isEmpty() || search.getText().equals(tip));
			//如果用户输入了搜索关键字
			if(isUserType) {
				this.showingPanel = cardsManager.getCurrentPanel();
				if(!this.isAllInfo) {
					cardsManager.free();
					this.currentProjects.clear();
				}
				SwitchPanel to = this.createSwitchPanel(result);
				this.switcher.jump(infoParent,
						this.showingPanel, to,
						PanelSwitcher.LEFT);
				this.showingPanel = to;
				this.currentProjects = result;
				this.isAllInfo = false;
			}else if(!this.isAllInfo){//如果用户没有输入搜索关键字，则显示所有信息
				this.showingPanel = cardsManager.getCurrentPanel();
				if(!this.isAllInfo) {
					cardsManager.free();
					this.currentProjects.clear();
				}
				this.switcher.jump(infoParent,
						showingPanel, allInfoPanel,
						PanelSwitcher.LEFT);
				this.showingPanel = this.allInfoPanel;
				this.currentProjects = this.allProjects;
				this.isAllInfo = true;
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
			this.cardsManager.free();
			SwitchPanel to = this.createSwitchPanel(currentProjects);
			this.switcher.jump(infoParent,
					this.showingPanel, to,
					PanelSwitcher.LEFT);
			this.showingPanel = to;
		};
		return handler;
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
		//重新获取所有项目信息
		try {
			currentProjects = repository.getAllRepositorys();
		} catch (Exception e) {
			currentProjects = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		cardsManager.free();
		SwitchPanel to = this.createSwitchPanel(allProjects);
		this.switcher.jump(infoParent,
				showingPanel, to,
				PanelSwitcher.LEFT);
		this.allProjects.clear();
		this.allProjects = this.currentProjects;
		this.isAllInfo = true;
		this.showingPanel = to;
		this.allInfoPanel = to;
	}
}
