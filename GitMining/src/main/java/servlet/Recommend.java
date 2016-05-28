package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.UserInfoDetail;
import recommend.RecommendService;
import res.CookieUtil;

/**
 * 处理来自推荐模块的请求
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final RecommendService service =
			new recommend.Recommend();	
       
    public Recommend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = CookieUtil.getUserIDfromCookie(request, response);
		//TODO 根据用户id获得向用户推荐的项目和开发者信息
		
		List<Info.ProjectDetail> top6 = service.getTop();
		List<UserInfoDetail> developers = service.getDevelopers("");
		List<Info.ProjectDetail> projects = service.getProjects("");
		request.setAttribute("guessPros", projects);
		request.setAttribute("guessDevs", developers);
		request.setAttribute("top6", top6);
		request.getRequestDispatcher("/visualize/recommend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
