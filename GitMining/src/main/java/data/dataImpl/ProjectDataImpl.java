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

    /**
     *从数据库中获取项目数据
     *
     *
     */
    ResultSet rs;
    public List<ProjectDetail> getAllProjectsFromDB() throws Exception{

        List<ProjectDetail> pList = new ArrayList<ProjectDetail>();
        ProjectDetail projectDetail;
        ProjectName proname;
        String language;
        String URL;
        String description;

        int forks;
        int stars;
        int contributors;
        int collaborators;
        int subscribers;

        Date creatDate;

        int pullRequest;
        int size;
        int commit;
        int issue;
        String sql="select * from projectInfo";
        rs= Database.query(sql);
        while(rs.next()){
            proname=new ProjectName(rs.getString("name"));
            //projectDetail=new ProjectDetail();
        }
        //pList=proFile.getProjectListFromFile();

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

        //List<ProjectDetail> proList=proFile.getProjectDetailListFromFile();
        ProjectDetail projectDetail = null;
        ProjectName pn;



        return projectDetail;
    }
}
