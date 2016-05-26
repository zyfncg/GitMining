package res;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *操纵cookie的工具类 
 */
public class CookieUtil {
	
	/**
	 *用户id的cookie关键字 
	 */
	private static final String USER_ID = "userid";
	
	/**
	 *从cookie中获得用户id
	 *如果cookie为空，重新添加cookie，返回null
	 *如果cookie中用户id这一项为空，重新添加用户id这一项cookie，返回null
	 *如果用户id存在，返回用户id
	 */
	public static String getUserIDfromCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			setUserIDCookie(response);
			return null;
		}else {
			String user_id = getUserIDfromCookie(cookies);
			if(user_id == null) {
				setUserIDCookie(response);
			}
			return user_id;
		}
	}

	/**
	 *为客户端用户在cookie设置一个id 
	 */
	private static void setUserIDCookie(HttpServletResponse response) {
		Random random = new Random();
		Cookie cookie = new Cookie(USER_ID, getCurrentTime()
				+ random.nextInt(10000));
		cookie.setMaxAge(14 * 24 * 60 * 3600); //两周
		response.addCookie(cookie);
	}
	
	/**
	 *从用户cookies中获得用户id 
	 */
	private static String getUserIDfromCookie(Cookie[] cookies) {
		String id = null;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(USER_ID)) {
				id = cookie.getValue();
				break;
			}
		}
		return id;
	}
	
	/**
	 *获取系统当前时间，格式为yyMMddHHmmss 
	 */
	private static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(date);
		return time;
	}
}
