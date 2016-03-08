package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JPanel;

import res.Colors;

/**
 *信息卡片 
 */
@SuppressWarnings("serial")
public class Card extends JPanel {
	
	private Color c = Colors.CARD_AWAY_BG;	
	/**
	 *图像面板 
	 */
	protected JPanel iconPanel;
	
	/**
	 *描述面板 
	 */
	protected TextPanel txtPanel;
	
	/**
	 *信息项面板 
	 */
	protected JPanel itemPanel;

	public Card(ClickHandler handler, int width, int height, String text) {
		//分成3部分， 图像面板：描述面板：信息面板 = 1 : 1 : 2
		
		//图像面板
		int iconH = height >> 2;
		this.iconPanel = new JPanel();
		this.iconPanel.setOpaque(false);
		this.iconPanel.setPreferredSize(new Dimension(width, iconH));
		this.iconPanel.setOpaque(false);//TODO 可能不设为透明
		
		//描述面板
		this.txtPanel = new TextPanel(text, width, iconH);

		//信息面板
		FlowLayout itemLayout = new FlowLayout();
		itemLayout.setVgap(0);
		itemLayout.setHgap(0);
		this.itemPanel = new JPanel(itemLayout);
		this.itemPanel.setOpaque(false);
		this.itemPanel.setPreferredSize(new Dimension(width, iconH << 1));

		//组装所有面板
		Box all = Box.createVerticalBox();
		all.add(this.iconPanel);
		all.add(this.txtPanel);
		all.add(this.itemPanel);
		all.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(c);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				c = Colors.CARD_ENTER_BG;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				c = Colors.CARD_AWAY_BG;
				repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				handler.handle();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(c);
	}
}
