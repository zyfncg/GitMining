package Info.UsrStatisticInfo;

import java.io.Serializable;

public class CreatTimeStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8453611165714024761L;

	private String time;
	
	private int num;
	
	public CreatTimeStatistics(String Time,int Num){
		this.time = Time;
		this.num = Num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
