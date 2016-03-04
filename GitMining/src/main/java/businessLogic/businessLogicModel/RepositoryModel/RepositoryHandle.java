package businessLogic.businessLogicModel.RepositoryModel;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class RepositoryHandle {
	
	ProjectDataServer projectData = new ProjectDataController();
	
	private static List<ProjectInfo> allprojects = null;
	private static List<ProjectInfo> searchprojects = null;
	public List<ProjectInfo> GetAllRepositorys()throws Exception{
		List<ProjectInfo> allProjects = projectData.getAllProjects();
		
		return allProjects;
	}
	
	public ProjectDetail GetRepositoryByName(ProjectName name)throws Exception {
		
		return null;
	}
	
	public List<ProjectInfo> SearchRepositorys(String key)throws Exception {
		
		return null;
	}
}
