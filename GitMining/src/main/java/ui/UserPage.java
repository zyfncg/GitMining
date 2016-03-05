package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.UserInfo;
import businessLogicService.UserBLService.UserBLService;
import constant.Page;
import stub.UserController_Stub;

/**
 *用户信息主页 
 */
@SuppressWarnings("serial")
public class UserPage extends JPanel{
	
	private UserBLService user = new UserController_Stub();
	
	private int userNum = 0;
	
	private int userIndex = 0;
	
	/**
	 *显示的信息卡片的行数 
	 */
	private static final int CARD_ROW = 2;
	
	public UserPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分为3部分，图像面板：搜索面板：信息面板 = 1 : 1 : 4;
		
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
		SearchPanel s = new SearchPanel(searchW, searchH, "用户名");//TODO 字符串统一处理
		FlowLayout layout = new FlowLayout();
		layout.setHgap(SwitchPanel.SWITCH_WIDTH);
		layout.setVgap(0);
		JPanel search = new JPanel(layout);
		search.add(s);
		
		//信息面板
		List<UserInfo> allUsers = null;
		try {
			allUsers = this.user.getAllUsers();
		} catch (Exception e) {
			//TODO 处理异常
			String msg = e.getMessage();
		}	
		this.userNum = allUsers.size();
		this.userIndex = 0;
		CardsPanel panel = null;
		if(this.userNum == 0) {
			panel = CardsPanel.createPlainPanel(CARD_ROW, lineCardNum);
		}else{
			int total = CARD_ROW * lineCardNum;
			List<UserInfo> info = new ArrayList<UserInfo>();
			for(int i = 0; i < userNum && i < total; ++i) {
				info.add(allUsers.get(i));
			}
			panel = CardsPanel.createUserCards(switcher, CARD_ROW, lineCardNum, info);
			userIndex += info.size();
		}
		SwitchPanel switchCards = SwitchPanel.rightOnly(null, panel);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(search);
		container.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(container);
	}
}
