package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.UserInfoDetail;

public class IfSuccess {
//	private AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
	private List<ProjectDetail> AllProject = StaticAllProjectDetail.AllProjectDetailInfo;
//	private static  Succ = 7708;
	
//	public IfSuccess(){
//		if (AllProject == null) {
//			StaticAllProjectDetail staticAllProjectDetail = new StaticAllProjectDetail();
//			AllProject = staticAllProjectDetail.AllProjectDetailInfo;
//		}
//	}
	
	public boolean getIfSuccess(ProjectDetail AProject) {
		if (AProject.getStars()>=5000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<ProjectDetail> GetAllSuccess() {
		List<ProjectDetail> AllSuccess = new ArrayList<ProjectDetail>();
		for(ProjectDetail tempProject:AllProject){
			if (tempProject.getStars()>=5000) {
				AllSuccess.add(tempProject);
			}
		}
		return AllSuccess;
	}
	
	public List<ProjectDetail> GetAllUnSuccess() {
		List<ProjectDetail> AllUnSuccess = new ArrayList<ProjectDetail>();
		for(ProjectDetail tempProject:AllProject){
			if (tempProject.getStars()<5000) {
				AllUnSuccess.add(tempProject);
			}
		}
		return AllUnSuccess;
	}
	
	//计算某一个用户创建的项目的成功数量
	public int CalSuccNum(UserInfoDetail userDetail) {
		int num = 0;
		for(ProjectInfo temp:userDetail.getProjectCreatInfo()){
			if (temp.getStars()>=5000) {
				num++;
			}
		}
		
		return num;
	}
}
