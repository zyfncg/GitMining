package Info;

public class HistogramInfo {

	private int MaxNum;
	
	private int MinNum;
	
	private int GroupNum;
	
	private double[] allNum;
	
	public HistogramInfo(int maxnum,int minnum,int groupnum,double[] num){
		this.MaxNum = maxnum;
		this.MinNum = minnum;
		this.GroupNum = groupnum;
		this.allNum = num;
	}

	public int getMaxNum() {
		return MaxNum;
	}

	public void setMaxNum(int maxNum) {
		MaxNum = maxNum;
	}

	public int getMinNum() {
		return MinNum;
	}

	public void setMinNum(int minNum) {
		MinNum = minNum;
	}

	public int getGroupNum() {
		return GroupNum;
	}

	public void setGroupNum(int groupNum) {
		GroupNum = groupNum;
	}

	public double[] getAllNum() {
		return allNum;
	}

	public void setAllNum(double[] allNum) {
		this.allNum = allNum;
	}
	
}
