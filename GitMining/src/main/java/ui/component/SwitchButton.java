package ui.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import ui.ClickHandler;

/**
 *页面切换按钮，用JPanel来模拟 
 */
@SuppressWarnings("serial")
public class SwitchButton extends JPanel {

	/**
	 *页面切换处理器 
	 */
	private ClickHandler handler;

	/**
	 *鼠标离开时显示的图片 
	 */
	private Image away;

	/**
	 *鼠标移动到上面时显示的图片 
	 */
	private Image enter;

	/**
	 *显示的图片 
	 */
	private Image image;

	/**
	 *按钮高度 
	 */
	private int height;
	
	/**
	 *切换按钮的宽度 
	 */
	public static final int SWITCH_WIDTH = 50;
	
	/**
	 *创建一个空白的切面切换按钮，不提供页面切换服务
	 *@param height 按钮高度
	 *@param image 按钮图标，如果不需要，则null 
	 */
	public SwitchButton(int height, Image image) {
		this.image = image;
		this.height = height;
		this.setPreferredSize(new Dimension(SWITCH_WIDTH, height));
		this.setOpaque(false);
	}

	/**
	 *创建一个页面切换操作按钮 
	 *@param handler 页面切换处理器
	 *@param height 按钮高度
	 *@param enter 鼠标移动到按钮上时的按钮图标
	 *@param away 鼠标移出按钮时的按钮图标
	 */
	public SwitchButton(ClickHandler handler,
			int height, Image enter, Image away) {
		this(height, enter, away);
		this.handler = handler;
	}

	/**
	 *创建一个页面切换操作按钮 
	 *@param height 按钮高度
	 *@param enter 鼠标移动到按钮上时的按钮图标
	 *@param away 鼠标移出按钮时的按钮图标
	 */
	public SwitchButton(int height,
			Image enter, Image away) {
		this.enter = enter;
		this.away = away;
		this.image = away;
		this.height = height;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(SWITCH_WIDTH, height));
		this.addListener();
	}

	public void setHandler(ClickHandler handler) {
		this.handler = handler;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return ;
		
		int y = (image.getHeight(null) - height) / 2;
		g.drawImage(image,
				0, 0, SWITCH_WIDTH, height,
				0, y, SWITCH_WIDTH, y + height,
				null);
	}
	
	/**
	 *添加监听 
	 */
	private void addListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(handler != null) {
					handler.handle();
				}
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				image = enter;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				image = away;
				repaint();
			}
		});
	}
}
