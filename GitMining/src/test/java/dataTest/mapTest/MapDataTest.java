package dataTest.mapTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Info.AddressInfo;
import data.map.MapData;

public class MapDataTest {

	private MapData mapData=new MapData();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMapData() {
		Map<String,AddressInfo> map=mapData.getMapData();
		String key="china";
		AddressInfo addressInfo=map.get(key);
//		System.out.println(localInfo.getSite());
		
		
		assertEquals(113.0,addressInfo.getLongtitude(),0.01);
		assertEquals(30.0,addressInfo.getLatitude(),0.01);
	}

}
