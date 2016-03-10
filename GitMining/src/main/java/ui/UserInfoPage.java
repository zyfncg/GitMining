package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.ProjectInfo;
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
public class UserInfoPage extends JPanel implements Refreshable {

	/**
	 *显示的创建项目信息卡片的行数 
	 */
	private static final int CREATE_ROW = 2;
	
	/**
	 *创建项目信息面板的容器 
	 */
	private JPanel infoContainer;
	
	/**
	 *创建项目信息面板 
	 */
	private SwitchPanel infoPanel;
	
	/**
	 *项目信息 
	 */
	private List<ProjectInfo> projects;
	
	private PanelSwitcher switcher;
	
	private int lineCard;
	
	private RepositoryBLService repoService;
	
	private UserBLService userService;

	public UserInfoPage(int lineCardNum, int width, int height,
			PanelSwitcher switcher, UserInfoDetail detail,
			RepositoryBLService repo, UserBLService user) {
		this.lineCard = lineCardNum;
		this.switcher = switcher;
		this.repoService = repo;
		this.userService = user;
		//分成4部分， 图像面板：信息面板：创建项目面板：参与项目面板 = 1 : 1 : 2 : 2

		//图像面板
		int iconH = height / 6;
		int btnH = iconH / 3;
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(
				handler, width, iconH, btnW, btnH, Img.USER_ICON);

		//信息面板
		Box info = Box.createVerticalBox();
		info.setOpaque(false);
		int itemH = iconH >> 2;
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
		projects = detail.getProjectCreatInfo();
		infoContainer = new JPanel(new BorderLayout());
		infoContainer.setOpaque(false);
		infoPanel = InfoManager.getProjectInfoPanel(
				projects, infoContainer, switcher, lineCardNum,
				this, CREATE_ROW, repo, user,
				Img.PROJECT_CREATED_TIP, Img.LARGE_NULL_TIP);
		infoContainer.add(infoPanel, BorderLayout.CENTER);


		//组装所有面板
		Box all = Box.createVerticalBox();
		all.setOpaque(false);
		all.add(icon);
		all.add(info);
		all.add(infoContainer);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(Colors.PAGE_BG);
	}

	@Override
	public void refresh() {
		SwitchPanel from = this.infoPanel.getCurrentPanel();
		SwitchPanel to = InfoManager.getProjectInfoPanel(projects, infoContainer,
				switcher, lineCard, this, CREATE_ROW,
				this.repoService, this.userService,
				Img.PROJECT_CREATED_TIP, Img.LARGE_NULL_TIP);
		this.switcher.jump(infoContainer, from, to, PanelSwitcher.LEFT);
		this.infoPanel = to;
	}
}
