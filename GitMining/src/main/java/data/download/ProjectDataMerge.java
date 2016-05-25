package data.download;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectName;
import data.dataImpl.FileUtil;
import data.download.connectUtil.HttpRequestUtil;
import data.download.connectUtil.StringListTool;
import data.download.connectUtil.URLString;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProjectDataMerge {
	/**
	 * 使用URL获得所有的项目的日期信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean setProjectDate(){
		FileUtil fileUtil=new FileUtil();
		
		ProjectDetail projectDetail;
		String projectURL;
		String projectJson = null;
		List<ProjectDetail> projectList;
		try {
			projectList = fileUtil.getProjectDetailList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		Date creatDate;
		ProjectName pn;
		for(int i=0;i<projectList.size();i++){
			projectDetail=projectList.get(i);
			pn=projectDetail.getProjectName();
			projectURL=URLString.getRepositoryApiString()+pn.toString();
			try {
				projectJson=HttpRequestUtil.httpRequest(projectURL);
				if(projectJson==null){
					System.out.println("null "+i);
					continue;
				}
			
				creatDate=getDateFromJSON(projectJson);
				projectDetail.setCreatDate(creatDate);
				projectList.set(i, projectDetail);
	
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			if(i%100==0){
				System.out.println(i);
			}
			
		}
		
		if(!fileUtil.setProjectDetailToFile(projectList)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 使用URL获得所有用户的项目的userCommits信息并写到项目文件中
	 * @author ZhangYF
	 * @return 是否获取成功
	 * 
	 */
	public boolean setUserCommits(){
		FileUtil fileUtil=new FileUtil();
		ProjectDetail projectDetail;
		List<ProjectDetail> projectList;
		List<Integer> commitList;
		
		try {
			projectList = fileUtil.getProjectDetailList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		String projectURL;
		int commit=0;
		ProjectName pn;
		Map<String,Integer> userCommits;

		for(int i=0;i<projectList.size();i++){
			projectDetail=projectList.get(i);
			pn=projectDetail.getProjectName();
			if(pn.toString().contains(".")){
				System.out.println(pn.toString());
			}
			String pname=pn.toString().replace(".", "+");
			projectURL=URLString.getRepositoryApiString()+pname;

			try {

				userCommits=getUserCommitMap(projectURL);
				commit=0;
				for(Integer value:userCommits.values()){
					commit=commit+value;
				}
				projectDetail.setUserCommits(userCommits);
				projectDetail.setCommit(commit);
				projectList.set(i, projectDetail);

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			if(i%10==0){
				System.out.println(i);
			}
			
		}
		
		if(!fileUtil.setProjectDetailToFile(projectList)){
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 使用URL获得项目的commit信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean setCommitData(){
		FileUtil fileUtil=new FileUtil();
		//ProjectFile pf=new ProjectFile();
		ProjectDetail projectDetail;
		String projectURL;
		List<ProjectDetail> projectList;
		//List<Integer> commitList=new ArrayList<Integer>();
		try {
			projectList = fileUtil.getProjectDetailList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		int commit;
		ProjectName pn;
		for(int i=0;i<projectList.size();i++){
			projectDetail=projectList.get(i);
			pn=projectDetail.getProjectName();
			if(pn.toString().contains(".")){
				System.out.println(pn.toString());
			}
			String pname=pn.toString().replace(".", "+");
			projectURL=URLString.getRepositoryApiString()+pname;
			try {
			
				commit=getCommitNumber(projectURL);
//				projectDetail.setCommit(commit);
//				projectList.set(i, projectDetail);
//				commitList.add(commit);
				projectDetail.setCommit(commit);
				projectList.set(i, projectDetail);
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			if(commit>5000||i==185){
				System.out.println(i+":"+commit);
			}
		
			if(i%10==0){
				System.out.println(i+":"+commit);
			}
			
		}
		
		if(!fileUtil.setProjectDetailToFile(projectList)){
			return false;
		}
		
		return true;
	}
	
	private Date getDateFromJSON(String jsonString){
		Date creatDate;
		JSONObject json;
		json = JSONObject.fromObject(jsonString);
		String dateString=json.getString("created_at");
		creatDate=Date.stringToDate(dateString);
		
		return creatDate;
	}
	
	
	 private int getCommitNumber(String url){
	    	
	    	StringListTool stringTool=new StringListTool();
	    	String page="/commits/shas?page=";
	    	String retStr="";
	    	List<String> list;
	    	int seg=32;
	    	int i=1;
	    	int num=0;
	    	boolean isRange=false; //是否找到大小区间
	    	try {
				retStr=HttpRequestUtil.httpRequest(url+page+i);
				if(retStr==null||retStr.length()<3){
//					System.out.println(retStr);
					return 0;
				}
				while(seg>0){
		    		i=i+seg;
		    		
					retStr=HttpRequestUtil.httpRequest(url+page+i);
//					System.out.print(i+" ");
					if(retStr==null||retStr.length()<3){
						i=i-seg;
						seg=seg>>1;
					    isRange=true;
						continue;
					}else{
						list=stringTool.getStringList(retStr);
						num=50*(i-1)+list.size();
						if(!isRange){
							seg=seg<<1;
						}
						
					}
					 	
		    	}
			} catch (Exception e) {
//				e.printStackTrace();
				return num;
			}
	    	
	    	return num;
	    }

	 private Map<String,Integer> getUserCommitMap(String url) {

		 Map<String,Integer> userCommits=new HashMap<String,Integer>();
		 JSONArray commitJSONList;
		 JSONObject jb;
		 StringListTool stringTool=new StringListTool();
		 String page="/commits?page=";
		 String retStr="";
		 String name;
		 int commits;
		 int i=1;

		 try {
			 retStr=HttpRequestUtil.httpRequest(url+page+i);
//			 System.out.println(url+page+i);
			 while(retStr!=null&&retStr.length()>2){
				 commitJSONList=JSONArray.fromObject(retStr);
				 for(int k=0;k<commitJSONList.size();k++){
					 jb=commitJSONList.getJSONObject(k);
					 jb=jb.getJSONObject("commit");
					 jb=jb.getJSONObject("author");
					 name=jb.getString("name");

					 if(userCommits.containsKey(name)){
						 commits=(Integer) userCommits.get(name);
						 userCommits.put(name,commits+1);
					 }else{
						 userCommits.put(name,1);
					 }
				 }
				 
				 i++;
				 if(i%20==0){
					 System.out.println("page="+i);
				 }
				 retStr=HttpRequestUtil.httpRequest(url+page+i);

			 }
			 System.out.println("endPage="+i);
		 } catch (Exception e) {
			 System.out.println("endPage="+i);
			 e.printStackTrace();
			 return userCommits;
		 }



		 return userCommits;
	 }
}
