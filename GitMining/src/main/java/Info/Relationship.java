package Info;

import java.util.List;

public class Relationship {
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	/**
	 * 用户姓名
	 */
	private List<RelationUser> RelationUser;
	
	public Relationship(String name, String Des, List<RelationUser> relation){
		this.userName = name;
		this.descriptionUser = Des;
		this.RelationUser = relation;
	}
	public Relationship(){
		
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
	public List<RelationUser> getRelationUser() {
		return RelationUser;
	}
	public void setRelationUser(List<RelationUser> relationUser) {
		RelationUser = relationUser;
	}
	
	
}
