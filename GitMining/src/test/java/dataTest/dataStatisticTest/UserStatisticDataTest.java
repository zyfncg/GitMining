package dataTest.dataStatisticTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import data.dataImpl.statistisDataImpl.UserStatisticData;

public class UserStatisticDataTest {

	UserStatisticData userStatistic;
	
	@Before
	public void setUp() throws Exception {
		userStatistic= new UserStatisticData();
	}

	@Test
	public void testGetStatisticUsersInfo() {
		List<UserInfoDetail> userList = null;
		
		try {
			userList=userStatistic.getStatisticUsersInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true,userList!=null);
	}

	@Test
	public void testGetStatisticedInfo() {
		SaveUserStatisticInfo userStatisticInfo = null;
		try {
			userStatisticInfo=userStatistic.GetStatisticedInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,userStatisticInfo!=null);
	}

}
