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
	/**
	 * description:查询数据库信息
	 * @param table:数据库中的表的名称
	 * @param idname 表中属性的名称
	 * @param id 要查的编号
	 * @return 结果的集合
	 */
	public static ResultSet find(String table,String idname,String id){
		String sql="SELECT * FROM "+table+" WHERE "+idname+"="+"'"+id+"'";
		try {
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * description:添加数据库信息
	 * @param table:数据库中的表的名称
	 * @param val PO转化为对应数据的字符串
	 * @return 添加是否成功
	 */
	public static boolean add(String table,String val){
		@SuppressWarnings("unused")
		int x;
		String sql="INSERT INTO "+table+" VALUES("+val+")";
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * description:删除数据库信息
	 * @param table:数据库中的表的名称
	 * @param idname 表中属性的名称
	 * @param id 要查的编号
	 * @return 是否删除成功
	 */
	public static boolean delete(String table,String idname,String id){
		@SuppressWarnings("unused")
		int x;
		String sql="DELETE FROM "+table+" WHERE "+idname+"="+"'"+id+"'";
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * description:修改数据库信息
	 * @param table:数据库中的表的名称
	 * @param val PO转化为对应数据的字符串
	 * @return 修改是否成功
	 */
	public static boolean modify(String table,String val,String idname,String id){
		@SuppressWarnings("unused")
		int x;
		String sql="UPDATE "+table+" SET "+val+" WHERE "+idname+"="+"'"+id+"'";
		try {
			x=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//查询数据
	public static ResultSet query(String sql) throws SQLException{
		rs=stat.executeQuery(sql);
		return rs;
	}
	
	//增删改操作
	public static boolean operate(String sql) throws SQLException{
	    stat.executeUpdate(sql);
		return true;
	}
	
}
