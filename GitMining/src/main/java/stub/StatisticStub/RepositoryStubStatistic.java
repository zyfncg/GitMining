package stub.StatisticStub;

import java.util.ArrayList;
import java.util.List;

import Info.RepStatisticInfo.ContributorStatistics;
import Info.RepStatisticInfo.ForkStatistics;
import Info.RepStatisticInfo.LanguageStatistics;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import Info.RepStatisticInfo.StarStatistics;
import Info.RepStatisticInfo.TimeStatistics;

public class RepositoryStubStatistic {

	public SaveRepositoryStatisticInfo GetStatisticedInfo() throws Exception {

		List<ForkStatistics> forkResult = new ArrayList<ForkStatistics>();
		List<LanguageStatistics> languageResult = new ArrayList<LanguageStatistics>();
		List<ContributorStatistics> contributorResult = new ArrayList<ContributorStatistics>();
		List<StarStatistics> starResult = new ArrayList<StarStatistics>();
		List<TimeStatistics> timeResult = new ArrayList<TimeStatistics>();

		for (int i = 0; i < 7; i++) {
			ForkStatistics forkStatistics = new ForkStatistics("GG", 10);
			forkResult.add(forkStatistics);
		}
		for (int i = 0; i < 7; i++) {
			LanguageStatistics languageStatistics = new LanguageStatistics("java", i, 12.0);
			languageResult.add(languageStatistics);
		}
		for (int i = 0; i < 7; i++) {
			ContributorStatistics contributorStatistics = new ContributorStatistics();
			contributorResult.add(contributorStatistics);
		}
		for (int i = 0; i < 7; i++) {
			StarStatistics starStatistics = new StarStatistics("GL", i);
			starResult.add(starStatistics);
		}
		for (int i = 0; i < 7; i++) {
			TimeStatistics timeStatistics = new TimeStatistics("1995", i);
			timeResult.add(timeStatistics);
		}

		SaveRepositoryStatisticInfo saveRepositoryStatisticInfo = new SaveRepositoryStatisticInfo(timeResult,
				languageResult, forkResult, starResult, contributorResult);
		return saveRepositoryStatisticInfo;
	}
}
