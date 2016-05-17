package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis;

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
	public List<Integer> getCollaNum();
	
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
	
	/**
	 *获得团队结构为主程序员团队的项目数目 
	 */
	public int getManageTeamNum();
	
	/**
	 *获得团队结构为民主团队的项目数目 
	 */
	public int getCommuTeamNum();
}
