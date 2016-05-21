package data.statisticServer;

import Info.AddressInfo;

public interface AddressServer {

	/**
	 * 通过地址获得地址的经纬度信息
	 * @param name
	 * @return
	 */
	public AddressInfo getAddressByName(String name);
	
	
}
