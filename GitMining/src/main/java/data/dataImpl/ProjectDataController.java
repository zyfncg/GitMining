package data.dataImpl;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataServer.ProjectDataServer;

public class ProjectDataController implements ProjectDataServer{

	
	private ProjectDataUtil projectdataUtil=new ProjectDataUtil();
	
	public List<ProjectInfo> getAllProjects() throws Exception{
		
		return projectdataUtil.getAllProjects();
	}

	public ProjectDetail getProjectByName(ProjectName name) throws Exception {

		return projectdataUtil.getProjectByName(name);
	}

}
