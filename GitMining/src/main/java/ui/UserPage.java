package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;
import stub.RepositoryController_Stub;
import stub.UserController_Stub;

/**
 *用户信息主页 
 */
@SuppressWarnings("serial")
public class UserPage extends JPanel implements Refreshable {
	
	private UserBLService user = new UserController_Stub();
	
	private RepositoryBLService repository = new RepositoryController_Stub();
	
//	private UserBLService user = new UserController();
//	
//	private RepositoryBLService repository = new RepositoryController();
	
	/**
	 *所有的用户信息 
	 */
	private List<UserInfo> allUsers;
	
	/**
	 *当前页面所显示的用户信息 面板
	 */
	private SwitchPanel currentPanel;
	
	/**
	 *展现用户信息的面板
	 */
	private JPanel infoPanel;
	
	/**
	 *页面转换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *一行显示的用户信息卡片数目 
	 */
	private int lineCard;
	
	/**
	 *显示的信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public UserPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		this.switcher = switcher;
		this.lineCard = lineCardNum;
		//分为3部分，图像面板：搜索面板：信息面板 = 1 : 1 : 4;
		
		//信息面板
		allUsers = null;
		try {
			allUsers = this.user.getAllUsers();
		} catch (Exception e) {
			//TODO 处理异常
			allUsers = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}	
		infoPanel = new JPanel(new BorderLayout());
		infoPanel.setOpaque(false);
		SwitchPanel userPanel = InfoManager.getUserInfoPanel(
				allUsers, infoPanel, switcher, lineCardNum,
				CARD_ROW, this, repository, user,
				Img.USER_LIST_TIP, Img.LARGE_NULL_TIP);
		currentPanel = userPanel;
		infoPanel.add(currentPanel, BorderLayout.CENTER);
		
		//图像面板
		int iconW = width - (SwitchPanel.SWITCH_WIDTH << 1);
		int iconH = height / 6;
		JPanel icon = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(Img.USER_ICON,
						0, 0, iconW, iconH,
						0, 0, Img.USER_ICON.getWidth(null), Img.USER_ICON.getHeight(null),
						null);
			}
		};
		icon.setOpaque(false);
		icon.setPreferredSize(new Dimension(iconW, iconH));
//		ClickHandler handler = 
//				() -> switcher.jump(Page.USER, Page.PROJECT, PanelSwitcher.RIGHT);
		SwitchPanel switcherPanel = SwitchPanel.noSwitch(icon, null);
//				.leftOnly(handler, icon, null);
		
		//搜索面板
		int searchW = iconW;
		int searchH = iconH;
		String tip = Strings.USER_SEARCH_TIP;
		SearchPanel s = new SearchPanel(searchW, searchH, tip);
		s.setClickHandler(this.getSearchHandler(s, tip));
		FlowLayout layout = new FlowLayout();
		layout.setHgap(SwitchPanel.SWITCH_WIDTH);
		layout.setVgap(0);
		JPanel search = new JPanel(layout);
		search.setOpaque(false);
		search.add(s);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.setOpaque(false);
		container.add(switcherPanel);
		container.add(search);
		container.add(infoPanel);
		this.setLayout(new BorderLayout());
		this.add(container);
		this.setBackground(Colors.PAGE_BG);
	}
	
	/**
	 *点击搜索按钮后的事件处理 
	 *@param search 搜索面板
	 *@param tip 搜索框的提示信息
	 */
	private ClickHandler getSearchHandler(SearchPanel search, String tip) {
		ClickHandler handler = () -> {
			List<UserInfo> users = null;
			try {
				users = user.searchUsers(search.getText());
			} catch (Exception e1) {
				// TODO 异常处理
				users = new ArrayList<>();
				JOptionPane.showMessageDialog(null, e1.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			}
			if(search.getText().isEmpty() || search.getText().equals(tip)) {
				this.jump(allUsers, PanelSwitcher.RIGHT);
			}else {
				this.jump(users, PanelSwitcher.LEFT);
			}
		};
		return handler;
	}
	
	/**
	 *从当前用户信息面板跳转到
	 *根据新的用户信息创建的面板
	 *@param projects 用户信息 
	 *@param direction 面板切换的方向
	 *@param image 切换面板的
	 */
	private void jump(List<UserInfo> users, int direction) {
		JPanel from = currentPanel.getCurrentPanel();
		SwitchPanel to = InfoManager.getUserInfoPanel(
				users, infoPanel, switcher, lineCard,
				CARD_ROW, this, repository, user,
				Img.USER_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoPanel, from, to, direction);
		currentPanel = to;
	}

	@Override
	public void refresh() {
		SwitchPanel current = this.currentPanel.getCurrentPanel();
		try {
			if(allUsers == null || allUsers.isEmpty()) {
				allUsers = this.user.getAllUsers();
			}
		} catch (Exception e) {
			allUsers = new ArrayList<>();
		}
		SwitchPanel to = InfoManager.getUserInfoPanel(allUsers, infoPanel,
				switcher, lineCard, CARD_ROW, this, repository, user,
				Img.USER_LIST_TIP, Img.LARGE_NULL_TIP);
		switcher.jump(infoPanel, current, to, PanelSwitcher.LEFT);
		currentPanel = to;
	}
	
}
