package UserStatistic.GetUserStatistic.HistogramDetail;

import java.util.List;

import Info.HistogramInfo;
import Info.UserInfo;
import UserStatistic.GetUserStatistic.HistogramStatisticUser;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class HistogramStatisticCreat implements HistogramStatisticUser{

	public HistogramInfo getUsrHistogramInfo() {
		//取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//最大值与最小值
		int CreatMax =userInfoList.get(0).getProjectCreate();
		int CreatMin =userInfoList.get(0).getProjectCreate();
		for(UserInfo tempuserInfo:userInfoList){
			if (tempuserInfo.getProjectCreate()>CreatMax) {
				CreatMax = tempuserInfo.getProjectCreate();
			}
			else if (tempuserInfo.getProjectCreate()<CreatMin) {
				CreatMin = tempuserInfo.getProjectCreate();
			}
		}
		
		//组数
		int GroupNum = 1 + (int)( (Math.log10(userInfoList.size())) / (Math.log10(2)) );
		
		//全部Creat Repository信息
		double[] allCreatInfo = new double[userInfoList.size()];
		for(int i=0;i<userInfoList.size();i++){
			allCreatInfo[i] = userInfoList.get(i).getProjectCreate();
		}
		
		//创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(CreatMax, CreatMin, GroupNum, allCreatInfo);
		return histogramInfo;
	}

}
