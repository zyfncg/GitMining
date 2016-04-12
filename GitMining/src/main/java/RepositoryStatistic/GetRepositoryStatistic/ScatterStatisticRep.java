package RepositoryStatistic.GetRepositoryStatistic;

import java.util.List;

import Info.ProjectInfo;
import Info.ScatterDiagramStatistic;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class ScatterStatisticRep {

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
		
		//二维double值，先Star后Fork
		double[][] StatisticNum = new double[2][projectInfoList.size()];
		for(int i=0;i<projectInfoList.size();i++){
			StatisticNum[0][i] = projectInfoList.get(i).getStars();
		}
		for(int i=0;i<projectInfoList.size();i++){
			StatisticNum[1][i] = projectInfoList.get(i).getForks();
		}
		
		//
		int StarAll = 0;
		int ForkAll = 0;
		for(int i=0;i<projectInfoList.size();i++){
			StarAll+=projectInfoList.get(i).getStars();
			ForkAll+=projectInfoList.get(i).getForks();
		}
		
		double StarAve = ((double)StarAll) / ((double)(projectInfoList.size()));
		double ForkAve = ((double)ForkAll) / ((double)(projectInfoList.size()));
		
		//计算参数A
		double tempA = 0.0;
		for(int i=0;i<projectInfoList.size();i++){
			tempA += (StatisticNum[0][i])*(StatisticNum[1][i]);
		}
		//以Star值为X坐标
		double tempB = 0.0;
		for(int i=0;i<projectInfoList.size();i++){
			tempB += Math.pow(StatisticNum[0][i], 2);
		}
		
		double ParameterA = (double)(tempA-(projectInfoList.size()*StarAve*ForkAve)) / (double)(tempB-(projectInfoList.size()*Math.pow(StarAve, 2)));
		double ParameterB = ForkAve - ParameterA*StarAve;
		
		ScatterDiagramStatistic scatterDiagramStatistic = new ScatterDiagramStatistic(ParameterA, ParameterB, StatisticNum);
		return scatterDiagramStatistic;
	}
}
