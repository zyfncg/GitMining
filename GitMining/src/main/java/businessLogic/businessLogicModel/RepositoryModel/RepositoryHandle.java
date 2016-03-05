package businessLogic.businessLogicModel.RepositoryModel;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectName;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class RepositoryHandle {
	
	ProjectDataServer projectData = new ProjectDataController();
	//全部项目信息（粗略）列表
	private static List<ProjectDetail> allprojects = new ArrayList<ProjectDetail>();
	//最近一次搜索所得的项目信息（粗略）列表
	private static List<ProjectDetail> searchprojects = new ArrayList<ProjectDetail>();
	public List<ProjectDetail> GetAllRepositorys()throws Exception{
		List<ProjectDetail> allProjects = projectData.getAllProjects();
		allprojects.addAll(allProjects);
		return allProjects;
	}
	
	public ProjectDetail GetRepositoryByName(ProjectName name)throws Exception {
		
		return projectData.getProjectByName(name);
	}
	
	public List<ProjectDetail> SearchRepositorys(String key)throws Exception {
		List<ProjectDetail> resultList = new ArrayList<ProjectDetail>();
		List<ProjectDetail> templist = new ArrayList<ProjectDetail>();
		templist.addAll(allprojects);
		for(ProjectDetail proinfo:templist){
			if ((proinfo.getDescription().contains(key))||(proinfo.getProjectName().getrepository().contains(key))) {
				resultList.add(proinfo);
			}
		}
		searchprojects.addAll(resultList);
		return resultList;
	}
	
	public List<ProjectDetail> getallProjects() {
		List<ProjectDetail> temp = new ArrayList<ProjectDetail>();
		temp.addAll(allprojects);
		return temp;
	}
}
