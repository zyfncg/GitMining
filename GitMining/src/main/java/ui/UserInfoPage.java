package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Info.ProjectInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;

/**
 *用户详细信息页面 
 */
@SuppressWarnings("serial")
public class UserInfoPage extends JPanel {
	
	/**
	 *显示的创建项目信息卡片的行数 
	 */
	private static final int CREATE_ROW = 2;
	
	public UserInfoPage(int lineCardNum, int width, int height,
			PanelSwitcher switcher, UserInfoDetail user,
			RepositoryBLService service, UserBLService u) {
		//分成4部分， 图像面板：信息面板：创建项目面板：参与项目面板 = 1 : 1 : 2 : 2
		
		//图像面板
		int iconH = height / 6;
		int btnH = iconH / 3;
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(handler, width, iconH, btnW, btnH);
		
		//信息面板
		Box info = Box.createVerticalBox();
		int itemH = iconH >> 2;
		Item description = new Item(width, itemH,
				user.getDescriptionUser());  //TODO 具体信息,信息过长则分开
		Item email = new Item(width, itemH,
				"email:" + user.getEmail());//TODO 字符串统一处理
		Item company = new Item(width, itemH,
				"company:" + user.getCompany());
		Item address = new Item(width, itemH,
				"address:" + user.getAddress());
		info.add(description);
		info.add(email);
		info.add(company);
		info.add(address);
		
		//创建项目面板
		List<ProjectInfo> p1 = user.getProjectCreatInfo();
		JPanel switchCards = new JPanel(new BorderLayout());
		SwitchPanel create = null;
		try {
			create = InfoManager.getProjectInfoPanel(
					p1, switchCards, switcher, lineCardNum, this, CREATE_ROW, service, u);
		} catch (Exception e) {
			// TODO 异常处理
		}
		switchCards.add(create, BorderLayout.CENTER);
		
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.add(icon);
		all.add(info);
		all.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
	}
	
	/**
	 *信息项面板 
	 */
	private class Item extends JPanel {
		
		public Item(int width, int height, String text) {
			JLabel txtLabel = new JLabel(text);
			txtLabel.setFont(new Font("斜体", Font.ITALIC, 15));
			txtLabel.setForeground(Color.BLUE);
			txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			this.setPreferredSize(new Dimension(width, height));
			this.setLayout(new BorderLayout());
			this.add(txtLabel, BorderLayout.CENTER);
		}
	}
}
