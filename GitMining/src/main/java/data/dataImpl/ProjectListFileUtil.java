package data.dataImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Info.ProjectInfo;
/**
 *@author ZhangYF 
 * 实现项目信息在文件的存取功能
 * 
 */
public class ProjectListFileUtil {

	@SuppressWarnings("unchecked")
	public List<ProjectInfo> getProjectListFromFile() throws Exception{
		
		List<ProjectInfo> pList = null;
		
		
		ObjectInputStream is=new ObjectInputStream(new FileInputStream("projectData.ser"));
			
		pList=(List<ProjectInfo>) is.readObject();
		is.close();
		    
		
		return pList;
	}
	
	public boolean setProjectToFile(List<ProjectInfo> pList){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("projectData.ser"));
			oos.writeObject(pList);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
