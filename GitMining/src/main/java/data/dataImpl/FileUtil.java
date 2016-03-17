package data.dataImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Info.ProjectInfo;
import Info.UserInfo;

public class FileUtil {

	/**
	 * 从文件中获取所有项目信息的列表
	 * @return 项目信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> getProjectListFromFile() throws Exception{
		
		List<ProjectInfo> pList = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectData.ser"));
			
		pList=(List<ProjectInfo>) is.readObject();
		is.close();
		    
		
		return pList;
	}
	
	/**
	 * 所有项目信息的列表放入文件中
	 * @param 项目信息列表
	 */
	public boolean setProjectToFile(List<ProjectInfo> pList){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectData.ser"));
			oos.writeObject(pList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
		
	/**
	 * 从文件中获取所有用户信息的列表
	 * @return 用户信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> getUserListFromFile() throws Exception{
		
		List<UserInfo> userList = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("userData.ser"));
			
		userList=(List<UserInfo>) is.readObject();
		is.close();
		    
		
		return userList;
	}
	
	/**
	 * 所有用户信息的列表放入文件中
	 * @param 用户信息列表
	 */
	public boolean setUserToFile(List<UserInfo> userList){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("userData.ser"));
			oos.writeObject(userList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
