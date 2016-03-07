package ui;

import java.awt.BorderLayout;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import constant.Page;

/**
 *面板转换器 
 */
public class PanelSwitcher {
	
	/**
	 *页面标识符与页面的映射表 
	 */
	private Map<Page, JPanel> map;
	
	/**
	 *主窗口 
	 */
	private MainFrame frame;
	
	/**
	 *页面向左切换控制符 
	 */
	public static final int LEFT = 0;
	
	/**
	 *页面向右切换控制符 
	 */
	public static final int RIGHT = 1;
	
	/**
	 *页面切换策略表 
	 */
	private Map<Integer, SlideStrategy> slideMap =
			new HashMap<Integer, SlideStrategy>();
	
	/**
	 *保存面板的栈，用于面板回退 
	 */
	private static Deque<JPanel> panelStack =
			new ArrayDeque<JPanel>();
	
	public PanelSwitcher(MainFrame frame) {
		this.frame = frame;
		this.initSlideMap();
	}
	
	/**
	 *可回退的跳转
	 *父容器是MainFrame 
	 */
	public void backableJump(JPanel from, JPanel to, int direction) {
		if(from == to) return ;
		panelStack.push(from);
		this.jump(from, to, direction);
	}
	
	/**
	 *回退到上一个面板
	 *只适用于界面跳转时可回退跳转的面板
	 *父容器是MainFrame
	 */
	public void back(JPanel from, int direction) {
		if(!panelStack.isEmpty()) {
			JPanel to = panelStack.pop();
			this.jump(from, to, direction);
		}
	}

	/**
	 *不同面板的切换 
	 *@param parent 被切换面板的父容器
	 *@param from 被切换面板
	 *@param to 新面板
	 */
	public void jump(JPanel parent, JPanel from,
			JPanel to, int direction) {
		from.setVisible(false);
		to.setVisible(true);
		if(from == to) return ;
		parent.add(to);
		this.panelSlide(from, to, direction);
		parent.revalidate();
	}
	
	/**
	 *不同页面之间的切换 
	 *@param from 被切换页面
	 *@param to 新页面
	 *@param direction 切换的方向
	 *有PanelSwitcher.LEFT, PanelSwitcher.RIGHT
	 */
	public void jump(Page from, Page to, int direction) {
		JPanel f = this.map.get(from);
		JPanel t = this.map.get(to);
		if(f == t) return;
		this.jump(f, t, direction);
		//如果进行的不是可返回跳转，把之前压栈的面板清空
		panelStack.clear();
	}
	
	/**
	 *不同页面之间的切换 
	 *@param from 被切换页面
	 *@param to 新页面
	 *@param direction 切换的方向
	 *有PanelSwitcher.LEFT, PanelSwitcher.RIGHT
	 */
	public void jump(JPanel from, Page to, int direction) {
		JPanel t = this.map.get(to);
		if(from == t) return ;
		this.jump(from, t, direction);
		//如果进行的不是可返回跳转，把之前压栈的面板清空
		panelStack.clear();
	}
	
	/**
	 *不同页面之间的切换 
	 *@param from, 被切换页面
	 *@param to, 新面板
	 *@param direction, 切换的方向,
	 *有PanelSwitcher.LEFT, PanelSwitcher.RIGHT
	 */
	public void jump(Page from, JPanel to, int direction) {
		JPanel f = this.map.get(from);
		if(f == to) return ;
		this.jump(f, to, direction);
		//如果进行的不是可返回跳转，把之前压栈的面板清空
		panelStack.clear();
	}
	
	/**
	 * 父容器为MainFrame
	 */
	public void jump(JPanel from, JPanel to, int direction) {
		from.setVisible(false);
		to.setVisible(true);
		this.frame.add(to, BorderLayout.CENTER);
		this.panelSlide(from, to, direction);
		this.frame.setCurrentPage(to);
		this.frame.revalidate();
	}
	
	public void setPageMap(Map<Page, JPanel> pageMap) {
		this.map = pageMap;
	}
	
	private int startX;	//面板滑动之前相对于窗体的x坐标
	private int startY; //面板滑动之前相对于窗体的y坐标
	private int startW; //面板滑动之前的宽度
	private int startH; //面板滑动之前的高度
	private int frequency = 10; //面板位置变化的频率
	private int distance = 100;  //面板每次移动的距离
	/**
	 *初始化页面切换策略表 
	 */
	private void initSlideMap() {
		this.slideMap.put(LEFT, (from, to) -> {
			startX = from.getX() + from.getWidth();
			startY = from.getY();
			int endX = from.getX();
			int endY = startY;
			Timer timer = new Timer(frequency, e -> {
				to.setLocation(startX, startY);
				if(startX <= endX) {
					to.setLocation(endX, endY);
					((Timer)e.getSource()).stop();
				}
				startX -= distance;
			});
			startSlide(timer);
		});
		this.slideMap.put(RIGHT, (from , to) -> {
			to.setLocation(from.getX(), from.getY());
			startW = 1;
			startH = from.getHeight();
			int endW = from.getWidth();
			Timer timer = new Timer(frequency, e -> {
				to.setSize(startW, startH);
				if(startW >= endW) {
					to.setSize(endW, startH);
					((Timer)e.getSource()).stop();
				}
				startW += distance;
			});
			startSlide(timer);
		});
	}
	
	/**
	 *开始进行页面切换 
	 */
	private void startSlide(Timer timer) {
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
	}
	
	/**
	 *实现页面切换的滑动效果 
	 *@param from, 被切换的面板
	 *@param to, 切换的面板
	 *@param direction,切换的方向
	 */
	private void panelSlide(JPanel from, JPanel to, int direction) {
		SlideStrategy s = this.slideMap.get(direction);
		s.slide(from, to);
	}
	
	/**
	 *页面切换动态效果策略 
	 */
	@FunctionalInterface
	private interface SlideStrategy {
		public void slide(JPanel from, JPanel to);
	}
}
