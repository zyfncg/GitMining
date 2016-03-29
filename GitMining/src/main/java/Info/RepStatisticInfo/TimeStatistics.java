package Info.RepStatisticInfo;

import java.io.Serializable;

public class TimeStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4903074375700194204L;

	private String year;
	
	private int num;
	
	public TimeStatistics(String Year,int Num){
		this.year = Year;
		this.num = Num;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
