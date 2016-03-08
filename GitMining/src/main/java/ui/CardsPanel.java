package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;

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
	 *@param service 获取项目信息的接口
	 *@param user 获取用户信息列表的接口
	 * @throws Exception 
	 */
	public static CardsPanel createProjectCards(JPanel page, PanelSwitcher switcher,
			int row, int lineNum, List<ProjectInfo> projects,
			RepositoryBLService service, UserBLService user) throws Exception {
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		int size = projects.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				final ProjectDetail detail = service.getRepositoryByName(
						projects.get(i * lineNum + j).getProjectName());
				ClickHandler handler = () ->{
					switcher.backableJump(page,
							new ProjectInfoPage(lineNum, MainFrame.PAGE_WIDTH,
									MainFrame.PAGE_HEIGHT, switcher, detail,
									service, user),
							PanelSwitcher.LEFT);
//					switcher.toFullScreen(page,
//							new ProjectInfoPage(lineNum, MainFrame.PAGE_WIDTH,
//									MainFrame.PAGE_HEIGHT, switcher, detail,
//									service, user));
					};
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
	 *@param repo 获取项目信息列表的接口
	 *@param u 获取用户信息列表的接口
	 * @throws Exception 
	 */
	public static CardsPanel createUserCards(JPanel page, PanelSwitcher switcher,
			int row, int lineNum, List<UserInfo> users,
			RepositoryBLService repo, UserBLService u) throws Exception {
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		int size = users.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				UserInfoDetail detail = u.getUserByName(
						users.get(i * lineNum + j).getUserName());
				ClickHandler handler = () -> {
					switcher.backableJump(page,
							new UserInfoPage(lineNum, MainFrame.PAGE_WIDTH,
									MainFrame.PAGE_HEIGHT, switcher,detail, repo, u),
							PanelSwitcher.LEFT);
				};
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
	 *@param row, 卡片的行数,用于确定面板的高度
	 *@param column, 卡片的列数，用于确定面板的宽度 
	 */
	public static CardsPanel createPlainPanel(int row, int column) {
		CardsPanel panel = new CardsPanel();
		Box box = Box.createVerticalBox();
		for(int i = 0; i < row; ++i) {
			box.add(createCardContainer(column));
		}
		panel.setLayout(new BorderLayout());
		panel.add(box, BorderLayout.CENTER);
		return panel;
	}
	
	/**
	 *创建承载信息卡片的容器
	 *@param size, 信息卡片的数量 
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
