package data.statistisDataImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Info.RepStatisticInfo.SaveRepositoryStatisticInfo;
import Info.UsrStatisticInfo.SaveUserStatisticInfo;

public class StatisticFile {
	/**
	 * 从文件中获取所有项目统计信息
	 * @return 项目统计信息
	 */
	public SaveRepositoryStatisticInfo getProjectStatisticData() throws Exception {
		SaveRepositoryStatisticInfo pStatisticData = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectStatisticData.ser"));
			
		pStatisticData=(SaveRepositoryStatisticInfo) is.readObject();
		is.close();
		 	
		return pStatisticData;
	}
	
	
	/**
	 * 所有项目统计信息放入文件中
	 * @param 项目统计信息
	 * @return 是否存入成功
	 */
	public boolean saveProjectStatisticData(SaveRepositoryStatisticInfo saveRepository) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectStatisticData.ser"));
			oos.writeObject(saveRepository);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
	/**
	 * 从文件中获取所有用户统计信息
	 * @return 用户统计信息
	 */
	public SaveUserStatisticInfo getUserStatisticData() throws Exception {
		SaveUserStatisticInfo userStatisticData = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("userStatisticData.ser"));
			
		userStatisticData=(SaveUserStatisticInfo) is.readObject();
		is.close();
		 	
		return userStatisticData;
	}
	
	
	/**
	 * 所有用户统计信息放入文件中
	 * @param 用户统计信息
	 * @return 是否存入成功
	 */
	public boolean saveUserStatisticData(SaveUserStatisticInfo saveUser) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("userStatisticData.ser"));
			oos.writeObject(saveUser);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
