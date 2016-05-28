package Recommend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.RecommendUser;
import Info.UserInfo;
import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfSuccess;
import UserStatistic.GetUserStatistic.UserAnalysis.OtherAnalysis;
import data.dataImpl.statistisDataImpl.UserStatisticData;
import data.dataServer.statisticServer.UserStatisticsDataServer;

public class UsrRecommend {

	private RecUtil Autil = new RecUtil();
	private OtherAnalysis other = new OtherAnalysis();
	private IfSuccess ifSuccess = new IfSuccess();
	private UserStatisticsDataServer userStatisticsDataServer = new UserStatisticData();
	
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
	
	public UserInfoDetail GetTop(int num) {
		List<UserInfoDetail> tempDetailUser = new ArrayList<UserInfoDetail>();
		try {
			tempDetailUser = userStatisticsDataServer.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<RecommendUser> AllRecommend = new ArrayList<RecommendUser>();
		
		for(UserInfoDetail userDetail:tempDetailUser){
			int succnum = ifSuccess.CalSuccNum(userDetail);
			RecommendUser tempRec = new RecommendUser(userDetail, succnum);
			AllRecommend.add(tempRec);
		}
		
		//排序
		Collections.sort(AllRecommend, new Comparator<RecommendUser>() {
			@Override
			public int compare(RecommendUser arg0, RecommendUser arg1) {
				return (new Integer(arg1.getSuccessNum())).compareTo(new Integer(arg0.getSuccessNum()));
			}
		});
		
		return AllRecommend.get(num).getUserInfoDetail();
	}
}
