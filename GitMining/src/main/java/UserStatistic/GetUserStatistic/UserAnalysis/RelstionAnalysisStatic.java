package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.Relationship;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class RelstionAnalysisStatic {
	AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	public List<Relationship> getAllRelationship() {
		List<ProjectDetail> allProject = ToGetRepository.getStatisticRepositoryInfo();
		List<Relationship> allrelation = new ArrayList<Relationship>();
		
		return null;
	}
}
