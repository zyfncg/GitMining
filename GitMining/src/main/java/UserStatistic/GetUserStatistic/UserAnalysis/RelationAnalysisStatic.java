package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.AddressInfo;
import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import Info.Relation.RelationUser;
import Info.Relation.Relationship;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.StaticAllProjectDetail;
import data.dataServer.statisticServer.AddressServer;
import data.map.AddressImpl;

public class RelationAnalysisStatic {
	private OtherAnalysis other = new OtherAnalysis();
//	private AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	private AddressServer GetAddress = new AddressImpl();
	// 所有与当前用户相关的User
	private List<UserInfoDetail> allrelation = new ArrayList<UserInfoDetail>();

	public Relationship getAllRelationship(UserInfo ChooseUser) {
		Relationship relationship = new Relationship();
		boolean find = false;
		// 于当前查询用户相关的用户
		List<RelationUser> AllRelation = new ArrayList<RelationUser>();
		// 所有项目详细信息
		List<ProjectDetail> allProject = StaticAllProjectDetail.AllProjectDetailInfo;
		//清空allrelation
		allrelation.clear();
		//处理查询用户相关
		for (ProjectDetail AProject : allProject) {
			for (UserInfo aUserInfo : AProject.getContributorsInfo()) {
				if (other.IfUserEqual(aUserInfo, ChooseUser)) {
//					AProject.getContributorsInfo().addAll(AProject.getCollaboratorsInfo());
//					this.IntoRelation(AProject.getContributorsInfo(),ChooseUser);
					this.IntoRelation(AProject.getContributorsInfo(), ChooseUser);
					find  = true;
					//break;
				}
			}
		}
		if (!find) {
			return null;
		}
		// UserInfoDetail ChooseOne = other.BecomeDetail(ChooseUser);
		//设置当前用户的相关值
		UserInfoDetail ChooseUserDetail = other.BecomeDetail(ChooseUser);
		AddressInfo ChooseaddressInfo = GetAddress.getAddressByName(ChooseUserDetail.getAddress());
		if (ChooseaddressInfo == null) {
			return null;
		}
		relationship.setUserName(ChooseUser.getUserName());
		relationship.setDescriptionUser(ChooseUser.getDescriptionUser());
		relationship.setLatitude(ChooseaddressInfo.getLatitude());
		relationship.setLongtitude(ChooseaddressInfo.getLongtitude());
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
		relationship.setRelationUsers(AllRelation);
		return relationship;
	}

	// 把所有collaboraters加入列表(allrelation)
	public void IntoRelation(List<UserInfo> temp,UserInfo ChooseUser) {
		for (UserInfo auUserInfo : temp) {
			UserInfoDetail userInfoDetail = other.BecomeDetail(auUserInfo);
			if ((!other.IfContained(allrelation, userInfoDetail)) && (!other.IfEqualDetail(ChooseUser, userInfoDetail)) ) {
				allrelation.add(userInfoDetail);
			}
		}
	}

}
