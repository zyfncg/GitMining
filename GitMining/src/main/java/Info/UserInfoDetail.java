package Info;

/**
 * ��ϸ�û�����Ϣ
 * 
 * @author ����֪
 *
 */
public class UserInfoDetail {

	/**
	 * �û�����
	 */
	private String userName;
	
	/**
	 * ���û��ļ�Ҫ����
	 */
	private String descriptionUser;
	
	/**
	 * �û�����
	 */
	private String email;
	
	/**
	 * �û�������Ŀ��ʱ��
	 */
	private Date joinDate;
	
	/**
	 * �û����ڹ�˾
	 */
	private String company;
	
	/**
	 * �û���ַ
	 */
	private String address;
	
	/**
	 * �û��������Ŀ����
	 */
	private int projectInvolved;
	
	/**
	 * �û���������Ŀ����
	 */
	private int projectCreate;

	public UserInfoDetail(String userName, String descriptionUser,
			String email, Date joinDate, String company, String address,
			int projectInvolved, int projectCreate) {
		this.userName = userName;
		this.descriptionUser = descriptionUser;
		this.email = email;
		this.joinDate = joinDate;
		this.company = company;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
