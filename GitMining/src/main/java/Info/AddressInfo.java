package Info;

public class AddressInfo {
	/**
	 * 地点名称
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
	 * 程序员人数
	 */
	private int workerNumber;

	public AddressInfo(String site, double longtitude, double latitude, int workerNumber) {
		super();
		this.site = site;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.workerNumber = workerNumber;
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

	public int getWorkerNumber() {
		return workerNumber;
	}

	public void setWorkerNumber(int workerNumber) {
		this.workerNumber = workerNumber;
	}
}
