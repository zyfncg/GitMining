package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.List;

import Info.ProjectDetail;
import Info.Relationship;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class RelstionAnalysisStatic {
	AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	public List<Relationship> getAllRelationship() {
		List<ProjectDetail> allProject = ToGetRepository.getStatisticRepositoryInfo();
		
		
		return null;
	}
}
