package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.CompanyStatistics;

public class GetCompanyStatistic {

	public List<CompanyStatistics> getCompanyStatistic() {
		UsrPartStatistic partStatistic = new UsrPartStatistic();
		return partStatistic.getCompany();
	}
}
