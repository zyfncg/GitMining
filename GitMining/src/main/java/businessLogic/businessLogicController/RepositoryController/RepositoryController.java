package businessLogic.businessLogicController.RepositoryController;

import java.util.List;

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
	@Override
	public List<ProjectInfo> getAllRepositorys()throws Exception {

		return repositoryHandle.GetAllRepositorys();
	}

	@Override
	public ProjectDetail getRepositoryByName(ProjectName name)throws Exception {

		return repositoryHandle.GetRepositoryByName(name);
	}

	@Override
	public List<ProjectInfo> searchRepositorys(String key)throws Exception {

		return repositoryHandle.SearchRepositorys(key);
	}

	@Override
	public List<ProjectInfo> getSortedRepositorys(SortType type)throws Exception {

		return repositorySort.GetSortedRepositorys(type);
	}

	@Override
	public List<ProjectInfo> SortSearchRepositorys(SortType type, List<ProjectInfo> SomeProjects){

		return repositorySort.SortSearchRepositorys(type, SomeProjects);
	}
	


}
