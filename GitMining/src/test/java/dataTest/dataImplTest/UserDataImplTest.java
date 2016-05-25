package dataTest.dataImplTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataImpl.UserDataImpl;

public class UserDataImplTest {

	UserDataImpl userData;
	@Before
	public void setUp() throws Exception {
		userData=new UserDataImpl();
	}

	@Test
	public void testGetAllUsers() {
		List<UserInfo> userList = null;
		
		try {
			userList=userData.getAllUsers();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name="aantthony";
		int proCreate=71;
		
		for(UserInfo user:userList){
			if(user.getUserName().equals(name)){
				assertEquals(proCreate,user.getProjectCreate());
				break;
			}
		}
	}

	@Test
	public void testGetUserByName() {
		String name="debasishg";
		String email="dghosh@acm.org";
		try {
			UserInfoDetail user=userData.getUserByName(name);
			assertEquals(email,user.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
