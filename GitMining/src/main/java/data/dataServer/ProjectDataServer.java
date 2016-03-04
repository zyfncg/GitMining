package data.dataServer;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;

public interface ProjectDataServer {

	/**
	 * @return 返回所有项目信息 
	 */
	public List<ProjectInfo> getAllProjects()throws Exception;
	
	/**
	 * 
	 * @return 返回单个项目的信息 
	 */
	public ProjectDetail getProjectByName(String name)throws Exception;
	
}
