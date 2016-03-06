package stub;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import constant.SortType;

public class RepositoryController_Stub implements RepositoryBLService {

	@Override
	public List<ProjectInfo> getAllRepositorys() throws Exception {
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < 8; i++) {
			projects.add(new ProjectInfo("OS kernel",
					new ProjectName("Linus", "Linux"), 10 * i, 20 * i, 30 * i));
		}
		return projects;
	}

	@Override
	public ProjectDetail getRepositoryByName(ProjectName name) throws Exception {
		return new ProjectDetail("OS kernel", "C", "https://www.github.com", 
				new ProjectName("Linus", "Linux"), 100, 200, 300, 400,1);
	}

	@Override
	public List<ProjectInfo> searchRepositorys(String key) throws Exception {
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < 20; i++) {
			projects.add(new ProjectInfo("OS kernel",
					new ProjectName("Linus", "Linux"), 10 * i, 20 * i, 30 * i));
		}
		return projects;
	}

	@Override
	public List<ProjectInfo> getSortedRepositorys(SortType type) throws Exception {
		List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
		for(int i = 0; i < 20; i++) {
			projects.add(new ProjectInfo("OS kernel",
					new ProjectName("Linus", "Linux"), 10 * i, 20 * i, 30 * i));
		}
		return projects;
	}

	@Override
	public List<ProjectInfo> SortSearchRepositorys(SortType type, List<ProjectInfo> SomeProjects){
		// TODO Auto-generated method stub
		return null;
	}

}
