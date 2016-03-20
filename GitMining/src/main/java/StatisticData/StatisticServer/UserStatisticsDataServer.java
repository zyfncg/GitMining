package StatisticData.StatisticServer;

import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;

public interface UserStatisticsDataServer {

//设置统计数据
	/**
	 *description: 取得全部的详细用户信息列表
	 * 前置条件：无
	 * 后置条件：返回全部详细用户信息列表
	 * @return 返回用户详细信息列表，若无(返回null)
	 * @throws Exception 
	 */
	public List<UserInfoDetail> getStatisticUsersInfo() throws Exception;
	/**
	 *description: 保存用户的统计数据
	 * 前置条件：无
	 * 后置条件：返回保存结果
	 * @return boolean：保存结果；成功true；失败false
	 */
	public boolean setStatisticInfo(SaveUserStatisticInfo saveUser);
	
//取得统计好的数据
	/**
	 *description: 取得全部用户统计后的数据
	 * 前置条件：无
	 * 后置条件：返回全部用户统计结果的数据
	 * @return 返回用户信息统计结果，若无，返回null
	 * @throws Exception 
	 */
	public SaveUserStatisticInfo GetStatisticedInfo() throws Exception;
}
