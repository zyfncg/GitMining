package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.JoinRepositoryStatistics;

public class GetJoinRepositoryStatistic {

	public List<JoinRepositoryStatistics> getJoinRepositoryStatistic() {
		UsrPartStatistic partStatistic = new UsrPartStatistic();
		return partStatistic.getJoinRepository();
	}
}
