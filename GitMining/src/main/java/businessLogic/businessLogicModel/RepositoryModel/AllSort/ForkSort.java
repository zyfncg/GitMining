package businessLogic.businessLogicModel.RepositoryModel.AllSort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectInfo;
import businessLogic.businessLogicModel.RepositoryModel.DetailSort;

public class ForkSort implements DetailSort{

	@Override
	public List<ProjectInfo> MakeSort(List<ProjectInfo> projectInfos) {
		// TODO Auto-generated method stub
		 Collections.sort(projectInfos,new Comparator<ProjectInfo>(){
	            @Override
				public int compare(ProjectInfo arg0, ProjectInfo arg1) {
	                return (new Integer(arg1.getForks())).compareTo(new Integer(arg0.getForks()));
	            }
	        });
		return projectInfos;
	}

}
