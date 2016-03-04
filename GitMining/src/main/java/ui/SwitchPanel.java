package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 *切换面板
 *在面板两侧提供面板切换按钮
 *左侧按钮表示切换至前一个 面板
 *右侧按钮表示切换至后一个面板
 *工厂模式创造实例
 */
@SuppressWarnings("serial")
public class SwitchPanel extends JPanel {
	
	private SwitchPanel() {}
	
	/**
	 *切换按钮的宽度 
	 */
	public static final int SWITCH_WIDTH = 50;
	
	/**
	 *创建只有后退按钮的面板 
	 */
	public static SwitchPanel leftOnly(ClickHandler handler, JPanel center) {
		
		Dimension d = getSize(center);
		double width = d.getWidth();
		double height = d.getHeight();
		SwtichButton previous = new SwtichButton(handler, SWITCH_WIDTH, height,
				Color.BLACK, Color.WHITE);
		JPanel next = createPlainPanel(SWITCH_WIDTH, height);		
		SwitchPanel panel = new SwitchPanel();
		combineUI(panel, previous, next, center, width, height);
		return panel;
	}
	
	/**
	 *创建只有前进按钮的面板 
	 */
	public static SwitchPanel rightOnly(ClickHandler handler, JPanel center) {
		Dimension d = getSize(center);
		double width = d.getWidth();
		double height = d.getHeight();
		JPanel previous = createPlainPanel(SWITCH_WIDTH, height);
		SwtichButton next = new SwtichButton(handler, SWITCH_WIDTH, height,
				Color.BLACK, Color.WHITE);
		SwitchPanel panel = new SwitchPanel();
		combineUI(panel, previous, next, center, width, height);
		return panel;
	}
	
	/**
	 *创建具有前进和后退按钮的面板 
	 */
	public static SwitchPanel bothSides(ClickHandler left,
			ClickHandler right, JPanel center) {
		Dimension d = getSize(center);
		double width = d.getWidth();
		double height = d.getHeight();
		SwtichButton previous = new SwtichButton(left, SWITCH_WIDTH, height,
				Color.BLACK, Color.WHITE);
		SwtichButton next = new SwtichButton(right, SWITCH_WIDTH, height,
				Color.BLACK, Color.WHITE);
		SwitchPanel panel = new SwitchPanel();
		combineUI(panel, previous, next, center, width, height);
		return panel;
	}
	
	/**
	 *获得整个SwitchPanel的宽度和高度 
	 */
	private static Dimension getSize(JPanel panel) {
		Dimension d = panel.getPreferredSize();
		double width = d.getWidth() + (SWITCH_WIDTH << 1);
		double height = d.getHeight();
		return new Dimension((int)width, (int)height);
	}
	
	/**
	 *创建一个空的面板 
	 */
	private static JPanel createPlainPanel(double width, double height) {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension((int)width, (int)height));
		return p;
	}
	
	/**
	 * 将所有组件组装起来
	 */
	private static void combineUI(SwitchPanel panel,
			JPanel previous, JPanel next,
			JPanel center, double width, double height) {
		panel.setLayout(new BorderLayout());
		panel.add(previous, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		panel.add(next, BorderLayout.EAST);
		panel.setPreferredSize(new Dimension((int)width, (int)height));
	}
	
	/**
	 *页面切换按钮，用JPanel来模拟 
	 */
	private static class SwtichButton extends JPanel {
		
		private Color c;
		
		/**
		 * TODO touch 和 untouch代表触摸前后的颜色
		 * 以后用图片代替
		 */
		public SwtichButton(ClickHandler handler, double width,
				double height, final Color touch, final Color untouch) {
			this.c = untouch;
			this.setPreferredSize(new Dimension((int)width, (int)height));
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					handler.handle();
				}
			});
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					c = touch;
					repaint();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					c = untouch;
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
}
