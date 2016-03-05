package businessLogicService.UserBLService;
import java.util.List;

import Info.*;

/**
 *description:业务逻辑层为展示层提供的服务 
 * @author 阮威威
 */
public interface UserBLService {
	/**
	 *description: 取得全部的用户信息列表
	 * 前置条件：无
	 * 后置条件：返回用户信息列表
	 * 需要的服务： UserData.getAllUsers
	 * @return 返回用户信息列表
	 * @throws Exception 
	 */
	public List<UserInfoDetail> getAllUsers()throws Exception;
	/**
	 *description: 取得某一用户详细信息
	 * 前置条件：无
	 * 后置条件：返回用户详细信息
	 * 需要的服务： UserData.getUserByName
	 * @param Name :用户名
	 * @return 返回用户详细信息
	 * @throws Exception 
	 */
	public UserInfoDetail getUserByName(String name)throws Exception;
	/**
	 *description: 通过关键字搜索
	 * 前置条件：无
	 * 后置条件：返回用户信息列表
	 * 需要的服务： UserData.getAllUsers
	 * @param Key :关键字（String）
	 * @return 返回用户信息列表
	 * @throws Exception 
	 */
	public List<UserInfoDetail> searchUsers(String key)throws Exception;
}
