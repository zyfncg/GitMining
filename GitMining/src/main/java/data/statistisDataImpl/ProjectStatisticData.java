package data.statistisDataImpl;

import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import data.dataImpl.FileUtil;
import data.statisticServer.RepositoryStatisticsDataServer;

public class ProjectStatisticData implements RepositoryStatisticsDataServer{

	@Override
	public List<ProjectDetail> getStatisticRepositoryInfo() throws Exception {
		// TODO Auto-generated method stub
		FileUtil proFile=new FileUtil();
		
		List<ProjectDetail> proList = null;
		try {
			proList=proFile.getProjectDetailListFromFile();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return proList;
	}

	@Override
	public boolean setStatisticInfo(SaveRepositoryStatisticInfo saveRepository) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SaveRepositoryStatisticInfo GetStatisticedInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDetailStatisticInfo(List<ProjectDetail> list) {
		
		FileUtil proFile=new FileUtil();
		
		if(!proFile.setProjectDetailToFile(list)){
			return false;
		}
		return false;
	}

}
