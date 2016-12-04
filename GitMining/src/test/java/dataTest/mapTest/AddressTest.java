package dataTest.mapTest;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Info.AddressInfo;
import data.dataServer.statisticServer.AddressServer;
import data.map.AddressImpl;

public class AddressTest {

	AddressServer address=new AddressImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAddressByName() {
		String addrList[]={"san francisco bay area, ca","prague","hahahah"};
		AddressInfo addrInfo[]=new AddressInfo[3];
		addrInfo[0]=address.getAddressByName(addrList[0]);
		addrInfo[1]=address.getAddressByName(addrList[1]);
		addrInfo[2]=address.getAddressByName(addrList[2]);
		
		assertEquals(-122,addrInfo[0].getLongtitude(),0.01);
		assertEquals(38,addrInfo[0].getLatitude(),0.01);
		assertEquals(null,addrInfo[1]);
		assertEquals(null,addrInfo[2]);
	}

	@Test
	public void testGetMapKey() {
		String addrList[]={"magdeburg, germany","",
				"united states, india, england, china, australia, germany, canada, brazil"," ",null};
		List<String> key;
		key=address.getMapKey(addrList[0]);
		assertEquals(true,key.get(0).equalsIgnoreCase("germany"));
		
		key=address.getMapKey(addrList[1]);
		assertEquals(null,key);
		
		key=address.getMapKey(addrList[2]);
		String list="";
		for(String str:key){
			list=list+str;
		}
//		System.out.println(key.size());
//		System.out.println(list);
		assertEquals(true,list.contains("india"));
		assertEquals(true,list.contains("china"));
		assertEquals(false,list.contains("japen"));
		
		key=address.getMapKey(addrList[3]);
		assertEquals(null,key);
		
		key=address.getMapKey(addrList[4]);
		assertEquals(null,key);
		
	}

	@Test
	public void testGetMapData() {
		Map<String,AddressInfo> map=address.getMapData();
		String key=", ri";
		AddressInfo addressInfo=map.get(key);
	
		
		assertEquals(-71.3,addressInfo.getLongtitude(),0.01);
		assertEquals(41.7,addressInfo.getLatitude(),0.01);
	}

}
