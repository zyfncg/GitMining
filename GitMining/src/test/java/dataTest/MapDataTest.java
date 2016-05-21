package dataTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Info.LocalInfo;
import data.map.MapData;

public class MapDataTest {

	private MapData mapData=new MapData();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapData() {
		Map<String,LocalInfo> map=mapData.getMapData();
		String key="china";
		LocalInfo localInfo=map.get(key);
//		System.out.println(localInfo.getSite());
		
		
		assertEquals(100.0,localInfo.getLongtitude(),0.01);
		assertEquals(30.0,localInfo.getLatitude(),0.01);
	}

}
