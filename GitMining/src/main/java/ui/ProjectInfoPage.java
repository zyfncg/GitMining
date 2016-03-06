package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Info.ProjectDetail;
import Info.UserInfo;

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
			PanelSwitcher switcher, ProjectDetail project) {
		//分成5部分， 图像面板：描述面板: 项目地址面板: 信息面板：贡献者面板：协作者面板
		//= 1 / 3 : 1 / 6: 1 / 6: 1 / 3 : 1 : 2 : 2
		
		//图像面板
		int iconH = height / 9;
		int btnH = iconH >> 1;
		int btnW = btnH << 1;
		ClickHandler handler = () -> switcher.back(this, PanelSwitcher.RIGHT);
		BackPanel icon = new BackPanel(handler, width, iconH, btnW, btnH);
		
		//描述面板
		JLabel txt = new JLabel(project.getDescription(),
				SwingConstants.CENTER);
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		JPanel description = new JPanel(fl);
		description.setPreferredSize(new Dimension(width, iconH >> 1));
		description.add(txt);
		
		//项目地址面板
		JPanel URL = new JPanel();
		int urlW = width >> 1;
		int urlH = iconH >> 1;
		JTextField url = new JTextField();
		url.setText(project.getURL());
		url.setPreferredSize(new Dimension((int)(urlW * 0.8), urlH));
		url.setEditable(false);
		JButton copy = new JButton("复制");//TODO字符串资源统一管理
		copy.setToolTipText("将地址复制到剪贴板");
		copy.addActionListener(e -> {
			Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection content = new StringSelection(url.getText());
			board.setContents(content, null);
			copy.setToolTipText("已复制到剪贴板");
		});
		copy.setPreferredSize(new Dimension(urlW / 5, urlH));
		FlowLayout urlLayout = new FlowLayout();
		urlLayout.setVgap(urlH >> 3);
		urlLayout.setHgap(0);
		URL.setLayout(urlLayout);
		URL.add(url);
		URL.add(copy);
		
		//信息面板
		int itemW = width >> 3;
		int itemH = height >> 3;
		ItemPanel language = new ItemPanel(
				itemW, itemH, "language", project.getLanguage());
		ItemPanel star = new ItemPanel(
				itemW, itemH, "star", String.valueOf(project.getStars()));
		ItemPanel fork = new ItemPanel(
				itemW, itemH, "fork", String.valueOf(project.getForks()));
		ItemPanel contributor = new ItemPanel(
				itemW, itemH, "contributor", String.valueOf(project.getContributors()));
		ItemPanel collaborator = new ItemPanel(
				itemW, itemH, "collaborator", String.valueOf(project.getCollaborators()));
		ItemPanel subscriber = new ItemPanel(
				itemW, itemH, "subscriber", String.valueOf("33"));
		FlowLayout layout = new FlowLayout();
		layout.setVgap(itemH >> 3);
		JPanel info = new JPanel(layout);
		info.add(language);
		info.add(star);
		info.add(fork);
		info.add(contributor);
		info.add(collaborator);
		info.add(subscriber);
		
		//贡献者面板
		//TODO 具体信息获取
		List<UserInfo> u1 = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			u1.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel c1 = CardsPanel.createUserCards(this, switcher, CONTRIBUTOR_ROW, lineCardNum, u1);
		SwitchPanel contri = SwitchPanel.rightOnly(null, c1);

		//参与者面板
		List<UserInfo> u2 = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			u2.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel c2 = CardsPanel.createUserCards(this, switcher, COLLABORATOR_ROW, lineCardNum, u2);
		SwitchPanel involve = SwitchPanel.rightOnly(null, c2);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.add(icon);
		all.add(description);
		all.add(URL);
		all.add(info);
		all.add(contri);
		all.add(involve);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
	}
}
