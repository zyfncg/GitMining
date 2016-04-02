package UserStatistic.GetUserStatistic;

import Info.HistogramInfo;

public interface HistogramStatisticUser {

	/**
	 *description: 取得全部的直方图用户信息
	 * 前置条件：无
	 * 后置条件：返回直方图用户信息
	 * @return 返回直方图用户信息
	 */
	public HistogramInfo getUsrHistogramInfo();
}
