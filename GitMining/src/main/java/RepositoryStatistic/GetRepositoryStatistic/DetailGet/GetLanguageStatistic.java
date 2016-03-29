package RepositoryStatistic.GetRepositoryStatistic.DetailGet;

import java.util.List;

import Info.RepStatisticInfo.LanguageStatistics;

public class GetLanguageStatistic {

	public List<LanguageStatistics> getLanguageStatistic(){
		RepPartStatistics part = new RepPartStatistics();
		
		return part.getLanguage();
	}
}
