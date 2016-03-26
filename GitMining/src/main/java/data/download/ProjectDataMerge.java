package data.download;

import java.util.List;

import Info.Date;
import Info.ProjectDetail;
import Info.ProjectName;
import data.connectUtil.HttpRequestUtil;
import data.connectUtil.StringListTool;
import data.connectUtil.URLString;
import data.dataImpl.FileUtil;
import net.sf.json.JSONObject;

public class ProjectDataMerge {
	/**
	 * 使用URL获得所有的项目的时间信息并写到文件中
	 * @author ZhangYF
	 * @return 是否下载成功 
	 * 
	 */
	public boolean setProjectDate(){
		String projectListUrl=URLString.getRepositoryApiString()+"names";
		StringListTool stringTool=new StringListTool();
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
		
		String reponameList;
		try {
			reponameList = HttpRequestUtil.httpRequest(projectListUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		List<String> reponame=stringTool.getStringList(reponameList);
		
		Date creatDate;
		ProjectName pn;
		int k=0;
		for(int i=0;i<reponame.size();i++){
			projectURL=URLString.getRepositoryApiString()+reponame.get(i);
			try {
				projectJson=HttpRequestUtil.httpRequest(projectURL);
				if(projectJson==null){
					continue;
				}
			
				projectDetail=projectList.get(i-k);
				creatDate=getDateFromJSON(projectJson);
				pn=getProjectNameFromJSON(projectJson);
				if(pn.isSame(projectDetail.getProjectName())){
					projectDetail.setCreatDate(creatDate);
					projectList.set(i-k, projectDetail);
				}else{
					k++;
					System.out.println("NOT CORRESPOND:"+k);
				}
				
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
	
	
	private Date getDateFromJSON(String jsonString){
		Date creatDate;
		JSONObject json;
		json = JSONObject.fromObject(jsonString);
		String dateString=json.getString("created_at");
		creatDate=Date.stringToDate(dateString);
		
		return creatDate;
	}
	
	private ProjectName getProjectNameFromJSON(String jsonString){
		ProjectName pn;
		JSONObject json;
		String owner;
		String reponame;
		
		json = JSONObject.fromObject(jsonString);
		JSONObject ownerJson=json.getJSONObject("owner");
		reponame=json.getString("name");
	    owner=ownerJson.getString("login");
		
	    pn=new ProjectName(owner,reponame);
		
	    return pn;
	}
}
