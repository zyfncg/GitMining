package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import Info.ProjectInfo;
import Info.UserInfo;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import businessLogicService.UserBLService.UserBLService;
import res.Colors;
import res.Strings;

/**
 *项目详细信息面板 
 */
@SuppressWarnings("serial")
public class ProjectInfoPage extends JPanel {
	
	/**
	 *显示的贡献者信息卡片的行数
	 */
	private static final int CONTRIBUTOR_ROW = 1;
	
	/**
	 *显示的协作者信息卡片的行数
	 */
	private static final int COLLABORATOR_ROW = 1;
	
	public ProjectInfoPage(int lineCardNum, int width, int height,
			PanelSwitcher switcher, ProjectInfo project,
			RepositoryBLService repo, UserBLService user) {
		//分成5部分， 图像面板：描述面板: 项目地址面板: 信息面板：贡献者面板：协作者面板
		//= 1 / 3 : 1 / 6: 1 / 6: 1 / 3 : 1 : 2 : 2
		
		//图像面板
		int iconH = height / 9;
		int btnH = iconH >> 1;
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(handler, width, iconH, btnW, btnH);
		
		//描述面板
		TextPanel description = new TextPanel(
				project.getDescription(), width, iconH >> 1);
		
		//项目地址面板
		JPanel URL = new JPanel();
		URL.setOpaque(false);
		int urlW = width >> 1;
		int urlH = iconH >> 1;
		//项目地址文本框
		JTextField url = new JTextField();
		ProjectDetail detail = null;
		try {
			detail = repo.getRepositoryByName(project.getProjectName());
		} catch (Exception e3) {
			// TODO 异常处理
		}
		url.setText(detail.getURL());
		url.setPreferredSize(new Dimension((int)(urlW * 0.8), urlH));
		url.setEditable(false);
		//复制按钮
		JButton copy = new JButton(Strings.COPY_LABEL);//TODO字符串资源统一管理
//		copy.setToolTipText("将地址复制到剪贴板");
//		ToolTipManager.sharedInstance().setInitialDelay(0);
//		copy.addActionListener(e -> {
//			Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
//			StringSelection content = new StringSelection(url.getText());
//			board.setContents(content, null);
//			copy.setToolTipText("已复制到剪贴板");
//		});
		JPopupMenu popup = new JPopupMenu();
		TipText tip = new TipText();
		tip.setEnabled(false);
		popup.add(tip);
		copy.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				tip.setText(Color.BLACK);
				popup.show(copy, -20, -20);
			};
			
			public void mouseReleased(MouseEvent e) {
				tip.setText(Color.WHITE);
				popup.show(copy,-20, -20);
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
		int itemH = height >> 3;
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
		List<UserInfo> u1 = detail.getContributorsInfo();
		JPanel contri = new JPanel(new BorderLayout());
		contri.setOpaque(false);
		SwitchPanel p1 = null;
		try {
			 p1 = InfoManager.getUserInfoPanel(u1, contri, switcher,
					lineCardNum, CONTRIBUTOR_ROW, this, repo, user, null);//TODO 给出贡献者的图片
		} catch (Exception e2) {
			// TODO 异常处理
		}
		contri.add(p1, BorderLayout.CENTER);

		//参与者面板
		List<UserInfo> u2 = detail.getCollaboratorsInfo();
		JPanel involve = new JPanel(new BorderLayout());
		involve.setOpaque(false);
		SwitchPanel p2 = null;
		try {
			p2 = InfoManager.getUserInfoPanel(u2, involve, switcher,
					lineCardNum, COLLABORATOR_ROW, this, repo, user, null);//TODO 给出参与者的图片
		} catch (Exception e1) {
			// TODO 异常处理
		}
		involve.add(p2, BorderLayout.CENTER);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.setOpaque(false);
		all.add(icon);
		all.add(description);
		all.add(URL);
		all.add(info);
		all.add(contri);
		all.add(involve);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
		this.setBackground(Colors.PAGE_BG);
	}
	
	private class TipText extends JMenuItem {
		private Color c;
		
		public TipText() {
			this.setPreferredSize(new Dimension(40, 26));
		}
		
		public void setText(Color c) {//TOOD 以后用图片代替
			this.c = c;
			this.repaint();
		};
		
		protected void paintComponent(Graphics g) {
			g.setColor(c);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		};
	}
}
