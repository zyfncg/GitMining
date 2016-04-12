package UserStatistic.GetUserStatistic;

import java.util.List;

import Info.ScatterDiagramStatistic;
import Info.UserInfo;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class ScatterStatisticUsr {

	public ScatterDiagramStatistic getUsrScatterInfo() {
		// 取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 二维double值，先Star后Fork
		double[][] StatisticNum = new double[2][userInfoList.size()];
		for (int i = 0; i < userInfoList.size(); i++) {
			StatisticNum[0][i] = (double)userInfoList.get(i).getProjectCreate();
			StatisticNum[1][i] = (double)userInfoList.get(i).getProjectInvolved();
		}
//		for (int i = 0; i < userInfoList.size(); i++) {
//		}

		//
		int CreatAll = 0;
		int InvolveAll = 0;
		for (int i = 0; i < userInfoList.size(); i++) {
			CreatAll += userInfoList.get(i).getProjectCreate();
			InvolveAll += userInfoList.get(i).getProjectInvolved();
		}

		double CreatAve = ((double) CreatAll) / ((double) (userInfoList.size()));
		double InvolveAve = ((double) InvolveAll) / ((double) (userInfoList.size()));

		// 计算参数A
		double tempA = 0.0;
		for (int i = 0; i < userInfoList.size(); i++) {
			tempA += (StatisticNum[0][i]) * (StatisticNum[1][i]);
		}
		// 以CreatProject值为X坐标
		double tempB = 0.0;
		for (int i = 0; i < userInfoList.size(); i++) {
			tempB += Math.pow(StatisticNum[0][i], 2);
		}


		double ParameterA = (double)(tempA-(userInfoList.size()*CreatAve*InvolveAve)) / (double)(tempB-(userInfoList.size()*Math.pow(CreatAve, 2)));
		double ParameterB = InvolveAve - ParameterA*CreatAve;
		
		ScatterDiagramStatistic scatterDiagramStatistic = new ScatterDiagramStatistic(ParameterA, ParameterB, StatisticNum);
		return scatterDiagramStatistic;
	}
}
