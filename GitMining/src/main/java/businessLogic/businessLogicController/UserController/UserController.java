package businessLogic.businessLogicController.UserController;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import businessLogic.businessLogicModel.UserModel.UserHandle;
import businessLogicService.UserBLService.UserBLService;

public class UserController implements UserBLService{

	UserHandle userHandle = new UserHandle();
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return userHandle.GetAllUsers();
	}

	public UserInfoDetail getUserByName(String name) {
		// TODO Auto-generated method stub
		return userHandle.GetUserByName(name);
	}

	public List<UserInfo> searchUsers(String key) {
		// TODO Auto-generated method stub
		return userHandle.SearchUsers(key);
	}

}
