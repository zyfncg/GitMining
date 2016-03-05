package data.connectUtil;

import Info.ProjectDetail;
import Info.ProjectInfo;
import Info.ProjectName;
import Info.UserInfo;
import Info.UserInfoDetail;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

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
		String description;
		String contributorsNameURL;
		int forks;
		int stars;
		int contributors;
		
		try {
		    json = JSONObject.fromObject(jsonString);  
		    
		    JSONObject ownerJson=json.getJSONObject("owner");
		    
		    description=json.getString("description");
		    reponame=json.getString("name");
		    owner=ownerJson.getString("login");
		    forks=json.getInt("forks_count");
		    stars=json.getInt("stargazers_count");
		    proname=new ProjectName(owner,reponame);
		    contributorsNameURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/contributors/login";
		    
		    String contributorsName=HttpRequestUtil.httpRequest(contributorsNameURL);
		    String contributorsNameList[]=contributorsName.split(",");
		    contributors=contributorsNameList.length;
		    

		    
		} catch (JSONException e) {

		      e.printStackTrace();
		      throw e;

		}
		
		return new ProjectInfo(description,proname,forks,stars,contributors);
	}
	
	/**
	 *@param json格式的字符串
	 *@return json转为的ProjectDetail类 
	 * 
	 */
	public static ProjectDetail jsonToProjectDetail(String jsonString) throws Exception{
		JSONObject json;
		
		ProjectName proname;
		String language;
		String URL;
		String owner;
		String reponame;
		String description;
		String collaboratorsNameURL;
		int forks;
		int stars;
		int contributors;
		int collaborators;
		
		ProjectInfo projectInfo=jsonToProject(jsonString);
		
		json = JSONObject.fromObject(jsonString);
		proname=projectInfo.getProjectName();
		owner=proname.getowner();
		reponame=proname.getrepository();
		
		description=projectInfo.getDescription();
		URL=json.getString("html_url");
		language=json.getString("language");
		forks=projectInfo.getForks();
		stars=projectInfo.getStars();
		contributors=projectInfo.getContributors();
		
		collaboratorsNameURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/collaborators/login";
		String collaboratorsName=HttpRequestUtil.httpRequest(collaboratorsNameURL);
	    String collaboratorsNameList[]=collaboratorsName.split(",");
	    collaborators=collaboratorsNameList.length;
	    
		return new ProjectDetail(description, language, URL, proname, forks, stars, contributors, collaborators);
	}
	
	public static UserInfo jsonToUser(String jsonString)throws Exception{
		JSONObject json;
		
		String userName;
		String descriptionUser = null;
		int projectInvolved;
		int projectCreate;
		
		json = JSONObject.fromObject(jsonString);
		
		userName=json.getString("login");
		projectInvolved=json.getInt("public_repos");
		projectCreate=json.getInt("public_gists");
		
		return new UserInfo(userName, descriptionUser, projectInvolved, projectCreate);	
	}
	
	public static UserInfoDetail jsonToUserDetail(String jsonString)throws Exception{
		JSONObject json;
		
		String userName;
		String descriptionUser = null;
		String email;
		String joinDate;
		String company;
		String address;
		int projectInvolved;
		int projectCreate;
		
		json = JSONObject.fromObject(jsonString);
		
		userName=json.getString("login");
		email=json.getString("email");
		joinDate=json.getString("created_at");
		address=json.getString("location");
		projectInvolved=json.getInt("public_repos");
		projectCreate=json.getInt("public_gists");
		
		return new UserInfoDetail(userName, descriptionUser, email, joinDate, company, address, projectInvolved, projectCreate);	
	}
	
}
