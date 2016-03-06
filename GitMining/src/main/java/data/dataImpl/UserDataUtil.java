package data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.JsonUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;

public class UserDataUtil {
	
	private static String projectListUrl=URLString.getRepositoryApiString()+"names";
	private StringListTool stringTool=new StringListTool();
	public List<UserInfo> getAllUsers() throws Exception{
		
		List<UserInfo> userList=new ArrayList<UserInfo>();
		UserInfo userInfo;
		String userURL;
		String userJson;
		String userName;
		
		
		String reponameList=HttpRequestUtil.httpRequest(projectListUrl);
		List<String> reponame=stringTool.getStringList(reponameList);
		List<String> userNameList=new ArrayList<String>();
		
		for(int i=0;i<reponame.size();i++){
			String ownerRepo[]=reponame.get(i).split("/");
			userName=ownerRepo[0];
			if(userNameList.contains(userName)){
				continue;
			}else{
				userNameList.add(userName);
				userURL=URLString.getUserApiString()+userName;
				userJson=HttpRequestUtil.httpRequest(userURL);
				userInfo=JsonUtil.jsonToUser(userJson);
				userList.add(userInfo);
			}
				
		}
		
		return userList;
	}
	
	public UserInfoDetail getUserByName(String name) throws Exception{
		
		UserInfoDetail userDetail;
		String userURL;
		String userJson;
		
		userURL=URLString.getRepositoryApiString()+name.toString();
		userJson=HttpRequestUtil.httpRequest(userURL);
		userDetail=JsonUtil.jsonToUserDetail(userJson);
		
		return userDetail;
	}
}
