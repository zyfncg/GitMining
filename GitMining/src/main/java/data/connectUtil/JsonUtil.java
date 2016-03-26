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
import net.sf.json.JSONArray;
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
	public static ProjectInfo jsonToProject(String jsonString){
		JSONObject json;
		
		ProjectName proname;
		String owner;
		String reponame;
		String description="";
		String contributorsNameURL;
		int forks;
		int stars;
		int contributors = 0;
		
		try {
		    json = JSONObject.fromObject(jsonString);  
		    
		    JSONObject ownerJson=json.getJSONObject("owner");
		    
		    reponame=json.getString("name");
		    owner=ownerJson.getString("login");
		    forks=json.getInt("forks_count");
		    stars=json.getInt("stargazers_count");
		    proname=new ProjectName(owner,reponame);
		    
		    contributorsNameURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/contributors/login";
		    
		    String contributorsName;
		    
		    description=getFromJson(json,"description");
		    if(description==null){
		    	description=Strings.DEFAULT_DESCRIPTION;
		    }
		    
		    try {
				contributorsName=HttpRequestUtil.httpRequest(contributorsNameURL);
				String contributorsNameList[]=contributorsName.split(",");
				contributors=contributorsNameList.length;
			} catch (Exception e) {
				e.printStackTrace();
				contributors=0;
				return new ProjectInfo(description,proname,forks,stars,contributors);
			}
		   
		} catch (JSONException e) {
		      e.printStackTrace();      
		      return null;
		}
		
		return new ProjectInfo(description,proname,forks,stars,contributors);
	}
	
	/**
	 *@param json格式的字符串
	 *@return json转为的ProjectDetail类 
	 * 
	 */
	public static ProjectDetail jsonToProjectDetail(String jsonString){
		
		StringListTool stringTool=new StringListTool();
		FileUtil userFile=new FileUtil();
		ProjectDetail proDetail;
		
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
		
		int pullRequest;
		int size;
		int commit;
		int issue;
//		UserInfo userInfo;
		
		ProjectInfo projectInfo=jsonToProject(jsonString);
		
		json = JSONObject.fromObject(jsonString);
		
		proname=projectInfo.getProjectName();
		owner=proname.getowner();
		reponame=proname.getrepository();
		
		forks=projectInfo.getForks();
		stars=projectInfo.getStars();
		description=projectInfo.getDescription();
		contributors=projectInfo.getContributors();
		
		URL=json.getString("html_url");
		subscribers=json.getInt("subscribers_count");
		size=json.getInt("size");
		
		//获取commit的数量
		String commitURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/commits/shas";
		commit=getCommitNumber(commitURL);
		
		//获取pullRequest数量
		String pullURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/pulls";
		pullRequest=getPullAndIssueNumber(pullURL);
		
		//获取issue数量
		String issueURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/issues";
		issue=getPullAndIssueNumber(issueURL);
		
		List<UserInfo> allUser = null;
		try {
			allUser = userFile.getUserListFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//获取所有contributors的个人信息
		List<UserInfo> contributorsInfo=new ArrayList<UserInfo>();
		String contributorsListURL;
		List<String> contributorsList;
		contributorsListURL=URLString.getRepositoryApiString()+owner+"/"+reponame+"/contributors/login";
		String contributorsString = null;
		try {
			contributorsString = HttpRequestUtil.httpRequest(contributorsListURL);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contributorsList=stringTool.getStringList(contributorsString);
		
		
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
		String collaboratorsName=null;
		try {
			collaboratorsName = HttpRequestUtil.httpRequest(collaboratorsNameURL);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    List<String> collaboratorsNameList=stringTool.getStringList(collaboratorsName);
	    collaborators=collaboratorsNameList.size();
	    

	    for(String name:collaboratorsNameList){
			for(UserInfo user:allUser){
				if(user.getUserName().equals(name)){
					collaboratorsInfo.add(user);
					continue;
				}
			}
		}
		
	    language=getFromJson(json,"language" );
	    if(language==null){
	    	language=Strings.DEFAULT_LAUNGUAGE;
	    }
	    proDetail=new ProjectDetail(description, language, URL, proname, forks,
	    		stars, contributors, collaborators,subscribers, contributorsInfo, collaboratorsInfo);
	    proDetail.setSize(size);
	    proDetail.setCommit(commit);
	    proDetail.setPullRequest(pullRequest);
	    proDetail.setIssue(issue);
	    
		return proDetail;

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
		
		descriptionUser=getFromJson(json,"bio");
		if(descriptionUser==null){
			descriptionUser=Strings.DEFAULT_BIO;
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
		
		address=getFromJson(json, "location");
		if(address==null){
			address=Strings.DEFAULT_LOCATION;
		}
		email=getFromJson(json, "email");
		if(email==null){
			email=Strings.DEFAULT_EMAIL;
		}
		company=getFromJson(json, "company");
		if(company==null){
			company=Strings.DEFAULT_COMPANY;
		}
		descriptionUser=getFromJson(json, "bio");
		if(descriptionUser==null){
			descriptionUser=Strings.DEFAULT_BIO;
		}
			
		return new UserInfoDetail(userName, descriptionUser, email, joinDate, company,
				address, projectInvolved, projectCreate, ProjectCreatList);
			
	}
	
	/**
	 *从json字符串中获取键值为key的字符串 
	 * 
	 */
	private static String getFromJson(JSONObject json,String key){
		String result;
		
		try {
			result=json.getString(key);
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
    private static int getCommitNumber(String url){
    	
    	StringListTool stringTool=new StringListTool();
    	String page="?page=";
    	String retStr="";
    	List<String> list;
    	int i=1;
    	int num=0;
//    	try {
//			retStr=HttpRequestUtil.httpRequest(url+page+i);
//			while(retStr.length()>2){
//	    		list=stringTool.getStringList(retStr);
//	    		num=num+list.size();
//	    		i++;
//	    		try {
//					retStr=HttpRequestUtil.httpRequest(url+page+i);
//				} catch (Exception e) {
//					e.printStackTrace();
//					return num;
//				}
//	    	}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
    	
    	return num;
    }

    private static int getPullAndIssueNumber(String url){
    	JSONArray pullJSONList;
    	int num=0;
    	try {
			String retStr=HttpRequestUtil.httpRequest(url);
			pullJSONList=JSONArray.fromObject(retStr);
			JSONObject jb=pullJSONList.getJSONObject(0);
			num=jb.getInt("number");
		} catch (Exception e) {
//			e.printStackTrace();
			return 0;
		}
    	
    	return num;
    }
}
