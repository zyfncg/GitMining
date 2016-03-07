package data.dataImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.UserInfoDetail;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.JsonUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;

public class UserDataUtil {
	
	private static String projectListUrl=URLString.getRepositoryApiString()+"names";
	private StringListTool stringTool=new StringListTool();
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getAllUsersFromFile(){
		
		List<UserInfo> userList = null;
		
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("userData.ser"));
			userList=(List<UserInfo>) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userList;
	} 
	
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
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("userData.ser"));
			oos.writeObject(userNameList);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
