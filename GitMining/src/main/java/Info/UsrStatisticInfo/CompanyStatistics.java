package Info.UsrStatisticInfo;

public class CompanyStatistics {

	private String company;
	
	private int num;
	
	public CompanyStatistics(String Company,int Num){
		this.company = Company;
		this.num = Num;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
