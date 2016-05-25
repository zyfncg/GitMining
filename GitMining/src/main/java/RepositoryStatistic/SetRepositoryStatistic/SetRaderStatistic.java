package RepositoryStatistic.SetRepositoryStatistic;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import Info.StatisticDetail;
import data.dataImpl.statistisDataImpl.ProjectStatisticData;
import data.dataServer.statisticServer.RepositoryStatisticsDataServer;

public class SetRaderStatistic {
	DecimalFormat df = new DecimalFormat("######0.00");

	public void DetailRaderStatistic() {
		RepositoryStatisticsDataServer RepStatisticsDataServer = new ProjectStatisticData();
		AllRepositoryStatistic allRepositoryStatistic = new AllRepositoryStatistic();
		List<ProjectDetail> allProjectsDetailInfo = allRepositoryStatistic.getStatisticRepositoryInfo();

		// 项目总数
		int SizeNum = allProjectsDetailInfo.size();
		// 每一挡的项目数量
		int tenth = (int) (SizeNum * 0.01);
		int ninth = (int) (SizeNum * 0.10);
		int eighth = (int) (SizeNum * 0.20);
		int seventh = (int) (SizeNum * 0.45);
		int sixth = (int) (SizeNum * 0.65);
		int fifth = (int) (SizeNum * 0.80);
		int forth = (int) (SizeNum * 0.85);
		int third = (int) (SizeNum * 0.90);
		int second = (int) (SizeNum * 0.95);

//		DecimalFormat df = new DecimalFormat("######0.00");
		// 1.
		// Contributor统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getContributors())).compareTo(new Integer(arg0.getContributors()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",0,tenth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.9+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",tenth,ninth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.8+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",ninth,eighth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.7+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",eighth,seventh,i);
			StatisticDetail detail = new StatisticDetail(0, 0.6+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",seventh,sixth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.5+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",sixth,fifth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.4+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",fifth,forth,i);
			StatisticDetail detail = new StatisticDetail(0, 0.3+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",forth,third,i);
			StatisticDetail detail = new StatisticDetail(0, 0.2+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",third,second,i);
			StatisticDetail detail = new StatisticDetail(0, 0.1+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",second,SizeNum-1,i);
			StatisticDetail detail = new StatisticDetail(0, 0.05+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
	//计算平均值
		double ContributorAll=0;
		for(int i=0;i<allProjectsDetailInfo.size();i++){
			ContributorAll=ContributorAll+allProjectsDetailInfo.get(i).getContributors();
		}
		double ContributorTemp = Double.parseDouble(df.format(ContributorAll / (double)SizeNum));
		int ContributorCha = allProjectsDetailInfo.get(eighth).getContributors()-allProjectsDetailInfo.get(seventh).getContributors();
		int ContributorBelow = allProjectsDetailInfo.get(seventh).getContributors();
		double ContributorAve = 0.6+Double.parseDouble(df.format(((double)ContributorTemp-(double)ContributorBelow)/((double) ContributorCha)))/10;
		

		// 2.
		// Star统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getStars())).compareTo(new Integer(arg0.getStars()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",0,tenth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",tenth,ninth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",ninth,eighth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",eighth,seventh,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",seventh,sixth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",sixth,fifth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.4+calNum);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",fifth,forth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.3+calNum);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",forth,third,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.2+calNum);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",third,second,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.1+calNum);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Star",second,SizeNum-1,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.05+calNum);
		}
	//计算平均值
		double StarAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				StarAll+=allProjectsDetailInfo.get(i).getStars();
			}
		double StarTemp = Double.parseDouble(df.format(StarAll / (double)SizeNum));
		int StarCha = allProjectsDetailInfo.get(eighth).getStars()-allProjectsDetailInfo.get(seventh).getStars();
		int StarBelow = allProjectsDetailInfo.get(seventh).getStars();
		double StarAve = 0.6+Double.parseDouble(df.format(((double)StarTemp-(double)StarBelow)/((double) StarCha)))/10;


		// 3.
		// Commit统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Long(arg1.getCommit())).compareTo(new Long(arg0.getCommit()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",0,tenth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",tenth,ninth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",ninth,eighth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",eighth,seventh,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",seventh,sixth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",sixth,fifth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.4+calNum);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",fifth,forth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.3+calNum);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",forth,third,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.2+calNum);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",third,second,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.1+calNum);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Commit",second,SizeNum-1,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setCommitStatistic(0.05+calNum);
		}
	//计算平均值
		double CommitAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				CommitAll+=allProjectsDetailInfo.get(i).getCommit();
			}
		double CommitTemp = Double.parseDouble(df.format(CommitAll / (double)SizeNum));
		long CommitCha = allProjectsDetailInfo.get(eighth).getCommit()-allProjectsDetailInfo.get(seventh).getCommit();
		long CommitBelow = allProjectsDetailInfo.get(seventh).getCommit();
		double CommitAve = 0.6+Double.parseDouble(df.format(((double)CommitTemp-(double)CommitBelow)/((double) CommitCha)))/10;

		// 4.
		// Issue统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getIssue())).compareTo(new Integer(arg0.getIssue()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",0,tenth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",tenth,ninth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",ninth,eighth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",eighth,seventh,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",seventh,sixth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",sixth,fifth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.4+calNum);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",fifth,forth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.3+calNum);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",forth,third,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.2+calNum);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",third,second,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.1+calNum);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Issue",second,SizeNum-1,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setIssueStatistic(0.05+calNum);
		}
	//计算平均值
		double IssueAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				IssueAll+=allProjectsDetailInfo.get(i).getIssue();
			}
		double IssueTemp = Double.parseDouble(df.format(IssueAll / (double)SizeNum));
		int IssueCha = allProjectsDetailInfo.get(eighth).getIssue()-allProjectsDetailInfo.get(seventh).getIssue();
		int IssueBelow = allProjectsDetailInfo.get(seventh).getIssue();
		double IssueAve = 0.6+Double.parseDouble(df.format(((double)IssueTemp-(double)IssueBelow)/((double) IssueCha)))/10;


		// 5.
		// PullRequest的统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getPullRequest())).compareTo(new Integer(arg0.getPullRequest()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",0,tenth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",tenth,ninth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",ninth,eighth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",eighth,seventh,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",seventh,sixth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",sixth,fifth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.4+calNum);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",fifth,forth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.3+calNum);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",forth,third,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.2+calNum);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",third,second,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.1+calNum);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"PullRequest",second,SizeNum-1,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setPullRequestStatistic(0.05+calNum);
		}
	//计算平均值
		double PullRequestAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				PullRequestAll+=allProjectsDetailInfo.get(i).getPullRequest();
			}
		double PullRequestTemp = Double.parseDouble(df.format(PullRequestAll / (double)SizeNum));
		int PullRequestCha = allProjectsDetailInfo.get(eighth).getPullRequest()-allProjectsDetailInfo.get(seventh).getPullRequest();
		int PullRequestBelow = allProjectsDetailInfo.get(seventh).getPullRequest();
		double PullRequestAve = 0.6+Double.parseDouble(df.format(((double)PullRequestTemp-(double)PullRequestBelow)/((double) PullRequestCha)))/10;


		// 6.
		// Size的统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getSize())).compareTo(new Integer(arg0.getSize()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",0,tenth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",tenth,ninth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",ninth,eighth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",eighth,seventh,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",seventh,sixth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",sixth,fifth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.4+calNum);
		}
		for (int i = fifth; i < forth; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",fifth,forth,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.3+calNum);
		}
		for (int i = forth; i < third; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",forth,third,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.2+calNum);
		}
		for (int i = third; i < second; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",third,second,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.1+calNum);
		}
		for (int i = second; i < SizeNum; i++) {
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Size",second,SizeNum-1,i);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setSizeStatistic(0.05+calNum);
		}
	//计算平均值
		double SizeAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				SizeAll+=allProjectsDetailInfo.get(i).getSize();
			}
		double SizeTemp = Double.parseDouble(df.format(SizeAll / (double)SizeNum));
		int SizeCha = allProjectsDetailInfo.get(ninth).getSize()-allProjectsDetailInfo.get(eighth).getSize();
		int SizeBelow = allProjectsDetailInfo.get(eighth).getSize();
		double SizeAve = 0.7+Double.parseDouble(df.format(((double)SizeTemp-(double)SizeBelow)/((double) SizeCha)))/10;

//		System.out.println(SizeTemp);
//		System.out.println(allProjectsDetailInfo.get(eighth).getSize());


		// 设置total
		for (int i = 0; i < allProjectsDetailInfo.size(); i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setTotalStatistic(
					detail.getCommitStatistic() + detail.getContributorStatistic() + detail.getIssueStatistic()
							+ detail.getPullRequestStatistic() + detail.getSizeStatistic() + detail.getStarStatistic());
			detail.setCommitAverage(CommitAve);
			detail.setStarAverage(StarAve);
			detail.setPullRequestAverage(PullRequestAve);
			detail.setContibutorAverage(ContributorAve);
			detail.setSizeAverage(SizeAve);
			detail.setIssueAverage(IssueAve);
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
	
	//求出详细分数
//	public double getdetailInfoNum(int distance,int num, int below){
//		double smallDistance = Double.parseDouble(df.format(((double)num-(double)below)/((double) distance)));
//		
//		return smallDistance;
//	}
	public double getdetailInfoNum(List<ProjectDetail> allProjectsDetailInfo,String sign,int high,int below,int now ){
		long Cha=0;
		long Temp=0;
		long Below=0;
		
		switch (sign){
			case "Contributor":
				Cha = allProjectsDetailInfo.get(high).getContributors()-allProjectsDetailInfo.get(below).getContributors();
				Temp = allProjectsDetailInfo.get(now).getContributors();
				Below = allProjectsDetailInfo.get(below).getContributors();
				break;
			case "Star":
				Cha = allProjectsDetailInfo.get(high).getStars()-allProjectsDetailInfo.get(below).getStars();
				Temp = allProjectsDetailInfo.get(now).getStars();
				Below = allProjectsDetailInfo.get(below).getStars();
				break;
			case "Commit":
				Cha = allProjectsDetailInfo.get(high).getCommit()-allProjectsDetailInfo.get(below).getCommit();
				Temp = allProjectsDetailInfo.get(now).getCommit();
				Below = allProjectsDetailInfo.get(below).getCommit();
				break;
			case "Issue":
				Cha = allProjectsDetailInfo.get(high).getIssue()-allProjectsDetailInfo.get(below).getIssue();
				Temp = allProjectsDetailInfo.get(now).getIssue();
				Below = allProjectsDetailInfo.get(below).getIssue();
				break;
			case "PullRequest":
				Cha = allProjectsDetailInfo.get(high).getPullRequest()-allProjectsDetailInfo.get(below).getPullRequest();
				Temp = allProjectsDetailInfo.get(now).getPullRequest();
				Below = allProjectsDetailInfo.get(below).getPullRequest();
				break;
			case "Size":
				Cha = allProjectsDetailInfo.get(high).getSize()-allProjectsDetailInfo.get(below).getSize();
				Temp = allProjectsDetailInfo.get(now).getSize();
				Below = allProjectsDetailInfo.get(below).getSize();
				break;
		
		}
		if (Cha==0) {
			Cha = 1;
		}
		double smallDistance = Double.parseDouble(df.format(((double)Temp-(double)Below)/((double) Cha)))/10;
//		System.out.println(smallDistance);
		return smallDistance;
	}
}
