package Info;

import java.io.Serializable;

/**
 * 项目信息
 * 
 * @author 张仁知
 *
 */
public class ProjectInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2326293819632388027L;

	/**
	 * 对项目的简要描述
	 */
	private String description;
	
	/**
	 * 项目名称
	 */
	private ProjectName projectName;
	
	/**
	 * 项目的fork数量
	 */
	private int forks;
	
	/**
	 * 项目的star数量
	 */
	private int stars;
	
	/**
	 * 项目的贡献者数量
	 */
	private int contributors;

	public ProjectInfo(String description, ProjectName projectName, int forks,
			int stars, int contributors) {
		this.description = description;
		this.projectName = projectName;
		this.forks = forks;
		this.stars = stars;
		this.contributors = contributors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectName getProjectName() {
		return projectName;
	}

	public void setProjectName(ProjectName projectName) {
		this.projectName = projectName;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getContributors() {
		return contributors;
	}

	public void setContributors(int contributors) {
		this.contributors = contributors;
	}
	
	
}
