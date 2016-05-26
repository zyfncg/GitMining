package data.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private Database() {}
	
	private static Connection conn=null;
	private static Statement stat;
	private static ResultSet rs;
	
	static{
		try {
			
			conn=DatabaseConnect.getConnection();
			stat=conn.createStatement();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询数据
	public static ResultSet query(String sql) throws SQLException{
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		return rs;
	}
	
	//增删改操作
	public static boolean operate(String sql) throws SQLException{
	    stat.executeUpdate(sql);
		return true;
	}
	
}
