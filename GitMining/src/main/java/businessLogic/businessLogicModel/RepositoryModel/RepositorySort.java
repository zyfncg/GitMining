package businessLogic.businessLogicModel.RepositoryModel;

import java.util.List;

import Info.ProjectInfo;
import businessLogic.businessLogicModel.RepositoryModel.AllSort.ContributorSort;
import businessLogic.businessLogicModel.RepositoryModel.AllSort.ForkSort;
import businessLogic.businessLogicModel.RepositoryModel.AllSort.GeneralSort;
import businessLogic.businessLogicModel.RepositoryModel.AllSort.StarSort;
import constant.SortType;

public class RepositorySort {

	public List<ProjectInfo> GetSortedRepositorys(SortType type) {
		DetailSort SortWay = this.GetDetailSort(type);
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> allRepositorys = repositoryHandle.getallProjects();
//		System.out.println(allRepositorys.get(0).getProjectName().getrepository());
		List<ProjectInfo> sortedRepositorys = SortWay.MakeSort(allRepositorys);
		return sortedRepositorys;
	}
	
	public List<ProjectInfo> SortSearchRepositorys(SortType type,List<ProjectInfo> someProjects){
//		System.out.println("123Search");
		DetailSort SortWay = this.GetDetailSort(type);
		List<ProjectInfo> sortedSearchRepositorys = SortWay.MakeSort(someProjects);
		return sortedSearchRepositorys;
	}
	
	//通过Type找到对应方法
	public DetailSort GetDetailSort(SortType Type){
		if (Type.equals(SortType.Fork)) {
			DetailSort forkSort = new ForkSort();
			return forkSort;
		}
		else if (Type.equals(SortType.Star)) {
			DetailSort starSort = new StarSort();
			return starSort;
		}
		else if (Type.equals(SortType.Contributors)) {
			DetailSort conSort = new ContributorSort();
			return conSort;
		}
		else if (Type.equals(SortType.General)) {
			DetailSort GeneralSort = new GeneralSort();
			return GeneralSort;
		}
		return null;
	}
}
