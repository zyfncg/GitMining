package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;

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
	 *返回包含所有卡片的信息面板
	 *TODO 以后根据具体信息创建卡片 
	 */
	public static CardsPanel createProjectCards(List<ProjectInfo> projects) {
		int size = projects.size();
		CardsPanel panel = createCardContainer(size);
		for(int i = 0; i < size; ++i) {
			panel.add(new ProjectCard(CARD_WIDTH, CARD_HEIGHT, null));
		}
		return panel;
	}
	
	/**
	 *根据用户信息创建信息面板
	 *每个用户信息以一个卡片的形式展现
	 *返回包含所有卡片的信息面板
	 *TODO 以后根据具体信息创建卡片 
	 */
	public static CardsPanel createUserCards(List<UserInfo> users) {
		int size = users.size();
		CardsPanel panel = createCardContainer(size);
		for(int i = 0; i < size; ++i) {
			panel.add(new UserCard(CARD_WIDTH, CARD_HEIGHT, null));
		}
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
}
