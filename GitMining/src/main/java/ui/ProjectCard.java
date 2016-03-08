package ui;

import Info.ProjectInfo;
import res.Strings;

/**
 *项目信息的简介
 *以卡片的形式展现 
 */
@SuppressWarnings("serial")
public class ProjectCard extends Card {
	
	//TODO, 以后用具体的信息填充
	public ProjectCard(ClickHandler handler, int width, int height, ProjectInfo info) {
		super(handler, width, height,
				info.getProjectName().toString() + "," +
				info.getDescription());
		
		//信息面板
		int itemW = width >> 2;
		KVPanel star = new KVPanel(itemW, height,
				Strings.STAR_LABEL, String.valueOf(info.getStars()),
				KVPanel.VERTICAL);
		KVPanel fork = new KVPanel(itemW, height,
				Strings.FORK_LABEL, String.valueOf(info.getForks()),
				KVPanel.VERTICAL);
//		ItemPanel contributor = new ItemPanel(itemW, height, "contributor", "30");
		this.itemPanel.add(star);
		this.itemPanel.add(fork);
//		this.itemPanel.add(contributor);
	}
}
