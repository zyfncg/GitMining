package res;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 *处理多页信息跳转的一些设置 
 */
public class PaginationUtil {

	/**
	 *设置关于页面跳转的参数 
	 *@param requst http请求对象
	 *@param numKey 用于设置request属性中关于信息项总数的key名称
	 *@param listKey 用户设置request属性中关于信息列表的key名称
	 */
	public static void setParameters(HttpServletRequest request,
			String numKey, String listKey, List<?> info) {
		int currentPage = 0;
		String para = request.getParameter("currentPage");
		if(para != null) {
			currentPage = Integer.parseInt(para);
			request.setAttribute("currentPage", currentPage);
		}else {
			request.setAttribute("currentPage", 0);
		}
		
		int size = info.size();
		int end = (currentPage + 1) * 6 >= size ? size
				: (currentPage + 1) * 6;
		request.setAttribute(listKey, info.subList(currentPage * 6, end));
		request.setAttribute(numKey, size);
	}
}
