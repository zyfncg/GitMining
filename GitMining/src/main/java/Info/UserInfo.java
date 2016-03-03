package Info;

/**
 * 用户的信息
 * 
 * @author 张仁知
 *
 */
public class UserInfo {

	/**
	 * 用户姓名
	 */
	private String userName;
	
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	
	/**
	 * 用户参与的项目数量
	 */
	private int projectInvolved;
	
	/**
	 * 用户创建的项目数量
	 */
	private int projectCreate;

	public UserInfo(String userName, String descriptionUser,
			int projectInvolved, int projectCreate) {
		this.userName = userName;
		this.descriptionUser = descriptionUser;
		this.projectInvolved = projectInvolved;
		this.projectCreate = projectCreate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescriptionUser() {
		return descriptionUser;
	}

	public void setDescriptionUser(String descriptionUser) {
		this.descriptionUser = descriptionUser;
	}

	public int getProjectInvolved() {
		return projectInvolved;
	}

	public void setProjectInvolved(int projectInvolved) {
		this.projectInvolved = projectInvolved;
	}

	public int getProjectCreate() {
		return projectCreate;
	}

	public void setProjectCreate(int projectCreate) {
		this.projectCreate = projectCreate;
	}
	
	
}
