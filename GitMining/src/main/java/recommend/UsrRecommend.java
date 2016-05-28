package recommend;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;
import UserStatistic.GetUserStatistic.UserAnalysis.OtherAnalysis;

public class UsrRecommend {

	private RecUtil Autil = new RecUtil();
	private OtherAnalysis other = new OtherAnalysis();
	
	public UserInfoDetail getMostRelat(List<ProjectInfo> relatePro) {
		UserInfo resultOne = null;
		int resultNum = 0;
		
//		List<UserInfo> tempA = new ArrayList<UserInfo>();
//		List<UserInfo> tempB = new ArrayList<UserInfo>();
		
		for(ProjectInfo ProInfo:relatePro){
			ProjectDetail projectDetail = Autil.ToProDetail(ProInfo);
//			tempA = projectDetail.getCollaboratorsInfo();
			for(UserInfo UsrInfo:projectDetail.getCollaboratorsInfo()){
				int i = this.SortNum(UsrInfo, relatePro);
				if (i>resultNum) {
					resultNum = i;
					resultOne = UsrInfo;
				}
			}
			
		}
		UserInfoDetail detail = other.BecomeDetail(resultOne);
		
		return detail;
	}
	

	//某一个UserInfo在相关项目中重复的次数
	public int SortNum(UserInfo Auser,List<ProjectInfo> relation) {
		int Num = 0;
		for(ProjectInfo ProInfo:relation){
			ProjectDetail temp = Autil.ToProDetail(ProInfo);
			for(UserInfo tempUser:temp.getCollaboratorsInfo()){
				if (Autil.IfSameUser(Auser, tempUser)) {
					Num++;
				}
			}
		}
		
		return Num;
	}
}
