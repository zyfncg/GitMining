package data.dataImpl.recommendDataImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Info.CookieInfo;
import data.mysql.Database;

public class UserCookieDB {
	
	/**
	 * 更新用户对某公司的引用次数
	 * @param user_id
	 * @param company
	 */
	public boolean updateCompanyInfo(String user_id, String company){
		String table="developer_ref";
		int ref_num=1;
		Date time=new Date(new java.util.Date().getTime());
		CookieInfo cookie=new CookieInfo(user_id, company, ref_num, time);
		
		if(saveCookie(table, cookie)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 更新用户对某语言的引用次数
	 * @param user_id
	 * @param language
	 */
	public boolean SaveLanguage(String user_id,String language){
		String table="language_ref";
		int ref_num=1;
		Date time=new Date(new java.util.Date().getTime());
		CookieInfo cookie=new CookieInfo(user_id, language, ref_num, time);
		
		if(saveCookie(table, cookie)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 更新用户对某项目的引用次数
	 * @param user_id
	 * @param ProjectName
	 */
	public boolean updateProjectInfo(String user_id, String ProjectName){
		String table="project_ref";
		int ref_num=1;
		Date time=new Date(new java.util.Date().getTime());
		CookieInfo cookie=new CookieInfo(user_id, ProjectName, ref_num, time);
		
		if(saveCookie(table, cookie)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 更新用户对某开发者的引用次数
	 * @param user_id
	 * @param UserName
	 * @return
	 */
	public boolean updateDeveloperInfo(String user_id, String UserName){
		String table="developer_ref";
		int ref_num=1;
		Date time=new Date(new java.util.Date().getTime());
		CookieInfo cookie=new CookieInfo(user_id, UserName, ref_num, time);
		
		if(saveCookie(table, cookie)){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * 取得引用次数排序第num的项目
	 * @param user_id
	 * @param num
	 * @return 项目名，如果不存在返回null
	 */
	public String getOneProject(String user_id,int num){
		String table="project_ref";
		String colName="project";
		List<CookieInfo> cookieList=getCookieInfo(table, colName, user_id);
		if(cookieList==null){
			return null;
		}
		CookieInfo cookie;
		try {
			cookie = cookieList.get(num-1);
		} catch (Exception e) {
			return null;
		}
		
		return cookie.getName();
	}

	
	/**
	 * 取得引用次数排序第num的用户
	 * @param user_id
	 * @param num
	 * @return 用户名 ，如果不存在返回null
	 */
	public String getOneUser(String user_id,int num){
		String table="developer_ref";
		String colName="developer";
		List<CookieInfo> cookieList=getCookieInfo(table, colName, user_id);
		if(cookieList==null){
			return null;
		}
		CookieInfo cookie;
		try {
			cookie = cookieList.get(num-1);
		} catch (Exception e) {
			return null;
		}
		
		return cookie.getName();
	}
	
	/**
	 * 取得引用次数做多的公司
	 * @param user_id
	 * @return
	 */
	public String getCompany(String user_id){
		String table="company_ref";
		String colName="company ";
		List<CookieInfo> cookieList=getCookieInfo(table, colName, user_id);
		if(cookieList==null){
			return null;
		}
		CookieInfo cookie=cookieList.get(0);
		
		return cookie.getName();
	}
	
	
	/**
	 * 取得引用次数做多的语言
	 * @param user_id
	 * @return
	 */
	public String getLanguage(String user_id){
		String table="language_ref";
		String colName="language";
		List<CookieInfo> cookieList=getCookieInfo(table, colName, user_id);
		if(cookieList==null){
			return null;
		}
		CookieInfo cookie=cookieList.get(0);
		
		return cookie.getName();
	}
	
	/**
	 * 获得table表中user_id的信息
	 * @param table
	 * @param user_id
	 * @return
	 */
	private List<CookieInfo> getCookieInfo(String table,String colName,String user_id){
		List<CookieInfo> cookieList=new ArrayList<CookieInfo>();
	
		ResultSet rs;
		String name;
		int ref_num;
		Date time;
		CookieInfo cookie;
		
		String sql="select * from "+table+" where user_id='"+user_id+"'"+" order by ref_num DESC";
		
		try {
			rs=Database.query(sql);
			while(rs.next()){
				name=rs.getString(colName);
				ref_num=rs.getInt("ref_num");
				time=rs.getDate("time");
				cookie=new CookieInfo(user_id, name, ref_num, time);
				cookieList.add(cookie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return cookieList;
	}
	
	/**
	 * 将cookie信息保存到对应表中
	 * @param table
	 * @param cookie
	 * @return
	 */
	private boolean saveCookie(String table,CookieInfo cookie){
		
		String user_id=cookie.getUser_id();
		String name=cookie.getName();
		int ref_num=cookie.getRef_num();
		Date time=cookie.getTime();
		
		String sql="INSERT INTO "+table+" VALUES('"+user_id+"','"+name+"',"+ref_num+","+time+")"+
				"ON DUPLICATE KEY UPDATE ref_num=ref_num+1,time="+time;
		try {
			if(!Database.operate(sql)){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	

}
