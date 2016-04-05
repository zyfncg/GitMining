package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *显示标题的面板 
 */
@SuppressWarnings("serial")
public class TitlePanel extends JPanel {
	
	private Font font = new Font("黑体", Font.BOLD, 20);

	public TitlePanel(String title, int width, int height) {
		JLabel label = new JLabel(title, JLabel.CENTER);
		label.setOpaque(false);
		label.setFont(font);
		label.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.CENTER);
		this.setOpaque(false);
	}
}
