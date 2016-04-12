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
	 *页面放大至全屏控制符 
	 */
	private static final int FULL_SCREEN = -1;
	
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
	 *父容器是MainFrame的root面板
	 */
	public void backableJump(JPanel from, JPanel to, int direction) {
		if(from == to) return ;
		panelStack.push(from);
		this.jump(from, to, direction);
	}
	
	/**
	 *回退到上一个面板
	 *只适用于界面跳转时可回退跳转的面板
	 *父容器是MainFrame的root面板
	 */
	public void back(JPanel from, int direction) {
		if(!panelStack.isEmpty()) {
			JPanel to = panelStack.pop();
			this.jump(from, to, direction);
		}
	}
	
//	/**
//	 *使目标按钮铺满全屏 
//	 */
//	public void toFullScreen(JPanel from, JPanel target) {
//		if(from == target) return ;
//		target.setVisible(true);
//		JPanel root = this.frame.getRootPanel();
//		root.add(target, BorderLayout.CENTER);
//		this.slideMap.get(FULL_SCREEN).slide(from, target);
//		this.frame.setCurrentPage(target);
//		root.revalidate();
//	}

	/**
	 *不同面板的切换 
	 *@param parent 被切换面板的父容器
	 *@param from 被切换面板
	 *@param to 新面板
	 */
	public void jump(JPanel parent, JPanel from,
			JPanel to, int direction) {
		if(from == to) return ;
		to.setVisible(true);
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
	 * 父容器为MainFrame的root面板
	 */
	public void jump(JPanel from, JPanel to, int direction) {
		to.setVisible(true);
		JPanel root = this.frame.getRootPanel();
		root.add(to, BorderLayout.CENTER);
		this.panelSlide(from, to, direction);
		this.frame.setCurrentPage(to);
		root.revalidate();
	}
	
	public void setPageMap(Map<Page, JPanel> pageMap) {
		this.map = pageMap;
	}
	
	private int startX;	//面板滑动之前相对于窗体的x坐标
	private int startY; //面板滑动之前相对于窗体的y坐标
	private int startW; //面板滑动之前的宽度
	private int startH; //面板滑动之前的高度
	private int frequency = 10; //面板位置变化的频率
	private int distance = 40;  //面板每次移动的距离
	private int left; //向左一次放大的距离
	private int right;//向右一次放大的距离
	private int up;   //向上一次放大的距离
	private int down; //向下一次放大的距离
	/**
	 *初始化页面切换策略表 
	 */
	private void initSlideMap() {
		//向左切换
		this.slideMap.put(LEFT, (from, to) -> {
			startY = from.getY();
			startX = from.getX() + MainFrame.PAGE_WIDTH;
			int endX = from.getX();
			int endY = startY;
			Timer timer = new Timer(frequency, e -> {
				from.setSize(startX - endX, from.getHeight());
				to.setLocation(startX, startY);
				if(startX <= endX) {
					from.setVisible(false);
					to.setLocation(endX, endY);
					((Timer)e.getSource()).stop();
				}
				startX -= distance;
			});
			startSlide(timer);
		});
		//向右切换
		this.slideMap.put(RIGHT, (from , to) -> {
			startW = 0;
			startH = MainFrame.PAGE_HEIGHT;
			int endW = MainFrame.PAGE_WIDTH;
			to.setLocation(from.getX(), from.getY());
			to.setSize(startW, startH);
			Timer timer = new Timer(frequency, e -> {
				from.setLocation(startW, from.getY());
				to.setSize(startW, startH);
				if(startW >= endW) {
					from.setVisible(false);
					to.setSize(endW, startH);
					((Timer)e.getSource()).stop();
				}
				startW += distance;
			});
			startSlide(timer);
		});
		//放大至全屏 TODO 以后有机会就实现
		this.slideMap.put(FULL_SCREEN, (from, to) -> {
			from.setVisible(false);
			startX = from.getX();
			startY = from.getY();
			startW = from.getWidth();
			startH = from.getHeight();
			int endX = 0, endY = MainFrame.BUTTON_SIZE;
			int endW = MainFrame.PAGE_WIDTH;
			int endH = MainFrame.PAGE_HEIGHT;
			left = (startX - endX) / 10;
			right = (endW - startX - startW) / 10;
			up = (startY - endY) / 10;
			down = (endH - startY - startH) / 10;
			Timer timer = new Timer(100, e -> {
				to.setBounds(startX, startY, startW, startH);
				boolean leftDone = startX <= endX;
				boolean rightDone = startX + startW >= endW;
				boolean upDone = startY <= endY;
				boolean downDone = startY + startH >= endH;
				if(leftDone) {//如果向左扩张完成
					startX = endX;
					left = 0;
				}
				if(rightDone) {//如果向右扩张完成
					startW = endW;
					right = 0;
				}
				if(upDone) {//如果向上扩张完成 
					startY = endY;
					up = 0;
				}
				if(downDone) {//如果向下扩张完成
					startH = endH;
					down = 0;
				}
				//如果都已经完成
				if(leftDone && rightDone && upDone && downDone) {
					to.setBounds(endX, endY, endW, endH);
					((Timer)e.getSource()).stop();
					System.out.println("done");
				}
				startX -= left;
				startW = startW + left + right;
				startY -= up;
				startH = startH + up + down;
				System.out.println("hh");
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
