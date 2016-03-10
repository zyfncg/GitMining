package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

import res.Colors;
import res.Img;

/**
 *后退按钮，拥有一个位于左上角的按钮（后退） 
 */
@SuppressWarnings("serial")
public class BackPanel extends JPanel {
	
	private Image img;
	
	private int width;
	
	private int height;
	
	public BackPanel(ClickHandler handler, int width, int height,
			int btnW, int btnH, Image img) {
		this.img = img;
		this.width = width;
		this.height = height;
		//后退按钮
		JButton back = new JButton(Img.BACK_BUTTON);
		back.setBackground(Colors.PAGE_BG);
		back.addActionListener(e -> handler.handle());
		back.setPreferredSize(new Dimension(btnW, btnH));
		
		//面板
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setVgap(0);
		layout.setHgap(0);
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(layout);
		this.add(back);
		this.setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,
				0, 0, width, height,
				0, 0, img.getWidth(null), img.getHeight(null),
				null);
	}
}

