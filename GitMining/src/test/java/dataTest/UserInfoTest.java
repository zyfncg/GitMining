package dataTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Info.UserInfo;
import data.dataImpl.UserDataController;
import data.dataServer.UserDataServer;

public class UserInfoTest {

	@Test
	public void test() {
		UserDataServer userData=new UserDataController();
		List<UserInfo> userList = null;
		UserInfo user = null;
		try {
			userList=userData.getAllUsers();
			System.out.println(userList.size());
			for(UserInfo userInfo:userList){
				if(userInfo.getUserName().equals("aaronrussell")){
					user=userInfo;
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(userList.size());
		}
		
		assertEquals(88,user.getProjectCreate());
	}

}
