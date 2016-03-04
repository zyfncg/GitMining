package businessLogic.businessLogicModel.UserModel;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataImpl.UserDataController;
import data.dataServer.UserDataServer;

public class UserHandle {

	UserDataServer userData = new UserDataController();
	public List<UserInfo> GetAllUsers() {

		return null;
	}

	public UserInfoDetail GetUserByName(String name) {

		return null;
	}

	public List<UserInfo> SearchUsers(String key) {

		return null;
	}
}
