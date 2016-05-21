package Info;

import java.util.List;

public class Relationship {
	/**
	 * 用户姓名
	 */
	private UserInfoDetail userName;
	/**
	 * 用户姓名
	 */
	private List<RelationUser> RelationUser;
	public Relationship(UserInfoDetail name,List<RelationUser> relation){
		this.userName = name;
		this.RelationUser = relation;
	}
	public Relationship(){
		
	}
	public UserInfoDetail getUserName() {
		return userName;
	}
	public void setUserName(UserInfoDetail userName) {
		this.userName = userName;
	}
	public List<RelationUser> getRelationUser() {
		return RelationUser;
	}
	public void setRelationUser(List<RelationUser> relationUser) {
		RelationUser = relationUser;
	}
	
}
