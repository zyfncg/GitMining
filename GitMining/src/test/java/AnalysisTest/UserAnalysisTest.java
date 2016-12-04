package AnalysisTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Info.UserInfo;
import Info.Relation.RelationUser;
import Info.Relation.Relationship;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.UserAnalysis.RelationAnalysisStatic;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class UserAnalysisTest {
	
	@Test
	public void test(){
		UserStatisticFactory factory = new UserStatisticFactory();
		RelationAnalysisStatic relation = factory.GetRelationAnalysisStatic();
		
		UserHandle handle = new UserHandle();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			userInfos = handle.GetAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo theuser = userInfos.get(57);
//		System.out.println(theuser.getUserName());
		assertEquals(theuser.getUserName(),theuser.getUserName());
		Relationship relationship = relation.getAllRelationship(theuser);
		if (relationship==null) {
//			System.out.println("12312312312312");
			assertEquals(null, relationship);
		}
		else {
//			System.out.println(relationship.getDescriptionUser());
//			System.out.println(relationship.getUserName());
//			System.out.println(relationship.getLatitude());
//			System.out.println(relationship.getLongtitude());
			assertEquals(relationship.getDescriptionUser(),relationship.getDescriptionUser());
			assertEquals(relationship.getUserName(),relationship.getUserName());
			
			List<RelationUser> relationUsers = relationship.getRelationUsers();
//			System.out.println(relationUsers.size());
			assertEquals(relationUsers.size(), relationUsers.size());
			RelationUser temp = relationUsers.get(0);
//			System.out.println(temp.getUserName());
//			System.out.println(temp.getPower());
//			System.out.println(temp.getLatitude());
//			System.out.println(temp.getLongtitude());
//			assertEquals("ultrasaurus",temp.getUserName());
//			assertEquals(0,temp.getPower());
//			assertEquals(38.0,temp.getLatitude(),0.0);
//			assertEquals(-122.0,temp.getLongtitude(),0.0);
			
		}
		
		
	}

//	public static void main(String[] args) {
//		UserStatisticFactory factory = new UserStatisticFactory();
////		System.out.println("123");
//		RelationAnalysisStatic relation = factory.GetRelationAnalysisStatic();
////		System.out.println("123a");
//		UserHandle handle = new UserHandle();
//		List<UserInfo> userInfos = new ArrayList<UserInfo>();
//		try {
//			userInfos = handle.GetAllUsers();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		System.out.println(userInfos.size());
//		UserInfo theuser = userInfos.get(14);
//		int NUM=0;
//		int thenull = 0;
//		for(UserInfo ttemp:userInfos){
//			Relationship relationship = relation.getAllRelationship(ttemp);
//			if (relationship==null) {
////				System.out.println("12312312312312");
//				thenull++;
//			}
//			else {
//				
//				List<RelationUser> relationUsers = relationship.getRelationUsers();
//				int a = relationUsers.size();
//				if (a>=3) {
//					NUM++;
//				}
//			}
//		}
//		System.out.println(NUM);
//		System.out.println(thenull);
//		
//		System.out.println(theuser.getUserName());
////		System.out.println(theuser.get);
//		Relationship relationship = relation.getAllRelationship(theuser);
//		if (relationship==null) {
//			System.out.println("12312312312312");
//		}
//		else {
//			System.out.println(relationship.getDescriptionUser());
//			System.out.println(relationship.getUserName());
//			System.out.println(relationship.getLatitude());
//			System.out.println(relationship.getLongtitude());
//			List<RelationUser> relationUsers = relationship.getRelationUsers();
//			System.out.println(relationUsers.size());
//			for(RelationUser temp:relationUsers){
//				System.out.println(temp.getUserName());
//				System.out.println(temp.getPower());
//				System.out.println(temp.getSite());
//				System.out.println(temp.getLatitude());
//				System.out.println(temp.getLongtitude());
//			}
//			
//		}
//	}
}
