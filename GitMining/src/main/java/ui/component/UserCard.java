package ui.component;

import Info.UserInfo;
import res.Strings;
import ui.ClickHandler;

/**
 *用户信息的简介
 *以卡片的形式展现 
 */
@SuppressWarnings("serial")
public class UserCard extends Card {
	
	public UserCard(ClickHandler handler, int width, int height, UserInfo user) {
		super(handler, width, height,
				user.getUserName() + "," + user.getDescriptionUser());
		
		int itemW = width / 3;
		KVPanel projectInvolve = new KVPanel(itemW, height,
				Strings.User.INVOLVE_PROJECTS, String.valueOf(user.getProjectInvolved()),
				KVPanel.VERTICAL);
		KVPanel projectCreate = new KVPanel(itemW, height,
				Strings.User.CREATE_PROJECTS, String.valueOf(user.getProjectCreate()),
				KVPanel.VERTICAL);
		this.itemPanel.add(projectInvolve);
		this.itemPanel.add(projectCreate);
	}
}
