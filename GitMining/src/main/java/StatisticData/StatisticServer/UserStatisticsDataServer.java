package StatisticData.StatisticServer;

import java.util.List;

import Info.UsrStatisticInfo.SaveUserStatisticInfo;
import Info.UsrStatisticInfo.UserStatisticInfo;

public interface UserStatisticsDataServer {

	//设置统计数据
	public List<UserStatisticInfo> getStatisticInfo();
	
	public boolean setStatisticInfo(SaveUserStatisticInfo saveUser);
	
	//取得统计好的数据
	public SaveUserStatisticInfo GetStatisticedInfo();
}
