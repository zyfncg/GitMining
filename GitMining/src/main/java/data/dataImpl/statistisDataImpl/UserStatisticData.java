package data.dataImpl.statistisDataImpl;

import java.util.List;

import Info.UserInfoDetail;
import Info.Relation.AllUsrRelation;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import data.dataImpl.FileUtil;
import data.dataServer.statisticServer.UserStatisticsDataServer;

public class UserStatisticData implements UserStatisticsDataServer{

	@Override
	public List<UserInfoDetail> getStatisticUsersInfo() throws Exception{

		FileUtil fileUtil=new FileUtil();
//		DBUtil fileUtil=new DBUtil();
		List<UserInfoDetail> userList = null;
		
		try {
			userList=fileUtil.getUserDetailList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return userList;
	}

	@Override
	public boolean setStatisticInfo(SaveUserStatisticInfo saveUser) {

		StatisticFile statisticFile=new StatisticFile();
		return statisticFile.saveUserStatisticData(saveUser);
	}

	@Override
	public SaveUserStatisticInfo GetStatisticedInfo()throws Exception{

		StatisticFile statisticFile=new StatisticFile();
		SaveUserStatisticInfo userStatisticInfo;

		try {
			userStatisticInfo=statisticFile.getUserStatisticData();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userStatisticInfo;
	}

	@Override
	public boolean SaveAllRelation(List<AllUsrRelation> Result) {
		StatisticFile statisticFile=new StatisticFile();
		return statisticFile.saveUserRelation(Result);
	}

	@Override
	public List<AllUsrRelation> getAllRelation() {
		StatisticFile statisticFile=new StatisticFile();
		List<AllUsrRelation> relation;

		try {
			relation=statisticFile.getUserRelation();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return relation;
	}

}
