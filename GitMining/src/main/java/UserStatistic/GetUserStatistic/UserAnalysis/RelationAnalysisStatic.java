package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.AddressInfo;
import Info.ProjectDetail;
import Info.RelationUser;
import Info.Relationship;
import Info.UserInfo;
import Info.UserInfoDetail;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;
import data.map.AddressImpl;
import data.statisticServer.AddressServer;

public class RelationAnalysisStatic {
	private OtherAnalysis other = new OtherAnalysis();
	private AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	private AddressServer GetAddress = new AddressImpl();
	// 所有与当前用户相关的User
	List<UserInfoDetail> allrelation = new ArrayList<UserInfoDetail>();

	public Relationship getAllRelationship(UserInfo ChooseUser) {
		Relationship relationship = new Relationship();
		// 于当前查询用户相关的用户
		List<RelationUser> AllRelation = new ArrayList<RelationUser>();
		// 所有项目详细信息
		List<ProjectDetail> allProject = ToGetRepository.getStatisticRepositoryInfo();
		for (ProjectDetail AProject : allProject) {
			for (UserInfo aUserInfo : AProject.getCollaboratorsInfo()) {
				if (other.IfUserEqual(aUserInfo, ChooseUser)) {
					this.IntoRelation(AProject.getCollaboratorsInfo());
					break;
				}
			}
		}
		// UserInfoDetail ChooseOne = other.BecomeDetail(ChooseUser);
		relationship.setUserName(ChooseUser.getUserName());
		relationship.setDescriptionUser(ChooseUser.getDescriptionUser());
		//
		for (UserInfoDetail userInfoDetail : allrelation) {
			int power = other.PowerNum(userInfoDetail);
			AddressInfo addressInfo = GetAddress.getAddressByName(userInfoDetail.getAddress());
			RelationUser relationUser = new RelationUser(userInfoDetail.getUserName(),
					userInfoDetail.getDescriptionUser(), userInfoDetail.getAddress(), addressInfo.getLongtitude(),
					addressInfo.getLatitude(), power);
			AllRelation.add(relationUser);
		}
		relationship.setRelationUser(AllRelation);
		return relationship;
	}

	// 把所有collaboraters加入列表
	public void IntoRelation(List<UserInfo> temp) {
		for (UserInfo auUserInfo : temp) {
			UserInfoDetail userInfoDetail = other.BecomeDetail(auUserInfo);
			if (!allrelation.contains(userInfoDetail)) {
				allrelation.add(userInfoDetail);
			}
		}
	}

}
