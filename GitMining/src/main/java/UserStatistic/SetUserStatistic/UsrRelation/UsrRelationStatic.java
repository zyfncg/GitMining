package UserStatistic.SetUserStatistic.UsrRelation;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.Relation.RelationAll;
import Info.Relation.RelationUser;
import Info.Relation.Relationship;
import UserStatistic.GetUserStatistic.UserAnalysis.RelationAnalysisStatic;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class UsrRelationStatic {

	private RelationAnalysisStatic Relation = new RelationAnalysisStatic();
	private RelationUtil Autil = new RelationUtil();
	public boolean SetUsrRelation() {
		UserHandle handle = new UserHandle();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			userInfos = handle.GetAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo Need = null;
		for(UserInfo tempUser:userInfos){
			Relationship relationship = Relation.getAllRelationship(tempUser);
			if (relationship!=null) {
				int Num = relationship.getRelationUsers().size();
				if (Num ==7) {
					Need = tempUser;
					System.out.println(relationship.getUserName());
					System.out.println("----------------");
					break;
//					for(RelationUser relationUser:relationship.getRelationUsers()){
//						System.out.println(relationUser.getUserName());
//					}
				}
				
			}
		}
		
		//最后结果
		RelationAll relationResult = new RelationAll(Need.getUserName(), Need.getDescriptionUser(), null);
		//第二层人物联系
		List<Relationship> relationAll = new ArrayList<Relationship>();
		
		//核心人物的relationship
		Relationship relationship = Relation.getAllRelationship(Need);
		int num = 0;
		//核心人物的每一个relation friend
		for(RelationUser temp:relationship.getRelationUsers()){
			UserInfo tempUserInfo = Autil.ToUserInfo(temp, userInfos);
			//每一个relation friend的relationship
			Relationship tempRelat = Relation.getAllRelationship(tempUserInfo);
			if (tempRelat.getRelationUsers().size()>2) {
				System.out.println(temp.getUserName());
				System.out.println("~~~~~~~~~~~~~~~");
				//将第二层的相关人物形成一个List
				List<RelationUser> relationUsers = new ArrayList<RelationUser>();
				for(RelationUser tempUsr:tempRelat.getRelationUsers()){
					System.out.println(tempUsr.getUserName());
					RelationUser anRelationUser = new RelationUser(tempUsr.getUserName(), tempUsr.getDescriptionUser(), null, 0, 0, 0);
					relationUsers.add(anRelationUser);
				}
				System.out.println("-------------");
				Relationship anRelationAll = new Relationship(temp.getUserName(),temp.getDescriptionUser(),relationUsers);
				relationAll.add(anRelationAll);
				num++;
			}
		}
		System.out.println(num);
		System.out.println(num);
//		System.out.println(maxNum);
		relationResult.setFirstRelation(relationAll);
		
		return false;
	}
	
	public static void main(String[] args) {
		UsrRelationStatic usrRelationStatic = new UsrRelationStatic();
		usrRelationStatic.SetUsrRelation();
		
	}
}
