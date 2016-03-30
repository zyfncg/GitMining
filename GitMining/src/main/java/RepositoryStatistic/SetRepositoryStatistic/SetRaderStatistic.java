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
		double maxContributor = 1.0;
		double maxStar = 1.0;
		double maxCommit = 1.0;
		double maxIssue = 1.0;
		double maxPullRequest = 1.0;
		double maxSize = 1.0;

		// 统计之后的各个项目的统计数据

		for (ProjectDetail oneProject : allProjectsDetailInfo) {
			if (oneProject.getContributors() > maxContributor) {
				maxContributor = (double)oneProject.getContributors();
			}
			if (oneProject.getStars() > maxStar) {
				maxStar = (double)oneProject.getStars();
			}
			if (oneProject.getCommit() > maxCommit) {
				maxCommit = (double)oneProject.getCommit();
			}
			if (oneProject.getIssue() > maxIssue) {
				maxIssue = (double)oneProject.getIssue();
			}
			if (oneProject.getPullRequest() > maxPullRequest) {
				maxPullRequest = (double)oneProject.getPullRequest();
			}
			if (oneProject.getSize() > maxSize) {
				maxSize = (double)oneProject.getSize();
			}
		}
		for (ProjectDetail anProject : allProjectsDetailInfo) {
			double ContributorStatistic = Double.parseDouble(df.format( ((double)(anProject.getContributors())) / maxContributor));
			double StarStatistic = Double.parseDouble(df.format( ((double)(anProject.getStars())) / maxStar));
			double CommitStatistic = Double.parseDouble(df.format( ((double)(anProject.getCommit())) / maxCommit));
			double IssueStatistic = Double.parseDouble(df.format( ((double)(anProject.getIssue())) / maxIssue));
			double PullRequestStatistic = Double.parseDouble(df.format( ((double)(anProject.getPullRequest())) / maxPullRequest));
			double SizeStatistic = Double.parseDouble(df.format( ((double)(anProject.getSize())) / maxSize));
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
