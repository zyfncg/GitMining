package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;

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
			PanelSwitcher switcher, UserInfo user,
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
		info.setOpaque(false);
		int itemH = iconH >> 2;
		UserInfoDetail detail = null;
		try {
			detail = u.getUserByName(user.getUserName());
		} catch (Exception e1) {
			// TODO 异常处理
		}
		KVPanel description = new KVPanel(width, itemH,
				Strings.DESCRIPTION_LABEL, detail.getDescriptionUser(), KVPanel.HORIZONTAL);
		KVPanel email = new KVPanel(width, itemH,
				Strings.EMAIL_LABEL, detail.getEmail(), KVPanel.HORIZONTAL);
		KVPanel company = new KVPanel(width, itemH,
				Strings.COMPANY_LABEL, detail.getCompany(), KVPanel.HORIZONTAL);
		KVPanel address = new KVPanel(width, itemH,
				Strings.ADDRESS_LABEL, detail.getAddress(), KVPanel.HORIZONTAL);
		info.add(description);
		info.add(email);
		info.add(company);
		info.add(address);

		//创建项目面板
		List<ProjectInfo> p1 = detail.getProjectCreatInfo();
		JPanel switchCards = new JPanel(new BorderLayout());
		switchCards.setOpaque(false);
		SwitchPanel create = InfoManager.getProjectInfoPanel(
				p1, switchCards, switcher, lineCardNum,
				this, CREATE_ROW, service, u, Img.PROJECT_CREATED_TIP);//TODO 给出创建项目的图片;
		switchCards.add(create, BorderLayout.CENTER);


		//组装所有面板
		Box all = Box.createVerticalBox();
		all.setOpaque(false);
		all.add(icon);
		all.add(info);
		all.add(switchCards);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(Colors.PAGE_BG);
	}
}
