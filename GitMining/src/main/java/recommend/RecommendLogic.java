package recommend;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfoDetail;
import data.dataImpl.recommendDataImpl.RecommendDataImpl;
import data.dataServer.recommendDataServer.RecommendDataServer;
import twaver.base.A.E.b;

public class RecommendLogic implements RecommendService {

	private RecommendDataServer RecommendData = new RecommendDataImpl();
	private RecUtil AUtil = new RecUtil();
	private UsrRecommend user = new UsrRecommend();

	@Override
	public List<ProjectDetail> getProjects(String user_id) {
		int TOPNum = 0;
		// TODO Auto-generated method stub
		// 推荐1
		ProjectDetail FstGet = RecommendData.getOneProject(user_id,0);
		if (FstGet == null) {
			FstGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		// 推荐2
		ProjectDetail SecGet = RecommendData.getOneProject(user_id,1);
		if (SecGet == null) {
			SecGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		// 推荐3
		ProjectDetail TrdGet = new ProjectDetail(null, null, null, null, 0, 0, 0, 0, 0, null, null);
		// 推荐4
		ProjectDetail FthGet = new ProjectDetail(null, null, null, null, 0, 0, 0, 0, 0, null, null);

		// 推荐三
		UserInfoDetail FstUser = RecommendData.getOneUser(user_id,0);
		if (FstUser == null) {
			TrdGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		else {
			for (ProjectInfo tempProject : FstUser.getProjectCreatInfo()) {
				if (tempProject.getStars() > TrdGet.getStars()) {
					TrdGet = AUtil.ToProDetail(tempProject);
				}
			}			
		}
		// 推荐四
		String mostLanguage = RecommendData.getLanguage(user_id);
		if ((mostLanguage == null) || (FstUser == null)) {
			FthGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		else {
			for (ProjectInfo tempProject : FstUser.getProjectCreatInfo()) {
				ProjectDetail temp = AUtil.ToProDetail(tempProject);
				if (temp.getLanguage().equals(mostLanguage)) {
					if (temp.getStars() > FthGet.getStars()) {
						FthGet = AUtil.ToProDetail(tempProject);
					}
				}
			}
		}

		List<ProjectDetail> result = new ArrayList<ProjectDetail>();
		result.add(FstGet);
		result.add(SecGet);
		result.add(TrdGet);
		result.add(FthGet);
		return result;
	}

	@Override
	public List<UserInfoDetail> getDevelopers(String user_id) {
		int TopNum = 0;
		
		// 推荐1
		UserInfoDetail FstGet = RecommendData.getOneUser(user_id,0);
		if (FstGet == null) {
			FstGet = user.GetTop(TopNum);
			TopNum++;
		}
		// 推荐2
		UserInfoDetail SecGet = user.getMostRelat(FstGet.getProjectCreatInfo());
		if (SecGet == null) {
			SecGet = user.GetTop(TopNum);
			TopNum++;
		}
		// 推荐3
		UserInfoDetail TrdGet = RecommendData.getOneUser(user_id,1);
		if (TrdGet == null) {
			TrdGet = user.GetTop(TopNum);
			TopNum++;
		}
		// 推荐4
		UserInfoDetail FthGet = user.getMostRelat(TrdGet.getProjectCreatInfo());
		if (FthGet == null) {
			FthGet = user.GetTop(TopNum);
			TopNum++;
		}

		List<UserInfoDetail> result = new ArrayList<UserInfoDetail>();
		result.add(FthGet);
		result.add(SecGet);
		result.add(TrdGet);
		result.add(FthGet);
		return result;
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

	@Override
	public List<ProjectDetail> getTop() {
		// TODO Auto-generated method stub
//		ProjectDetail fst = AUtil.GetTOP(0);
//		ProjectDetail fst1 = AUtil.GetTOP(1);
//		ProjectDetail fst2= AUtil.GetTOP(2);
//		ProjectDetail fst3 = AUtil.GetTOP(3);
//		ProjectDetail fst4 = AUtil.GetTOP(4);
//		ProjectDetail fst5 = AUtil.GetTOP(5);
		List<ProjectDetail> result = AUtil.GetTopSix();
//		List<ProjectDetail> result = new ArrayList<ProjectDetail>();
//		result.add(fst);
//		result.add(fst1);
//		result.add(fst2);
//		result.add(fst3);
//		result.add(fst4);
//		result.add(fst5);
		return result;
	}

}
