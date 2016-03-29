package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CreatTimeStatistics;

public class SetCreatTimeStatistic {

	public List<CreatTimeStatistics> makeCreatTimeStatistic(List<UserInfoDetail> userInfoDetails) {
		List<CreatTimeStatistics> allCreatTimeResult = new ArrayList<CreatTimeStatistics>();

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

		// 对每一年的创建项数量做统计
		for (int i = StartYear; i <= EndYear; i++) {
			int CreatTimeNumber = 0;
			for (UserInfoDetail tempUser : userInfoDetails) {
				if (tempUser.getJoinDate().getYear() == i) {
					CreatTimeNumber++;
				}
			}
			CreatTimeStatistics creatTimeStatistic = new CreatTimeStatistics(i + "年",
					CreatTimeNumber);
			allCreatTimeResult.add(creatTimeStatistic);
		}

		return allCreatTimeResult;
	}
}
