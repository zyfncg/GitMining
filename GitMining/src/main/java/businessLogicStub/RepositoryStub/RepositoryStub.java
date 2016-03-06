package businessLogicStub.RepositoryStub;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataServer.ProjectDataServer;

public class RepositoryStub implements ProjectDataServer {

	@Override
	public List<ProjectInfo> getAllProjects() throws Exception {
		// TODO Auto-generated method stub
		List<ProjectInfo> someProject = new ArrayList<ProjectInfo>();
		someProject.add(new ProjectInfo("yes", new ProjectName("rww", "rww1"), 7, 7, 5));
		someProject.add(new ProjectInfo("YES", new ProjectName("rww", "rww2"), 6, 9, 6));
		someProject.add(new ProjectInfo("or", new ProjectName("rww", "rww1"), 5, 8, 2));
		someProject.add(new ProjectInfo("no", new ProjectName("rww", "rww2"), 4, 4, 4));
		someProject.add(new ProjectInfo("NO", new ProjectName("rww", "rww3"), 3, 5, 7));
		someProject.add(new ProjectInfo("end", new ProjectName("rww", "rww2"), 1, 4, 0));
		someProject.add(new ProjectInfo("END", new ProjectName("rww", "rww4"), 4, 13, 6));
		return someProject;
	}

	@Override
	public ProjectDetail getProjectByName(ProjectName name) throws Exception {
		// TODO Auto-generated method stub
		return new ProjectDetail("asd", "java", "http:", new ProjectName("rww", "rww1"), 7, 7, 7, 7, 7);
	}

}
