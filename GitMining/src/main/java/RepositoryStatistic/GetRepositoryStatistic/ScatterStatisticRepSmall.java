package RepositoryStatistic.GetRepositoryStatistic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectInfo;
import Info.ScatterDiagramStatistic;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class ScatterStatisticRepSmall {

	public ScatterDiagramStatistic getRepScatterInfo() {
		// 取得全部项目粗略信息列表
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = null;

		try {
			projectInfoList = repositoryHandle.GetAllRepositorys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 常量，取全部数据的百分比
		int BaiFenBi = (int) ((projectInfoList.size()) * (0.7));

		// 二维double值，先Star后Fork
		double[][] StatisticNum = new double[2][projectInfoList.size()];
		// 添加Star值
			//按Star对项目进行排序
		Collections.sort(projectInfoList, new Comparator<ProjectInfo>() {
			@Override
			public int compare(ProjectInfo arg0, ProjectInfo arg1) {
				return (new Integer(arg0.getStars())).compareTo(new Integer(arg1.getStars()));
			}
		});

		for (int i = 0; i < BaiFenBi; i++) {
			StatisticNum[0][i] = projectInfoList.get(i).getStars();
		}

		// 添加Fork值
		// Collections.sort(projectInfoList, new Comparator<ProjectInfo>() {
		// @Override
		// public int compare(ProjectInfo arg0, ProjectInfo arg1) {
		// return (new Integer(arg0.getForks())).compareTo(new
		// Integer(arg1.getForks()));
		// }
		// });

		for (int i = 0; i < BaiFenBi; i++) {
			StatisticNum[1][i] = projectInfoList.get(i).getForks();
		}

		// 统计
		int StarAll = 0;
		int ForkAll = 0;
		for (int i = 0; i < BaiFenBi; i++) {
			StarAll += StatisticNum[0][i];
			ForkAll += StatisticNum[1][i];
		}
		// 求平均值
		double StarAve = ((double) StarAll) / ((double) BaiFenBi);
		double ForkAve = ((double) ForkAll) / ((double) BaiFenBi);

		// 计算参数A
		double tempA = 0.0;
		for (int i = 0; i <BaiFenBi; i++) {
			tempA += (StatisticNum[0][i]) * (StatisticNum[1][i]);
		}
		// 以Star值为X坐标
		double tempB = 0.0;
		for (int i = 0; i < BaiFenBi; i++) {
			tempB += Math.pow(StatisticNum[0][i], 2);
		}

		double ParameterA = (double) (tempA - (BaiFenBi * StarAve * ForkAve))
				/ (double) (tempB - (BaiFenBi * Math.pow(StarAve, 2)));
		double ParameterB = ForkAve - ParameterA * StarAve;

		ScatterDiagramStatistic scatterDiagramStatistic = new ScatterDiagramStatistic(ParameterA, ParameterB,
				StatisticNum);
		return scatterDiagramStatistic;
	}
}
