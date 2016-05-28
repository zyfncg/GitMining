package recommend;

import java.util.List;

import Info.ProjectInfo;
import Info.UserInfoDetail;

public interface RecommendService {
	
	//由用户id获得向该用户推荐的项目信息
	public List<ProjectInfo> getProjects(String user_id);
	//由用户id获得向该用户推荐的开发者信息
	public List<UserInfoDetail> getDevelopers(String user_id);
	//更新用户对该语言的引用次数
	public void updateLanguageInfo(String user_id, String language);
	//更新用户对该开发者的引用次数
	public void updateDeveloperInfo(String user_id, String name);
	//更新用户对该公司的引用次数
	public void updateCompanyInfo(String user_id, String company);
	//更新用户对该项目的引用次数
	public void updateProjectInfo(String user_id, String name);
}
