package StatisticTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.AddressInfo;
import UserStatistic.GetUserStatistic.Distribution;

public class DistributionTest {
	@Test
	public void test(){
		Distribution distribution = new Distribution();
		List<AddressInfo> addressInfos = distribution.getDistribution();
		System.out.println(addressInfos.get(0).getSite());
		System.out.println(addressInfos.get(0).getLatitude());
		System.out.println(addressInfos.get(0).getLongtitude());
		System.out.println(addressInfos.get(0).getWorkerNumber());
//		assertEquals("Minnesota明尼苏达�?",addressInfos.get(0).getSite());
		assertEquals(43.4, addressInfos.get(0).getLatitude(),0.0);
		assertEquals(-93.2, addressInfos.get(0).getLongtitude(),0.0);
		assertEquals(5, addressInfos.get(0).getWorkerNumber());
	}
}
