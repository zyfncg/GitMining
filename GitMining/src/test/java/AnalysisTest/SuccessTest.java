package AnalysisTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccAnalysisStatic;

public class SuccessTest {

	@Test
	public void test(){
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		SuccAnalysisStatic SuccStatic = factory.GetSuccStatistcs();
		
		
		double one = SuccStatic.getProjectNum();
		int[] two = SuccStatic.getCollaNum();
		List<LanguageStatistics> languageStatistics = SuccStatic.getLanguageStat();
		List<CompanyStatistics> companyStatistics = SuccStatic.getCompanyStat();
		System.out.println(one);
		assertEquals(75.0, one,0.0);
		//assertEquals(expected, actual);
		for(int i=0;i < two.length;i++){
			System.out.println(two[i]);
		}
		//System.out.println(two[two.length-1]);
		//System.out.println(companyStatistics.size());
		for(int i=0;i < (languageStatistics.size());i++){
//			System.out.println(i);
			System.out.println(languageStatistics.get(i).getLanguage());
			System.out.println(languageStatistics.get(i).getNum());
		}
		for(int i=0;i<companyStatistics.size();i++){
			System.out.println(companyStatistics.get(i).getCompany());
			System.out.println(companyStatistics.get(i).getNum());
		}
	}
	
	public static void main(String[] args) {
//		System.out.println("123");
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		SuccAnalysisStatic SuccStatic = factory.GetSuccStatistcs();
		SuccAnalysisStatic UnSuccStatic = factory.GetUnSuccStatistcs();
		
		
		double one = SuccStatic.getProjectNum();
		int[] two = SuccStatic.getCollaNum();
		List<LanguageStatistics> languageStatistics = SuccStatic.getLanguageStat();
		List<CompanyStatistics> companyStatistics = SuccStatic.getCompanyStat();
		List<CompanyStatistics> companyStatistics2 = UnSuccStatic.getCompanyStat();
//		System.out.println(one);
		for(int i=0;i < two.length;i++){
//			System.out.println(two[i]);
		}
		//System.out.println(two[two.length-1]);
		//System.out.println(companyStatistics.size());
		for(int i=0;i < (languageStatistics.size());i++){
//			System.out.println(i);
//			System.out.println(languageStatistics.get(i).getLanguage());
//			System.out.println(languageStatistics.get(i).getNum());
		}
		for(int i=0;i<companyStatistics.size();i++){
			System.out.println(companyStatistics.get(i).getCompany());
			System.out.println(companyStatistics.get(i).getNum());
		}
		System.out.println("123");
		for(int i=0;i<companyStatistics2.size();i++){
			System.out.println(companyStatistics2.get(i).getCompany());
			System.out.println(companyStatistics2.get(i).getNum());
		}
	}

}
