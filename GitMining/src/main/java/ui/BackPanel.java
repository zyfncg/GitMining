package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *后退按钮，拥有一个位于左上角的按钮（后退） 
 */
@SuppressWarnings("serial")
public class BackPanel extends JPanel {
	
	public BackPanel(int width, int height,
			int btnW, int btnH) {
		//后退按钮
		JButton back = new JButton("后退");//TODO 用图片表示
		back.setPreferredSize(new Dimension(btnW, btnH));
		
		//面板
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setVgap(0);
		layout.setHgap(0);
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(layout);
		this.add(back);
	}
}
