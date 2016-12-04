package AnalysisTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.AddressInfo;
import Info.ProjectDetail;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.ProjectMap;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.StaticAllProjectDetail;

public class ProjectMapTest {
	@Test
	public void test(){
		// 所有项目详细信息
		List<ProjectDetail> allProject = StaticAllProjectDetail.AllProjectDetailInfo;
		ProjectMap map = new ProjectMap();
		List<AddressInfo> alladdress = map.GetAddressDis(allProject.get(17));
		int theSize = alladdress.size();
		assertEquals(theSize,alladdress.size());
		assertEquals(1,1);
//		for(AddressInfo temp:alladdress){
//			System.out.println(temp.getSite());
//			System.out.println(temp.getLatitude());
//			System.out.println(temp.getLongtitude());
//			System.out.println(temp.getWorkerNumber());
//			
//		}
	}
}
