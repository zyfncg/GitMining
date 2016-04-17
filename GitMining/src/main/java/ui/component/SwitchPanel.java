package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import ui.ClickHandler;

/**
 *切换面板
 *在面板两侧提供面板切换按钮
 *左侧按钮表示切换至前一个 面板
 *右侧按钮表示切换至后一个面板
 *工厂模式创造实例
 */
@SuppressWarnings("serial")
public class SwitchPanel extends JPanel {
	
	/**
	 *后退按钮 
	 */
	private SwitchButton preBtn;
	
	/**
	 *前进按钮 
	 */
	private SwitchButton nextBtn;
	
	/**
	 *@param center 可切换面板的中间部分
	 *@param preBtn 回退按钮
	 *@param nextBtn 前进按钮
	 *@note 最终面板的宽度为三个面板宽度之和，高度为中间面板的高度
	 */
	public SwitchPanel(JPanel center, SwitchButton preBtn, SwitchButton nextBtn) {
		this.preBtn = preBtn;
		this.nextBtn = nextBtn;
		this.combine(center, preBtn, nextBtn);
	}
	
	/**
	 *给后退按钮添加监听
	 */
	public void addBackListener(ClickHandler handler) {
		this.preBtn.setHandler(handler);
	}
	
	/**
	 *给前进按钮添加监听 
	 */
	public void addNextListener(ClickHandler handler) {
		this.nextBtn.setHandler(handler);
	}
	
	/**
	 *将组件组装起来形成可切换面板 
	 */
	private void combine(JPanel center, SwitchButton preBtn, SwitchButton nextBtn) {
		this.setLayout(new BorderLayout());
		this.add(this.preBtn, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(this.nextBtn, BorderLayout.EAST);
		int width = center.getPreferredSize().width +
				this.preBtn.getPreferredSize().width +
				this.nextBtn.getPreferredSize().width;
		int height = center.getPreferredSize().height;
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
	}
}
