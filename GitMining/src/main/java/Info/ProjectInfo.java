package Info;

/**
 * ������Ŀ��Ϣ����
 * 
 * @author ����֪
 *
 */
public class ProjectInfo {

	/**
	 * ����Ŀ�ļ�Ҫ����
	 */
	private String description;
	
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
