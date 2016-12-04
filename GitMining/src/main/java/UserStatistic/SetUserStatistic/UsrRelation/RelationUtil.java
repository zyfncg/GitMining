package UserStatistic.SetUserStatistic.UsrRelation;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.UserInfo;
import Info.Relation.AllUsrRelation;
import Info.Relation.RelationUser;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.StaticAllProjectDetail;

public class RelationUtil {

	// 所有与当前用户相关的User
	private List<UserInfo> allrelation = new ArrayList<UserInfo>();

	public UserInfo ToUserInfo(RelationUser relationUser, List<UserInfo> allUserInfo) {
		for (UserInfo temp : allUserInfo) {
			if ((temp.getUserName().equals(relationUser.getUserName()))
					&& (temp.getDescriptionUser().equals(relationUser.getDescriptionUser()))) {
				return temp;
			}
		}

		return null;
	}

	public boolean IfUserEqual(UserInfo arg0, UserInfo arg1) {
		if (arg0.getUserName().equals(arg1.getUserName())
				&& arg0.getDescriptionUser().equals(arg1.getDescriptionUser())) {
			return true;
		}

		return false;
	}
	
	public boolean IfContain(List<UserInfo> relat,UserInfo arg0) {
		for(UserInfo tempUserInfo:relat){
			if (this.IfUserEqual(tempUserInfo, arg0)) {
				return true;
			}
		}
		return false;
		
	}

	public AllUsrRelation ToAllUsrRelation(UserInfo ChooseUsr, List<UserInfo> BeUsedUser) {
		AllUsrRelation relationship = new AllUsrRelation(ChooseUsr.getUserName(), ChooseUsr.getDescriptionUser(), null);
		// Relationship relationship = new Relationship();
		boolean find = false;
		// 于当前查询用户相关的用户
		List<UserInfo> AllRelation = new ArrayList<UserInfo>();
		// 所有项目详细信息
		List<ProjectDetail> allProject = StaticAllProjectDetail.AllProjectDetailInfo;
		// 清空allrelation
		allrelation.clear();
		// 处理查询用户相关
		for (ProjectDetail AProject : allProject) {
			for (UserInfo aUserInfo : AProject.getCollaboratorsInfo()) {
				if (this.IfUserEqual(ChooseUsr, aUserInfo)) {
					// AProject.getContributorsInfo().addAll(AProject.getCollaboratorsInfo());
					// this.IntoRelation(AProject.getContributorsInfo(),ChooseUser);
					this.IntoRelation(AProject.getCollaboratorsInfo(), ChooseUsr);
					find = true;
					// break;
				}
			}
		}
		if (!find) {
			return null;
		}
		
		//处理相关用户
		for(UserInfo tempUser:allrelation){
			if (!BeUsedUser.contains(tempUser)) {
				AllRelation.add(tempUser);
			}
		}

		relationship.setAllRelation(AllRelation);
		return relationship;
	}

	// 把所有collaboraters加入列表(allrelation)
	public void IntoRelation(List<UserInfo> temp, UserInfo ChooseUser) {
		for (UserInfo auUserInfo : temp) {
//			UserInfoDetail userInfoDetail = other.BecomeDetail(auUserInfo);
			if ((!this.IfContain(allrelation, auUserInfo)) && (!this.IfUserEqual(ChooseUser, auUserInfo))) {
				allrelation.add(auUserInfo);
			}
		}
	}
}
