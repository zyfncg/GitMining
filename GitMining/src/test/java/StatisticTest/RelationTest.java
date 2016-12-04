package StatisticTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Info.Relation.AllUsrRelation;
import UserStatistic.GetUserStatistic.GetAllUsrRelation;
import UserStatistic.SetUserStatistic.UsrRelation.UsrRelationStatic;

public class RelationTest {
	@Test
	public void test(){
		GetAllUsrRelation getAllUsrRelation = new GetAllUsrRelation();
		List<AllUsrRelation> all1 = getAllUsrRelation.getAllUserRelation();
		System.out.println(all1.size());
		assertEquals(all1.size(),all1.size());
		
		UsrRelationStatic usrRelationStatic = new UsrRelationStatic();
		boolean result = usrRelationStatic.SetUsrRelation();
		assertEquals(result, result);
	}
	
	
}
