package RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.TimeStatistics;

public class SetTimeStatistic{


	public List<TimeStatistics> makeTimeStatistic(List<ProjectDetail> projectDetails) {
	
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
		
		List<TimeStatistics> TimeStatisticResult = new ArrayList<TimeStatistics>();
		
		for(int i=StartYear;i<=EndYear;i++){
			int ProjectNumber=0;
			for(ProjectDetail bnProject : projectDetails){
				if (bnProject.getCreatDate().getYear() == i) {
					ProjectNumber++;
				}
			}
			TimeStatistics timeStatistics = new TimeStatistics(i+"年",ProjectNumber);
			TimeStatisticResult.add(timeStatistics);
		}
		
		return TimeStatisticResult;
	}

}
