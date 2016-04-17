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
	
	public UserCard(ClickHandler handler, UserInfo user) {
		super(handler, user.getUserName() + "," + user.getDescriptionUser());
		
		int itemW = CARD_WIDTH / 3;
		int itemH = CARD_HEIGHT >> 1;
		KVPanel projectInvolve = new KVPanel(itemW, itemH,
				Strings.User.INVOLVE_PROJECTS, String.valueOf(user.getProjectInvolved()),
				KVPanel.VERTICAL);
		KVPanel projectCreate = new KVPanel(itemW, itemH,
				Strings.User.CREATE_PROJECTS, String.valueOf(user.getProjectCreate()),
				KVPanel.VERTICAL);
		this.itemPanel.add(projectInvolve);
		this.itemPanel.add(projectCreate);
	}
}
