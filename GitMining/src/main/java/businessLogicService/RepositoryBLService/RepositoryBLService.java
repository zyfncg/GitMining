package businessLogicService.RepositoryBLService;
import java.util.List;

import Info.*;
import constant.SortType;

/**
 *description:业务逻辑层为展示层提供的服务 
 * @author 阮威威
 */
public interface RepositoryBLService {
	/**
	 *description: 取得全部的项目信息列表
	 * 前置条件：无
	 * 后置条件：返回项目信息列表
	 * 需要的服务： RepositoryData.getAllProjects
	 * @return 返回项目信息列表
	 * @throws Exception 
	 */
	public List<ProjectInfo> getAllRepositorys();
	/**
	 *description: 取得某一项目详细信息
	 * 前置条件：无
	 * 后置条件：返回项目详细信息
	 * 需要的服务： RepositoryData.getProjectByName
	 * @param ProjectName :项目名与用户名
	 * @return 返回项目详细信息
	 * @throws Exception 
	 */
	public ProjectDetail getRepositoryByName(ProjectName name);
	/**
	 *description: 通过关键字搜索
	 * 前置条件：无
	 * 后置条件：返回项目信息列表
	 * 需要的服务： RepositoryData.getAllProjects
	 * @param Key :关键字（String）
	 * @return 返回项目信息列表
	 * @throws Exception 
	 */
	public List<ProjectInfo> searchRepositorys(String key);
	/**
	 *description: 通过相应排序方法排序项目
	 * 前置条件：无
	 * 后置条件：返回排序后的项目信息列表
	 * 需要的服务： RepositoryData.getAllProjects
	 * @param SortType :排序信息
	 * @return 返回项目信息列表
	 * @throws Exception 
	 */
	public List<ProjectInfo> getSortedRepositorys(SortType type);
	
}
