package data.dataImpl;

import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;

public class UserDataUtil {
	
	private FileUtil fileUtil=new FileUtil();
	
	/**
	 *从文件中获取用户数据 
	 * 
	 */
	public List<UserInfo> getAllUsers() throws Exception{
		
		List<UserInfo> userList = null;
		
		userList=fileUtil.getUserList();
		
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
		
		List<UserInfoDetail> userDetailList=fileUtil.getUserDetailList();
		UserInfoDetail userDetail = null;
		String userName;
		
		for(UserInfoDetail ud:userDetailList){
			userName=ud.getUserName();
			if(userName.equals(name)){
				userDetail=ud;
				break;
			}
		}
		
		return userDetail;
	}
}
