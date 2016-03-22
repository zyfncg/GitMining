package Info;

public class StatisticDetail {
	
	private Double StarStatistic;
	
	private Double ContributorStatistic;
	
	private Double CommitStatistic;
	
	private Double issueStatistic;
	
	private Double PullRequestStatistic;
	
	private Double sizeStatistic;
	
	public StatisticDetail(double Star,double Contributor,double Commit,double issue,double PullRequest,double Size){
		this.StarStatistic = Star;
		this.ContributorStatistic = Contributor;
		this.CommitStatistic = Commit;
		this.issueStatistic = issue;
		this.PullRequestStatistic = PullRequest;
		this.sizeStatistic = Size;
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
	
	
	
}