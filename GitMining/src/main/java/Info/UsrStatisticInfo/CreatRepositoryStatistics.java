package Info.UsrStatisticInfo;

public class CreatRepositoryStatistics {

	private String Year;
	
	private int num;
	
	public CreatRepositoryStatistics(String year,int Num){
		this.Year = year;
		this.num = Num;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
