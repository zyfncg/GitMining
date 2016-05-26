package data.dataServer.statisticServer;

import java.util.List;
import java.util.Map;

import Info.AddressInfo;

public interface AddressServer {

	/**
	 * 通过地址获得地址的经纬度信息
	 * @param name
	 * @return 无法获取时返回null
	 */
	public AddressInfo getAddressByName(String name);
	
	
	
	/**
	 * 获得地址名称map中对应的key值
	 * @param name
	 * @return key值，如果不存在返回null
	 */
	public List<String> getMapKey(String name);
	
	/**
	 * 获得map数据
	 * @return
	 */
	public Map<String,AddressInfo> getMapData();
	
	/**
	 * 保存map数据
	 * @param map
	 * @return
	 */
	public boolean saveMapData(Map<String,AddressInfo> map);
}
