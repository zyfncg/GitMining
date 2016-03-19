package res;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 *图片资源 
 */
public class Img {
	
	private static final String BUTTON_ROOT_PATH =
			"graphics/button";
	
	private static final String TIP_ROOT_PATH =
			"graphics/tip";

	/**
	 *主页背景图片 
	 */
	public static final Image START =
			new ImageIcon("graphics/start.jpg").getImage();
	
	/**
	 *主页按钮图标 
	 */
	public static final ImageIcon HOME_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/home.png");
	
	/**
	 *项目主页按钮图标 
	 */
	public static final ImageIcon PROJECT_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/repository.png");
	/**
	 *用户按钮图标 
	 */
	public static final ImageIcon USER_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/user.png");
	
	/**
	 *刷新按钮图标 
	 */
	public static final ImageIcon REFRESH_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/refresh.png");
	
	/**
	 *退出按钮图标 
	 */
	public static final ImageIcon EXIT_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/exit.png");
	
	/**
	 *最小化按钮图标 
	 */
	public static final ImageIcon MIN_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/min.png");
	
	/**
	 *鼠标移开回退按钮时的图片
	 */
	public static final Image BACK_AWAY =
			new ImageIcon(BUTTON_ROOT_PATH + "/back_away.png").getImage();
	
	/**
	 *鼠标移到回退按钮时的图片
	 */
	public static final Image BACK_ENTER =
			new ImageIcon(BUTTON_ROOT_PATH + "/back_enter.png").getImage();
	
	/**
	 *鼠标移开前进按钮时的图片
	 */
	public static final Image NEXT_AWAY =
			new ImageIcon(BUTTON_ROOT_PATH + "/next_away.png").getImage();
	
	/**
	 *鼠标移到前进按钮时的图片
	 */
	public static final Image NEXT_ENTER =
			new ImageIcon(BUTTON_ROOT_PATH + "/next_enter.png").getImage();
	
	/**
	 *回退按钮图标 
	 */
	public static final ImageIcon BACK_BUTTON =
			new ImageIcon(BUTTON_ROOT_PATH + "/back.png");
	
	/**
	 *general排序按钮未被点击时的图标 
	 */
	public static final ImageIcon GENERAL_NOT_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/general.png");
	
	/**
	 *general排序按钮被点击时的图标 
	 */
	public static final ImageIcon GENERAL_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/general_pressed.png");
	
	/**
	 *star排序按钮未被点击时的图标 
	 */
	public static final ImageIcon STAR_NOT_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/star.png");
	
	/**
	 *star排序按钮被点击时的图标 
	 */
	public static final ImageIcon STAR_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/star_pressed.png");
	
	/**
	 *fork排序按钮未被点击时的图标 
	 */
	public static final ImageIcon FORK_NOT_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/fork.png");
	
	/**
	 *fork排序按钮被点击时的图标 
	 */
	public static final ImageIcon FORK_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/fork_pressed.png");
	
	/**
	 *contributor排序按钮未被点击时的图标 
	 */
	public static final ImageIcon CONTRIBUTOR_NOT_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/contributor.png");
	
	/**
	 *contributor排序按钮被点击时的图标 
	 */
	public static final ImageIcon CONTRIBUTOR_SELECT =
			new ImageIcon(BUTTON_ROOT_PATH + "/contributor_pressed.png");
	
	/**
	 *复制按钮的图标 
	 */
	public static final ImageIcon COPY =
			new ImageIcon(BUTTON_ROOT_PATH + "/copy.png");
	
	public static final ImageIcon SEARCH =
			new ImageIcon(BUTTON_ROOT_PATH + "/search.png");
	
	/**
	 *显示没有可显示信息的图片 
	 */
	public static final Image NULL_MESSAGE =
			new ImageIcon(TIP_ROOT_PATH + "/null.png").getImage();
	
	/**
	 *显示贡献者字符串的图片 
	 */
	public static final Image CONTRIBUTOR_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/contributor.png").getImage();
	
	/**
	 *显示协作者字符串的图片 
	 */
	public static final Image COLLABOROTOR_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/collaborator.png").getImage();
	
	/**
	 *显示创建项目字符串的图片 
	 */
	public static final Image PROJECT_CREATED_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/project_created.png").getImage();
	
	/**
	 *显示项目列表字符串的图片 
	 */
	public static final Image PROJECT_LIST_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/project_list.png").getImage();
	
	/**
	 *显示用户列表字符串的图片 
	 */
	public static final Image USER_LIST_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/user_list.png").getImage();
	
	/**
	 *提示没有信息的图片(小) 
	 */
	public static final Image SAMLL_NULL_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/small_null.png").getImage();
	
	/**
	 *提示没有信息的图片(大) 
	 */
	public static final Image LARGE_NULL_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/large_null.png").getImage();
	
	/**
	 *图标 
	 */
	public static final Image USER_ICON =
			new ImageIcon("graphics/icon.png").getImage();
	
	/**
	 *已经复制项目URL提示图片
	 */
	public static final Image COPY_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/copied.png").getImage();
	
	/**
	 *提示复制项目URL到剪贴板提示图片
	 */
	public static final Image COPY_CLIPBOARD_TIP =
			new ImageIcon(TIP_ROOT_PATH + "/copy_to.png").getImage();
}
