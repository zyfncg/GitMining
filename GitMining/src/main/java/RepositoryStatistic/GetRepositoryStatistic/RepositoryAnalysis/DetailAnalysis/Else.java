package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.LanguageStatistics;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class Else {
	// private IfSuccess success = new IfSuccess();
	// private IfBigCow bigCow = new IfBigCow();
	// private List<ProjectDetail> temp = success.GetAllSuccess();

	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = allRepositoryStatistic.getStatisticRepositoryInfo();

	public List<String> GetLanguage() {
		List<LanguageStatistics> Sortlanguage = new ArrayList<LanguageStatistics>();
		List<String> allLanguage = new ArrayList<String>();
		for (ProjectDetail tempProject : AllProject) {
			if (!allLanguage.contains(tempProject.getLanguage())) {
				allLanguage.add(tempProject.getLanguage());
			}
		}
//		for (ProjectDetail tempProject : AllProject) {
//
//		}
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
		
		Collections.sort(Sortlanguage,new Comparator<LanguageStatistics>(){
            @Override
			public int compare(LanguageStatistics arg0, LanguageStatistics arg1) {
                return (new Integer(arg1.getNum())).compareTo(new Integer(arg0.getNum()));
            }
        });
		
		//
		allLanguage.clear();
		List<LanguageStatistics> templanguage = Sortlanguage.subList(0, 9);
		for(LanguageStatistics language:templanguage){
			allLanguage.add(language.getLanguage());
		}
		return allLanguage;
	}
}
