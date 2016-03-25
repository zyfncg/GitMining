package UserStatistic.SetUserStatistic;

import UserStatistic.SetUserStatistic.DetailAnalyze.SetCatalogStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCompanyStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCreatRepositoryStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCreatTimeStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetJoinRepositoryStatistic;

public class UsrStatisticsFactory {

	public SetCatalogStatistic getCatalogObject(){
		return new SetCatalogStatistic();
	}
	
	public SetCompanyStatistic getCompanyObject() {
		return new SetCompanyStatistic();
	}
	
	public SetCreatRepositoryStatistic getCreatRepositoryObject() {
		return new SetCreatRepositoryStatistic();
	}
	
	public SetCreatTimeStatistic getCreatTimrObject() {
		return new SetCreatTimeStatistic();
	}
	
	public SetJoinRepositoryStatistic getJoinRepositoryObject() {
		return new SetJoinRepositoryStatistic();
	}
}
