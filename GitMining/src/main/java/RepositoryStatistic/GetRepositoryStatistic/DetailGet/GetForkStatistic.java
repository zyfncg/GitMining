package RepositoryStatistic.GetRepositoryStatistic.DetailGet;

import java.util.List;

import Info.RepStatisticInfo.ForkStatistics;

public class GetForkStatistic {

	public List<ForkStatistics> getForkStatistic(){
		RepPartStatistics part = new RepPartStatistics();
		
		return part.getFork();
	}
}
