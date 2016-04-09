package UserStatistic.GetUserStatistic.HistogramDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Info.HistogramInfo;
import Info.UserInfo;
import UserStatistic.GetUserStatistic.HistogramStatisticUser;
import businessLogic.businessLogicModel.UserModel.UserHandle;

public class HistogramStatisticJoin implements HistogramStatisticUser {

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
		int MaxJoin = userInfoList.get(0).getProjectInvolved();
		int MinJoin = userInfoList.get(0).getProjectInvolved();
		for (UserInfo tempUserInfo : userInfoList) {
			if (tempUserInfo.getProjectInvolved() > MaxJoin) {
				MaxJoin = tempUserInfo.getProjectInvolved();
			} else if (tempUserInfo.getProjectInvolved() < MinJoin) {
				MinJoin = tempUserInfo.getProjectInvolved();
			}
		}

		// 组数
		int GroupNum = 1 + (int) ((Math.log10(userInfoList.size())) / (Math.log10(2)));

		// 全部Creat Repository信息
		double[] allJoinInfo = new double[userInfoList.size()];
		for (int i = 0; i < userInfoList.size(); i++) {
			allJoinInfo[i] = userInfoList.get(i).getProjectInvolved();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(MaxJoin, MinJoin, GroupNum, allJoinInfo);
		return histogramInfo;
	}

	@Override
	public HistogramInfo getSmallUsrHistogramInfo() {
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
				return (new Integer(arg0.getProjectInvolved())).compareTo(new Integer(arg1.getProjectInvolved()));
			}
		});

		List<UserInfo> smallUsrHis = new ArrayList<UserInfo>();
		for (int i = 0; i < (int) (userInfoList.size() * 0.9); i++) {
			smallUsrHis.add(userInfoList.get(i));
		}

		// 最大值与最小值
		int MaxJoin = smallUsrHis.get(smallUsrHis.size() - 1).getProjectInvolved();
		int MinJoin = smallUsrHis.get(0).getProjectInvolved();

		// 组数
		int GroupNum = 1 + (int) ((Math.log10(smallUsrHis.size())) / (Math.log10(2)));

		// 全部Creat Repository信息
		double[] allJoinInfo = new double[smallUsrHis.size()];
		for (int i = 0; i < smallUsrHis.size(); i++) {
			allJoinInfo[i] = smallUsrHis.get(i).getProjectInvolved();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(MaxJoin, MinJoin, GroupNum, allJoinInfo);
		return histogramInfo;
	}

	@Override
	public HistogramInfo getBigUsrHistogramInfo() {
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
				return (new Integer(arg0.getProjectInvolved())).compareTo(new Integer(arg1.getProjectInvolved()));
			}
		});

		List<UserInfo> bigUsrHis = new ArrayList<UserInfo>();
		for (int i = (int) (userInfoList.size() * 0.9); i < userInfoList.size(); i++) {
			bigUsrHis.add(userInfoList.get(i));
		}

		// 最大值与最小值
		int MaxJoin = bigUsrHis.get(bigUsrHis.size() - 1).getProjectInvolved();
		int MinJoin = bigUsrHis.get(0).getProjectInvolved();

		// 组数
		int GroupNum = 1 + (int) ((Math.log10(bigUsrHis.size())) / (Math.log10(2)));

		// 全部Creat Repository信息
		double[] allJoinInfo = new double[bigUsrHis.size()];
		for (int i = 0; i < bigUsrHis.size(); i++) {
			allJoinInfo[i] = bigUsrHis.get(i).getProjectInvolved();
		}

		// 创建HistogramInfo对象
		HistogramInfo histogramInfo = new HistogramInfo(MaxJoin, MinJoin, GroupNum, allJoinInfo);
		return histogramInfo;
	}

}
