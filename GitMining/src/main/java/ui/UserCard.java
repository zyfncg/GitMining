package ui;

import Info.UserInfo;

/**
 *用户信息的简介
 *以卡片的形式展现 
 */
@SuppressWarnings("serial")
public class UserCard extends Card {
	
	//TODO 字符串统一管理
	public UserCard(ClickHandler handler, int width, int height, UserInfo user) {
		super(handler, width, height,
				user.getUserName() + "," + user.getDescriptionUser());
		
		int itemW = width / 3;
		ItemPanel projectInvolve = new ItemPanel(itemW, height,
				"参与项目人数", String.valueOf(user.getProjectInvolved()));
		ItemPanel projectCreate = new ItemPanel(itemW, height,
				"创建项目人数", String.valueOf(user.getProjectCreate()));
		this.itemPanel.add(projectInvolve);
		this.itemPanel.add(projectCreate);
	}
}
