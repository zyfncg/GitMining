package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Info.ProjectInfo;
import Info.UserInfo;

/**
 *项目详细信息面板 
 */
@SuppressWarnings("serial")
public class ProjectInfoPage extends JPanel {

	public ProjectInfoPage(int lineCardNum, int width, int height, PanelSwitcher switcher) {
		//分成5部分， 图像面板：描述面板: 信息面板：贡献者面板：协作者面板 = 2 / 3 : 1 / 3 : 1 : 2 : 2
		
		//图像面板
		int iconH = height / 9;
		int btnH = iconH >> 1;
		int btnW = btnH << 1;
		BackPanel icon = new BackPanel(width, iconH, btnW, btnH);
		
		//描述面板
		JLabel txt = new JLabel("Linux, an operation system kernel",
				JLabel.CENTER);
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		JPanel description = new JPanel(fl);
		description.setPreferredSize(new Dimension(width, iconH >> 1));
		description.add(txt);
		
		//信息面板
		int itemW = width >> 3;
		int itemH = height / 6;
		ItemPanel language = new ItemPanel(itemW, itemH, "language", "Java");
		ItemPanel star = new ItemPanel(itemW, itemH, "star", "100");
		ItemPanel fork = new ItemPanel(itemW, itemH, "fork", "20");
		ItemPanel contributor = new ItemPanel(itemW, itemH, "contributor", "10");
		ItemPanel collaborator = new ItemPanel(itemW, itemH, "collaborator", "4");
		ItemPanel subscriber = new ItemPanel(itemW, itemH, "subscriber", "20");
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		JPanel info = new JPanel(layout);
		info.add(language);
		info.add(star);
		info.add(fork);
		info.add(contributor);
		info.add(collaborator);
		info.add(subscriber);
		
		//贡献者面板
		//TODO 具体信息获取
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			projects.add(new ProjectInfo(null, null, 0, 0, 0));
		}
		CardsPanel c1 = CardsPanel.createProjectCards(projects);
		SwitchPanel contri = SwitchPanel.rightOnly(null, c1);

		//参与者面板
		List<UserInfo> users = new ArrayList<UserInfo>();
		for(int i = 0; i < lineCardNum; ++i) {
			users.add(new UserInfo(null, null, 0, 0));
		}
		CardsPanel c2 = CardsPanel.createUserCards(users);
		SwitchPanel involve = SwitchPanel.rightOnly(null, c2);
		
		//组装所有面板
		Box all = Box.createVerticalBox();
		all.add(icon);
		all.add(description);
		all.add(info);
		all.add(contri);
		all.add(involve);
		this.setLayout(new BorderLayout());
		this.add(all, BorderLayout.CENTER);
	}
}
