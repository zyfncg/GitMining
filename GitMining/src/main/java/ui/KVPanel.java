package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import res.Colors;

/**
 *信息项面板，分为两部分
 *信息的具体值(value)
 *信息的类型 (key)
 */
@SuppressWarnings("serial")
public class KVPanel extends JPanel {
	
	/**
	 *键值对以垂直方向展现 
	 */
	public static final int VERTICAL = 0;
	
	/**
	 *键值对以水平方向展现 
	 */
	public static final int HORIZONTAL = 1;
	
	/**
	 *@param direction 信息展现的方式,取值有KVPanel.VERTICAL 和
	 *KVPanel.HORIZONTAL, 其他情况当做KVPanel.HORIZONTAL处理
	 */
	public KVPanel(int width, int height, String key,
			String value, int direction) {
		int keyW, keyH, valueW, valueH;//key宽度、key高度、value宽度、value高度
		int kHAlign, kVAlign, vHAlign, vVAlign;//key水平对齐、key垂直对齐、value水平对齐、value垂直对齐
		Box box;
		ItemLabel keyPanel, valuePanel;
		if(direction == VERTICAL) {
			keyW = width;
			keyH = height >> 1;
			valueW = width;
			valueH = keyH;
			kHAlign = JLabel.CENTER;
			kVAlign = JLabel.CENTER;
			vHAlign = JLabel.CENTER;
			vVAlign = JLabel.CENTER;
			keyPanel = new ItemLabel(keyW, keyH, key,
					Colors.KEY_TEXT, JLabel.CENTER, JLabel.CENTER);
			valuePanel = new ItemLabel(valueW, valueH, value,
					Colors.VALUE_TEXT, JLabel.CENTER, JLabel.CENTER);
			box = Box.createVerticalBox();
		}else {
			keyW = width >> 1;
			keyH = height;
			valueW = keyW;
			valueH = height;
			kHAlign = JLabel.RIGHT;
			kVAlign = JLabel.CENTER;
			vHAlign = JLabel.LEFT;
			vVAlign = JLabel.CENTER;
			keyPanel = new ItemLabel(keyW, keyH, key,
					Colors.KEY_TEXT, JLabel.RIGHT, JLabel.CENTER);
			box = Box.createHorizontalBox();
		}
		keyPanel = new ItemLabel(
				width, height >> 1, key, Colors.KEY_TEXT,
				kHAlign, kVAlign);
		valuePanel = new ItemLabel(
				width, height >> 1, value, Colors.VALUE_TEXT,
				vHAlign, vVAlign);
		
		box.add(keyPanel);
		box.add(valuePanel);
		this.setLayout(new BorderLayout());
		this.add(box, BorderLayout.CENTER);
		this.setOpaque(false);
	}

	private class ItemLabel extends JLabel {
		public ItemLabel(int width, int height,
				String text, Color textColor,
				int hAlign, int vAlign) {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(width, height));
			this.setFont(new Font("斜体", Font.ITALIC, 15));
			this.setText(text);
			this.setForeground(textColor);
			this.setHorizontalAlignment(hAlign);
			this.setVerticalAlignment(vAlign);
		}
	}
}
