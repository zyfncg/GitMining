package Info.UsrStatisticInfo;

import java.io.Serializable;
import java.util.List;

public class SaveUserStatisticInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3213619873365568092L;

	private List<CatalogStatistics> theCatalog;

	private List<CompanyStatistics> theCompany;

	private List<CreatRepositoryStatistics> theCreatRepository;

	private List<CreatTimeStatistics> theCreatTime;

	private List<JoinRepositoryStatistics> theJoinRepository;

	public SaveUserStatisticInfo(List<CatalogStatistics> Catalog, List<CompanyStatistics> Company,
			List<CreatRepositoryStatistics> CreatRepository, List<CreatTimeStatistics> CreatTime,
			List<JoinRepositoryStatistics> JoinRepository) {
		this.theCatalog = Catalog;
		this.theCompany = Company;
		this.theCreatRepository = CreatRepository;
		this.theCreatTime = CreatTime;
		this.theJoinRepository = JoinRepository;

	}

	public List<CatalogStatistics> getTheCatalog() {
		return theCatalog;
	}

	public void setTheCatalog(List<CatalogStatistics> theCatalog) {
		this.theCatalog = theCatalog;
	}

	public List<CompanyStatistics> getTheCompany() {
		return theCompany;
	}

	public void setTheCompany(List<CompanyStatistics> theCompany) {
		this.theCompany = theCompany;
	}

	public List<CreatRepositoryStatistics> getTheCreatRepository() {
		return theCreatRepository;
	}

	public void setTheCreatRepository(List<CreatRepositoryStatistics> theCreatRepository) {
		this.theCreatRepository = theCreatRepository;
	}

	public List<CreatTimeStatistics> getTheCreatTime() {
		return theCreatTime;
	}

	public void setTheCreatTime(List<CreatTimeStatistics> theCreatTime) {
		this.theCreatTime = theCreatTime;
	}

	public List<JoinRepositoryStatistics> getTheJoinRepository() {
		return theJoinRepository;
	}

	public void setTheJoinRepository(List<JoinRepositoryStatistics> theJoinRepository) {
		this.theJoinRepository = theJoinRepository;
	}

}
