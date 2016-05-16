package data.dataImpl;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import data.mysql.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYF on 2016/5/7.
 */
public class ProjectDataImpl {
	
	DBUtil dbUtil=new DBUtil();

    /**
     *从数据库中获取项目数据
     */
	public List<ProjectInfo> getAllProjects() throws Exception{
		
		List<ProjectInfo> pList = null;

		pList=dbUtil.getProjectListFromDB();

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

    	ProjectDetail projectDetail;
    	projectDetail=dbUtil.getProjectDetail(name.toString());


        return projectDetail;
    }
}
