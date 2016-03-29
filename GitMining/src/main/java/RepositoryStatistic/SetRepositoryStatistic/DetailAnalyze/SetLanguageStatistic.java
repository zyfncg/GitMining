package RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.LanguageStatistics;

public class SetLanguageStatistic {

	public List<LanguageStatistics> makeLanguageStatistic(List<ProjectDetail> projectDetails) {

		List<LanguageStatistics> allLanguageResult = new ArrayList<LanguageStatistics>();

		int projectSize = projectDetails.size();
		DecimalFormat df = new DecimalFormat("######0.00");
		// 形成所有不同语言的一个集合
		List<String> allLanguage = new ArrayList<String>();
		for (ProjectDetail tempProject : projectDetails) {
			if (!allLanguage.contains(tempProject.getLanguage())) {
				allLanguage.add(tempProject.getLanguage());
			}
		}

		// 对各种语言进行统计
		for (int i = 0; i < allLanguage.size(); i++) {
			int projectNumber = 0;
			for (ProjectDetail tempProject2 : projectDetails) {
				if ((allLanguage.get(i)).equals(tempProject2.getLanguage())) {
					projectNumber++;
				}
			}
			double Projectnumber = Double.parseDouble(df.format(((double) projectNumber) / ((double) projectSize)));
			LanguageStatistics languageStatisticsResult = new LanguageStatistics(allLanguage.get(i), projectNumber,
					Projectnumber);
			allLanguageResult.add(languageStatisticsResult);
		}

		// 项目统计数据处理
		Iterator<LanguageStatistics> languageIte = allLanguageResult.iterator();
		int otherLanguage = 0;
		while (languageIte.hasNext()) {
			LanguageStatistics Iter = languageIte.next();
			if (Iter.getNum() <= 10) {
				otherLanguage = otherLanguage + Iter.getNum();
				languageIte.remove();
			}
		}

		allLanguageResult.add(new LanguageStatistics("other Language", otherLanguage,
				Double.parseDouble(df.format(((double) otherLanguage) / ((double) projectSize)) ) ) );

		//设置Pareto图的百分比数值
		double allBaiFenBi = 0.0;
		for(int i=0;i<allLanguageResult.size();i++){
			allBaiFenBi = allBaiFenBi + allLanguageResult.get(i).getPareto();
			allLanguageResult.get(i).setPareto(allBaiFenBi);
		}
		
		return allLanguageResult;
	}

}
