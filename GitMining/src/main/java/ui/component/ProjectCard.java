package ui.component;

import Info.ProjectInfo;
import res.Strings;
import ui.ClickHandler;


/**
 *项目信息的简介
 *以卡片的形式展现 
 */
@SuppressWarnings("serial")
public class ProjectCard extends Card {
	
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
		KVPanel contributor = new KVPanel(itemW, height,
				Strings.CONTRIBUTOR_LABEL, String.valueOf(info.getContributors()),
				KVPanel.VERTICAL);
		this.itemPanel.add(star);
		this.itemPanel.add(fork);
		this.itemPanel.add(contributor);
	}
}
