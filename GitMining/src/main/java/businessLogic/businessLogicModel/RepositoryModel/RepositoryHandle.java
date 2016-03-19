package businessLogic.businessLogicModel.RepositoryModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import businessLogicStub.RepositoryStub.RepositoryStub;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class RepositoryHandle {
	
	ProjectDataServer projectData = new ProjectDataController();
	//全部项目信息（粗略）列表
	private static List<ProjectInfo> allprojects = new ArrayList<ProjectInfo>();
	//最近一次搜索所得的项目信息（粗略）列表
	private static List<ProjectInfo> searchprojects = new ArrayList<ProjectInfo>();
	
	
	//Junit test
	ProjectDataServer repositoryStub = new RepositoryStub();
	
	
	public List<ProjectInfo> GetAllRepositorys()throws Exception{
		List<ProjectInfo> allProjects = projectData.getAllProjects();
		//junit Test
//		List<ProjectInfo> allProjects = repositoryStub.getAllProjects();
		allprojects.clear();
		allprojects.addAll(allProjects);
		return allProjects;
	}
	
	public ProjectDetail GetRepositoryByName(ProjectName name)throws Exception {
		
		return projectData.getProjectByName(name);
		
		//Junit Test
//		return repositoryStub.getProjectByName(name);
	}
	
	public List<ProjectInfo> SearchRepositorys(String key)throws Exception {
		List<ProjectInfo> resultList = new ArrayList<ProjectInfo>();
		List<ProjectInfo> templist = new ArrayList<ProjectInfo>();
//		List<ProjectInfo> templist2 = new ArrayList<ProjectInfo>();
//		try {
			templist = this.GetAllRepositorys();			
//			templist2.addAll(templist);
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw e;
//		}
		Iterator<ProjectInfo> iter = templist.iterator();
		while(iter.hasNext()){
			ProjectInfo proinfos = iter.next();
			if (proinfos.getProjectName().getrepository().contains(key)) {
				resultList.add(proinfos);
				iter.remove();
			}
		}
			
//		for(ProjectInfo proinfo:templist){
//			if (proinfo.getProjectName().getrepository().contains(key)) {
////				System.out.println("12311");
//				resultList.add(proinfo);
////				System.out.println("12312");
////				templist2.remove(proinfo);
////				System.out.println("12313");
//			}
//		}
		for(ProjectInfo projectInfo2:templist){
			if (projectInfo2.getDescription().contains(key)) {
//				System.out.println("123");
				resultList.add(projectInfo2);
			}
		}
		searchprojects.clear();
		searchprojects.addAll(resultList);
//		System.out.println(resultList.size());
		return resultList;
	}
	
	public List<ProjectInfo> getallProjects() {
		List<ProjectInfo> temp = new ArrayList<ProjectInfo>();
		temp.addAll(allprojects);
		return temp;
	}
	
	public List<ProjectInfo> getSeaechProjects() {
		List<ProjectInfo> Temp = new ArrayList<ProjectInfo>();
		Temp.addAll(searchprojects);
		return Temp;
	}
}
