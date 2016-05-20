package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.UserInfo;

public class IfBigCow {
	private IfSuccess success = new IfSuccess(); 
	
	public boolean IfBigCowMore50(ProjectDetail AnProject) {
		int Num = AnProject.getCollaboratorsInfo().size()/2;
		int tempNum=0;
		List<UserInfo> AllSuccUser = this.getAllBigCow();
		for(UserInfo tempUser: AnProject.getCollaboratorsInfo()){
			if(AllSuccUser.contains(tempUser)){
				tempNum++;
			}
		}
		if (tempNum>=Num) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<UserInfo> getAllBigCow() {
		List<ProjectDetail> tempSucc = success.GetAllSuccess();
		List<UserInfo> tempSuccUser = new ArrayList<UserInfo>();
		List<UserInfo> SuccUser = new ArrayList<UserInfo>();
		for(ProjectDetail aProject:tempSucc){
			for(UserInfo aUser:(aProject.getCollaboratorsInfo())){
				if (tempSuccUser.contains(aUser)) {
					if (SuccUser.contains(aUser)) {
					}
					else {
						SuccUser.add(aUser);
					}
				}
				else {
					tempSuccUser.add(aUser);
				}
			}
		}	
		return SuccUser;
	}
}
