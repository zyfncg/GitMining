package data.dataImpl;

import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;

public class ProjectDataUtil {
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
	 *获得单个项目的具体信息
	 *@author ZhangYF
	 *@param name 项目名称
	 *@return 具体项目信息
	 *
	 */
	public ProjectDetail getProjectByName(ProjectName name) throws Exception {
		
		List<ProjectDetail> proList=proFile.getProjectDetailListFromFile();
		ProjectDetail projectDetail = null;
		ProjectName pn;
		
		for(ProjectDetail pd:proList){
			pn=pd.getProjectName();
			if(pn.isSame(name)){
				projectDetail=pd;
				break;
			}
		}
		
		return projectDetail;
	}
}
