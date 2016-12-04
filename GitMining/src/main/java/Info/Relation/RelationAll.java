package Info.Relation;

import java.util.List;

public class RelationAll {
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	
	
	private List<Relationship> FirstRelation;
	
	public RelationAll(String Name,String Des,List<Relationship> all){
		this.userName = Name;
		this.descriptionUser = Des;
		this.FirstRelation = all;
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

	public List<Relationship> getFirstRelation() {
		return FirstRelation;
	}

	public void setFirstRelation(List<Relationship> firstRelation) {
		FirstRelation = firstRelation;
	}
	
	
	
}
