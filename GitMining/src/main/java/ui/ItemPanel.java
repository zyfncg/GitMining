package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *信息项面板，分为两部分
 *上面为信息的具体值(value)
 *下面为信息的类型 (key)
 */
@SuppressWarnings("serial")
public class ItemPanel extends JPanel {

	public ItemPanel(int width, int height, String key, String value) {
		ItemLabel keyPanel = new ItemLabel(width, height >> 1, key);
		ItemLabel valuePanel = new ItemLabel(width, height >> 1, value);
		Box box = Box.createVerticalBox();
		box.add(keyPanel);
		box.add(valuePanel);
		this.setLayout(new BorderLayout());
		this.add(box, BorderLayout.CENTER);
		this.setOpaque(false);
	}

	private class ItemLabel extends JLabel {
		public ItemLabel(int width, int height, String text) {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(width, height));
			this.setFont(new Font("斜体", Font.ITALIC, 15));
			this.setText(text);
			this.setForeground(Color.BLUE);
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setVerticalAlignment(JLabel.CENTER);
		}
	}
}
