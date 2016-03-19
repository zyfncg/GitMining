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
	public List<ProjectDetail> getStatisticRepositoryInfo() throws Exception;
	/**
	 *description: 保存项目统计数据
	 * 前置条件：无
	 * 后置条件：返回保存结果
	 * @return boolean：保存结果；成功true；失败false
	 */
	public boolean setStatisticInfo(SaveRepositoryStatisticInfo saveRepository);
	
//取得统计好的数据
	/**
	 *description: 取得全部项目统计数据
	 * 前置条件：无
	 * 后置条件：返回项目统计结果的数据
	 * @return 返回项目统计结果，若无，返回null
	 * @throws Exception 
	 */
	public SaveRepositoryStatisticInfo GetStatisticedInfo() throws Exception;
	
//设置雷达图相关数据
	/**
	 *description: 取得全部项目详细信息列表
	 * 前置条件：无
	 * 后置条件：返回全部项目详细信息列表
	 * @return 返回全部项目详细信息列表，若无，返回null
	 * @throws Exception 
	 */
	public List<ProjectDetail> getDetailRepositoryInfo() throws Exception;
	
	/**
	 *description: 保存项目统计后数据（雷达图）
	 * 前置条件：无
	 * 后置条件：返回保存结果
	 * @return boolean：保存结果；成功true；失败false
	 */
	public boolean setDetailStatisticInfo(List<ProjectDetail> list);
}
