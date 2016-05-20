package data.statistisDataImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ProjectFile {
	/**
	 * 从文件中获取所有项目commit信息
	 * @return 项目时间信息
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getProjectCommit() throws Exception {
		List<Integer> pcommit = null;	
		String fileName="projectCommitData.ser";
		ObjectInputStream is=new ObjectInputStream(new FileInputStream(fileName));
			
		pcommit=(List<Integer>) is.readObject();
		is.close();
		 	
		return pcommit;
	}
	
	
	/**
	 * 所有项目commit信息放入文件中
	 * @param 项目时间信息
	 * @return 是否存入成功
	 */
	public boolean saveProjectCommit(List<Integer> pcommit) {
		String fileName="projectCommitData.ser";
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(pcommit);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
