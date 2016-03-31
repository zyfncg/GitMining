package Info.RepStatisticInfo;

import java.io.Serializable;

public class ForkStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1086352120425575063L;

	private String Fork;
	
	private int nums;
	
	public ForkStatistics(String fork,int num){
		this.Fork = fork;
		this.nums = num;
	}

	public String getFork() {
		return Fork;
	}

	public void setFork(String fork) {
		Fork = fork;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}
	
	
}
