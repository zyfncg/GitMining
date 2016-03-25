package UserStatistic.SetUserStatistic.DetailAnalyze;

import java.util.ArrayList;
import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.CatalogStatistics;

public class SetCatalogStatistic {
	public List<CatalogStatistics> makeCatalogStatistic(List<UserInfoDetail> userInfoDetails){
		List<CatalogStatistics> allcatalogResult = new ArrayList<CatalogStatistics>();
		
		int UserSize = userInfoDetails.size();
		
		//统计用户的全部类型
		List<String> allCatalog = new ArrayList<String>();
		for(UserInfoDetail tempUserInfo:userInfoDetails){
			if (!allCatalog.contains(tempUserInfo.getUserType())) {
				allCatalog.add(tempUserInfo.getUserType());
			}
		}
		
		//对各种类型进行统计
		for(int i=0;i<allCatalog.size();i++){
			int CatalogNumber =0;
			for(UserInfoDetail tempUserInfo:userInfoDetails){
				if ((tempUserInfo.getUserType()).equals(allCatalog.get(i))) {
					CatalogNumber++;
				}
			}
			double CataloNum = CatalogNumber / UserSize;
			CatalogStatistics catalogStatistics = new CatalogStatistics(allCatalog.get(i), CataloNum);
			allcatalogResult.add(catalogStatistics);
		}
		
		
		return allcatalogResult;
	}
}
