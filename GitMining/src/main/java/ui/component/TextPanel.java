package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import res.Colors;

/**
 *只拥有描述文本信息的面板 
 */
@SuppressWarnings("serial")
public class TextPanel extends JPanel {
	
	/**
	 *一行文本 显示的最大字符数
	 */
	private static final int LINE_MAX = 120;
	
	public TextPanel(String text, int width, int height) {
		int len = text.length();
		int remainder = len % LINE_MAX;
		int labelNum = remainder == 0 ?
				len / LINE_MAX : len / LINE_MAX + 1;
		Box box = Box.createVerticalBox();
		box.setOpaque(false);
		int part = len / labelNum;//文本被分成多行，每行的长度
		String temp;
		for(int i = 0; i < labelNum; i++) {
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			if(part * i >= text.length()) {
				temp = text.substring(i * part, len);
			}else {
				temp = text.substring(i * part, (i + 1) * part);
			}
			JLabel txt = new JLabel(temp,JLabel.CENTER);
			txt.setForeground(Colors.TEXT_COLOR);
			txt.setOpaque(false);
			panel.add(txt);
			box.add(panel);
		}
		
		this.setLayout(new BorderLayout());
		this.add(box, BorderLayout.CENTER);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, height));
	}

}
