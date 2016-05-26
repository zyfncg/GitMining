package data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataServer.ProjectDataServer;
import res.Strings;

public class ProjectDataController implements ProjectDataServer{

	
//	private ProjectDataUtil projectData=new ProjectDataUtil();
	private ProjectDataImpl projectData=new ProjectDataImpl();
	
	@Override
	public List<ProjectInfo> getAllProjects(){
		List<ProjectInfo> pList=new ArrayList<ProjectInfo>();
		try {
			pList=projectData.getAllProjects();
		} catch (Exception e) {
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
			proDetail=projectData.getProjectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Strings.URL_EXCEPTION_TIP);
		}
		
		return proDetail;
	}

}
