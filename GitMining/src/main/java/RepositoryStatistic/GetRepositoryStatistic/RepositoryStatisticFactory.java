package RepositoryStatistic.GetRepositoryStatistic;

import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetContributorStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetForkStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetLanguageStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetStarStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetTimeStatistic;

public class RepositoryStatisticFactory {
	
	public GetContributorStatistic GetContributor(){
		return new GetContributorStatistic();
	}
	
	public GetForkStatistic GetFork(){
		return new GetForkStatistic();
	}
	
	public GetLanguageStatistic GetLanguage() {
		return new GetLanguageStatistic();
	}
	
	public GetStarStatistic GetStar(){
		return new GetStarStatistic();
	}
	
	public GetTimeStatistic GetTime() {
		return new GetTimeStatistic();
	}
}
