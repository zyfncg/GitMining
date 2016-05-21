package UserStatistic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Info.AddressInfo;
import Info.UserInfoDetail;
import data.map.MapData;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class MapStatistic {
	public boolean StatisticMapData(){
		MapData mapData=new MapData();
		Map<String,AddressInfo> map=mapData.getMapData();
		UserStatisticsDataServer userData=new UserStatisticData();
		List<UserInfoDetail> userList = null;
		try {
			userList=userData.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		String address;
		AddressInfo addressInfo;
		int workerNum;
		
		for (Entry<String, AddressInfo> entry: map.entrySet()) {
			String key=entry.getKey();
		    addressInfo=entry.getValue();
		    addressInfo.setWorkerNumber(0);
		    map.put(key, addressInfo);
		}
		int count = 0;
		System.out.println(map.size());
		for(UserInfoDetail user :userList){
			address=user.getAddress().toLowerCase();
			if(address.contains("san francisco")&&!address.contains(", ca")){
				address=", ca";
			}else if(address.contains("seattle")&&!address.contains(", wa")){
				address=", wa";
			}else if(address.contains("united kingdom")||address.contains("england")){
				address=", uk";
			}else if(address.contains(", new york")){
				address=", ny";
			}else if(address.contains("brazil")){
				address="brasil";
			}
//			System.out.println(address);
			for(String key:map.keySet()){
				
				if(address.contains(key)){
					count++;
					System.out.println(count);
					if(key.equals(", ca")&&address.contains("canada")){
						continue;
					}else if(key.equals(", in")&&address.contains("india")){
						continue;
					}
					addressInfo=map.get(key);
					workerNum=addressInfo.getWorkerNumber();
					workerNum++;
					addressInfo.setWorkerNumber(workerNum);
					map.put(key, addressInfo);
					
				}
			}
		}
		
		if(mapData.setMapData(map)){
			return true;
		}else{
			return false;
		}
	}
}
