package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class OtherAnalysis {
	private AllUserStatistic allUserStatistic = new AllUserStatistic();
	private List<UserInfoDetail> allUserDetail = allUserStatistic.getStatisticUserInfo();
	//判断两个UserInfo是否一致
	public boolean IfUserEqual(UserInfo Auser,UserInfo Buser) {
		if ( (Auser.getUserName().equals(Buser.getUserName())) && (Auser.getDescriptionUser().equals(Buser.getDescriptionUser())) ) {
			return true;
		}
		else {
			return false;
		}
	}
	//判断UserInfo鱼UserInfoDetail是否一致
	public boolean IfEqualDetail(UserInfo Auser,UserInfoDetail Buser) {
		if ( (Auser.getUserName().equals(Buser.getUserName())) && (Auser.getDescriptionUser().equals(Buser.getDescriptionUser())) ) {
			return true;
		}
		else {
			return false;
		}
	}
	//将UserInfo变为UserInfoDetail
	public UserInfoDetail BecomeDetail(UserInfo tempUser) {
		for(UserInfoDetail temp:allUserDetail){
			if (this.IfEqualDetail(tempUser, temp)) {
				return temp;
			}
		}
		return null;
	}
	//用户的个人能力值
	public int PowerNum() {
		
		return 0;
	}
}
