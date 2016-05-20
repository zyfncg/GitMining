package Info;

import java.util.List;

public class Relationship {
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户姓名
	 */
	private List<UserInfo> RelationUser;
	public Relationship(String name,List<UserInfo> relation){
		this.userName = name;
		this.RelationUser = relation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<UserInfo> getRelationUser() {
		return RelationUser;
	}
	public void setRelationUser(List<UserInfo> relationUser) {
		RelationUser = relationUser;
	}
	
}
