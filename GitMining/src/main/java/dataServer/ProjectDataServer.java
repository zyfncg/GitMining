package dataServer;

public interface ProjectDataServer {

	/**
	 * @return 返回所有项目信息 
	 */
	public String getAllProjects();
	
	/**
	 * 
	 * @return 返回单个项目的信息 
	 */
	public String getProjectByName(String name);
}
