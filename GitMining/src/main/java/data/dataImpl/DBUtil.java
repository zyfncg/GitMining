package data.dataImpl;

import Info.*;
import data.mysql.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangYF on 2016/5/7.
 */
public class DBUtil {
	
	/**
     * 从数据库获得指定项目的详细信息
     */
	public ProjectDetail getProjectDetail(String projectName){
		List<ProjectDetail> pList;
    	String target="where name='"+projectName+"'";
    	pList=getProjectDetailListFromDB(target);
    	if(pList==null){
        	return null;
        }
    	return pList.get(0);
	}
	
	/**
     * 从数据库获得指定项目的信息
     */
    private ProjectInfo getProjectInfo(String projectName){

        ResultSet rs;

        ProjectName proname=null;
        String description=null;
        int forks=0;
        int stars=0;
        int contributors=0;

        String sql="select * from projectInfo where name='"+projectName+"'";
        try {
            rs=Database.query(sql);
            while (rs.next()){
                proname=new ProjectName(projectName);
                description=rs.getString("description");
                forks=rs.getInt("forks");
                stars=rs.getInt("stars");
                contributors=rs.getInt("contributors");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return new ProjectInfo(description,proname,forks,stars,contributors);
    }

    /**
     *从数据库中获取所有项目详细数据
     */
    public List<ProjectDetail> getProjectDetailList() {

    	List<ProjectDetail> pList;
    	String target="";
    	pList=getProjectDetailListFromDB(target);
    	
    	return pList;
    }

    /**
     *从数据库中获取所有项目简单数据
     */
    public List<ProjectInfo> getProjectList(){
    	ResultSet rs;

        List<ProjectInfo> pList = new ArrayList<ProjectInfo>();
        ProjectInfo project;
        ProjectName pn;
        String projectName;
        String description=null;
        int forks=0;
        int stars=0;
        int contributors=0;
        
        String sql="select * from projectInfo";
        try {
            rs=Database.query(sql);
            while (rs.next()){
            	projectName=rs.getString("name");
                pn=new ProjectName(projectName);
                description=rs.getString("description");
                forks=rs.getInt("forks");
                stars=rs.getInt("stars");
                contributors=rs.getInt("contributors");
                project=new ProjectInfo(description, pn, forks, stars, contributors);
                pList.add(project);
            }

        } catch (SQLException e) {
        	
            e.printStackTrace();
            if(pList.size()<1){
            	return null;
            }
            return pList;
        }
        if(pList.size()<1){
        	return null;
        }
        return pList;
    }
    
    /**
     * 通过target信息对应获得项目详细信息列表
     * targer格式为where name='xxx'
     * target为""则为所有项目
     */
    private List<ProjectDetail> getProjectDetailListFromDB(String target){
    	ResultSet rs;

        List<ProjectDetail> pList = new ArrayList<ProjectDetail>();
        ProjectDetail projectDetail;

        ProjectName pn;
        String projectName;
        String description;
        String language;
        String URL;
        int forks;
        int stars;
        int contributors;
        int collaborators;
        int subscribers;

        Date date;
        String creatDate;

        int pullRequest;
        int size;
        long commit;
        int issue;
        int oneUserCommit;

        double StarStatistic;
		double ContributorStatistic;
		double CommitStatistic;
		double issueStatistic;
		double PullRequestStatistic;
		double sizeStatistic;
		double StarAverage;
		double ContibutorAverage;
		double CommitAverage;
		double issueAverage;
		double PullRequestAverage;
		double sizeAverage;
		double totalStatistic;
		
		StatisticDetail statistic = null;
        
        UserInfo userInfo;

        ResultSet userRS;

        String sql="select * from projectInfo "+target;
        String contributorSQL;
        String collaboratorSQL;
        String commitSQL;
        String statisticSQL;

        String userName;

        try {
            rs= Database.query(sql);
            while(rs.next()) {
                projectName = rs.getString("name");
                pn = new ProjectName(projectName);
                description = rs.getString("description");
                language = rs.getString("languages");
                URL = rs.getString("URL");
                forks = rs.getInt("forks");
                stars = rs.getInt("stars");
                contributors = rs.getInt("contributors");
                collaborators = rs.getInt("collaborators");
                subscribers = rs.getInt("subscribers");

                creatDate = rs.getString("creatDate");
                date = Date.stringToDate(creatDate);
                pullRequest = rs.getInt("pullRequest");
                size = rs.getInt("sizes");
                commit = rs.getLong("commits");
                issue = rs.getInt("issue");

                

                projectDetail = new ProjectDetail(description, language, URL, pn, forks,
                        stars, contributors, collaborators, subscribers, null, null);
                projectDetail.setSize(size);
                projectDetail.setCommit((int)commit);
                projectDetail.setPullRequest(pullRequest);
                projectDetail.setIssue(issue);
                projectDetail.setCreatDate(date);

                pList.add(projectDetail);
            }          
            
            rs.close();
            
            for(int i=0;i<pList.size();i++){
            	projectDetail=pList.get(i);
            	pn=projectDetail.getProjectName();
            	projectName=pn.toString();
            	Map<String,Integer> userCommits = new HashMap<String, Integer>();
                List<UserInfo> contributorsInfo=new ArrayList<UserInfo>();
                List<UserInfo> collaboratorsInfo=new ArrayList<UserInfo>();

                contributorSQL = "select * from projectContributors where name='" + projectName + "'";
                userRS = Database.query(contributorSQL);
                while (userRS.next()) {
                    userName=userRS.getString("contributorsName");
                    userInfo=getUserInfo(userName);
                    if(userInfo!=null){
                        contributorsInfo.add(userInfo);
                    }
                }
                userRS.close();

                collaboratorSQL="select * from projectCollaborators where name='" + projectName + "'";
                userRS = Database.query(collaboratorSQL);
                while (userRS.next()) {
                    userName=userRS.getString("cllaboratorsName");
                    userInfo=getUserInfo(userName);
                    if(userInfo!=null){
                        collaboratorsInfo.add(userInfo);
                    }
                }
                userRS.close();

                commitSQL="select * from projectCommits where projectName='" + projectName + "'";
                userRS = Database.query(commitSQL);
                while (userRS.next()) {
                    userName=userRS.getString("userName");
                    oneUserCommit=userRS.getInt("commits");
                    userCommits.put(userName,oneUserCommit);
                }
                userRS.close();
                
                statisticSQL="select * from projectStatistic where name='" + projectName + "'";
                userRS = Database.query(statisticSQL);
                while (userRS.next()) {
                	StarStatistic=userRS.getDouble("StarStatistic");
                	ContributorStatistic=userRS.getDouble("ContributorStatistic");
            		CommitStatistic=userRS.getDouble("CommitStatistic");
            		issueStatistic=userRS.getDouble("issueStatistic");
            		PullRequestStatistic=userRS.getDouble("PullRequestStatistic");
            		sizeStatistic=userRS.getDouble("sizeStatistic");
            		StarAverage=userRS.getDouble("StarAverage");
            		ContibutorAverage=userRS.getDouble("ContibutorAverage");
            		CommitAverage=userRS.getDouble("CommitAverage");
            		issueAverage=userRS.getDouble("issueAverage");
            		PullRequestAverage=userRS.getDouble("PullRequestAverage");
            		sizeAverage=userRS.getDouble("sizeAverage");
            		totalStatistic=userRS.getDouble("totalStatistic");
                    
            		statistic=new StatisticDetail(StarStatistic, ContributorStatistic, CommitStatistic,
            				issueStatistic, PullRequestStatistic, sizeStatistic, totalStatistic);
            		statistic.setStarAverage(StarAverage);
            		statistic.setContibutorAverage(ContibutorAverage);
            		statistic.setCommitAverage(CommitAverage);
            		statistic.setIssueAverage(issueAverage);
            		statistic.setPullRequestAverage(PullRequestAverage);
            		statistic.setSizeAverage(sizeAverage);
            		
                }
                
                projectDetail.setContributorsInfo(contributorsInfo);
                projectDetail.setCollaboratorsInfo(collaboratorsInfo);
                projectDetail.setUserCommits(userCommits);
                projectDetail.setStatisticDetail(statistic);
                pList.set(i, projectDetail);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            if(pList.size()<1){
            	return null;
            }
            return pList;
        }
        if(pList.size()<1){
        	return null;
        }


        return pList;
    }
    
	
    /**
     * 从数据库获得指定用户简单信息
     */
    private UserInfo getUserInfo(String userName){

        ResultSet rs;

        String descriptionUser = null;
        int projectInvolved = 0;
        int projectCreate = 0;

        String sql="select * from userInfo where name='"+userName+"'";
        try {
            rs=Database.query(sql);
            while(rs.next()){
                descriptionUser=rs.getString("description");
                projectInvolved=rs.getInt("projectInvolved");
                projectCreate=rs.getInt("projectCreate");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return new UserInfo(userName, descriptionUser, projectInvolved, projectCreate);
    }

    /**
     * 从数据库获得指定用户详细信息
     */
    public UserInfoDetail getUserDetail(String userName){
    	List<UserInfoDetail> userList;
    	String target="where name='"+userName+"'";
    	userList=getUserDetailListFromDB(target);
    	if(userList==null){
    		return null;
    	}
    	return userList.get(0);
    }
    
    /**
     * 从数据库获取所有用户详细信息
     */
    public List<UserInfoDetail> getUserDetailList(){
    	List<UserInfoDetail> userList;
    	String target="";
    	userList=getUserDetailListFromDB(target);
    	
    	return userList;
    }
    
    /**
     * 通过target信息对应获得用户详细信息列表
     * targer格式为where name='xxx'
     * target为""则为所有用户
     */
    private List<UserInfoDetail> getUserDetailListFromDB(String target){

        ResultSet rs;

        List<UserInfoDetail> userList = new ArrayList<UserInfoDetail>();
        UserInfoDetail userDetail;

        String userName;
        String descriptionUser;
        String email;
        Date joinDate;
        String type;
        String company ;
        String address;
        int projectInvolved;
        int projectCreate;
        String projectName;

        ProjectInfo projectInfo;
        String sql="select * from userInfo "+target;
        String proCreatSQL;

        try {
            rs=Database.query(sql);
            while(rs.next()){
                userName=rs.getString("name");
                descriptionUser=rs.getString("description");
                email=rs.getString("email");
                joinDate=Date.stringToDate(rs.getString("joinDate"));
                type=rs.getString("userType");
                company=rs.getString("company");
                address=rs.getString("address");
                projectInvolved=rs.getInt("projectInvolved");
                projectCreate=rs.getInt("projectCreate");


                userDetail=new UserInfoDetail(userName, descriptionUser, email, joinDate, company,
                        address, projectInvolved, projectCreate, null);
                userDetail.setUserType(type);

                userList.add(userDetail);
            }
            
            rs.close();
            
            for(int i=0;i<userList.size();i++){
            	userDetail=userList.get(i);
            	userName=userDetail.getUserName();
            	List<ProjectInfo> projectCreatList=new ArrayList<ProjectInfo>();
            	proCreatSQL="select * from projectCreated where userName='" + userName + "'";
                ResultSet proCreatRS=Database.query(proCreatSQL);
                while(proCreatRS.next()){
                     projectName=proCreatRS.getString("projectName");
                     projectInfo=getProjectInfo(projectName);
                     if(projectInfo!=null){
                         projectCreatList.add(projectInfo);
                     }
                }
                proCreatRS.close();
                userDetail.setProjectCreatInfo(projectCreatList);
                
                userList.set(i, userDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if(userList.size()<1){
            	return null;
            }
            return userList;
        }
        if(userList.size()<1){
        	return null;
        }

        return userList;
    }

    /**
     * 从数据库获取所有用户简单信息
     */
    public List<UserInfo> getUserList(){
    	
    	List<UserInfo> userList=new ArrayList<UserInfo>();
    	
    	ResultSet rs;

    	String name;
        String descriptionUser = null;
        int projectInvolved = 0;
        int projectCreate = 0;
        
        UserInfo user;

        String sql="select * from userInfo";
        try {
            rs=Database.query(sql);
            while(rs.next()){
            	name=rs.getString("name");
                descriptionUser=rs.getString("description");
                projectInvolved=rs.getInt("projectInvolved");
                projectCreate=rs.getInt("projectCreate");
                user=new UserInfo(name, descriptionUser, projectInvolved, projectCreate);
                userList.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return userList;
        }
        if(userList.size()<1){
        	return null;
        }
        return userList;
    }
}
