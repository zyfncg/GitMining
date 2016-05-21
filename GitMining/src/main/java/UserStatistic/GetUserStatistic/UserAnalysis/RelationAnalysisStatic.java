package UserStatistic.GetUserStatistic.UserAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RelationUser;
import Info.Relationship;
import Info.UserInfo;
import Info.UserInfoDetail;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;

public class RelationAnalysisStatic {
	private OtherAnalysis other = new OtherAnalysis();
	private AllRepositoryStatistic ToGetRepository = new AllRepositoryStatistic();
	private Relationship relationship = new Relationship();
	//所有与当前用户相关的User
	List<UserInfoDetail> allrelation = new ArrayList<UserInfoDetail>();
	
	
	public Relationship getAllRelationship(UserInfo ChooseUser) {
		//于当前查询用户相关的用户
		List<RelationUser> AllRelation = new ArrayList<RelationUser>();
		//所有项目详细信息
		List<ProjectDetail> allProject = ToGetRepository.getStatisticRepositoryInfo();
		for(ProjectDetail AProject:allProject){
			for(UserInfo aUserInfo:AProject.getCollaboratorsInfo()){
				if(other.IfUserEqual(aUserInfo, ChooseUser)){
					this.IntoRelation(AProject.getCollaboratorsInfo());
					break;
				}
			}
		}
		UserInfoDetail ChooseOne = other.BecomeDetail(ChooseUser);
		
		
		return null;
	}
	
	
	
	
	
	//把所有collaboraters加入列表
	public void IntoRelation(List<UserInfo> temp) {
		for(UserInfo auUserInfo:temp){
			UserInfoDetail userInfoDetail = other.BecomeDetail(auUserInfo);
			if (!allrelation.contains(userInfoDetail)) {
				allrelation.add(userInfoDetail);
			}
		}
	}
	
	
}
