package UserStatistic.GetUserStatistic.HistogramDetail;

import java.util.List;

import Info.HistogramInfo;
import Info.UserInfo;
import UserStatistic.GetUserStatistic.HistogramStatisticUser;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class HistogramStatisticJoin implements HistogramStatisticUser {

	public HistogramInfo getUsrHistogramInfo() {
		// 取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 最大值与最小值
		int MaxJoin = userInfoList.get(0).getProjectInvolved();
		int MinJoin = userInfoList.get(0).getProjectInvolved();
		for(UserInfo tempUserInfo:userInfoList){
			if (tempUserInfo.getProjectInvolved()>MaxJoin) {
				MaxJoin = tempUserInfo.getProjectInvolved();
			}
			else if(tempUserInfo.getProjectInvolved()<MinJoin){
				MinJoin = tempUserInfo.getProjectInvolved();
			}
		}

		//组数
		int GroupNum = 1 + (int)( (Math.log10(userInfoList.size())) / (Math.log10(2)) );
		
		//全部Creat Repository信息
		double[] allJoinInfo = new double[userInfoList.size()];
		for(int i=0;i<userInfoList.size();i++){
			allJoinInfo[i] = userInfoList.get(i).getProjectInvolved();
		}
		
		//创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(MaxJoin, MinJoin, GroupNum, allJoinInfo);
		return histogramInfo;
	}

}
