package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.CatalogStatistics;

public class GetCatalogStatistic {

	public List<CatalogStatistics> getCatalogStatistic(){
		UsrPartStatistic partStatistic = new UsrPartStatistic();
		return partStatistic.getCatalog();
	}
}
