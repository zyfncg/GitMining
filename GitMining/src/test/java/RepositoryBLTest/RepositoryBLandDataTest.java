package RepositoryBLTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.Theories;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import businessLogic.businessLogicController.RepositoryController.RepositoryController;
import businessLogicService.RepositoryBLService.RepositoryBLService;
import constant.SortType;

public class RepositoryBLandDataTest {
	@Test
	public void test() {
		RepositoryBLService repositoryBLService = new RepositoryController();
		List<ProjectInfo> somelist = new ArrayList<ProjectInfo>();
		try {
			somelist = repositoryBLService.getAllRepositorys();
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<ProjectInfo> sortlist = new ArrayList<ProjectInfo>();
		try {
			sortlist = repositoryBLService.getSortedRepositorys(SortType.Contributors);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		for(int i=0;i<2000;i++){
			System.out.println(sortlist.get(i).getProjectName().getrepository()+"  "+sortlist.get(i).getProjectName().getowner()+"  "+sortlist.get(i).getForks()+"  "+sortlist.get(i).getStars()+"  "+sortlist.get(i).getContributors());
			
		}
//		ProjectDetail detail = null;
//		try {
//			detail = repositoryBLService.getRepositoryByName(new ProjectName("mojombo","grit"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(detail.getProjectName().toString()+"  "+detail.getDescription()+"  "+detail.getLanguage()+"  "+detail.getURL());
		
//		List<ProjectInfo> someProject = new ArrayList<ProjectInfo>();
//		someProject.add(new ProjectInfo("mojombo", "grit", forks, stars, contributors))
	}
	public static void main(String[] args) {
		RepositoryBLandDataTest asasd = new RepositoryBLandDataTest();
		asasd.test();
	}
}
