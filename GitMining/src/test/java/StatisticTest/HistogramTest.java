package StatisticTest;

import Info.HistogramInfo;
import RepositoryStatistic.GetRepositoryStatistic.HistogramStatisticRep;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryStatisticFactory;

public class HistogramTest {
	public void test(){
		RepositoryStatisticFactory factory = new RepositoryStatisticFactory();
		HistogramStatisticRep histogramStatisticFork = factory.GetHistogramFork();
		HistogramInfo histogramInfo = histogramStatisticFork.getRepHistogramInfo();
		
		System.out.println(histogramInfo.getGroupNum()+"  "+histogramInfo.getMaxNum()+"  "+histogramInfo.getMinNum());
		
	}
	
	public static void main(String[] args) {
		HistogramTest test = new HistogramTest();
		test.test();
	}
	
}
