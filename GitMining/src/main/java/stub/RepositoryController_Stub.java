package stub;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
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
		ProjectDetail d = new ProjectDetail("OS kernel", "C", "https://www.github.com", 
				new ProjectName("Linus", "Linux"), 100, 200, 300, 400,1,null,null);
		List<UserInfo> c = new ArrayList<>();
		for(int i = 0; i < 15; ++i) {
			c.add(new UserInfo("Linus", "father of Linux kernel", 100 + i, 200 + i));
		}
		d.setCollaboratorsInfo(c);
		List<UserInfo> u = new ArrayList<>();
		for(int i = 0; i < 15; ++i) {
			u.add(new UserInfo("Linus", "father of Linux kernel", 100 + i, 200 + i));
		}
		d.setContributorsInfo(u);
		return d;
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
		return SomeProjects;
	}

}
