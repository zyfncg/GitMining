package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Strings;
import ui.ClickHandler;
import ui.MainFrame;
import ui.PanelSwitcher;
import ui.page.ProjectInfoPage;
import ui.page.UserInfoPage;

/**
 *卡片信息面板
 *每个信息以一张卡片的形式展现 
 *面板中所有卡片排成一行
 *工厂模式创建项目卡片信息面板
 *和用户卡片信息面板
 */
@SuppressWarnings("serial")
public class CardsPanel extends JPanel {

	/**
	 *每个信息卡片之间的距离以及卡片和边界的距离 
	 */
	public static final int CARD_GAP = 10;

	/**
	 *信息卡片的宽度 
	 */
	public static final int CARD_WIDTH = 300;

	/**
	 *信息卡片的高度 
	 */
	public static final int CARD_HEIGHT = 200;

	private CardsPanel() {this.setOpaque(false);}

	/**
	 *根据项目信息创建信息面板
	 *每个项目信息以一个卡片的形式展现
	 *@param page 面板所在页面
	 *@param switcher 页面转换器
	 *@param row 信息卡片的行数
	 *@param lineNum 一行包括的信息卡片的数量
	 *@param projects 项目信息列表
	 *@param repoService 获取项目信息的接口
	 *@param userService 获取用户信息列表的接口
	 */
	public static CardsPanel createProjectCards(JPanel page, PanelSwitcher switcher,
			int row, int lineNum, List<ProjectInfo> projects,
			RepositoryBLService repoService, UserBLService userService){
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		int size = projects.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				final int index = i * lineNum + j;
				ClickHandler handler = createProjectCardHandler(index, lineNum,
						projects, page, switcher, repoService, userService);
				panel.add(new ProjectCard(handler,
						CARD_WIDTH, CARD_HEIGHT, projects.get(i * lineNum + j)));
			}
			//如果信息数目 <要显示的卡片数目，用空白卡片替代
			for(int k = j; k < lineNum; ++k) {
				panel.add(createPlainCard());
			}
			box.add(panel);
		}
		CardsPanel cards = new CardsPanel();
		cards.setLayout(new BorderLayout());
		cards.add(box, BorderLayout.CENTER);
		return cards;
	}

	/**
	 *根据用户信息创建信息面板
	 *每个用户信息以一个卡片的形式展现
	 *返回包含所有卡片的信息面板
	 *@param page 面板所在页面
	 *@param switcher 页面转换器
	 *@param row 信息卡片的行数
	 *@param lineNum 一行包括的信息卡片的数量
	 *@param users 用户信息列表
	 *@param repoService 获取项目信息列表的接口
	 *@param userService 获取用户信息列表的接口
	 */
	public static CardsPanel createUserCards(JPanel page, PanelSwitcher switcher,
			int row, int lineNum, List<UserInfo> users,
			RepositoryBLService repoService, UserBLService userService){
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		int size = users.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				final int index = i * lineNum + j;
				ClickHandler handler = createUserCardHandler(index, lineNum,
						users, page, switcher, repoService, userService);
				panel.add(new UserCard(handler,
						CARD_WIDTH, CARD_HEIGHT, users.get(i * lineNum + j)));
			}
			//如果信息数目 <要显示的卡片数目，用空白卡片替代
			for(int k = j; k < lineNum; ++k) {
				panel.add(createPlainCard());
			}
			box.add(panel);
		}
		CardsPanel cards = new CardsPanel();
		cards.setLayout(new BorderLayout());
		cards.add(box, BorderLayout.CENTER);
		return cards;
	}

	/**
	 *创建一个没有信息的面板
	 *@param 提示信息图片
	 *@param row, 卡片的行数,用于确定面板的高度
	 *@param column, 卡片的列数，用于确定面板的宽度 
	 */
	public static CardsPanel createPlainPanel(Image img,int row, int column) {
		CardsPanel panel = new CardsPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension d = this.getPreferredSize();
				g.drawImage(img,
						0, 0, d.width, d.height,
						0, 0, img.getWidth(null), img.getHeight(null),
						null);
			}
		};
		Box box = Box.createVerticalBox();
		for(int i = 0; i < row; ++i) {
			box.add(createCardContainer(column));
		}
		panel.setLayout(new BorderLayout());
		panel.add(box, BorderLayout.CENTER);
		return panel;
	}

	/**
	 * 创建用户信息卡片的监听器
	 * @param index 当前用户信息在用户信息列表中的下标
	 * @param lineNum 用户信信息页面一行信息卡片的数目
	 * @param users 用户信息列表
	 * @param page 面板所在页面
	 * @param switcher 页面切换器
	 * @param repoService 获得项目信息的接口
	 * @param userService 获得用户信息的接口
	 * @return
	 */
	private static ClickHandler createUserCardHandler(int index,
			int lineNum, List<UserInfo> users, JPanel page, PanelSwitcher switcher,
			RepositoryBLService repoService, UserBLService userService) {
		ClickHandler handler = () -> {
			UserInfo user = users.get(index);
			UserInfoDetail detail = null;
			try {
				detail = userService.getUserByName(user.getUserName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			UserInfoPage infoPage = new UserInfoPage(lineNum, MainFrame.PAGE_WIDTH,
					MainFrame.PAGE_HEIGHT, switcher, detail, repoService, userService);
			switcher.backableJump(page,
					infoPage,
					PanelSwitcher.LEFT);
		};
		return handler;
	}

	/**
	 * 创建项目信息卡片的监听器
	 * @param index 当前项目信息在项目信息列表中的下标
	 * @param lineNum 项目信信息页面一行信息卡片的数目
	 * @param users 项目信息列表
	 * @param page 面板所在页面
	 * @param switcher 页面切换器
	 * @param repoService 获得项目信息的接口
	 * @param userService 获得用户信息的接口
	 * @return
	 */
	private static ClickHandler createProjectCardHandler(int index,
			int lineNum, List<ProjectInfo> projects, JPanel page, PanelSwitcher switcher,
			RepositoryBLService repoService, UserBLService userService) {
		ClickHandler handler = () ->{
			ProjectInfo project = projects.get(index);
			ProjectDetail detail = null;
			try {
				detail = repoService.getRepositoryByName(project.getProjectName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			ProjectInfoPage infoPage = new ProjectInfoPage(lineNum, MainFrame.PAGE_WIDTH,
					MainFrame.PAGE_HEIGHT, switcher, detail,
					repoService, userService);
			switcher.backableJump(page, infoPage, PanelSwitcher.LEFT);
		};
		return handler;
	}

	/**
	 *创建承载信息卡片的容器
	 *@param size, 一行信息卡片的数量 
	 */
	private static CardsPanel createCardContainer(int size) {
		FlowLayout layout = new FlowLayout();
		layout.setVgap(CARD_GAP);
		layout.setHgap(CARD_GAP);
		CardsPanel panel = new CardsPanel();
		panel.setLayout(layout);
		int width = size * CARD_WIDTH + (size + 1) * CARD_GAP;
		int height = (CARD_GAP << 1) + CARD_HEIGHT;
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}

	/**
	 *创建一个空白卡片 
	 */
	private static JPanel createPlainCard() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
		return panel;
	}
}
