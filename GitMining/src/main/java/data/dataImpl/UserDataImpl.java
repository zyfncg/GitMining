package data.dataImpl;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;

public class UserDataImpl {
	DBUtil dbUtil=new DBUtil();
	/**
	 *从数据库中获取用户数据 
	 * 
	 */
	public List<UserInfo> getAllUsers() throws Exception{
		
		List<UserInfo> userList = null;
		
		userList=dbUtil.getUserList();
		
		return userList;
	} 
	
	/**
	 *获得单个用户的具体信息
	 *@author ZhangYF
	 *@param 用户姓名
	 *@return 具体用户信息
	 *
	 */
	public UserInfoDetail getUserByName(String name) throws Exception{
		
		
		UserInfoDetail userDetail = null;
		userDetail=dbUtil.getUserDetail(name);
		
		return userDetail;
	}
}
