package StatisticTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import UserStatistic.MapStatistic;

public class MapStatisticTest {

	private MapStatistic mapStatistic=new MapStatistic();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStatisticMapData() {
		assertEquals(true,mapStatistic.StatisticMapData());
	}

}
