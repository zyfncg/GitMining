package UserStatistic.GetUserStatistic.DetailGet;

import java.util.List;

import Info.UsrStatisticInfo.CatalogStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class UsrPartStatistic {

	private UserStatisticsDataServer statisticsDataServer = new UserStatisticData();
	
	public List<CatalogStatistics> getCatalog(){
		SaveUserStatisticInfo SaveCatalog = this.getsaveUserStatisticInfo();
		return SaveCatalog.getTheCatalog();
	}
	
	public List<CompanyStatistics> getCompany(){
		SaveUserStatisticInfo SaveCompany = this.getsaveUserStatisticInfo();
		return SaveCompany.getTheCompany();
	}
	
	public List<CreatRepositoryStatistics> getCreatRepository() {
		SaveUserStatisticInfo SaveCreatREpositoryStatistic = this.getsaveUserStatisticInfo();
		return SaveCreatREpositoryStatistic.getTheCreatRepository();
	}
	
	public List<CreatTimeStatistics> getCreatTime() {
		SaveUserStatisticInfo SaveCreatTime = this.getsaveUserStatisticInfo();
		return SaveCreatTime.getTheCreatTime();
	}
	
	public List<JoinRepositoryStatistics> getJoinRepository() {
		SaveUserStatisticInfo SaveJoinRepository = this.getsaveUserStatisticInfo();
		return SaveJoinRepository.getTheJoinRepository();
	}
	
	public SaveUserStatisticInfo getsaveUserStatisticInfo() {
		SaveUserStatisticInfo Save1 = null;
		try {
			Save1 = statisticsDataServer.GetStatisticedInfo();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Save1;
	}
}
