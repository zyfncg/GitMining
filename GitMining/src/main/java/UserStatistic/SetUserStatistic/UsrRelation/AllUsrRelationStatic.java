package UserStatistic.SetUserStatistic.UsrRelation;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfo;
import Info.Relation.AllUsrRelation;
import businessLogic.businessLogicModel.UserModel.UserHandle;
import data.dataImpl.statistisDataImpl.UserStatisticData;
import data.dataServer.statisticServer.UserStatisticsDataServer;

public class AllUsrRelationStatic {

//	private RelationAnalysisStatic Relation = new RelationAnalysisStatic();
	private RelationUtil Autil = new RelationUtil();
	private UserStatisticsDataServer userStatisticsData = new UserStatisticData();
	public boolean SetAllUsrRelation() {
		//取得所有的UserInfo
		UserHandle handle = new UserHandle();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			userInfos = handle.GetAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//所有人物关系的List
		List<AllUsrRelation> Result = new ArrayList<AllUsrRelation>();
		
		//已经实用的UserInfo，之后人物的相关信息里不可再包含
		List<UserInfo> hasUserInfo = new ArrayList<UserInfo>();
		for(UserInfo nowUser:userInfos){
			AllUsrRelation alluser = Autil.ToAllUsrRelation(nowUser, hasUserInfo);
			if ((alluser!=null)&&(alluser.getAllRelation().size()!=0)) {
				Result.add(alluser);
				hasUserInfo.add(nowUser);
//				System.out.println(nowUser.getUserName());
//			System.out.println("~~~~~~~~~~~~~");
//			System.out.println(alluser.getAllRelation().size());
//				for(UserInfo userInfo:alluser.getAllRelation()){
//					System.out.println(userInfo.getUserName());
//				}
//				System.out.println("---------------");
			}
			
		}
		boolean SaveRes = userStatisticsData.SaveAllRelation(Result);
//		System.out.println("asd");
		
		
		return SaveRes;
	}
	
	public static void main(String[] args) {
		AllUsrRelationStatic allUsrRelationStatic = new AllUsrRelationStatic();
		allUsrRelationStatic.SetAllUsrRelation();
	}

}
