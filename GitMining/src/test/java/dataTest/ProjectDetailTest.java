package dataTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Info.ProjectDetail;
import Info.ProjectName;
import data.dataImpl.ProjectDataController;
import data.dataServer.ProjectDataServer;

public class ProjectDetailTest {

	@Test
	public void test() {
		ProjectDataServer projectdata=new ProjectDataController();
		ProjectDetail proDetail = null;
		ProjectName pn=new ProjectName("hoisie","web");
		
		try {
			proDetail=projectdata.getProjectByName(pn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(360,proDetail.getForks());
	}

}
