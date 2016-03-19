package data.download;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfo;
import Info.UserInfoDetail;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.JsonUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;
import data.dataImpl.FileUtil;

public class DataDownload {
	private static String projectListUrl=URLString.getRepositoryApiString()+"names";
	private StringListTool stringTool=new StringListTool();
	private FileUtil fileUtil=new FileUtil();
	
	/**
	 * 使用URL获得所有的项目信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功
	 * 
	 */
	public boolean getAllProjects(){
		ProjectInfo projectInfo;
		String projectURL;
		String projectJson;
		List<ProjectInfo> projectList=new ArrayList<ProjectInfo>();
		
		String reponameList = null;
		try {
			reponameList = HttpRequestUtil.httpRequest(projectListUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> reponame=stringTool.getStringList(reponameList);
		
		for(int i=0;i<reponame.size();i++){
			projectURL=URLString.getRepositoryApiString()+reponame.get(i);
			try {
				projectJson=HttpRequestUtil.httpRequest(projectURL);
				if(projectJson==null){
					continue;
				}
				projectInfo=JsonUtil.jsonToProject(projectJson);
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
			projectList.add(projectInfo);
		}
		
		if(!fileUtil.setProjectToFile(projectList)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 使用URL获得所有的项目的详细信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean getAllProjectDetail(){
		ProjectDetail projectDetail;
		String projectURL;
		String projectJson = null;
		List<ProjectDetail> projectList=new ArrayList<ProjectDetail>();
		
		String reponameList;
		try {
			reponameList = HttpRequestUtil.httpRequest(projectListUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		List<String> reponame=stringTool.getStringList(reponameList);
		
		for(int i=0;i<reponame.size();i++){
			projectURL=URLString.getRepositoryApiString()+reponame.get(i);
			try {
				projectJson=HttpRequestUtil.httpRequest(projectURL);
				if(projectJson==null){
					continue;
				}
			
				projectDetail=JsonUtil.jsonToProjectDetail(projectJson);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			projectList.add(projectDetail);
		}
		
		if(!fileUtil.setProjectDetailToFile(projectList)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 使用URL获得所有的用户信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean getAllUsers(){
		
		List<UserInfo> userList=new ArrayList<UserInfo>();
		UserInfo userInfo;
		String userURL;
		String userJson;
		String userName;
		
		
		String reponameList;
		try {
			reponameList = HttpRequestUtil.httpRequest(projectListUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
				try {
					userJson=HttpRequestUtil.httpRequest(userURL);
					
					if(userJson==null){
						continue;
					}
					
					userInfo=JsonUtil.jsonToUser(userJson);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				userList.add(userInfo);
			}
				
		}
		
		if(!fileUtil.setUserToFile(userList)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 使用URL获得所有的用户的详细信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean getAllUserDetail(){
		
		List<UserInfoDetail> userList=new ArrayList<UserInfoDetail>();
		UserInfoDetail userInfo;
		String userURL;
		String userJson;
		String userName;
		
		
		String reponameList;
		try {
			reponameList = HttpRequestUtil.httpRequest(projectListUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
				try {
					userJson=HttpRequestUtil.httpRequest(userURL);
					
					if(userJson==null){
						continue;
					}
					
					userInfo=JsonUtil.jsonToUserDetail(userJson);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				userList.add(userInfo);
			}
				
		}
		
		if(!fileUtil.setUserDetailToFile(userList)){
			return false;
		}
		
		return true;
	}
}
