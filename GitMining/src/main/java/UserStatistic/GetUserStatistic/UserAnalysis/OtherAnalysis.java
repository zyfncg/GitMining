package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.List;

import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfSuccess;

public class OtherAnalysis {
//	private AllUserStatistic allUserStatistic = new AllUserStatistic();
	private IfSuccess ToGetSucc = new IfSuccess();
	private List<UserInfoDetail> allUserDetail = StaticAllUserDetail.AllUserDetailInfo;
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
	//判断在UserInfoDetail的List中是否包含某一个UserInfoDetail
	public boolean IfContained(List<UserInfoDetail> aList,UserInfoDetail anDetail) {
		for(UserInfoDetail tempUser:aList){
			if (tempUser.getUserName().equals(anDetail.getUserName()) && (tempUser.getDescriptionUser().equals(anDetail.getDescriptionUser()))) {
				return true;
			}
		}
		return false;
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
	public int PowerNum(UserInfoDetail AnUSer) {
		int power = 0;
		List<ProjectDetail> allProject = ToGetSucc.GetAllSuccess();
		for(ProjectDetail temp:allProject){
			for(UserInfo tempUser:temp.getContributorsInfo()){
				if(this.IfEqualDetail(tempUser, AnUSer)){
					power++;
					break;
				}
			}
		}
		
		return power;
	}
	
}
