package Info;

import java.io.Serializable;

public class StatisticDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3612953034453238123L;

	private Double StarStatistic;
	
	private Double ContributorStatistic;
	
	private Double CommitStatistic;
	
	private Double issueStatistic;
	
	private Double PullRequestStatistic;
	
	private Double sizeStatistic;
	
	private Double totalStatistic;
	
	public StatisticDetail(double Star,double Contributor,double Commit,double issue,double PullRequest,double Size,double total){
		this.StarStatistic = Star;
		this.ContributorStatistic = Contributor;
		this.CommitStatistic = Commit;
		this.issueStatistic = issue;
		this.PullRequestStatistic = PullRequest;
		this.sizeStatistic = Size;
		this.totalStatistic = total;
	}

	public Double getStarStatistic() {
		return StarStatistic;
	}

	public void setStarStatistic(Double starStatistic) {
		StarStatistic = starStatistic;
	}

	public Double getContributorStatistic() {
		return ContributorStatistic;
	}

	public void setContributorStatistic(Double contributorStatistic) {
		ContributorStatistic = contributorStatistic;
	}

	public Double getCommitStatistic() {
		return CommitStatistic;
	}

	public void setCommitStatistic(Double commitStatistic) {
		CommitStatistic = commitStatistic;
	}

	public Double getIssueStatistic() {
		return issueStatistic;
	}

	public void setIssueStatistic(Double issueStatistic) {
		this.issueStatistic = issueStatistic;
	}

	public Double getPullRequestStatistic() {
		return PullRequestStatistic;
	}

	public void setPullRequestStatistic(Double pullRequestStatistic) {
		PullRequestStatistic = pullRequestStatistic;
	}

	public Double getSizeStatistic() {
		return sizeStatistic;
	}

	public void setSizeStatistic(Double sizeStatistic) {
		this.sizeStatistic = sizeStatistic;
	}

	public Double getTotalStatistic() {
		return totalStatistic;
	}

	public void setTotalStatistic(Double totalStatistic) {
		this.totalStatistic = totalStatistic;
	}
	
	
	
}
