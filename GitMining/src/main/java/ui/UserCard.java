package ui;

import Info.UserInfo;

/**
 *用户信息的简介
 *以卡片的形式展现 
 */
@SuppressWarnings("serial")
public class UserCard extends Card {
	
	//TODO, 以后用具体的信息填充
	public UserCard(ClickHandler handler, int width, int height, UserInfo user) {
		super(handler, width, height, "Linus, an interesting programmer");
		
		int itemW = width >> 2;
		ItemPanel projectInvolve = new ItemPanel(itemW, height, "参与项目", "20");
		ItemPanel projectCreate = new ItemPanel(itemW, height, "创建项目", "10");
		this.itemPanel.add(projectInvolve);
		this.itemPanel.add(projectCreate);
	}
}
