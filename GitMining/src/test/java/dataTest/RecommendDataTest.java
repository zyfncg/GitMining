package dataTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import data.dataImpl.recommendDataImpl.RecommendDataImpl;
import data.dataServer.recommendDataServer.RecommendDataServer;

public class RecommendDataTest {

	RecommendDataServer recommendData;
	@Before
	public void setUp() throws Exception {
		recommendData=new RecommendDataImpl();
	}

	@Test
	public void testSaveLanguage() {
		String user_id="12345678901234580";
		String language="java";
		assertEquals(true,recommendData.SaveLanguage(user_id, language));
	}

	@Test
	public void testUpdateDeveloperInfo() {
		String user_id="12345678901234580";
		String developer="茗柯";
		assertEquals(true,recommendData.updateDeveloperInfo(user_id, developer));
		assertEquals(true,recommendData.updateDeveloperInfo(user_id, "debasishg"));
		assertEquals(true,recommendData.updateDeveloperInfo(user_id, "debasishg"));
	}

	@Test
	public void testUpdateCompanyInfo() {
		String user_id="12345678901234580";
		String company="nju";
		assertEquals(true,recommendData.updateCompanyInfo(user_id, company));
	}

	@Test
	public void testUpdateProjectInfo() {
		String user_id="12345678901234580";
		String project="aboekhoff/congomongo";
		assertEquals(true,recommendData.updateProjectInfo(user_id, project));
	}

	@Test
	public void testGetOneProject() {
		String user_id="12345678901234580";
		int num=1;
		assertEquals(true,recommendData.getOneProject(user_id, num)!=null);
		assertEquals(true,recommendData.getOneProject(user_id, num+3)==null);
		assertEquals(true,recommendData.getOneProject("12343414123", num+3)==null);
	}

	@Test
	public void testGetOneUser() {
		String user_id="12345678901234580";
		int num=1;
		assertEquals(true,recommendData.getOneUser(user_id, num)!=null);
		assertEquals(true,recommendData.getOneUser(user_id, num+1)==null);
		assertEquals(true,recommendData.getOneUser("12343414123", num)==null);
	}

	@Test
	public void testGetLanguage() {
		String user_id="12345678901234580";
		assertEquals(true,recommendData.getLanguage(user_id).equals("java"));
		assertEquals(true,recommendData.getLanguage("12341432")==null);
	}

	@Test
	public void testGetCompany() {
		String user_id="12345678901234580";
		assertEquals(true,recommendData.getCompany(user_id).equals("nju"));
		assertEquals(true,recommendData.getCompany("123132414")==null);
	}

}
