package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;

public class SetJoinRepositoryStatistic {

	public List<JoinRepositoryStatistics> makeJoinRepositoryStatistic(List<UserInfoDetail> userInfoDetails) {
		List<JoinRepositoryStatistics> allJoinRepositoryResult = new ArrayList<JoinRepositoryStatistics>();

		// 统计全部数据所涉及的年份
		int StartYear = userInfoDetails.get(0).getJoinDate().getYear();
		int EndYear = userInfoDetails.get(0).getJoinDate().getYear();

		for (UserInfoDetail anUser : userInfoDetails) {
			if (anUser.getJoinDate().getYear() < StartYear) {
				StartYear = anUser.getJoinDate().getYear();
			} else if (anUser.getJoinDate().getYear() > EndYear) {
				EndYear = anUser.getJoinDate().getYear();
			}
		}

		// 对每一年的创建项目做统计
		for (int i = StartYear; i <= EndYear; i++) {
			int JoinRepositoryNumber = 0;
			for (UserInfoDetail tempUser : userInfoDetails) {
				if (tempUser.getJoinDate().getYear() == i) {
					JoinRepositoryNumber = JoinRepositoryNumber + tempUser.getProjectInvolved();
				}
			}
			JoinRepositoryStatistics joinRepositoryStatistic = new JoinRepositoryStatistics(i + "年",
					JoinRepositoryNumber);
			allJoinRepositoryResult.add(joinRepositoryStatistic);
		}

		return allJoinRepositoryResult;
	}
}
