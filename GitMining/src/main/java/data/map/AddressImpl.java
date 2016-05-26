package data.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Info.AddressInfo;
import data.dataServer.statisticServer.AddressServer;

public class AddressImpl implements AddressServer{
	
	MapData mapData;
	Map<String,AddressInfo> map;

	public AddressImpl(){
		mapData=new MapData();
		map=mapData.getMapData();
	}
	
	
	@Override
	public AddressInfo getAddressByName(String name) {
		
		AddressInfo addressInfo;
		String key;
		
		List<String> addrList=addressMatch(name);
		if(addrList==null){
			return null;
		}else{
			key=addrList.get(0);
			addressInfo=map.get(key);
		}
		
		return addressInfo;
	}

	@Override
	public List<String> getMapKey(String name) {
		List<String> addrList=addressMatch(name);
		if(addrList==null){
			return null;	
		}
		return addrList;
	}

	@Override
	public Map<String, AddressInfo> getMapData() {
		return map;
	}

	@Override
	public boolean saveMapData(Map<String, AddressInfo> map) {
		return mapData.setMapData(map);
	}
	
	/**
	 * 根据地址字符串匹配地图中地址的key值列表
	 * @param addr
	 * @return 如果没有返回null
	 */
	private List<String> addressMatch(String addr){
		
		if(addr==null){
			return null;
		}
		
		List<String> addrList=new ArrayList<String>();
		
		String address=addr.toLowerCase();
		
		if(address.contains("san francisco")&&!address.contains(", ca")){
			address+=", ca";
		}else if(address.contains("seattle")&&!address.contains(", wa")){
			address+=", wa";
		}else if(address.contains("united kingdom")||address.contains("england")){
			address+=", uk";
		}else if(address.contains(", new york")){
			address+=", ny";
		}else if(address.contains("brazil")){
			address+="brasil";
		}
//		System.out.println(address);
		for(String key:map.keySet()){
			
			if(address.contains(key)){
//				System.out.println(key);
				if(key.equals(", ca")&&address.contains("canada")){
					continue;
				}else if(key.equals(", in")&&address.contains("india")){
					continue;
				}
				addrList.add(key);
			}
		}
		
		if(addrList.size()>0){
			return addrList;
		}
		return null;
	}

}
