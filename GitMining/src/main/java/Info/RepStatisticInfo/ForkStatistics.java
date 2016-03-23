package Info.RepStatisticInfo;

public class ForkStatistics {

	private String Fork;
	
	private double nums;
	
	public ForkStatistics(String fork,double num){
		this.Fork = fork;
		this.nums = num;
	}

	public String getFork() {
		return Fork;
	}

	public void setFork(String fork) {
		Fork = fork;
	}

	public double getNums() {
		return nums;
	}

	public void setNums(double nums) {
		this.nums = nums;
	}
	
	
}
