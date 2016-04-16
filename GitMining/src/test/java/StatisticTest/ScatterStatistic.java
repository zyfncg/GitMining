package StatisticTest;

import org.junit.Test;

import Info.ScatterDiagramStatistic;
import RepositoryStatistic.GetRepositoryStatistic.ScatterStatisticRep;

public class ScatterStatistic {
	@Test
	public void test(){ 
		ScatterStatisticRep scatterStatisticRep = new ScatterStatisticRep();
		ScatterDiagramStatistic ScatterDiagram = scatterStatisticRep.getRepScatterInfo();
		System.out.println(ScatterDiagram.getParameterA()+" "+ScatterDiagram.getParameterB());
	}
	public static void main(String[] args) {
		ScatterStatistic scatterStatistic = new ScatterStatistic();
		scatterStatistic.test();
	}
}
