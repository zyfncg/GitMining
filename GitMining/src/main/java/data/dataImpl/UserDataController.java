package data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataServer.UserDataServer;
import res.Strings;

public class UserDataController implements UserDataServer{

	private UserDataUtil userDataUtil=new UserDataUtil();
	
	@Override
	public List<UserInfo> getAllUsers() throws Exception{

		List<UserInfo> userList=new ArrayList<UserInfo>();
		
		try {
			userList=userDataUtil.getAllUsersFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return userList;
		}
		
//		return userDataUtil.getAllUsers();
		return userList;
	}

	@Override
	public UserInfoDetail getUserByName(String name) throws Exception{
		
		UserInfoDetail user;
		
		try {
			user=userDataUtil.getUserByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(Strings.URL_EXCEPTION_TIP);
		}
		
		return user;
	}

}
