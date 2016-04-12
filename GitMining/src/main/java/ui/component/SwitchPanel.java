package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Img;
import ui.ClickHandler;
import ui.PanelSwitcher;

/**
 *切换面板
 *在面板两侧提供面板切换按钮
 *左侧按钮表示切换至前一个 面板
 *右侧按钮表示切换至后一个面板
 *工厂模式创造实例
 */
@SuppressWarnings("serial")
public class SwitchPanel extends JPanel {
	
	public SwitchPanel() {this.setOpaque(false);}
	
	/**
	 *切换按钮的宽度 
	 */
	public static final int SWITCH_WIDTH = 50;
	
	/**
	 *所有信息以若干页面的形式展现
	 *列表存储了所有的页面 
	 */
	private List<JPanel> panelList =
			new ArrayList<JPanel>();
	
	/**
	 *当前信息面板在列表中的下标 
	 */
	private int nowIndex;
	
	/**
	 *信息面板列表的大小 
	 */
	private int size;
	
	/**
	 *当前信息面板 
	 */
	private SwitchPanel current;
	
	/**
	 *获得一个自己完成跳转任务的项目信息面板
	 *@param projects 所有要显示的项目信息
	 *@param isSearch 是否是搜索结果面板
	 *@param page 当前页面 
	 *@param parent 项目信息面板的父容器
	 *@param switcher 页面转换器
	 *@param row 项目信息卡片的行数
	 *@param column 项目信息卡片的列数
	 *@param service 获取项目信息的接口
	 *@param user 获取用户信息的接口
	 */
	public SwitchPanel projectListPanel(List<ProjectInfo> projects,
			JPanel page, JPanel parent, PanelSwitcher switcher,
			int row, int column, RepositoryBLService service,
			UserBLService user, Image image){
		this.initProjectList(projects, page, switcher, row, column, service, user);
		this.nowIndex = 0;
		this.size = this.panelList.size();
		Dimension d = getSize(panelList.get(nowIndex));
		int width = d.width;
		int height = d.height;
		
		SwitchButton previous = new SwitchButton(
				SWITCH_WIDTH, height, true);
		SwitchButton next = new SwitchButton(
				SWITCH_WIDTH, height, false);
		previous.setHandler(
				this.getPreHandler(previous, next, width,
						height, switcher, parent, image));
		next.setHandler(
				this.getNextHandler(previous, next, width,
						height, switcher, parent, image));
		
		return this.getFirstPage(next, height, image);
	}
	
	/**
	 *获得一个自己完成跳转任务的用户信息面板
	 *@param users 所有要显示的用户信息
	 *@param page 当前页面 
	 *@param parent 用户信息面板的父容器
	 *@param switcher 页面转换器
	 *@param row 用户信息卡片的行数
	 *@param column 用户信息卡片的列数
	 *@param repo 获取项目信息列表的接口
	 *@param u 获取用户信息列表的接口
	 */
	public SwitchPanel userListPanel(List<UserInfo> users,
			JPanel page, JPanel parent, PanelSwitcher switcher, int row, int column,
			RepositoryBLService repo, UserBLService u, Image image){
		this.initUserList(users, page, switcher, row, column, repo, u);
		this.nowIndex = 0;
		this.size = this.panelList.size();
		Dimension d = getSize(panelList.get(nowIndex));
		int width = d.width;
		int height = d.height;
		
		SwitchButton previous = new SwitchButton(
				SWITCH_WIDTH, height, true);
		SwitchButton next = new SwitchButton(
				SWITCH_WIDTH, height, false);
		previous.setHandler(
				this.getPreHandler(previous, next, width,
						height, switcher, parent, image));
		next.setHandler(
				this.getNextHandler(previous, next, width,
						height, switcher, parent, image));
		
		return this.getFirstPage(next, height, image);
	}
	
	public void clearPanelList() {
		this.panelList.clear();
	}
	
	/**
	 *返回信息面板的第一页 ,
	 *只能去到下一页，而不能返回上一页
	 *@param next 去到下一页的按钮
	 *@param height 信息面板的高度
	 */
	private SwitchPanel getFirstPage(SwitchButton next, int height, Image image) {
		current = this;
		JPanel left = createPlainPanel(image, SWITCH_WIDTH, height);
		if(this.size <= 1) {
			combineUI(this, left, createPlainPanel(image, SWITCH_WIDTH, height),
					panelList.get(nowIndex), SWITCH_WIDTH, height);
		}else {
			combineUI(this, left, next,
					panelList.get(nowIndex), SWITCH_WIDTH, height);
		}
		return this;
	}
	
	/**
	 * @param previous 回到上一个页面的按钮
	 * @param next 去下一个页面的按钮
	 * @param width 信息页面的宽度
	 * @param height 信息页面的高度
	 * @param swither 页面切换器
	 * @param parent 当前页面的父容器
	 * @return 用户点击回到上一个页面时，响应的事件处理 
	 */
	private ClickHandler getPreHandler(SwitchButton previous,
			SwitchButton next, int width, int height,
			PanelSwitcher switcher, JPanel parent, Image image) {
		ClickHandler pre = () -> {
			SwitchPanel to = null;
			if(nowIndex - 1 == 0) {
				to = rightOnly(next,
						panelList.get(nowIndex - 1),
						width, height, image);
			}else {
				to = bothSides(previous, next,
						panelList.get(nowIndex - 1),
						width, height);
			}
			nowIndex -= 1;
			switcher.jump(parent, current, to, PanelSwitcher.RIGHT);
			current = to;
		};
		return pre;
	}
	
	/**
	 * @param previous 回到上一个页面的按钮
	 * @param next 去下一个页面的按钮
	 * @param width 信息页面的宽度
	 * @param height 信息页面的高度
	 * @param swither 页面切换器
	 * @param parent 当前页面的父容器
	 * @return 用户点击去下一个页面时，响应的事件处理 
	 */
	private ClickHandler getNextHandler(SwitchButton previous,
			SwitchButton next, int width, int height,
			PanelSwitcher switcher, JPanel parent, Image image) {
		ClickHandler h = () -> {
			SwitchPanel to = null;
			if(nowIndex + 1 == size - 1) {
				to = leftOnly(previous,
						panelList.get(nowIndex + 1),
						width, height, image);
			}else {
				to = bothSides(previous, next,
						panelList.get(nowIndex + 1),
						width, height);
			}
			nowIndex += 1;
			switcher.jump(parent, current, to, PanelSwitcher.LEFT);
			current = to;
		};
		return h;
	}
	
	/**
	 *将项目信息转换成信息卡片面板，并存储 
	 *@param projects 项目信息列表
	 *@param page 信息面板所在的页面
	 *@param switcher 页面转换器
	 *@param row 信息卡片面板中卡片的行数
	 *@param column 信息卡片面板中卡片的列数
	 *@param service 获取项目信息的接口
	 *@param user 获取用户信息的接口
	 * @throws Exception 
	 */
	private void initProjectList(List<ProjectInfo> projects,
			JPanel page, PanelSwitcher switcher, int row, int column,
			RepositoryBLService service, UserBLService user){
		int size = projects.size();
		int num = row * column;
		int i;
		for(i = 0; i < size && i + num <= size; i += num) {
			List<ProjectInfo> info = new ArrayList<ProjectInfo>();
			for(int j = i; j < i + num; ++j) {
				info.add(projects.get(j));
			}
			JPanel panel = CardsPanel.createProjectCards(
					page, switcher, row, column, info, service, user);
			this.panelList.add(panel);
		}
		if(i < size && i + num > size) {
			List<ProjectInfo> info = new ArrayList<ProjectInfo>();
			for(int j = i; j < size; ++j) {
				info.add(projects.get(j));
			}
			JPanel panel = CardsPanel.createProjectCards(
					page, switcher, row, column, info, service, user);
			this.panelList.add(panel);
		}
	}
	
	/**
	 *将用户信息转换成信息卡片面板，并存储 
	 *@param users 用户信息列表
	 *@param page 信息面板所在的页面
	 *@param switcher 页面转换器
	 *@param row 信息卡片面板中卡片的行数
	 *@param column 信息卡片面板中卡片的列数
	 *@param repo 获取项目信息列表的接口
	 *@param u 获取用户信息列表的接口
	 */
	private void initUserList(List<UserInfo> users,
			JPanel page, PanelSwitcher switcher, int row, int column,
			RepositoryBLService repo, UserBLService u){
		int size = users.size();
		int num = row * column;
		int i;
		for(i = 0; i < size && i + num <= size; i += num) {
			List<UserInfo> info = new ArrayList<UserInfo>();
			for(int j = i; j < i + num; ++j) {
				info.add(users.get(j));
			}
			JPanel panel = CardsPanel.createUserCards(
					page, switcher, row, column, info, repo, u);
			this.panelList.add(panel);
		}
		if(i < size && i + num > size) {
			List<UserInfo> info = new ArrayList<UserInfo>();
			for(int j = i; j < size; ++j) {
				info.add(users.get(j));
			}
			JPanel panel = CardsPanel.createUserCards(
					page, switcher, row, column, info, repo, u);
			this.panelList.add(panel);
		}
	}
	
	/**
	 * 创建一个没有前进和后退按钮的面板
	 * @param center 面板中间的内容
	 */
	public static SwitchPanel noSwitch(JPanel center, Image image) {
		Dimension d = getSize(center);
		int width = d.width;
		int height = d.height;
		JPanel previous = createPlainPanel(image, SWITCH_WIDTH, height);
		JPanel next = createPlainPanel(image, SWITCH_WIDTH, height);		
		SwitchPanel panel = new SwitchPanel();
		panel.current = panel;
		combineUI(panel, previous, next, center, width, height);
		return panel;
	}
	
	/**
	 *创建只有后退按钮的面板 
	 *@param handler 按钮被点击后的响应
	 *@param center 切换面板中间的内容
	 */
	public static SwitchPanel leftOnly(ClickHandler handler, JPanel center, Image image) {
		Dimension d = getSize(center);
		int width = d.width;
		int height = d.height;
		SwitchButton previous = new SwitchButton(
				handler, SWITCH_WIDTH, height, true);
		return leftOnly(previous, center, width, height, image);
	}
	
	private static SwitchPanel leftOnly(SwitchButton previous, JPanel center,
			int width, int height, Image image) {
		JPanel next = createPlainPanel(image, SWITCH_WIDTH, height);		
		SwitchPanel panel = new SwitchPanel();
		panel.current = panel;
		combineUI(panel, previous, next, center, width, height);
		return panel;

	}
	
	/**
	 *创建只有前进按钮的面板 
	 *@param handler 按钮被点击后的响应
	 *@param center 切换面板中间的内容
	 */
	public static SwitchPanel rightOnly(Image image, ClickHandler handler, JPanel center) {
		Dimension d = getSize(center);
		int width = d.width;
		int height = d.height;
		SwitchButton next = new SwitchButton(
				handler, SWITCH_WIDTH, height, false);
		return rightOnly(next, center, width, height, image);
	}
	
	/**
	 *创建只有前进按钮的面板 
	 *@param btn 前进按钮
	 *@param center 切换面板中间的内容
	 */
	private static SwitchPanel rightOnly(SwitchButton btn, JPanel center,
			int width, int height, Image image) {
		JPanel previous = createPlainPanel(image, SWITCH_WIDTH, height);
		SwitchPanel panel = new SwitchPanel();
		panel.current = panel;
		combineUI(panel, previous, btn, center, width, height);
		return panel;
	}
	
	/**
	 *创建具有前进和后退按钮的面板 
	 *@param handler 按钮被点击后的响应
	 *@param center 切换面板中间的内容
	 */
	public static SwitchPanel bothSides(ClickHandler left,
			ClickHandler right, JPanel center) {
		Dimension d = getSize(center);
		int width = d.width;
		int height = d.height;
		SwitchButton previous = new SwitchButton(
				left, SWITCH_WIDTH, height, true);
		SwitchButton next = new SwitchButton(
				right, SWITCH_WIDTH, height, false);
		return bothSides(previous, next, center, width, height);
	}
	
	private static SwitchPanel bothSides(SwitchButton left,
			SwitchButton right, JPanel center, double width, double height) {
		SwitchPanel panel = new SwitchPanel();
		panel.current = panel;
		combineUI(panel, left, right, center, width, height);
		return panel;
	}
	
	public SwitchPanel getCurrentPanel() {
		return this.current;
	}
	
	/**
	 *获得整个SwitchPanel的宽度和高度 
	 */
	private static Dimension getSize(JPanel panel) {
		Dimension d = panel.getPreferredSize();
		int width = d.width + (SWITCH_WIDTH << 1);
		int height = d.height;
		return new Dimension(width, height);
	}
	
	/**
	 *创建一个空的面板 
	 */
	private static JPanel createPlainPanel(Image img, int width, int height) {
		JPanel p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(img == null) return ;
				g.drawImage(img,
						0, 0, width, height,
						0, 0, img.getWidth(null), img.getHeight(null),
						null);
			}
		};
		p.setPreferredSize(new Dimension(width, height));
		p.setOpaque(false);
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
	private static class SwitchButton extends JPanel {
		
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
		
		private int width;
		
		private int height;
		
		public SwitchButton(ClickHandler handler, int width,
				int height,boolean isLeft) {
			this(width, height, isLeft);
			this.handler = handler;
		}
		
		public SwitchButton(int width, int height, boolean isLeft) {
			if(isLeft) {
				away = Img.BACK_AWAY;
				enter = Img.BACK_ENTER;
			}else {
				away = Img.NEXT_AWAY;
				enter = Img.NEXT_ENTER;
			}
			image = away;
			this.width = width;
			this.height = height;
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(width, height));
			
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
		
		public void setHandler(ClickHandler handler) {
			this.handler = handler;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int y = (image.getHeight(null) - height) / 2;
			g.drawImage(image,
					0, 0, width, height,
					0, y, width, y + height,
					null);
		}
	}
}
