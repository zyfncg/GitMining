package RepositoryStatistic.SetRepositoryStatistic;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
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

		// 项目总数
		int SizeNum = allProjectsDetailInfo.size();
		// 每一挡的项目数量
		int tenth = (int) (SizeNum * 0.05);
		int ninth = (int) (SizeNum * 0.15);
		int eighth = (int) (SizeNum * 0.25);
		int seventh = (int) (SizeNum * 0.35);
		int sixth = (int) (SizeNum * 0.5);
		int fifth = (int) (SizeNum * 0.65);
		int forth = (int) (SizeNum * 0.75);
		int third = (int) (SizeNum * 0.85);
		int second = (int) (SizeNum * 0.95);

		DecimalFormat df = new DecimalFormat("######0.00");
		// 1.
		// Contributor统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getContributors())).compareTo(new Integer(arg0.getContributors()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 1, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.9, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.8, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.7, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.6, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.5, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.4, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.3, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.2, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = new StatisticDetail(0, 0.1, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		// 2.
		// Star统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getStars())).compareTo(new Integer(arg0.getStars()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(1);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.9);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.8);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.7);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.6);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.5);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.4);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.3);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.2);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.1);
		}
		// 3.
		// Commit统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Long(arg1.getCommit())).compareTo(new Long(arg0.getCommit()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(1);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.9);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.8);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.7);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.6);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.5);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.4);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.3);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.2);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.1);
		}
		// 4.
		// Issue统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getIssue())).compareTo(new Integer(arg0.getIssue()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(1);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.9);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.8);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.7);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.6);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.5);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.4);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.3);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.2);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.1);
		}
		// 5.
		// PullRequest的统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getPullRequest())).compareTo(new Integer(arg0.getPullRequest()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(1);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.9);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.8);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.7);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.6);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.5);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.4);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.3);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.2);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.1);
		}
		// 6.
		// Size的统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getSize())).compareTo(new Integer(arg0.getSize()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(1);
		}
		for (int i = tenth; i < ninth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.9);
		}
		for (int i = ninth; i < eighth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.8);
		}
		for (int i = eighth; i < seventh; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.7);
		}
		for (int i = seventh; i < sixth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.6);
		}
		for (int i = sixth; i < fifth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.5);
		}
		for (int i = fifth; i < forth; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.4);
		}
		for (int i = forth; i < third; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.3);
		}
		for (int i = third; i < second; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.2);
		}
		for (int i = second; i < SizeNum; i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.1);
		}

		// 设置total
		for (int i = 0; i < allProjectsDetailInfo.size(); i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setTotalStatistic(
					detail.getCommitStatistic() + detail.getContributorStatistic() + detail.getIssueStatistic()
							+ detail.getPullRequestStatistic() + detail.getSizeStatistic() + detail.getStarStatistic());
		}

		// 保存
		boolean result = RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		if (!result) {
			RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		} else {
			System.out.println("Radersuccess");
		}

		// // 每个项目的最大值
		// double maxContributor = 1.0;
		// double maxStar = 1.0;
		// double maxCommit = 1.0;
		// double maxIssue = 1.0;
		// double maxPullRequest = 1.0;
		// double maxSize = 1.0;
		//
		// // 统计之后的各个项目的统计数据
		//
		// for (ProjectDetail oneProject : allProjectsDetailInfo) {
		// if (oneProject.getContributors() > maxContributor) {
		// maxContributor = (double)oneProject.getContributors();
		// }
		// if (oneProject.getStars() > maxStar) {
		// maxStar = (double)oneProject.getStars();
		// }
		// if (oneProject.getCommit() > maxCommit) {
		// maxCommit = (double)oneProject.getCommit();
		// }
		// if (oneProject.getIssue() > maxIssue) {
		// maxIssue = (double)oneProject.getIssue();
		// }
		// if (oneProject.getPullRequest() > maxPullRequest) {
		// maxPullRequest = (double)oneProject.getPullRequest();
		// }
		// if (oneProject.getSize() > maxSize) {
		// maxSize = (double)oneProject.getSize();
		// }
		// }
		// for (ProjectDetail anProject : allProjectsDetailInfo) {
		// double ContributorStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getContributors())) / maxContributor));
		// double StarStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getStars())) / maxStar));
		// double CommitStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getCommit())) / maxCommit));
		// double IssueStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getIssue())) / maxIssue));
		// double PullRequestStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getPullRequest())) / maxPullRequest));
		// double SizeStatistic = Double.parseDouble(df.format(
		// ((double)(anProject.getSize())) / maxSize));
		// double TotalStatistic = ContributorStatistic + StarStatistic +
		// CommitStatistic + IssueStatistic
		// + PullRequestStatistic + SizeStatistic;
		// StatisticDetail detail = new StatisticDetail(StarStatistic,
		// ContributorStatistic, CommitStatistic,
		// IssueStatistic, PullRequestStatistic, SizeStatistic, TotalStatistic);
		// anProject.setStatisticDetail(detail);
		// }
		//
		// boolean result =
		// RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		// if (!result) {
		// RepStatisticsDataServer.setDetailStatisticInfo(allProjectsDetailInfo);
		// }
		// else{
		// System.out.println("Radersuccess");
		// }

	}
}
