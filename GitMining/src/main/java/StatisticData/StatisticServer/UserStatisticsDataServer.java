package StatisticData.StatisticServer;

import java.util.List;

import Info.UserInfoDetail;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;

public interface UserStatisticsDataServer {

	//设置统计数据
	public List<UserInfoDetail> getStatisticInfo();
	
	public boolean setStatisticInfo(SaveUserStatisticInfo saveUser);
	
	//取得统计好的数据
	public SaveUserStatisticInfo GetStatisticedInfo();
}
