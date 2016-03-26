package RepositoryStatistic.GetRepositoryStatistic.DetailGet;

import java.util.List;

import Info.RepStatisticInfo.StarStatistics;

public class GetStarStatistic {

	public List<StarStatistics> getStarStatistic(){
		RepPartStatistics part = new RepPartStatistics();
		
		return part.getStar();
	}
}
