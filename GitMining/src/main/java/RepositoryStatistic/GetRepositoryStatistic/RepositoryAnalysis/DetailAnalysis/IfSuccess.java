package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class IfSuccess {
	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = allRepositoryStatistic.getStatisticRepositoryInfo();
	
	public boolean getIfSuccess(ProjectDetail AProject) {
		if (AProject.getStars()>=4000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<ProjectDetail> GetAllSuccess() {
		List<ProjectDetail> AllSuccess = new ArrayList<ProjectDetail>();
		for(ProjectDetail tempProject:AllProject){
			if (tempProject.getStars()>=4000) {
				AllSuccess.add(tempProject);
			}
		}
		return AllSuccess;
	}
	
	public List<ProjectDetail> GetAllUnSuccess() {
		List<ProjectDetail> AllUnSuccess = new ArrayList<ProjectDetail>();
		for(ProjectDetail tempProject:AllProject){
			if (tempProject.getStars()<4000) {
				AllUnSuccess.add(tempProject);
			}
		}
		return AllUnSuccess;
	}
}
