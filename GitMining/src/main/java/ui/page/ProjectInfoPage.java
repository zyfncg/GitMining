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
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import Info.ProjectDetail;
import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Img;
import res.Strings;
import ui.ClickHandler;
import ui.InfoManager;
import ui.PanelSwitcher;
import ui.Refreshable;
import ui.component.BackPanel;
import ui.component.KVPanel;
import ui.component.SwitchPanel;
import ui.component.TextPanel;

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
	 *项目参与者信息面板容器
	 */
	private JPanel involveContainer;
	
	/**
	 *参与者信息面板 
	 */
	private SwitchPanel involve;
	
	/**
	 *参与者信息 
	 */
	private List<UserInfo> involvers;
	
	/**
	 *用户参与者信息面板容器
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
	 *一行显示的信息卡片数目 
	 */
	private int lineCard;
	
	/**
	 *页面切换器 
	 */
	private PanelSwitcher switcher;
	
	/**
	 *获取项目信息的接口 
	 */
	private RepositoryBLService repo;
	
	/**
	 *获取用户信息的接口 
	 */
	private UserBLService user;
	
	public ProjectInfoPage(int lineCardNum, int width, int height,
			PanelSwitcher switcher, ProjectDetail detail,
			RepositoryBLService repo, UserBLService user) {
		this.lineCard = lineCardNum;
		this.switcher = switcher;
		//分成6部分， 回退面板：描述面板: 项目地址面板: 信息面板：贡献者面板：协作者面板
		//= 2/3 : 1/2 : 1/6: 1/3 : 1/3 : 2 : 2
		
		//回退面板
		int backH = height / 9;
		int btnH = backH >> 1;
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(
				handler, width, backH, btnW, btnH, Img.USER_ICON);
		
		//描述面板
		TextPanel description = new TextPanel(
				detail.getDescription(), width, height / 12);
		
		//项目地址面板
		JPanel URL = new JPanel();
		URL.setOpaque(false);
		int urlW = width >> 1;
		int urlH = backH >> 1;
		//项目地址文本框
		JTextField url = new JTextField();
		url.setText(detail.getURL());
		url.setPreferredSize(new Dimension((int)(urlW * 0.8), urlH));
		url.setEditable(false);
		//复制按钮
		JButton copy = new JButton(Img.COPY);
		copy.addActionListener(e -> {
			Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection content = new StringSelection(url.getText());
			board.setContents(content, null);
			copy.setToolTipText("已复制到剪贴板");
		});
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
		copy.setPreferredSize(new Dimension(urlW / 5, urlH));
		
		//将文本框和按钮加到面板
		FlowLayout urlLayout = new FlowLayout();
		urlLayout.setVgap(urlH >> 3);
		urlLayout.setHgap(0);
		URL.setLayout(urlLayout);
		URL.add(url);
		URL.add(copy);
		
		//信息面板
		int itemW = width >> 3;
		int itemH = height / 18;
		//各项信息面板
		KVPanel language = new KVPanel(itemW, itemH,
				Strings.LANGUAGE_LABEL, detail.getLanguage(), KVPanel.VERTICAL);
		KVPanel star = new KVPanel(itemW, itemH,
				Strings.STAR_LABEL, String.valueOf(detail.getStars()), KVPanel.VERTICAL);
		KVPanel fork = new KVPanel(itemW, itemH,
				Strings.FORK_LABEL, String.valueOf(detail.getForks()), KVPanel.VERTICAL);
		KVPanel contributor = new KVPanel(itemW, itemH,Strings.CONTRIBUTOR_LABEL,
				String.valueOf(detail.getContributors()), KVPanel.VERTICAL);
		KVPanel collaborator = new KVPanel(itemW, itemH, Strings.COLLABORATOR_LABEL,
				String.valueOf(detail.getCollaborators()), KVPanel.VERTICAL);
		KVPanel subscriber = new KVPanel(itemW, itemH, Strings.SUBSCRIBER_LABEL,
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
		contri = InfoManager.getUserInfoPanel(contributors, contriContainer, switcher,
				lineCard, CONTRIBUTOR_ROW, this, repo, user,
				Img.FOUNDER_TIP, Img.SAMLL_NULL_TIP);
		contriContainer.add(contri, BorderLayout.CENTER);

		//参与者面板
		involvers = detail.getCollaboratorsInfo();
		involveContainer = new JPanel(new BorderLayout());
		involveContainer.setOpaque(false);
		involve = InfoManager.getUserInfoPanel(involvers, involveContainer, switcher,
				lineCard, COLLABORATOR_ROW, this, repo, user,
				Img.PARICIPANT_TIP, Img.SAMLL_NULL_TIP);
		involveContainer.add(involve, BorderLayout.CENTER);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.setOpaque(false);
		all.add(icon);
		all.add(description);
		all.add(URL);
		all.add(info);
		all.add(contriContainer);
		all.add(involveContainer);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(Colors.PAGE_BG);
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
		SwitchPanel from1 = involve.getCurrentPanel();
		SwitchPanel to1 = InfoManager.getUserInfoPanel(involvers, involveContainer, switcher,
				lineCard, CONTRIBUTOR_ROW, this, repo, user,
				Img.FOUNDER_TIP, Img.SAMLL_NULL_TIP);
		switcher.jump(involveContainer, from1, to1, PanelSwitcher.LEFT);
		involve = to1;
		
		SwitchPanel from2 = contri.getCurrentPanel();
		SwitchPanel to2 = InfoManager.getUserInfoPanel(contributors, contriContainer, switcher,
				lineCard, CONTRIBUTOR_ROW, this, repo, user,
				Img.FOUNDER_TIP, Img.SAMLL_NULL_TIP);
		switcher.jump(contriContainer, from2, to2, PanelSwitcher.LEFT);
		contri = to2;
	}
}
