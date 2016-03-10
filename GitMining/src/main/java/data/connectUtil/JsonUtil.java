package data.connectUtil;

import java.util.ArrayList;
import java.util.List;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
import Info.UserInfoDetail;
import data.dataImpl.FileUtil;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import res.Strings;

/**
 *@author ZhangYF 
 * 
 */
public class JsonUtil {
	
	/**
	 *@param json格式的字符串
	 *@return json转为的ProjectInfo类 
	 * 
	 */
	public static ProjectInfo jsonToProject(String jsonString)throws Exception {
		JSONObject json;
		
		ProjectName proname;
		String owner;
		String reponame;
		String description="";
		String contributorsNameURL;
		int forks;
		int stars;
		int contributors;
		
		try {
		    json = JSONObject.fromObject(jsonString);  
		    
		    JSONObject ownerJson=json.getJSONObject("owner");
		    
		    reponame=json.getString("name");
		    owner=ownerJson.getString("login");
		    forks=json.getInt("forks_count");
		    stars=json.getInt("stargazers_count");
		    proname=new ProjectName(owner,reponame);
		    
		    contributorsNameURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/contributors/login";
		    
		    String contributorsName=HttpRequestUtil.httpRequest(contributorsNameURL);
		    String contributorsNameList[]=contributorsName.split(",");
		    contributors=contributorsNameList.length;
		    
		    try {
				description=json.getString("description");
			} catch (Exception e) {
				description=Strings.DEFAULT_DESCRIPTION;
				return new ProjectInfo(description,proname,forks,stars,contributors);
			}
		    
		    
		    

		} catch (JSONException e) {

		      e.printStackTrace();
		      
		      return null;

		}
		
		return new ProjectInfo(description,proname,forks,stars,contributors);
//		return new ProjectInfo(description,proname,forks,stars,12);
	}
	
	/**
	 *@param json格式的字符串
	 *@return json转为的ProjectDetail类 
	 * 
	 */
	public static ProjectDetail jsonToProjectDetail(String jsonString) throws Exception{
		
		StringListTool stringTool=new StringListTool();
		FileUtil userFile=new FileUtil();
		
		JSONObject json;
		
		ProjectName proname;
		String language;
		String URL;
		String owner;
		String reponame;
		String description;
		String collaboratorsNameURL;
//		String userURL;
//		String userJson;
		int forks;
		int stars;
		int contributors;
		int collaborators;
		int subscribers;
//		UserInfo userInfo;
		
		ProjectInfo projectInfo=jsonToProject(jsonString);
		
		json = JSONObject.fromObject(jsonString);
		
		proname=projectInfo.getProjectName();
		owner=proname.getowner();
		reponame=proname.getrepository();
		
		//获取所有contributors的个人信息
		List<UserInfo> contributorsInfo=new ArrayList<UserInfo>();
		String contributorsListURL;
		List<String> contributorsList;
		contributorsListURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/contributors/login";
		String contributorsString=HttpRequestUtil.httpRequest(contributorsListURL);
		contributorsList=stringTool.getStringList(contributorsString);
		
//		for(int i=0;i<contributorsList.size();i++){
//			userURL=URLString.getUserApiString()+contributorsList.get(i);
//			userJson=HttpRequestUtil.httpRequest(userURL);
//			userInfo=JsonUtil.jsonToUser(userJson);
//			contributorsInfo.add(userInfo);
//		}
		
		List<UserInfo> allUser=userFile.getUserListFromFile();
		for(String name:contributorsList){
			for(UserInfo user:allUser){
				if(user.getUserName().equals(name)){
					contributorsInfo.add(user);
					continue;
				}
			}
		}
		
		//获取所有的collaborators的个人信息
		List<UserInfo> collaboratorsInfo=new ArrayList<UserInfo>(); 
		collaboratorsNameURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/collaborators/login";
		String collaboratorsName=HttpRequestUtil.httpRequest(collaboratorsNameURL);
	    List<String> collaboratorsNameList=stringTool.getStringList(collaboratorsName);
	    collaborators=collaboratorsNameList.size();
	    
//	    for(int i=0;i<collaboratorsNameList.size();i++){
//			userURL=URLString.getUserApiString()+collaboratorsNameList.get(i);
//			userJson=HttpRequestUtil.httpRequest(userURL);
//			userInfo=JsonUtil.jsonToUser(userJson);
//			collaboratorsInfo.add(userInfo);
//		}
	    for(String name:collaboratorsNameList){
			for(UserInfo user:allUser){
				if(user.getUserName().equals(name)){
					collaboratorsInfo.add(user);
					continue;
				}
			}
		}
		
		URL=json.getString("html_url");
		language=json.getString("language");
		subscribers=json.getInt("subscribers_count");
		
		
		forks=projectInfo.getForks();
		stars=projectInfo.getStars();
		description=projectInfo.getDescription();
		contributors=projectInfo.getContributors();
		
		
		
		return new ProjectDetail(description, language, URL, proname, 
				forks, stars, contributors, collaborators,subscribers, contributorsInfo, collaboratorsInfo);

	}
	
	/**
	 *将json格式字符串转为UserInfo对象 
	 * 
	 */
	public static UserInfo jsonToUser(String jsonString)throws Exception{
		JSONObject json;
		
		String userName;
		String descriptionUser = null;
		int projectInvolved;
		int projectCreate;
		
		json = JSONObject.fromObject(jsonString);
		
		userName=json.getString("login");
		projectInvolved=json.getInt("following");
		projectCreate=json.getInt("public_repos");
		
		try {
			descriptionUser = json.getString("bio");
		} catch (Exception e) {
			e.printStackTrace();
			descriptionUser=Strings.DEFAULT_BIO;
			return new UserInfo(userName, descriptionUser, projectInvolved, projectCreate);
		}
		
		return new UserInfo(userName, descriptionUser, projectInvolved, projectCreate);	
	}
	
	/**
	 *将json字符串转为UserInfoDetail对象 
	 * 
	 */
	public static UserInfoDetail jsonToUserDetail(String jsonString)throws Exception{
		
		JSONObject json;
		FileUtil proFile=new FileUtil();
		
		String userName;
		String descriptionUser = "";
		String email="";
		Date joinDate;
		String company = "";
		String address;
		int projectInvolved;
		int projectCreate;
		List<ProjectInfo> ProjectCreatList=new ArrayList<ProjectInfo>();
		
		
		
		json = JSONObject.fromObject(jsonString);
		
		userName=json.getString("login");
		String dateString=json.getString("created_at");
		joinDate=Date.stringToDate(dateString);
		address=json.getString("location");
		projectInvolved=json.getInt("following");
		projectCreate=json.getInt("public_repos");
		
		List<ProjectInfo> projectList=proFile.getProjectListFromFile();
		ProjectName proName;
		for(ProjectInfo project:projectList){
			proName=project.getProjectName();
			if(proName.getowner().equals(userName)){
				ProjectCreatList.add(project);
			}
		}
		
		
		try {
			email=json.getString("email");
			descriptionUser = json.getString("bio");
		    company = json.getString("company");
		} catch (Exception e) {
			e.printStackTrace();
			email=Strings.DEFAULT_EMAIL;
			descriptionUser=Strings.DEFAULT_BIO;
		    company=Strings.DEFAULT_COMPANY;
		    System.out.println(userName);
		    return new UserInfoDetail(userName, descriptionUser, email, joinDate, company,
					address, projectInvolved, projectCreate, ProjectCreatList);
		}
			
		return new UserInfoDetail(userName, descriptionUser, email, joinDate, company,
				address, projectInvolved, projectCreate, ProjectCreatList);
			
	}
	
}
