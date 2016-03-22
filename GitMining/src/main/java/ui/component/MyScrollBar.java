package ui.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *滚动面板滚动条 
 */
public class MyScrollBar extends MetalScrollBarUI {
    
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		super.paintThumb(g, c, thumbBounds);
		g.translate(thumbBounds.x, thumbBounds.y);
		// 设置把手颜色
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, thumbBounds.width, thumbBounds.height);
//		// 画一个圆角矩形
//		g.drawRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);
//		// 消除锯齿
//		Graphics2D g2 = (Graphics2D) g;
//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.addRenderingHints(rh);
//		// 半透明
//		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
//		// 设置填充颜色，这里设置了渐变，由下往上
//		 g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, Color.GRAY, c.getWidth() / 2, c.getHeight(), Color.GRAY));
//		// 填充圆角矩形
//		g2.fillRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);
	}
	
//	@Override
//	protected void paintDecreaseHighlight(Graphics g) {
//		super.paintDecreaseHighlight(g);
//		g.setColor(Color.YELLOW);
//		g.fillRect(0, 0, 10, 10);
//	}
	
//	@Override
//	public void paint(Graphics g, JComponent c) {
//		super.paint(g, c);
//		int w = c.getWidth();
//		int h = c.getHeight();
//		g.setColor(Color.ORANGE);
//		g.fillRect(0, 0, w, h);
//	}
	
//	@Override
//	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
//		// TODO Auto-generated method stub
//		super.paintTrack(g, c, trackBounds);
//		int w = trackBounds.width;
//		int h = trackBounds.height;
//		g.setColor(Color.ORANGE);
//		g.fillRect(0, 0, w, h);
//	}
	
//	@Override
//	protected JButton createIncreaseButton(int orientation) {
//		JButton b = new JButton();
//		b.setBackground(Color.black);
//		return b;
//	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JScrollPane p = new JScrollPane();
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(400, 400));
		p.setViewportView(panel);
		p.setPreferredSize(new Dimension(200, 200));
		p.getVerticalScrollBar().setUI(new MyScrollBar());
		frame.add(p);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}
