package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.List;

import Info.ProjectDetail;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class StaticAllProjectDetail {
	public static List<ProjectDetail>  AllProjectDetailInfo = null;
	
	static {
		AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
		List<ProjectDetail> AllProject = allRepositoryStatistic.getStatisticRepositoryInfo();
		StaticAllProjectDetail.AllProjectDetailInfo = AllProject;
	}
}
