package RepositoryStatistic;

import java.util.List;

import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;

public interface SuccAnalysisStatic {
	
	/**
	 *获得项目的个数 
	 */
	public double getProjectNum();
	
	/**
	 *获得项目中的所有协作者数目 
	 */
	public int[] getCollaNum();
	
	/**
	 *获得大牛占collaborator总数一半以上的项目个数 
	 */
	public int getMrBigOccupyNum();
	
	/**
	 *获得语言统计的数据
	 *@see LanguageStatistics
	 */
	public List<LanguageStatistics> getLanguageStat();
	
	/**
	 *获得公司统计的数据 
	 *@see CompanyStatistics
	 */
	public List<CompanyStatistics> getCompanyStat();
	
}
