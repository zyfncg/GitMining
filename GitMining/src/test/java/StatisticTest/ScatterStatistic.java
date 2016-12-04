package StatisticTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Info.ScatterDiagramStatistic;
import RepositoryStatistic.GetRepositoryStatistic.ScatterStatisticRep;
import RepositoryStatistic.GetRepositoryStatistic.ScatterStatisticRepSmall;
import UserStatistic.GetUserStatistic.ScatterStatisticUsr;
import UserStatistic.GetUserStatistic.ScatterStatisticUsrSmall;

public class ScatterStatistic {
	@Test
	public void test(){ 
		ScatterStatisticRep scatterStatisticRep = new ScatterStatisticRep();
		ScatterDiagramStatistic ScatterDiagram = scatterStatisticRep.getRepScatterInfo();
//		System.out.println(ScatterDiagram.getParameterA()+" "+ScatterDiagram.getParameterB());
		assertEquals(true, ScatterDiagram!=null);
		assertEquals(ScatterDiagram.getParameterA(),ScatterDiagram.getParameterA(),0.00);
		assertEquals(ScatterDiagram.getParameterB(),ScatterDiagram.getParameterB(),0.00);
		
		ScatterStatisticRepSmall scatterStatisticRep2 = new ScatterStatisticRepSmall();
		ScatterDiagramStatistic ScatterDiagram2 = scatterStatisticRep2.getRepScatterInfo();
//		System.out.println(ScatterDiagram2.getParameterA()+" "+ScatterDiagram2.getParameterB());
		assertEquals(true, ScatterDiagram2!=null);
		assertEquals(ScatterDiagram2.getParameterA(),ScatterDiagram2.getParameterA(),0.00);
		assertEquals(ScatterDiagram2.getParameterB(),ScatterDiagram2.getParameterB(),0.00);
		
		ScatterStatisticUsr scatterStatisticUsr = new ScatterStatisticUsr();
		ScatterDiagramStatistic scatterDiagram = scatterStatisticUsr.getUsrScatterInfo();
//		System.out.println(scatterDiagram.getParameterA()+" "+scatterDiagram.getParameterB());
		assertEquals(true, scatterDiagram!=null);
		assertEquals(scatterDiagram.getParameterA(),scatterDiagram.getParameterA(),0.00);
		assertEquals(scatterDiagram.getParameterB(),scatterDiagram.getParameterB(),0.00);
		
		ScatterStatisticUsrSmall scatterStatisticUsrSmall = new ScatterStatisticUsrSmall();
		ScatterDiagramStatistic scatterDiagram2 = scatterStatisticUsrSmall.getUsrScatterInfo();
//		System.out.println(scatterDiagram2.getParameterA()+" "+scatterDiagram2.getParameterB());
		assertEquals(true, scatterDiagram2!=null);
		assertEquals(scatterDiagram2.getParameterA(),scatterDiagram2.getParameterA(),0.00);
		assertEquals(scatterDiagram2.getParameterB(),scatterDiagram2.getParameterB(),0.00);
	}
//	public static void main(String[] args) {
//		ScatterStatistic scatterStatistic = new ScatterStatistic();
//		scatterStatistic.test();
//	}
}
