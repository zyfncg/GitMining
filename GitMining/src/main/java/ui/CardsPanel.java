package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
import Info.UserInfoDetail;
import constant.Page;

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

	private CardsPanel() {}
	
	/**
	 *根据项目信息创建信息面板
	 *每个项目信息以一个卡片的形式展现
	 **@param row, 信息卡片的行数
	 *@param lineNum, 一行包括的信息卡片的数量
	 *@param users, 用户信息列表
	 */
	public static CardsPanel createProjectCards(PanelSwitcher switcher,
			int row, int lineNum, List<ProjectInfo> projects) {
		Box box = Box.createVerticalBox();
		int size = projects.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				ClickHandler handler = () ->
					switcher.jump(Page.PROJECT,
							new ProjectInfoPage(lineNum, MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT, switcher,
									new ProjectDetail("OS kernel", "C", "https://www.github.com",//TODO 获取具体信息 
											new ProjectName("Linus", "Linux"), 100, 200, 300, 400,1)),
							PanelSwitcher.LEFT);
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
	 *@param row, 信息卡片的行数
	 *@param lineNum, 一行包括的信息卡片的数量
	 *@param users, 用户信息列表
	 */
	public static CardsPanel createUserCards(PanelSwitcher switcher,
			int row, int lineNum, List<UserInfo> users) {
		Box box = Box.createVerticalBox();
		int size = users.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(lineNum);
			int j;
			for(j = 0; j < lineNum && i * lineNum + j < size; ++j) {
				ClickHandler handler = () -> {
					switcher.jump(Page.USER,
							new UserInfoPage(lineNum, MainFrame.PAGE_WIDTH, MainFrame.PAGE_HEIGHT, switcher,
									new UserInfoDetail("Linus", "a programmer", "linus@example.com",	//TODO 获取具体信息
											new Date(1980, 10, 23), "Microsoft", "America", 200, 1000)),
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
		panel.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
		return panel;
	}
}
