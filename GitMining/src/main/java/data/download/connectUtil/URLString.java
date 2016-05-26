package data.download.connectUtil;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class URLString {

	/**
	 *项目信息URL 
	 */
	private static String repositoryApiString="http://www.gitmining.net/api/repository/";
	
	/**
	 *用户信息URL 
	 */
	private static String userApiString="http://www.gitmining.net/api/user/";
	
	private static Element data=getConfig();

	
	/**
	 *获取项目相关的URL字符串 
	 */
	public static String getRepositoryApiString() {
		repositoryApiString=data.elementText("ProjectURL").trim();
		return repositoryApiString;
	}
	
	/**
	 *获取用户相关的URL字符串 
	 */
	public static String getUserApiString() {
		userApiString=data.elementText("UserURL").trim();
		return userApiString;
	}
	
	
	/**
	 *获取配置文件数据 
	 */
	private static Element getConfig(){
	
		try {  
            File f = new File("config.xml");  
            if (!f.exists()) {  
                System.out.println("  Error : Config file doesn't exist!");  
                System.exit(1);  
            }  
            SAXReader reader = new SAXReader();  
            Document doc;  
            doc = reader.read(f);  
            Element root = doc.getRootElement();  
              
            Iterator<?> itr = root.elementIterator("VALUE");  
            data = (Element) itr.next();  
  
        } catch (Exception ex) {  
            System.out.println("Error : " + ex.toString());  
        }  
		
		return data;
	}
}
