package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *搜索框面板
 *包含一个搜索框和一个确定按钮
 */
@SuppressWarnings("serial")
public class SearchPanel extends JPanel {

	/**
	 *搜索框 
	 */
	private JTextField text;
	
	/**
	 *确定搜索按钮 
	 */
	private JButton search;
	
	/**
	 *提示信息字体格式 
	 */
	private static final Font TIP_FONT = new Font("斜体", Font.ITALIC, 12);
	
	/**
	 *用户输入字体格式 
	 */
	private static final Font TEXT_FONT = new Font("宋体", Font.PLAIN, 14);
	
	/**
	 *@param width, 面板的宽度
	 *@param height, 面板的高度
	 *@param tip, 显示在搜索框中的提示信息
	 *			  如果没有显示信息，传入"",不接受null值 
	 */
	public SearchPanel(int width, int height, String tip) {
		int btnH = height / 3;
		int btnW = height << 1;
		btnW = (btnW > width / 3) ? (width / 3) : btnW;
		//TODO 字符串统一管理
		search = new JButton("搜索");
		search.setPreferredSize(new Dimension(btnW, btnH));
		
		this.initTextUI(width - btnW, btnH, tip);
		
		FlowLayout layout = new FlowLayout();
		layout.setHgap(0);
		layout.setVgap(height / 3);
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(width, height));
		this.add(text);
		this.add(search);
	}
	
	/**
	 *初始化输入框 
	 */
	private void initTextUI(int txtW, int height, final String tip) {
		text = new JTextField();
		this.setTip(tip);
		text.setPreferredSize(new Dimension(txtW, height));
		
		text.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(text.getText().equals(tip)) {
					clearTip();
				}
			}
			
			public void focusLost(FocusEvent e) {
				if(text.getText().isEmpty()) {
					setTip(tip);
				}
			}
		});
	}
	
	/**
	 *设置输入框提示信息 
	 */
	private void setTip(String tip) {
		text.setFont(TIP_FONT);
		text.setForeground(Color.GRAY);
		text.setText(tip);
	}
	
	/**
	 *清空输入框的提示信息 
	 */
	private void clearTip() {
		text.setFont(TEXT_FONT);
		text.setForeground(Color.BLACK);
		text.setText("");
	}
	
	public JButton getSearchBtn() {
		return this.search;
	}
	
	public String getText() {
		return this.text.getText();
	}
}
