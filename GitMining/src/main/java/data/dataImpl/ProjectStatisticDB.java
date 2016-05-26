package data.dataImpl;

import java.sql.SQLException;
import java.util.List;

import Info.ProjectDetail;
import Info.StatisticDetail;
import data.mysql.Database;

public class ProjectStatisticDB {

	/**
	 * 将项目的statistic存到数据库中
	 * @param list
	 * @return
	 */
	public boolean saveProjectStatis(List<ProjectDetail> list){
		double StarStatistic;
		double ContributorStatistic;
		double CommitStatistic;
		double issueStatistic;
		double PullRequestStatistic;
		double sizeStatistic;
		double StarAverage;
		double ContibutorAverage;
		double CommitAverage;
		double issueAverage;
		double PullRequestAverage;
		double sizeAverage;
		double totalStatistic;
		String name;
		String sql;
		StatisticDetail statistic;
		
		
		try {
			sql="delete from projectStatistic";
			Database.operate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			for(ProjectDetail projectDetail:list){
				statistic=projectDetail.getStatisticDetail();
				name=projectDetail.getProjectName().toString();
				
				StarStatistic=statistic.getStarStatistic();
				ContributorStatistic=statistic.getContributorStatistic();
				CommitStatistic=statistic.getCommitStatistic();
				issueStatistic=statistic.getIssueStatistic();
				PullRequestStatistic=statistic.getPullRequestStatistic();
				sizeStatistic=statistic.getSizeStatistic();
				StarAverage=statistic.getStarAverage();
				ContibutorAverage=statistic.getContibutorAverage();
				CommitAverage=statistic.getCommitAverage();
				issueAverage=statistic.getIssueAverage();
				PullRequestAverage=statistic.getPullRequestAverage();
				sizeAverage=statistic.getSizeAverage();
				totalStatistic=statistic.getTotalStatistic();
				
				sql="INSERT INTO projectInfo VALUES('"+name+"',"+StarStatistic+ContributorStatistic+CommitStatistic+
						issueStatistic+PullRequestStatistic+sizeStatistic+StarAverage+ContibutorAverage+CommitAverage+
						issueAverage+PullRequestAverage+sizeAverage+totalStatistic+");";
				
				Database.operate(sql);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
