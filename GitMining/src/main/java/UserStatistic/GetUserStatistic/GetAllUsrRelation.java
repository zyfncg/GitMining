package UserStatistic.GetUserStatistic;

import java.util.List;

import Info.Relation.AllUsrRelation;
import data.dataImpl.statistisDataImpl.UserStatisticData;
import data.dataServer.statisticServer.UserStatisticsDataServer;

public class GetAllUsrRelation {
	private UserStatisticsDataServer userStatisticsData = new UserStatisticData();
	public List<AllUsrRelation> getAllUserRelation() {
		List<AllUsrRelation> res = userStatisticsData.getAllRelation();
		while(res==null){
			res = userStatisticsData.getAllRelation();
		}
		return res;
	}
}
