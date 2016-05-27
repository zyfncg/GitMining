package Recommend;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfoDetail;
import data.dataImpl.recommendDataImpl.RecommendDataImpl;
import data.dataServer.recommendDataServer.RecommendDataServer;

public class ProRecommend implements RecommendService {

	private RecommendDataServer RecommendData = new RecommendDataImpl();
	private RecUtil AUtil = new RecUtil();

	@Override
	public List<ProjectInfo> getProjects(String user_id) {
		// TODO Auto-generated method stub
		// 推荐1
		ProjectInfo FstGet = RecommendData.getOneProject(0);
		// 推荐2
		ProjectInfo SecGet = RecommendData.getOneProject(1);
		// 推荐3
		ProjectInfo TrdGet = new ProjectInfo(null, null, 0, 0, 0);
		// 推荐4
		ProjectInfo FthGet = new ProjectInfo(null, null, 0, 0, 0);

		// 推荐三
		UserInfoDetail FstUser = RecommendData.getOneUser(0);
		for (ProjectInfo tempProject : FstUser.getProjectCreatInfo()) {
			if (tempProject.getStars() > TrdGet.getStars()) {
				TrdGet = tempProject;
			}
		}
		// 推荐四
		String mostLanguage = RecommendData.getLanguage();
		for (ProjectInfo tempProject : FstUser.getProjectCreatInfo()) {
			ProjectDetail temp = AUtil.ToProDetail(tempProject);
			if (temp.getLanguage().equals(mostLanguage)) {
				if (temp.getStars() > FthGet.getStars()) {
					FthGet = tempProject;
				}
			}
		}

		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		result.add(FthGet);
		result.add(SecGet);
		result.add(TrdGet);
		result.add(FthGet);
		return result;
	}

	@Override
	public List<UserInfoDetail> getDevelopers(String user_id) {
		// TODO Auto-generated method stub
		// 推荐1
		UserInfoDetail FstGet = RecommendData.getOneUser(0);
		// 推荐3
		UserInfoDetail TrdGet = RecommendData.getOneUser(1);
		// 推荐2
		UserInfoDetail SecGet = new UserInfoDetail(null, null, null, null, null, null, 0, 0, null);
		// 推荐4
		UserInfoDetail FthGet = new UserInfoDetail(null, null, null, null, null, null, 0, 0, null);

		return null;
	}

	@Override
	public void updateLanguageInfo(String user_id, String language) {
		// TODO Auto-generated method stub
		boolean result = RecommendData.SaveLanguage(user_id, language);

	}

	@Override
	public void updateDeveloperInfo(String user_id, String name) {
		// TODO Auto-generated method stub
		boolean result = RecommendData.updateDeveloperInfo(user_id, name);

	}

	@Override
	public void updateCompanyInfo(String user_id, String company) {
		// TODO Auto-generated method stub
		boolean result = RecommendData.updateCompanyInfo(user_id, company);
	}

	@Override
	public void updateProjectInfo(String user_id, String name) {
		// TODO Auto-generated method stub
		boolean result = RecommendData.updateProjectInfo(user_id, name);
	}

}
