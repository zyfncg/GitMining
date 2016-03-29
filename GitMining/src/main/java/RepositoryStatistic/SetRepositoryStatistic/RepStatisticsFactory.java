package RepositoryStatistic.SetRepositoryStatistic;

import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetContributorStatistic;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetForkStatistic;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetLanguageStatistic;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetStarStatisitc;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetTimeStatistic;

public class RepStatisticsFactory {

	public SetContributorStatistic getContributorObject(){
		return new SetContributorStatistic();
	}
	
	public SetForkStatistic getForkObject() {
		return new SetForkStatistic();
	}
	
	public SetLanguageStatistic getLanguageObject() {
		return new SetLanguageStatistic();
	}
	
	public SetStarStatisitc getStarObject() {
		return new SetStarStatisitc();
	}
	
	public SetTimeStatistic getTimeObject() {
		return new SetTimeStatistic();
	}
}
