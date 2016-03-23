package Info.UsrStatisticInfo;

public class CatalogStatistics {

	private String Catalog;
	
	private double num;
	
	public CatalogStatistics(String Cata,double nums){
		this.Catalog = Cata;
		this.num = nums;
	}

	public String getCatalog() {
		return Catalog;
	}

	public void setCatalog(String catalog) {
		Catalog = catalog;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
}
