package data.statistisDataImpl;

import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import data.dataImpl.FileUtil;
import data.statisticServer.UserStatisticsDataServer;

public class UserStatisticData implements UserStatisticsDataServer{

	@Override
	public List<UserInfoDetail> getStatisticUsersInfo() throws Exception{

		FileUtil fileUtil=new FileUtil();
		List<UserInfoDetail> userList = null;
		
		try {
			userList=fileUtil.getUserDetailFromFile();
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

}
