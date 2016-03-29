package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		//排序
		Collections.sort(allCompanyResult,new Comparator<CompanyStatistics>() {
			@Override
			public int compare(CompanyStatistics arg0, CompanyStatistics arg1){
				return (new Integer(arg1.getNum())).compareTo(new Integer(arg0.getNum()));
			}
		});
		
		
		//其余小公司数据统计
		int otherCompanyNum = 0;
		for(int i=19;i<allCompanyResult.size();i++){
			otherCompanyNum = otherCompanyNum + allCompanyResult.get(i).getNum();
		}
		
		for(int allSize = (allCompanyResult.size()-1);allSize>19;allSize--){
			allCompanyResult.remove(allSize);
		}
		allCompanyResult.add(new CompanyStatistics("other", otherCompanyNum));
		
		return allCompanyResult;
	}
}
