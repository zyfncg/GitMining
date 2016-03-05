package businessLogic.businessLogicModel.RepositoryModel.AllSort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import businessLogic.businessLogicModel.RepositoryModel.DetailSort;

public class StarSort implements DetailSort{

	public List<ProjectDetail> MakeSort(List<ProjectDetail> projectInfos) {
		// TODO Auto-generated method stub
		 Collections.sort(projectInfos,new Comparator<ProjectDetail>(){
	            public int compare(ProjectDetail arg0, ProjectDetail arg1) {
	                return (new Integer(arg0.getStars())).compareTo(new Integer(arg1.getStars()));
	            }
	        });
		return projectInfos;
	}

}
