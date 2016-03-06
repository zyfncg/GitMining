package businessLogic.businessLogicController.UserController;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogic.businessLogicModel.UserModel.UserHandle;
import businessLogicService.UserBLService.UserBLService;

public class UserController implements UserBLService{

	UserHandle userHandle = new UserHandle();
	@Override
	public List<UserInfo> getAllUsers()throws Exception {
		// TODO Auto-generated method stub
		return userHandle.GetAllUsers();
	}

	@Override
	public UserInfoDetail getUserByName(String name)throws Exception {
		// TODO Auto-generated method stub
		return userHandle.GetUserByName(name);
	}

	@Override
	public List<UserInfo> searchUsers(String key)throws Exception {
		// TODO Auto-generated method stub
		return userHandle.SearchUsers(key);
	}

}
