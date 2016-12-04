package StatisticTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Info.HistogramInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;
import UserStatistic.GetUserStatistic.HistogramStatisticUser;
import UserStatistic.GetUserStatistic.UserStatisticFactory;

public class HistogramTest {
	@Test
	public void test(){
		/*
		 * 项目相关Histogram
		 */
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		HistogramStatisticRep histogramStatisticFork = factory.GetHistogramFork();
		HistogramInfo histogramInfo = histogramStatisticFork.getRepHistogramInfo();
		assertEquals(histogramInfo.getGroupNum(),histogramInfo.getGroupNum());
		assertEquals(histogramInfo.getMaxNum(), histogramInfo.getMaxNum());
		assertEquals(histogramInfo.getMinNum(), histogramInfo.getMinNum());
		HistogramInfo histogramInfo2 = histogramStatisticFork.getSmallRepHistogramInfo();
//		System.out.println(histogramInfo2.getGroupNum());
//		System.out.println(histogramInfo2.getMaxNum());
//		System.out.println(histogramInfo2.getMinNum());
//		System.out.println(histogramInfo2.getAllNum()[0]);
		assertEquals(histogramInfo2.getGroupNum(), histogramInfo2.getGroupNum());
		assertEquals(histogramInfo2.getMaxNum(), histogramInfo2.getMaxNum());
		assertEquals(histogramInfo2.getMinNum(), histogramInfo2.getMinNum());
		assertEquals(histogramInfo2.getAllNum()[0], histogramInfo2.getAllNum()[0],0.0);
		HistogramInfo histogramInfo3 = histogramStatisticFork.getBigRepHistogramInfo();
//		System.out.println(histogramInfo3.getGroupNum());
//		System.out.println(histogramInfo3.getMaxNum());
//		System.out.println(histogramInfo3.getMinNum());
//		System.out.println(histogramInfo3.getAllNum()[0]);
		assertEquals(histogramInfo3.getGroupNum(), histogramInfo3.getGroupNum());
		assertEquals(histogramInfo3.getMaxNum(), histogramInfo3.getMaxNum());
		assertEquals(histogramInfo3.getMinNum(), histogramInfo3.getMinNum());
		assertEquals(histogramInfo3.getAllNum()[0], histogramInfo3.getAllNum()[0],0.0);
//		System.out.println(histogramInfo.getGroupNum()+"  "+histogramInfo.getMaxNum()+"  "+histogramInfo.getMinNum());
		
		HistogramStatisticRep histogramStatisticStar = factory.GetHistogramStar();
		HistogramInfo histogramInfo4 = histogramStatisticStar.getSmallRepHistogramInfo();
//		System.out.println(histogramInfo4.getGroupNum());
//		System.out.println(histogramInfo4.getMaxNum());
//		System.out.println(histogramInfo4.getMinNum());
//		System.out.println(histogramInfo4.getAllNum()[0]);
		assertEquals(histogramInfo4.getGroupNum(), histogramInfo4.getGroupNum());
		assertEquals(histogramInfo4.getMaxNum(), histogramInfo4.getMaxNum());
		assertEquals(histogramInfo4.getMinNum(), histogramInfo4.getMinNum());
		assertEquals(histogramInfo4.getAllNum()[0], histogramInfo4.getAllNum()[0],0.0);
		HistogramInfo histogramInfo5 = histogramStatisticStar.getBigRepHistogramInfo();
//		System.out.println(histogramInfo5.getGroupNum());
//		System.out.println(histogramInfo5.getMaxNum());
//		System.out.println(histogramInfo5.getMinNum());
//		System.out.println(histogramInfo5.getAllNum()[0]);
		assertEquals(histogramInfo5.getGroupNum(), histogramInfo5.getGroupNum());
		assertEquals(histogramInfo5.getMaxNum(), histogramInfo5.getMaxNum());
		assertEquals(histogramInfo5.getMinNum(), histogramInfo5.getMinNum());
		assertEquals(histogramInfo5.getAllNum()[0], histogramInfo5.getAllNum()[0],0.0);
		HistogramInfo histogramInfo6 = histogramStatisticStar.getRepHistogramInfo();
//		System.out.println(histogramInfo6.getGroupNum());
//		System.out.println(histogramInfo6.getMaxNum());
//		System.out.println(histogramInfo6.getMinNum());
//		System.out.println(histogramInfo6.getAllNum()[0]);
		assertEquals(histogramInfo6.getGroupNum(), histogramInfo6.getGroupNum());
		assertEquals(histogramInfo6.getMaxNum(), histogramInfo6.getMaxNum());
		assertEquals(histogramInfo6.getMinNum(), histogramInfo6.getMinNum());
		assertEquals(histogramInfo6.getAllNum()[0], histogramInfo6.getAllNum()[0],0.0);
		
		/*
		 * 用户相关Histogram
		 */
		UserStatisticFactory userStatisticFactory = new UserStatisticFactory();
		HistogramStatisticUser histogramStatisticJoin = userStatisticFactory.GetHistogramJoin();
		HistogramInfo histogramInfo7 = histogramStatisticJoin.getBigUsrHistogramInfo();
//		System.out.println(histogramInfo7.getGroupNum());
//		System.out.println(histogramInfo7.getMaxNum());
//		System.out.println(histogramInfo7.getMinNum());
//		System.out.println(histogramInfo7.getAllNum()[0]);
		assertEquals(histogramInfo7.getGroupNum(), histogramInfo7.getGroupNum());
		assertEquals(histogramInfo7.getMaxNum(), histogramInfo7.getMaxNum());
		assertEquals(histogramInfo7.getMinNum(), histogramInfo7.getMinNum());
		assertEquals(histogramInfo7.getAllNum()[0], histogramInfo7.getAllNum()[0],0.0);
		HistogramInfo histogramInfo8 = histogramStatisticJoin.getSmallUsrHistogramInfo();
//		System.out.println(histogramInfo8.getGroupNum());
//		System.out.println(histogramInfo8.getMaxNum());
//		System.out.println(histogramInfo8.getMinNum());
//		System.out.println(histogramInfo8.getAllNum()[0]);
		assertEquals(histogramInfo8.getGroupNum(), histogramInfo8.getGroupNum());
		assertEquals(histogramInfo8.getMaxNum(), histogramInfo8.getMaxNum());
		assertEquals(histogramInfo8.getMinNum(), histogramInfo8.getMinNum());
		assertEquals(histogramInfo8.getAllNum()[0], histogramInfo8.getAllNum()[0],0.0);
		HistogramInfo histogramInfo9 = histogramStatisticJoin.getUsrHistogramInfo();
//		System.out.println(histogramInfo9.getGroupNum());
//		System.out.println(histogramInfo9.getMaxNum());
//		System.out.println(histogramInfo9.getMinNum());
//		System.out.println(histogramInfo9.getAllNum()[0]);
		assertEquals(histogramInfo9.getGroupNum(), histogramInfo9.getGroupNum());
		assertEquals(histogramInfo9.getMaxNum(), histogramInfo9.getMaxNum());
		assertEquals(histogramInfo9.getMinNum(), histogramInfo9.getMinNum());
		assertEquals(histogramInfo9.getAllNum()[0], histogramInfo9.getAllNum()[0],0.0);
		
		HistogramStatisticUser histogramStatisticCreat = userStatisticFactory.GetHistogramCreat();
		HistogramInfo histogramInfo10 = histogramStatisticCreat.getBigUsrHistogramInfo();
//		System.out.println(histogramInfo10.getGroupNum());
//		System.out.println(histogramInfo10.getMaxNum());
//		System.out.println(histogramInfo10.getMinNum());
//		System.out.println(histogramInfo10.getAllNum()[0]);
		assertEquals(histogramInfo10.getGroupNum(), histogramInfo10.getGroupNum());
		assertEquals(histogramInfo10.getMaxNum(), histogramInfo10.getMaxNum());
		assertEquals(histogramInfo10.getMinNum(), histogramInfo10.getMinNum());
		assertEquals(histogramInfo10.getAllNum()[0], histogramInfo10.getAllNum()[0],0.0);
		HistogramInfo histogramInfo11 = histogramStatisticCreat.getSmallUsrHistogramInfo();
//		System.out.println(histogramInfo11.getGroupNum());
//		System.out.println(histogramInfo11.getMaxNum());
//		System.out.println(histogramInfo11.getMinNum());
//		System.out.println(histogramInfo11.getAllNum()[0]);
		assertEquals(histogramInfo11.getGroupNum(), histogramInfo11.getGroupNum());
		assertEquals( histogramInfo11.getMaxNum(), histogramInfo11.getMaxNum());
		assertEquals(histogramInfo11.getMinNum(), histogramInfo11.getMinNum());
		assertEquals(histogramInfo11.getAllNum()[0], histogramInfo11.getAllNum()[0],0.0);
		HistogramInfo histogramInfo12 = histogramStatisticCreat.getUsrHistogramInfo();
//		System.out.println(histogramInfo12.getGroupNum());
//		System.out.println(histogramInfo12.getMaxNum());
//		System.out.println(histogramInfo12.getMinNum());
//		System.out.println(histogramInfo12.getAllNum()[0]);
		assertEquals(histogramInfo12.getGroupNum(), histogramInfo12.getGroupNum());
		assertEquals(histogramInfo12.getMaxNum(), histogramInfo12.getMaxNum());
		assertEquals(histogramInfo12.getMinNum(), histogramInfo12.getMinNum());
		assertEquals(histogramInfo12.getAllNum()[0], histogramInfo12.getAllNum()[0],0.0);
	}
	
//	public static void main(String[] args) {
//		HistogramTest test = new HistogramTest();
//		test.test();
//	}
	
}
