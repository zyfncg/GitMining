package businessLogic.businessLogicController.RepositoryController;

import java.util.List;
import java.util.concurrent.ExecutionException;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;
import businessLogic.businessLogicModel.RepositoryModel.RepositorySort;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import constant.SortType;

public class RepositoryController implements RepositoryBLService {

	RepositoryHandle repositoryHandle = new RepositoryHandle();
	RepositorySort repositorySort = new RepositorySort();
	public List<ProjectInfo> getAllRepositorys()throws Exception {
		// TODO Auto-generated method stub
		return repositoryHandle.GetAllRepositorys();
	}

	public ProjectDetail getRepositoryByName(ProjectName name)throws Exception {
		// TODO Auto-generated method stub
		return repositoryHandle.GetRepositoryByName(name);
	}

	public List<ProjectInfo> searchRepositorys(String key)throws Exception {
		// TODO Auto-generated method stub
		return repositoryHandle.SearchRepositorys(key);
	}

	public List<ProjectInfo> getSortedRepositorys(SortType type)throws Exception {
		// TODO Auto-generated method stub
		return repositorySort.GetSortedRepositorys(type);
	}

}
