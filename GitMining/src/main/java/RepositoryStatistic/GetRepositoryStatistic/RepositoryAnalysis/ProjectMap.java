package RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis;

import java.util.ArrayList;
import java.util.List;

import Info.AddressInfo;
import Info.ProjectDetail;
import Info.UserInfo;
import Info.UserInfoDetail;
import RepositoryStatistic.GetRepositoryStatistic.RepositoryAnalysis.DetailAnalysis.Else;
import UserStatistic.GetUserStatistic.UserAnalysis.OtherAnalysis;
import data.dataServer.statisticServer.AddressServer;
import data.map.AddressImpl;

public class ProjectMap {
	
	private AddressServer GetAddress = new AddressImpl();
	private OtherAnalysis other = new OtherAnalysis();
	private Else theelse = new Else();
	
	public List<AddressInfo> GetAddressDis(ProjectDetail aProjectDetail) {
		List<AddressInfo> Result = new ArrayList<AddressInfo>();
		Result.clear();
		//处理当前ProjectDetail的Contributor数据
		List<UserInfo> allContri = aProjectDetail.getContributorsInfo();
//		AddressInfo fstAddress = null;
		for(UserInfo temp:allContri){
			UserInfoDetail UsrDetail = other.BecomeDetail(temp);
			AddressInfo fstAddress = GetAddress.getAddressByName(UsrDetail.getAddress());
			if (fstAddress!=null) {
				fstAddress.setWorkerNumber(1);
				theelse.IfContain(Result, fstAddress);				
			}
		}
		
		//处理当前ProjectDetail的Contributor数据
		List<UserInfo> allColl = aProjectDetail.getCollaboratorsInfo();
		for(UserInfo tempColl:allColl){
			UserInfoDetail UsrDetail = other.BecomeDetail(tempColl);
			AddressInfo sndAddress = GetAddress.getAddressByName(UsrDetail.getAddress());
			if (sndAddress!=null) {
				sndAddress.setWorkerNumber(1);
				theelse.IfContain(Result, sndAddress);				
			}
		}
		
		return Result;
	}
}
