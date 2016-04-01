package ui.component;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 *空的透明面板 
 */
@SuppressWarnings("serial")
public class EmptyPanel extends JPanel {

	public EmptyPanel(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
	}
}
