package RepositoryStatistic;

import RepositoryStatistic.SetRepositoryStatistic.AllRepositoryStatistic;
import RepositoryStatistic.SetRepositoryStatistic.SetRaderStatistic;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class Iterater2main {

	public static void main(String[] args) {
		AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
		allRepositoryStatistic.RepositoryAnalyze();
		SetRaderStatistic setRaderStatistic = new SetRaderStatistic();
		setRaderStatistic.DetailRaderStatistic();
		AllUserStatistic allUserStatistic = new AllUserStatistic();
		allUserStatistic.UserAnalyze();
	}
}
