package Info;

/**
 * �û�����Ϣ
 * 
 * @author ����֪
 *
 */
public class UserInfo {

	/**
	 * �û�����
	 */
	private String userName;
	
	/**
	 * ���û��ļ�Ҫ����
	 */
	private String descriptionUser;
	
	/**
	 * �û��������Ŀ����
	 */
	private int projectInvolved;
	
	/**
	 * �û���������Ŀ����
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
