package RepositoryStatistic.SetRepositoryStatistic;

import java.util.ArrayList;
import java.util.List;

import Info.ProjectDetail;
import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import Info.RepStatisticInfo.StarStatistics;
import Info.RepStatisticInfo.TimeStatistics;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetForkStatistic;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetLanguageStatistic;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetStarStatisitc;
import RepositoryStatistic.SetRepositoryStatistic.DetailAnalyze.SetTimeStatistic;
import data.statisticServer.RepositoryStatisticsDataServer;
import data.statistisDataImpl.ProjectStatisticData;

public class AllRepositoryStatistic {

	private RepositoryStatisticsDataServer repositoryStatisticsDataServer = new ProjectStatisticData();
	private RepStatisticsFactory repStatisticsFactory = new RepStatisticsFactory();

	public void RepositoryAnalyze() {
		// 取得所有的项目List
		List<ProjectDetail> allList = this.getStatisticRepositoryInfo();

//		System.out.println(allList.get(0).getStars());
		// 进行Fork排序
		SetForkStatistic forkStatistic = repStatisticsFactory.getForkObject();
		List<ForkStatistics> forkResult = forkStatistic.makeForkStatistic(allList);
		// 进行Language排序
		SetLanguageStatistic languageStatistic = repStatisticsFactory.getLanguageObject();
		List<LanguageStatistics> languageResult = languageStatistic.makeLanguageStatistic(allList);
		// 进行Star排序
		SetStarStatisitc starStatisitc = repStatisticsFactory.getStarObject();
		List<StarStatistics> starResult = starStatisitc.makeStarStatistics(allList);
		// 进行Time排序
		SetTimeStatistic timeStatistic = repStatisticsFactory.getTimeObject();
		List<TimeStatistics> timeResult = timeStatistic.makeTimeStatistic(allList);

		// 创建保存到Txt中的对象
		SaveRepositoryStatisticInfo saveRepositoryStatisticInfo = new SaveRepositoryStatisticInfo(timeResult,
				languageResult, forkResult, starResult, null);
		
		//进行保存
		boolean SaveResult = repositoryStatisticsDataServer.setStatisticInfo(saveRepositoryStatisticInfo);
		if (!SaveResult) {
			repositoryStatisticsDataServer.setStatisticInfo(saveRepositoryStatisticInfo);
		}
	}

	public List<ProjectDetail> getStatisticRepositoryInfo() {
		List<ProjectDetail> StatisticInfo = new ArrayList<ProjectDetail>();
		try {
			StatisticInfo = repositoryStatisticsDataServer.getStatisticRepositoryInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StatisticInfo;
	}
}
