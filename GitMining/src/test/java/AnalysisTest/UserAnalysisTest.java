package AnalysisTest;

import java.util.ArrayList;
import java.util.List;

import Info.RelationUser;
import Info.Relationship;
import Info.UserInfo;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.UserAnalysis.RelationAnalysisStatic;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class UserAnalysisTest {

	public static void main(String[] args) {
		UserStatisticFactory factory = new UserStatisticFactory();
//		System.out.println("123");
		RelationAnalysisStatic relation = factory.GetRelationAnalysisStatic();
//		System.out.println("123a");
		UserHandle handle = new UserHandle();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			userInfos = handle.GetAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Relationship relationship = relation.getAllRelationship(userInfos.get(0));
		List<RelationUser> relationUsers = relationship.getRelationUser();
		for(RelationUser temp:relationUsers){
			System.out.println(temp.getUserName());
			System.out.println(temp.getPower());
			System.out.println(temp.getLongtitude());
		}
	}
}
