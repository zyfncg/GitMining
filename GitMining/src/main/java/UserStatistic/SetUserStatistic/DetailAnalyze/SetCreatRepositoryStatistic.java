package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;

public class SetCreatRepositoryStatistic {

	public List<CreatRepositoryStatistics> makeCreatRepositoryStatistic(List<UserInfoDetail> userInfoDetails) {
		List<CreatRepositoryStatistics> allCreatRepositoryResult = new ArrayList<CreatRepositoryStatistics>();
		
		//统计全部数据所涉及的年份
		int StartYear = userInfoDetails.get(0).getJoinDate().getYear();
		int EndYear = userInfoDetails.get(0).getJoinDate().getYear();
		
		for(UserInfoDetail anUser : userInfoDetails){
			if (anUser.getJoinDate().getYear()<StartYear) {
				StartYear = anUser.getJoinDate().getYear();
			}
			else if(anUser.getJoinDate().getYear()>EndYear){
				EndYear = anUser.getJoinDate().getYear();
			}
		}
		
		//对每一年的创建项目做统计
		for(int i=StartYear;i<=EndYear;i++){
			int CreatRepositoryNumber=0;
			for(UserInfoDetail tempUser : userInfoDetails){
				if (tempUser.getJoinDate().getYear() == i) {
					CreatRepositoryNumber = CreatRepositoryNumber+tempUser.getProjectCreate();
				}
			}
			CreatRepositoryStatistics creatRepositoryStatistic = new CreatRepositoryStatistics(i+"年", CreatRepositoryNumber);
			allCreatRepositoryResult.add(creatRepositoryStatistic);
		}
		
		
		return allCreatRepositoryResult;
	}
}
