package Info;

import java.io.Serializable;

public class Date implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3812736314846797981L;

	private int year;
	
	private int month;
	
	private int day;
	
	private static String seperator = "-";
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate() {
		return year + seperator + month + seperator + day;
	}
	
	public static Date stringToDate(String dateString){
		dateString=dateString.substring(0,10);
		String time[]=dateString.split(seperator);
		int toYear=Integer.parseInt(time[0]);
		int toMonth=Integer.parseInt(time[1]);
		int toDay=Integer.parseInt(time[2]);
		
		return new Date(toYear,toMonth,toDay);
	}
}
