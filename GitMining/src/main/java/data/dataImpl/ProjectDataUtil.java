package data.dataImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.JsonUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;

public class ProjectDataUtil {
	private static String projectListUrl=URLString.getRepositoryApiString()+"names";
	private StringListTool stringTool=new StringListTool();
	
	/**
	 *从文件中获取项目数据 
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> getAllProjectsFromFile() throws Exception{
		
		List<ProjectInfo> pList = null;
		
		try {
			ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectData.ser"));
			
		    pList=(List<ProjectInfo>) is.readObject();
		    is.close();
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}
	
	/**
	 * 使用URL获得所有的项目信息
	 * @author ZhangYF
	 * @return 项目列表 
	 * 
	 */
	public List<ProjectInfo> getAllProjects() throws Exception{
		ProjectInfo projectInfo;
		String projectURL;
		String projectJson;
		List<ProjectInfo> ProjectList=new ArrayList<ProjectInfo>();
		
		String reponameList=HttpRequestUtil.httpRequest(projectListUrl);
		List<String> reponame=stringTool.getStringList(reponameList);
		
		for(int i=0;i<reponame.size();i++){
//		for(int i=0;i<reponame.size();i++){
			projectURL=URLString.getRepositoryApiString()+reponame.get(i);
			projectJson=HttpRequestUtil.httpRequest(projectURL);
			projectInfo=JsonUtil.jsonToProject(projectJson);
			ProjectList.add(projectInfo);
		}
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectData.ser"));
			oos.writeObject(ProjectList);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ProjectList;
	}
	
	/**
	 *获得单个项目的具体信息
	 *@author ZhangYF
	 *@param 项目名称
	 *@return 具体项目信息
	 *
	 */
	public ProjectDetail getProjectByName(ProjectName name) throws Exception {
		
		ProjectDetail projectDetail;
		String projectURL;
		String projectJson;
		
		projectURL=URLString.getRepositoryApiString()+name.toString();
		projectJson=HttpRequestUtil.httpRequest(projectURL);
		projectDetail=JsonUtil.jsonToProjectDetail(projectJson);
		
		return projectDetail;
	}
}
