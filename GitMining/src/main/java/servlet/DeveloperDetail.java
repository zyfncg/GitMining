package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.UserInfoDetail;
import businessLogic.businessLogicController.UserController.UserController;
import businessLogicService.UserBLService.UserBLService;
import res.CookieUtil;
import res.PaginationUtil;

/**
 * 用户显示开发者的详细信息
 */
@WebServlet("/DeveloperDetail")
public class DeveloperDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final UserBLService service = new UserController();
       
    public DeveloperDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("chooseDeveloper");
		if(name != null) {
			//TODO 更新数据库中对该用户的引用，获得该用户的数据
			String user_id = CookieUtil.getUserIDfromCookie(request, response);
		}
		
		UserInfoDetail info = null;
		try {
			info = service.getUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "createNum", "projects", info.getProjectCreatInfo());
		
		request.getRequestDispatcher("/visualize/developer_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
