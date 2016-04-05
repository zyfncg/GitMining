package RepositoryStatistic.GetRepositoryStatistic.HistogramDetail;

import java.util.List;

import Info.HistogramInfo;
import Info.ProjectInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class HistogramStatisticFork implements HistogramStatisticRep {

	public HistogramInfo getRepHistogramInfo() {
		// 取得全部项目粗略信息列表
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = repositoryHandle.getallProjects();

		// 从全部的项目中搜索出最大Star与最小Star
		int maxFork = projectInfoList.get(0).getForks();
		int minFork = projectInfoList.get(0).getForks();

		for (ProjectInfo tempProject : projectInfoList) {
			if (tempProject.getForks() > maxFork) {
				maxFork = tempProject.getForks();
			} else if (tempProject.getForks() < minFork) {
				minFork = tempProject.getForks();
			}
		}
		
		//求出组数
		int GroupNum = 1 + (int)( (Math.log10(projectInfoList.size())) / (Math.log10(2)) );
		
		//全部Fork
		double[] allForkInfo = new double[projectInfoList.size()];
		for(int i=0;i<projectInfoList.size();i++){
			allForkInfo[i] = projectInfoList.get(i).getForks();
		}

		//创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxFork, minFork, GroupNum, allForkInfo);
		return histogramInfo;
	}

}
