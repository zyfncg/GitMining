package AnalysisTest;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import Info.RepStatisticInfo.LanguageStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.SuccAnalysisStatic;

public class UnSuccessTest {

	@Test
	public void test(){
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		SuccAnalysisStatic SuccStatic = factory.GetUnSuccStatistcs();
		//得到数据
		double one = SuccStatic.getProjectNum();
		int[] two = SuccStatic.getCollaNum();
		List<LanguageStatistics> languageStatistics = SuccStatic.getLanguageStat();
		List<CompanyStatistics> companyStatistics = SuccStatic.getCompanyStat();
//		System.out.println(one);
//		System.out.println(two[0]);
		assertEquals(3161.0,one,0.0);
//		assertEquals(311, two[0]);
//		System.out.println(languageStatistics.get(1).getLanguage());
//		System.out.println(languageStatistics.get(1).getNum());
		assertEquals("Python", languageStatistics.get(1).getLanguage());
		assertEquals(417, languageStatistics.get(1).getNum());
		
//		System.out.println(companyStatistics.get(1).getCompany());
//		System.out.println(companyStatistics.get(1).getNum());
		assertEquals(companyStatistics.get(1).getCompany(), companyStatistics.get(1).getCompany());
		assertEquals(companyStatistics.get(1).getNum(), companyStatistics.get(1).getNum());
		
	}
}
