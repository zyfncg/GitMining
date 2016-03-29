package RepositoryStatistic.GetRepositoryStatistic.DetailGet;

import java.util.List;

import Info.RepStatisticInfo.ContributorStatistics;
import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import Info.RepStatisticInfo.StarStatistics;
import Info.RepStatisticInfo.TimeStatistics;
import data.statisticServer.RepositoryStatisticsDataServer;
import data.statistisDataImpl.ProjectStatisticData;

public class RepPartStatistics {
	
	private RepositoryStatisticsDataServer  StatisticServer= new ProjectStatisticData();

	public List<TimeStatistics> getTime(){
		SaveRepositoryStatisticInfo SaveTime = this.getsaveRepositoryStatistic();

		return SaveTime.getTheTime();
	}
	
	public List<ContributorStatistics> getContributor(){
		SaveRepositoryStatisticInfo SaveContributor = this.getsaveRepositoryStatistic();
		
		return SaveContributor.getTheContributor();
	}
	
	public List<StarStatistics> getStar(){
		SaveRepositoryStatisticInfo SaveStar = this.getsaveRepositoryStatistic();
		
		return SaveStar.getTheStar();
	}
	
	public List<ForkStatistics> getFork(){
		SaveRepositoryStatisticInfo SaveFork = this.getsaveRepositoryStatistic();
		
		return SaveFork.getTheFork();
	}
	
	public List<LanguageStatistics> getLanguage(){
		SaveRepositoryStatisticInfo SaveLanguage = this.getsaveRepositoryStatistic();
		
		return SaveLanguage.getTheLanguage();
	}
	
	private SaveRepositoryStatisticInfo getsaveRepositoryStatistic(){
		SaveRepositoryStatisticInfo Save1 = null;
		try {
			Save1 = StatisticServer.GetStatisticedInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Save1;
	}
}
