package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.AddressInfo;
import Info.ProjectDetail;
import Info.UserInfoDetail;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;

public class Else {
	// private IfSuccess success = new IfSuccess();
	// private IfBigCow bigCow = new IfBigCow();
	// private List<ProjectDetail> temp = success.GetAllSuccess();

//	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = StaticAllProjectDetail.AllProjectDetailInfo;

//	public Else(){
//		if (AllProject == null) {
//			StaticAllProjectDetail staticAllProjectDetail = new StaticAllProjectDetail();
//			AllProject = staticAllProjectDetail.AllProjectDetailInfo;
//		}
//	}
	//取得分析相关的语言种类
	public List<String> GetLanguage() {
		List<LanguageStatistics> Sortlanguage = new ArrayList<LanguageStatistics>();
		List<String> allLanguage = new ArrayList<String>();
		for (ProjectDetail tempProject : AllProject) {
			if (!allLanguage.contains(tempProject.getLanguage())) {
				allLanguage.add(tempProject.getLanguage());
			}
		}
		// for (ProjectDetail tempProject : AllProject) {
		//
		// }
		// 对各种语言进行统计
		for (int i = 0; i < allLanguage.size(); i++) {
			int projectNumber = 0;
			for (ProjectDetail tempProject2 : AllProject) {
				if ((allLanguage.get(i)).equals(tempProject2.getLanguage())) {
					projectNumber++;
				}
			}
			LanguageStatistics languageStatisticsResult = new LanguageStatistics(allLanguage.get(i), projectNumber,
					0.0);
			Sortlanguage.add(languageStatisticsResult);
		}

		Collections.sort(Sortlanguage, new Comparator<LanguageStatistics>() {
			@Override
			public int compare(LanguageStatistics arg0, LanguageStatistics arg1) {
				return (new Integer(arg1.getNum())).compareTo(new Integer(arg0.getNum()));
			}
		});

		//
		allLanguage.clear();
		List<LanguageStatistics> templanguage = Sortlanguage.subList(0, 9);
		for (LanguageStatistics language : templanguage) {
			allLanguage.add(language.getLanguage());
		}
		return allLanguage;
	}

	//取得分析相关的公司种类
	public List<String> GetCompany(List<UserInfoDetail> allUser) {
		List<CompanyStatistics> SortCompany = new ArrayList<CompanyStatistics>();
		List<String> allCompany = new ArrayList<String>();
		for (UserInfoDetail tempUserInfo : allUser) {
			if (!allCompany.contains(tempUserInfo.getCompany())) {
				allCompany.add(tempUserInfo.getCompany());
			}
		}
		// 因为数据问题；删去unknown这个类型
		allCompany.remove("unknown");
		// 对用户所属公司进行统计
		for (int i = 0; i < allCompany.size(); i++) {
			int CompantNumber = 0;
			for (UserInfoDetail tempUserInfo : allUser) {
				if ((tempUserInfo.getCompany()).equals(allCompany.get(i))) {
					CompantNumber++;
				}
			}

			CompanyStatistics companyStatisticsResult = new CompanyStatistics(allCompany.get(i), CompantNumber);
			SortCompany.add(companyStatisticsResult);
		}

		// 排序
		Collections.sort(SortCompany, new Comparator<CompanyStatistics>() {
			@Override
			public int compare(CompanyStatistics arg0, CompanyStatistics arg1) {
				return (new Integer(arg1.getNum())).compareTo(new Integer(arg0.getNum()));
			}
		});
		
		List<CompanyStatistics> subComp = new ArrayList<CompanyStatistics>();
		subComp.addAll(SortCompany.subList(0, 10));
		allCompany.clear();
		for(CompanyStatistics company:subComp){
			allCompany.add(company.getCompany());
		}
		return allCompany;
	}
	
	
	//处理项目的Contributor分布内容
	//
	public boolean IfContain(List<AddressInfo> allAddress,AddressInfo nowAddress) {
//		boolean ifCon = false;
		boolean IfFound = false;
		for(AddressInfo temp:allAddress){
			if (temp.getSite().equals(nowAddress.getSite())) {
				int a = temp.getWorkerNumber();
				a++;
				temp.setWorkerNumber(a);
				IfFound = true;
			}
		}
		if (!IfFound) {
			allAddress.add(nowAddress);
		}
		return false;
	}
}
