package data.connectUtil;

public class URLString {

	/**
	 *项目信息URL 
	 */
	private static String repositoryApiString="http://www.gitmining.net/api/repository/";
	
	/**
	 *用户信息URL 
	 */
	private static String userApiString="http://www.gitmining.net/api/user/";

	public static String getRepositoryApiString() {
		return repositoryApiString;
	}

	public static String getUserApiString() {
		return userApiString;
	}
	
}
