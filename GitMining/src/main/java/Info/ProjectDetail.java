package Info;

/**
 * ��Ŀ��ϸ��Ϣ
 * 
 * @author ����֪
 *
 */
public class ProjectDetail {
	
	/** 
	 * ����Ŀ�ļ�Ҫ����
	 */
	private String description;
	
	/**
	 * ��Ŀ��ʹ�õı������
	 */
	private String language;
	
	/**
	 * ��Ŀ��ҳ
	 */
	private String URL;
	
	/**
	 * ��Ŀ����
	 */
	private ProjectName projectName;
	
	/**
	 * ��Ŀ��fork����
	 */
	private int forks;
	
	/**
	 * ��Ŀ��star����
	 */
	private int stars;
	
	/**
	 * ��Ŀ�Ĺ���������
	 */
	private int contributors;
	
	/**
	 * ��Ŀ��Э��������
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
 