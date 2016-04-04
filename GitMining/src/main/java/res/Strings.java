package res;

/**
 *字符串集合 
 */
public class Strings {
	
	/**
	 *有关项目的字符串 
	 */
	public static class Project {
		/**
		 *star标签 
		 */
		public static final String STAR_LABEL = "star";
		
		/**
		 *language标签 
		 */
		public static final String LANGUAGE_LABEL = "language";
		
		/**
		 *repository标签 
		 */
		public static final String REPOSITORY_LABEL = "repository";
		
		/**
		 *cumulative 
		 */
		public static final String CUMULATIVE_LABEL = "cumulative";
		
		/**
		 *fork标签 
		 */
		public static final String FORK_LABEL = "fork";
		
		/**
		 *contributor标签 
		 */
		public static final String CONTRIBUTOR_LABEL = "contributor";
		
		/**
		 *collaborator标签 
		 */
		public static final String COLLABORATOR_LABEL = "collaborator";
		
		/**
		 *subscriber标签 
		 */
		public static final String SUBSCRIBER_LABEL = "subscriber";
		
		/**
		 *项目搜索框提示信息 
		 */
		public static final String PROJECT_SEARCH_TIP = "Enter project name";
		
		/**
		 *star分布直方图的标题 
		 */
		public static final String STAR_HISTOGRAM_TILE = "Distribution of star";
		
		/**
		 *start分布折线图的标题 
		 */
		public static final String STAR_LINE_TILE =
				"Tendency of total star quantities in recent years";
		
		/**
		 *fork分布直方图的标题 
		 */
		public static final String FORK_HISTOGRAM_TILE = "Distribution of fork";
		
		/**
		 *fork分布折线图的标题 
		 */
		public static final String FORK_LINE_TILE =
				"Tendency of total fork quantities in recent years";

		/**
		 *项目创建时间柱状图的标题 
		 */
		public static final String PROJECT_TIME_BAR_TITLE =
				"Quantities of created repository in recent years";
		
		/**
		 *项目语言pareto图的标题 
		 */
		public static final String LANGUAGE_PARETO_TITLE =
				"Numbers of Repository in Different Languages";
	}

	/**
	 *有关用户的字符串 
	 */
	public static class User {
		
		/**
		 *User Enrollment标签
		 */
		public static final String USER_ENROLLMENT_LABEL = "User Enrollment";
		
		/**
		 *involve projects标签 
		 */
		public static final String INVOLVE_PROJECTS = "ProjectInvolve";
		
		/**
		 *create projects标签 
		 */
		public static final String CREATE_PROJECTS = "ProjectCreate";
		
		/**
		 *description标签 
		 */
		public static final String DESCRIPTION_LABEL = "description ";
		
		/**
		 *email标签 
		 */
		public static final String EMAIL_LABEL = "email ";
		
		/**
		 *company标签 
		 */
		public static final String COMPANY_LABEL = "company ";
		
		/**
		 *address标签 
		 */
		public static final String ADDRESS_LABEL = "address ";
		
		/**
		 *用户搜索框提示信息 
		 */
		public static final String USER_SEARCH_TIP = "Enter user name";
		
		/**
		 *用户注册统计面板标题
		 */
		public static final String REGISTRY_TITLE =
				"Total Enrollment of users in recent years";
		
		/**
		 *用户类型统计面板标题
		 */
		public static final String USER_TYPE_TITLE = "User Type";
		
		/**
		 *用户参与项目统计面板标题 
		 */
		public static final String INVOLVE_TITLE =
				"Total quantities of repositories involved by users in recent years";
		
		/**
		 *用户创建项目统计面板 标题
		 */
		public static final String CREATE_TITLE =
				"Total quantities of repositories created by users in recent years";
		
		/**
		 *参与公司统计面板标题 
		 */
		public static final String COMPANY_TITLE = "Contribution of companies";
		
	}
	
	/**
	 *按钮提示信息字符串 
	 */
	public static class ButtonTip {
		/**
		 *主页按钮提示 
		 */
		public static final String HOME_BUTTON_TIP = "Home";
		
		/**
		 *用户主页按钮提示 
		 */
		public static final String PROJECT_BUTTON_TIP = "Project Page";
		
		/**
		 *用户主页按钮提示 
		 */
		public static final String USER_BUTTON_TIP = "User Page";
		
		/**
		 *刷新按钮提示 
		 */
		public static final String REFRESH_BUTTON_TIP = "Refresh";
		
		/**
		 *最小化按钮提示 
		 */
		public static final String MIN_BUTTON_TIP = "Minimum";
		
		/**
		 *退出按钮提示 
		 */
		public static final String EXIT_BUTTON_TIP = "Exit";
	}
	
	/**
	 *发生错误时，提示框的标题字符串
	 */
	public static final String ERROR_DIALOG_TITLE = "Error";
	
	/**
	 *网络异常提示信息 
	 */
	public static final String URL_EXCEPTION_TIP="Something wrong with the network\n"
			+ "Check the network connection and\n" + "press the refresh button above";
	
	/**
	 *默认项目description信息 
	 */
	public static final String DEFAULT_DESCRIPTION="unkown";
	
	/**
	 *默认用户bio信息 
	 */
	public static final String DEFAULT_BIO="unknown";
	
	/**
	 *默认company信息 
	 */
	public static final String DEFAULT_COMPANY="unknown";
	
	/**
	 *默认email信息 
	 */
	public static final String DEFAULT_EMAIL="unknown";
	
	/**
	 *默认language信息 
	 */
	public static final String DEFAULT_LAUNGUAGE="unknown";
	
	/**
	 *默认location信息 
	 */
	public static final String DEFAULT_LOCATION="unknown";
	
}
