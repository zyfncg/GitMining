package StatisticData.StatisticServer;

import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;

public interface RepositoryStatisticsDataServer {

	//设置统计数据
	/**
	 *description: 取得全部的详细项目信息列表
	 * 前置条件：无
	 * 后置条件：返回详细项目信息列表
	 * @return 返回项目信息列表，若无(返回null)
	 * @throws Exception 
	 */
	public List<ProjectDetail> getStatisticInfo() throws Exception;
	
	public boolean setStatisticInfo(SaveRepositoryStatisticInfo saveRepository);
	
	//取得统计好的数据
	public SaveRepositoryStatisticInfo GetStatisticedInfo() throws Exception;
	
	//设置雷达图相关数据
	public List<ProjectDetail> getDetailStatisticInfo() throws Exception;
	
	public boolean setDetailStatisticInfo(List<ProjectDetail> list);
}
