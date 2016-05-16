package data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataServer.UserDataServer;
import res.Strings;

public class UserDataController implements UserDataServer{

	private UserDataUtil userDataUtil=new UserDataUtil();
//	private UserDataImpl userDataUtil=new UserDataImpl();
	
	@Override
	public List<UserInfo> getAllUsers(){

		List<UserInfo> userList=new ArrayList<UserInfo>();
		
		try {
			userList=userDataUtil.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return userList;
		}
		
//		try {
//			return userDataUtil.getAllUsers();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return userList;
	}

	@Override
	public UserInfoDetail getUserByName(String name) throws Exception{
		
		UserInfoDetail user;
		
		try {
			user=userDataUtil.getUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(Strings.URL_EXCEPTION_TIP);
		}
		
		return user;
	}

}
