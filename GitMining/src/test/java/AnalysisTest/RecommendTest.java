package AnalysisTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Info.ProjectDetail;
import Info.UserInfoDetail;
import recommend.RecommendLogic;
import recommend.RecommendService;

public class RecommendTest {
	@Test
	public void test(){
		RecommendService recommend = new RecommendLogic();
		List<ProjectDetail> projectDetails = recommend.getProjects("");
		List<UserInfoDetail> userInfoDetails = recommend.getDevelopers("");
		assertEquals("jquery/jquery",projectDetails.get(0).getProjectName().getowner()+"/"+projectDetails.get(0).getProjectName().getrepository());
//		for(ProjectDetail temp:projectDetails){
//			System.out.println(temp.getProjectName());
//		}
//		System.out.println("\n"+"123"+"\n");
		assertEquals("scrooloose",userInfoDetails.get(0).getUserName()); 
//		for(UserInfoDetail temp2:userInfoDetails){
//			System.out.println(temp2.getUserName());
//		}
		List<ProjectDetail> TopSix = recommend.getTop();
		assertEquals("jquery/jquery",TopSix.get(0).getProjectName().getowner()+"/"+TopSix.get(0).getProjectName().getrepository());
//		System.out.println(TopSix.get(0).getProjectName());
		recommend.updateLanguageInfo("", "unknown");
		recommend.updateCompanyInfo("", "unknown");
	}
	
	
//	public static void main(String[] args) {
//		RecommendService recommend = new RecommendLogic();
//		List<ProjectDetail> projectDetails = recommend.getProjects("");
//		List<UserInfoDetail> userInfoDetails = recommend.getDevelopers("@$nlh$UH#*(aq");
//		for(ProjectDetail temp:projectDetails){
//			System.out.println(temp.getProjectName());
//		}
//		System.out.println("\n"+"123"+"\n");
//		for(UserInfoDetail temp2:userInfoDetails){
//			System.out.println(temp2.getUserName());
//		}
//		List<ProjectDetail> TopSix = recommend.getTop();
//	}
}
