package StatisticTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Info.UsrStatisticInfo.CatalogStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import UserStatistic.GetUserStatistic.UserStatisticFactory;
import UserStatistic.GetUserStatistic.DetailGet.GetCatalogStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCompanyStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatRepositoryStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetCreatTimeStatistic;
import UserStatistic.GetUserStatistic.DetailGet.GetJoinRepositoryStatistic;
import UserStatistic.SetUserStatistic.AllUserStatistic;

public class UsrStatisticTest {
	@Test
	public void test(){
		UserStatisticFactory factory1 = new UserStatisticFactory();
		GetCatalogStatistic catalogStatistic = factory1.GetCatalog();
		List<CatalogStatistics> list1 = catalogStatistic.getCatalogStatistic();
		assertEquals(list1.size(),list1.size());
		
		GetCompanyStatistic companyStatistic = factory1.GetCompany();
		List<CompanyStatistics> list2 = companyStatistic.getCompanyStatistic();
		assertEquals(list2.size(), list2.size());
		
		GetCreatTimeStatistic creatTimeStatistic = factory1.GetCreatTime();
		List<CreatTimeStatistics> list3 = creatTimeStatistic.getCreatTimeStatistic();
		assertEquals(list3.size(), list3.size());
		
		GetCreatRepositoryStatistic creatRepositoryStatistic = factory1.GetCreatRepository();
		List<CreatRepositoryStatistics> list4 = creatRepositoryStatistic.getCreatRepositoryStatistic();
		assertEquals(list4.size(), list4.size());
		
		GetJoinRepositoryStatistic joinRepositoryStatistic = factory1.GetJoinRepository();
		List<JoinRepositoryStatistics> list5 = joinRepositoryStatistic.getJoinRepositoryStatistic();
		assertEquals(list5.size(), list5.size());
		
		AllUserStatistic allUserStatistic = new AllUserStatistic();
		allUserStatistic.UserAnalyze();
		
//		UsrStatisticsFactory factory2 = new UsrStatisticsFactory();
//		
	}
}
