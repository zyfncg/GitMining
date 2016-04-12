package RepositoryStatistic.GetRepositoryStatistic.HistogramDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.HistogramInfo;
import Info.ProjectInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class HistogramStatisticStar implements HistogramStatisticRep {

	public HistogramInfo getRepHistogramInfo() {
		// 取得全部项目粗略信息列表
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = null;

		try {
			projectInfoList = repositoryHandle.GetAllRepositorys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 从全部的项目中搜索出最大Star与最小Star
		int maxStar = projectInfoList.get(0).getStars();
		int minStar = projectInfoList.get(0).getStars();

		for (ProjectInfo tempProject : projectInfoList) {
			if (tempProject.getStars() > maxStar) {
				maxStar = tempProject.getStars();
			} else if (tempProject.getStars() < minStar) {
				minStar = tempProject.getStars();
			}
		}

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(projectInfoList.size())) / (Math.log10(2)));

		// 全部Star
		double[] allStarInfo = new double[projectInfoList.size()];
		for (int i = 0; i < projectInfoList.size(); i++) {
			allStarInfo[i] = projectInfoList.get(i).getStars();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxStar, minStar, GroupNum, allStarInfo);
		return histogramInfo;
	}

	public HistogramInfo getSmallRepHistogramInfo() {
		// 取得全部项目粗略信息列表
		List<ProjectInfo> projectInfoList = this.getSortedProject();

		List<ProjectInfo> smallRepHis = new ArrayList<ProjectInfo>();
		for (int i = 0; i < (int) (projectInfoList.size() * 0.9); i++) {
			smallRepHis.add(projectInfoList.get(i));
		}

		// 从全部的项目中搜索出最大Star与最小Star
		int maxStar = smallRepHis.get(smallRepHis.size() - 1).getStars();
		int minStar = smallRepHis.get(0).getStars();

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(smallRepHis.size())) / (Math.log10(2)));

		// 全部Star
		double[] allStarInfo = new double[smallRepHis.size()];
		for (int i = 0; i < smallRepHis.size(); i++) {
			allStarInfo[i] = smallRepHis.get(i).getStars();
		}
		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxStar, minStar, GroupNum, allStarInfo);

		return histogramInfo;
	}

	public HistogramInfo getBigRepHistogramInfo() {
		// 取得全部项目粗略信息列表
		List<ProjectInfo> projectInfoList = this.getSortedProject();

		List<ProjectInfo> bigRepHis = new ArrayList<ProjectInfo>();
		for (int i = (int) (projectInfoList.size() * 0.9); i < (projectInfoList.size()); i++) {
			bigRepHis.add(projectInfoList.get(i));
		}

		// 从全部的项目中搜索出最大Star与最小Star
		int maxStar = bigRepHis.get(bigRepHis.size() - 1).getStars();
		int minStar = bigRepHis.get(0).getStars();

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(bigRepHis.size())) / (Math.log10(2)));

		// 全部Star
		double[] allStarInfo = new double[bigRepHis.size()];
		for (int i = 0; i < bigRepHis.size(); i++) {
			allStarInfo[i] = bigRepHis.get(i).getStars();
		}
		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxStar, minStar, GroupNum, allStarInfo);

		return histogramInfo;
	}

	public List<ProjectInfo> getSortedProject() {
		// 取得全部项目粗略信息列表
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = null;

		try {
			projectInfoList = repositoryHandle.GetAllRepositorys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 按Star从小到大排序
		Collections.sort(projectInfoList, new Comparator<ProjectInfo>() {
			@Override
			public int compare(ProjectInfo arg0, ProjectInfo arg1) {
				return (new Integer(arg0.getStars())).compareTo(new Integer(arg1.getStars()));
			}
		});

		return projectInfoList;
	}
}
