package Info;

public class Date {
	
	private int year;
	
	private int month;
	
	private int day;
	
	private String seperator = "/";
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate() {
		return year + seperator + month + seperator + day;
	}
}
