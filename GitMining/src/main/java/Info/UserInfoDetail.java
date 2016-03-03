package Info;

/**
 * 详细用户的信息
 * 
 * @author 张仁知
 *
 */
public class UserInfoDetail {

	/**
	 * 用户姓名
	 */
	private String userName;
	
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户加入项目的时间
	 */
	private Date joinDate;
	
	/**
	 * 用户所在公司
	 */
	private String company;
	
	/**
	 * 用户地址
	 */
	private String address;
	
	/**
	 * 用户参与的项目数量
	 */
	private int projectInvolved;
	
	/**
	 * 用户创建的项目数量
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
