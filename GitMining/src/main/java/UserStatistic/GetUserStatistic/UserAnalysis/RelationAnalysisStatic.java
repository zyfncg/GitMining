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
import data.dataServer.statisticServer.AddressServer;
import data.map.AddressImpl;

public class RelationAnalysisStatic {
	private OtherAnalysis other = new OtherAnalysis();
	private AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	private AddressServer GetAddress = new AddressImpl();
	// 所有与当前用户相关的User
	private List<UserInfoDetail> allrelation = new ArrayList<UserInfoDetail>();

	public Relationship getAllRelationship(UserInfo ChooseUser) {
		Relationship relationship = new Relationship();
		boolean find = false;
		// 于当前查询用户相关的用户
		List<RelationUser> AllRelation = new ArrayList<RelationUser>();
		// 所有项目详细信息
		List<ProjectDetail> allProject = ToGetRepository.getStatisticRepositoryInfo();
		//清空allrelation
		allrelation.clear();
		//处理查询用户相关
		for (ProjectDetail AProject : allProject) {
			for (UserInfo aUserInfo : AProject.getCollaboratorsInfo()) {
				if (other.IfUserEqual(aUserInfo, ChooseUser)) {
					this.IntoRelation(AProject.getCollaboratorsInfo());
					find  = true;
					//break;
				}
			}
		}
		if (!find) {
			return null;
		}
		// UserInfoDetail ChooseOne = other.BecomeDetail(ChooseUser);
		relationship.setUserName(ChooseUser.getUserName());
		relationship.setDescriptionUser(ChooseUser.getDescriptionUser());
		//
		for (UserInfoDetail userInfoDetail : allrelation) {
			int power = other.PowerNum(userInfoDetail);
			AddressInfo addressInfo = GetAddress.getAddressByName(userInfoDetail.getAddress());
			if (addressInfo==null) {
			}
			else {
				RelationUser relationUser = new RelationUser(userInfoDetail.getUserName(),
						userInfoDetail.getDescriptionUser(), userInfoDetail.getAddress(), addressInfo.getLongtitude(),
						addressInfo.getLatitude(), power);
				AllRelation.add(relationUser);		
			}
		}
		relationship.setRelationUser(AllRelation);
		return relationship;
	}

	// 把所有collaboraters加入列表(allrelation)
	public void IntoRelation(List<UserInfo> temp) {
		for (UserInfo auUserInfo : temp) {
			UserInfoDetail userInfoDetail = other.BecomeDetail(auUserInfo);
			if (!allrelation.contains(userInfoDetail)) {
				allrelation.add(userInfoDetail);
			}
		}
	}

}
