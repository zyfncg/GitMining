package Info;

/**
 * 项目详细信息
 * 
 * @author 张仁知
 *
 */
public class ProjectDetail {
	
	/** 
	 * 对项目的简要描述
	 */
	private String description;
	
	/**
	 * 项目所使用的编程语言
	 */
	private String language;
	
	/**
	 * 项目主页
	 */
	private String URL;
	
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
	
	/**
	 * 项目的协作者数量
	 */
	private int collaborators;

	public ProjectDetail(String description, String language, String uRL,
			ProjectName projectName, int forks, int stars, int contributors,
			int collaborators) {
		super();
		this.description = description;
		this.language = language;
		URL = uRL;
		this.projectName = projectName;
		this.forks = forks;
		this.stars = stars;
		this.contributors = contributors;
		this.collaborators = collaborators;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
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

	public int getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}
	
	
}
 