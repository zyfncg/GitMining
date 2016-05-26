package data.dataImpl.statistisDataImpl;

import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import data.dataImpl.DBUtil;
import data.dataImpl.ProjectStatisticDB;
import data.dataServer.statisticServer.RepositoryStatisticsDataServer;

public class ProjectStatisticData implements RepositoryStatisticsDataServer{

	@Override
	public List<ProjectDetail> getStatisticRepositoryInfo() throws Exception {
//		FileUtil proUtil=new FileUtil();
		DBUtil proUtil=new DBUtil();
		
		List<ProjectDetail> proList = null;
		try {
			proList=proUtil.getProjectDetailList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return proList;
	}

	@Override
	public boolean setStatisticInfo(SaveRepositoryStatisticInfo saveRepository) {
		StatisticFile statisticFile=new StatisticFile();
		return statisticFile.saveProjectStatisticData(saveRepository);
	}

	@Override
	public SaveRepositoryStatisticInfo GetStatisticedInfo() throws Exception{
		StatisticFile statisticFile=new StatisticFile();
		SaveRepositoryStatisticInfo repoStatistic;
		System.out.println("++++++++++");
		try {
			repoStatistic=statisticFile.getProjectStatisticData();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		return repoStatistic;
	}

	@Override
	public boolean setDetailStatisticInfo(List<ProjectDetail> list) {
		
		
		ProjectStatisticDB statisticUtil=new ProjectStatisticDB();
		if(!statisticUtil.saveProjectStatis(list)){
			return false;
		}
//		FileUtil statisticUtil=new FileUtil();
//		if(!statisticUtil.saveProjectDetail(list)){
//			return false;
//		}
		return true;
	}

}
