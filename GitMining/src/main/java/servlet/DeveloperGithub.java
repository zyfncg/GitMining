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

/**
 * 处理跳转至开发者github主页的请求
 */
@WebServlet("/DeveloperGithub")
public class DeveloperGithub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final RecommendService recommend =
			new RecommendLogic();
	
	private static final UserBLService user =
			new UserController();
       
    public DeveloperGithub() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String developer = request.getParameter("chooseDeveloper");
		try {
			UserInfoDetail detail = user.getUserByName(developer);
			if(detail == null) {
				throw new Exception("找不到名字为" + developer + "的用户信息");
			}
			response.sendRedirect("http://www.github.com/" + developer);
			String user_id = CookieUtil.getUserIDfromCookie(request, response);
			recommend.updateDeveloperInfo(user_id, developer);
			recommend.updateCompanyInfo(user_id, detail.getCompany());
		} catch (Exception e) {
			request.getRequestDispatcher("/Developer").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
