package Info.RepStatisticInfo;

import java.io.Serializable;

public class StarStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 485695421264085138L;

	private String Star;
	
	private int nums;
	
	public StarStatistics(String star,int num){
		this.Star = star;
		this.nums = num;
	}

	public String getStar() {
		return Star;
	}

	public void setStar(String star) {
		Star = star;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}
	
}
