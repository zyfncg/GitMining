package UserStatistic.SetUserStatistic;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CatalogStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCatalogStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCompanyStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCreatRepositoryStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetCreatTimeStatistic;
import UserStatistic.SetUserStatistic.DetailAnalyze.SetJoinRepositoryStatistic;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class AllUserStatistic {

	private UserStatisticsDataServer userStatisticsDataServer = new UserStatisticData();
	private UsrStatisticsFactory UserFactory = new UsrStatisticsFactory();

	public void UserAnalyze() {
		// 取得全部用户的详细信息的List
		List<UserInfoDetail> allList = this.getStatisticUserInfo();

		// 进行用户类型统计
		SetCatalogStatistic catalogStatistic = UserFactory.getCatalogObject();
		List<CatalogStatistics> CatalogResult = catalogStatistic.makeCatalogStatistic(allList);
		// 进行用户所属公司统计
		SetCompanyStatistic companyStatistic = UserFactory.getCompanyObject();
		List<CompanyStatistics> CompanyResult = companyStatistic.makeCompanyStatistic(allList);
		// 进行用户创建项目统计
		SetCreatRepositoryStatistic creatRepositoryStatistic = UserFactory.getCreatRepositoryObject();
		List<CreatRepositoryStatistics> CreatRepositoryResult = creatRepositoryStatistic
				.makeCreatRepositoryStatistic(allList);
		// 进行用户创建时间统计
		SetCreatTimeStatistic creatTimeStatistic = UserFactory.getCreatTimrObject();
		List<CreatTimeStatistics> CreatTimeResult = creatTimeStatistic.makeCreatTimeStatistic(allList);
		// 进行用户参与项目统计
		SetJoinRepositoryStatistic joinRepositoryStatistic = UserFactory.getJoinRepositoryObject();
		List<JoinRepositoryStatistics> JoinRepositoryResult = joinRepositoryStatistic
				.makeJoinRepositoryStatistic(allList);

		//创建保存到Txt中的对象
		SaveUserStatisticInfo saveUserStatisticInfo = new SaveUserStatisticInfo(CatalogResult, CompanyResult,
				CreatRepositoryResult, CreatTimeResult, JoinRepositoryResult);
		
		//进行保存
		boolean SaveResult = userStatisticsDataServer.setStatisticInfo(saveUserStatisticInfo);
		if (!SaveResult) {
			userStatisticsDataServer.setStatisticInfo(saveUserStatisticInfo);
		}
		else{
			System.out.println("Usersuccess");
		}

	}

	public List<UserInfoDetail> getStatisticUserInfo() {
		List<UserInfoDetail> temp = new ArrayList<UserInfoDetail>();
		try {
			temp = userStatisticsDataServer.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;

	}
}
