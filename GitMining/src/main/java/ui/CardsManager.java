package ui;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import res.Img;
import ui.component.Card;
import ui.component.CardsPanel;
import ui.component.SwitchButton;
import ui.component.SwitchPanel;

/**
 *信息卡片管理器
 *负责信息卡片的显示
 *卡片面板的跳转
 *卡片面板资源的回收 
 */
public class CardsManager {
	
	/**
	 *可切换的卡片信息面板列表 
	 */
	private List<SwitchPanel> panels = new ArrayList<>();
	
	/**
	 *卡片面板的父容器 
	 */
	private JPanel container;
	
	/**
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *当前显示的卡片信息面板位于列表的下标 
	 */
	private int index;
	
	/**
	 *当前显示的卡片信息面板的标题图片
	 */
	private Image image;
	
	/**
	 *卡片信息面板列表的容量 
	 */
	private int size;
	
	/**
	 *@param image 卡片信息面板标题图片
	 *@param row 卡片面板信息卡片的行数 
	 *@param cards 要被管理的信息卡片列表
	 *@param parent 卡片信息面板的父面板
	 */
	public CardsManager(Image image, int row,
			List<? extends Card> cards, JPanel parent,
			PanelSwitcher switcher) {
		this.index = 0;
		this.image = image;
		this.container = parent;
		this.switcher = switcher;
		//将信息卡片组织成卡片面板
		List<JPanel> list = this.cardsToPanels(row, cards);
		//将卡片面板组织成可切换面板
		this.initPanelList(row, list);
		this.size = panels.size();
		//为可切换面板添加监听
		this.addListeners();
	}
	
	/**
	 *创建第一个卡片面板 
	 */
	public SwitchPanel first() {
		return panels.get(0);
	}
	
	/**
	 *获得当前正在显示的面板 
	 */
	public SwitchPanel getCurrentPanel() {
		return panels.get(index);
	}
	
	/**
	 *释放卡片面板持有的资源
	 */
	public void free() {
		this.panels.clear();
		System.gc();
	}
	
	/**
	 *创建返回上一个卡片信息面板的处理方法 
	 */
	private ClickHandler toPrevious() {
		ClickHandler handler = () -> {
			this.switcher.jump(container,
					panels.get(index),
					panels.get(index - 1),
					PanelSwitcher.RIGHT);
			index -= 1;
		};
		return handler;
	}
	
	/**
	 *创建到下一个卡片信息面板的处理方法 
	 */
	private ClickHandler toNext() {
		ClickHandler handler = () -> {
			this.switcher.jump(container,
					panels.get(index),
					panels.get(index + 1),
					PanelSwitcher.LEFT);
			index += 1;
		};
		return handler;
	}
	
	/**
	 *将信息卡片组织成卡片面板
	 *@param row 卡片面板信息卡片的行数
	 *@param cards 信息卡片列表
	 */
	private List<JPanel> cardsToPanels(int row, List<? extends Card> cards) {
		//信息卡片的总数
		int size = cards.size();
		//一个卡片面板的信息卡片数量
		int num = row * CardsPanel.CARD_COLUMN;
		List<JPanel> panels = new ArrayList<>();
		
		if(size == 0) {
			panels.add(CardsPanel.createPlainPanel(row, Img.NULL_MESSAGE));
		}else {
			int i = 0;
			for(; i + num < size; i += num) {
				panels.add(CardsPanel.organize(row, cards.subList(i, i + num)));
			}
			//将剩余的信息卡片生成一个卡片面板
			if(i < size) {
				panels.add(CardsPanel.organize(row, cards.subList(i, size)));
			}
		}
		
		return panels;
	}
	
	/**
	 *初始化可切换的卡片面板列表
	 *@param row 卡片面板信息卡片的行数
	 *@param list 卡片面板列表 
	 */
	private void initPanelList(int row, List<JPanel> list) {
		//要管理的卡片面板的数量
		int part = list.size();
		
		SwitchButton pre = null;
		SwitchButton next = null;
		JPanel center = list.get(0);
		int height = center.getPreferredSize().height;
		if(part <= 1) {
			pre = new SwitchButton(height, image);
			next = new SwitchButton(height, image);
			panels.add(new SwitchPanel(center, pre, next));
			return ;
		}
		
		//第一个卡片面板
		pre = new SwitchButton(height, image);
		next = new SwitchButton(height, Img.NEXT_ENTER, Img.NEXT_AWAY);
		panels.add(new SwitchPanel(center, pre, next));
		//中间的卡片面板
		for(int i = 1; i < part - 1; ++i) {
			center = list.get(i);
			height = center.getPreferredSize().height;
			pre = new SwitchButton(height, Img.BACK_ENTER, Img.BACK_AWAY);
			next = new SwitchButton(height, Img.NEXT_ENTER, Img.NEXT_AWAY);
			panels.add(new SwitchPanel(center, pre, next));
		}
		//最后一个卡片面板
		if(part >= 2) {
			center = list.get(part - 1);
			height = center.getPreferredSize().height;
			pre = new SwitchButton(height, Img.BACK_ENTER, Img.BACK_AWAY);
			next = new SwitchButton(height, image);
			panels.add(new SwitchPanel(center, pre, next));
		}
	}
	
	/**
	 *给可切换页面添加监听 
	 */
	private void addListeners() {
		if(size > 1) {
			//第一个面板
			this.panels.get(0).addNextListener(toNext());
			//中间的面板
			for(int i = 1; i < size - 1; ++i) {
				SwitchPanel panel = this.panels.get(i);
				panel.addBackListener(toPrevious());
				panel.addNextListener(toNext());
			}
			//最后一个面板
			if(size >= 2) {
				this.panels.get(size - 1).addBackListener(toPrevious());
			}
		}
	}
	
}
