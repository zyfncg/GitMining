package StatisticData.StatisticServer;

import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.RepositoryStatisticInfo;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;

public interface RepositoryStatisticsDataServer {

	//设置统计数据
	public List<RepositoryStatisticInfo> getStatisticInfo();
	
	public boolean setStatisticInfo(SaveRepositoryStatisticInfo saveRepository);
	
	//取得统计好的数据
	public SaveRepositoryStatisticInfo GetStatisticedInfo();
	
	//设置雷达图相关数据
	public List<ProjectDetail> getDetailStatisticInfo();
	
	public boolean setDetailStatisticInfo(List<ProjectDetail> list);
}
