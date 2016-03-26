package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CompanyStatistics;

public class SetCompanyStatistic {

	public List<CompanyStatistics> makeCompanyStatistic(List<UserInfoDetail> userInfoDetails) {
		List<CompanyStatistics> allCompanyResult = new ArrayList<CompanyStatistics>();

		// 统计用户的全部公司种类
		List<String> allCompany = new ArrayList<String>();
		for (UserInfoDetail tempUserInfo : userInfoDetails) {
			if (!allCompany.contains(tempUserInfo.getCompany())) {
				allCompany.add(tempUserInfo.getCompany());
			}
		}
		
		//对用户所属公司进行统计
		for(int i=0;i<allCompany.size();i++){
			int CompantNumber =0;
			for(UserInfoDetail tempUserInfo : userInfoDetails){
				if ((tempUserInfo.getCompany()).equals(allCompany.get(i))) {
					CompantNumber++;
				}
			}
			
			CompanyStatistics companyStatisticsResult = new CompanyStatistics(allCompany.get(i), CompantNumber);
			allCompanyResult.add(companyStatisticsResult);
		}

		return allCompanyResult;
	}
}
