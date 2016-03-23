package Info.RepStatisticInfo;

public class StarStatistics {

	private String Star;
	
	private double nums;
	
	public StarStatistics(String star,double num){
		this.Star = star;
		this.nums = num;
	}

	public String getStar() {
		return Star;
	}

	public void setStar(String star) {
		Star = star;
	}

	public double getNums() {
		return nums;
	}

	public void setNums(double nums) {
		this.nums = nums;
	}
	
}
