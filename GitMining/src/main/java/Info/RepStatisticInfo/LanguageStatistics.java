package Info.RepStatisticInfo;

public class LanguageStatistics {

	private String Language;
	
	private int num;
	
	private double pareto;
	
	public LanguageStatistics(String languages,int nums,Double paretos){
		this.Language = languages;
		this.num = nums;
		this.pareto = paretos;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPareto() {
		return pareto;
	}

	public void setPareto(double pareto) {
		this.pareto = pareto;
	}
	
}
