package businessLogicStub.UserStub;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataServer.UserDataServer;

public class UserStub implements UserDataServer{

	@Override
	public List<UserInfo> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoDetail getUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
