package data.dataImpl;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataServer.UserDataServer;

public class UserDataController implements UserDataServer{

	private UserDataUtil userDataUtil=new UserDataUtil();
	
	@Override
	public List<UserInfo> getAllUsers() throws Exception{

//		return userDataUtil.getAllUsers();
		return userDataUtil.getAllUsersFromFile();
	}

	@Override
	public UserInfoDetail getUserByName(String name) throws Exception{
		
		return userDataUtil.getUserByName(name);
	}

}
