package Info;

import java.io.Serializable;
import java.util.List;

/**
 * 详细用户信息
 * 
 * @author 张仁知
 *
 */
public class UserInfoDetail implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2852651766558438L;

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
	 * 用户参加这个项目的时间
	 */
	private Date joinDate;
	
	/**
	 * 用户类型
	 */
	private String UserType;
	
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
	
	/**
	 * 用户创建的项目信息列表
	 */
	private List<ProjectInfo> ProjectCreatInfo;

	public UserInfoDetail(String userName, String descriptionUser,
			String email, Date joinDate, String company, String address,
			int projectInvolved, int projectCreate,List<ProjectInfo> ProjectCreatInfo) {
		this.userName = userName;
		this.descriptionUser = descriptionUser;
		this.email = email;
		this.joinDate = joinDate;
		this.company = company;
		this.address = address;
		this.projectInvolved = projectInvolved;
		this.projectCreate = projectCreate;
		this.ProjectCreatInfo = ProjectCreatInfo;
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

	public List<ProjectInfo> getProjectCreatInfo() {
		return ProjectCreatInfo;
	}

	public void setProjectCreatInfo(List<ProjectInfo> projectCreatInfo) {
		ProjectCreatInfo = projectCreatInfo;
	}
	
	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	/**
	 * 将用户详细信息转为用户粗略信息
	 */
	public UserInfo ChangeDetailToInfo(){
		UserInfo userInfo = new UserInfo(this.userName, this.descriptionUser, this.projectInvolved, this.projectCreate);
		return userInfo;
	}
}
