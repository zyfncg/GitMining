package Info.RepStatisticInfo;

public class TimeStatistics {

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
