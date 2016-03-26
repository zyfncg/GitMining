package Info.UsrStatisticInfo;

import java.io.Serializable;

public class JoinRepositoryStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2885698751878892137L;

	private String year;
	
	private double num;
	
	public JoinRepositoryStatistics(String Year,double Num){
		this.year = Year;
		this.num = Num;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
}
