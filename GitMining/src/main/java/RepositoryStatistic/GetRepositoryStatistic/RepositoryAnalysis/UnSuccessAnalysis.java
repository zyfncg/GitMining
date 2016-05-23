package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.SuccAnalysisStatic;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfBigCow;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfSuccess;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class UnSuccessAnalysis implements SuccAnalysisStatic{
	private IfSuccess success = new IfSuccess();
	private IfBigCow bigCow = new IfBigCow();
	private List<ProjectDetail> temp = success.GetAllUnSuccess();
	private UserStatisticsDataServer userStatisticsDataServer = new UserStatisticData();
	
	@Override
	public double getProjectNum() {
		// TODO Auto-generated method stub
		return temp.size();
	}

	@Override
	public int[] getCollaNum() {
		// TODO Auto-generated method stub
		int[] allcolla = new int[temp.size()];
		for (int i=0;i<temp.size();i++) {
			allcolla[i] = temp.get(i).getCollaborators();
		}

		return allcolla;
	}

	@Override
	public int getMrBigOccupyNum() {
		// TODO Auto-generated method stub
		List<ProjectDetail> allbigcow = new ArrayList<ProjectDetail>();
		for (ProjectDetail aProject : temp) {
			if (bigCow.IfBigCowMore50(aProject)) {
				allbigcow.add(aProject);
			}
		}
		return allbigcow.size();
	}

	@Override
	public List<LanguageStatistics> getLanguageStat() {
		// TODO Auto-generated method stub
		List<LanguageStatistics> allLanguageResult = new ArrayList<LanguageStatistics>();
		// 形成所有不同语言的一个集合
		DecimalFormat df = new DecimalFormat("######0.00");
		List<String> allLanguage = new ArrayList<String>();
		for (ProjectDetail tempProject : temp) {
			if (!allLanguage.contains(tempProject.getLanguage())) {
				allLanguage.add(tempProject.getLanguage());
			}
		}

		// 对各种语言进行统计
		for (int i = 0; i < allLanguage.size(); i++) {
			int projectNumber = 0;
			for (ProjectDetail tempProject2 : temp) {
				if ((allLanguage.get(i)).equals(tempProject2.getLanguage())) {
					projectNumber++;
				}
			}
			double Projectnumber = Double.parseDouble(df.format(((double) projectNumber) / ((double) (temp.size()))));
			LanguageStatistics languageStatisticsResult = new LanguageStatistics(allLanguage.get(i), projectNumber,
					Projectnumber);
			allLanguageResult.add(languageStatisticsResult);
		}

		return allLanguageResult;
	}

	@Override
	public List<CompanyStatistics> getCompanyStat() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<UserInfoDetail> tempDetailUser = new ArrayList<UserInfoDetail>();
		List<CompanyStatistics> statistics = new ArrayList<CompanyStatistics>();
		// List<UserInfoDetail> EndDetailUser = new ArrayList<UserInfoDetail>();
		try {
			tempDetailUser = userStatisticsDataServer.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 统计用户的全部公司种类
		HashMap<String, Integer> CompanyResult = new HashMap<>();
		List<String> allCompany = new ArrayList<String>();
		for (UserInfoDetail tempUserInfo : tempDetailUser) {
			if (!allCompany.contains(tempUserInfo.getCompany())) {
				allCompany.add(tempUserInfo.getCompany());
				CompanyResult.put(tempUserInfo.getCompany(), 0);
			}
		}

		for (ProjectDetail tempProject : temp) {
			for (UserInfo tempUser : (tempProject.getCollaboratorsInfo())) {
				for (UserInfoDetail UserDetail : tempDetailUser) {
					if (this.ifEqual(tempUser, UserDetail)) {
						int num = CompanyResult.get(UserDetail.getCompany());
						num++;
						CompanyResult.put(UserDetail.getCompany(), num);
						break;
					}
				}
			}
		}
		Set ss = CompanyResult.entrySet();
		Iterator iter = ss.iterator();
		while (iter.hasNext()) {
			Map.Entry me = (Map.Entry) iter.next();// 强制转换
			// System.out.println(me.getKey()+":"+me.getValue());
			String key = (String) me.getKey();
			int val = (Integer) me.getValue();
			if ((!key.equals("unknow")) && (val != 0)) {
				statistics.add(new CompanyStatistics(key, val));
			}
		}

		return statistics;
	}

	public boolean ifEqual(UserInfo userA, UserInfoDetail userB) {
		if ((userA.getUserName().equals(userB.getUserName()))
				&& (userA.getDescriptionUser().equals(userB.getDescriptionUser()))) {
			return true;
		} else {
			return false;
		}
	}


}
