package Info.UsrStatisticInfo;

import java.io.Serializable;

public class CompanyStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1471228838104393198L;

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
