package Info.Relation;

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
	 * 经度
	 */
	private double longtitude;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 相关用户姓名
	 */
	private List<RelationUser> relationUsers;
	
	public Relationship(String name, String Des, List<RelationUser> relation){
		this.userName = name;
		this.descriptionUser = Des;
		this.relationUsers = relation;
	}
	public Relationship(){
		
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public List<RelationUser> getRelationUsers() {
		return relationUsers;
	}
	public void setRelationUsers(List<RelationUser> relationUsers) {
		this.relationUsers = relationUsers;
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
	
	
}
