package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

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
	private static final int CARD_GAP = 10;

	/**
	 *要显示的信息卡片的行数
	 */
	private static final int CARD_ROW = 2;
	
	/**
	 *要显示的信息卡片的列数 
	 */
	public static final int CARD_COLUMN = 3;
	
	/**
	 *卡片信息面板的宽度 
	 */
	public static final int WIDTH = CARD_COLUMN * Card.CARD_WIDTH +
			(CARD_COLUMN + 1) * CARD_GAP;
	
	/**
	 *卡片信息面板的高度 
	 */
	public static final int HEIGHT = CARD_ROW * Card.CARD_HEIGHT +
			(CARD_ROW + 1) * CARD_GAP;

	private CardsPanel() {this.setOpaque(false);}


	/**
	 *创建一个没有信息的面板
	 *@param row 卡片面板信息卡片的行数
	 *@param img 提示信息图片
	 */
	public static CardsPanel createPlainPanel(int row, Image img) {
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
			box.add(createCardContainer(CARD_COLUMN));
		}
		panel.setLayout(new BorderLayout());
		panel.add(box, BorderLayout.CENTER);
		return panel;
	}
	
	/**
	 *将所有的信息卡片组织成卡片面板
	 *@param cards 信息卡片列表 
	 */
	public static CardsPanel organize(int row, List<? extends Card> cards) {
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		
		int size = cards.size();
		for(int i = 0; i < row; ++i) {
			CardsPanel panel = createCardContainer(CARD_COLUMN);
			int j = 0;
			for(; j < CARD_COLUMN && i * CARD_COLUMN + j < size; ++j) {
				panel.add(cards.get(i * CARD_COLUMN + j));
			}
			//如果信息数目 <要显示的卡片数目，用空白卡片替代
			for(int k = j; k < CARD_COLUMN; ++k) {
				panel.add(createPlainCard());
			}
			box.add(panel);
		}
		
		CardsPanel panel = new CardsPanel();
		panel.setLayout(new BorderLayout());
		panel.add(box, BorderLayout.CENTER);
		return panel;
	}

	/**
	 *创建承载信息卡片的容器
	 *@param column, 一行信息卡片的数量 
	 */
	private static CardsPanel createCardContainer(int column) {
		FlowLayout layout = new FlowLayout();
		layout.setVgap(CARD_GAP);
		layout.setHgap(CARD_GAP);
		CardsPanel panel = new CardsPanel();	
		panel.setLayout(layout);
		int width = column * Card.CARD_WIDTH + (column + 1) * CARD_GAP;
		int height = (CARD_GAP << 1) + Card.CARD_HEIGHT;
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}

	/**
	 *创建一个空白卡片 
	 */
	private static JPanel createPlainCard() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(Card.CARD_WIDTH, Card.CARD_HEIGHT));
		return panel;
	}
}
