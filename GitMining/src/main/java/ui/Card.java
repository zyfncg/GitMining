package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *信息卡片 
 */
@SuppressWarnings("serial")
public class Card extends JPanel {
	
	private Color c = Color.GREEN;
	
	/**
	 *图像面板 
	 */
	protected JPanel iconPanel;
	
	/**
	 *描述面板 
	 */
	protected JPanel txtPanel;
	
	/**
	 *信息项面板 
	 */
	protected JPanel itemPanel;

	public Card(int width, int height, String text) {
		//分成3部分， 图像面板：描述面板：信息面板 = 1 : 1 : 2
		
		//图像面板
		int iconH = height >> 2;
		this.iconPanel = new JPanel();
		this.iconPanel.setOpaque(false);
		this.iconPanel.setPreferredSize(new Dimension(width, iconH));
		
		//描述面板
		JLabel txtLabel = new JLabel(text, JLabel.CENTER);
		txtLabel.setOpaque(false);
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		this.txtPanel = new JPanel(layout);
		this.txtPanel.setOpaque(false);
		this.txtPanel.add(txtLabel);
		this.txtPanel.setPreferredSize(new Dimension(width, iconH));

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
				c = Color.BLACK;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				c = Color.GREEN;
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(c);
	}
}
