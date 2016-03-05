package businessLogic.businessLogicModel.UserModel;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import data.dataImpl.UserDataController;
import data.dataServer.UserDataServer;

public class UserHandle {

	UserDataServer userData = new UserDataController();
	//全部用户信息列表
	private static List<UserInfoDetail> alluser = new ArrayList<UserInfoDetail>();
	//最近一次搜索的用户信息列表
	private static List<UserInfoDetail> searchuser = new ArrayList<UserInfoDetail>();
	public List<UserInfoDetail> GetAllUsers()throws Exception {
		List<UserInfoDetail> allUsers = userData.getAllUsers();
		alluser.addAll(allUsers);
		return allUsers;
	}

	public UserInfoDetail GetUserByName(String name)throws Exception {

		return userData.getUserByName(name);
	}

	public List<UserInfoDetail> SearchUsers(String key)throws Exception {
		List<UserInfoDetail> resultList = new ArrayList<UserInfoDetail>();
		List<UserInfoDetail> templist = new ArrayList<UserInfoDetail>();
		templist.addAll(alluser);
		for(UserInfoDetail userInfo:templist){
			if (userInfo.getUserName().contains(key)||userInfo.getDescriptionUser().contains(key)) {
				resultList.add(userInfo);
			}
		}
		searchuser.addAll(resultList);
		return resultList;
	}
}
