package Info;

import java.io.Serializable;

public class StatisticDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3612953034453238123L;

	private double StarStatistic;
	
	private double ContributorStatistic;
	
	private double CommitStatistic;
	
	private double issueStatistic;
	
	private double PullRequestStatistic;
	
	private double sizeStatistic;
	
	private double totalStatistic;
	
	public StatisticDetail(double Star,double Contributor,double Commit,double issue,double PullRequest,double Size,double total){
		this.StarStatistic = Star;
		this.ContributorStatistic = Contributor;
		this.CommitStatistic = Commit;
		this.issueStatistic = issue;
		this.PullRequestStatistic = PullRequest;
		this.sizeStatistic = Size;
		this.totalStatistic = total;
	}

	public double getStarStatistic() {
		return StarStatistic;
	}

	public void setStarStatistic(double starStatistic) {
		StarStatistic = starStatistic;
	}

	public double getContributorStatistic() {
		return ContributorStatistic;
	}

	public void setContributorStatistic(double contributorStatistic) {
		ContributorStatistic = contributorStatistic;
	}

	public double getCommitStatistic() {
		return CommitStatistic;
	}

	public void setCommitStatistic(double commitStatistic) {
		CommitStatistic = commitStatistic;
	}

	public double getIssueStatistic() {
		return issueStatistic;
	}

	public void setIssueStatistic(double issueStatistic) {
		this.issueStatistic = issueStatistic;
	}

	public double getPullRequestStatistic() {
		return PullRequestStatistic;
	}

	public void setPullRequestStatistic(double pullRequestStatistic) {
		PullRequestStatistic = pullRequestStatistic;
	}

	public double getSizeStatistic() {
		return sizeStatistic;
	}

	public void setSizeStatistic(double sizeStatistic) {
		this.sizeStatistic = sizeStatistic;
	}

	public double getTotalStatistic() {
		return totalStatistic;
	}

	public void setTotalStatistic(double totalStatistic) {
		this.totalStatistic = totalStatistic;
	}
	
	
	
}
