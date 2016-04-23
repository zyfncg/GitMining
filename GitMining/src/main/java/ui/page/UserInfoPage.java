package ui.page;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;
import ui.CardsManager;
import ui.ClickHandler;
import ui.MainFrame;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.BackPanel;
import ui.component.KVPanel;
import ui.component.ProjectCard;
import ui.component.SwitchPanel;

/**
 *用户详细信息页面 
 */
@SuppressWarnings("serial")
public class UserInfoPage extends JPanel implements Refreshable {

	/**
	 *显示的创建项目信息卡片的行数 
	 */
	private static final int ROW = 2;
	
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
	
	private RepositoryBLService repoService;
	
	private UserBLService userService;

	public UserInfoPage(int width, int height,
			PanelSwitcher switcher, UserInfoDetail detail,
			RepositoryBLService repo, UserBLService user) {
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
				Strings.User.DESCRIPTION_LABEL, detail.getDescriptionUser(), KVPanel.HORIZONTAL);
		KVPanel email = new KVPanel(width, itemH,
				Strings.User.EMAIL_LABEL, detail.getEmail(), KVPanel.HORIZONTAL);
		KVPanel company = new KVPanel(width, itemH,
				Strings.User.COMPANY_LABEL, detail.getCompany(), KVPanel.HORIZONTAL);
		KVPanel address = new KVPanel(width, itemH,
				Strings.User.ADDRESS_LABEL, detail.getAddress(), KVPanel.HORIZONTAL);
		info.add(description);
		info.add(email);
		info.add(company);
		info.add(address);

		//创建项目面板
		projects = detail.getProjectCreatInfo();
		infoContainer = new JPanel(new BorderLayout());
		infoContainer.setOpaque(false);
		infoPanel = this.createSwitchPanel(projects,
				infoContainer, ROW, Img.PROJECT_CREATED_TIP);
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

	/**
	 *创建可切换项目信息面板
	 */
	private SwitchPanel createSwitchPanel(List<ProjectInfo> list,
			JPanel parent, int row, Image image) {
		List<ProjectCard> cards = new ArrayList<>();
		for (ProjectInfo projectInfo : list) {
			cards.add(new ProjectCard(
					this.toDetailInfo(projectInfo),
					projectInfo));
		}
		CardsManager cm = new CardsManager(image,
				row, cards, parent, switcher);
		return cm.first();
	}
	
	/**
	 *获得由信息卡片跳转到详细信息页面的控制器 
	 */
	private ClickHandler toDetailInfo(ProjectInfo info) {
		ClickHandler handler = () -> {
			ProjectDetail detail = null;
			try {
				detail = repoService.getRepositoryByName(info.getProjectName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			
			switcher.backableJump(this,
					new ProjectInfoPage(MainFrame.PAGE_WIDTH,
							MainFrame.PAGE_HEIGHT, switcher,
							detail, repoService, userService),
					PanelSwitcher.LEFT);
		};
		return handler;
	}
	
	@Override
	public void refresh() {
		//TODO 暂时无事可做
	}
}
