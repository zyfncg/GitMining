package RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.StarStatistics;

public class SetStarStatisitc{


	public List<StarStatistics> makeStarStatistics(List<ProjectDetail> projectDetails) {

		int StartYear = projectDetails.get(0).getCreatDate().getYear();
		int EndYear = projectDetails.get(0).getCreatDate().getYear();
		

		for(ProjectDetail anProject : projectDetails){
			if (anProject.getCreatDate().getYear()<StartYear) {
				StartYear = anProject.getCreatDate().getYear();
			}
			else if(anProject.getCreatDate().getYear()>EndYear){
				EndYear = anProject.getCreatDate().getYear();
			}
		}
		
		List<StarStatistics> StarStatisticResult = new ArrayList<StarStatistics>();
		
		for(int i=StartYear;i<=EndYear;i++){
			int StarNumber=0;
			for(ProjectDetail bnProject : projectDetails){
				if (bnProject.getCreatDate().getYear() == i) {
					StarNumber = StarNumber+bnProject.getStars();
				}
			}
			StarStatistics starStatistic = new StarStatistics(i+"年", StarNumber);
			StarStatisticResult.add(starStatistic);
		}

		return StarStatisticResult;
	}

}
