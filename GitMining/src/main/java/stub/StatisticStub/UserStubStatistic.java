package stub.StatisticStub;

import java.util.ArrayList;
import java.util.List;

import Info.UsrStatisticInfo.CatalogStatistics;
import Info.UsrStatisticInfo.CompanyStatistics;
import Info.UsrStatisticInfo.CreatRepositoryStatistics;
import Info.UsrStatisticInfo.CreatTimeStatistics;
import Info.UsrStatisticInfo.JoinRepositoryStatistics;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;

public class UserStubStatistic {

	public SaveUserStatisticInfo GetStatisticedInfo() throws Exception {
		List<CatalogStatistics> catalogStatistics = new ArrayList<CatalogStatistics>();
		List<CompanyStatistics> companyStatistics = new ArrayList<CompanyStatistics>();
		List<CreatRepositoryStatistics> creatRepositoryStatistics = new ArrayList<CreatRepositoryStatistics>();
		List<CreatTimeStatistics> creatTimeStatistics = new ArrayList<CreatTimeStatistics>();
		List<JoinRepositoryStatistics> joinRepositoryStatistics = new ArrayList<JoinRepositoryStatistics>();

		for (int i = 0; i < 7; i++) {
			CatalogStatistics temp = new CatalogStatistics("alphgo" + i, 10 * (i + 1));
			catalogStatistics.add(temp);
		}

		for (int i = 0; i < 7; i++) {
			CompanyStatistics temp = new CompanyStatistics("alphgo" + i, 10 * (i + 1));
			companyStatistics.add(temp);
		}

		for (int i = 0; i < 7; i++) {
			CreatRepositoryStatistics temp = new CreatRepositoryStatistics("alphgo" + i, 10 * (i + 1));
			creatRepositoryStatistics.add(temp);
		}

		for (int i = 0; i < 7; i++) {
			CreatTimeStatistics temp = new CreatTimeStatistics("alphgo" + i, 10 * (i + 1));
			creatTimeStatistics.add(temp);
		}

		for (int i = 0; i < 7; i++) {
			JoinRepositoryStatistics temp = new JoinRepositoryStatistics("alphgo" + i, 10 * (i + 1));
			joinRepositoryStatistics.add(temp);
		}

		SaveUserStatisticInfo SaveResult = new SaveUserStatisticInfo(catalogStatistics, companyStatistics,
				creatRepositoryStatistics, creatTimeStatistics, joinRepositoryStatistics);
		;

		return SaveResult;
	}
}
