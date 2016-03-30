package UserStatistic.GetUserStatistic;

import UserStatistic.GetUserStatistic.DetailGet.GetCatalogStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCompanyStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatRepositoryStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatTimeStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetJoinRepositoryStatistic;

public class UserStatisticFactory {

	public GetCatalogStatistic GetCatalog(){
		return new GetCatalogStatistic();
	}
	public GetCompanyStatistic GetCompany(){
		return new GetCompanyStatistic();
	}
	public GetCreatRepositoryStatistic GetCreatRepository(){
		return new GetCreatRepositoryStatistic();
	}
	public GetJoinRepositoryStatistic GetJoinRepository(){
		return new GetJoinRepositoryStatistic();
	}
	public GetCreatTimeStatistic GetCreatTime(){
		return new GetCreatTimeStatistic();
	}
}
