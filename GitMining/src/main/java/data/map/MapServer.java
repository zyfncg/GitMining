package data.map;

import java.util.List;

import Info.AddressInfo;

public interface MapServer {
	
	/**
	 * 获得人员的地址分布信息
	 * @return AddressInfo里包含地址经纬度信息和当地人数
	 */
	public List<AddressInfo> getAddressDistribute();
}
