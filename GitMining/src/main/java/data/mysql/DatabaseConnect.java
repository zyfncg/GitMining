package data.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;



import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class DatabaseConnect {
	
	private DatabaseConnect() {}

	private static  String URL="jdbc:mysql://localhost/logistics_system";
	private static  String USER="root";

	private static  String PASSWORD=null;


	private static Connection conn=null;
	
	private static void connection() {
		  try {			  
			  Class.forName("com.mysql.jdbc.Driver");   

		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
		  try {
			  getConfig();
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	public static Connection getConnection(){
		if(conn == null){
			connection();
		}
		return conn;
	}
	public static void disconnect(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getConfig(){
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
            Element data;  
            Iterator<?> itr = root.elementIterator("VALUE");  
            data = (Element) itr.next();  
  
            URL = data.elementText("url").trim();  
            USER = data.elementText("user").trim();  
            PASSWORD = data.elementText("pass").trim();  
  
        } catch (Exception ex) {  
            System.out.println("Error : " + ex.toString());  
        }  
	}

}
