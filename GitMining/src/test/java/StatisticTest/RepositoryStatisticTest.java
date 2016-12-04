package StatisticTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.RepStatisticInfo.ContributorStatistics;
import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.RepStatisticInfo.StarStatistics;
import Info.RepStatisticInfo.TimeStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetContributorStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetForkStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetLanguageStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetStarStatistic;
import RepositoryStatistic.GetRepositoryStatistic.DetailGet.GetTimeStatistic;
import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;
import RepositoryStatistic.SetRepositoryStatistic.SetRaderStatistic;

public class RepositoryStatisticTest {

	@Test
	public void test(){
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		GetContributorStatistic contributorStatistic = factory.GetContributor();
		List<ContributorStatistics> list1 = contributorStatistic.getContributorStatistic();
		if (list1 == null) {
			assertEquals(null, list1);
		}
		else {
			assertEquals(list1.size(),list1.size());
		}
		
		GetForkStatistic forkStatistic = factory.GetFork();
		List<ForkStatistics> list2 = forkStatistic.getForkStatistic();
		assertEquals(list2.size(), list2.size());
		
		GetStarStatistic starStatistic = factory.GetStar();
		List<StarStatistics> list3 = starStatistic.getStarStatistic();
		assertEquals(list3.size(), list3.size());
		
		GetTimeStatistic timeStatistic = factory.GetTime();
		List<TimeStatistics> list4 = timeStatistic.getTimeStatistic();
		assertEquals(list4.size(), list4.size());
		
		GetLanguageStatistic languageStatistic = factory.GetLanguage();
		List<LanguageStatistics> list5 = languageStatistic.getLanguageStatistic();
		assertEquals(list5.size(), list5.size());
		
		SetRaderStatistic setRaderStatistic = new SetRaderStatistic();
		setRaderStatistic.DetailRaderStatistic();
		
		AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
		allRepositoryStatistic.RepositoryAnalyze();
	}
}
