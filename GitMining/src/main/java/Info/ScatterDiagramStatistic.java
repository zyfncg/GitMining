package Info;

public class ScatterDiagramStatistic {
	
	private double[][] AllNum;
	//y=Ax+B中的A
	private double ParameterA;
	//y=Ax+B中的B
	private double ParameterB;
	
	public ScatterDiagramStatistic(double parameterA,double parameterB,double[][] allnum){
		this.ParameterA = parameterA;
		this.ParameterB = parameterB;
		this.AllNum =allnum;
	}

	public double[][] getAllNum() {
		return AllNum;
	}

	public void setAllNum(double[][] allNum) {
		AllNum = allNum;
	}

	public double getParameterA() {
		return ParameterA;
	}

	public void setParameterA(double parameterA) {
		ParameterA = parameterA;
	}

	public double getParameterB() {
		return ParameterB;
	}

	public void setParameterB(double parameterB) {
		ParameterB = parameterB;
	}
	
}
