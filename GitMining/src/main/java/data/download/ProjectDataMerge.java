package data.download;

import java.util.ArrayList;
import java.util.List;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectName;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;
import data.dataImpl.FileUtil;
import data.statistisDataImpl.ProjectFile;
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
			projectList = fileUtil.getProjectDetailListFromFile();
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
	 * 从文件获得项目的commit信息并写到项目文件中
	 * @author ZhangYF
	 * @return 是否合并成功 
	 * 
	 */
	public boolean setCommitMerge(){
		FileUtil fileUtil=new FileUtil();
		ProjectFile pf=new ProjectFile();
		ProjectDetail projectDetail;
		List<ProjectDetail> projectList;
		List<Integer> commitList;
		
		try {
			projectList = fileUtil.getProjectDetailListFromFile();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		
			try {
				commitList=pf.getProjectCommit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		int commit;
		for(int i=0;i<projectList.size();i++){
			commit=commitList.get(i);
			projectDetail=projectList.get(i);
			projectDetail.setCommit(commit);
			
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
		ProjectFile pf=new ProjectFile();
		ProjectDetail projectDetail;
		String projectURL;
		List<ProjectDetail> projectList;
		List<Integer> commitList=new ArrayList<Integer>();
		try {
			projectList = fileUtil.getProjectDetailListFromFile();
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
}
