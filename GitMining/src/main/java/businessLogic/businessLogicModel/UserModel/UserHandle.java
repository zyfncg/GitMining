package businessLogic.businessLogicModel.UserModel;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataImpl.UserDataController;
import data.dataServer.UserDataServer;

public class UserHandle {

	UserDataServer userData = new UserDataController();
	//全部用户信息列表
	private static List<UserInfo> alluser = new ArrayList<UserInfo>();
	//最近一次搜索的用户信息列表
	private static List<UserInfo> searchuser = new ArrayList<UserInfo>();
	public List<UserInfo> GetAllUsers()throws Exception {
		List<UserInfo> allUsers = userData.getAllUsers();
		alluser.addAll(allUsers);
		return allUsers;
	}

	public UserInfoDetail GetUserByName(String name)throws Exception {

		return userData.getUserByName(name);
	}

	public List<UserInfo> SearchUsers(String key)throws Exception {
		List<UserInfo> resultList = new ArrayList<UserInfo>();
		List<UserInfo> templist = new ArrayList<UserInfo>();
		templist.addAll(alluser);
		for(UserInfo userInfo:templist){
			if (userInfo.getUserName().contains(key)||userInfo.getDescriptionUser().contains(key)) {
				resultList.add(userInfo);
			}
		}
		searchuser.addAll(resultList);
		return resultList;
	}
}
