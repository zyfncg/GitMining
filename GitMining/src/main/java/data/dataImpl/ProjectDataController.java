package data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataServer.ProjectDataServer;
import res.Strings;

public class ProjectDataController implements ProjectDataServer{

	
	private ProjectDataUtil projectdataUtil=new ProjectDataUtil();
	
	
	@Override
	public List<ProjectInfo> getAllProjects() throws Exception{
		List<ProjectInfo> pList=new ArrayList<ProjectInfo>();
		try {
			pList=projectdataUtil.getAllProjectsFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pList;
		}
		return pList;
//		return projectdataUtil.getAllProjects();
	}

	@Override
	public ProjectDetail getProjectByName(ProjectName name) throws Exception {
		ProjectDetail proDetail;
		
		try {
			proDetail=projectdataUtil.getProjectByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(Strings.URL_EXCEPTION_TIP);
		}
		
		return proDetail;
	}

}
