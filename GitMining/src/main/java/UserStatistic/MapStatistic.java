package UserStatistic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Info.LocalInfo;
import Info.UserInfoDetail;
import data.map.MapData;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class MapStatistic {
	public boolean StatisticMapData(){
		MapData mapData=new MapData();
		Map<String,LocalInfo> map=mapData.getMapData();
		UserStatisticsDataServer userData=new UserStatisticData();
		List<UserInfoDetail> userList = null;
		try {
			userList=userData.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		String address;
		LocalInfo localInfo;
		int workerNum;
		
		for (Entry<String, LocalInfo> entry: map.entrySet()) {
			String key=entry.getKey();
		    localInfo=entry.getValue();
		    localInfo.setWorkerNumber(0);
		    map.put(key, localInfo);
		}
		int count = 0;
		System.out.println(map.size());
		for(UserInfoDetail user :userList){
			address=user.getAddress().toLowerCase();
		
//			System.out.println(address);
			for(String key:map.keySet()){
				if(address.contains(key)){
					count++;
					System.out.println(count);
					if(key.equals(", ca")&&address.contains("canada")){
						continue;
					}else if(key.equals(", in")&&address.contains("india")){
						continue;
					}else if(address.contains("england")){
						key=", uk";
					}
					localInfo=map.get(key);
					workerNum=localInfo.getWorkerNumber();
					workerNum++;
					localInfo.setWorkerNumber(workerNum);
					map.put(key, localInfo);
					
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
