package dataTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Info.ProjectInfo;
import Info.UserInfoDetail;
import data.dataImpl.UserDataController;
import data.dataServer.UserDataServer;

public class UserDetailTest {

	@Test
	public void test() {
		String userName="ghtdak";
		
		UserDataServer userData=new UserDataController();
		UserInfoDetail userDetail = null;
		ProjectInfo project;
		try {
			userDetail=userData.getUserByName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project=userDetail.getProjectCreatInfo().get(0);
		assertEquals(25,project.getForks());
		
	}

}
