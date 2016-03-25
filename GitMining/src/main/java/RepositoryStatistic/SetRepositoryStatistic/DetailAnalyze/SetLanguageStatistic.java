package RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.LanguageStatistics;

public class SetLanguageStatistic{


	public List<LanguageStatistics> makeLanguageStatistic(List<ProjectDetail> projectDetails) {
		
		List<LanguageStatistics> allLanguageResult = new ArrayList<LanguageStatistics>();
		
		int projectSize = projectDetails.size();
		DecimalFormat df = new DecimalFormat("######0.00");
		//形成所有不同语言的一个集合
		List<String> allLanguage = new ArrayList<String>();
		for(ProjectDetail tempProject:projectDetails){
			if (!allLanguage.contains(tempProject.getLanguage())) {
				allLanguage.add(tempProject.getLanguage());
			}
		}
		
		//对各种语言进行统计
		for(int i=0;i<allLanguage.size();i++){
			int projectNumber=0;
			for(ProjectDetail tempProject2:projectDetails){
				if ((allLanguage.get(i)).equals(tempProject2.getLanguage())) {
					projectNumber++;
				}
			}
			double Projectnumber = Double.parseDouble(df.format(projectNumber/projectSize));
			LanguageStatistics languageStatisticsResult = new LanguageStatistics(allLanguage.get(i), projectNumber, Projectnumber);
			allLanguageResult.add(languageStatisticsResult);
		}
		

		return allLanguageResult;
	}

}
