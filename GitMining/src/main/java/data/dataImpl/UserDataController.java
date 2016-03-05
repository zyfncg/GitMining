package data.dataImpl;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataServer.UserDataServer;

public class UserDataController implements UserDataServer{

	private UserDataUtil userDataUtil=new UserDataUtil();
	
	public List<UserInfo> getAllUsers() throws Exception{

		return userDataUtil.getAllUsers();
	}

	public UserInfoDetail getUserByName(String name) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
