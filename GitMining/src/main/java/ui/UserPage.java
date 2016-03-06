package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import constant.Page;
import stub.RepositoryController_Stub;
import stub.UserController_Stub;

/**
 *用户信息主页 
 */
@SuppressWarnings("serial")
public class UserPage extends JPanel{
	
	private UserBLService user = new UserController_Stub();
	
	private RepositoryBLService repository = new RepositoryController_Stub();
	
	/**
	 *所有的用户信息 
	 */
	private List<UserInfo> allUsers;
	
	/**
	 *当前页面所显示的用户信息 面板
	 */
	private SwitchPanel currentPanel;
	
	/**
	 *显示的信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public UserPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分为3部分，图像面板：搜索面板：信息面板 = 1 : 1 : 4;
		
		//信息面板
		allUsers = null;
		try {
			allUsers = this.user.getAllUsers();
		} catch (Exception e) {
			//TODO 处理异常
			//					String msg = e.getMessage();
		}	
		JPanel switchCards = new JPanel(new BorderLayout());
		SwitchPanel userPanel = null;
		try {
			userPanel = InfoManager.getUserInfoPanel(
					allUsers, switchCards, switcher, lineCardNum,
					CARD_ROW, this, repository, user);
		} catch (Exception e) {
			// TODO 异常处理
		}
		currentPanel = userPanel;
		switchCards.add(currentPanel, BorderLayout.CENTER);
		
		//图像面板
		int iconW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		int iconH = height / 6;
		JPanel icon = new JPanel();
		icon.setPreferredSize(new Dimension(iconW, iconH));
		ClickHandler handler =
				() -> switcher.jump(Page.USER, Page.PROJECT, PanelSwitcher.RIGHT);
		SwitchPanel switcherPanel = SwitchPanel.leftOnly(handler, icon);
		
		//搜索面板
		int searchW = iconW;
		int searchH = iconH;
		String tip = "用户名";//TODO 字符串统一处理
		SearchPanel s = new SearchPanel(searchW, searchH, tip);
		s.setClickHandler(this.getSearchHandler(
				s, tip, switcher, switchCards, lineCardNum));
		FlowLayout layout = new FlowLayout();
		layout.setHgap(SwitchPanel.SWITCH_WIDTH);
		layout.setVgap(0);
		JPanel search = new JPanel(layout);
		search.add(s);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(search);
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
			List<UserInfo> users = null;
			try {
				users = user.searchUsers(search.getText());
			} catch (Exception e1) {
				// TODO 异常处理
			}
			if(search.getText().isEmpty() || search.getText().equals(tip)) {
				this.jump(allUsers, switcher, parent, col, PanelSwitcher.RIGHT);
			}else {
				this.jump(users, switcher, parent, col, PanelSwitcher.LEFT);
			}
		};
		return handler;
	}
	
	/**
	 *从当前用户信息面板跳转到
	 *根据新的用户信息创建的面板
	 *@param projects 用户信息 
	 *@param switcher 页面切换器
	 *@param parent 面板的父容器
	 *@param col 面板显示的信息卡片列数
	 *@param direction 面板切换的方向
	 */
	private void jump(List<UserInfo> users, PanelSwitcher switcher,
			JPanel parent, int col, int direction) {
		JPanel from = currentPanel.getCurrentPanel();
		SwitchPanel to = null;
		try {
			to = InfoManager.getUserInfoPanel(
					users, parent, switcher, col,
					CARD_ROW, this, repository, user);
		} catch (Exception e) {
			// TODO 异常处理
		}
		switcher.jump(parent, from, to, direction);
		currentPanel = to;
	}
	
//	private SwitchPanel getUserInfoPanel(List<UserInfo> users,
//			JPanel parent, PanelSwitcher switcher, int lineCardNum) {
//		if(users.size() == 0) {
//			CardsPanel panel = CardsPanel.createPlainPanel(CARD_ROW, lineCardNum);
//			return SwitchPanel.noSwitch(panel);
//		}else{
//			SwitchPanel p = new SwitchPanel();
//			try {
//				return p.userListPanel(users, this, parent, switcher,
//						CARD_ROW, lineCardNum, repository, user);
//			} catch (Exception e) {
//				// TODO 处理异常
//			}
//			return null;
//		}
//	}
}
