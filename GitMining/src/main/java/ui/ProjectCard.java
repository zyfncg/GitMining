package ui;

import Info.ProjectInfo;

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
		ItemPanel star = new ItemPanel(itemW, height,
				"star", String.valueOf(info.getStars()));
		ItemPanel fork = new ItemPanel(itemW, height,
				"fork", String.valueOf(info.getForks()));
//		ItemPanel contributor = new ItemPanel(itemW, height, "contributor", "30");
		this.itemPanel.add(star);
		this.itemPanel.add(fork);
//		this.itemPanel.add(contributor);
	}
}
