package Info;

public class RelationUser {
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 对用户的简要描述
	 */
	private String descriptionUser;
	/**
	 * 地址名称
	 */
	private String site;
	/**
	 * 经度
	 */
	private double longtitude;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 该用户能力值
	 */
	private int Power;
	
	public RelationUser(String name,String des,String Site,double Longti,double lat, int power){
		this.userName = name;
		this.descriptionUser = des;
		this.site = Site;
		this.longtitude = Longti;
		this.latitude = lat;
		this.Power = power;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
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

	public int getPower() {
		return Power;
	}

	public void setPower(int power) {
		Power = power;
	}

}
