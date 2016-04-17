package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogic.businessLogicController.UserController.UserController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;
import ui.CardsManager;
import ui.ClickHandler;
import ui.MainFrame;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.SearchPanel;
import ui.component.SwitchButton;
import ui.component.SwitchPanel;
import ui.component.UserCard;
import ui.statistics.UserStatPage;

/**
 *用户信息主页 
 */
@SuppressWarnings("serial")
public class UserPage extends JPanel implements Refreshable {
	
//	private UserBLService user = new UserController_Stub();
//	
//	private RepositoryBLService repository = new RepositoryController_Stub();
	
	private UserBLService user = new UserController();
	
	private RepositoryBLService repository = new RepositoryController();
	
//	/**
//	 *所有的用户信息 
//	 */
//	private List<UserInfo> allUsers;
	
	/**
	 *当前展现的用户信息 
	 */
	private List<UserInfo> currentUsers;
	
	/**
	 *拥有所有用户信息的可切换面板
	 */
	private SwitchPanel allInfoPanel;
	
	/**
	 *当前面板是否显示所有用户信息 
	 */
	private boolean isAllInfo = true;
	
	/**
	 *当前页面所显示的用户信息 面板
	 */
	private SwitchPanel currentPanel;
	
	/**
	 *展现用户信息的面板
	 */
	private JPanel infoParent;
	
	/**
	 *页面转换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *卡片信息管理器 
	 */
	private CardsManager cardsManager;
	
	/**
	 *卡片面板信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public UserPage(int width, int height, PanelSwitcher switcher) {
		this.switcher = switcher;
		//分为3部分，图像面板：搜索面板：信息面板 = 1 : 1 : 4;
		
		//信息面板
		try {
			currentUsers = this.user.getAllUsers();
		} catch (Exception e) {
			currentUsers = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}	
		infoParent = new JPanel(new BorderLayout());
		infoParent.setOpaque(false);
		SwitchPanel userPanel = this.createSwitchPanel(currentUsers);
		currentPanel = userPanel;
		allInfoPanel = currentPanel;
		infoParent.add(currentPanel, BorderLayout.CENTER);
		
		//图像面板
		int iconW = width - (SwitchButton.SWITCH_WIDTH << 1);
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
		SwitchButton preBtn = new SwitchButton(iconH, null);
		SwitchButton nextBtn = new SwitchButton(iconH, null);
		SwitchPanel switcherPanel = new SwitchPanel(icon, preBtn, nextBtn);
		
		//搜索面板
		FlowLayout layout = new FlowLayout();
		int centerW = width - (SwitchButton.SWITCH_WIDTH << 1);
		int centerH = iconH;
		int searchW = width - (SwitchButton.SWITCH_WIDTH << 3);
		int searchH = centerH / 3;
		layout.setHgap(SwitchButton.SWITCH_WIDTH);
		layout.setVgap(searchH);
		JPanel center = new JPanel(layout);
		center.setPreferredSize(new Dimension(centerW, centerH));
		center.setOpaque(false);
		//搜索框和搜索按钮
		String tip = Strings.User.USER_SEARCH_TIP;
		SearchPanel search = new SearchPanel(searchW, searchH, tip);
		search.setClickHandler(this.getSearchHandler(search, tip));
		//统计按钮
		JButton statistics = new JButton();
		int btnW = SwitchButton.SWITCH_WIDTH << 1;
		int btnH = searchH;
		statistics.setPreferredSize(new Dimension(btnW, btnH));
		statistics.addActionListener(e -> switcher.backableJump(
				this, new UserStatPage(switcher), PanelSwitcher.LEFT));
		statistics.setIcon(Img.STATISTICS);
		//将搜索框、搜索按钮和统计按钮添加到搜索面板
		center.add(search);
		center.add(statistics);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.setOpaque(false);
		container.add(switcherPanel);
		container.add(center);
		container.add(infoParent);
		this.setLayout(new BorderLayout());
		this.add(container);
		this.setBackground(Colors.PAGE_BG);
	}
	
	/**
	 *根据用户信息创建可切换卡片面板 
	 */
	private SwitchPanel createSwitchPanel(List<UserInfo> users) {
		List<UserCard> cards = new ArrayList<>();
		for (UserInfo userInfo : users) {
			cards.add(new UserCard(
					this.toDetailInfo(userInfo), userInfo));
		}
		cardsManager = new CardsManager(Img.PROJECT_LIST_TIP, CARD_ROW,
				cards, infoParent, switcher);
		return cardsManager.first();
	}
	
	/**
	 *获得由信息卡片跳转到详细信息页面的控制器 
	 */
	private ClickHandler toDetailInfo(UserInfo info) {
		ClickHandler handler = () -> {
			UserInfoDetail detail = null;
			try {
				detail = user.getUserByName(info.getUserName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			
			switcher.backableJump(this,
					new UserInfoPage(MainFrame.PAGE_WIDTH,
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
	private ClickHandler getSearchHandler(SearchPanel search, String tip) {
		ClickHandler handler = () -> {
			List<UserInfo> users = null;
			try {
				users = user.searchUsers(search.getText());
			} catch (Exception e) {
				users = new ArrayList<>();
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			}
			
			//用户是否输入
			boolean isUserType = !(search.getText().isEmpty() || search.getText().equals(tip));
			//如果用户输入了搜索关键字
			if(isUserType) {
				this.currentPanel = cardsManager.getCurrentPanel();
				if(!this.isAllInfo) {
					this.cardsManager.free();
					this.currentUsers.clear();
				}
				SwitchPanel to = this.createSwitchPanel(users);
				this.switcher.jump(infoParent,
						this.currentPanel, to,
						PanelSwitcher.LEFT);
				this.currentPanel = to;
				this.currentUsers = users;
				this.isAllInfo = false;
			}else if(!this.isAllInfo){//如果用户没有输入搜索关键字，则显示所有信息
				this.currentPanel = cardsManager.getCurrentPanel();
				if(!this.isAllInfo) {
					cardsManager.free();
				}
				this.switcher.jump(infoParent,
						this.currentPanel, allInfoPanel,
						PanelSwitcher.LEFT);
				this.currentPanel = this.allInfoPanel;
				this.isAllInfo = true;
			}
		};
		return handler;
	}
	
	@Override
	public void refresh() {
		//重新获取所有用户信息
		try {
			currentUsers = user.getAllUsers();
		} catch (Exception e) {
			currentUsers = new ArrayList<>();
			JOptionPane.showMessageDialog(null, e.getMessage(),
					Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			return ;
		}

		this.cardsManager.free();
		SwitchPanel to = this.createSwitchPanel(currentUsers);
		this.switcher.jump(infoParent,
				this.currentPanel, to,
				PanelSwitcher.LEFT);
		this.isAllInfo = true;
		this.currentPanel = to;
		this.allInfoPanel = to;
	}
}
