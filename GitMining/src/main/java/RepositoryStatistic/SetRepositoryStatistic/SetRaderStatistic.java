package RepositoryStatistic.SetRepositoryStatistic;

import java.text.DecimalFormat;
import java.util.List;

import Info.ProjectDetail;
import Info.StatisticDetail;
import data.statisticServer.RepositoryStatisticsDataServer;
import data.statistisDataImpl.ProjectStatisticData;

public class SetRaderStatistic {

	public void DetailRaderStatistic() {
		RepositoryStatisticsDataServer RepStatisticsDataServer = new ProjectStatisticData();
		AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
		List<ProjectDetail> allProjectsDetailInfo = allRepositoryStatistic.getStatisticRepositoryInfo();

		DecimalFormat df = new DecimalFormat("######0.00");
		// 每个项目的最大值
		int maxContributor = 1;
		int maxStar = 1;
		long maxCommit = 1;
		int maxIssue = 1;
		int maxPullRequest = 1;
		int maxSize = 1;

		// 统计之后的各个项目的统计数据

		for (ProjectDetail oneProject : allProjectsDetailInfo) {
			if (oneProject.getContributors() > maxContributor) {
				maxContributor = oneProject.getContributors();
			}
			if (oneProject.getStars() > maxStar) {
				maxStar = oneProject.getStars();
			}
			if (oneProject.getCommit() > maxCommit) {
				maxCommit = oneProject.getCommit();
			}
			if (oneProject.getIssue() > maxIssue) {
				maxIssue = oneProject.getIssue();
			}
			if (oneProject.getPullRequest() > maxPullRequest) {
				maxPullRequest = oneProject.getPullRequest();
			}
			if (oneProject.getSize() > maxSize) {
				maxSize = oneProject.getSize();
			}
		}
		for (ProjectDetail anProject : allProjectsDetailInfo) {
			double ContributorStatistic = Double.parseDouble(df.format((anProject.getContributors()) / maxContributor));
			double StarStatistic = Double.parseDouble(df.format((anProject.getStars()) / maxStar));
			double CommitStatistic = Double.parseDouble(df.format((anProject.getCommit()) / maxCommit));
			double IssueStatistic = Double.parseDouble(df.format((anProject.getIssue()) / maxIssue));
			double PullRequestStatistic = Double.parseDouble(df.format((anProject.getPullRequest()) / maxPullRequest));
			double SizeStatistic = Double.parseDouble(df.format((anProject.getSize()) / maxSize));
			double TotalStatistic = ContributorStatistic + StarStatistic + CommitStatistic + IssueStatistic
					+ PullRequestStatistic + SizeStatistic;
			StatisticDetail detail = new StatisticDetail(StarStatistic, ContributorStatistic, CommitStatistic,
					IssueStatistic, PullRequestStatistic, SizeStatistic, TotalStatistic);
			anProject.setStatisticDetail(detail);
		}
		
		boolean result = RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		if (!result) {
			RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		}
		else{
			System.out.println("Radersuccess");
		}

	}
}
