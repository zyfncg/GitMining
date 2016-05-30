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
import recommend.RecommendLogic;
import recommend.RecommendService;
import res.CookieUtil;
import res.PaginationUtil;

/**
 * 用户显示开发者的详细信息
 */
@WebServlet("/DeveloperDetail")
public class DeveloperDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final UserBLService developer = new UserController();
	
	private static final RecommendService recommend = new RecommendLogic();
       
    public DeveloperDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("chooseDeveloper");
		if(name == null) {
			request.getRequestDispatcher("/Developer").forward(request, response);
			return ;
		}
		
		UserInfoDetail info = null;
		try {
			info = developer.getUserByName(name);
			if(info == null) {
				throw new Exception("找不到名字为" + name + "的用户信息");
			}
			String user_id = CookieUtil.getUserIDfromCookie(request, response);
			recommend.updateDeveloperInfo(user_id, name);
			recommend.updateCompanyInfo(user_id, info.getCompany());
		} catch (Exception e) {
			request.getRequestDispatcher("/Developer").forward(request, response);
			e.printStackTrace();
			return ;
		}
		
		//设置有关页面跳转的一些参数
		PaginationUtil.setParameters(request, "createNum", "projects", info.getProjectCreatInfo());
		
		request.setAttribute("developer_detail", info);
		request.getRequestDispatcher("/visualize/developer_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
