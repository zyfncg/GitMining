package RepositoryStatistic.GetRepositoryStatistic.HistogramDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.HistogramInfo;
import Info.ProjectInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import businessLogic.businessLogicModel.RepositoryModel.RepositoryHandle;

public class HistogramStatisticFork implements HistogramStatisticRep {

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

		// 从全部的项目中搜索出最大Fork与最小Fork
		int maxFork = projectInfoList.get(0).getForks();
		int minFork = projectInfoList.get(0).getForks();

		for (ProjectInfo tempProject : projectInfoList) {
			if (tempProject.getForks() > maxFork) {
				maxFork = tempProject.getForks();
			} else if (tempProject.getForks() < minFork) {
				minFork = tempProject.getForks();
			}
		}

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(projectInfoList.size())) / (Math.log10(2)));

		// 全部Fork
		double[] allForkInfo = new double[projectInfoList.size()];
		for (int i = 0; i < projectInfoList.size(); i++) {
			allForkInfo[i] = projectInfoList.get(i).getForks();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxFork, minFork, GroupNum, allForkInfo);
		return histogramInfo;
	}

	public HistogramInfo getSmallRepHistogramInfo() {
		//取得全部的数据
		List<ProjectInfo> projectInfoList = this.getSortedProject();

		List<ProjectInfo> smallRepHis = new ArrayList<ProjectInfo>();
		for (int i = 0; i < (int)(projectInfoList.size() * 0.9); i++) {
			smallRepHis.add(projectInfoList.get(i));
		}

		// 从全部的项目中搜索出最大Fork与最小Fork
		int maxFork = smallRepHis.get(smallRepHis.size() - 1).getForks();
		int minFork = smallRepHis.get(0).getForks();

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(smallRepHis.size())) / (Math.log10(2)));

		// 全部Fork
		double[] allForkInfo = new double[smallRepHis.size()];
		for (int i = 0; i < smallRepHis.size(); i++) {
			allForkInfo[i] = smallRepHis.get(i).getForks();
		}
		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxFork, minFork, GroupNum, allForkInfo);
		
		return histogramInfo;
	}

	public HistogramInfo getBigRepHistogramInfo() {
		//去的全部的数据
		List<ProjectInfo> projectInfoList = this.getSortedProject();

		List<ProjectInfo> bigRepHis = new ArrayList<ProjectInfo>();
		for (int i = (int) (projectInfoList.size() * 0.9); i < (projectInfoList.size()); i++) {
			bigRepHis.add(projectInfoList.get(i));
		}

		// 从全部的项目中搜索出最大Fork与最小Fork
		int maxFork = bigRepHis.get(bigRepHis.size() - 1).getForks();
		int minFork = bigRepHis.get(0).getForks();

		// 求出组数
		int GroupNum = 1 + (int) ((Math.log10(bigRepHis.size())) / (Math.log10(2)));

		// 全部Fork
		double[] allForkInfo = new double[bigRepHis.size()];
		for (int i = 0; i < bigRepHis.size(); i++) {
			allForkInfo[i] = bigRepHis.get(i).getForks();
		}
		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(maxFork, minFork, GroupNum, allForkInfo);
		
		return histogramInfo;
	}
	
	//对projectInfoList排序，按从小到大的顺序
	public List<ProjectInfo> getSortedProject(){
		RepositoryHandle repositoryHandle = new RepositoryHandle();
		List<ProjectInfo> projectInfoList = null;

		try {
			projectInfoList = repositoryHandle.GetAllRepositorys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.sort(projectInfoList, new Comparator<ProjectInfo>() {
			@Override
			public int compare(ProjectInfo arg0, ProjectInfo arg1) {
				return (new Integer(arg0.getForks())).compareTo(new Integer(arg1.getForks()));
			}
		});
		
		return projectInfoList;
	}

}
