package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfBigCow;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.IfSuccess;

public class UnSuccessAnalysis implements SuccAnalysisStatic{
	private IfSuccess success = new IfSuccess();
	private IfBigCow bigCow = new IfBigCow();
	private List<ProjectDetail> temp = success.GetAllUnSuccess();
	
	@Override
	public double getProjectNum() {
		// TODO Auto-generated method stub
		return temp.size();
	}

	@Override
	public List<Integer> getCollaNum() {
		// TODO Auto-generated method stub
		List<Integer> allcolla = new ArrayList<Integer>();
		for (ProjectDetail aProject : temp) {
			allcolla.add(aProject.getCollaboratorsInfo().size());
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
		return null;
	}

	@Override
	public int getManageTeamNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCommuTeamNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
