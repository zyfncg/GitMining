package Recommend;

import java.util.List;

import Info.ProjectInfo;
import Info.UserInfoDetail;
import data.dataImpl.recommendDataImpl.RecommendDataImpl;
import data.dataServer.recommendDataServer.RecommendDataServer;

public class ProRecommend implements RecommendService{

	RecommendDataServer RecommendData = new RecommendDataImpl();
	
	@Override
	public List<ProjectInfo> getProjects(String user_id) {
		// TODO Auto-generated method stub
		ProjectInfo FstGet = RecommendData.getOneProject(1);
		ProjectInfo SecGet = RecommendData.getOneProject(2);
		
		UserInfoDetail FstUser = RecommendData.getOneUser(1);
		return null;
	}

	@Override
	public List<UserInfoDetail> getDevelopers(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLanguageInfo(String user_id, String language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDeveloperInfo(String user_id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCompanyInfo(String user_id, String company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProjectInfo(String user_id, String name) {
		// TODO Auto-generated method stub
		
	}

}
