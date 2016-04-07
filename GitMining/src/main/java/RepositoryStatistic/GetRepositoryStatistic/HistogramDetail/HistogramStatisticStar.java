package RepositoryStatistic.GetRepositoryStatistic.HistogramDetail;

import java.util.List;

import Info.HistogramInfo;
import Info.ProjectInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class HistogramStatisticStar implements HistogramStatisticRep{

	public HistogramInfo getRepHistogramInfo() {
		//取得全部项目粗略信息列表
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = null;

		try {
			projectInfoList = repositoryHandle.GetAllRepositorys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//从全部的项目中搜索出最大Star与最小Star
		int maxStar = projectInfoList.get(0).getStars();
		int minStar = projectInfoList.get(0).getStars();
		
		for(ProjectInfo tempProject:projectInfoList){
			if (tempProject.getStars()>maxStar) {
				maxStar = tempProject.getStars();
			}
			else if(tempProject.getStars()<minStar){
				minStar = tempProject.getStars();
			}
		}
		
		//求出组数
		int GroupNum = 1 + (int)( (Math.log10(projectInfoList.size())) / (Math.log10(2)) );
		
		//全部Star
		double[] allStarInfo = new double[projectInfoList.size()];
		for(int i=0;i<projectInfoList.size();i++){
			allStarInfo[i] = projectInfoList.get(i).getStars();
		}
		
		//创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxStar, minStar, GroupNum, allStarInfo);
		return histogramInfo;
	}

}
