package dataTest.dataImplTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.dataImpl.ProjectDataImpl;

public class ProjectDataImplTest {

	ProjectDataImpl projectData;
	
	@Before
	public void setUp() throws Exception {
		projectData=new ProjectDataImpl();
	}

	@Test
	public void testGetAllProjects() {
		List<ProjectInfo> pList=new ArrayList<ProjectInfo>();
		try {
			pList=projectData.getAllProjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name="550/tf2ib";
		int star=16;
		for(ProjectInfo project:pList){
			if(project.getProjectName().toString().equals(name)){
				assertEquals(star,project.getStars());
			}
		}
	}

	@Test
	public void testGetProjectByName() {
		ProjectDetail project;
		String name="aboekhoff/congomongo";
		String description="Clojure wrapper for the mongo-db java api";
		
		try {
			project=projectData.getProjectByName(new ProjectName(name));
			assertEquals(description,project.getDescription());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
