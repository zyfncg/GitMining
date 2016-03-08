package data.dataImpl;

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
	private FileUtil proFile=new FileUtil();
	
	/**
	 *从文件中获取项目数据 
	 * 
	 * 
	 */
	public List<ProjectInfo> getAllProjectsFromFile() throws Exception{
		
		List<ProjectInfo> pList = null;

		pList=proFile.getProjectListFromFile();

		return pList;
	}
	
	/**
	 * 使用URL获得所有的项目信息并写到文件中
	 * @author ZhangYF
	 * @return 项目列表 
	 * 
	 */
	public List<ProjectInfo> getAllProjects() throws Exception{
		ProjectInfo projectInfo;
		String projectURL;
		String projectJson;
		List<ProjectInfo> projectList=new ArrayList<ProjectInfo>();
		
		String reponameList=HttpRequestUtil.httpRequest(projectListUrl);
		List<String> reponame=stringTool.getStringList(reponameList);
		
		for(int i=0;i<reponame.size();i++){
//		for(int i=0;i<reponame.size();i++){
			projectURL=URLString.getRepositoryApiString()+reponame.get(i);
			projectJson=HttpRequestUtil.httpRequest(projectURL);
			if(projectJson==null){
				continue;
			}		
			projectInfo=JsonUtil.jsonToProject(projectJson);
			projectList.add(projectInfo);
		}
		
		if(!proFile.setProjectToFile(projectList)){
			return null;
		}
		
		return projectList;
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
