package Info.Relation;

import java.io.Serializable;
import java.util.List;

import Info.UserInfo;

public class AllUsrRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1340471294397091443L;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	/**
	 * 有联系的相关用户
	 */
	private List<UserInfo> AllRelation;
	public AllUsrRelation(String name,String des,List<UserInfo> all){
		this.userName = name;
		this.descriptionUser = des;
		this.AllRelation = all;
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
	public List<UserInfo> getAllRelation() {
		return AllRelation;
	}
	public void setAllRelation(List<UserInfo> allRelation) {
		AllRelation = allRelation;
	}
	
}
