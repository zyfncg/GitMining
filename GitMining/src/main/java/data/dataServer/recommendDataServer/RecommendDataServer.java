package data.dataServer.recommendDataServer;

import Info.ProjectDetail;
import Info.UserInfoDetail;

public interface RecommendDataServer {
	
	
	/**
	 * 更新用户对某语言的引用次数
	 * @param user_id
	 * @param language
	 */
	public boolean SaveLanguage(String user_id,String language);
	
	/**
	 * 更新用户对某开发者的引用次数
	 * @param user_id
	 * @param UserName
	 */
	public boolean updateDeveloperInfo(String user_id, String UserName);

	/**
	 * 更新用户对某公司的引用次数
	 * @param user_id
	 * @param company
	 */
	public boolean updateCompanyInfo(String user_id, String company);
	
	/**
	 * 更新用户对某项目的引用次数
	 * @param user_id
	 * @param ProjectName
	 */
	public boolean updateProjectInfo(String user_id, String ProjectName);


	/**
	 * 取得引用次数排序第num的项目
	 * @param num
	 * @return
	 */

	public ProjectDetail getOneProject(String user_id,int num);

	
	/**
	 * 取得引用次数排序第num的用户
	 * @param num
	 * @return
	 */
	public UserInfoDetail getOneUser(String user_id,int num);
	
	/**
	 * 取得引用次数最多的语言
	 * @return
	 */
	public String getLanguage(String user_id);
	
	/**
	 * 取得引用次数做多的公司
	 * @return
	 */
	public String getCompany(String user_id);



}
