package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;

/**
 *用户详细信息页面 
 */
@SuppressWarnings("serial")
public class UserInfoPage extends JPanel {
	
	public UserInfoPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分成4部分， 图像面板：信息面板：创建项目面板：参与项目面板 = 1 : 1 : 2 : 2
		
		//图像面板
		int iconH = height / 6;
		int btnH = iconH / 3;
		int btnW = btnH << 1;
		BackPanel icon = new BackPanel(width, iconH, btnW, btnH);
		
		//信息面板
		Box info = Box.createVerticalBox();
		int itemH = iconH >> 2;
		Item description = new Item(width, itemH,
				"description:Linus, father of Linux");  //TODO 具体信息,信息过长则分开
		Item email = new Item(width, itemH,
				"email:linus@example.com");
		Item company = new Item(width, itemH,
				"company:who knows");
		Item address = new Item(width, itemH,
				"address:may be America");
		info.add(description);
		info.add(email);
		info.add(company);
		info.add(address);
		
		//创建项目面板
		//TODO 具体信息获取
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			projects.add(new ProjectInfo(null, null, 0, 0, 0));
		}
		CardsPanel c1 = CardsPanel.createProjectCards(projects);
		SwitchPanel create = SwitchPanel.rightOnly(null, c1);
		
		//参与项目面板
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			users.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel c2 = CardsPanel.createUserCards(users);
		SwitchPanel involve = SwitchPanel.rightOnly(null, c2);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.add(icon);
		all.add(info);
		all.add(create);
		all.add(involve);
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
			txtLabel.setHorizontalAlignment(JLabel.CENTER);
			
			this.setPreferredSize(new Dimension(width, height));
			this.setLayout(new BorderLayout());
			this.add(txtLabel, BorderLayout.CENTER);
		}
	}
}
