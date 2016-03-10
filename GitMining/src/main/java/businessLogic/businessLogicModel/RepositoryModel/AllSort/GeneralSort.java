package businessLogic.businessLogicModel.RepositoryModel.AllSort;

import java.util.List;

import Info.ProjectInfo;
import businessLogic.businessLogicModel.RepositoryModel.DetailSort;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class GeneralSort implements DetailSort{

	@Override
	//api中的原顺序
	public List<ProjectInfo> MakeSort(List<ProjectInfo> projectInfos) {
		// TODO Auto-generated method stub
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> allRepositorys = repositoryHandle.getallProjects();
		return allRepositorys;
	}

}
