package StatisticTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Info.HistogramInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;

public class HistogramTest {
	@Test
	public void test(){
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		HistogramStatisticRep histogramStatisticFork = factory.GetHistogramFork();
		HistogramInfo histogramInfo = histogramStatisticFork.getRepHistogramInfo();
		assertEquals(histogramInfo.getGroupNum(),60);
		assertEquals(histogramInfo.getMaxNum(), 9609);
		assertEquals(histogramInfo.getMinNum(), 0);
//		System.out.println(histogramInfo.getGroupNum()+"  "+histogramInfo.getMaxNum()+"  "+histogramInfo.getMinNum());
		
	}
	
//	public static void main(String[] args) {
//		HistogramTest test = new HistogramTest();
//		test.test();
//	}
	
}
