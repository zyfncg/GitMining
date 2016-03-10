package businessLogic.businessLogicModel.RepositoryModel.AllSort;

import java.util.List;

import Info.ProjectInfo;
import businessLogic.businessLogicModel.RepositoryModel.DetailSort;

public class GeneralSort implements DetailSort{

	@Override
	//api中的原顺序
	public List<ProjectInfo> MakeSort(List<ProjectInfo> projectInfos) {
		// TODO Auto-generated method stub
		return projectInfos;
	}

}
