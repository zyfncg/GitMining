package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.CreatRepositoryStatistics;

public class GetCreatRepositoryStatistic {

	public List<CreatRepositoryStatistics> getCreatRepositoryStatistic() {
		UsrPartStatistic partStatistic = new UsrPartStatistic();
		return partStatistic.getCreatRepository();
	}
}
