package data.statistisDataImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Info.Date;

public class ProjectFile {
	/**
	 * 从文件中获取所有项目时间信息
	 * @return 项目时间信息
	 */
	@SuppressWarnings("unchecked")
	public List<Date> getProjectDate() throws Exception {
		List<Date> pdlist = null;	
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectDate.ser"));
			
		pdlist=(List<Date>) is.readObject();
		is.close();
		 	
		return pdlist;
	}
	
	
	/**
	 * 所有项目时间信息放入文件中
	 * @param 项目时间信息
	 * @return 是否存入成功
	 */
	public boolean saveProjectDate(List<Date> pdlist) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectDate.ser"));
			oos.writeObject(pdlist);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
