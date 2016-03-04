package businessLogic.businessLogicModel.RepositoryModel;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class RepositoryHandle {
	
	ProjectDataServer projectData = new ProjectDataController();
	//全部项目信息（粗略）列表
	private static List<ProjectInfo> allprojects = new ArrayList<ProjectInfo>();
	//最近一次搜索所得的项目信息（粗略）列表
	private static List<ProjectInfo> searchprojects = new ArrayList<ProjectInfo>();
	public List<ProjectInfo> GetAllRepositorys()throws Exception{
		List<ProjectInfo> allProjects = projectData.getAllProjects();
		allprojects.addAll(allProjects);
		return allProjects;
	}
	
	public ProjectDetail GetRepositoryByName(ProjectName name)throws Exception {
		
		return projectData.getProjectByName(name);
	}
	
	public List<ProjectInfo> SearchRepositorys(String key)throws Exception {
		List<ProjectInfo> resultList = new ArrayList<ProjectInfo>();
		List<ProjectInfo> templist = new ArrayList<ProjectInfo>();
		templist.addAll(allprojects);
		for(ProjectInfo proinfo:templist){
			if ((proinfo.getDescription().contains(key))||(proinfo.getProjectName().getrepository().contains(key))) {
				resultList.add(proinfo);
			}
		}
		searchprojects.addAll(resultList);
		return resultList;
	}
	
	public List<ProjectInfo> getallProjects() {
		List<ProjectInfo> temp = new ArrayList<ProjectInfo>();
		temp.addAll(allprojects);
		return temp;
	}
}
