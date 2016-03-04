package data.dataServer;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;

public interface UserDataServer {

	/**
	 * @return 返回所有用户信息 
	 */
	public List<UserInfo> getAllUsers();
	/**
	 * 
	 * @return 返回单个用户的详细信息 
	 */
	public UserInfoDetail getUserByName(String name);
}
