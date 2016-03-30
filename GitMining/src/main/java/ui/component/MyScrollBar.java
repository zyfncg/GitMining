package ui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *滚动面板滚动条 
 */
public class MyScrollBar extends MetalScrollBarUI {
    
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		super.paintThumb(g, c, thumbBounds);
		g.translate(thumbBounds.x, thumbBounds.y);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, thumbBounds.width, thumbBounds.height);
	}
	
}
