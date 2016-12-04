package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.List;

import Info.UserInfoDetail;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class StaticAllUserDetail {
	public static List<UserInfoDetail> AllUserDetailInfo = null;
	
	static{
		AllUserStatistic allUserStatistic = new AllUserStatistic();
		List<UserInfoDetail> tempUserInfoDetail = allUserStatistic.getStatisticUserInfo();
		StaticAllUserDetail.AllUserDetailInfo = tempUserInfoDetail;
//		System.out.println("static语句快被执行");
	}
}
