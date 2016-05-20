package dataTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import Info.LocalInfo;
import data.map.MapData;

public class MapDataTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		MapData mapData=new MapData();
		Map<String,LocalInfo> map=mapData.getMapData();
		String key="china";
		LocalInfo localInfo=map.get(key);
		System.out.println("test!");
		System.out.println(localInfo.getSite());
		assertEquals(100,localInfo.getLongtitude());
		assertEquals(30,localInfo.getLatitude());
	}

}
