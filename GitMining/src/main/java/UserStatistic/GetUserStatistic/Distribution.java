package UserStatistic.GetUserStatistic;

import java.util.List;

import Info.AddressInfo;
import data.map.MapImpl;
import data.map.MapServer;

public class Distribution {
	MapServer mapServer = new MapImpl();
	public List<AddressInfo> getDistribution() {
		return mapServer.getAddressDistribute();
	}
}
