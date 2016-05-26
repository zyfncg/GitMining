package data.dataImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;

public class FileUtil {

	/**
	 * 从文件中获取所有项目信息的列表
	 * @return 项目信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> getProjectList() throws Exception{
		
		List<ProjectInfo> pList = null;	

		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectData.ser"));
			
		pList=(List<ProjectInfo>) is.readObject();
		is.close();
		    
		
		return pList;
	}
	
	/**
	 * 所有项目信息的列表放入文件中
	 * @param pList 项目信息列表
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
	public List<UserInfo> getUserList() throws Exception{
		
		List<UserInfo> userList;
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("userData.ser"));
			
		userList=(List<UserInfo>) is.readObject();
		is.close();
		    
		
		return userList;
	}
	
	/**
	 * 所有用户信息的列表放入文件中
	 * @param userList 用户信息列表
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
	
	/**
	 * 从文件中获取所有项目信息的列表
	 * @return 项目信息列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectDetail> getProjectDetailList() throws Exception{
		
		List<ProjectDetail> pList = null;	
		
<<<<<<< HEAD
		ObjectInputStream is=new ObjectInputStream(new FileInputStream(
				"projectDetailData.ser"));
=======
		String relativelyPath=System.getProperty("user.dir");
		System.out.println(relativelyPath);
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectDetailData.ser"));
>>>>>>> 88050d4a6cb93547adde2728fdd2892621f5fa9e
			
		pList=(List<ProjectDetail>) is.readObject();
		is.close();
		    
		
		return pList;
	}
	
	/**
	 * 所有项目信息的列表放入文件中
	 * @param pList 项目信息列表
	 */
	public boolean saveProjectDetail(List<ProjectDetail> pList){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectDetailData.ser"));
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
	public List<UserInfoDetail> getUserDetailList() throws Exception{
		
		List<UserInfoDetail> userList = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("userDetailData.ser"));
			
		userList=(List<UserInfoDetail>) is.readObject();
		is.close();
		    
		
		return userList;
	}
	
	/**
	 * 所有用户信息的列表放入文件中
	 * @param 用户信息列表
	 */
	public boolean setUserDetailToFile(List<UserInfoDetail> userList){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("userDetailData.ser"));
			oos.writeObject(userList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
