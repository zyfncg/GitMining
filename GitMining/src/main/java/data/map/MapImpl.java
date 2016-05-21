package data.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Info.AddressInfo;

public class MapImpl implements MapServer {

	@Override
	public List<AddressInfo> getAddressDistribute() {
		MapData mapData=new MapData();
		Map<String,AddressInfo> map=mapData.getMapData();
		List<AddressInfo> addrList=new ArrayList<AddressInfo>();
		
		for (AddressInfo addressInfo: map.values()) {
		   	
		    addrList.add(addressInfo);
		}
		
		return addrList;
	}

}
