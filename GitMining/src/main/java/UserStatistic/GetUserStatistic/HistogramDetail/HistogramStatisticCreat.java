package UserStatistic.GetUserStatistic.HistogramDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.HistogramInfo;
import Info.UserInfo;
import UserStatistic.GetUserStatistic.HistogramStatisticUser;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class HistogramStatisticCreat implements HistogramStatisticUser {

	public HistogramInfo getUsrHistogramInfo() {
		// 取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 最大值与最小值
		int CreatMax = userInfoList.get(0).getProjectCreate();
		int CreatMin = userInfoList.get(0).getProjectCreate();
		for (UserInfo tempuserInfo : userInfoList) {
			if (tempuserInfo.getProjectCreate() > CreatMax) {
				CreatMax = tempuserInfo.getProjectCreate();
			} else if (tempuserInfo.getProjectCreate() < CreatMin) {
				CreatMin = tempuserInfo.getProjectCreate();
			}
		}

		// 组数
		int GroupNum = 1 + (int) ((Math.log10(userInfoList.size())) / (Math.log10(2)));

		// 全部Creat Repository信息
		double[] allCreatInfo = new double[userInfoList.size()];
		for (int i = 0; i < userInfoList.size(); i++) {
			allCreatInfo[i] = userInfoList.get(i).getProjectCreate();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(CreatMax, CreatMin, GroupNum, allCreatInfo);
		return histogramInfo;
	}

	@Override
	public HistogramInfo getSmallUsrHistogramInfo() {
		// 取得全部用户粗略信息列表
		List<UserInfo> userInfoList = this.getSortedUser();

		List<UserInfo> smallUsrHis = new ArrayList<UserInfo>();
		for (int i = 0; i < (int) (userInfoList.size() * 0.9); i++) {
			smallUsrHis.add(userInfoList.get(i));
		}

		// 最大值与最小值
		int CreatMax = smallUsrHis.get(smallUsrHis.size() - 1).getProjectCreate();
		int CreatMin = smallUsrHis.get(0).getProjectCreate();

		// 组数
		int GroupNum = (1 + (int) ((Math.log10(smallUsrHis.size())) / (Math.log10(2))))*2;

		// 全部Creat Repository信息
		double[] allCreatInfo = new double[smallUsrHis.size()];
		for (int i = 0; i < smallUsrHis.size(); i++) {
			allCreatInfo[i] = smallUsrHis.get(i).getProjectCreate();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(CreatMax, CreatMin, GroupNum, allCreatInfo);
		return histogramInfo;
	}

	@Override
	public HistogramInfo getBigUsrHistogramInfo() {
		// 取得全部用户粗略信息列表
		List<UserInfo> userInfoList = this.getSortedUser();

		List<UserInfo> bigUsrHis = new ArrayList<UserInfo>();
		for (int i = (int) (userInfoList.size() * 0.9); i < userInfoList.size(); i++) {
			bigUsrHis.add(userInfoList.get(i));
		}

		// 最大值与最小值
		int CreatMax = bigUsrHis.get(bigUsrHis.size() - 1).getProjectCreate();
		int CreatMin = bigUsrHis.get(0).getProjectCreate();

		// 组数
		int GroupNum = (1 + (int) ((Math.log10(bigUsrHis.size())) / (Math.log10(2))))*2;

		// 全部Creat Repository信息
		double[] allCreatInfo = new double[bigUsrHis.size()];
		for (int i = 0; i < bigUsrHis.size(); i++) {
			allCreatInfo[i] = bigUsrHis.get(i).getProjectCreate();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(CreatMax, CreatMin, GroupNum, allCreatInfo);
		return histogramInfo;
	}

	public List<UserInfo> getSortedUser() {
		// 取得全部用户粗略信息列表
		UserHandle userHandle = new UserHandle();
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userHandle.GetAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.sort(userInfoList, new Comparator<UserInfo>() {
			@Override
			public int compare(UserInfo arg0, UserInfo arg1) {
				return (new Integer(arg0.getProjectCreate())).compareTo(new Integer(arg1.getProjectCreate()));
			}
		});

		return userInfoList;
	}

}
