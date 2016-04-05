package RepositoryStatistic.GetRepositoryStatistic;

import Info.HistogramInfo;

public interface HistogramStatisticRep {

	/**
	 *description: 取得全部的直方图项目信息
	 * 前置条件：无
	 * 后置条件：返回直方图项目信息
	 * @return 返回直方图项目信息
	 */
	public HistogramInfo getRepHistogramInfo();
}
