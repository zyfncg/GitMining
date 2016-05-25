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
	public ProjectInfo getOneProject(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoDetail getOneUser(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
