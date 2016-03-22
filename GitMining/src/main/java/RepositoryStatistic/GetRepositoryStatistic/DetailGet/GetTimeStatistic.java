package RepositoryStatistic.GetRepositoryStatistic.DetailGet;

import java.util.List;

import Info.RepStatisticInfo.TimeStatistics;

public class GetTimeStatistic {

	public List<TimeStatistics> getTimeStatistic(){
		RepPartStatistics part = new RepPartStatistics();
		
		return part.getTime();
	}
}
