package RepositoryBLTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Info.ProjectInfo;
import Info.ProjectName;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import constant.SortType;

public class RepositoryHandleTest {
	@Test
	public void test(){
		RepositoryBLService repositoryBLService = new RepositoryController();
		List<ProjectInfo> somelist = new ArrayList<ProjectInfo>();
		try {
			somelist = repositoryBLService.getAllRepositorys();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		List<ProjectInfo> someProject = new ArrayList<ProjectInfo>();
		someProject.add(new ProjectInfo("yes", new ProjectName("rww", "rww1"), 7, 7, 5));
		someProject.add(new ProjectInfo("YES", new ProjectName("rww", "rww2"), 6, 9, 6));
		someProject.add(new ProjectInfo("or", new ProjectName("rww", "rww1"), 5, 8, 2));
		someProject.add(new ProjectInfo("no", new ProjectName("rww", "rww2"), 4, 4, 4));
		someProject.add(new ProjectInfo("NO", new ProjectName("rww", "rww3"), 3, 5, 7));
		someProject.add(new ProjectInfo("end", new ProjectName("rww", "rww2"), 1, 4, 0));
		someProject.add(new ProjectInfo("END", new ProjectName("rww", "rww4"), 4, 13, 6));
		
		for(int i=0;i<somelist.size();i++){
//			assertEquals(somelist.get(i).getDescription(),someProject.get(i).getDescription());
//			assertEquals(somelist.get(i).getForks(), someProject.get(i).getForks());
//			assertEquals(somelist.get(i).getContributors(), someProject.get(i).getContributors());
//			assertEquals(somelist.get(i).getStars(), someProject.get(i).getStars());
//			assertEquals(somelist.get(i).getProjectName().getowner(), someProject.get(i).getProjectName().getowner());
//			assertEquals(somelist.get(i).getProjectName().getrepository(), someProject.get(i).getProjectName().getrepository());
		}
		
		
		/////////////////////////////////Search(key)
		List<ProjectInfo> searchlist = new ArrayList<ProjectInfo>();
		try {
			searchlist = repositoryBLService.searchRepositorys("ww1");
		} catch (Exception e) {
			// TODO: handle exception
		}	
		List<ProjectInfo> someProject1 = new ArrayList<ProjectInfo>();
		someProject1.add(new ProjectInfo("yes", new ProjectName("rww", "rww1"), 7, 7, 5));
		someProject1.add(new ProjectInfo("or", new ProjectName("rww", "rww1"), 5, 8, 2));
		for(int i=0;i<searchlist.size();i++){
			assertEquals(searchlist.get(i).getDescription(),someProject1.get(i).getDescription());
			assertEquals(searchlist.get(i).getForks(), someProject1.get(i).getForks());
			assertEquals(searchlist.get(i).getContributors(), someProject1.get(i).getContributors());
			assertEquals(searchlist.get(i).getStars(), someProject1.get(i).getStars());
			assertEquals(searchlist.get(i).getProjectName().getowner(), someProject1.get(i).getProjectName().getowner());
			assertEquals(searchlist.get(i).getProjectName().getrepository(), someProject1.get(i).getProjectName().getrepository());
		}
		
		
		////////////////////////////////sort
		List<ProjectInfo> sortlist1 = new ArrayList<ProjectInfo>();
		try {
			sortlist1 = repositoryBLService.getSortedRepositorys(SortType.Fork);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		List<ProjectInfo> sortProject = new ArrayList<ProjectInfo>();
		sortProject.add(new ProjectInfo("yes", new ProjectName("rww", "rww1"), 7, 7, 5));
		sortProject.add(new ProjectInfo("YES", new ProjectName("rww", "rww2"), 6, 9, 6));
		sortProject.add(new ProjectInfo("or", new ProjectName("rww", "rww1"), 5, 8, 2));
		sortProject.add(new ProjectInfo("END", new ProjectName("rww", "rww4"), 4, 13, 6));
		sortProject.add(new ProjectInfo("no", new ProjectName("rww", "rww2"), 4, 4, 4));
		sortProject.add(new ProjectInfo("NO", new ProjectName("rww", "rww3"), 3, 5, 7));
		sortProject.add(new ProjectInfo("end", new ProjectName("rww", "rww2"), 1, 4, 0));
		
		for(int i=0;i<sortlist1.size();i++){
//			assertEquals(sortlist1.get(i).getDescription(),sortProject.get(i).getDescription());
//			assertEquals(sortlist1.get(i).getForks(), sortProject.get(i).getForks());
//			assertEquals(sortlist1.get(i).getContributors(), sortProject.get(i).getContributors());
//			assertEquals(sortlist1.get(i).getStars(), sortProject.get(i).getStars());
//			assertEquals(sortlist1.get(i).getProjectName().getowner(), sortProject.get(i).getProjectName().getowner());
//			assertEquals(sortlist1.get(i).getProjectName().getrepository(), sortProject.get(i).getProjectName().getrepository());
		}
	}
	
}
