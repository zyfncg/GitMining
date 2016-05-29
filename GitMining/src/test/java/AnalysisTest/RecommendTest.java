package AnalysisTest;

import java.util.List;

import Info.ProjectDetail;
import Info.UserInfoDetail;
import recommend.RecommendLogic;
import recommend.RecommendService;

public class RecommendTest {

	
	
	public static void main(String[] args) {
		RecommendService recommend = new RecommendLogic();
		List<ProjectDetail> projectDetails = recommend.getProjects("asd");
		List<UserInfoDetail> userInfoDetails = recommend.getDevelopers("123");
		for(ProjectDetail temp:projectDetails){
			System.out.println(temp.getProjectName());
		}
		System.out.println("\n"+"123"+"\n");
		for(UserInfoDetail temp2:userInfoDetails){
			System.out.println(temp2.getUserName());
		}
	}
}
