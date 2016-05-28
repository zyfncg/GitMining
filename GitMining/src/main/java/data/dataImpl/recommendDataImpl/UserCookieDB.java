package data.dataImpl.recommendDataImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Info.CookieInfo;
import data.mysql.Database;

public class UserCookieDB {
	public void getLanguage_ref(){
		
	}
	
	
	private List<CookieInfo> getCookieInfo(String table,String user_id){
		List<CookieInfo> cookieList=new ArrayList<CookieInfo>();
	
		ResultSet rs;
		String name;
		int ref_num;
		Date time;
		
		String sql="select * from "+table;
		if(user_id==null){
			sql=sql+" order by ref_num";
		}else{
			sql=sql+" where user_id='"+user_id+"'";
		}
		
		try {
			rs=Database.query(sql);
			while(rs.next()){
				name=rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private boolean saveTable_ref(String table,CookieInfo cookie){
		
		return true;
	}
	
	

}
