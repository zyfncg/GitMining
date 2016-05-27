package Recommend;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class RecUtil {

	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = allRepositoryStatistic.getStatisticRepositoryInfo();
	public ProjectDetail ToProDetail(ProjectInfo Aproject) {
		for(ProjectDetail temp:AllProject){
			if (this.IfEqualName(temp.getProjectName(), Aproject.getProjectName())) {
				return temp;
			}
		}
		
		return null; 
	}
	public boolean IfEqualName(ProjectName Arg0,ProjectName Arg1) {
		if ((Arg0.getowner().equals(Arg1.getowner())) &&(Arg0.getrepository().equals(Arg1.getrepository()))) {
			return true;
		}
		else {
			return false;
		}
	}
}
