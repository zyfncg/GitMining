package Info;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 项目详细信息
 * 
 * @author 张仁知
 *
 */
public class ProjectDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3985898918660943741L;

	/** 
	 * 对项目的简要描述
	 */
	private String description;
	
	/**
	 * 项目所使用的语言
	 */
	private String language;
	
	/**
	 * 项目主页
	 */
	private String URL;
	
	/**
	 * 项目名称
	 */
	private ProjectName projectName;
	
	/**
	 * 项目创建时间
	 */
	private Date CreatDate;
	
	/**
	 * 项目的fork数量
	 */
	private int forks;
	
	/**
	 * 项目的star数量
	 */
	private int stars;
	
	/**
	 * 项目贡献者
	 */
	private int contributors;
	
	/**
	 * 项目的issue数量
	 */
	private int issue;
	
	/**
	 * 项目提取情况
	 */
	private int pullRequest;
	
	/**
	 * 项目大小
	 */
	private int size;
	
	/**
	 * 项目提交
	 */
	private int commit;
	/**
	 * 项目贡献者相关信息列表
	 */
	private List<UserInfo> ContributorsInfo;
	
	/**
	 * 项目协作者
	 */
	private int collaborators;
	
	/**
	 * 项目协作者相关信息列表
	 */
	private List<UserInfo> CollaboratorsInfo;

	/**
	 * 用户订阅
	 */
	private int subscribers;
	
	/**
	 * 雷达图详细数据
	 */
	private StatisticDetail statisticDetail;

	/**
	 * 用户commit统计
	 */
	private Map userCommits;
	

	public ProjectDetail(String description, String language, String uRL,
			ProjectName projectName, int forks, int stars, int contributors,
			int collaborators,int subscribers,List<UserInfo> ContributorsInfo,List<UserInfo> CollaboratorsInfo) {
		super();
		this.description = description;
		this.language = language;
		URL = uRL;
		this.projectName = projectName;
		this.forks = forks;
		this.stars = stars;
		this.contributors = contributors;
		this.collaborators = collaborators;
		this.subscribers = subscribers;
		this.ContributorsInfo = ContributorsInfo;
		this.CollaboratorsInfo = CollaboratorsInfo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public ProjectName getProjectName() {
		return projectName;
	}

	public void setProjectName(ProjectName projectName) {
		this.projectName = projectName;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getContributors() {
		return contributors;
	}

	public void setContributors(int contributors) {
		this.contributors = contributors;
	}

	public int getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}
	
	public void setSubscribers(int subscribers) {
		this.subscribers = subscribers;
	}
	
	public int getSubscribers() {
		return subscribers;
	}
	public List<UserInfo> getContributorsInfo() {
		return ContributorsInfo;
	}

	public void setContributorsInfo(List<UserInfo> contributorsInfo) {
		ContributorsInfo = contributorsInfo;
	}

	public List<UserInfo> getCollaboratorsInfo() {
		return CollaboratorsInfo;
	}

	public void setCollaboratorsInfo(List<UserInfo> collaboratorsInfo) {
		CollaboratorsInfo = collaboratorsInfo;
	}
	
	public Date getCreatDate() {
		return CreatDate;
	}

	public void setCreatDate(Date creatDate) {
		CreatDate = creatDate;
	}

	public int getPullRequest() {
		return pullRequest;
	}

	public void setPullRequest(int pullRequest) {
		this.pullRequest = pullRequest;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getCommit() {
		return commit;
	}

	public void setCommit(int commit2) {
		this.commit = commit2;
	}

	public StatisticDetail getStatisticDetail() {
		return statisticDetail;
	}

	public void setStatisticDetail(StatisticDetail statisticDetail) {
		this.statisticDetail = statisticDetail;
	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	public void setUserCommits(Map userCommits){
		this.userCommits=userCommits;
	}

	public Map getUserCommits(){
		return this.userCommits;
	}

	/**
	 * 将项目详细信息转为项目粗略信息
	 */
	public ProjectInfo ChangeDetailToInfo(){
		ProjectInfo pInfo = new ProjectInfo(this.description, this.projectName, this.forks, this.stars, this.contributors);
		return pInfo;
	}
}
 