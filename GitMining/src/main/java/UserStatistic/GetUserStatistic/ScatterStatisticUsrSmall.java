package UserStatistic.GetUserStatistic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ScatterDiagramStatistic;
import Info.UserInfo;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class ScatterStatisticUsrSmall {

	public ScatterDiagramStatistic getUsrScatterInfo() {
		// 取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 常量，取全部数据的百分比
		int BaiFenBi = (int) ((userInfoList.size()) * (0.7));

		// 二维double值，先Creat后Involve
		double[][] StatisticNum = new double[2][userInfoList.size()];
		// 添加Star值
		// 按Star对项目进行排序
		Collections.sort(userInfoList, new Comparator<UserInfo>() {
			@Override
			public int compare(UserInfo arg0, UserInfo arg1) {
				return (new Integer(arg0.getProjectCreate())).compareTo(new Integer(arg1.getProjectCreate()));
			}
		});

		for (int i = 0; i < BaiFenBi; i++) {
			StatisticNum[0][i] = userInfoList.get(i).getProjectCreate();
		}

		for (int i = 0; i < BaiFenBi; i++) {
			StatisticNum[1][i] = userInfoList.get(i).getProjectInvolved();
		}

		// 统计
		int CreatAll = 0;
		int InvolveAll = 0;
		for (int i = 0; i < BaiFenBi; i++) {
			CreatAll += StatisticNum[0][i];
			InvolveAll += StatisticNum[1][i];
		}
		// 求平均值
		double CreatAve = ((double) CreatAll) / ((double) BaiFenBi);
		double InvolveAve = ((double) InvolveAll) / ((double) BaiFenBi);

		// 计算参数A
		double tempA = 0.0;
		for (int i = 0; i < BaiFenBi; i++) {
			tempA += (StatisticNum[0][i]) * (StatisticNum[1][i]);
		}
		// 以Star值为X坐标
		double tempB = 0.0;
		for (int i = 0; i < BaiFenBi; i++) {
			tempB += Math.pow(StatisticNum[0][i], 2);
		}

		double ParameterA = (double) (tempA - (BaiFenBi * CreatAve * InvolveAve))
				/ (double) (tempB - (BaiFenBi * Math.pow(CreatAve, 2)));
		double ParameterB = InvolveAve - ParameterA * CreatAve;

		ScatterDiagramStatistic scatterDiagramStatistic = new ScatterDiagramStatistic(ParameterA, ParameterB,
				StatisticNum);
		return scatterDiagramStatistic;
	}
}
