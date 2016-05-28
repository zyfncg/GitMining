package data.dataImpl.recommendDataImpl;

import Info.ProjectInfo;
import Info.UserInfoDetail;
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
	public ProjectInfo getOneProject(String user_id, int num) {
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

	
	
}
