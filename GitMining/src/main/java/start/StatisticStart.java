package start;

import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;
import RepositoryStatistic.SetRepositoryStatistic.SetRaderStatistic;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class StatisticStart {

	public static void main(String[] args) {
		AllRepositoryStatistic tryRepositoryStatistic = new AllRepositoryStatistic();
		AllUserStatistic tryUserStatistic = new AllUserStatistic();
		SetRaderStatistic tryRaderStatistic = new SetRaderStatistic();
		tryRepositoryStatistic.RepositoryAnalyze();
		tryUserStatistic.UserAnalyze();
		tryRaderStatistic.DetailRaderStatistic();
	}
}
