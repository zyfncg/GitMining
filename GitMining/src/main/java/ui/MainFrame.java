package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constant.Page;
import res.Img;

/**
 *主窗体 
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	/**
	 *开始页面 
	 */
	private StartPage start;
	
	/**
	 *项目主页 
	 */
	private ProjectPage project;
	
	/**
	 *用户主页 
	 */
	private UserPage user;
	
	/**
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *按钮面板 
	 */
	private JPanel btnPanel;
	
	/**
	 *当前显示的页面 
	 */
	private JPanel currentPage;
	
	/**
	 *窗口顶级面板 
	 */
	private JPanel root = new JPanel() {
		protected void paintComponent(java.awt.Graphics g) {
			g.drawImage(Img.START, 0, 0,
					PAGE_WIDTH, PAGE_HEIGHT + BUTTON_SIZE, null);
		};
	};
	
	/**
	 *页面标识符与页面的映射表 
	 */
	private Map<Page, JPanel> pageMap =
			new HashMap<Page, JPanel>();
	
	/**
	 *一行显示的信息卡片的数量 
	 */
	private static final int CARD_NUM = 3;
	
	/**
	 *页面宽度 
	 */
	public static final int PAGE_WIDTH =
			CARD_NUM * CardsPanel.CARD_WIDTH +
			(CARD_NUM + 1) * CardsPanel.CARD_GAP +
			(SwitchPanel.SWITCH_WIDTH << 1);
	
	/**
	 *页面高度 
	 */
	public static final int PAGE_HEIGHT =
			(((CardsPanel.CARD_HEIGHT << 1) +
			 3 * CardsPanel.CARD_GAP) * 3) >> 1;
			
	/**
	 *按钮边长 
	 */
	public static final int BUTTON_SIZE = 36;
			
	/**
	 *鼠标位于窗口左上角的x坐标 
	 */
	private int x;
	
	/**
	 *鼠标位于窗口右上角的y坐标 
	 */
	private int y;
	
	public MainFrame() {
		this.switcher = new PanelSwitcher(this);
		this.start = new StartPage(PAGE_WIDTH, PAGE_HEIGHT, switcher);
		this.project = new ProjectPage(CARD_NUM, PAGE_WIDTH, PAGE_HEIGHT, switcher);
		this.user = new UserPage(CARD_NUM, PAGE_WIDTH, PAGE_HEIGHT, switcher);
		this.currentPage = this.start;
		
		this.mapPage();
		this.switcher.setPageMap(this.pageMap);
		this.initButtonPannel();
		
		this.root.setLayout(new BorderLayout());
		root.add(this.btnPanel, BorderLayout.NORTH);
		root.add(this.start, BorderLayout.CENTER);
		
		this.add(root);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setFrameAtCenter(this);
		this.enableDrag(this);
		this.setVisible(true);
	}

	/**
	 *初始化窗体的按钮面板，
	 *用户替换窗体的边框，
	 *实现最小化，关闭等功能 
	 */
	private void initButtonPannel() {
		//开始主页按钮
		FrameButton home = new FrameButton(null,
				e -> switcher.jump(currentPage, Page.START, PanelSwitcher.RIGHT));
		//项目主页按钮
		FrameButton project = new FrameButton(null,
				e -> switcher.jump(currentPage, Page.PROJECT, PanelSwitcher.LEFT));
		//用户主页按钮
		FrameButton user = new FrameButton(null,
				e -> switcher.jump(currentPage, Page.USER, PanelSwitcher.LEFT));
		//最小化按钮
		FrameButton min = new FrameButton(null,
				e -> setExtendedState(Frame.ICONIFIED));
		//退出按钮
		FrameButton exit = new FrameButton(null, e -> System.exit(0));
		
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT, 0, 0);
		this.btnPanel = new JPanel(layout);
		this.btnPanel.add(home);
		this.btnPanel.add(project);
		this.btnPanel.add(user);
		this.btnPanel.add(min);
		this.btnPanel.add(exit);
		this.btnPanel.setOpaque(false);
	}
	
	/**
	 *建立 Page枚举量和各个页面之间的映射表
	 */
	private void mapPage() {
		this.pageMap.put(Page.START, this.start);
		this.pageMap.put(Page.PROJECT, this.project);
		this.pageMap.put(Page.USER, this.user);
	}
	
	/**
	 *将窗体显示在屏幕中间 
	 */
	private void setFrameAtCenter(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = frame.getPreferredSize();
		int x = (int) ((d.getWidth() - size.getWidth()) / 2);
		int y = (int) ((d.getHeight() - size.getHeight()) / 2);
		frame.setLocation(x, y);
	}
	
	private class FrameButton extends JButton {
		
		public FrameButton(ImageIcon icon, ActionListener l) {
			this.setBackground(Color.BLACK);
			this.addActionListener(l);
			this.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
		}
	}
	
	/**
	 *使窗体响应拖动事件 
	 */
	private void enableDrag(final JFrame frame) {
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
			
		});
		
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();//鼠标距离屏幕左上角的x坐标
				int yOnScreen = e.getYOnScreen();//鼠标距离屏幕左上角的y坐标
				int nowX = xOnScreen - x;
				int nowY = yOnScreen - y;
				frame.setLocation(nowX, nowY);
			}
		});
		
	}
	
	public void setCurrentPage(JPanel page) {
		this.currentPage = page;
	}
	
	public JPanel getRootPanel() {
		return this.root;
	}
}
