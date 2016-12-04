package recommend;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfoDetail;
import data.dataImpl.recommendDataImpl.RecommendDataImpl;
import data.dataServer.recommendDataServer.RecommendDataServer;

public class RecommendLogic implements RecommendService {

	private RecommendDataServer RecommendData = new RecommendDataImpl();
	private RecUtil AUtil = new RecUtil();
	private UsrRecommend user = new UsrRecommend();

	@Override
	public List<ProjectDetail> getProjects(String user_id) {
		int TOPNum = 0;
		List<String> projectName = new ArrayList<String>();
		projectName.clear();
		// TODO Auto-generated method stub
		// 推荐1
		ProjectDetail FstGet = RecommendData.getOneProject(user_id,0);
		if (FstGet == null) {
			FstGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		projectName.add(FstGet.getProjectName().toString());
		// 推荐2
		ProjectDetail SecGet = RecommendData.getOneProject(user_id,1);
		if (SecGet == null) {
			SecGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		
		while(projectName.contains(SecGet.getProjectName().toString())){
			SecGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		projectName.add(SecGet.getProjectName().toString());
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
		while(projectName.contains(TrdGet.getProjectName().toString())){
			TrdGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		projectName.add(TrdGet.getProjectName().toString());
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
		while(projectName.contains(FthGet.getProjectName().toString())){
			FthGet = AUtil.GetTOP(TOPNum);
			TOPNum++;
		}
		projectName.add(FthGet.getProjectName().toString());

		List<ProjectDetail> result = new ArrayList<ProjectDetail>();
		result.add(FstGet);
		result.add(SecGet);
		result.add(TrdGet);
		result.add(FthGet);
		return result;
	}

//	@SuppressWarnings("unused")
	@Override
	public List<UserInfoDetail> getDevelopers(String user_id) {
		int TopNum = 0;
		List<String> userName = new ArrayList<>();
		userName.clear();
		// 推荐1
		UserInfoDetail FstGet = RecommendData.getOneUser(user_id,0);
		if (FstGet == null) {
			FstGet = user.GetTop(TopNum);
			TopNum++;
		}
		userName.add(FstGet.getUserName());
		// 推荐2
		UserInfoDetail SecGet = user.getMostRelat(FstGet.getProjectCreatInfo(),FstGet.ChangeDetailToInfo());
		if (SecGet == null) {
			SecGet = user.GetTop(TopNum);
			TopNum++;
		}
		
		while(userName.contains(SecGet.getUserName())){
			SecGet = user.GetTop(TopNum);
			TopNum++;
		}
			
		userName.add(SecGet.getUserName());
		// 推荐3
		UserInfoDetail TrdGet = RecommendData.getOneUser(user_id,1);
		if (TrdGet == null) {
			TrdGet = user.GetTop(TopNum);
			TopNum++;
		}
		while(userName.contains(TrdGet.getUserName())){
			TrdGet = user.GetTop(TopNum);
			TopNum++;
		}
		
		userName.add(TrdGet.getUserName());
		// 推荐4
		UserInfoDetail FthGet = user.getMostRelat(TrdGet.getProjectCreatInfo(),TrdGet.ChangeDetailToInfo());
		if (FthGet == null) {
			FthGet = user.GetTop(TopNum);
			TopNum++;
		}
		while(userName.contains(FthGet.getUserName())){
			FthGet = user.GetTop(TopNum);
			TopNum++;
		}
		userName.add(FthGet.getUserName());
		
		List<UserInfoDetail> result = new ArrayList<UserInfoDetail>();
		result.add(FstGet);
		result.add(SecGet);
		result.add(TrdGet);
		result.add(FthGet);
		return result;
	}

	@Override
	public void updateLanguageInfo(String user_id, String language) {
		// TODO Auto-generated method stub
		if(!language.equals("unknown")){
			boolean result = RecommendData.SaveLanguage(user_id, language);
		}
		else {
		}
	}

	@Override
	public void updateDeveloperInfo(String user_id, String name) {
		// TODO Auto-generated method stub
		boolean result = RecommendData.updateDeveloperInfo(user_id, name);

	}

	@Override
	public void updateCompanyInfo(String user_id, String company) {
		// TODO Auto-generated method stub
		if(!company.equals("unknown")){
			boolean result = RecommendData.updateCompanyInfo(user_id, company);			
		}
		else {
		}
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
