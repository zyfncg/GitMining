package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import res.Colors;

/**
 *只拥有描述文本信息的面板 
 */
@SuppressWarnings("serial")
public class TextPanel extends JPanel {
	
	private static final int LINE_MAX = 40;
	
	public TextPanel(String text, int width, int height) {
		JLabel txt = new JLabel(text,JLabel.CENTER);
		txt.setForeground(Colors.TEXT_COLOR);
		txt.setOpaque(false);
		FlowLayout f = new FlowLayout();
		f.setVgap(0);
		this.setLayout(f);
		this.add(txt);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, height));
	}

}
