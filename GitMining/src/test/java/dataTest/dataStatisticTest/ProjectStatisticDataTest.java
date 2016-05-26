package dataTest.dataStatisticTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Info.ProjectDetail;
import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import data.dataImpl.statistisDataImpl.ProjectStatisticData;

public class ProjectStatisticDataTest {

	ProjectStatisticData projectStatistic;
	
	@Before
	public void setUp() throws Exception {
		projectStatistic=new ProjectStatisticData();
	}

	@Test
	public void testGetStatisticRepositoryInfo() {
		List<ProjectDetail> proList = null;
		try {
			proList=projectStatistic.getStatisticRepositoryInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,proList!=null);
	}

	@Test
	public void testGetStatisticedInfo() {
		SaveRepositoryStatisticInfo repoStatistic=null;
		try {
			repoStatistic=projectStatistic.GetStatisticedInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true,repoStatistic!=null);
	}

}
