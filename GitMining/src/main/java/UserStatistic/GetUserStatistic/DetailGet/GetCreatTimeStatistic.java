package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.CreatTimeStatistics;

public class GetCreatTimeStatistic {

	public List<CreatTimeStatistics> getCreatTimeStatistic() {
		UsrPartStatistic partStatistic = new UsrPartStatistic();
		return partStatistic.getCreatTime();
	}
}
