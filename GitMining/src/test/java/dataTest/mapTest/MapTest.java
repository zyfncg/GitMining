package dataTest.mapTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Info.AddressInfo;
import data.map.MapImpl;
import data.map.MapServer;

public class MapTest {

	MapServer map=new MapImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAddressDistribute() {
		List<AddressInfo> addrList=map.getAddressDistribute();
		
		for(AddressInfo address:addrList){
			if(address.getSite().equals("Massachusetts马萨诸塞州")){
				assertEquals(-70,address.getLongtitude(),0.01);
				assertEquals(42,address.getLatitude(),0.01);
			}
			
		}
	}

}
