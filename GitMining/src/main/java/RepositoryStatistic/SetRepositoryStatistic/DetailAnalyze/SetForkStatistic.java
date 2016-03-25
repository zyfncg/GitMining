package RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.ForkStatistics;

public class SetForkStatistic{


	public List<ForkStatistics> makeForkStatistic(List<ProjectDetail> projectDetails) {
		
//		int maxFork = 0;
//		
//		for(ProjectDetail anProject : projectDetails){
//			if(anProject.getForks() > maxFork){
//				maxFork = anProject.getForks();
//			}
//		}
//		
//		int average = (maxFork+6)/6;
//		int number[] = {0,0,0,0,0,0};
//		for(ProjectDetail bnProject : projectDetails){
//			int a = this.DetailSort(bnProject.getForks(),average);
//			number[a]++;
//		}
//		ForkStatistics forkStatistics1 = new ForkStatistics("0-"+average, number[0]);
//		ForkStatistics forkStatistics2 = new ForkStatistics(average+"-"+(average*2), number[1]);
//		ForkStatistics forkStatistics3 = new ForkStatistics((average*2)+"-"+(average*3), number[2]);
//		ForkStatistics forkStatistics4 = new ForkStatistics((average*3)+"-"+(average*4), number[3]);
//		ForkStatistics forkStatistics5 = new ForkStatistics((average*4)+"-"+(average*5), number[4]);
//		List<ForkStatistics> forkStatisticsList = new ArrayList<ForkStatistics>();
//		forkStatisticsList.add(forkStatistics1);
//		forkStatisticsList.add(forkStatistics2);
//		forkStatisticsList.add(forkStatistics3);
//		forkStatisticsList.add(forkStatistics4);
//		forkStatisticsList.add(forkStatistics5);
		
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
		
		List<ForkStatistics> forkStatisticsResult = new ArrayList<ForkStatistics>();
		
		for(int i=StartYear;i<=EndYear;i++){
			int ForkNumber=0;
			for(ProjectDetail bnProject : projectDetails){
				if (bnProject.getCreatDate().getYear() == i) {
					ForkNumber = ForkNumber+bnProject.getForks();
				}
			}
			ForkStatistics forkStatistic = new ForkStatistics(i+"年", ForkNumber);
			forkStatisticsResult.add(forkStatistic);
		}
		
		
		return forkStatisticsResult;
	}


}
