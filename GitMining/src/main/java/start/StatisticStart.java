package start;

import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class StatisticStart {

	public static void main(String[] args) {
		AllRepositoryStatistic tryRepositoryStatistic = new AllRepositoryStatistic();
		AllUserStatistic tryUserStatistic = new AllUserStatistic();
		tryRepositoryStatistic.RepositoryAnalyze();
		tryUserStatistic.UserAnalyze();
	}
}
