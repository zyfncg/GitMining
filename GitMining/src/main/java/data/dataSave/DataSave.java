package data.dataSave;

import Info.*;
import data.dataImpl.FileUtil;
import data.mysql.Database;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DataSave {
	private FileUtil fileUtil=new FileUtil();


	public static void main(String args[]){
		DataSave ds=new DataSave();
		if(ds.saveProjectData()){
			System.out.println("项目信息保存成功！");
		}else{
			System.out.println("项目信息保存失败！");
		}
		if(ds.saveUserData()){
			System.out.println("用户信息保存成功！");
		}else{
			System.out.println("用户信息保存失败！");
		}
		if(ds.savePartnerData()){
			System.out.println("项目人员信息保存成功！");
		}else{
			System.out.println("项目人员信息保存失败！");
		}
		
		
		
		
	}
	
	
	/**
	 *保存项目信息到数据库
	 *
	 */
	@SuppressWarnings("unchecked")
	public boolean saveProjectData(){
		int count=0;
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
		Map<String,Integer> userCommits;

		String linkStr="','";
		String sql;
		List<ProjectDetail> projectDetailList=null;

		try {
			projectDetailList=fileUtil.getProjectDetailList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assert projectDetailList != null;
		
//		sql="TRUNCATE TABLE projectInfo";
		try {
			sql="delete from projectContributors";
			Database.operate(sql);
			sql="delete from projectCollaborators";
			Database.operate(sql);
			sql="delete from projectCommits";
			Database.operate(sql);
			sql="delete from projectStatistic";
			Database.operate(sql);
			sql="delete from projectInfo";
			Database.operate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for(ProjectDetail projectDetail:projectDetailList){
			pn=projectDetail.getProjectName();
			projectName=pn.toString();
			projectName.replace("'", "\\'");
			description=projectDetail.getDescription();
			description=description.replace("'", "\\'");
			//System.out.println(description);
			language=projectDetail.getLanguage();
			URL=projectDetail.getURL();
			forks=projectDetail.getForks();
			stars=projectDetail.getStars();
			contributors=projectDetail.getContributors();
			collaborators=projectDetail.getCollaborators();
			subscribers=projectDetail.getSubscribers();
			date=projectDetail.getCreatDate();
			creatDate=date.getDate();
			issue=projectDetail.getIssue();
			pullRequest=projectDetail.getPullRequest();
			size=projectDetail.getSize();
			commit=projectDetail.getCommit();


			sql="INSERT INTO projectInfo VALUES('"+projectName+linkStr+description+linkStr+language+linkStr+URL+linkStr+
					creatDate+"',"+forks+","+stars+","+contributors+","+issue+","+pullRequest+","+size+","+commit+","+
					collaborators+","+subscribers +");";
			try {
				//System.out.println(sql);
				if(!Database.operate(sql)){
                    System.out.println("Saving projectInfo failed");
                    return false;
                }
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(sql);
				System.out.println("存储失败！");
			}

			userCommits=projectDetail.getUserCommits();
			if(userCommits!=null){
//				System.out.println("map is null!");
				for(Map.Entry<String, Integer> entry : userCommits.entrySet()){

					sql="INSERT INTO projectCommits VALUES('"+projectName+linkStr+entry.getKey()+"',"+entry.getValue()+")";
					try {
						if(!Database.operate(sql)){
							System.out.println("Saving projectCommits failed");
							return false;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			count++;
			if(count%50==0){
				System.out.println(count);
			}
			
			
		}

		return true;
	}

	/**
	 *保存项目的合作者和贡献者信息
	 */
	public boolean savePartnerData(){
		List<ProjectDetail> projectDetailList=null;
		List<UserInfo> ContributorsInfo;
		List<UserInfo> CollaboratorsInfo;

		ProjectName pn;
		String projectName;
		String userName;

		String linkStr="','";
		String sql;

		try {
			projectDetailList=fileUtil.getProjectDetailList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			sql="delete from projectContributors";
			Database.operate(sql);
			sql="delete from projectCollaborators";
			Database.operate(sql);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(ProjectDetail projectDetail:projectDetailList){
			ContributorsInfo=projectDetail.getContributorsInfo();
			CollaboratorsInfo=projectDetail.getCollaboratorsInfo();
			pn=projectDetail.getProjectName();
			projectName=pn.toString();
			for(UserInfo user:ContributorsInfo){
				userName=user.getUserName();
				sql="INSERT INTO projectContributors VALUES('"+projectName+linkStr+userName+"')";
				try {
					if(!Database.operate(sql)){
						System.out.println("Saving projectContributors failed");
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(UserInfo user:CollaboratorsInfo){
				userName=user.getUserName();
				sql="INSERT INTO projectCollaborators VALUES('"+projectName+linkStr+userName+"')";
				try {
					if(!Database.operate(sql)){
						System.out.println("Saving projectCollaborators failed");
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return true;
	}

	/**
	 *保存用户信息到数据库
	 */
	public boolean saveUserData(){

		int count = 0;
		
		String userName;
		String descriptionUser ;
		String email;
		Date date;
		String joinDate;
		String type;
		String company;
		String address;
		int projectInvolved;
		int projectCreate;

		List<ProjectInfo> projectCreatInfo;

		List<UserInfoDetail> userInfoDetailList;
		ProjectName pn;
		String projectName;

		try {
			userInfoDetailList=fileUtil.getUserDetailList();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		String linkStr="','";
		String sql;
		String creatSQL;
		try {
			sql="delete from projectCreated";
			Database.operate(sql);
			sql="delete from userInfo";
			Database.operate(sql);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(UserInfoDetail user:userInfoDetailList){
			userName=user.getUserName();
			descriptionUser=user.getDescriptionUser();
			descriptionUser=descriptionUser.replace("'", "\\'");
			email=user.getEmail();
			date=user.getJoinDate();
			joinDate=date.getDate();
			type=user.getUserType();
			company=user.getCompany();
			company=company.replace("'", "\\'");
			address=user.getAddress();
			address=address.replace("'", "\\'");
			projectInvolved=user.getProjectInvolved();
			projectCreate=user.getProjectCreate();

			sql="INSERT INTO userInfo VALUES('"+userName+linkStr+descriptionUser+linkStr+email+linkStr+joinDate+linkStr+
					type+linkStr+company+linkStr+address+"',"+projectInvolved+","+projectCreate+")";
			try {
				if(!Database.operate(sql)){
					System.out.println("Saving userInfo failed");
					return false;
				}
			} catch (SQLException e) {
				System.out.println(sql);
				e.printStackTrace();
			}

			projectCreatInfo=user.getProjectCreatInfo();
			for(ProjectInfo project:projectCreatInfo){
				pn=project.getProjectName();
				projectName=pn.toString();
				creatSQL="INSERT INTO projectCreated VALUES('"+userName+linkStr+projectName+"')";
				try {
					if(!Database.operate(creatSQL)){
						System.out.println("Saving projectCreated failed");
						return false;
					}
				} catch (SQLException e) {
					System.out.println(creatSQL);
					e.printStackTrace();
					
				}
			}
			
			count++;
			if(count%50==0){
				System.out.println(count);
			}
		}

		return true;
	}

	
}
