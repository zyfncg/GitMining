package businessLogic.businessLogicController.UserController;

import java.util.List;

import Info.UserInfoDetail;
import businessLogic.businessLogicModel.UserModel.UserHandle;
import businessLogicService.UserBLService.UserBLService;

public class UserController implements UserBLService{

	UserHandle userHandle = new UserHandle();
	public List<UserInfoDetail> getAllUsers()throws Exception {
		// TODO Auto-generated method stub
		return userHandle.GetAllUsers();
	}

	public UserInfoDetail getUserByName(String name)throws Exception {
		// TODO Auto-generated method stub
		return userHandle.GetUserByName(name);
	}

	public List<UserInfoDetail> searchUsers(String key)throws Exception {
		// TODO Auto-generated method stub
		return userHandle.SearchUsers(key);
	}

}
