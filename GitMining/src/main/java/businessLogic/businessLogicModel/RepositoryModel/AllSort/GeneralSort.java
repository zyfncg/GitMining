package businessLogic.businessLogicModel.RepositoryModel.AllSort;

import java.util.List;

import Info.ProjectInfo;
import businessLogic.businessLogicModel.RepositoryModel.DetailSort;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class GeneralSort implements DetailSort{

	@Override
	//api中的原顺序
	public List<ProjectInfo> MakeSort(List<ProjectInfo> projectInfos) {
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		//get Search projects(the last time)
		List<ProjectInfo> Temp = repositoryHandle.getSeaechProjects();
//		System.out.println(Temp.size()+"  |  "+projectInfos.size());
		if ((Temp.size()) == (projectInfos.size())) {
			
			return Temp;
		}
		else {
			List<ProjectInfo> allRepositorys = repositoryHandle.getallProjects();
			return allRepositorys;			
		}
	}

}
