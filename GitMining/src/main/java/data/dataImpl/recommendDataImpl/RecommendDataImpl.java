package data.dataImpl.recommendDataImpl;

import Info.ProjectDetail;
import Info.UserInfoDetail;
import data.dataImpl.DBUtil;
import data.dataServer.recommendDataServer.RecommendDataServer;

public class RecommendDataImpl implements RecommendDataServer {

	@Override
	public boolean SaveLanguage(String user_id, String language) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDeveloperInfo(String user_id, String UserName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCompanyInfo(String user_id, String company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProjectInfo(String user_id, String ProjectName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProjectDetail getOneProject(String user_id, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoDetail getOneUser(String user_id, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLanguage(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCompany(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

//	private UserCookieDB cookieDB=new UserCookieDB();
//	private DBUtil dbUtil=new DBUtil();
//	
//	@Override
//	public boolean SaveLanguage(String user_id, String language) {
//		return cookieDB.SaveLanguage(user_id, language);
//	}
//
//	@Override
//	public boolean updateDeveloperInfo(String user_id, String UserName) {
//		return cookieDB.updateDeveloperInfo(user_id, UserName);
//	}
//
//	@Override
//	public boolean updateCompanyInfo(String user_id, String company) {
//		return cookieDB.updateCompanyInfo(user_id, company);
//	}
//
//	@Override
//	public boolean updateProjectInfo(String user_id, String ProjectName) {
//		return cookieDB.updateProjectInfo(user_id, ProjectName);
//	}
//
//	@Override
//	public ProjectDetail getOneProject(String user_id, int num) {
//		
//		String projectName=cookieDB.getOneProject(user_id, num);
//		if(projectName==null){
//			return null;
//		}
//		ProjectDetail project=dbUtil.getProjectDetail(projectName);
//		
//		return project;
//	}
//
//	@Override
//	public UserInfoDetail getOneUser(String user_id, int num) {
//		String userName=cookieDB.getOneUser(user_id, num);
//		if(userName==null){
//			return null;
//		}
//		UserInfoDetail user=dbUtil.getUserDetail(userName);
//		return user;
//	}
//
//	@Override
//	public String getLanguage(String user_id) {
//		return cookieDB.getLanguage(user_id);
//	}
//
//	@Override
//	public String getCompany(String user_id) {
//		return cookieDB.getCompany(user_id);
//	}

	
	
	
}
