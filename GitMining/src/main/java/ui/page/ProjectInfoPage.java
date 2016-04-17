package ui.page;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;
import ui.CardsManager;
import ui.ClickHandler;
import ui.MainFrame;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.BackPanel;
import ui.component.KVPanel;
import ui.component.SwitchButton;
import ui.component.SwitchPanel;
import ui.component.TextPanel;
import ui.component.UserCard;
import ui.statistics.SingleProjectStatPage;

/**
 *项目详细信息面板 
 */
@SuppressWarnings("serial")
public class ProjectInfoPage extends JPanel implements Refreshable {
	
	/**
	 *显示的贡献者信息卡片的行数
	 */
	private static final int CONTRIBUTOR_ROW = 1;
	
	/**
	 *显示的协作者信息卡片的行数
	 */
	private static final int COLLABORATOR_ROW = 1;
	
	/**
	 *项目协作者信息面板容器
	 */
	private JPanel collabContainer;
	
	/**
	 *协作者信息面板 
	 */
	private SwitchPanel collab;
	
	/**
	 *协作者信息 
	 */
	private List<UserInfo> collaborators;
	
	/**
	 *用户贡献者信息面板容器
	 */
	private JPanel contriContainer;
	
	/**
	 *贡献者信息面板 
	 */
	private SwitchPanel contri;
	
	/**
	 *贡献者信息 
	 */
	private List<UserInfo> contributors;
	
	/**
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *获取项目信息的接口 
	 */
	private RepositoryBLService repository;
	
	/**
	 *获取用户信息的接口 
	 */
	private UserBLService user;
	
	public ProjectInfoPage(int width, int height,
			PanelSwitcher switcher, ProjectDetail detail,
			RepositoryBLService repo, UserBLService user) {
		this.switcher = switcher;
		this.user = user;
		this.repository = repo;
		//分成6部分， 回退面板：描述面板: 项目地址面板: 信息面板：贡献者面板：协作者面板
		//= 1/2 : 1/2 : 1/2: 1/2 : 2 : 2
		
		//回退面板
		int backH = height / 12;
		int btnH = (int) (backH / 3 * 2);
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(
				handler, width, backH, btnW, btnH, Img.USER_ICON);
		
		//描述面板
		TextPanel description = new TextPanel(
				detail.getDescription(), width, backH);
		
		//项目地址面板
		JPanel URL = new JPanel();
		URL.setOpaque(false);
		int urlW = width;
		int urlH = backH;
		URL.setPreferredSize(new Dimension(urlW, urlH));
		//项目地址文本框
		JTextField url = new JTextField();
		url.setText(detail.getURL());
		int textW = width - (SwitchButton.SWITCH_WIDTH * 10);
		int textH = urlH / 3 * 2;
		url.setPreferredSize(new Dimension(textW, textH));
		url.setEditable(false);
		//复制按钮
		JButton copy = new JButton(Img.COPY);
		copy.addActionListener(e -> {//为复制按钮添加将项目地址复制到剪贴板的监听操作
			Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection content = new StringSelection(url.getText());
			board.setContents(content, null);
		});
		//为复制按钮添加ToolTip(用JPopupMenu模拟)
		JPopupMenu popup = new JPopupMenu();
		Dimension d = copy.getPreferredSize();
		TipText tip = new TipText(d.width, (int)(d.height * 0.75));
		final int x = -d.width / 3;
		final int y = -d.height;
		tip.setEnabled(false);
		popup.add(tip);
		copy.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				tip.setText(Img.COPY_CLIPBOARD_TIP);               
				popup.show(copy, x, y);
			};
			
			public void mouseReleased(MouseEvent e) {
				tip.setText(Img.COPY_TIP);
				popup.show(copy, x, y);
			};
			
			public void mouseExited(MouseEvent e) {
				popup.setVisible(false);
			};
		});
		int copyW = textW >> 2;
		int copyH = textH;
		copy.setPreferredSize(new Dimension(copyW, copyH));
		//将文本框和复制按钮组合成一个新面板
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		fl.setHgap(0);
		JPanel panel = new JPanel(fl);
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(
				textW + copyW, textH));
		panel.add(url);
		panel.add(copy);
		//统计按钮
		JButton statistics = new JButton();
		statistics.setPreferredSize(new Dimension(
				SwitchButton.SWITCH_WIDTH << 1, copyH));
		statistics.addActionListener(e -> switcher.backableJump(this,
				new SingleProjectStatPage(switcher, detail.getStatisticDetail()),
						PanelSwitcher.LEFT));
		statistics.setIcon(Img.STATISTICS);
		//将文本框、复制按钮和统计按钮加到面板
		FlowLayout urlLayout = new FlowLayout();
		urlLayout.setVgap(urlH / 6);
		urlLayout.setHgap(SwitchButton.SWITCH_WIDTH);
		URL.setLayout(urlLayout);
		URL.add(panel);
		URL.add(statistics);
		
		//信息面板
		int itemW = width >> 3;
		int itemH = backH;
		//各项信息面板
		KVPanel language = new KVPanel(itemW, itemH,
				Strings.Project.LANGUAGE_LABEL, detail.getLanguage(), KVPanel.VERTICAL);
		KVPanel star = new KVPanel(itemW, itemH,
				Strings.Project.STAR_LABEL, String.valueOf(detail.getStars()), KVPanel.VERTICAL);
		KVPanel fork = new KVPanel(itemW, itemH,
				Strings.Project.FORK_LABEL, String.valueOf(detail.getForks()), KVPanel.VERTICAL);
		KVPanel contributor = new KVPanel(itemW, itemH,Strings.Project.CONTRIBUTOR_LABEL,
				String.valueOf(detail.getContributors()), KVPanel.VERTICAL);
		KVPanel collaborator = new KVPanel(itemW, itemH, Strings.Project.COLLABORATOR_LABEL,
				String.valueOf(detail.getCollaborators()), KVPanel.VERTICAL);
		KVPanel subscriber = new KVPanel(itemW, itemH, Strings.Project.SUBSCRIBER_LABEL,
				String.valueOf(detail.getSubscribers()), KVPanel.VERTICAL);
		//将信息面板组合
		FlowLayout layout = new FlowLayout();
		layout.setVgap(itemH >> 3);
		JPanel info = new JPanel(layout);
		info.setOpaque(false);
		info.add(language);
		info.add(star);
		info.add(fork);
		info.add(contributor);
		info.add(collaborator);
		info.add(subscriber);
		
		//贡献者面板
		contributors = detail.getContributorsInfo();
		contriContainer = new JPanel(new BorderLayout());
		contriContainer.setOpaque(false);
		contri = this.createSwitchPanel(contributors,
				contriContainer, CONTRIBUTOR_ROW, Img.CONTRIBUTOR_TIP);
		contriContainer.add(contri, BorderLayout.CENTER);

		//协作者面板
		collaborators = detail.getCollaboratorsInfo();
		collabContainer = new JPanel(new BorderLayout());
		collabContainer.setOpaque(false);
		collab = this.createSwitchPanel(collaborators,
				collabContainer, COLLABORATOR_ROW, Img.COLLABOROTOR_TIP);
		collabContainer.add(collab, BorderLayout.CENTER);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.setOpaque(false);
		all.add(icon);
		all.add(description);
		all.add(URL);
		all.add(info);
		all.add(contriContainer);
		all.add(collabContainer);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(Colors.PAGE_BG);
	}
	
	/**
	 *创建可切换用户信息面板
	 */
	private SwitchPanel createSwitchPanel(List<UserInfo> list,
			JPanel parent, int row, Image image) {
		List<UserCard> cards = new ArrayList<>();
		int size = list.size();
		UserInfo userInfo = null;
		for (int i = 0; i < size; ++i) {
			userInfo = list.get(i);
			cards.add(new UserCard(
					this.toDetailInfo(userInfo),
					userInfo));
		}
		CardsManager cm = new CardsManager(image,
				row, cards, parent, switcher);
		return cm.first();
	}
	
	/**
	 *获得由信息卡片跳转到详细信息页面的控制器 
	 */
	private ClickHandler toDetailInfo(UserInfo info) {
		ClickHandler handler = () -> {
			UserInfoDetail detail = null;
			try {
				detail = user.getUserByName(info.getUserName());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),
						Strings.ERROR_DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
				return ;
			}
			
			switcher.backableJump(this,
					new UserInfoPage(MainFrame.PAGE_WIDTH,
							MainFrame.PAGE_HEIGHT, switcher,
							detail, repository, user),
					PanelSwitcher.LEFT);
		};
		return handler;
	}
	
	private class TipText extends JMenuItem {
		
		private Image img;
		
		private int width;
		
		private int height;
		
		public TipText(int width, int height) {
			this.width = width;
			this.height = height;
			this.setPreferredSize(new Dimension(width, height));
		}
		
		public void setText(Image img) {
			this.img = img;
			this.repaint();
		};
		
		protected void paintComponent(Graphics g) {
			g.drawImage(img,
					0, 0, width, height, 0, 0,
					img.getWidth(null), img.getHeight(null),
					null);
		};
	}

	@Override
	public void refresh() {
		//TODO 暂时无事可做
	}
}
