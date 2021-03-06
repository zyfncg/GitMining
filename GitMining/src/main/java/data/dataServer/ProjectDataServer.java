package data.dataServer;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;

public interface ProjectDataServer {

	/**
	 * @return 返回所有项目信息 
	 */
	public List<ProjectInfo> getAllProjects();
	
	/**
	 * 
	 * @return 返回单个项目的信息 
	 */
	public ProjectDetail getProjectByName(ProjectName name)throws Exception;
	
}
