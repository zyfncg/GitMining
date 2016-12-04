package dataTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.ProjectInfo;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class ProjectTest {

	@Test
	public void test() {
		ProjectDataServer projectdata=new ProjectDataController();
		ProjectInfo proinfo;
		try {
			List<ProjectInfo> projectList=projectdata.getAllProjects();
			proinfo=projectList.get(0);
			System.out.println(projectList.size());
			assertEquals(true,proinfo!=null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
