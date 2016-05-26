package dataTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Info.UserInfoDetail;
import data.dataImpl.FileUtil;

public class LocationTest {

	@Test
	public void test() {
		FileUtil fileUtil=new FileUtil();
		List<UserInfoDetail> userList = null;
		List<String> addressList=new ArrayList<String>();
		String address;
		
		try {
			userList=fileUtil.getUserDetailList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(UserInfoDetail userDetail:userList){
			
			address=userDetail.getAddress();
			address=address.toLowerCase();
//			addressList.add(address);
//			for(String addr:addressList){
//				System.out.println(addr);
//				if(addr.indexOf(address)==-1&&address.indexOf(addr)==-1){
//					addressList.add(address);
//				}
//			}
			if(!addressList.contains(address)){
				addressList.add(address);
			}
//			if(!address.equals("unknown")){
//				addressList.add(address);
//			}
			
		}
		System.out.println(addressList.size());
		
		for(int i=0;i<addressList.size();i++){
			System.out.println(addressList.get(i));
		}
		
//		List<String> cityList=new ArrayList<String>();
//		for(int i=0;i<addressList.size();i++){
//			String nation=addressList.get(i);
//			if(nation.contains(" us")||nation.contains("san francisco")){
//				cityList.add(nation);
//			}
//			//System.out.println(addressList.get(i));
//		}
//		Collections.sort(cityList);  
//		for(int i=0;i<cityList.size();i++){
//			System.out.println(cityList.get(i));
//		}
		
	}

}
