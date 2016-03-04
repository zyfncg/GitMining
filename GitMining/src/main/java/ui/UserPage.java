package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;
import constant.Page;

/**
 *用户信息主页 
 */
@SuppressWarnings("serial")
public class UserPage extends JPanel{
	
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
		
		//TODO 信息获取
		//第一行信息卡片
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			projects.add(new ProjectInfo(null, null, 0, 0, 0));
		}
		CardsPanel line1 = CardsPanel.createProjectCards(projects);
		//第二行信息卡片
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			users.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel line2 = CardsPanel.createUserCards(users);
		//组合信息卡片，形成信息面板
		JPanel cards = new JPanel(new BorderLayout());
		Box box = Box.createVerticalBox();
		box.add(line1);
		box.add(line2);
		cards.add(box, BorderLayout.CENTER);
		SwitchPanel switchCards = SwitchPanel.rightOnly(null, cards);
		
		//组合所有面板
		Box container = Box.createVerticalBox();
		container.add(switcherPanel);
		container.add(search);
		container.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(container);
	}
}
