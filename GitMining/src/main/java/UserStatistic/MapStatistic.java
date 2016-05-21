package UserStatistic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Info.AddressInfo;
import Info.UserInfoDetail;
import data.map.AddressImpl;
import data.map.MapData;
import data.statisticServer.AddressServer;
import data.statisticServer.UserStatisticsDataServer;
import data.statistisDataImpl.UserStatisticData;

public class MapStatistic {
	
	public boolean StatisticMapData(){
		AddressServer addrData=new AddressImpl();
		Map<String,AddressInfo> map=addrData.getMapData();
		UserStatisticsDataServer userData=new UserStatisticData();
		List<UserInfoDetail> userList = null;
		try {
			userList=userData.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		String address;
		List<String> keyList;
		AddressInfo addressInfo;
		int workerNum;
		
		for (Entry<String, AddressInfo> entry: map.entrySet()) {
			String key=entry.getKey();
		    addressInfo=entry.getValue();
		    addressInfo.setWorkerNumber(0);
		    map.put(key, addressInfo);
		}

		
		for(UserInfoDetail user :userList){
			address=user.getAddress().toLowerCase();
			keyList=addrData.getMapKey(address);

			if(keyList==null){
				continue;
			}
			for(String key:keyList){
				addressInfo=map.get(key);
				workerNum=addressInfo.getWorkerNumber();
				workerNum++;
				addressInfo.setWorkerNumber(workerNum);
				map.put(key, addressInfo);
			}
			
		}
		
		if(addrData.saveMapData(map)){
			return true;
		}else{
			return false;
		}
	}
}
