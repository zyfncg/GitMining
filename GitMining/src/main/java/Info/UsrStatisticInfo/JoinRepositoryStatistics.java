package Info.UsrStatisticInfo;

public class JoinRepositoryStatistics {

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
