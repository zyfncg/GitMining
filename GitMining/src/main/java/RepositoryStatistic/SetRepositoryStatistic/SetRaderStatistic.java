package RepositoryStatistic.SetRepositoryStatistic;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.StatisticDetail;
import data.statisticServer.RepositoryStatisticsDataServer;
import data.statistisDataImpl.ProjectStatisticData;

public class SetRaderStatistic {
	DecimalFormat df = new DecimalFormat("######0.00");

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
			double calNum = this.getdetailInfoNum(allProjectsDetailInfo,"Contributor",second,SizeNum,i);
			StatisticDetail detail = new StatisticDetail(0, 0+calNum, 0, 0, 0, 0, 0);
			allProjectsDetailInfo.get(i).setStatisticDetail(detail);
		}
	//计算平均值
		double ContributorAll=0;
		for(int i=0;i<allProjectsDetailInfo.size();i++){
			ContributorAll=ContributorAll+allProjectsDetailInfo.get(i).getContributors();
		}
		double ContributoraAve = Double.parseDouble(df.format(ContributorAll / (double)SizeNum));
		System.out.println(ContributoraAve);
		System.out.println(allProjectsDetailInfo.get(seventh).getContributors());
		// 2.
		// Star统计
		Collections.sort(allProjectsDetailInfo, new Comparator<ProjectDetail>() {
			@Override
			public int compare(ProjectDetail arg0, ProjectDetail arg1) {
				return (new Integer(arg1.getStars())).compareTo(new Integer(arg0.getStars()));
			}
		});
		for (int i = 0; i < tenth; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(tenth).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(tenth).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.9+calNum);
		}
		for (int i = tenth; i < ninth; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(ninth).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(ninth).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.8+calNum);
		}
		for (int i = ninth; i < eighth; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(eighth).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(eighth).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.7+calNum);
		}
		for (int i = eighth; i < seventh; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(seventh).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(seventh).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.6+calNum);
		}
		for (int i = seventh; i < sixth; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(sixth).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(sixth).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.5+calNum);
		}
		for (int i = sixth; i < fifth; i++) {
			int cha = allProjectsDetailInfo.get(0).getStars()-allProjectsDetailInfo.get(fifth).getStars();
			int temp = allProjectsDetailInfo.get(i).getStars();
			int below = allProjectsDetailInfo.get(fifth).getStars();
			double calNum = this.getdetailInfoNum(cha, temp,below);
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setStarStatistic(0.4+calNum);
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
	//计算平均值
		double StarAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				StarAll+=allProjectsDetailInfo.get(i).getStars();
			}
		double StarAve = Double.parseDouble(df.format(StarAll / (double)SizeNum));
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
	//计算平均值
		double CommitAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				CommitAll+=allProjectsDetailInfo.get(i).getCommit();
			}
		double CommitAve = Double.parseDouble(df.format(CommitAll / (double)SizeNum));

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
	//计算平均值
		double IssueAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				IssueAll+=allProjectsDetailInfo.get(i).getIssue();
			}
		double IssueAve = Double.parseDouble(df.format(IssueAll / (double)SizeNum));

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
	//计算平均值
		double PullRequestAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				PullRequestAll+=allProjectsDetailInfo.get(i).getPullRequest();
			}
		double PullRequestAve = Double.parseDouble(df.format(PullRequestAll / (double)SizeNum));

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
	//计算平均值
		double SizeAll=0.0;
			for(int i=0;i<allProjectsDetailInfo.size();i++){
				StarAll+=allProjectsDetailInfo.get(i).getSize();
			}
		double SizeAve = Double.parseDouble(df.format(SizeAll / (double)SizeNum));


		// 设置total
		for (int i = 0; i < allProjectsDetailInfo.size(); i++) {
			StatisticDetail detail = allProjectsDetailInfo.get(i).getStatisticDetail();
			detail.setTotalStatistic(
					detail.getCommitStatistic() + detail.getContributorStatistic() + detail.getIssueStatistic()
							+ detail.getPullRequestStatistic() + detail.getSizeStatistic() + detail.getStarStatistic());
			detail.setCommitAverage(CommitAve);
			detail.setStarAverage(StarAve);
			detail.setPullRequestAverage(PullRequestAve);
			detail.setContibutorAverage(ContributoraAve);
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
		
		double smallDistance = Double.parseDouble(df.format(((double)Temp-(double)Below)/((double) Cha)));
		
		return smallDistance;
	}
}
