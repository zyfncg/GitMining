package Info.RepStatisticInfo;

import java.io.Serializable;
import java.util.List;

public class SaveRepositoryStatisticInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5660515531645287861L;

	private List<TimeStatistics> theTime;

	private List<LanguageStatistics> theLanguage;

	private List<ForkStatistics> theFork;

	private List<StarStatistics> theStar;

	private List<ContributorStatistics> theContributor;

	public SaveRepositoryStatisticInfo(List<TimeStatistics> Time, List<LanguageStatistics> Language,
			List<ForkStatistics> Fork, List<StarStatistics> Star, List<ContributorStatistics> Contributor) {
		this.theTime = Time;
		this.theLanguage = Language;
		this.theFork = Fork;
		this.theStar = Star;
		this.theContributor = Contributor;

	}

	public List<TimeStatistics> getTheTime() {
		return theTime;
	}

	public void setTheTime(List<TimeStatistics> theTime) {
		this.theTime = theTime;
	}

	public List<LanguageStatistics> getTheLanguage() {
		return theLanguage;
	}

	public void setTheLanguage(List<LanguageStatistics> theLanguage) {
		this.theLanguage = theLanguage;
	}

	public List<ForkStatistics> getTheFork() {
		return theFork;
	}

	public void setTheFork(List<ForkStatistics> theFork) {
		this.theFork = theFork;
	}

	public List<StarStatistics> getTheStar() {
		return theStar;
	}

	public void setTheStar(List<StarStatistics> theStar) {
		this.theStar = theStar;
	}

	public List<ContributorStatistics> getTheContributor() {
		return theContributor;
	}

	public void setTheContributor(List<ContributorStatistics> theContributor) {
		this.theContributor = theContributor;
	}

}
